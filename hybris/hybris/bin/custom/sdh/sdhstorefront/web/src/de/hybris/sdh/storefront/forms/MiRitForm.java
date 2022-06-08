/**
 *
 */
package de.hybris.sdh.storefront.forms;

import de.hybris.sdh.core.pojos.responses.ContribAgente;
import de.hybris.sdh.core.pojos.responses.ContribDireccion;
import de.hybris.sdh.core.pojos.responses.ContribRedSocial;
import de.hybris.sdh.core.pojos.responses.ContribTelefono;
import de.hybris.sdh.core.pojos.responses.DetalleActivEconomicas;
import de.hybris.sdh.core.pojos.responses.ImpuestoDelineacionUrbana;
import de.hybris.sdh.core.pojos.responses.ImpuestoGasolina;
import de.hybris.sdh.core.pojos.responses.ImpuestoICA;
import de.hybris.sdh.core.pojos.responses.ImpuestoPublicidadExterior;
import de.hybris.sdh.core.pojos.responses.ImpuestoVehiculos;
import de.hybris.sdh.core.pojos.responses.PredialResponse;

import java.util.List;


/**
 * @author hybris
 *
 */
public class MiRitForm
{

	private String numBP;
	private String tipoDoc;
	private String numDoc;
	private String fchExp;
	private String primNom;
	private String segNom;
	private String primApe;
	private String segApe;
	private String departExp;
	private String municipio;

	private String tratamiento;
	private String claseIC;
	private String sexo;
	private String nacionalidad;
	private String fechaNacimiento;
	private String lugarNacimiento;
	private String paisOrigen;

	private String email;

	private Boolean hasCORol;
	private Boolean hasAARol;
	private Boolean hasTARol;
	private Boolean hasARRol;
	private Boolean hasRIRol;

	private ContribDireccion direccionNotificacion;
	private ContribDireccion direccionContacto;

	private String telefonoPricipal;
	private String extensionTelefono;

	private Boolean useEmailForNotifications;
	private Boolean useInformationForInstitutionalPurposes;

	private String nombreRazonSocial1;
	private String nombreRazonSocial2;
	private String nombreRazonSocial3;
	private String nombreRazonSocial4;
	private String formaJuridica;
	private String numeroMatriculaMercantil;
	private String fechaLiquidacion;
	private String tipoRetenedor;
	private String digVer;
	private String proceso1pc;

	private List<ImpuestoGasolina> gasolina;
	private List<ImpuestoPublicidadExterior> publicidadExt;
	private List<ContribRedSocial> redsocial;
	private List<ContribAgente> representados;
	private List<ContribAgente> representantes;
	private ImpuestoICA impuestoICA;
	private List<ImpuestoDelineacionUrbana> delineacion;
	private List<ImpuestoVehiculos> vehicular;
	private List<PredialResponse> predial;
	private List<DetalleActivEconomicas> activEconomicas;
	private List<ContribTelefono> telefono;


	//*->INI dev-eduardo ajuste de menu impuestos
	private String bPredial;
	private String bVehicular;
	private String bIca;
	private String bPublicidadExt;
	private String bSobreGasolina;
	private String bDelineacionUrbana;


	/**
	 * @return the delineacion
	 */
	public List<ImpuestoDelineacionUrbana> getDelineacion()
	{
		return delineacion;
	}

	/**
	 * @param delineacion
	 *           the delineacion to set
	 */
	public void setDelineacion(final List<ImpuestoDelineacionUrbana> delineacion)
	{
		this.delineacion = delineacion;
	}


	/**
	 * @return the vehicular
	 */
	public List<ImpuestoVehiculos> getVehicular()
	{
		return vehicular;
	}

	/**
	 * @param vehicular
	 *           the vehicular to set
	 */
	public void setVehicular(final List<ImpuestoVehiculos> vehicular)
	{
		this.vehicular = vehicular;
	}

	/**
	 * @return the impuestoICA
	 */
	public ImpuestoICA getImpuestoICA()
	{
		return impuestoICA;
	}

	/**
	 * @param impuestoICA
	 *           the impuestoICA to set
	 */
	public void setImpuestoICA(final ImpuestoICA impuestoICA)
	{
		this.impuestoICA = impuestoICA;
	}

	/**
	 * @return the bPredial
	 */
	public String getbPredial()
	{
		return bPredial;
	}

	/**
	 * @param bPredial
	 *           the bPredial to set
	 */
	public void setbPredial(final String bPredial)
	{
		this.bPredial = bPredial;
	}

	/**
	 * @return the activEconomicas
	 */
	public List<DetalleActivEconomicas> getActivEconomicas()
	{
		return activEconomicas;
	}

	/**
	 * @param activEconomicas
	 *           the activEconomicas to set
	 */
	public void setActivEconomicas(final List<DetalleActivEconomicas> activEconomicas)
	{
		this.activEconomicas = activEconomicas;
	}

	/**
	 * @return the bVehicular
	 */
	public String getbVehicular()
	{
		return bVehicular;
	}

	/**
	 * @param bVehicular
	 *           the bVehicular to set
	 */
	public void setbVehicular(final String bVehicular)
	{
		this.bVehicular = bVehicular;
	}

	/**
	 * @return the bIca
	 */
	public String getbIca()
	{
		return bIca;
	}

	/**
	 * @param bIca
	 *           the bIca to set
	 */
	public void setbIca(final String bIca)
	{
		this.bIca = bIca;
	}

	/**
	 * @return the bPublicidadExt
	 */
	public String getbPublicidadExt()
	{
		return bPublicidadExt;
	}

	/**
	 * @param bPublicidadExt
	 *           the bPublicidadExt to set
	 */
	public void setbPublicidadExt(final String bPublicidadExt)
	{
		this.bPublicidadExt = bPublicidadExt;
	}

	/**
	 * @return the bSobreGasolina
	 */
	public String getbSobreGasolina()
	{
		return bSobreGasolina;
	}

	/**
	 * @param bSobreGasolina
	 *           the bSobreGasolina to set
	 */
	public void setbSobreGasolina(final String bSobreGasolina)
	{
		this.bSobreGasolina = bSobreGasolina;
	}

	/**
	 * @return the bDelineacionUrbana
	 */
	public String getbDelineacionUrbana()
	{
		return bDelineacionUrbana;
	}

	/**
	 * @param bDelineacionUrbana
	 *           the bDelineacionUrbana to set
	 */
	public void setbDelineacionUrbana(final String bDelineacionUrbana)
	{
		this.bDelineacionUrbana = bDelineacionUrbana;
	}



	//*->FIN dev-eduardo ajuste de menu impuestos


	/**
	 *
	 */
	public MiRitForm()
	{
		// XXX Auto-generated constructor stub
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
	 * @return the tipoDoc
	 */
	public String getTipoDoc()
	{
		return tipoDoc;
	}

	/**
	 * @param tipoDoc
	 *           the tipoDoc to set
	 */
	public void setTipoDoc(final String tipoDoc)
	{
		this.tipoDoc = tipoDoc;
	}

	/**
	 * @return the fchExp
	 */
	public String getFchExp()
	{
		return fchExp;
	}

	/**
	 * @param fchExp
	 *           the fchExp to set
	 */
	public void setFchExp(final String fchExp)
	{
		this.fchExp = fchExp;
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
	 * @return the departExp
	 */
	public String getDepartExp()
	{
		return departExp;
	}

	/**
	 * @param departExp
	 *           the departExp to set
	 */
	public void setDepartExp(final String departExp)
	{
		this.departExp = departExp;
	}

	/**
	 * @return the municipio
	 */
	public String getMunicipio()
	{
		return municipio;
	}

	/**
	 * @param municipio
	 *           the municipio to set
	 */
	public void setMunicipio(final String municipio)
	{
		this.municipio = municipio;
	}

	/**
	 * @return the numDoc
	 */
	public String getNumDoc()
	{
		return numDoc;
	}

	/**
	 * @param numDoc
	 *           the numDoc to set
	 */
	public void setNumDoc(final String numDoc)
	{
		this.numDoc = numDoc;
	}

	/**
	 * @return the tratamiento
	 */
	public String getTratamiento()
	{
		return tratamiento;
	}

	/**
	 * @param tratamiento
	 *           the tratamiento to set
	 */
	public void setTratamiento(final String tratamiento)
	{
		this.tratamiento = tratamiento;
	}

	/**
	 * @return the claseIC
	 */
	public String getClaseIC()
	{
		return claseIC;
	}

	/**
	 * @param claseIC
	 *           the claseIC to set
	 */
	public void setClaseIC(final String claseIC)
	{
		this.claseIC = claseIC;
	}

	/**
	 * @return the sexo
	 */
	public String getSexo()
	{
		return sexo;
	}

	/**
	 * @param sexo
	 *           the sexo to set
	 */
	public void setSexo(final String sexo)
	{
		this.sexo = sexo;
	}

	/**
	 * @return the nacionalidad
	 */
	public String getNacionalidad()
	{
		return nacionalidad;
	}

	/**
	 * @param nacionalidad
	 *           the nacionalidad to set
	 */
	public void setNacionalidad(final String nacionalidad)
	{
		this.nacionalidad = nacionalidad;
	}

	/**
	 * @return the fechaNacimiento
	 */
	public String getFechaNacimiento()
	{
		return fechaNacimiento;
	}

	/**
	 * @param fechaNacimiento
	 *           the fechaNacimiento to set
	 */
	public void setFechaNacimiento(final String fechaNacimiento)
	{
		this.fechaNacimiento = fechaNacimiento;
	}

	/**
	 * @return the lugarNacimiento
	 */
	public String getLugarNacimiento()
	{
		return lugarNacimiento;
	}

	/**
	 * @param lugarNacimiento
	 *           the lugarNacimiento to set
	 */
	public void setLugarNacimiento(final String lugarNacimiento)
	{
		this.lugarNacimiento = lugarNacimiento;
	}

	/**
	 * @return the paisOrigen
	 */
	public String getPaisOrigen()
	{
		return paisOrigen;
	}

	/**
	 * @param paisOrigen
	 *           the paisOrigen to set
	 */
	public void setPaisOrigen(final String paisOrigen)
	{
		this.paisOrigen = paisOrigen;
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
	 * @return the hasCORol
	 */
	public Boolean getHasCORol()
	{
		return hasCORol;
	}

	/**
	 * @param hasCORol
	 *           the hasCORol to set
	 */
	public void setHasCORol(final Boolean hasCORol)
	{
		this.hasCORol = hasCORol;
	}

	/**
	 * @return the hasAARol
	 */
	public Boolean getHasAARol()
	{
		return hasAARol;
	}

	/**
	 * @param hasAARol
	 *           the hasAARol to set
	 */
	public void setHasAARol(final Boolean hasAARol)
	{
		this.hasAARol = hasAARol;
	}

	/**
	 * @return the hasTARol
	 */
	public Boolean getHasTARol()
	{
		return hasTARol;
	}

	/**
	 * @param hasTARol
	 *           the hasTARol to set
	 */
	public void setHasTARol(final Boolean hasTARol)
	{
		this.hasTARol = hasTARol;
	}

	/**
	 * @return the hasARRol
	 */
	public Boolean getHasARRol()
	{
		return hasARRol;
	}

	/**
	 * @param hasARRol
	 *           the hasARRol to set
	 */
	public void setHasARRol(final Boolean hasARRol)
	{
		this.hasARRol = hasARRol;
	}

	/**
	 * @return the hasRIRol
	 */
	public Boolean getHasRIRol()
	{
		return hasRIRol;
	}

	/**
	 * @param hasRIRol
	 *           the hasRIRol to set
	 */
	public void setHasRIRol(final Boolean hasRIRol)
	{
		this.hasRIRol = hasRIRol;
	}




	/**
	 * @return the direccionNotificacion
	 */
	public ContribDireccion getDireccionNotificacion()
	{
		return direccionNotificacion;
	}

	/**
	 * @param direccionNotificacion
	 *           the direccionNotificacion to set
	 */
	public void setDireccionNotificacion(final ContribDireccion direccionNotificacion)
	{
		this.direccionNotificacion = direccionNotificacion;
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
	 * @return the extensionTelefono
	 */
	public String getExtensionTelefono()
	{
		return extensionTelefono;
	}

	/**
	 * @param extensionTelefono
	 *           the extensionTelefono to set
	 */
	public void setExtensionTelefono(final String extensionTelefono)
	{
		this.extensionTelefono = extensionTelefono;
	}


	/**
	 * @return the telefonoPricipal
	 */
	public String getTelefonoPricipal()
	{
		return telefonoPricipal;
	}

	/**
	 * @param telefonoPricipal
	 *           the telefonoPricipal to set
	 */
	public void setTelefonoPricipal(final String telefonoPricipal)
	{
		this.telefonoPricipal = telefonoPricipal;
	}

	/**
	 * @return the nombreRazonSocial1
	 */
	public String getNombreRazonSocial1()
	{
		return nombreRazonSocial1;
	}

	/**
	 * @param nombreRazonSocial1
	 *           the nombreRazonSocial1 to set
	 */
	public void setNombreRazonSocial1(final String nombreRazonSocial1)
	{
		this.nombreRazonSocial1 = nombreRazonSocial1;
	}

	/**
	 * @return the nombreRazonSocial2
	 */
	public String getNombreRazonSocial2()
	{
		return nombreRazonSocial2;
	}

	/**
	 * @param nombreRazonSocial2
	 *           the nombreRazonSocial2 to set
	 */
	public void setNombreRazonSocial2(final String nombreRazonSocial2)
	{
		this.nombreRazonSocial2 = nombreRazonSocial2;
	}

	/**
	 * @return the nombreRazonSocial3
	 */
	public String getNombreRazonSocial3()
	{
		return nombreRazonSocial3;
	}

	/**
	 * @param nombreRazonSocial3
	 *           the nombreRazonSocial3 to set
	 */
	public void setNombreRazonSocial3(final String nombreRazonSocial3)
	{
		this.nombreRazonSocial3 = nombreRazonSocial3;
	}

	/**
	 * @return the nombreRazonSocial4
	 */
	public String getNombreRazonSocial4()
	{
		return nombreRazonSocial4;
	}

	/**
	 * @param nombreRazonSocial4
	 *           the nombreRazonSocial4 to set
	 */
	public void setNombreRazonSocial4(final String nombreRazonSocial4)
	{
		this.nombreRazonSocial4 = nombreRazonSocial4;
	}

	/**
	 * @return the formaJuridica
	 */
	public String getFormaJuridica()
	{
		return formaJuridica;
	}

	/**
	 * @param formaJuridica
	 *           the formaJuridica to set
	 */
	public void setFormaJuridica(final String formaJuridica)
	{
		this.formaJuridica = formaJuridica;
	}

	/**
	 * @return the numeroMatriculaMercantil
	 */
	public String getNumeroMatriculaMercantil()
	{
		return numeroMatriculaMercantil;
	}

	/**
	 * @param numeroMatriculaMercantil
	 *           the numeroMatriculaMercantil to set
	 */
	public void setNumeroMatriculaMercantil(final String numeroMatriculaMercantil)
	{
		this.numeroMatriculaMercantil = numeroMatriculaMercantil;
	}

	/**
	 * @return the fechaLiquidacion
	 */
	public String getFechaLiquidacion()
	{
		return fechaLiquidacion;
	}

	/**
	 * @param fechaLiquidacion
	 *           the fechaLiquidacion to set
	 */
	public void setFechaLiquidacion(final String fechaLiquidacion)
	{
		this.fechaLiquidacion = fechaLiquidacion;
	}

	/**
	 * @return the tipoRetenedor
	 */
	public String getTipoRetenedor()
	{
		return tipoRetenedor;
	}

	/**
	 * @param tipoRetenedor
	 *           the tipoRetenedor to set
	 */
	public void setTipoRetenedor(final String tipoRetenedor)
	{
		this.tipoRetenedor = tipoRetenedor;
	}

	/**
	 * @return the gasolina
	 */
	public List<ImpuestoGasolina> getGasolina()
	{
		return gasolina;
	}

	/**
	 * @param gasolina
	 *           the gasolina to set
	 */
	public void setGasolina(final List<ImpuestoGasolina> gasolina)
	{
		this.gasolina = gasolina;
	}

	/**
	 * @return the publicidadExt
	 */
	public List<ImpuestoPublicidadExterior> getPublicidadExt()
	{
		return publicidadExt;
	}

	/**
	 * @param publicidadExt
	 *           the publicidadExt to set
	 */
	public void setPublicidadExt(final List<ImpuestoPublicidadExterior> publicidadExt)
	{
		this.publicidadExt = publicidadExt;
	}

	/**
	 * @return the predial
	 */
	public List<PredialResponse> getPredial()
	{
		return predial;
	}

	/**
	 * @param predial
	 *           the predial to set
	 */
	public void setPredial(final List<PredialResponse> predial)
	{
		this.predial = predial;
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
	 * @return the digVer
	 */
	public String getDigVer()
	{
		return digVer;
	}

	/**
	 * @param digVer
	 *           the digVer to set
	 */
	public void setDigVer(final String digVer)
	{
		this.digVer = digVer;
	}

	/**
	 * @return the proceso1pc
	 */
	public String getProceso1pc()
	{
		return proceso1pc;
	}

	/**
	 * @param proceso1pc the proceso1pc to set
	 */
	public void setProceso1pc(String proceso1pc)
	{
		this.proceso1pc = proceso1pc;
	}

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
	 * @return the representantes
	 */
	public List<ContribAgente> getRepresentantes()
	{
		return representantes;
	}

	/**
	 * @param representantes
	 *           the representantes to set
	 */
	public void setRepresentantes(final List<ContribAgente> representantes)
	{
		this.representantes = representantes;
	}

	/**
	 * @return the telefono
	 */
	public List<ContribTelefono> getTelefono()
	{
		return telefono;
	}

	/**
	 * @param telefono the telefono to set
	 */
	public void setTelefono(List<ContribTelefono> telefono)
	{
		this.telefono = telefono;
	}





}
