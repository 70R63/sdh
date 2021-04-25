/**
 *
 */
package de.hybris.sdh.core.pojos.responses;

/**
 * @author hybris
 *
 */
public class ContribAgente
{
	private String agente;
	private String tipoDoc;
	private String numDoc;
	private String nomCompleto;
	private String impuesto;
	private String funcionInterl;
	private String bp;
	private String menu;
	private String entBanco;

	/**
	 * @return the tipoDoc
	 */
	public String getTipoDoc()
	{
		return tipoDoc;
	}

	/**
	 * @param tipoDoc
	 *           the tipoDoc to set
	 */
	public void setTipoDoc(final String tipoDoc)
	{
		this.tipoDoc = tipoDoc;
	}

	/**
	 * @return the numDoc
	 */
	public String getNumDoc()
	{
		return numDoc;
	}

	/**
	 * @param numDoc
	 *           the numDoc to set
	 */
	public void setNumDoc(final String numDoc)
	{
		this.numDoc = numDoc;
	}

	/**
	 * @return the nomCompleto
	 */
	public String getNomCompleto()
	{
		return nomCompleto;
	}

	/**
	 * @param nomCompleto
	 *           the nomCompleto to set
	 */
	public void setNomCompleto(final String nomCompleto)
	{
		this.nomCompleto = nomCompleto;
	}

	/**
	 * @return the impuesto
	 */
	public String getImpuesto()
	{
		return impuesto;
	}

	/**
	 * @param impuesto
	 *           the impuesto to set
	 */
	public void setImpuesto(final String impuesto)
	{
		this.impuesto = impuesto;
	}

	/**
	 * @return the funcionInterl
	 */
	public String getFuncionInterl()
	{
		return funcionInterl;
	}

	/**
	 * @param funcionInterl
	 *           the funcionInterl to set
	 */
	public void setFuncionInterl(final String funcionInterl)
	{
		this.funcionInterl = funcionInterl;
	}

	/**
	 * @return the agente
	 */
	public String getAgente()
	{
		return agente;
	}

	/**
	 * @param agente
	 *           the agente to set
	 */
	public void setAgente(final String agente)
	{
		this.agente = agente;
	}


	public String getBp() {
		return bp;
	}

	public void setBp(String bp) {
		this.bp = bp;
	}

	public String getMenu() {
		return menu;
	}

	public void setMenu(String menu) {
		this.menu = menu;
	}

	public String getEntBanco() {
		return entBanco;
	}

	public void setEntBanco(String entBanco) {
		this.entBanco = entBanco;
	}

	@Override
	public String toString() {
		return "ContribAgente{" +
				"agente='" + agente + '\'' +
				", tipoDoc='" + tipoDoc + '\'' +
				", numDoc='" + numDoc + '\'' +
				", nomCompleto='" + nomCompleto + '\'' +
				", impuesto='" + impuesto + '\'' +
				", funcionInterl='" + funcionInterl + '\'' +
				", bp='" + bp + '\'' +
				", menu='" + menu + '\'' +
				", entBanco='" + entBanco + '\'' +
				'}';
	}
}
