/**
 *
 */
package de.hybris.sdh.storefront.forms;

import de.hybris.sdh.core.pojos.responses.ContribDireccion;
import de.hybris.sdh.core.pojos.responses.ContribTelefono;

import java.util.List;


/**
 * @author hybris
 *
 */
public class UpdateRitForm
{
	private String primNom;
	private String segNom;
	private String primApe;
	private String segApe;

	private String telfonoPrincipal;
	private String extension;
	private String pais;
	private String departamento;
	private String munipio;
	private String direccionContacto;
	private String direccionNoficacion;
	private String codigoPostal;
	private String email;
	private String newEmailAddress;
	private String confirmNewEmailAddress;
	private String passoword;
	private String newPassword;
	private String confirmNewPassword;

	private Boolean usoBuzon;
	private Boolean autoUsoInfo;

	private String redsocial;
	private List<ContribDireccion> direccion;
	private List<ContribTelefono> telefono;
	//	private List<ContribRedSocial> redsocial;

	/**
	 * @return the telfonoPrincipas
	 */
	public String getTelfonoPrincipal()
	{
		return telfonoPrincipal;
	}

	/**
	 * @param telfonoPrincipas
	 *           the telfonoPrincipas to set
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

	/**
	 * @return the pais
	 */
	public String getPais()
	{
		return pais;
	}

	/**
	 * @param pais
	 *           the pais to set
	 */
	public void setPais(final String pais)
	{
		this.pais = pais;
	}

	/**
	 * @return the departamento
	 */
	public String getDepartamento()
	{
		return departamento;
	}

	/**
	 * @param departamento
	 *           the departamento to set
	 */
	public void setDepartamento(final String departamento)
	{
		this.departamento = departamento;
	}

	/**
	 * @return the munipio
	 */
	public String getMunipio()
	{
		return munipio;
	}

	/**
	 * @param munipio
	 *           the munipio to set
	 */
	public void setMunipio(final String munipio)
	{
		this.munipio = munipio;
	}




	/**
	 * @return the direccionContacto
	 */
	public String getDireccionContacto()
	{
		return direccionContacto;
	}

	/**
	 * @param direccionContacto the direccionContacto to set
	 */
	public void setDireccionContacto(final String direccionContacto)
	{
		this.direccionContacto = direccionContacto;
	}

	/**
	 * @return the direccionNoficacion
	 */
	public String getDireccionNoficacion()
	{
		return direccionNoficacion;
	}

	/**
	 * @param direccionNoficacion the direccionNoficacion to set
	 */
	public void setDireccionNoficacion(final String direccionNoficacion)
	{
		this.direccionNoficacion = direccionNoficacion;
	}

	/**
	 * @return the codigoPostal
	 */
	public String getCodigoPostal()
	{
		return codigoPostal;
	}

	/**
	 * @param codigoPostal
	 *           the codigoPostal to set
	 */
	public void setCodigoPostal(final String codigoPostal)
	{
		this.codigoPostal = codigoPostal;
	}

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
	 * @return the newEmailAddress
	 */
	public String getNewEmailAddress()
	{
		return newEmailAddress;
	}

	/**
	 * @param newEmailAddress
	 *           the newEmailAddress to set
	 */
	public void setNewEmailAddress(final String newEmailAddress)
	{
		this.newEmailAddress = newEmailAddress;
	}

	/**
	 * @return the confirmNewEmailAddress
	 */
	public String getConfirmNewEmailAddress()
	{
		return confirmNewEmailAddress;
	}

	/**
	 * @param confirmNewEmailAddress
	 *           the confirmNewEmailAddress to set
	 */
	public void setConfirmNewEmailAddress(final String confirmNewEmailAddress)
	{
		this.confirmNewEmailAddress = confirmNewEmailAddress;
	}

	/**
	 * @return the passoword
	 */
	public String getPassoword()
	{
		return passoword;
	}

	/**
	 * @param passoword
	 *           the passoword to set
	 */
	public void setPassoword(final String passoword)
	{
		this.passoword = passoword;
	}

	/**
	 * @return the newPassword
	 */
	public String getNewPassword()
	{
		return newPassword;
	}

	/**
	 * @param newPassword
	 *           the newPassword to set
	 */
	public void setNewPassword(final String newPassword)
	{
		this.newPassword = newPassword;
	}

	/**
	 * @return the confirmNewPassword
	 */
	public String getConfirmNewPassword()
	{
		return confirmNewPassword;
	}

	/**
	 * @param confirmNewPassword
	 *           the confirmNewPassword to set
	 */
	public void setConfirmNewPassword(final String confirmNewPassword)
	{
		this.confirmNewPassword = confirmNewPassword;
	}

	/**
	 * @return the usoBuzon
	 */
	public Boolean getUsoBuzon()
	{
		return usoBuzon;
	}

	/**
	 * @param usoBuzon
	 *           the usoBuzon to set
	 */
	public void setUsoBuzon(final Boolean usoBuzon)
	{
		this.usoBuzon = usoBuzon;
	}

	/**
	 * @return the autoUsoInfo
	 */
	public Boolean getAutoUsoInfo()
	{
		return autoUsoInfo;
	}

	/**
	 * @param autoUsoInfo
	 *           the autoUsoInfo to set
	 */
	public void setAutoUsoInfo(final Boolean autoUsoInfo)
	{
		this.autoUsoInfo = autoUsoInfo;
	}

	/**
	 * @return the redsocial
	 */
	//	public List<ContribRedSocial> getRedsocial()
	//	{
	//		return redsocial;
	//	}

	/**
	 * @param redsocial
	 *           the redsocial to set
	 */
	//	public void setRedsocial(final List<ContribRedSocial> redsocial)
	//	{
	//		this.redsocial = redsocial;
	//	}

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
	 * @return the direccion
	 */
	public List<ContribDireccion> getDireccion()
	{
		return direccion;
	}

	/**
	 * @param direccion
	 *           the direccion to set
	 */
	public void setDireccion(final List<ContribDireccion> direccion)
	{
		this.direccion = direccion;
	}

	/**
	 * @return the telefono
	 */
	public List<ContribTelefono> getTelefono()
	{
		return telefono;
	}

	/**
	 * @param telefono
	 *           the telefono to set
	 */
	public void setTelefono(final List<ContribTelefono> telefono)
	{
		this.telefono = telefono;
	}

	/**
	 * @return the redsocial
	 */
	public String getRedsocial()
	{
		return redsocial;
	}

	/**
	 * @param redsocial
	 *           the redsocial to set
	 */
	public void setRedsocial(final String redsocial)
	{
		this.redsocial = redsocial;
	}




}
