ACC.mirit = {

		 _autoload: ["bindUpdateNombreButton","bindUpdateNotificationAddressButton","bindUpdateContactAddressButton","bindUpdateTelefonoButton","bindUpdateRedesSocialesButton","bindUpdateAutorizacionesButton","bindUpdatePasswordButton", "bindUpdateEmailButton", "bindCertifNombButton","bindDialog","bindUpdateRitButton","bindAddressData","bindAddSocialNetworkRowButton", "bindTermnsandConditions","bindTermnsandConditionsRegister", "bindActEco" ],
		 

	
		 bindUpdateNombreButton: function () {
		        $(document).on("click", "#updateNombreButton", function (e) {
		    	        e.preventDefault();
						
						
						ACC.spinner.show();

		    	        
		    	        var updateNombreData = {};
		    	        
		    	        
		    	        updateNombreData.name1 = $.trim( $("#primNom").val());
		    	        updateNombreData.name2 =  $.trim($("#segNom").val());
		    	        updateNombreData.apellido1 =  $.trim($("#primApe").val());
		    	        updateNombreData.apellido2 =  $.trim($("#segApe").val());
		    	        
	        
			   	        $.ajax({
			   	            url: ACC.updateNombreRitURL,
			   	            data: updateNombreData,
			   	            type: "POST",
			   	            success: function (data) {
									ACC.spinner.close();
			        	        	$( "#dialog" ).dialog( "open" );
			        	        	if(data.ritUpdated==true)
			        	        	{
			        	        		$("#ritDialogContent").html("");
				    	            	$("#ritDialogContent").html("Tu nombre ha sido actualizado.");
			        	        	}else
			        	        	{
			        	        		$("#ritDialogContent").html("");
				    	            	$("#ritDialogContent").html("Tu nombre no ha sido actualizado.");
			        	        	}
			    	            	
			   	            },
			   	            error: function () {
				$("#cargandoSpinner").html();
				spinnerdiv.style.display = 'none';
			   	            	$( "#dialog" ).dialog( "open" );
			    	            	$("#ritDialogContent").html("");
			   	            	$("#ritDialogContent").html("Hubo un error al tratar de actualizar tu RIT, por favor inténtalo más tarde.");
			   	            }
			   	        });
		        });
		   },
		 
		 bindUpdateNotificationAddressButton: function () {
		        $(document).on("click", "#updateNotificationAddressButton", function (e) {
		    	        e.preventDefault();

		    	  ACC.spinner.show();
		    	        var direccionNotificacion = {};
		    	        
		    	        direccionNotificacion.ADR_KIND = "02";
		    	        direccionNotificacion.COUNTRY  = $.trim($("#countryDireccionNotificacion").val());
		    	        
		    	        if($("#countryDireccionNotificacion").val()=="CO")
			        	{
		    	        	direccionNotificacion.STREET = $.trim($("#direccionNotificacionStreet").val());
		    	        	direccionNotificacion.STR_SUPPL1 = $.trim($("#direccionNotificacionSuppl1").val());
		    	        	direccionNotificacion.STR_SUPPL2 = $.trim($("#direccionNotificacionSuppl2").val());
		    	        	direccionNotificacion.POST_CODE1 = $.trim($("#postalCodeDireccionNotificacion").val());
		    	        	direccionNotificacion.REGION = $.trim($("#deparmentDireccionNotificacion").val());
		    	        	direccionNotificacion.CITY1   =$.trim( $("#municipioDireccionNotificacion").val())
			        	}else
		        		{
			        		direccionNotificacion.STREET = $.trim($("#direccionNotificacion").val());
		        		}
		    	        
		    	        var addressData = {};
		    	        addressData.address = JSON.stringify(direccionNotificacion);
						
	        
			   	        $.ajax({
			   	            url: ACC.updateAddressRitURL,
			   	            data: addressData,
			   	            type: "POST",
			   	            success: function (data) {
									ACC.spinner.close();
			        	        	$( "#dialog" ).dialog( "open" );
			        	        	if(data.ritUpdated==true)
			        	        	{
			        	        		$("#ritDialogContent").html("");
				    	            	$("#ritDialogContent").html("Tu dirección de notificación ha sido actualizada.");
			        	        	}else
			        	        	{
			        	        		$("#ritDialogContent").html("");
				    	            	$("#ritDialogContent").html("Tu dirección de notificación no ha sido actualizada.");
				    	            	$.each(data.errores,function (index, value)
				    	            	{
				    	            		$("#ritDialogContent").html($("#ritDialogContent").html()+"<br>"+value.txtmsj);
				    	            	});
			        	        	}
			    	            	
			   	            },
			   	            error: function () {
								ACC.spinner.close();
			   	            	$( "#dialog" ).dialog( "open" );
			    	            	$("#ritDialogContent").html("");
			   	            	$("#ritDialogContent").html("Hubo un error al tratar de actualizar tu RIT, por favor inténtalo más tarde.");
			   	            }
			   	        });
		        });
		   },
		 
		 bindUpdateContactAddressButton: function () {
		        $(document).on("click", "#updateContactAddressButton", function (e) {
		    	        e.preventDefault();

		    	        ACC.spinner.show();
	    	        
		    	        var direccionContacto = {};
		    	        
		    	        direccionContacto.ADR_KIND = "01";
		    	        direccionContacto.COUNTRY  = $.trim($("#countryDireccionContacto").val());
		    	        
		    	        if($("#countryDireccionContacto").val()=="CO")
			        	{
		    	        	direccionContacto.STREET = $.trim($("#direccionContactoStreet").val());
		    	        	direccionContacto.STR_SUPPL1 = $.trim($("#direccionContactoSuppl1").val());
		    	        	direccionContacto.STR_SUPPL2 = $.trim($("#direccionContactoSuppl2").val());
		    	        	direccionContacto.POST_CODE1 = $.trim($("#postalCodeDireccionContacto").val());
		    	        	direccionContacto.REGION = $.trim($("#deparmentDireccionContacto").val());
		    	        	direccionContacto.CITY1   = $.trim($("#municipioDireccionContacto").val());
			        	}else
		        		{
			        		direccionContacto.STREET = $.trim($("#direccionContacto").val());
		        		}
		    	        
		    	        
		    	        var addressData = {};
		    	        addressData.address = JSON.stringify(direccionContacto);
 	        
		    	        $.ajax({
			   	            url: ACC.updateAddressRitURL,
			   	            data: addressData,
			   	            type: "POST",
			   	            success: function (data) {
									ACC.spinner.close();
			        	        	$( "#dialog" ).dialog( "open" );
			        	        	if(data.ritUpdated==true)
			        	        	{
			        	        		$("#ritDialogContent").html("");
				    	            	$("#ritDialogContent").html("Tu dirección de contacto ha sido actualizada.");
			        	        	}else
			        	        	{
			        	        		$("#ritDialogContent").html("");
				    	            	$("#ritDialogContent").html("Tu dirección de contacto no ha sido actualizada.");
				    	            	$.each(data.errores,function (index, value)
				    	            	{
				    	            		$("#ritDialogContent").html($("#ritDialogContent").html()+"<br>"+value.txtmsj);
				    	            	});
				    	            	
			        	        	}
			    	            	
			   	            },
			   	            error: function () {
								ACC.spinner.close();
			   	            	$( "#dialog" ).dialog( "open" );
			    	            	$("#ritDialogContent").html("");
			   	            	$("#ritDialogContent").html("Hubo un error al tratar de actualizar tu RIT, por favor inténtalo más tarde.");
			   	            }
			   	        });
		        });
		   },
		 
	bindTermnsandConditions: function(){
		$(document).on("click", "#terminosPopUp", function(e) {
 e.preventDefault();
		   var selectRefinementsTitle = "Términos y condiciones";
	        ACC.colorbox.open(selectRefinementsTitle, {
	            href: ".js-terminos-facet",
	            inline: true,
	            width: "90%",
	            onComplete: function () {
	                $(document).on("click", ".js-terminos-facet .js-facet-name-veh", function (e) {
	                    e.preventDefault();
	                    $(".js-terminos-facet  .js-facet-veh").removeClass("active");
	                    $(this).parents(".js-facet-veh").addClass("active");
	                    $.colorbox.resize()
	                })
	            },
	            onClosed: function () {
	                $(document).off("click", ".js-vehicular-facet .js-facet-name-veh");
	            }
	        });
});
	},
	
	terminosAceptar : function(){
    var habcheck = document.getElementById("buzon2");
	var habcheck2 = document.getElementById("buzon3");
		habcheck.style.cursor=="auto";
		habcheck.style.pointer-event=="painted";
		
	
		$("#buzon2").attr("aria-checked", true);
		$("#buzon3").attr("class", "checked");
		$('#buzon').prop('checked', 'checked');
		$.colorbox.close();
		$(document).off("click", ".js-vehicular-facet .js-facet-name-veh");
	},
	
	terminosCancelar : function(){
    $("#buzon2").attr("aria-checked", false);
		$("#buzon3").attr("class", "control-label");
		$('#buzon').prop('checked', '');
		$.colorbox.close();
		$(document).off("click", ".js-vehicular-facet .js-facet-name-veh");
	},
	
	bindTermnsandConditionsRegister: function(){
		$(document).on("click", "#terminosPopUpRegister", function(e) {

 e.preventDefault();

		   var selectRefinementsTitle = "Términos y condiciones";
	        ACC.colorbox.open(selectRefinementsTitle, {
	            href: ".js-terminos-facet",
	            inline: true,
	            width: "90%",
	            onComplete: function () {
	                $(document).on("click", ".js-terminos-facet .js-facet-name-veh", function (e) {
	                    e.preventDefault();
	                    $(".js-terminos-facet  .js-facet-veh").removeClass("active");
	                    $(this).parents(".js-facet-veh").addClass("active");
	                    $.colorbox.resize()
	                })
	            },
	            onClosed: function () {
	                $(document).off("click", ".js-vehicular-facet .js-facet-name-veh");
	            }
	        });

});
	},
	
//	terminosAceptarRegister : function(){
//		
//   var habcheck = document.getElementById("useEmailForNotifications");
//       var parent = habcheck.offsetParent;
//parent.ariaChecked=true;
//parent.attributes[4]=true;
//	var label = parent.lastElementChild;
//	label.attributes[0]="checked";
//	label.className="checked";
//	$.colorbox.close();
//		$(document).off("click", ".js-vehicular-facet .js-facet-name-veh");
//
//	},
	
	terminosCancelarRegister : function(){
       var habcheck = document.getElementById("useEmailForNotifications");
       var parent = habcheck.offsetParent;
parent.ariaChecked=false;
parent.attributes[4]=false;
	var label = parent.lastElementChild;
	label.attributes[0]="control-label";
	label.className="control-label";
	$.colorbox.close();
		$(document).off("click", ".js-vehicular-facet .js-facet-name-veh");
	$('#useEmailForNotifications').prop('checked', '');
	},
	
		terminosRegister : function(){
       var habcheck = document.getElementById("useEmailForNotifications");
       var parent = habcheck.offsetParent;
parent.ariaChecked=true;
parent.attributes[4]=true;
	var label = parent.lastElementChild;
	label.attributes[0]="checked";
	label.className="checked";
	$.colorbox.close();
		$(document).off("click", ".js-vehicular-facet .js-facet-name-veh");
	$('#useEmailForNotifications').prop('checked', 'checked');
	},
	
	terminosAceptarRegisterTwo : function(){
//         var habcheck = document.getElementById("useEmailForNotifications");
//       var parent = habcheck.offsetParent;
//parent.ariaChecked=true;
//parent.attributes[4]=true;
//	var label = parent.lastElementChild;
//	label.attributes[0]="checked";
//	label.className="checked";
//	$.colorbox.close();
//		$(document).off("click", ".js-vehicular-facet .js-facet-name-veh");
	},
	
		 bindUpdateTelefonoButton: function () {
		        $(document).on("click", "#updateTelefonoButton", function (e) {
		    	        e.preventDefault();

		    	        ACC.spinner.show();
	    	        
		    	        var updateTelefonoRitData ={};
		    	        
		    	        updateTelefonoRitData.telfonoPrincipal = $.trim($("#telefonoPricipal").val());
		    	        updateTelefonoRitData.extension = $.trim($("#extensionTelefono").val());
		    	        updateTelefonoRitData.tel_tipo = $.trim($("#phoneSelect").val());
		    	        
    	        
			   	        $.ajax({
			   	            url: ACC.updateTelefonoRitURL,
			   	            data: updateTelefonoRitData,
			   	            type: "POST",
			   	            success: function (data) {
									ACC.spinner.close();
			        	        	$( "#dialog" ).dialog( "open" );
			        	        	if(data.ritUpdated==true)
			        	        	{
			        	        		$("#ritDialogContent").html("");
				    	            	$("#ritDialogContent").html("Tu teléfono ha sido actualizado.");
			        	        	}else
			        	        	{
			        	        		$("#ritDialogContent").html("");
				    	            	$("#ritDialogContent").html("Tu teléfono no ha sido actualizado.");
			        	        	}
			    	            	
			   	            },
			   	            error: function () {
								ACC.spinner.close();
			   	            	$( "#dialog" ).dialog( "open" );
			    	            	$("#ritDialogContent").html("");
			   	            	$("#ritDialogContent").html("Hubo un error al tratar de actualizar tu RIT, por favor inténtalo más tarde.");
			   	            }
			   	        });
		        });
		   },
		 
		 bindUpdateRedesSocialesButton: function () {
		        $(document).on("click", "#updateRedesSocialesButton", function (e) {
		    	        e.preventDefault();   
	        
		    	        ACC.spinner.show();
		    	        var redSocialData = new Array();
		    	        
		    	        var updateRedesSociales = false;
		    	        
		    	        $.each($(".socialNetworkRow"),function(index,value){
		    	        	
		    	        	var redSocial = $(value).find(".redSocial").val();
		    	        	var usuarioRedSocial = $(value).find(".usuarioRedSocial").val();
		    	        	
		    	        	if(redSocial != "" && usuarioRedSocial != "")
		    	        	{
			    	        	var eachSocialNet=new Object();
			    	        	
			    	        	eachSocialNet.RED_SOCIAL = redSocial;
			    	        	eachSocialNet.USUARIORED = usuarioRedSocial;
			    	        	
			    	        	redSocialData.push(eachSocialNet);
			    	        	
			    	        	updateRedesSociales = true;
			    	        	
		    	        	}
		    	        	
		    	        });
		    	        if(updateRedesSociales)
		    	        {
			    	        var updateRedesSocialesData = {};
			    	        
			    	        updateRedesSocialesData.redsocial = JSON.stringify(redSocialData);
	    	        
				   	        $.ajax({
				   	            url: ACC.updateRedesSocialesRitURL,
				   	            data: updateRedesSocialesData,
				   	            type: "POST",
				   	            success: function (data) {
										ACC.spinner.close();
				        	        	$( "#dialog" ).dialog( "open" );
				        	        	if(data.ritUpdated==true)
				        	        	{
				        	        		$("#ritDialogContent").html("");
					    	            	$("#ritDialogContent").html(data.errores[0].txtmsj);
				        	        	}else
				        	        	{
				        	        		$("#ritDialogContent").html("");
					    	            	$("#ritDialogContent").html("Tus redes sociales no han sido actualizadas.");
				        	        	}
				    	            	
				   	            },
				   	            error: function () {
									ACC.spinner.close();
				   	            	$( "#dialog" ).dialog( "open" );
				    	            	$("#ritDialogContent").html("");
				   	            	$("#ritDialogContent").html("Hubo un error al tratar de actualizar tu RIT, por favor inténtalo más tarde.");
				   	            }
				   	        });
		    	        }else
	    	        	{
							ACC.spinner.close();
		    	        	$( "#dialog" ).dialog( "open" );
		    	        	$("#ritDialogContent").html("");
	    	            	$("#ritDialogContent").html("Tus redes sociales no han sido actualizadas.");
	    	        	}
		        });
		   },
		 
		 bindUpdateAutorizacionesButton: function () {
		        $(document).on("click", "#updateAutorizacionesButton", function (e) {
		    	        e.preventDefault();

						ACC.spinner.show();
 						var msgBuzon = document.getElementById("mensaggeBuzon");
						msgBuzon.style.visibility="visible";  
		    	        var updateAutorizacionesData = {};
		    	        updateAutorizacionesData.usoBuzon = $("#buzon").is(":checked");
		    	        updateAutorizacionesData.autoUsoInfo = $("#usoInformacion").is(":checked");
       	        
			   	        $.ajax({
			   	            url: ACC.updateAutorizacionesRitURL,
			   	            data: updateAutorizacionesData,
			   	            type: "POST",
			   	            success: function (data) {
							ACC.spinner.close();
				 			var msgBuzon = document.getElementById("mensaggeBuzon");
							msgBuzon.style.visibility="visible";
			        	        	$( "#dialog" ).dialog( "open" );
			        	        	if(data.ritUpdated==true)
			        	        	{
			        	        		$("#ritDialogContent").html("");
				    	            	$("#ritDialogContent").html("Tus autorizaciones han sido actualizadas.");
			        	        	}else
			        	        	{
			        	        		$("#ritDialogContent").html("");
				    	            	$("#ritDialogContent").html("Tus autorizaciones no han sido actualizadas.");
			        	        	}
			    	            	
			   	            },
			   	            error: function () {
								ACC.spinner.close();
			   	            	$( "#dialog" ).dialog( "open" );
			    	            	$("#ritDialogContent").html("");
			   	            	$("#ritDialogContent").html("Hubo un error al tratar de actualizar tu RIT, por favor inténtalo más tarde.");
			   	            }
			   	        });

		        });
		   },
		 
		 bindUpdatePasswordButton: function () {
		        $(document).on("click", "#updatePasswordButton", function (e) {
		    	        e.preventDefault();

		    	        ACC.spinner.show();
		    	        var currentPassword = $.trim($("#currentPassword").val());
		    	        var newPassword = $.trim($("#newPassword").val());
		    	        var confirmNewPassword = $.trim($("#confirmNewPassword").val());
		    	        
		    	        if(currentPassword == "")
	    	        	{
		    	        	$( "#dialog" ).dialog( "open" );
	    	            	$("#ritDialogContent").html("");
	    	            	$("#ritDialogContent").html("Por favor introduce la contraseña actual");
	    	            	return;
	    	        	}
		    	        
		    	        if(newPassword == "")
	    	        	{
		    	        	$( "#dialog" ).dialog( "open" );
	    	            	$("#ritDialogContent").html("");
	    	            	$("#ritDialogContent").html("Por favor introduce la nueva contraseña");
	    	            	return;
	    	        	}
		    	        
		    	        
		    	        if(confirmNewPassword == "")
	    	        	{
		    	        	$( "#dialog" ).dialog( "open" );
	    	            	$("#ritDialogContent").html("");
	    	            	$("#ritDialogContent").html("Por favor confirma la nueva contraseña");
	    	            	return;
	    	        	}
		    	        
		    	        if(/[a-z]/.test(newPassword) == false || /[A-Z]/.test(newPassword) == false || /[0-9]/.test(newPassword) == false || (newPassword.length <8 || newPassword.length>16))
	    	        	{
		    	        	$( "#dialog" ).dialog( "open" );
	    	            	$("#ritDialogContent").html("");
	    	            	$("#ritDialogContent").html("La contraseña debe tener una letra mayúscula, una minúscula, un número y una longitud entre 8 y 16 caracteres.");
	    	            	return;
	    	        	}
		    	        
		    	        if(currentPassword == newPassword)
	    	        	{
		    	        	$( "#dialog" ).dialog( "open" );
	    	            	$("#ritDialogContent").html("");
	    	            	$("#ritDialogContent").html("La contraseña actual y la nueva contraseña son idénticas.");
	    	            	return;
	    	        	}
	    	        
		    	        if(confirmNewPassword != newPassword)
	    	        	{
		    	        	$( "#dialog" ).dialog( "open" );
	    	            	$("#ritDialogContent").html("");
	    	            	$("#ritDialogContent").html("La nueva contraseña y la confirmación de contraseña son diferentes.");
	    	            	return;
	    	        	}
          	
		    	        var passwordData = {};
	        	        passwordData.passoword = currentPassword;
          	        
          	        $.ajax({
          	            url: ACC.validaCurrentPasswrodURL,
          	            data: passwordData,
          	            type: "POST",
          	            success: function (data) {
							ACC.spinner.close();
          	            	if(data.isValidPassword == true)
      	            		{
	
								ACC.spinner.show();
          	            		var updatePasswordRitData = {};
          	            		updatePasswordRitData.passoword = currentPassword;
          	            		updatePasswordRitData.newPassword = newPassword;
          	            		updatePasswordRitData.confirmNewPassword = confirmNewPassword;
          	            		
          	            		$.ajax({
                      	            url: ACC.updatePasswordRitURL,
                      	            data: updatePasswordRitData,
                      	            type: "POST",
                      	           async: false,
                      	            success: function (data) {
											ACC.spinner.close();
                  	        	        	$( "#dialog" ).dialog( "open" );
                 	    	            	$("#ritDialogContent").html("");
                 	    	            	if(data.ritUpdated==true)
             	    	            		{
                 	    	            		$("#ritDialogContent").html("");
                 		    	            	$("#ritDialogContent").html("Su contraseña ha sido cambiada.");
                 		    	            	$("#currentPassword").val("");
                 		    	            	$("#newPassword").val("");
                 		    	            	$("#confirmNewPassword").val("");
             	    	            		}
                 	    	            	else{
                 	    	            		$("#ritDialogContent").html("");
                 		    	            	$("#ritDialogContent").html("Su contraseña no ha sido cambiada.");
                 	    	            	}
                      	            },
                      	            error: function () {
										ACC.spinner.close();
                      	            	$("#ritDialogContent").html("Hubo un error al tratar de actualizar tu RIT, por favor inténtalo más tarde.");
                      	            }
                      	        });
      	            		}else
          	            	{
								ACC.spinner.close();
      	        	        	$( "#dialog" ).dialog( "open" );
     	    	            	$("#ritDialogContent").html("");
     	    	            	$("#ritDialogContent").html("Contraseña actual incorrecta.");
          	            	}
          	            },
          	            error: function () {
							ACC.spinner.close();
          	            	$( "#dialog" ).dialog( "open" );
 	    	            	$("#ritDialogContent").html("");
          	            	$("#ritDialogContent").html("Hubo un error al tratar de actualizar tu RIT, por favor inténtalo más tarde.");
          	            }
          	        });
		        });
		   },
		 
		 bindUpdateEmailButton: function () {
		        $(document).on("click", "#updateEmailButton", function (e) {
		    	        e.preventDefault();

		    	        ACC.spinner.show(); 
		    	        var email = $.trim($("#currentMail").val());
		    	        var newEmail = $.trim($("#newEmail").val());
		    	        var confirmNewEmail = $.trim($("#confirmNewEmail").val());
		    	        
		    	        
		    	        if(newEmail == "")
	    	        	{
		    	        	$( "#dialog" ).dialog( "open" );
	    	            	$("#ritDialogContent").html("");
	    	            	$("#ritDialogContent").html("Por favor introduce el nuevo correo");
	    	            	return;
	    	        	}
		    	        
		    	        
		    	        if(confirmNewEmail == "")
	    	        	{
		    	        	$( "#dialog" ).dialog( "open" );
	    	            	$("#ritDialogContent").html("");
	    	            	$("#ritDialogContent").html("Por favor confirma el nuevo correo");
	    	            	return;
	    	        	}
		    	        
		    	        if(newEmail == email)
	    	        	{
		    	        	$( "#dialog" ).dialog( "open" );
	    	            	$("#ritDialogContent").html("");
	    	            	$("#ritDialogContent").html("Correo actual y correo nuevo son idénticos.");
	    	            	return;
	    	        	}
		    	        
		    	        var re = /^(([^<>()[\]\\.,;:\s@\"]+(\.[^<>()[\]\\.,;:\s@\"]+)*)|(\".+\"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
	    	        	if(!re.test(String(newEmail).toLowerCase()))
	    	        	{
	    	        		$( "#dialog" ).dialog( "open" );
	    	            	$("#ritDialogContent").html("");
	    	            	$("#ritDialogContent").html("Escribe una dirección de correo electrónico válida");
	    	            	return;
	    	        	}
		    	        
		    	        if(newEmail != confirmNewEmail )
	    	        	{
		    	        	$( "#dialog" ).dialog( "open" );
	    	            	$("#ritDialogContent").html("");
	    	            	$("#ritDialogContent").html("El nuevo correo y la confirmación de correo no coinciden.");
	    	            	return;
	    	        	}
		    	        
		    	        
		        	        	
        	        	var emailData = {};
             	        emailData.mail = confirmNewEmail;
             	        
             	        $.ajax({
             	            url: ACC.validaEmailURL,
             	            data: emailData,
             	            type: "POST",
             	            success: function (data) {
									    	       
             	            	if(data.isValidEmail == true)
         	            		{
             	            		var updateEmailRitData = {};
             	            		updateEmailRitData.email = email;
             	            		updateEmailRitData.newEmailAddress = newEmail;
             	            		updateEmailRitData.confirmNewEmailAddress = confirmNewEmail;
             	            		
             	            		$.ajax({
                         	            url: ACC.updateEmailRitURL,
                         	            data: updateEmailRitData,
                         	            type: "POST",
                         	           async: false,
                         	            success: function (data) {
												ACC.spinner.close();
                     	        	        	$( "#dialog" ).dialog( "open" );
                    	    	            	$("#ritDialogContent").html("");
                    	    	            	$.each(data.errores, function( index, value ) {
                    	    	            		if(value.idmsj != "")
                    	    	            		{
                    	    	            			$("#ritDialogContent").html($("#ritDialogContent").html()+value.txtmsj+"<br>");
                    	    	            		}
                    	    	            	});
                         	            },
                         	            error: function () {
											ACC.spinner.close();
                         	            	$("#ritDialogContent").html("Hubo un error al tratar de actualizar tu RIT, por favor inténtalo más tarde.");
                         	            }
                         	        });
         	            		}else
             	            	{
									ACC.spinner.close();
         	        	        	$( "#dialog" ).dialog( "open" );
        	    	            	$("#ritDialogContent").html("");
        	    	            	$("#ritDialogContent").html("Correo no disponible está siendo utilizado por otro usuario, introduzca otro");
             	            	}
             	            },
             	            error: function () {
								ACC.spinner.close();
             	            	$( "#dialog" ).dialog( "open" );
    	    	            	$("#ritDialogContent").html("");
             	            	$("#ritDialogContent").html("Hubo un error al tratar de actualizar tu RIT, por favor inténtalo más tarde.");
             	            }
             	        });
		        });
		   },
		 
		 
		 
		    bindAddressData: function(){
		    	
		    	if ( typeof(countries) == 'undefined' )
		    		return;
		    	
		    	//bind countries data
		    	$('#countryDireccionNotificacion')
		        .find('option')
		        .remove();
		    	
		    	var o = new Option( "SELECCIONAR","");
		    	/// jquerify the DOM object 'o' so we can use the html method
		    	$(o).html("SELECCIONAR");
		    	$("#countryDireccionNotificacion").append(o);
		    	
		    	countries.forEach(function (eachCountry) {
		    	    	var o = new Option( eachCountry.name,eachCountry.isocode);
		    	    	/// jquerify the DOM object 'o' so we can use the html method
		    	    	$(o).html(eachCountry.name);
		    	    	$("#countryDireccionNotificacion").append(o);
		    	});
		    	
		    	$("#countryDireccionNotificacion").val(ACC.addressNotificationCountry);
		    	
		    	
		    	$('#countryDireccionContacto')
		        .find('option')
		        .remove();
		    	
		    	var o = new Option( "SELECCIONAR","");
		    	/// jquerify the DOM object 'o' so we can use the html method
		    	$(o).html("SELECCIONAR");
		    	$("#countryDireccionContacto").append(o);
		    	
		    	countries.forEach(function (eachCountry) {
		    	    	var o = new Option( eachCountry.name,eachCountry.isocode);
		    	    	/// jquerify the DOM object 'o' so we can use the html method
		    	    	$(o).html(eachCountry.name);
		    	    	$("#countryDireccionContacto").append(o);
		    	});
		    	
		    	$("#countryDireccionContacto").val(ACC.addressContactoCountry);
		    	
		    	
		    	var o = new Option( "SELECCIONAR","");
		    	/// jquerify the DOM object 'o' so we can use the html method
		    	$(o).html("SELECCIONAR");
		    	$("#deparmentDireccionNotificacion").append(o);
		    	
		    	departments.forEach(function (eachDep) {
		    	    	var o = new Option( eachDep.name,eachDep.depId);
		    	    	/// jquerify the DOM object 'o' so we can use the html method
		    	    	$(o).html(eachDep.name);
		    	    	$("#deparmentDireccionNotificacion").append(o);
		    	});
		    	
		    	$("#deparmentDireccionNotificacion").val(ACC.addressNotificationDep);
		    	
		    	
		    	var o = new Option( "SELECCIONAR","");
		    	/// jquerify the DOM object 'o' so we can use the html method
		    	$(o).html("SELECCIONAR");
		    	$("#deparmentDireccionContacto").append(o);
		    	
		    	departments.forEach(function (eachDep) {
		    	    	var o = new Option( eachDep.name,eachDep.depId);
		    	    	/// jquerify the DOM object 'o' so we can use the html method
		    	    	$(o).html(eachDep.name);
		    	    	$("#deparmentDireccionContacto").append(o);
		    	});
		    	
		    	$("#deparmentDireccionContacto").val(ACC.addressContactoDep);
		    	
		    	
		    	
		    	
		    	
		    	var o = new Option( "SELECCIONAR","");
		    	/// jquerify the DOM object 'o' so we can use the html method
		    	$(o).html("SELECCIONAR");
		    	$("#municipioDireccionNotificacion").append(o);
		    	
		    	municipios.forEach(function (eachMun) {
		    		if(eachMun.dep == ACC.addressNotificationDep)
		    		{
		    	    	var o = new Option( eachMun.desc,eachMun.desc);
		    	    	/// jquerify the DOM object 'o' so we can use the html method
		    	    	$(o).html(eachMun.desc);
		    	    	$("#municipioDireccionNotificacion").append(o);
		    		}
		    	});
		    	
		    	$("#municipioDireccionNotificacion").val(ACC.addressNotificationMun);
		    	
		    	
		    	var o = new Option( "SELECCIONAR","");
		    	/// jquerify the DOM object 'o' so we can use the html method
		    	$(o).html("SELECCIONAR");
		    	$("#municipioDireccionContacto").append(o);
		    	
		    	municipios.forEach(function (eachMun) {
		    		if(eachMun.dep == ACC.addressContactoDep)
		    		{
		    	    	var o = new Option( eachMun.desc,eachMun.desc);
		    	    	/// jquerify the DOM object 'o' so we can use the html method
		    	    	$(o).html(eachMun.desc);
		    	    	$("#municipioDireccionContacto").append(o);
		    		}
		    	});
		    	
		    	$("#municipioDireccionContacto").val(ACC.addressContactoMun);
		    	
		    	
		    	
		    	
		    	var o = new Option( "SELECCIONAR","");
		    	/// jquerify the DOM object 'o' so we can use the html method
		    	$(o).html("SELECCIONAR");
		    	$("#postalCodeDireccionNotificacion").append(o);
		    	
		    	var munId ="";
		    	
		    	municipios.forEach(function (eachMun){
		    		
		    		if(eachMun.desc == ACC.addressNotificationMun){
		    			munId=eachMun.mun;
		    		}
		    		
		    	});
		    	
		    	cps.forEach(function (eachCP) {
		    		if(eachCP.mun == munId)
		    		{
		    	    	var o = new Option( eachCP.cp,eachCP.cp);
		    	    	/// jquerify the DOM object 'o' so we can use the html method
		    	    	$(o).html(eachCP.cp);
		    	    	$("#postalCodeDireccionNotificacion").append(o);
		    		}
		    	});
		    	
		    	$("#postalCodeDireccionNotificacion").val(ACC.addressNotificationPC);
		    	
		    	
		    	
		    	
		    	
		    	
		    	var o = new Option( "SELECCIONAR","");
		    	/// jquerify the DOM object 'o' so we can use the html method
		    	$(o).html("SELECCIONAR");
		    	$("#postalCodeDireccionContacto").append(o);
		    	
		    	munId ="";
		    	
		    	municipios.forEach(function (eachMun){
		    		
		    		if(eachMun.desc == ACC.addressContactoMun){
		    			munId=eachMun.mun;
		    		}
		    		
		    	});
		    	
		    	
		    	cps.forEach(function (eachCP) {
		    		if(eachCP.mun == munId)
		    		{
		    	    	var o = new Option( eachCP.cp,eachCP.cp);
		    	    	/// jquerify the DOM object 'o' so we can use the html method
		    	    	$(o).html(eachCP.cp);
		    	    	$("#postalCodeDireccionContacto").append(o);
		    		}
		    	});
		    	
		    	$("#postalCodeDireccionContacto").val(ACC.addressContactoPC);
		    	
		    	
		    	
		    	
		    	
		    	
		    	
		    	
		    	$('#countrySelect')
		        .find('option')
		        .remove();
		    	
		    	var o = new Option( "SELECCIONAR","");
		    	/// jquerify the DOM object 'o' so we can use the html method
		    	$(o).html("SELECCIONAR");
		    	$("#countrySelect").append(o);
		    	
		    	countries.forEach(function (eachCountry) {
		    	    	var o = new Option( eachCountry.name,eachCountry.isocode);
		    	    	/// jquerify the DOM object 'o' so we can use the html method
		    	    	$(o).html(eachCountry.name);
		    	    	$("#countrySelect").append(o);
		    	});
		    	
		    	
		    	$("#countrySelect").val("CO");
		    },
		    
		    bindAddSocialNetworkRowButton: function () {
        $(document).on("click", "#addSocialNetworkButton", function (e) {
    	        e.preventDefault();
    	        
    	        if($(".socialNetworkRow").length < 5)
    	        {
    	        	$($(".socialNetworkRow")[0]).parent().append($($(".socialNetworkRow")[0]).clone());
    	        	
    	        	$($(".socialNetworkRow")[0]).parent().children().last().find(".redSocial").val("")
    	        	$($(".socialNetworkRow")[0]).parent().children().last().find(".usuarioRedSocial").val("")
    	        }
    	        
    	    });
        },

    bindCertifNombButton: function () {
    $(document).on("click", "#certifNombButton", function (e) {
	        e.preventDefault();

        	ACC.spinner.show();
	        var data={};

	        data.name1 = $("#primNom").val();
	        data.name2 = $("#segNom").val();
	        data.apellido1 = $("#primApe").val();
	        data.apellido2 = $("#segApe").val();
	        
	        $.ajax({
	            url: ACC.certifNombURL,
	            data: data,
	            type: "POST",
	            async: false,
	            success: function (data) {
					ACC.spinner.close();
	            	$( "#dialog" ).dialog( "open" );
	            	if(data.success==true)
	            	{
	            		$("#ritDialogContent").html("Nombre válido. El nombre quedará actualizado en dar clic en  ACTUALIZAR RIT");
	            	}else
	            	{
	            		$("#ritDialogContent").html("Nombre inválido.<br> El nuevo nombre tiene un porcentaje de "+parseInt(100*data.porcentaje)+"%<br>El porcentaje mínimo necesario para actualizar tu nombre es "+parseInt(100*data.minPercentage)+"%");
	            	}
	            },
	            error: function () {
					ACC.spinner.close();
	            	$("#ritDialogContent").html("No se puede certificar el nombre");
	            }
	        });
	    });
    },
    
    
    bindUpdateRitButton: function () {
        $(document).on("click", "#updateRitButton", function (e) {
    	        e.preventDefault();

    	        ACC.spinner.show();
    	        var updateName = false;
    	        
    	        var hasErrors = false;
    	        
    	        //TODO: Call service to validet wheter we update name or no. Here we asume we can update it
    	        
    	        updateName = true;
    	        
    	        
    	        var newEmail = $.trim($("#newEmail").val());
    	        var confirmNewEmail = $.trim($("#confirmNewEmail").val());
    	        
    	        if(newEmail != "" || confirmNewEmail != "")
    	        {
    	        	//validate new email format
    	        	var re = /^(([^<>()[\]\\.,;:\s@\"]+(\.[^<>()[\]\\.,;:\s@\"]+)*)|(\".+\"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
    	        	if(!re.test(String(newEmail).toLowerCase()))
    	        	{
    	        		$("#newEmailErrors").removeClass("hidden");
        	        	$("#newEmail").parents(".form-group ").addClass("has-error");
        	        	$("#newEmailErrors").html("Indique una dirección de correo electrónico");
        	        	hasErrors = true;
    	        	}else
    	        	{
    	        		$("#newEmailErrors").addClass("hidden");
        	        	$("#newEmail").parents(".form-group ").removeClass("has-error");
        	        	
        	        	 var emailData = {};
             	        emailData.mail = confirmNewEmail;
             	        
             	        $.ajax({
             	            url: ACC.validaEmailURL,
             	            data: emailData,
             	            type: "POST",
             	           async: false,
             	            success: function (data) {
								ACC.spinner.close();
             	            	if(data.isValidEmail == true)
         	            		{
             	            		$("#textCertNom").html("Nuevo Usuario Válido");
         	            		}else
             	            	{
         	            			$("#newEmailErrors").removeClass("hidden");
         	            			$("#newEmailErrors").html("Correo no disponible está siendo utilizado por otro usuario, introduzca otro");
         	        	        	$("#newEmail").parents(".form-group ").addClass("has-error");
         	        	        	hasErrors = true;
             	            	}
             	            },
             	            error: function () {
								ACC.spinner.close();
             	            	$("#textCertNom").html("Hubo un error al tratar de actualizar tu RIT, por favor inténtalo más tarde.");
             	            }
             	        });
    	        	}
    	        	
    	        	if( newEmail != confirmNewEmail)
    	        	{
    	        		$("#confirmNewEmailErrors").removeClass("hidden");
        	        	$("#confirmNewEmail").parents(".form-group ").addClass("has-error");
        	        	$("#confirmNewEmailErrors").html("Correo y confirmación de correo no coinciden.");
        	        	hasErrors = true;
    	        	}else
    	        	{
    	        		{
        	        		$("#confirmNewEmailErrors").addClass("hidden");
            	        	$("#confirmNewEmail").parents(".form-group ").removeClass("has-error");
        	        	}
    	        	}
    	        	
        	       
    	        	
    	       	}else
	       		{
    	       		$("#newEmailErrors").addClass("hidden");
    	        	$("#newEmail").parents(".form-group ").removeClass("has-error");
    	       		
    	       		$("#confirmNewEmailErrors").addClass("hidden");
    	        	$("#confirmNewEmail").parents(".form-group ").removeClass("has-error");
	       		}
    	        
    	        var hasPasswordErrors=false;
    	        
    	        var currentPassword = $.trim($("#currentPassword").val());
    	        var newPassword = $.trim($("#newPassword").val());
    	        var confirmNewPassword = $.trim($("#confirmNewPassword").val());
    	        
    	        if(currentPassword != "" || newPassword != "" || confirmNewPassword !=  "" )
	        	{
    	        	if(currentPassword == "")
	        		{
    	        		$("#currentPasswordErrors").removeClass("hidden");
        	        	$("#currentPassword").parents(".form-group ").addClass("has-error");
        	        	$("#currentPasswordErrors").html("Por favor introduce tu contraseña actual");
        	        	hasPasswordErrors = true;
	        		}else
        			{
	        			$("#currentPasswordErrors").addClass("hidden");
        	        	$("#currentPassword").parents(".form-group ").removeClass("has-error");
        			}
        		
    	        	
    	        	if(/[a-z]/.test(newPassword) == false || /[A-Z]/.test(newPassword) == false || /[0-9]/.test(newPassword) == false || (newPassword.length <8 || newPassword.length>16))
    	        	{
        	        	$("#newPassword").parents(".form-group ").addClass("has-error");
        	        	hasPasswordErrors = true;
    	        	}else
    	        	{
    	        		$("#newPassword").parents(".form-group ").removeClass("has-error");
    	        	}
    	        
    	        	if(newPassword != confirmNewPassword)
    	        	{
    	        		$("#confirmNewPasswordErrors").removeClass("hidden");
        	        	$("#confirmNewPassword").parents(".form-group ").addClass("has-error");
        	        	hasPasswordErrors = true;
    	        	}else
    	        	{
    	        		$("#confirmNewPasswordErrors").addClass("hidden");
        	        	$("#confirmNewPassword").parents(".form-group ").removeClass("has-error");
    	        	}
    	        	
    	        	if (hasPasswordErrors == false)
    	        	{
	    	        	var passwordData = {};
	        	        passwordData.passoword = currentPassword;
	        	        
	    	        	
	        	        $.ajax({
		    	            url: ACC.validaCurrentPasswrodURL,
		    	            data: passwordData,
		    	            type: "POST",
		    	            async: false,
		    	            success: function (data) {
								ACC.spinner.close();
		    	            	if(data.isValidPassword == true)
			            		{
		    	            		$("#currentPasswordErrors").addClass("hidden");
		            	        	$("#currentPassword").parents(".form-group ").removeClass("has-error");
		            	        	
		            	        	  if( currentPassword == newPassword)
		            	        	  {
		            	        		  $("#newPassword").parents(".form-group ").addClass("has-error");
		            	        		  $("#sameOldPasswordError").removeClass("hidden");
		            	        		  hasPasswordErrors = true;
		            	        	  }else
		            	        	  {
		            	        		  $("#newPassword").parents(".form-group ").removeClass("has-error");
		            	        		  $("#sameOldPasswordError").addClass("hidden");
		            	        	  }
		            	        	
		            	        	
			            		}else
		    	            	{
			            			$("#currentPasswordErrors").removeClass("hidden");
			        	        	$("#currentPassword").parents(".form-group ").addClass("has-error");
			        	        	$("#currentPasswordErrors").html("Contraseña actual incorrecta.");
			        	        	hasPasswordErrors = true;
		    	            	}
		    	            },
		    	            error: function () {
								ACC.spinner.close();
		    	            	$("#textCertNom").html("Hubo un error al tratar de actualizar tu RIT, por favor inténtalo más tarde.");
		    	            }
	        	        });
    	        	}
        		
	        } 	
    	        
    	        
    	        var redSocialData = new Array();
    	        
    	        $.each($(".socialNetworkRow"),function(index,value){
    	        	
    	        	var redSocial = $(value).find(".redSocial").val();
    	        	var usuarioRedSocial = $(value).find(".usuarioRedSocial").val();
    	        	
    	        	if(redSocial != "" && usuarioRedSocial != "")
    	        	{
	    	        	var eachSocialNet=new Object();
	    	        	
	    	        	eachSocialNet.RED_SOCIAL = redSocial;
	    	        	eachSocialNet.USUARIORED = usuarioRedSocial;
	    	        	
	    	        	redSocialData.push(eachSocialNet);
    	        	}
    	        	
    	        });
    	        
    	        var updateName= false;
    	        if($("#documentType").val() != "NIT" && $("#documentType").val() != "NITE")
    	        {
    	           if(($.trim($("#primNom").val()) != "" && $.trim($("#primNom").val()) !=  $("#primNom").attr("data-original"))
    	        	||($.trim($("#primApe").val()) != "" && $.trim($("#primApe").val()) !=  $("#primApe").attr("data-original"))	
    	        	||($.trim($("#segNom").val()) !=  $("#segNom").attr("data-original"))
    	        	||($.trim($("#segApe").val()) != "" && $.trim($("#segApe").val()) !=  $("#segApe").attr("data-original")))
    	        	{
        				updateName=true;
    	        	}
    	        }
    	        
    	        
    	        var direccionNotificacion = {};
    	        
    	        direccionNotificacion.ADR_KIND = "02";
	        	 direccionNotificacion.COUNTRY  = $.trim($("#countryDireccionNotificacion").val());
    	        
    	        if($("#countryDireccionNotificacion").val()=="CO")
	        	{
    	        	 direccionNotificacion.STREET = $.trim($("#direccionNotificacionStreet").val());
    	        	 direccionNotificacion.STR_SUPPL1 = $.trim($("#direccionNotificacionSuppl1").val());
	    	        direccionNotificacion.STR_SUPPL2 = $.trim($("#direccionNotificacionSuppl2").val());
	    	        direccionNotificacion.POST_CODE1 = $.trim($("#postalCodeDireccionNotificacion").val());
	    	        direccionNotificacion.REGION = $.trim($("#deparmentDireccionNotificacion").val());
	    	        direccionNotificacion.CITY1   =$.trim( $("#municipioDireccionNotificacion").val())
	        	}else
        		{
	        		direccionNotificacion.STREET = $.trim($("#direccionNotificacion").val());
        		}
    	        
    	        
    	        var direccionContacto = {};
    	        
    	        direccionContacto.ADR_KIND = "01";
    	        direccionContacto.COUNTRY  = $.trim($("#countryDireccionContacto").val());
    	        
    	        if($("#countryDireccionContacto").val()=="CO")
	        	{
    	        	direccionContacto.STREET = $.trim($("#direccionContactoStreet").val());
	    	        direccionContacto.STR_SUPPL1 = $.trim($("#direccionContactoSuppl1").val());
	    	        direccionContacto.STR_SUPPL2 = $.trim($("#direccionContactoSuppl2").val());
	    	        direccionContacto.POST_CODE1 = $.trim($("#postalCodeDireccionContacto").val());
	    	        direccionContacto.REGION = $.trim($("#deparmentDireccionContacto").val());
	    	        direccionContacto.CITY1   = $.trim($("#municipioDireccionContacto").text());
	        	}else
        		{
	        		direccionContacto.STREET = $.trim($("#direccionContacto").val());
        		}
    	        
    	        
    	        
    	        if(hasErrors || hasPasswordErrors)
    	        {
    	        	$( "#dialog" ).dialog( "open" );
    	        	$("#textCertNom").html("Por favor corrige los errores señalados");
    	        }else
    	        {
    	        	 var updateRitData = {};
    	    	        updateRitData.email = $.trim($("#currentMail").val());
    	    	        updateRitData.newEmailAddress =  $.trim($("#newEmail").val());
    	    	        updateRitData.confirmNewEmailAddress =  $.trim($("#confirmNewEmail").val());
    	    	        updateRitData.passoword=currentPassword;
    	    	        updateRitData.newPassword=newPassword;
    	    	        updateRitData.confirmNewPassword=confirmNewPassword;
    	    	        updateRitData.requestUpdateName =  updateName;
    	    	        updateRitData.primNom = $.trim( $("#primNom").val());
    	    	        updateRitData.segNom =  $.trim($("#segNom").val());
    	    	        updateRitData.primApe =  $.trim($("#primApe").val());
    	    	        updateRitData.segApe =  $.trim($("#segApe").val());
    	    	        updateRitData.usoBuzon = $("#buzon").is(":checked");
    	    	        updateRitData.autoUsoInfo = $("#usoInformacion").is(":checked");
    	    	        updateRitData.telfonoPrincipal = $.trim($("#telefonoPricipal").val());
    	    	        updateRitData.extension = $.trim($("#extensionTelefono").val());
    	    	        updateRitData.redsocial =JSON.stringify(redSocialData);
    	    	        updateRitData.direccionNoficacion =JSON.stringify(direccionNotificacion);
    	    	        updateRitData.direccionContacto =JSON.stringify(direccionContacto);
    	    	        
    	    	        $.ajax({
    	    	            url: ACC.updateRitURL,
    	    	            data: updateRitData,
    	    	            type: "POST",
    	    	            dataType : 'json',
    	    	            success: function (data) {
    	    	            	$( "#dialog" ).dialog( "open" );
    	    	            	$("#textCertNom").html("");
    	    	            	$.each(data.errores, function( index, value ) {
    	    	            		if(value.idmsj != "")
    	    	            		{
    	    	            			$("#textCertNom").html($("#textCertNom").html()+value.txtmsj+"<br>");
    	    	            		}
    	    	            		});
    	    	            },
    	    	            error: function () {
    	    	            	$("#textCertNom").html("Hubo un error al tratar de actualizar tu RIT, por favor inténtalo más tarde.");
    	    	            }
    	    	        });
    	        }
    	        
    	        
    	    });
        },
    
    bindDialog: function(){
    	
    	$( "#dialog" ).dialog({ 
    		autoOpen: false, 
    		modal: true,
			 draggable: false,
    		buttons: {
    			Ok: function() {
    				$( this ).dialog( "close" );
    			}
    	    } 
    	});
    	
    },
    

    bindActEco: function(){
    	
		$(document).on("click", "#btnActualizarInfoActEco", function (e) {
    		e.preventDefault();
    		if(ACC.mirit.validarAntesActualizar() == true){
        		ACC.spinner.show();
        		var updateICAActEcoRitForm = {};
        		
        		updateICAActEcoRitForm.activEconomicas = ACC.mirit.obtenerInfo_ActEco();
        		
        		
       				$.ajax({
					url : ACC.actualizaICAActEcoURL,
					data : JSON.stringify(updateICAActEcoRitForm),
					type : "POST",
					dataType: "json",
					contentType: "application/json",
					success : function(dataResponse) {
						ACC.spinner.close();
						$( "#dialog" ).dialog( "open" );
//        	        	if(dataResponse.ritUpdated==true)
//        	        	{
//        	        		$("#ritDialogContent").html("");
//	    	            	$("#ritDialogContent").html("Tu registro de información tributaria ha sido actualizado.");
//        	        	}else
//        	        	{
        	        		$("#ritDialogContent").html("");
//	    	            	$("#ritDialogContent").html("Tu registro de información tributaria no ha sido actualizado.");
	    	            	$.each(dataResponse.errores,function (index, value)
	    	            	{
	    	            		if(value.idmsj != ""){
		    	            		$("#ritDialogContent").html($("#ritDialogContent").html()+"<br>"+value.txtmsj);	    	            			
	    	            		}
	    	            	});
	    	            	
//        	        	}
       				},
					error : function() {
						ACC.spinner.close();
					}
				});
        		
    		}
    		
		});
    	
    },
    
    
    obtenerInfo_ActEco: function(){
    	var registrosTabla = new Array();
    	$("#tabPaginacion5 tbody tr").each(function(index){
        	var registro_leido = {};
    		registro_leido.activPrincipal = "";
    		registro_leido.ciiu = "";
    		registro_leido.denominacion = "";
    		registro_leido.fechaIniAct = "";
    		registro_leido.fechaCeseAct = "";
    		$(this).find('input').each (function() {
    			switch((this).name){
    			case "actPrincipal":
    				if((this).checked == true){
    					registro_leido.activPrincipal = "X";
    				}
    				break;
    			case "codciiu":
    				registro_leido.ciiu = (this).value;
    				break;
    			case "deno":
    				registro_leido.denominacion = (this).value;
    				break;
    			case "fechaIniAct":
    				registro_leido.fechaIniAct = (this).value;
    				break;
    			case "fechaCeseAct":
    				registro_leido.fechaCeseAct = (this).value;
    				break;
    			}
    		});
    		
    		registrosTabla.push(registro_leido);
    	});

    	return registrosTabla;
    },
    
    
    validarAntesActualizar: function(){
    	
    	var flagValidacion = true;
    	var flagValidacion_conteoAEP = ACC.mirit.validar_conteoAEP();
    	var flagValidacion_camposObligatorios = ACC.mirit.validar_camposObligatorios();
    	
    	if(flagValidacion_conteoAEP.value == false || flagValidacion_camposObligatorios.value == false){
			$( "#dialog" ).dialog( "open" );
    		$("#ritDialogContent").html("");
    		$("#ritDialogContent").html(flagValidacion_conteoAEP.mensaje+"<br>"+flagValidacion_camposObligatorios.mensaje);
    		flagValidacion = false;
    	}

    	return flagValidacion;
    },
    
    
    validar_conteoAEP : function(){
    	var flagValidacion = {};
    	flagValidacion.value = true;
    	flagValidacion.mensaje = "";
    	var conteoActPrincipal = 0;
    	
    	$(".actPrincipal").each(function(index){
    		if((this).checked == true){
    			conteoActPrincipal++;
    		}
    	});
    	
    	if(conteoActPrincipal>1){
    		flagValidacion.mensaje = "\n"+"Solamente se puede marcar una actividad económica como principal";
    		flagValidacion.value = false;
    	}
    	
    	return flagValidacion
    },
    
    validar_camposObligatorios : function(){
    	var flagValidacion = {};
    	
    	flagValidacion.value = true;
    	flagValidacion.mensaje = "";
    	flagValidacion.inputcodciuu = ACC.mirit.validar_camposObligatorios_campo(".inputcodciuu");
    	flagValidacion.fechaI = ACC.mirit.validar_camposObligatorios_campo(".fechaI");
    	
    	if(flagValidacion.inputcodciuu == false){
    		flagValidacion.mensaje = flagValidacion.mensaje + "\n"+"Se debe ingresar el código de la actividad";
    	}
    	
    	if(flagValidacion.fechaI == false){
    		flagValidacion.mensaje = flagValidacion.mensaje + "\n"+"Se debe ingresar la fecha de inicio";
    	}
    	
    	if(flagValidacion.inputcodciuu == false || flagValidacion.fechaI == false){
    		flagValidacion.value = false;
    	}
    	
    	return flagValidacion;
    },
    
    validar_camposObligatorios_campo : function(campoBuscar){
    	var flagValidacion = true;
    	
    	$(campoBuscar).each(function(index){
    		if($(this).val().trim() == ""){
    			flagValidacion = false; 
    		}
    	});
    	
    	return flagValidacion;
    }

    

};