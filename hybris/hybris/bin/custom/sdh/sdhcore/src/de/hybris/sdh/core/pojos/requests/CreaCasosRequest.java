/**
 *
 */
package de.hybris.sdh.core.pojos.requests;

import java.util.List;


/**
 * @author Federico Flores Dimas
 *
 */
public class CreaCasosRequest
{
	private List<CreaCasosAtribRequest> atributos;
	private List<CreaCasosArchiRequest> archivos;




	/**
	 * @return the atributos
	 */
	public List<CreaCasosAtribRequest> getAtributos()
	{
		return atributos;
	}

	/**
	 * @param atributos
	 *           the atributos to set
	 */
	public void setAtributos(final List<CreaCasosAtribRequest> atributos)
	{
		this.atributos = atributos;
	}

	/**
	 * @return the archivos
	 */
	public List<CreaCasosArchiRequest> getArchivos()
	{
		return archivos;
	}

	/**
	 * @param archivos
	 *           the archivos to set
	 */
	public void setArchivos(final List<CreaCasosArchiRequest> archivos)
	{
		this.archivos = archivos;
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

		if (this.getAtributos() != null || this.getArchivos() != null)
		{
			{
				stringBuilder.append("{");
				stringBuilder.append("\"parametros\":");
				stringBuilder.append("[");
				if (this.getAtributos() != null)
				{
					stringBuilder.append(this.preparaAtributos());
				}
				if (this.getArchivos() != null)
				{
					if (this.getArchivos().size() > 0)
					{
						stringBuilder.append(",{");
						stringBuilder.append(this.preparaArchivos("\"archivos\":"));
						stringBuilder.append("}");
					}
				}
				stringBuilder.append("]");
				stringBuilder.append("}");
			}
		}



		return stringBuilder.toString();
	}

	private String preparaAtributos()
	{
		final StringBuilder stringBuilder = new StringBuilder();
		CreaCasosAtribRequest infoAtrib;
		String valorRetorno = "";


		if (this.getAtributos() != null)
		{
			for (int i = 0; i < this.getAtributos().size() - 1; i++)
			{
				infoAtrib = this.getAtributos().get(i);
				stringBuilder.append(infoAtrib.toString());
				stringBuilder.append(",");
			}
			infoAtrib = this.getAtributos().get(this.getAtributos().size() - 1);
			stringBuilder.append(infoAtrib.toString());
		}

		if (stringBuilder.toString() != null)
		{
			valorRetorno = stringBuilder.toString();
		}

		return valorRetorno;
	}

	private String preparaArchivos(final String nombreSegmento)
	{
		final StringBuilder stringBuilder = new StringBuilder();
		CreaCasosArchiRequest infoArchivos;
		String valorRetorno = "";


		if (this.getArchivos() != null && this.getArchivos().size() > 0)
		{
			stringBuilder.append("[");
			for (int i = 0; i < this.getArchivos().size() - 1; i++)
			{
				infoArchivos = this.getArchivos().get(i);

				stringBuilder.append(infoArchivos.toString());
				stringBuilder.append(",");
			}
			infoArchivos = this.getArchivos().get(this.getArchivos().size() - 1);

			stringBuilder.append(infoArchivos.toString());
			stringBuilder.append("]");
		}

		if (stringBuilder.toString() != null)
		{
			valorRetorno = nombreSegmento + stringBuilder.toString();
		}

		return valorRetorno;
	}

}
