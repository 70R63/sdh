ACC.spac = {

	_autoload : [ "bindBtnSpac", "bindBtnSpacObli", "bindBtnSpacObliPDF", "bindBtnSpacObliVehicular", "bindBtnSpacObliPDFVehicular" ],

	bindBtnSpac : function() {
		$(document)
				.on(
						"click",
						".btnspac",
						function(e) {
							
							e.preventDefault();
							
							ACC.spinner.show();
							var currentUrl = window.location.href;
							$('#tableSpacPago tbody').empty();
							var divtable = document.getElementById("tableSpac");

							divtable.style.visibility = 'hidden';

							if (confirm("El SPAC es el sistema de pago de los Impuestos Predial y Vehículos Automotores por cuotas de la presente vigencia. Si te acojes al pago de predial por cuotas no tendrás la opción del 10% de descuento por pronto pago ni del 1% adicional.")) {
								var anio = $.trim($(this).attr("data-anio"));
								var numform = $.trim($(this).attr(
										"data-numForm"));
								if(numform==""){
									numform = $("#numForm").val();
								}
								var numobj = $.trim($(this).attr("data-obj"));
								var reimpresion = $.trim($(this).attr(
										"data-reimpresion"));
								$
										.ajax({
											url : ACC.spacURL + '?anio=' + anio
													+ '&numform=' + numform
													+ '&numobj=' + numobj
													+ '&reimpresion='
													+ reimpresion,
											// data : data,
											type : "GET",
											success : function(spacform) {
												ACC.spinner.close();
												var cuotas = spacform.cuotas_Spac;
												if(cuotas != null){
												for (var i = 0; i < cuotas.length; i++) {

													$('#tableSpacPago')
															.append(
																	'<tr><td>'
																			+ cuotas[i].numCuotas
																			+ '</td><td>'
																			+ cuotas[i].fechaPago
																			+ '</td></tr>');

												}
												divtable.style.visibility = 'visible';
												}else{
													var errores = spacform.errores;
													for (var i = 0; i < errores.length; i++)
													{
														if(errores[i].id_msj != ""){
															alert(errores[i].txt_msj);
															
														}
													}
												}

											},
											error : function() {
												ACC.spinner.close();
											}
										});
							} else {
								ACC.spinner.close();
								window.location.href = currentUrl;
							}
						});
	},

	bindBtnSpacObli : function() {
		$(document).on("click",".btnGenerarSPACObli",function(e) {
			e.preventDefault();
			ACC.spac.generarSPACObli(this,"0001");
		});
	},
	
	
	bindBtnSpacObliVehicular : function() {
		$(document).on("click",".btnGenerarSPACObliVehicular",function(e) {
			e.preventDefault();
			ACC.spac.generarSPACObli(this,"0002");
		});
	},
	
	
	generarSPACObli : function(objeto,claveImpuesto){
		
		ACC.spinner.show();
		objetosPantalla = ACC.spac.determinarObjetos(claveImpuesto);

		var currentUrl = window.location.href;
		
		$(objetosPantalla.tableSpacPagoTbody).empty();
		var divtable = document.getElementById(objetosPantalla.tableSpac);
		if(divtable!=null){
			divtable.style.display = 'none';
			divtable.style.visibility = 'hidden';
		}

		var anio = $.trim($(objeto).attr("data-anio"));
		var numform = $.trim($(objeto).attr("data-numForm"));
		var numobj = $.trim($(objeto).attr("data-obj"));
		var reimpresion = $.trim($(objeto).attr("data-reimpresion"));

		document.getElementById(objetosPantalla.anioGravPDF).value=anio;
		document.getElementById(objetosPantalla.objcontPDF).value=numobj;
		document.getElementById(objetosPantalla.numFormPDF).value=numform;

		$.ajax({
			url : ACC.spacURL + '?anio=' + anio + '&numform='+ numform + '&numobj=' + numobj + '&reimpresion=' + reimpresion,
			// data : data,
			type : "GET",
			success : function(spacform) {
				ACC.spinner.close();
				var cuotas = spacform.cuotas_Spac;
				if(cuotas != null){
					for (var i = 0; i < cuotas.length; i++) {
						$(objetosPantalla.tableSpacPago).append('<tr><td>' + cuotas[i].numCuotas + '</td><td>' + cuotas[i].fechaPago + '</td><td>' + cuotas[i].monto + '</td><td>' + cuotas[i].status + '</td></tr>');
					}
					divtable.style.visibility = 'visible';
					divtable.style.display = 'block';
				}else{
					var errores = spacform.errores;
					for (var i = 0; i < errores.length; i++){
 						if(errores[i].id_msj != ""){
							alert(errores[i].txt_msj);
 						}
					}
				}
		},
			error : function(){ACC.spinner.close();}
		});		
	},
	
	
	determinarObjetos : function(claveImpuesto){
		var nombreObjetos = {};
		nombreObjetos.tableSpacPagoTbody = '';
		nombreObjetos.tableSpacPago = '';
		nombreObjetos.tableSpac = '';
		nombreObjetos.anioGravPDF = '';
		nombreObjetos.objcontPDF = '';
		nombreObjetos.numFormPDF = '';
		
		switch(claveImpuesto){
		case "0001": //predial
			nombreObjetos.tableSpacPagoTbody = '#tableSpacPago tbody';
			nombreObjetos.tableSpacPago = '#tableSpacPago';
			nombreObjetos.tableSpac = 'tableSpac';
			nombreObjetos.anioGravPDF = 'anioGravPDF';
			nombreObjetos.objcontPDF = 'objcontPDF';
			nombreObjetos.numFormPDF = 'numFormPDF';
			break;
		case "0002": //vehicular
			nombreObjetos.tableSpacPagoTbody = '#tableSpacPagoVehicular tbody';
			nombreObjetos.tableSpacPago = '#tableSpacPagoVehicular';
			nombreObjetos.tableSpac = 'tableSpacVehicular';
			nombreObjetos.anioGravPDF = 'anioGravPDFVehicular';
			nombreObjetos.objcontPDF = 'objcontPDFVehicular';
			nombreObjetos.numFormPDF = 'numFormPDFVehicular';
			break;
			
		}

		return nombreObjetos;
	},
	
	
	bindBtnSpacObliPDF : function() {
		$(document).on("click",".btnGenerarSpacPDF",function(e) {
			e.preventDefault();
			ACC.spac.btnSpacObli("0001");
		});
	},
	
	
	bindBtnSpacObliPDFVehicular : function() {
		$(document).on("click",".btnGenerarSpacPDFVehicular",function(e) {
			e.preventDefault();
			ACC.spac.btnSpacObli("0002");
		});
	},
	
	
	btnSpacObli : function(claveImpuesto){
		
		ACC.spinner.show();

		objetosPantalla = ACC.spac.determinarObjetos(claveImpuesto);
		
		var currentUrl = window.location.href;
		
		var anio = document.getElementById(objetosPantalla.anioGravPDF).value;
		var numobj=document.getElementById(objetosPantalla.objcontPDF).value;
		var numform=document.getElementById(objetosPantalla.numFormPDF).value;

		$.ajax({
			url : ACC.spacPDFURL + '?anio=' + anio + '&numform='
					+ numform + '&numobj=' + numobj,
			// data : data,
			type : "GET",
			success : function(spacform) {
				ACC.spinner.close();
				var pdf = spacform.pdf;
				if(pdf != null){
				var newpdf = spacform.pdf;

				var pdf = 'data:application/newpdf;base64,'+ newpdf;
				 var dlnk = document.getElementById('dwnldLnk');
				  dlnk.href = pdf;
				  dlnk.click();
				  
				}else{
					alert("Hubo un error generando el PDF");
				}
			},
			error : function() {
				ACC.spinner.close();
			}
		});
	}
	
};