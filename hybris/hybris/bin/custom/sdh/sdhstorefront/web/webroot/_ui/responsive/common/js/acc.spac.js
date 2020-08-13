ACC.spac = {

	_autoload : [ "bindBtnSpac", "bindBtnSpacObli", "bindBtnSpacObliPDF" ],

	bindBtnSpac : function() {
		$(document)
				.on(
						"click",
						".btnspac",
						function(e) {
							e.preventDefault();
							var currentUrl = window.location.href;
							$('#tableSpacPago tbody').empty();
							var divtable = document.getElementById("tableSpac");

							divtable.style.visibility = 'hidden';

							if (confirm("El SPAC es el sistema de pago del Impuesto Predial por cuotas de la presente vigencia. Si te acojes al pago de predial por cuotas no tendrás la opción del 10% de descuento por pronto pago ni del 1% adicional.")) {
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
												debugger;

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
											}
										});
							} else {
								window.location.href = currentUrl;
							}
						});
	},

	bindBtnSpacObli : function() {
		$(document).on(
				"click",
				".btnGenerarSPACObli",
				function(e) {
					e.preventDefault();
					var currentUrl = window.location.href;
					debugger;
					$('#tableSpacPago tbody').empty();
					var divtable = document.getElementById("tableSpac");

					divtable.style.visibility = 'hidden';

					var anio = $.trim($(this).attr("data-anio"));
					var numform = $.trim($(this).attr("data-numForm"));
					var numobj = $.trim($(this).attr("data-obj"));
					var reimpresion = $.trim($(this).attr("data-reimpresion"));

					document.getElementById("anioGravPDF").value=anio;
					document.getElementById("objcontPDF").value=numobj;
					document.getElementById("numFormPDF").value=numform;

					$.ajax({
						url : ACC.spacURL + '?anio=' + anio + '&numform='
								+ numform + '&numobj=' + numobj
								+ '&reimpresion=' + reimpresion,
						// data : data,
						type : "GET",
						success : function(spacform) {
							debugger;
							var cuotas = spacform.cuotas_Spac;
								if(cuotas != null){
							for (var i = 0; i < cuotas.length; i++) {

								$('#tableSpacPago').append(
										'<tr><td>' + cuotas[i].numCuotas
												+ '</td><td>'
												+ cuotas[i].fechaPago
												+ '</td><td>' + cuotas[i].monto
												+ '</td><td>'
												+ cuotas[i].status
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
						}
					});

				});
	},
	
	bindBtnSpacObliPDF : function() {
		$(document).on(
				"click",
				".btnGenerarSpacPDF",
				function(e) {
					e.preventDefault();
					var currentUrl = window.location.href;
					debugger;
					var anio = document.getElementById("anioGravPDF").value;
					var numobj=document.getElementById("objcontPDF").value;
					var numform=document.getElementById("numFormPDF").value;

					$.ajax({
						url : ACC.spacPDFURL + '?anio=' + anio + '&numform='
								+ numform + '&numobj=' + numobj,
						// data : data,
						type : "GET",
						success : function(spacform) {
							debugger;
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
						}
					});

				});
	}
};