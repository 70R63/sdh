/**
 *
 */
package de.hybris.sdh.storefront.forms;

import de.hybris.sdh.core.pojos.responses.ContribAgente;
import de.hybris.sdh.core.pojos.responses.DetalleDeclaraciones;

import java.util.List;


/**
 * @author hybris
 *
 */
public class ContribuyenteForm
{
	private List<DetalleDeclaraciones> declaraciones;
	private List<ContribAgente> representados;





    /**
     * @return the representados
     */
    public List<ContribAgente> getRepresentados()
    {
        return representados;
    }

    /**
     * @param representados
     *           the representados to set
     */
    public void setRepresentados(final List<ContribAgente> representados)
    {
        this.representados = representados;
    }

	/**
	 * @return the declaraciones
	 */
	public List<DetalleDeclaraciones> getDeclaraciones()
	{
		return declaraciones;
	}

	/**
	 * @param declaraciones
	 *           the declaraciones to set
	 */
	public void setDeclaraciones(final List<DetalleDeclaraciones> declaraciones)
	{
		this.declaraciones = declaraciones;
	}



}
