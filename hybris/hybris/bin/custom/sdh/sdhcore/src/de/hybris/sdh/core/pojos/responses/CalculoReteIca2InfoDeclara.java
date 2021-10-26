/**
 *
 */
package de.hybris.sdh.core.pojos.responses;

import com.fasterxml.jackson.annotation.JsonSetter;

/**
 * @author hybris
 *
 */
public class CalculoReteIca2InfoDeclara
{
	private String baseReten;
	private String totalRetePer;
	private String descDevol;
	private String totalReteDecl;
	private String sancion;
	private String totalSaldo;
	private String valorPagar;
	private String interesMora;
	private String totalPagar;


	/**
	 * @return the baseReten
	 */
	public String getBaseReten()
	{
		return baseReten;
	}

	/**
	 * @param baseReten
	 *           the baseReten to set
	 */
	@JsonSetter("Base_reten")
	public void setBaseReten(final String baseReten)
	{
		this.baseReten = baseReten;
	}

	/**
	 * @return the totalRetePer
	 */
	public String getTotalRetePer()
	{
		return totalRetePer;
	}

	/**
	 * @param totalRetePer
	 *           the totalRetePer to set
	 */
	@JsonSetter("total_rete_per")
	public void setTotalRetePer(final String totalRetePer)
	{
		this.totalRetePer = totalRetePer;
	}

	/**
	 * @return the descDevol
	 */
	public String getDescDevol()
	{
		return descDevol;
	}

	/**
	 * @param descDevol
	 *           the descDevol to set
	 */
	@JsonSetter("desc_devol")
	public void setDescDevol(final String descDevol)
	{
		this.descDevol = descDevol;
	}

	/**
	 * @return the totalReteDecl
	 */
	public String getTotalReteDecl()
	{
		return totalReteDecl;
	}

	/**
	 * @param totalReteDecl
	 *           the totalReteDecl to set
	 */
	@JsonSetter("total_rete_decl")
	public void setTotalReteDecl(final String totalReteDecl)
	{
		this.totalReteDecl = totalReteDecl;
	}

	/**
	 * @return the sancion
	 */
	public String getSancion()
	{
		return sancion;
	}

	/**
	 * @param sancion
	 *           the sancion to set
	 */
	@JsonSetter("sancion")
	public void setSancion(final String sancion)
	{
		this.sancion = sancion;
	}

	/**
	 * @return the totalSaldo
	 */
	public String getTotalSaldo()
	{
		return totalSaldo;
	}

	/**
	 * @param totalSaldo
	 *           the totalSaldo to set
	 */
	@JsonSetter("total_saldo")
	public void setTotalSaldo(final String totalSaldo)
	{
		this.totalSaldo = totalSaldo;
	}

	/**
	 * @return the valorPagar
	 */
	public String getValorPagar()
	{
		return valorPagar;
	}

	/**
	 * @param valorPagar
	 *           the valorPagar to set
	 */
	@JsonSetter("valor_pagar")
	public void setValorPagar(final String valorPagar)
	{
		this.valorPagar = valorPagar;
	}

	/**
	 * @return the interesMora
	 */
	public String getInteresMora()
	{
		return interesMora;
	}

	/**
	 * @param interesMora
	 *           the interesMora to set
	 */
	@JsonSetter("interes_mora")
	public void setInteresMora(final String interesMora)
	{
		this.interesMora = interesMora;
	}

	/**
	 * @return the totalPagar
	 */
	public String getTotalPagar()
	{
		return totalPagar;
	}

	/**
	 * @param totalPagar
	 *           the totalPagar to set
	 */
	@JsonSetter("total_pagar")
	public void setTotalPagar(final String totalPagar)
	{
		this.totalPagar = totalPagar;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString()
	{
		return "CalculoReteIca2InfoDeclara [baseReten=" + baseReten + ", totalRetePer=" + totalRetePer + ", descDevol=" + descDevol
				+ ", totalReteDecl=" + totalReteDecl + ", sancion=" + sancion + ", totalSaldo=" + totalSaldo + ", valorPagar="
				+ valorPagar + ", interesMora=" + interesMora + ", totalPagar=" + totalPagar + "]";
	}



}
