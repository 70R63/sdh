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
	private CreaCasosArchiInfoRequest archivosInfo;




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
	 * @return the archivosInfo
	 */
	public CreaCasosArchiInfoRequest getArchivosInfo()
	{
		return archivosInfo;
	}

	/**
	 * @param archivosInfo
	 *           the archivosInfo to set
	 */
	public void setArchivosInfo(final CreaCasosArchiInfoRequest archivosInfo)
	{
		this.archivosInfo = archivosInfo;
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

		if (this.getAtributos() != null || this.getArchivosInfo() != null)
		{
			{
				stringBuilder.append("{");
				stringBuilder.append("\"parametros\":");
				stringBuilder.append("[");
				if (this.getArchivosInfo() != null)
				{
					if (this.getArchivosInfo().getArchivos() != null)
					{
						if (this.getArchivosInfo().getArchivos().size() > 0)
						{
							//							stringBuilder.append("{");
							stringBuilder.append(this.preparaArchivos());
							//							stringBuilder.append("}");
						}
					}
				}
				if (this.getAtributos() != null)
				{
					if (this.getArchivosInfo() != null)
					{
						stringBuilder.append(",");
					}
					stringBuilder.append(this.preparaAtributos());
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

	private String preparaArchivos()
	{
		final StringBuilder stringBuilder = new StringBuilder();
		//		CreaCasosArchiRequest infoArchivos;
		String valorRetorno = "";


		if (this.getArchivosInfo() != null && this.getArchivosInfo().getArchivos() != null
				&& this.getArchivosInfo().getArchivos().size() > 0)
		{
			for (int i = 0; i <= this.getArchivosInfo().getArchivos().size() - 1; i++)
			{
				stringBuilder.append("{");
				stringBuilder.append("\"linea\":\"" + this.getArchivosInfo().getLinea() + "\",");
				stringBuilder.append("\"identificador\":\"" + this.getArchivosInfo().getIdentificador() + "\",");
				stringBuilder.append("\"valor\":\"" + this.getArchivosInfo().getValor() + "\",");

				stringBuilder.append("\"archivos\":");
				stringBuilder.append("[");
				//				infoArchivos = this.getArchivosInfo().getArchivos().get(i);

				//				stringBuilder.append(infoArchivos.toString());
				stringBuilder.append(this.getArchivosInfo().getArchivos().get(i));
				stringBuilder.append("]");
				stringBuilder.append("}");
				if (i < this.getArchivosInfo().getArchivos().size() - 1)
				{
					stringBuilder.append(",");
				}
			}
			//			infoArchivos = this.getArchivosInfo().getArchivos().get(this.getArchivosInfo().getArchivos().size() - 1);

			//		stringBuilder.append(infoArchivos.toString());
			//			stringBuilder.append("]");
			//			stringBuilder.append("}");
		}

		if (stringBuilder.toString() != null)
		{
			valorRetorno = stringBuilder.toString();
		}

		return valorRetorno;
	}

}
