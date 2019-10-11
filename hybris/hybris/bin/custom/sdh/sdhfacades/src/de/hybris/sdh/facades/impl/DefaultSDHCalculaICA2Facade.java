package de.hybris.sdh.facades.impl;

import de.hybris.sdh.core.pojos.requests.CalcICA2Request;
import de.hybris.sdh.core.pojos.responses.CalcICA2Response;
import de.hybris.sdh.core.services.SDHCalICA2Service;
import de.hybris.sdh.facades.SDHCalculaICA2Facade;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.codehaus.jackson.map.ObjectMapper;


public class DefaultSDHCalculaICA2Facade implements SDHCalculaICA2Facade
{

	private static final Logger LOG = Logger.getLogger(DefaultSDHCalculaICA2Facade.class);

	@Resource(name = "sdhCalculaICA2Service")
	SDHCalICA2Service sdhCalculaICA2Service;

	@Override
	public CalcICA2Response calcula(final CalcICA2Request impuestoRequest)
	{
		String response = sdhCalculaICA2Service.calcICA2(impuestoRequest);

		if (StringUtils.isNotBlank(response))
		{
			try
			{
				LOG.info(response);
				//				response = response.replace("\"\",\"\"", "");
				//				response = response.replace(",\"\"", "");
				response = response.replace("\"Regimen\":", "\"regimen\":");
				response = response.replace("\"Periodo\":", "\"periodo\":");
				response = response.replace("\"Opcion_uso\":", "\"opcion_uso\":");
				response = response.replace("\"Cant_establec\":", "\"cant_establec\":");
				response = response.replace("\"Total_ingr_periodo\":", "\"total_ingr_periodo\":");
				response = response.replace("\"Ing_fuera_bog\":", "\"ingFueraBog\":"); //---
				//				componentes:
				response = response.replace("\"cod_CIIU\":", "\"codCIIU\":");
				response = response.replace("\"cod_municipio\":", "\"codMunicipio\":");
				response = response.replace("\"Deducciones\":", "\"deducciones\":");
				//				componentes:
				response = response.replace("\"Actnosub_pa\":", "\"actnosubPA\":");
				response = response.replace("\"enaj_act_fijo\":", "\"enajActFijo\":");
				response = response.replace("\"Export_bienes\":", "\"exportBienes\":");
				response = response.replace("\"Export_serv\":", "\"exportServ\":");
				response = response.replace("\"Actnosub39\":", "\"actnosub39\":");
				response = response.replace("\"Actnosub_ph\":", "\"actnosubPH\":");
				response = response.replace("\"juego_suerte_azar\":", "\"juegoSuerteAzar\":");
				response = response.replace("\"Donaciones\":", "\"donaciones\":");
				response = response.replace("\"Exen_actos\":", "\"exenActos\":");
				response = response.replace("\"Base_grav_esp\":", "\"baseGravEsp\":");
				response = response.replace("\"Ingr_act_consorc\":", "\"ingrActConsorc\":");
				response = response.replace("\"Divi_nogiro_ord\":", "\"diviNOGiroOrd\":");
				response = response.replace("\"Exen_victima\":", "\"exenVictima\":");
				response = response.replace("\"Correc_moneda\":", "\"correcMoneda\":");
				response = response.replace("\"Reintegro\":", "\"reintegro\":");
				response = response.replace("\"Salarios\":", "\"salarios\":");
				response = response.replace("\"Devoluciones\":", "\"devoluciones\":");
				response = response.replace("\"Rebajas\":", "\"rebajas\":");
				response = response.replace("\"Descuentos\":", "\"descuentos\":");

				//				componentes:
				response = response.replace("\"Ing_netos_grava\":", "\"ingNetosGrava\":"); //---
				response = response.replace("\"Act_principal\":", "\"actPrincipal\":");
				response = response.replace("\"Cod_ciiu\":", "\"codCIIU\":");
				response = response.replace("\"Ingresos\":", "\"ingresos\":");

				//				response = response.replace("\"Ing_por_CIIU\":", "\"ing_por_CIIU\":"); //---
				//				componentes:

				response = response.replace("\"Firmantes\":", "\"firmantes\":");
				response = response.replace("\"Totaling_fuera_bog\":", "\"totaling_fuera_bog\":");
				response = response.replace("\"Totaling_brutos\":", "\"totaling_brutos\":");
				response = response.replace("\"Devol_descuentos\":", "\"devol_descuentos\":");
				response = response.replace("\"Total_deduccion\":", "\"total_deduccion\":");
				response = response.replace("\"Totaling_netos\":", "\"totaling_netos\":");
				response = response.replace("\"Imp_indus_comer\":", "\"imp_indus_comer\":");
				response = response.replace("\"Impuesto_aviso\":", "\"impuesto_aviso\":");
				response = response.replace("\"Total_unidad_adic\":", "\"total_unidad_adic\":");
				response = response.replace("\"Impuesto_cargo\":", "\"impuesto_cargo\":");
				response = response.replace("\"Valor_rete_indus_comer\":", "\"valor_rete_indus_comer\":");
				response = response.replace("\"Saldo_cargo\":", "\"saldo_cargo\":");
				response = response.replace("\"Valor_pagar\":", "\"valor_pagar\":");
				response = response.replace("\"Sanciones\":", "\"sanciones\":");
				response = response.replace("\"Interes_mora\":", "\"interes_mora\":");
				response = response.replace("\"Total_pagar\":", "\"total_pagar\":");
				response = response.replace("\"Total_aporte_volun\":", "\"total_aporte_volun\":");
				response = response.replace("\"Proyecto_aporte\":", "\"proyecto_aporte\":");
				response = response.replace("\"Tarifa_aporte\":", "\"tarifa_aporte\":");
				response = response.replace("\"Check_aporte\":", "\"check_aporte\":");


				final ObjectMapper mapper = new ObjectMapper();
				mapper.configure(org.codehaus.jackson.map.DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);
				final CalcICA2Response impuestoResponse = mapper.readValue(response, CalcICA2Response.class);
				return impuestoResponse;

			}
			catch (final Exception e)
			{
				// XXX Auto-generated catch block
				LOG.error("Error trying to parse JSON :" + response + " to String. Ex.Message" + e.getMessage());
				return null;

			}
		}
		else
		{
			// XXX Auto-generated catch block
			LOG.error("Empty Respnse from servive calula ICA 2");
			return null;
		}
	}




}
