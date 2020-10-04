package de.hybris.sdh.core.job;

import de.hybris.platform.cronjob.enums.CronJobResult;
import de.hybris.platform.cronjob.enums.CronJobStatus;
import de.hybris.platform.cronjob.model.CronJobModel;
import de.hybris.platform.servicelayer.config.ConfigurationService;
import de.hybris.platform.servicelayer.cronjob.AbstractJobPerformable;
import de.hybris.platform.servicelayer.cronjob.PerformResult;
import de.hybris.platform.servicelayer.model.ModelService;
import de.hybris.platform.servicelayer.search.SearchResult;
import de.hybris.sdh.core.dao.PseTransactionsLogDao;
import de.hybris.sdh.core.model.PseTransactionsLogModel;
import de.hybris.sdh.core.soap.pse.PseServices;
import de.hybris.sdh.core.soap.pse.beans.ConstantConnectionData;
import de.hybris.sdh.core.soap.pse.eanucc.FinalizeTransactionPaymentInformationType;
import de.hybris.sdh.core.soap.pse.eanucc.FinalizeTransactionPaymentResponseInformationType;
import de.hybris.sdh.core.soap.pse.eanucc.FinalizeTransactionPaymentResponseReturnCodeList;
import de.hybris.sdh.core.soap.pse.impl.MessageHeader;
import org.apache.log4j.Logger;

import javax.annotation.Resource;
import java.util.Objects;

public class PseFinalizeTransactionPerformable extends AbstractJobPerformable<CronJobModel> {

    @Resource(name = "configurationService")
    private ConfigurationService configurationService;

    @Resource(name = "pseTransactionsLogDao")
    private PseTransactionsLogDao pseTransactionsLogDao;

    @Resource(name = "defaultPseServices")
    private PseServices pseServices;

    @Resource(name = "modelService")
    private ModelService modelService;

    private static final Logger LOG = Logger.getLogger(PseBankListCatalogPerformable.class);

    @Override
    public PerformResult perform(CronJobModel cronJobModel) {
        final String TRANSACTION_STATE = "OK";
        SearchResult<PseTransactionsLogModel> result = pseTransactionsLogDao.getAllOutstandingTransactions(TRANSACTION_STATE);
        FinalizeTransactionPaymentInformationType finalizeType;

        LOG.info("-------------- Begin : Job FinalizePseTransaction When Status Equals To [" + TRANSACTION_STATE + "] --------------");
        for(PseTransactionsLogModel transactionsLogModel : result.getResult()){
            if(!"CREDIBANCO_TRANSACTION".equals(transactionsLogModel.getEntityCode())){
                finalizeType = new FinalizeTransactionPaymentInformationType();
                finalizeType.setEntityCode(transactionsLogModel.getEntityCode());
                finalizeType.setTrazabilityCode(transactionsLogModel.getTrazabilityCode());

                FinalizeTransactionPaymentResponseInformationType response = pseServices.finalizeTransactionPayment(
                        getConstantConnectionData(), getMessageHeader(), finalizeType);

                FinalizeTransactionPaymentResponseReturnCodeList returnCodeList = response.getReturnCode();

                if(Objects.nonNull(returnCodeList)){
                    LOG.info("[ TrazabilityCode: " + transactionsLogModel.getTrazabilityCode() + ", " +
                            "FinalizeTranzactionReturnedCode: " + response.getReturnCode().getValue() + " ]" );
                    transactionsLogModel.setTransactionState(response.getReturnCode().getValue());
                    modelService.save(transactionsLogModel);
                }
            }                      ;
        }
        LOG.info("-------------- End : Job FinalizePseTransaction When Status  Equals To [" + TRANSACTION_STATE + "] --------------");
        return new PerformResult(CronJobResult.SUCCESS, CronJobStatus.FINISHED);
    }

    private MessageHeader getMessageHeader()
    {
        final MessageHeader messageHeader = new MessageHeader();
        messageHeader.setTo(configurationService.getConfiguration().getString("sdh.pse.messageHeader.to"));
        messageHeader.setFrom(configurationService.getConfiguration().getString("sdh.pse.messageHeader.from"));
        messageHeader.setRepresentingParty(configurationService.getConfiguration().getString("sdh.pse.messageHeader.representingParty"));
        return messageHeader;
    }

    private ConstantConnectionData getConstantConnectionData()
    {
        final ConstantConnectionData constantConnectionData = new ConstantConnectionData();
        constantConnectionData.setPseurl(configurationService.getConfiguration().getString("sdh.pse.pseURL"));
        constantConnectionData.setPpeCode(configurationService.getConfiguration().getString("sdh.pse.ppeCode"));
        return constantConnectionData;
    }

}
