/**
 *
 */
package de.hybris.sdh.core.pojos.requests;

import de.hybris.sdh.core.pojos.responses.ContribDireccion;
import de.hybris.sdh.core.pojos.responses.ContribRedSocial;

import java.util.List;


/**
 * @author hybris
 *
 */
public class UpdateRitRequest
{
	private String numBP;
	private String email;
	private Boolean useEmailForNotifications;
	private Boolean useInformationForInstitutionalPurposes;
	private String autoBuzonDate;

	private String primNom;
	private String segNom;
	private String primApe;
	private String segApe;

	private List<ContribRedSocial> redsocial;

	private ContribDireccion direccionContacto;
	private ContribDireccion direccionNoficacion;

	private String telfonoPrincipal;
	private String extension;

	/**
	 * @return the email
	 */
	public String getEmail()
	{
		return email;
	}

	/**
	 * @param email
	 *           the email to set
	 */
	public void setEmail(final String email)
	{
		this.email = email;
	}

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
	 * @return the useEmailForNotifications
	 */
	public Boolean getUseEmailForNotifications()
	{
		return useEmailForNotifications;
	}

	/**
	 * @param useEmailForNotifications
	 *           the useEmailForNotifications to set
	 */
	public void setUseEmailForNotifications(final Boolean useEmailForNotifications)
	{
		this.useEmailForNotifications = useEmailForNotifications;
	}

	/**
	 * @return the useInformationForInstitutionalPurposes
	 */
	public Boolean getUseInformationForInstitutionalPurposes()
	{
		return useInformationForInstitutionalPurposes;
	}

	/**
	 * @param useInformationForInstitutionalPurposes
	 *           the useInformationForInstitutionalPurposes to set
	 */
	public void setUseInformationForInstitutionalPurposes(final Boolean useInformationForInstitutionalPurposes)
	{
		this.useInformationForInstitutionalPurposes = useInformationForInstitutionalPurposes;
	}

	/**
	 * @return the autoBuzonDate
	 */
	public String getAutoBuzonDate()
	{
		return autoBuzonDate;
	}

	/**
	 * @param autoBuzonDate
	 *           the autoBuzonDate to set
	 */
	public void setAutoBuzonDate(final String autoBuzonDate)
	{
		this.autoBuzonDate = autoBuzonDate;
	}



	/**
	 * @return the primNom
	 */
	public String getPrimNom()
	{
		return primNom;
	}

	/**
	 * @param primNom
	 *           the primNom to set
	 */
	public void setPrimNom(final String primNom)
	{
		this.primNom = primNom;
	}

	/**
	 * @return the segNom
	 */
	public String getSegNom()
	{
		return segNom;
	}

	/**
	 * @param segNom
	 *           the segNom to set
	 */
	public void setSegNom(final String segNom)
	{
		this.segNom = segNom;
	}

	/**
	 * @return the primApe
	 */
	public String getPrimApe()
	{
		return primApe;
	}

	/**
	 * @param primApe
	 *           the primApe to set
	 */
	public void setPrimApe(final String primApe)
	{
		this.primApe = primApe;
	}

	/**
	 * @return the segApe
	 */
	public String getSegApe()
	{
		return segApe;
	}

	/**
	 * @param segApe
	 *           the segApe to set
	 */
	public void setSegApe(final String segApe)
	{
		this.segApe = segApe;
	}




	/**
	 * @return the redsocial
	 */
	public List<ContribRedSocial> getRedsocial()
	{
		return redsocial;
	}

	/**
	 * @param redsocial
	 *           the redsocial to set
	 */
	public void setRedsocial(final List<ContribRedSocial> redsocial)
	{
		this.redsocial = redsocial;
	}

	@Override
	public String toString()
	{
		final StringBuilder stringBuilder = new StringBuilder();

		stringBuilder.append("{");
		stringBuilder.append("\"numBP\":\"" + this.getNumBP() + "\",");
		stringBuilder.append("\"personal\": {");
		stringBuilder.append("\"primNom\":\"" + this.getPrimNom() + "\",");
		stringBuilder.append("\"segNom\":\"" + this.getSegNom() + "\",");
		stringBuilder.append("\"primApe\":\"" + this.getPrimApe() + "\",");
		stringBuilder.append("\"segApe\":\"" + this.getSegApe() + "\",");
		stringBuilder.append("\"SMTP_ADDR\":\"" + this.getEmail() + "\",");
		stringBuilder.append("\"ZZAUTOUSOINF\":\""
				+ String.valueOf((Boolean.TRUE.equals(this.getUseInformationForInstitutionalPurposes()) ? 1 : 2)) + "\",");
		stringBuilder.append("\"ZZFECHAAUTOB\":\""
				+ String.valueOf((Boolean.TRUE.equals(this.getUseEmailForNotifications()) ? this.getAutoBuzonDate() : 0)) + "\",");
		stringBuilder.append(
				"\"ZZAUTOBUZONE\":\"" + String.valueOf((Boolean.TRUE.equals(this.getUseEmailForNotifications()) ? 1 : 2)) + "\"");
		stringBuilder.append("               },");
		stringBuilder.append("\"redsocial\": [");

		for (final ContribRedSocial eachRS : this.getRedsocial())
		{
			stringBuilder.append("{\"RED_SOCIAL\":\"" + eachRS.getRED_SOCIAL() + "\",");
			stringBuilder.append("\"USUARIORED\":\"" + eachRS.getUSUARIORED() + "\"},");
		}

		if (",".equals(stringBuilder.substring(stringBuilder.length() - 1)))
		{
			stringBuilder.delete(stringBuilder.length() - 1, stringBuilder.length());
		}

		stringBuilder.append("               ]");
		stringBuilder.append("}");
		// XXX Auto-generated method stub
		return stringBuilder.toString();
	}

	/**
	 * @return the direccionContacto
	 */
	public ContribDireccion getDireccionContacto()
	{
		return direccionContacto;
	}

	/**
	 * @param direccionContacto
	 *           the direccionContacto to set
	 */
	public void setDireccionContacto(final ContribDireccion direccionContacto)
	{
		this.direccionContacto = direccionContacto;
	}

	/**
	 * @return the direccionNoficacion
	 */
	public ContribDireccion getDireccionNoficacion()
	{
		return direccionNoficacion;
	}

	/**
	 * @param direccionNoficacion
	 *           the direccionNoficacion to set
	 */
	public void setDireccionNoficacion(final ContribDireccion direccionNoficacion)
	{
		this.direccionNoficacion = direccionNoficacion;
	}

	/**
	 * @return the telfonoPrincipal
	 */
	public String getTelfonoPrincipal()
	{
		return telfonoPrincipal;
	}

	/**
	 * @param telfonoPrincipal
	 *           the telfonoPrincipal to set
	 */
	public void setTelfonoPrincipal(final String telfonoPrincipal)
	{
		this.telfonoPrincipal = telfonoPrincipal;
	}

	/**
	 * @return the extension
	 */
	public String getExtension()
	{
		return extension;
	}

	/**
	 * @param extension
	 *           the extension to set
	 */
	public void setExtension(final String extension)
	{
		this.extension = extension;
	}



}
