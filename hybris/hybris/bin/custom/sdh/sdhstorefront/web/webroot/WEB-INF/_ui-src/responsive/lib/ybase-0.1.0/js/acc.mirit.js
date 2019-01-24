ACC.mirit = {

		 _autoload: [ "bindUpdateButton","bindDialog","bindUpdateRitButton","bindAddressData"],
		    
		    bindAddressData: function(){
		    	$("#u5070_input").val(ACC.addressCountry);
		    	$("#u5056_input").val(ACC.addressDep);
		    	$("#u5056_input").trigger( "change" );
		    	$("#u5058_input option").filter(function() {
		    	    return this.text == ACC.addressMun; 
		    	}).attr('selected', true);
		    	$("#u5058_input").trigger( "change" );
		    	$("#u5073_input").val(ACC.addressPC);
		    	$("#u5073_input").trigger( "change" );
		    },

    bindUpdateButton: function () {
    $(document).on("click", "#certifNombButton", function (e) {
	        e.preventDefault();
	        
	        var data={};
	        
	        data.name1 = $("#primNom").val();
	        data.name2 = $("#segNom").val();
	        data.apellido1 = $("#primNom").val();
	        data.apellido2 = $("#segApe").val();
	        
	        $.ajax({
	            url: ACC.certifNombURL,
	            data: data,
	            type: "POST",
	            async: false,
	            success: function (data) {
	            	$( "#dialog" ).dialog( "open" );
	            	$("#textCertNom").html("No se puede certificar el nombre");
	            },
	            error: function () {
	            	$("#textCertNom").html("No se puede certificar el nombre");
	            }
	        });
	    });
    },
    
    
    bindUpdateRitButton: function () {
        $(document).on("click", "#updateRitButton", function (e) {
    	        e.preventDefault();
    	        
    	        var updateName = false;
    	        
    	        var hasErrors = false;
    	        
    	        //TODO: Call service to validet wheter we update name or no. Here we asume we can update it
    	        
    	        updateName = true;
    	        
    	        
    	        var newEmail = $("#newEmail").val().trim();
    	        var confirmNewEmail = $("#confirmNewEmail").val().trim();
    	        
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
             	            	if(data.isValidEmail == true)
         	            		{
             	            		$("#textCertNom").html("Nuevo Usuario Valido");
         	            		}else
             	            	{
         	            			$("#newEmailErrors").removeClass("hidden");
         	            			$("#newEmailErrors").html("Correo no disponible, por favor indique otro.");
         	        	        	$("#newEmail").parents(".form-group ").addClass("has-error");
         	        	        	hasErrors = true;
             	            	}
             	            },
             	            error: function () {
             	            	$("#textCertNom").html("Hubo un error al tratar de actualizar su RIT, por favor intentalo mas tarde.");
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
    	        
    	        var currentPassword = $("#currentPassword").val().trim();
    	        var newPassword = $("#newPassword").val().trim();
    	        var confirmNewPassword = $("#confirmNewPassword").val().trim();
    	        
    	        if(currentPassword != "" || newPassword != "" || confirmNewPassword !=  "" )
	        	{
    	        	if(currentPassword == "")
	        		{
    	        		$("#currentPasswordErrors").removeClass("hidden");
        	        	$("#currentPassword").parents(".form-group ").addClass("has-error");
        	        	$("#currentPasswordErrors").html("Por favor introduce tu contraseña actual");
        	        	hasErrors = true;
	        		}else
        			{
	        			$("#currentPasswordErrors").addClass("hidden");
        	        	$("#currentPassword").parents(".form-group ").removeClass("has-error");
        			}
        		
    	        	
    	        	if(/[a-z]/.test(newPassword) == false)
    	        	{
        	        	$("#newPassword").parents(".form-group ").addClass("has-error");
        	        	hasErrors = true;
    	        	}else
    	        	{
    	        		$("#newPassword").parents(".form-group ").removeClass("has-error");
    	        	}
    	        	
    	        	if(/[A-Z]/.test(newPassword) == false)
    	        	{
        	        	$("#newPassword").parents(".form-group ").addClass("has-error");
        	        	hasErrors = true;
    	        	}else
    	        	{
    	        		$("#newPassword").parents(".form-group ").removeClass("has-error");
    	        	}
    	        	
    	        	if(/[0-9]/.test(newPassword) == false)
    	        	{
        	        	$("#newPassword").parents(".form-group ").addClass("has-error");
        	        	hasErrors = true;
    	        	}else
    	        	{
    	        		$("#newPassword").parents(".form-group ").removeClass("has-error");
    	        	}
    	        	
    	        	if(newPassword.length <8 || newPassword.length>16)
    	        	{
        	        	$("#newPassword").parents(".form-group ").addClass("has-error");
        	        	hasErrors = true;
    	        	}else
    	        	{
    	        		$("#newPassword").parents(".form-group ").removeClass("has-error");
    	        	}
    	        
    	        	if(newPassword != confirmNewPassword)
    	        	{
    	        		$("#confirmNewPasswordErrors").removeClass("hidden");
        	        	$("#confirmNewPassword").parents(".form-group ").addClass("has-error");
        	        	hasError = true;
    	        	}
    	        	
    	        	
    	        	var passwordData = {};
        	        passwordData.passoword = currentPassword;
    	        	
        	        $.ajax({
    	            url: ACC.validaCurrentPasswrodURL,
    	            data: passwordData,
    	            type: "POST",
    	            async: false,
    	            success: function (data) {
    	            	$( "#dialog" ).dialog( "open" );
    	            	if(data.isValidPassword == true)
	            		{
    	            		$("#currentPasswordErrors").addClass("hidden");
            	        	$("#currentPassword").parents(".form-group ").removeClass("has-error");
	            		}else
    	            	{
	            			$("#currentPasswordErrors").removeClass("hidden");
	        	        	$("#currentPassword").parents(".form-group ").addClass("has-error");
	        	        	$("#currentPasswordErrors").html("Contraseña actual incorrecta.");
	        	        	hasErrors = true;
    	            	}
    	            },
    	            error: function () {
    	            	$("#textCertNom").html("Hubo un error al tratar de actualizar su RIT, por favor intentalo mas tarde.");
    	            }
    	        });
        		
	        } 	
    	        
    	        
    	        var redSocialData = new Array();
    	        
    	        $.each($(".redSocial"),function(index,value){
    	        	
    	        	if($(value).val() != "")
	        		{
    	        		if($("#redsocial\\["+index+"\\]\\.USUARIORED").val()== "")
	        			{
    	        			$("#redsocial\\["+index+"\\]\\.USUARIORED\\.errors").removeClass("hidden");
	        	        	$("#redsocial\\["+index+"\\]\\.USUARIORED").parents(".form-group ").addClass("has-error");
	        	        	$("#redsocial\\["+index+"\\]\\.USUARIORED\\.errors").html("Por favor introduce el nombre de usuario");
	        	        	hasErrors = true;
	        			}else
	        			{
	        				$("#redsocial\\["+index+"\\]\\.USUARIORED\\.errors").addClass("hidden");
	        	        	$("#redsocial\\["+index+"\\]\\.USUARIORED").parents(".form-group ").removeClass("has-error");
	        			}
	        		}
    	        	var eachSocialNet=new Object();
    	        	
    	        	eachSocialNet.RED_SOCIAL= $(value).val();
    	        	eachSocialNet.USUARIORED=$("#redsocial\\["+index+"\\]\\.USUARIORED").val();
    	        	
    	        	redSocialData.push(eachSocialNet);
    	        	
    	        });
    	        
    	        
    	        
    	        
    	        
    	        var direccionNotificacion = {};
    	        
    	        direccionNotificacion.ADR_KIND = "02";
    	        direccionNotificacion.STREET = $("#direccionNotificacionStreet").val();
    	        direccionNotificacion.STR_SUPPL1 = $("#direccionNotificacionSuppl1").val();
    	        direccionNotificacion.STR_SUPPL2 = $("#direccionNotificacionSuppl2").val();
    	        direccionNotificacion.POST_CODE = $("#u5073_input").val();
    	        direccionNotificacion.REGION = $("#u5056_input").val();
    	        direccionNotificacion.COUNTRY  = $("#u5070_input").val();
    	        direccionNotificacion.CITY1   = $("#u5058_input").val();
    	        
    	        var direccionContacto = {};
    	        
    	        direccionContacto.ADR_KIND = "01";
    	        direccionContacto.STREET = $("#direccionContactoStreet").val();
    	        direccionContacto.STR_SUPPL1 = $("#direccionContactoSuppl1").val();
    	        direccionContacto.STR_SUPPL2 = $("#direccionContactoSuppl2").val();
    	        direccionContacto.POST_CODE = $("#u5073_input").val();
    	        direccionContacto.REGION = $("#u5056_input").val();
    	        direccionContacto.COUNTRY  = $("#u5070_input").val();
    	        direccionContacto.CITY1   = $("#u5058_input").val();
    	        
    	        if(hasErrors)
    	        {
    	        	$( "#dialog" ).dialog( "open" );
    	        	$("#textCertNom").html("Por favor corrije los errores señalados");
    	        }else
    	        {
    	        	 var updateRitData = {};
    	    	        updateRitData.email = $("#currentMail").val().trim();
    	    	        updateRitData.newEmailAddress =  $("#newEmail").val().trim();
    	    	        updateRitData.confirmNewEmailAddress =  $("#confirmNewEmail").val().trim();
    	    	        updateRitData.primNom =  $("#primNom").val().trim();
    	    	        updateRitData.segNom =  $("#segNom").val().trim();
    	    	        updateRitData.primApe =  $("#primApe").val().trim();
    	    	        updateRitData.segApe =  $("#segApe").val().trim();
    	    	        updateRitData.usoBuzon = $("#buzon").is(":checked");
    	    	        updateRitData.autoUsoInfo = $("#usoInformacion").is(":checked");
    	    	        updateRitData.telfonoPrincipal = $("#telefonoPricipal").val();
    	    	        updateRitData.extension = $("#extensionTelefono").val();
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
    	    	            	if(data.ritUpdated == true)
    		            		{
    	    	            		$("#textCertNom").html("Tu RIT ha sido actualizado");
    		            		}else
    	    	            	{
    		            			$("#textCertNom").html("Hubo un error al tratar de actualizar tu RIT, por favor intentalo mas tarde.");
    	    	            	}
    	    	            },
    	    	            error: function () {
    	    	            	$("#textCertNom").html("Hubo un error al tratar de actualizar su RIT, por favor intentalo mas tarde.");
    	    	            }
    	    	        });
    	        }
    	        
    	        
    	    });
        },
    
    bindDialog: function(){
    	
    	$( "#dialog" ).dialog({ 
    		autoOpen: false, 
    		modal: true,
			 draggable: false
    		buttons: {
    			Ok: function() {
    				$( this ).dialog( "close" );
    			}
    	    } 
    	});
    	
    }

    

};