package de.hybris.sdh.storefront.forms;


import de.hybris.sdh.storefront.controllers.pages.forms.SelectAtomValue;

import java.util.List;


public class TercerosAutForm {
	private String tipdoc;
	private String numdoc;
	private String numObjeto;
	private String impuesto;
	private String subrol;

	private List<SelectAtomValue> listaImpuestos;



    public String getTipdoc() {
        return tipdoc;
    }

    public void setTipdoc(final String tipdoc) {
        this.tipdoc = tipdoc;
    }

    public String getNumdoc() {
        return numdoc;
    }

    public void setNumdoc(final String numdoc) {
        this.numdoc = numdoc;
    }

    public String getImpuesto() {
        return impuesto;
    }

    public void setImpuesto(final String impuesto) {
        this.impuesto = impuesto;
    }

	/**
	 * @return the listaImpuestos
	 */
	public List<SelectAtomValue> getListaImpuestos()
	{
		return listaImpuestos;
	}

	/**
	 * @param listaImpuestos
	 *           the listaImpuestos to set
	 */
	public void setListaImpuestos(final List<SelectAtomValue> listaImpuestos)
	{
		this.listaImpuestos = listaImpuestos;
	}

	/**
	 * @return the numObjeto
	 */
	public String getNumObjeto()
	{
		return numObjeto;
	}

	/**
	 * @param numObjeto
	 *           the numObjeto to set
	 */
	public void setNumObjeto(final String numObjeto)
	{
		this.numObjeto = numObjeto;
	}

	/**
	 * @return the subrol
	 */
	public String getSubrol()
	{
		return subrol;
	}

	/**
	 * @param subrol
	 *           the subrol to set
	 */
	public void setSubrol(final String subrol)
	{
		this.subrol = subrol;
	}

}
