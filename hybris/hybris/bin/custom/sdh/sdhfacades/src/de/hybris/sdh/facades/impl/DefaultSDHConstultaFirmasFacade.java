package de.hybris.sdh.facades.impl;

import de.hybris.sdh.core.pojos.requests.ConsulFirmasRequest;
import de.hybris.sdh.core.pojos.responses.ConsulFirmasDeclaracionesResponse;
import de.hybris.sdh.core.pojos.responses.ConsulFirmasResponse;
import de.hybris.sdh.core.pojos.responses.ContribFirmasResponse;
import de.hybris.sdh.core.pojos.responses.DetalleDeclaraciones;
import de.hybris.sdh.core.services.SDHConsulFirmasService;
import de.hybris.sdh.core.services.SDHConsultaImpuesto_simplificado;
import de.hybris.sdh.core.services.impl.DefaultSDHConsultaFirmasService;
import de.hybris.sdh.facades.SDHConsultaFirmasFacade;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.annotation.Resource;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.codehaus.jackson.map.ObjectMapper;

public class DefaultSDHConstultaFirmasFacade implements SDHConsultaFirmasFacade {

    private static final Logger LOG = Logger.getLogger(DefaultSDHConsultaFirmasService.class);

    @Resource(name="sdhConsulFirmasService")
    SDHConsulFirmasService sdhConsulFirmasService;

	 @Resource(name = "sdhConsultaImpuesto_simplificado")
	 SDHConsultaImpuesto_simplificado sdhConsultaImpuesto_simplificado;

    @Override
    public ConsulFirmasResponse getDeclaraciones(final ConsulFirmasRequest request) {

        final String response = sdhConsulFirmasService.getDeclaraciones(request);

        if(StringUtils.isNotBlank(response))
        {
            try
            {

                final ObjectMapper mapper = new ObjectMapper();
                mapper.configure(org.codehaus.jackson.map.DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);
                final ConsulFirmasResponse consulFirmasResponse = mapper.readValue(response, ConsulFirmasResponse.class);

                if(consulFirmasResponse != null && CollectionUtils.isNotEmpty(consulFirmasResponse.getDeclaraciones()))
                {

                    final List<ConsulFirmasDeclaracionesResponse> filteredDeclas = new ArrayList<ConsulFirmasDeclaracionesResponse>();

                    for(final ConsulFirmasDeclaracionesResponse eachDecla : consulFirmasResponse.getDeclaraciones())
                    {

                        if(StringUtils.isNotBlank(eachDecla.getIdDeclaracion()))
                        {
                            filteredDeclas.add(eachDecla);
                        }

                    }

                    consulFirmasResponse.setDeclaraciones(filteredDeclas);
                }

                return consulFirmasResponse;

            }
            catch (final Exception e)
            {
                // XXX Auto-generated catch block
                LOG.error("Error trying to parse JSON :" + response + " to String. Ex.Message" + e.getMessage());

                return null;

            }
        }

        return null;
    }

	 @Override
	 public void filtrarFirmas(final ConsulFirmasResponse declaraciones, final Map<String, String> impuestosActivos)
	 {
		 List<ConsulFirmasDeclaracionesResponse> declaracionesFiltradas = null;

		 if (declaraciones != null && declaraciones.getDeclaraciones() != null && !declaraciones.getDeclaraciones().isEmpty())
		 {
			 declaracionesFiltradas = new ArrayList<ConsulFirmasDeclaracionesResponse>();

			 if (sdhConsultaImpuesto_simplificado.esImpuestoActivo(impuestosActivos, sdhConsultaImpuesto_simplificado.PREDIAL))
			 {
				 declaracionesFiltradas.addAll(declaraciones.getDeclaraciones().stream()
						 .filter(eachDeclarcion -> eachDeclarcion.getImpuesto().equals(sdhConsultaImpuesto_simplificado.PREDIAL))
						 .collect(Collectors.toList()));
			 }
			 if (sdhConsultaImpuesto_simplificado.esImpuestoActivo(impuestosActivos, sdhConsultaImpuesto_simplificado.VEHICULOS))
			 {
				 declaracionesFiltradas.addAll(declaraciones.getDeclaraciones().stream()
						 .filter(eachDeclarcion -> eachDeclarcion.getImpuesto().equals(sdhConsultaImpuesto_simplificado.VEHICULOS))
						 .collect(Collectors.toList()));
			 }
			 if (sdhConsultaImpuesto_simplificado.esImpuestoActivo(impuestosActivos, sdhConsultaImpuesto_simplificado.ICA))
			 {
				 declaracionesFiltradas.addAll(declaraciones.getDeclaraciones().stream()
						 .filter(eachDeclarcion -> eachDeclarcion.getImpuesto().equals(sdhConsultaImpuesto_simplificado.ICA))
						 .collect(Collectors.toList()));
			 }
			 if (sdhConsultaImpuesto_simplificado.esImpuestoActivo(impuestosActivos, sdhConsultaImpuesto_simplificado.RETEICA))
			 {
				 declaracionesFiltradas.addAll(declaraciones.getDeclaraciones().stream()
						 .filter(eachDeclarcion -> eachDeclarcion.getImpuesto().equals(sdhConsultaImpuesto_simplificado.RETEICA))
						 .collect(Collectors.toList()));
			 }
			 if (sdhConsultaImpuesto_simplificado.esImpuestoActivo(impuestosActivos, sdhConsultaImpuesto_simplificado.GASOLINA))
			 {
				 declaracionesFiltradas.addAll(declaraciones.getDeclaraciones().stream()
						 .filter(eachDeclarcion -> eachDeclarcion.getImpuesto().equals(sdhConsultaImpuesto_simplificado.GASOLINA))
						 .collect(Collectors.toList()));
			 }
			 if (sdhConsultaImpuesto_simplificado.esImpuestoActivo(impuestosActivos, sdhConsultaImpuesto_simplificado.DELINEACION))
			 {
				 declaracionesFiltradas.addAll(declaraciones.getDeclaraciones().stream()
						 .filter(eachDeclarcion -> eachDeclarcion.getImpuesto().equals(sdhConsultaImpuesto_simplificado.DELINEACION))
						 .collect(Collectors.toList()));
			 }
			 if (sdhConsultaImpuesto_simplificado.esImpuestoActivo(impuestosActivos, sdhConsultaImpuesto_simplificado.PUBLICIDAD))
			 {
				 declaracionesFiltradas.addAll(declaraciones.getDeclaraciones().stream()
						 .filter(eachDeclarcion -> eachDeclarcion.getImpuesto().equals(sdhConsultaImpuesto_simplificado.PUBLICIDAD))
						 .collect(Collectors.toList()));
			 }
		 }


		 declaraciones.setDeclaraciones(declaracionesFiltradas);
	 }

	 @Override
	 public void filtrarFirmas_contrib(final ContribFirmasResponse declaraciones, final Map<String, String> impuestosActivos)
	 {
		 List<DetalleDeclaraciones> declaracionesFiltradas = null;

		 if (declaraciones != null && declaraciones.getDeclaraciones() != null && !declaraciones.getDeclaraciones().isEmpty())
		 {
			 declaracionesFiltradas = new ArrayList<DetalleDeclaraciones>();

			 if (sdhConsultaImpuesto_simplificado.esImpuestoActivo(impuestosActivos, sdhConsultaImpuesto_simplificado.PREDIAL))
			 {
				 declaracionesFiltradas.addAll(declaraciones.getDeclaraciones().stream()
						 .filter(eachDeclarcion -> eachDeclarcion.getImpuesto().equals(sdhConsultaImpuesto_simplificado.PREDIAL))
						 .collect(Collectors.toList()));
			 }
			 if (sdhConsultaImpuesto_simplificado.esImpuestoActivo(impuestosActivos, sdhConsultaImpuesto_simplificado.VEHICULOS))
			 {
				 declaracionesFiltradas.addAll(declaraciones.getDeclaraciones().stream()
						 .filter(eachDeclarcion -> eachDeclarcion.getImpuesto().equals(sdhConsultaImpuesto_simplificado.VEHICULOS))
						 .collect(Collectors.toList()));
			 }
			 if (sdhConsultaImpuesto_simplificado.esImpuestoActivo(impuestosActivos, sdhConsultaImpuesto_simplificado.ICA))
			 {
				 declaracionesFiltradas.addAll(declaraciones.getDeclaraciones().stream()
						 .filter(eachDeclarcion -> eachDeclarcion.getImpuesto().equals(sdhConsultaImpuesto_simplificado.ICA))
						 .collect(Collectors.toList()));
			 }
			 if (sdhConsultaImpuesto_simplificado.esImpuestoActivo(impuestosActivos, sdhConsultaImpuesto_simplificado.RETEICA))
			 {
				 declaracionesFiltradas.addAll(declaraciones.getDeclaraciones().stream()
						 .filter(eachDeclarcion -> eachDeclarcion.getImpuesto().equals(sdhConsultaImpuesto_simplificado.RETEICA))
						 .collect(Collectors.toList()));
			 }
			 if (sdhConsultaImpuesto_simplificado.esImpuestoActivo(impuestosActivos, sdhConsultaImpuesto_simplificado.GASOLINA))
			 {
				 declaracionesFiltradas.addAll(declaraciones.getDeclaraciones().stream()
						 .filter(eachDeclarcion -> eachDeclarcion.getImpuesto().equals(sdhConsultaImpuesto_simplificado.GASOLINA))
						 .collect(Collectors.toList()));
			 }
			 if (sdhConsultaImpuesto_simplificado.esImpuestoActivo(impuestosActivos, sdhConsultaImpuesto_simplificado.DELINEACION))
			 {
				 declaracionesFiltradas.addAll(declaraciones.getDeclaraciones().stream()
						 .filter(eachDeclarcion -> eachDeclarcion.getImpuesto().equals(sdhConsultaImpuesto_simplificado.DELINEACION))
						 .collect(Collectors.toList()));
			 }
			 if (sdhConsultaImpuesto_simplificado.esImpuestoActivo(impuestosActivos, sdhConsultaImpuesto_simplificado.PUBLICIDAD))
			 {
				 declaracionesFiltradas.addAll(declaraciones.getDeclaraciones().stream()
						 .filter(eachDeclarcion -> eachDeclarcion.getImpuesto().equals(sdhConsultaImpuesto_simplificado.PUBLICIDAD))
						 .collect(Collectors.toList()));
			 }
		 }


		 declaraciones.setDeclaraciones(declaracionesFiltradas);
	 }
}
