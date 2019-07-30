/**
 *
 */
package de.hybris.sdh.core.pojos.responses;

import java.util.List;


/**
 * @author Federico Flores Dimas
 *
 */
public class DocTramitesResponse
{
	private String idmsj;
	private String txtmsj;
	private List<DocTramitesDocumentosResponse> documentos;

	/**
	 * @return the idmsj
	 */
	public String getIdmsj()
	{
		return idmsj;
	}

	/**
	 * @param idmsj
	 *           the idmsj to set
	 */
	public void setIdmsj(final String idmsj)
	{
		this.idmsj = idmsj;
	}

	/**
	 * @return the txtmsj
	 */
	public String getTxtmsj()
	{
		return txtmsj;
	}

	/**
	 * @param txtmsj
	 *           the txtmsj to set
	 */
	public void setTxtmsj(final String txtmsj)
	{
		this.txtmsj = txtmsj;
	}

	/**
	 * @return the documentos
	 */
	public List<DocTramitesDocumentosResponse> getDocumentos()
	{
		return documentos;
	}

	/**
	 * @param documentos
	 *           the documentos to set
	 */
	public void setDocumentos(final List<DocTramitesDocumentosResponse> documentos)
	{
		this.documentos = documentos;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString()
	{
		return "DocTramitesResponse [idmsj=" + idmsj + ", txtmsj=" + txtmsj + ", documentos=" + documentos + "]";
	}


}
