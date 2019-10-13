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
				response = response.replace("\"Opcion_uso\":", "\"opcionUso\":");
				response = response.replace("\"Cant_establec\":", "\"cantEstablec\":");
				response = response.replace("\"Total_ingr_periodo\":", "\"totalIngrPeriodo\":");
				response = response.replace("\"Ing_fuera_bog\":", "\"ingFueraBog\":"); //---
				//				componentes:
				response = response.replace("\"cod_CIIU\":", "\"codCIIU\":");
				response = response.replace("\"cod_municipio\":", "\"codMunicipio\":");
				response = response.replace("\"Valor_retenido\":", "\"valorRetenido\":"); //---
				//				componentes:
				response = response.replace("\"Anio_gravable\":", "\"anoGravable\":");
				response = response.replace("\"Tipo_id\":", "\"tipoID\":");
				response = response.replace("\"Num_id\":", "\"numID\":");
				response = response.replace("\"Telefono\":", "\"telefono\":");
				response = response.replace("\"Tarifa_apl\":", "\"tarifaApl\":");
				response = response.replace("\"Monto_retenido\":", "\"montoRetenido\":");
				response = response.replace("\"Ing_por_CIIU\":", "\"ingPorCIIU\":"); //---
				//				componentes:
				//				response = response.replace("\"Anio_gravable\":", "\"anoGravable\":");
				//				response = response.replace("\"Tipo_id\":", "\"tipoID\":");
				//				response = response.replace("\"Num_id\":", "\"numID\":");
				response = response.replace("\"Razon_social\":", "\"razonSocial\":");
				response = response.replace("\"Direccion\":", "\"direccion\":");
				response = response.replace("\"Cod_municipio\":", "\"codMunicipio\":");
				//				response = response.replace("\"Des_municipio\":", "\"_\":"); //Este no esta en el pojo
				//				response = response.replace("\"Telefono\":", "\"telefono\":");
				response = response.replace("\"Cod_ciiu\":", "\"codCIIU\":");
				//				response = response.replace("\"descrip_ciiu\":", "\"_\":"); //Este no esta en el pojo
				response = response.replace("\"Ing_bruto_siniva\":", "\"ingBrutoSINIVA\":");
				response = response.replace("\"Valor_total_devol\":", "\"valorTotalDevo\":");
				//				response = response.replace("\"Deducciones\":", "\"deducciones\":"); //---
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

				response = response.replace("\"Totaling_fuera_bog\":", "\"totalingFueraBog\":");
				response = response.replace("\"Totaling_brutos\":", "\"totalingBrutos\":");
				response = response.replace("\"Devol_descuentos\":", "\"devolDescuentos\":");
				response = response.replace("\"Total_deduccion\":", "\"totalDeduccion\":");
				response = response.replace("\"Totaling_netos\":", "\"totalingNetos\":");
				response = response.replace("\"Imp_indus_comer\":", "\"impIndusComer\":");
				response = response.replace("\"Impuesto_aviso\":", "\"impuestoAviso\":");
				response = response.replace("\"Total_unidad_adic\":", "\"totalUnidadAdic\":");
				response = response.replace("\"Impuesto_cargo\":", "\"impuestoCargo\":");
				response = response.replace("\"Valor_rete_indus_comer\":", "\"valorReteIndus\":");
				response = response.replace("\"Saldo_cargo\":", "\"saldoCargo\":");
				response = response.replace("\"Valor_pagar\":", "\"valorPagar\":");
				response = response.replace("\"Sanciones\":", "\"sanciones\":");
				response = response.replace("\"Interes_mora\":", "\"interesMora\":");
				response = response.replace("\"Total_pagar\":", "\"totalPagar\":");
				response = response.replace("\"Total_aporte_volun\":", "\"totalAporteVolun\":");
				response = response.replace("\"Proyecto_aporte\":", "\"proyectoAporte\":");
				response = response.replace("\"Tarifa_aporte\":", "\"tarifaAporte\":");
				response = response.replace("\"Check_aporte\":", "\"checkAporte\":");


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
