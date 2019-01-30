ACC.mirit = {

		 _autoload: [ "bindUpdateButton","bindDialog","bindUpdateRitButton","bindAddressData","bindAddSocialNetworkRowButton"],
		    
		    bindAddressData: function(){
		    	$("#u5070_input").val(ACC.addressCountry);
		    	$("#u5056_input").val(ACC.addressDep);
		    	$("#u5056_input").trigger( "change" );
		    	$("#u5058_input option").filter(function() {
		    	    return this.text == ACC.addressMun; 
		    	}).attr('selected', true);
		    	$("#u5058_input").trigger( "change" );
		    	$("#u5073_input").val(parseInt(ACC.addressPC));
		    	$("#u5073_input").trigger( "change" );
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

    bindUpdateButton: function () {
    $(document).on("click", "#certifNombButton", function (e) {
	        e.preventDefault();
	        
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
	            	$( "#dialog" ).dialog( "open" );
	            	if(data.success==true)
	            	{
	            		$("#textCertNom").html("Nombre válido. Tu nombre será acutalizado cuando clickes ACTUALIZAR RIT");
	            	}else
	            	{
	            		$("#textCertNom").html("Nombre inválido.<br> El nuevo nombre tiene un porcentaje de "+parseInt(100*data.porcentaje)+"%<br>El porcentaje mínimo necesario para actualizar tu nombre es "+parseInt(100*data.minPercentage)+"%");
	            	}
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
		    	            	$("#textCertNom").html("Hubo un error al tratar de actualizar su RIT, por favor intentalo mas tarde.");
		    	            }
	        	        });
    	        	}
        		
	        } 	
    	        
    	        
    	        var redSocialData = new Array();
    	        
    	        $.each($(".socialNetworkRow"),function(index,value){
    	        	
//    	        	if($(value).val() != "")
//	        		{
//    	        		if($("#redsocial\\["+index+"\\]\\.USUARIORED").val()== "")
//	        			{
//    	        			$("#redsocial\\["+index+"\\]\\.USUARIORED\\.errors").removeClass("hidden");
//	        	        	$("#redsocial\\["+index+"\\]\\.USUARIORED").parents(".form-group ").addClass("has-error");
//	        	        	$("#redsocial\\["+index+"\\]\\.USUARIORED\\.errors").html("Por favor introduce el nombre de usuario");
//	        	        	hasErrors = true;
//	        			}else
//	        			{
//	        				$("#redsocial\\["+index+"\\]\\.USUARIORED\\.errors").addClass("hidden");
//	        	        	$("#redsocial\\["+index+"\\]\\.USUARIORED").parents(".form-group ").removeClass("has-error");
//	        			}
//	        		}
    	        	
    	        	
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
    	        direccionNotificacion.STREET = $.trim($("#direccionNotificacionStreet").val());
    	        direccionNotificacion.STR_SUPPL1 = $.trim($("#direccionNotificacionSuppl1").val());
    	        direccionNotificacion.STR_SUPPL2 = $.trim($("#direccionNotificacionSuppl2").val());
    	        direccionNotificacion.POST_CODE1 = $.trim($("#u5073_input").val());
    	        direccionNotificacion.REGION = $.trim($("#u5056_input").val());
    	        direccionNotificacion.COUNTRY  = $.trim($("#u5070_input").val());
    	        direccionNotificacion.CITY1   =$.trim( $("#u5058_input option:selected").text())
    	        
    	        var direccionContacto = {};
    	        
    	        direccionContacto.ADR_KIND = "01";
    	        direccionContacto.STREET = $.trim($("#direccionContactoStreet").val());
    	        direccionContacto.STR_SUPPL1 = $.trim($("#direccionContactoSuppl1").val());
    	        direccionContacto.STR_SUPPL2 = $.trim($("#direccionContactoSuppl2").val());
    	        direccionContacto.POST_CODE1 = $.trim($("#u5073_input").val());
    	        direccionContacto.REGION = $.trim($("#u5056_input").val());
    	        direccionContacto.COUNTRY  = $.trim($("#u5070_input").val());
    	        direccionContacto.CITY1   = $.trim($("#u5058_input option:selected").text());
    	        
    	        if(hasErrors || hasPasswordErrors)
    	        {
    	        	$( "#dialog" ).dialog( "open" );
    	        	$("#textCertNom").html("Por favor corrije los errores señalados");
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
			 draggable: false,
    		buttons: {
    			Ok: function() {
    				$( this ).dialog( "close" );
    			}
    	    } 
    	});
    	
    }

    

};