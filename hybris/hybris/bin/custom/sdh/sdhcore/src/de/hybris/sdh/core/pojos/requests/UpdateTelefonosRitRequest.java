/**
 *
 */
package de.hybris.sdh.core.pojos.requests;

import de.hybris.sdh.core.pojos.responses.ContribTelefono;

import java.util.List;

import org.apache.commons.lang3.StringUtils;


/**
 * @author hybris
 *
 */
public class UpdateTelefonosRitRequest
{
	private String numBP;
	private List<ContribTelefono> telefonos;



	/**
	 * @return the numBP
	 */
	public String getNumBP()
	{
		return numBP;
	}

	/**
	 * @param numBP
	 *           the numBP to set
	 */
	public void setNumBP(final String numBP)
	{
		this.numBP = numBP;
	}

	/**
	 * @return the telefonos
	 */
	public List<ContribTelefono> getTelefonos()
	{
		return telefonos;
	}

	/**
	 * @param telefonos
	 *           the telefonos to set
	 */
	public void setTelefonos(final List<ContribTelefono> telefonos)
	{
		this.telefonos = telefonos;
	}


	@Override
	public String toString()
	{
		final StringBuilder stringBuilder = new StringBuilder();
		ContribTelefono telefono_tmp = null;

		stringBuilder.append("{");
		stringBuilder.append("\"numBP\":\"" + this.getNumBP() + "\",");

		stringBuilder.append("\"telefonos\": [");

		if (telefonos != null)
		{
			if (telefonos.size() > 1)
			{
				for (int i = 0; i < telefonos.size() - 1; i++)
				{
					telefono_tmp = telefonos.get(i);
					if (telefono_tmp != null)
					{
						stringBuilder.append("{");
						stringBuilder.append("\"TEL_TIPO\": \""
								+ ((StringUtils.isBlank(telefono_tmp.getTEL_TIPO())) ? "" : telefono_tmp.getTEL_TIPO()) + "\",");
						stringBuilder.append("\"TEL_NUMBER\": \""
								+ ((StringUtils.isBlank(telefono_tmp.getTEL_NUMBER())) ? "" : telefono_tmp.getTEL_NUMBER()) + "\",");
						stringBuilder.append("\"TEL_EXTENS\": \""
								+ ((StringUtils.isBlank(telefono_tmp.getTEL_EXTENS())) ? "" : telefono_tmp.getTEL_EXTENS()) + "\",");
						stringBuilder.append("\"MOB_NUMBER\": \"\"");
						stringBuilder.append("}");
						stringBuilder.append(",");
					}
				}
			}
			if (telefonos.size() > 0)
			{
				telefono_tmp = telefonos.get(telefonos.size() - 1);
				stringBuilder.append("{");
				stringBuilder.append("\"TEL_TIPO\": \""
						+ ((StringUtils.isBlank(telefono_tmp.getTEL_TIPO())) ? "" : telefono_tmp.getTEL_TIPO()) + "\",");
				stringBuilder.append("\"TEL_NUMBER\": \""
						+ ((StringUtils.isBlank(telefono_tmp.getTEL_NUMBER())) ? "" : telefono_tmp.getTEL_NUMBER()) + "\",");
				stringBuilder.append("\"TEL_EXTENS\": \""
						+ ((StringUtils.isBlank(telefono_tmp.getTEL_EXTENS())) ? "" : telefono_tmp.getTEL_EXTENS()) + "\",");
				stringBuilder.append("\"MOB_NUMBER\": \"\"");
				stringBuilder.append("}");
			}
		}

		stringBuilder.append("]");


		stringBuilder.append("}");
		return stringBuilder.toString();
	}


}
