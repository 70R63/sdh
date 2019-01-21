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

	/**
	 * @return
	 */
	public List<SobreTasaGasolinaTabla> prepararTablaDeclaracion()
	{

		final List<SobreTasaGasolinaTabla> gasolinaTabla = new ArrayList<SobreTasaGasolinaTabla>();

		for (int i = 1; i < 20; i++)
		{
			gasolinaTabla.add(new SobreTasaGasolinaTabla("NIT" + Integer.toString(i), Integer.toString(i)));
		}


		return gasolinaTabla;

	}

	/**
	 * @param bpMarcado
	 * @return
	 */
	public SobreTasaGasolinaForm prepararInfoBP(final String bpMarcado, final String info)
	{

		final SobreTasaGasolinaForm dataForm = new SobreTasaGasolinaForm();

		//datos en el formulario
		final List<ItemSelectOption> listaCalidadResponsable = new ArrayList<ItemSelectOption>();
		String numeroTanques;
		String capaciadAlmacProd;
		String capaciadAlmacTanques;
		String ubicacionPlantaAbasto;
		final List<ItemSelectOption> listaCodigoPostal = new ArrayList<ItemSelectOption>();
		final List<ItemSelectOption> listaLocalidad = new ArrayList<ItemSelectOption>();
		final List<ItemSelectOption> listaTipoId = new ArrayList<ItemSelectOption>();
		String numeroId;
		String nombre;
		final List<ItemSelectOption> listaTipoRelacion = new ArrayList<ItemSelectOption>();
		String fechaDesde;
		final String fechaHasta;
		final List<ItemSelectOption> listaFuenteDato = new ArrayList<ItemSelectOption>();
		final RepresentanteSGasolina representante = new RepresentanteSGasolina();
		final List<RepresentanteSGasolina> listaRepresentantes = new ArrayList<RepresentanteSGasolina>();


		//Obtener los valores
		listaCalidadResponsable.add(new ItemSelectOption(1, "Productor"));
		numeroTanques = "10";
		capaciadAlmacProd = "100";
		capaciadAlmacTanques = "1000";
		ubicacionPlantaAbasto = "10000";
		listaCodigoPostal.add(new ItemSelectOption(1, "110111"));
		listaLocalidad.add(new ItemSelectOption(1, "Antonio Nariño"));
		listaTipoId.add(new ItemSelectOption(1, "Cédula de Ciudadania"));
		numeroId = "12345";
		nombre = "usuario";
		listaTipoRelacion.add(new ItemSelectOption(1, "relacion1"));
		fechaDesde = "01/01/2019";
		fechaHasta = "31/12/2019";
		listaFuenteDato.add(new ItemSelectOption(1, "fuenteDato1"));
		representante.setTipoId(listaTipoId);
		representante.setNumeroId(numeroId);
		representante.setNombre(nombre);
		representante.setTipoRelacion(listaTipoRelacion);
		representante.setFechaDesde(fechaDesde);
		representante.setFechaHasta(fechaHasta);
		representante.setFuenteDato(listaFuenteDato);
		listaRepresentantes.add(representante);


		//Setear los valores
		dataForm.setCalidadResponsable(listaCalidadResponsable);
		dataForm.setNumeroTanques(numeroTanques);
		dataForm.setCapaciadAlmacProd(capaciadAlmacProd);
		dataForm.setCapaciadAlmacTanques(capaciadAlmacTanques);
		dataForm.setUbicacionPlantaAbasto(ubicacionPlantaAbasto);
		dataForm.setCodigoPostal(listaCodigoPostal);
		dataForm.setLocalidad(listaLocalidad);
		dataForm.setRepresentantes(listaRepresentantes);


		// XXX Auto-generated method stub
		return dataForm;
	}


}
