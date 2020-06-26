package de.hybris.sdh.storefront.forms;


import de.hybris.sdh.storefront.controllers.pages.forms.SelectAtomValue;

import java.util.List;


public class TercerosAutForm {
    private String tipdoc;
    private String numdoc;
    private String impuesto;

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

}
