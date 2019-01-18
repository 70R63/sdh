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
public class DeclaracionGasolinaService
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

	public DeclaracionGasolinaCatalogos prepararCatalogos()
	{

		final DeclaracionGasolinaCatalogos catalogosForm = new DeclaracionGasolinaCatalogos();

		catalogosForm.setAnioGravable(obtenerListaAnioGravable(2019, 1));
		catalogosForm.setPeriodo(obtenerListaPeriodo());
		catalogosForm.setOpcionesUso(obtenerListaOpcionesUso());
		catalogosForm.setClaseProducto(obtenerListaClaseProducto());
		catalogosForm.setPorcentajeAlc(obtenerListaPorcentajeAlc(1, 20));
		catalogosForm.setTipoIdRev(obtenerListaTipoIdRev());
		catalogosForm.setTipoIdDec(obtenerListaTipoIdDec());


		return catalogosForm;
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


	private List<ItemSelectOption> obtenerListaOpcionesUso()
	{

		final List<ItemSelectOption> elementos = new ArrayList<ItemSelectOption>();


		elementos.add(new ItemSelectOption(1, "Declaracion"));
		elementos.add(new ItemSelectOption(2, "Correccion"));
		elementos.add(new ItemSelectOption(3, "Solamente pago"));


		return elementos;
	}

	private List<ItemSelectOption> obtenerListaClaseProducto()
	{

		final List<ItemSelectOption> elementos = new ArrayList<ItemSelectOption>();


		elementos.add(new ItemSelectOption(1, "Gasolina Corriente Basica"));
		elementos.add(new ItemSelectOption(2, "Gasolina Correinte Oxigenada"));
		elementos.add(new ItemSelectOption(3, "Gasolina Extra Basica"));
		elementos.add(new ItemSelectOption(2, "Gasolina Extra Oxigenada"));

		return elementos;
	}

	private List<ItemSelectOption> obtenerListaPorcentajeAlc(final int porcentajeBase, final int maxPorcentaje)
	{

		final List<ItemSelectOption> elementos = new ArrayList<ItemSelectOption>();

		for (int i = porcentajeBase; i <= maxPorcentaje; i++)
		{
			elementos.add(new ItemSelectOption(i, Integer.toString(i)));
		}

		return elementos;
	}


	private List<ItemSelectOption> obtenerListaTipoIdRev()
	{

		final List<ItemSelectOption> elementos = new ArrayList<ItemSelectOption>();

		elementos.add(new ItemSelectOption(1, "CC-Cedula de extranjeria"));


		return elementos;
	}

	private List<ItemSelectOption> obtenerListaTipoIdDec()
	{

		final List<ItemSelectOption> elementos = new ArrayList<ItemSelectOption>();

		elementos.add(new ItemSelectOption(1, "CC-Cedula de extranjeria"));


		return elementos;
	}

}
