/**
 *
 */
package de.hybris.sdh.storefront.controllers.impuestoGasolina;

import java.util.ArrayList;
import java.util.List;


/**
 * @author fede
 *
 */
public class SobreTasaGasolinaService
{
	//	public List<TelefonoInfo> buscarTelefonosByID(final int id)
	//	{
	//		if (id == 1) // ejemplo de logica adicional en la capa de servicio, aca se pueden agregar validaciones o formateos adicionales para preparar la lista final
	//		{
	//			return new DeclaracionGasolinaDAOImpl().leerTelefonos();
	//		}
	//		else
	//		{
	//			return null;
	//		}
	//	}

	public SobreTasaGasolinaCatalogos prepararCatalogos()
	{

		final SobreTasaGasolinaCatalogos catalogosForm = new SobreTasaGasolinaCatalogos();

		catalogosForm.setOpcionesCantidadMostrar(obtenerListaOpcionesCantidadMostrar());
		catalogosForm.setAnioGravable(obtenerListaAnioGravable(2019, 4));
		catalogosForm.setPeriodo(obtenerListaPeriodo());
		catalogosForm.setCalidadResponsable(obtenerListaCalidadResponsable());
		catalogosForm.setCodigoPostal(obtenerListaCodigoPostal());
		catalogosForm.setLocalidad(obtenerListaLocalidades());
		catalogosForm.setTipoId(obtenerListaTipoId());
		catalogosForm.setTipoRelacion(obtenerListaTipoRelacion());
		catalogosForm.setFuenteDato(obtenerListaFuenteDato());


		return catalogosForm;
	}

	private List<ItemSelectOption> obtenerListaOpcionesCantidadMostrar()
	{

		final List<ItemSelectOption> elementos = new ArrayList<ItemSelectOption>();


		elementos.add(new ItemSelectOption(1, Integer.toString(10)));
		elementos.add(new ItemSelectOption(2, Integer.toString(20)));
		elementos.add(new ItemSelectOption(3, Integer.toString(50)));

		return elementos;
	}

	private List<ItemSelectOption> obtenerListaAnioGravable(final int anioBase, final int numeroAnios)
	{

		final List<ItemSelectOption> elementos = new ArrayList<ItemSelectOption>();

		for (int i = 0; i < numeroAnios; i++)
		{
			elementos.add(new ItemSelectOption(i, Integer.toString(anioBase - i)));
		}

		return elementos;
	}

	private List<ItemSelectOption> obtenerListaPeriodo()
	{

		final List<ItemSelectOption> elementos = new ArrayList<ItemSelectOption>();


		elementos.add(new ItemSelectOption(1, "Enero"));
		elementos.add(new ItemSelectOption(2, "Febrero"));
		elementos.add(new ItemSelectOption(3, "Marzo"));
		elementos.add(new ItemSelectOption(4, "Abril"));
		elementos.add(new ItemSelectOption(5, "Mayo"));
		elementos.add(new ItemSelectOption(6, "Junio"));
		elementos.add(new ItemSelectOption(7, "Julio"));
		elementos.add(new ItemSelectOption(8, "Agosto"));
		elementos.add(new ItemSelectOption(9, "Septiembre"));
		elementos.add(new ItemSelectOption(10, "Octubre"));
		elementos.add(new ItemSelectOption(11, "Noviembre"));
		elementos.add(new ItemSelectOption(12, "Diciembre"));


		return elementos;
	}

	private List<ItemSelectOption> obtenerListaCalidadResponsable()
	{

		final List<ItemSelectOption> elementos = new ArrayList<ItemSelectOption>();


		elementos.add(new ItemSelectOption(1, "Productor"));


		return elementos;
	}

	private List<ItemSelectOption> obtenerListaCodigoPostal()
	{

		final List<ItemSelectOption> elementos = new ArrayList<ItemSelectOption>();


		elementos.add(new ItemSelectOption(1, "110111"));

		return elementos;
	}

	private List<ItemSelectOption> obtenerListaLocalidades()
	{

		final List<ItemSelectOption> elementos = new ArrayList<ItemSelectOption>();


		elementos.add(new ItemSelectOption(1, "Antonio Nariño"));

		return elementos;
	}

	private List<ItemSelectOption> obtenerListaTipoId()
	{

		final List<ItemSelectOption> elementos = new ArrayList<ItemSelectOption>();

		elementos.add(new ItemSelectOption(1, "Cédula de ciudadanía"));


		return elementos;
	}

	private List<ItemSelectOption> obtenerListaTipoRelacion()
	{

		final List<ItemSelectOption> elementos = new ArrayList<ItemSelectOption>();

		elementos.add(new ItemSelectOption(1, "tipo 1"));


		return elementos;
	}

	private List<ItemSelectOption> obtenerListaFuenteDato()
	{

		final List<ItemSelectOption> elementos = new ArrayList<ItemSelectOption>();

		elementos.add(new ItemSelectOption(1, "tipo 1"));


		return elementos;
	}

}
