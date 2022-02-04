/**
 *
 */
package de.hybris.sdh.core.pojos.requests;

import de.hybris.sdh.core.pojos.responses.DelineacionUAreaIntervenida;
import de.hybris.sdh.core.pojos.responses.DelineacionUAreaProyecto;
import de.hybris.sdh.core.pojos.responses.DelineacionUInfoDeclara;
import de.hybris.sdh.core.pojos.responses.DelineacionUUsos;

import java.util.List;

import org.apache.commons.lang3.StringUtils;


/**
 * @author Federico Flores Dimas
 *
 */
public class CalculoImpDelineacionRequest
{
	private String numBP;
	private String cdu;
	private String numRadicado;
	private String anoGravable;
	private String retencion;
	private String numForm;
	private DelineacionUInfoDeclara infoDeclara;
	private List<DelineacionUUsos> usos;
	private List<DelineacionUAreaIntervenida> areaIntervenida;
	private List<DelineacionUAreaProyecto> areaProyecto;

	/**
	 * @return the numBP
	 */
	public String getNumBP()
	{
		return numBP;
	}

	/**
	 * @param numBP
	 *           the numBP to set
	 */
	public void setNumBP(final String numBP)
	{
		this.numBP = numBP;
	}

	/**
	 * @return the cdu
	 */
	public String getCdu()
	{
		return cdu;
	}

	/**
	 * @param cdu
	 *           the cdu to set
	 */
	public void setCdu(final String cdu)
	{
		this.cdu = cdu;
	}

	/**
	 * @return the numRadicado
	 */
	public String getNumRadicado()
	{
		return numRadicado;
	}

	/**
	 * @param numRadicado
	 *           the numRadicado to set
	 */
	public void setNumRadicado(final String numRadicado)
	{
		this.numRadicado = numRadicado;
	}

	/**
	 * @return the anoGravable
	 */
	public String getAnoGravable()
	{
		return anoGravable;
	}

	/**
	 * @param anoGravable
	 *           the anoGravable to set
	 */
	public void setAnoGravable(final String anoGravable)
	{
		this.anoGravable = anoGravable;
	}

	/**
	 * @return the retencion
	 */
	public String getRetencion()
	{
		return retencion;
	}

	/**
	 * @param retencion
	 *           the retencion to set
	 */
	public void setRetencion(final String retencion)
	{
		this.retencion = retencion;
	}

	/**
	 * @return the numForm
	 */
	public String getNumForm()
	{
		return numForm;
	}

	/**
	 * @param numForm
	 *           the numForm to set
	 */
	public void setNumForm(final String numForm)
	{
		this.numForm = numForm;
	}

	/**
	 * @return the infoDeclara
	 */
	public DelineacionUInfoDeclara getInfoDeclara()
	{
		return infoDeclara;
	}

	/**
	 * @param infoDeclara
	 *           the infoDeclara to set
	 */
	public void setInfoDeclara(final DelineacionUInfoDeclara infoDeclara)
	{
		this.infoDeclara = infoDeclara;
	}

	/**
	 * @return the usos
	 */
	public List<DelineacionUUsos> getUsos()
	{
		return usos;
	}

	/**
	 * @param usos
	 *           the usos to set
	 */
	public void setUsos(final List<DelineacionUUsos> usos)
	{
		this.usos = usos;
	}

	/**
	 * @return the areaIntervenida
	 */
	public List<DelineacionUAreaIntervenida> getAreaIntervenida()
	{
		return areaIntervenida;
	}

	/**
	 * @param areaIntervenida
	 *           the areaIntervenida to set
	 */
	public void setAreaIntervenida(final List<DelineacionUAreaIntervenida> areaIntervenida)
	{
		this.areaIntervenida = areaIntervenida;
	}

	/**
	 * @return the areaProyecto
	 */
	public List<DelineacionUAreaProyecto> getAreaProyecto()
	{
		return areaProyecto;
	}

	/**
	 * @param areaProyecto
	 *           the areaProyecto to set
	 */
	public void setAreaProyecto(final List<DelineacionUAreaProyecto> areaProyecto)
	{
		this.areaProyecto = areaProyecto;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString()
	{
		final StringBuilder stringBuilder = new StringBuilder();

		stringBuilder.append("{");
		stringBuilder.append("\"numBP\":\"" + this.getNumBP() + "\",");
		stringBuilder.append("\"cdu\":\"" + this.getCdu() + "\",");
		stringBuilder.append("\"numRadicado\":\"" + this.getNumRadicado() + "\",");
		stringBuilder.append("\"anoGravable\":\"" + this.getAnoGravable() + "\",");
		stringBuilder.append("\"retencion\":\"" + (StringUtils.isBlank(this.getRetencion()) ? "" : this.getRetencion()) + "\",");
		stringBuilder.append(obtenerValorJson("\"numForm\":\"", this.getNumForm(), "\""));


		if (this.getInfoDeclara() != null || this.getUsos() != null || this.getAreaIntervenida() != null
				|| this.getAreaProyecto() != null)
		{

			if (this.getInfoDeclara() != null)
			{
				stringBuilder.append(",");
				stringBuilder.append(this.preparaInfoDeclara("\"infoDeclara\":"));

			}
			if (this.getUsos() != null && this.getUsos().size() > 0)
			{
				stringBuilder.append(",");
				stringBuilder.append(this.preparaUsos("\"usos\":"));
			}
			if (this.getAreaIntervenida() != null && this.getAreaIntervenida().size() > 0)
			{
				stringBuilder.append(",");
				stringBuilder.append(this.preparaAreaIntervenida("\"areaIntervenida\":"));
			}
			if (this.getAreaProyecto() != null && this.getAreaProyecto().size() > 0)
			{
				stringBuilder.append(",");
				stringBuilder.append(this.preparaAreaProyecto("\"areaProyecto\":"));
			}

		}
		stringBuilder.append("}");

		return stringBuilder.toString();
	}


	private String obtenerValorJson(final String cadena1, final String valor, final String cadena2)
	{
		String valorVariable = "";

		valorVariable = (valor != null) ? cadena1 + valor + cadena2 : cadena1 + cadena2;


		return valorVariable;
	}

	private String preparaInfoDeclara(final String nombreSegmento)
	{
		final StringBuilder stringBuilder = new StringBuilder();
		DelineacionUInfoDeclara info;
		String valorRetorno = "";

		info = this.getInfoDeclara();

		stringBuilder.append("{");
		stringBuilder.append(obtenerValorJson("\"opcionUso\":\"", info.getOpcionUso(), "\","));
		stringBuilder.append(obtenerValorJson("\"tipoLicencia\":\"", info.getTipoLicencia(), "\","));
		stringBuilder.append(obtenerValorJson("\"objetoLicen\":\"", info.getObjetoLicen(), "\","));
		stringBuilder.append(obtenerValorJson("\"presupuestoObra\":\"", info.getPresupuestoObra(), "\","));
		stringBuilder.append(obtenerValorJson("\"causalExep\":\"", info.getCausalExcep(), "\","));
		stringBuilder.append(obtenerValorJson("\"totalPresupuesto\":\"", info.getTotalPresupuesto(), "\","));
		stringBuilder.append(obtenerValorJson("\"totalRetencion\":\"", info.getTotalRetencion(), "\","));
		stringBuilder.append(obtenerValorJson("\"totalPagar\":\"", info.getTotalPagar(), "\","));
		stringBuilder.append(obtenerValorJson("\"valorEjecutado\":\"", info.getValorEjecutado(), "\","));
		stringBuilder.append(obtenerValorJson("\"impuestoCargo\":\"", info.getImpuestoCargo(), "\","));
		stringBuilder.append(obtenerValorJson("\"valorSancion\":\"", info.getValorSancion(), "\","));
		stringBuilder.append(obtenerValorJson("\"saldoImpCargo\":\"", info.getSaldoImpCargo(), "\","));
		stringBuilder.append(obtenerValorJson("\"saldoFavor\":\"", info.getSaldoFavor(), "\","));
		stringBuilder.append(obtenerValorJson("\"valorPagar\":\"", info.getValorPagar(), "\","));
		stringBuilder.append(obtenerValorJson("\"interesMora\":\"", info.getInteresMora(), "\","));
		stringBuilder.append(obtenerValorJson("\"fechaEjecutaria\":\"", info.getFechaEjecutaria(), "\","));
		stringBuilder.append(obtenerValorJson("\"fechaFinObra\":\"", info.getFechaFinalObra(), "\","));
		stringBuilder.append(obtenerValorJson("\"fechaUltAbono\":\"", info.getFechaUltAbono(), "\","));
		stringBuilder.append(obtenerValorJson("\"modalidad\":\"", info.getModalidad(), "\","));
		stringBuilder.append(obtenerValorJson("\"valorExen\":\"", info.getValorExen(), "\""));
		stringBuilder.append("}");


		if (stringBuilder.toString() != null)
		{
			valorRetorno = nombreSegmento + stringBuilder.toString();
		}

		return valorRetorno;
	}


	private String preparaUsos(final String nombreSegmento)
	{
		final StringBuilder stringBuilder = new StringBuilder();
		DelineacionUUsos info;
		String valorRetorno = "";


		if (this.getUsos() != null && this.getUsos().size() > 0)
		{
			stringBuilder.append("[");
			for (int i = 0; i < this.getUsos().size() - 1; i++)
			{
				info = this.getUsos().get(i);

				stringBuilder.append("{");
				stringBuilder.append(obtenerValorJson("\"codUso\":\"", info.getCodUso(), "\","));
				stringBuilder.append(obtenerValorJson("\"numUnidad\":\"", info.getNumUnidad(), "\","));
				stringBuilder.append(obtenerValorJson("\"Uso\":\"", info.getUso(), "\","));
				stringBuilder.append(obtenerValorJson("\"areaNeta\":\"", info.getAreaNeta(), "\""));
				stringBuilder.append("},");
			}
			info = this.getUsos().get(this.getUsos().size() - 1);

			stringBuilder.append("{");
			stringBuilder.append(obtenerValorJson("\"codUso\":\"", info.getCodUso(), "\","));
			stringBuilder.append(obtenerValorJson("\"numUnidad\":\"", info.getNumUnidad(), "\","));
			stringBuilder.append(obtenerValorJson("\"Uso\":\"", info.getUso(), "\","));
			stringBuilder.append(obtenerValorJson("\"areaNeta\":\"", info.getAreaNeta(), "\""));
			stringBuilder.append("}");

			stringBuilder.append("]");
		}

		if (stringBuilder.toString() != null)
		{
			valorRetorno = nombreSegmento + stringBuilder.toString();
		}

		return valorRetorno;
	}


	private String preparaAreaIntervenida(final String nombreSegmento)
	{
		final StringBuilder stringBuilder = new StringBuilder();
		DelineacionUAreaIntervenida info;
		String valorRetorno = "";


		if (this.getAreaIntervenida() != null && this.getAreaIntervenida().size() > 0)
		{
			stringBuilder.append("[");
			for (int i = 0; i < this.getAreaIntervenida().size() - 1; i++)
			{
				info = this.getAreaIntervenida().get(i);

				stringBuilder.append("{");
				stringBuilder.append(obtenerValorJson("\"areaInter\":\"", info.getAreaInter(), "\","));
				stringBuilder.append(obtenerValorJson("\"aream2\":\"", info.getAream2(), "\""));
				stringBuilder.append("},");
			}
			info = this.getAreaIntervenida().get(this.getAreaIntervenida().size() - 1);

			stringBuilder.append("{");
			stringBuilder.append(obtenerValorJson("\"areaInter\":\"", info.getAreaInter(), "\","));
			stringBuilder.append(obtenerValorJson("\"aream2\":\"", info.getAream2(), "\""));
			stringBuilder.append("}");

			stringBuilder.append("]");
		}

		if (stringBuilder.toString() != null)
		{
			valorRetorno = nombreSegmento + stringBuilder.toString();
		}

		return valorRetorno;
	}

	private String preparaAreaProyecto(final String nombreSegmento)
	{
		final StringBuilder stringBuilder = new StringBuilder();
		DelineacionUAreaProyecto info;
		String valorRetorno = "";


		if (this.getAreaProyecto() != null && this.getAreaProyecto().size() > 0)
		{
			stringBuilder.append("[");
			for (int i = 0; i <= this.getAreaProyecto().size() - 1; i++)
			{
				info = this.getAreaProyecto().get(i);

				stringBuilder.append("{");
				stringBuilder.append(obtenerValorJson("\"areaProy\":\"", info.getAreaProy(), "\","));
				stringBuilder.append(obtenerValorJson("\"aream2\":\"", info.getAream2(), "\""));
				stringBuilder.append("},");
			}

			if (this.getAreaProyecto() == null)
			{
				stringBuilder.append("{");
				stringBuilder.append(obtenerValorJson("\"areaProy\":\"", "", "\","));
				stringBuilder.append(obtenerValorJson("\"aream2\":\"", "", "\""));
				stringBuilder.append("}");
			}

			stringBuilder.append("]");
		}

		if (stringBuilder.toString() != null)
		{
			valorRetorno = nombreSegmento + stringBuilder.toString();
		}

		return valorRetorno;
	}


}
