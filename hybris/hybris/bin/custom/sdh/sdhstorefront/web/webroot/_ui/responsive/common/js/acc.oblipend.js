ACC.oblipend = {

	_autoload : [ "bindBuscarObliPend", "bindDetalle", "bindDetalledos", "bindPopupPDF"],

	bindBuscarObliPend : function() {
		
		$(document).on("click", "#buscarObliPend", function(e) {
			
			debugger;
			e.preventDefault();

			$(".oblipend-table").hide();
			$(".oblipend-tabledetalle").hide();
			$(".oblipend-tabledetalledos").hide();
			$("#oblipend-predial").hide();
			$("#oblipend-vehiculos").hide();
			$("#oblipend-ica").hide();
			$("#oblipend-publiext").hide();
			$("#oblipend-gasolina").hide();
			$("#oblipend-delurbana").hide();
			

			var impuesto = $("#impuesto").val();

			if (impuesto == "1") {

				$("#oblipend-predial").show();

			} else if (impuesto == "2") {

				$("#oblipend-vehiculos").show();

			} else if (impuesto == "3") {

				$("#oblipend-ica").show();

			} else if (impuesto == "4") {

				$("#oblipend-publiext").show();

			} else if (impuesto == "5") {

				$("#oblipend-gasolina").show();

			} else if (impuesto == "6") {

				$("#oblipend-delurbana").show();

			}else if (impuesto == "7") {
				$("#oblipend-predial").show();
				$("#oblipend-vehiculos").show();
				$("#oblipend-ica").show();
				$("#oblipend-publiext").show();
				$("#oblipend-gasolina").show();
				$("#oblipend-delurbana").show();

			}

		});

	},
	
	bindPopupPDF : function(){
 $(document).on("click", "#ImprimirPopUp", function(e) {
 debugger;

 e.preventDefault();
 debugger;
	var impuestoSelc = $(this).data("impuesto");
	var tablePred = document.getElementsByClassName("table ImprimirPredial");
	tablePred[0].setAttribute("id","example1");
	var tableVeh = document.getElementsByClassName("table ImprimirVehicular");
	tableVeh[0].setAttribute("id","example2");
	var tableIca = document.getElementsByClassName("table ImprimirIca");
	tableIca[0].setAttribute("id","example3");
	var tableDel = document.getElementsByClassName("table ImprimirDelineacion");
	tableDel[0].setAttribute("id","example4");
	var tableGas = document.getElementsByClassName("table ImprimirGasolina");
	tableGas[0].setAttribute("id","example5");
	var tablePub = document.getElementsByClassName("table ImprimirPublicidad");
	tablePub[0].setAttribute("id","example6");
	
	if(impuestoSelc=="1"){
		tablePred[0].setAttribute("id","example");
	    var selectRefinementsTitle = "Predial";
        ACC.colorbox.open(selectRefinementsTitle, {
            href: ".js-impuesto-facet",
            inline: true,
            width: "90%",
            onComplete: function () {
                $(document).on("click", ".js-impuesto-facet .js-facet-name-imp", function (e) {
                    e.preventDefault();
                    $(".js-impuesto-facet  .js-facet-imp").removeClass("active");
                    $(this).parents(".js-facet-imp").addClass("active");
                    $.colorbox.resize()
                })
            },
            onClosed: function () {
                $(document).off("click", ".js-impuesto-facet .js-facet-name-imp");
            }
        });
	}else if(impuestoSelc=="2"){
	
		tableVeh[0].setAttribute("id","example");
		   var selectRefinementsTitle = "Vehicular";
	        ACC.colorbox.open(selectRefinementsTitle, {
	            href: ".js-vehicular-facet",
	            inline: true,
	            width: "90%",
	            onComplete: function () {
	                $(document).on("click", ".js-vehicular-facet .js-facet-name-veh", function (e) {
	                    e.preventDefault();
	                    $(".js-vehicular-facet  .js-facet-veh").removeClass("active");
	                    $(this).parents(".js-facet-veh").addClass("active");
	                    $.colorbox.resize()
	                })
	            },
	            onClosed: function () {
	                $(document).off("click", ".js-vehicular-facet .js-facet-name-veh");
	            }
	        });
	}else if(impuestoSelc=="3"){
		tableIca[0].setAttribute("id","example");
		   var selectRefinementsTitle = "ICA";
	        ACC.colorbox.open(selectRefinementsTitle, {
	            href: ".js-ica-facet",
	            inline: true,
	            width: "90%",
	            onComplete: function () {
	                $(document).on("click", ".js-ica-facet .js-facet-name-ica", function (e) {
	                    e.preventDefault();
	                    $(".js-ica-facet  .js-facet-ica").removeClass("active");
	                    $(this).parents(".js-facet-ica").addClass("active");
	                    $.colorbox.resize()
	                })
	            },
	            onClosed: function () {
	                $(document).off("click", ".js-ica-facet .js-facet-name-ica");
	            }
	        });
	}else if(impuestoSelc=="4"){
		tableDel[0].setAttribute("id","example");
		   var selectRefinementsTitle = "Delineación Urbana";
	        ACC.colorbox.open(selectRefinementsTitle, {
	            href: ".js-delineacion-facet",
	            inline: true,
	            width: "90%",
	            onComplete: function () {
	                $(document).on("click", ".js-delineacion-facet .js-facet-name-del", function (e) {
	                    e.preventDefault();
	                    $(".js-delineacion-facet  .js-facet-del").removeClass("active");
	                    $(this).parents(".js-facet-del").addClass("active");
	                    $.colorbox.resize()
	                })
	            },
	            onClosed: function () {
	                $(document).off("click", ".js-delineacion-facet .js-facet-name-del");
	            }
	        });
	}
	else if(impuestoSelc=="5"){
		tableGas[0].setAttribute("id","example");
		   var selectRefinementsTitle = "Gasolina";
	        ACC.colorbox.open(selectRefinementsTitle, {
	            href: ".js-gasolina-facet",
	            inline: true,
	            width: "90%",
	            onComplete: function () {
	                $(document).on("click", ".js-gasolina-facet .js-facet-name-gas", function (e) {
	                    e.preventDefault();
	                    $(".js-gasolina-facet  .js-facet-gas").removeClass("active");
	                    $(this).parents(".js-facet-gas").addClass("active");
	                    $.colorbox.resize()
	                })
	            },
	            onClosed: function () {
	                $(document).off("click", ".js-gasolina-facet .js-facet-name-gas");
	            }
	        });
	}
	else if(impuestoSelc=="6"){
		tablePub[0].setAttribute("id","example");
		   var selectRefinementsTitle = "Publicidad Exterior";
	        ACC.colorbox.open(selectRefinementsTitle, {
	            href: ".js-publicidad-facet",
	            inline: true,
	            width: "90%",
	            onComplete: function () {
	                $(document).on("click", ".js-publicidad-facet .js-facet-name-pub", function (e) {
	                    e.preventDefault();
	                    $(".js-publicidad-facet  .js-facet-pub").removeClass("active");
	                    $(this).parents(".js-facet-pub").addClass("active");
	                    $.colorbox.resize()
	                })
	            },
	            onClosed: function () {
	                $(document).off("click", ".js-publicidad-facet .js-facet-name-pub");
	            }
	        });
	}
	
		if ($.fn.dataTable.isDataTable('#example')) {
			table = $('#example').DataTable();
			table.destroy();
		}
		var tabla = $("#example")
				.DataTable(
						{
							"sPaginationType" : "full_numbers",
							"oLanguage" : {
								"oPaginate" : {
									"sPrevious" : "Anterior",
									"sNext" : "Siguiente",
									"sLast" : "Ultima",
									"sFirst" : "Primera"
								},
								"sLengthMenu" : 'Mostrar <select>'
										+ '<option value="5">5</option>'
										+ '<option value="10">10</option>'
										+ '<option value="15">15</option>'
										+ '<option value="20">20</option>'
										+ '<option value="30">30</option>'
										+ '</select> registros',
								"sInfo" : "Mostrando del START a END (Total: TOTAL resultados)",
								"sInfoFiltered" : " Filtrados de MAX registros",
								"sInfoEmpty" : " ",
								"sZeroRecords" : "No se encontraron registros",
								"sProcessing" : "Espere, por favor...",
								"sSearch" : "Buscar:",
							}
						});
	

	});
		
	},

	bindTrmPdf : function(impuesto, reporte, reportPdfName) {
	    var currentUrl = window.location.href;
	    var baseUrl = currentUrl.substring(0, currentUrl.indexOf("sdhstorefront"));
	    $.ajax({
            url     : baseUrl+'sdhstorefront/es/trmService/getPdfString?impuesto='+impuesto+'&reporte='+reporte,
            method  : 'GET',
            success : function(pdfResponse){
            	if(!ACC.oblipend.hayErrores_getPdfString(pdfResponse)){
	                console.log(pdfResponse.pdf);
	                ACC.oblipend.bindDownloadPdf(pdfResponse.pdf, reportPdfName);
            	}
            },
            error : function(jqXHR, exception){
                console.log('Error occured!!');
            }
        });
	},

	bindDownloadPdf : function(stringPdf, reportPdfName){
	    const linkSource = 'data:application/pdf;base64,' + stringPdf;
        const downloadLink = document.createElement("a");
        downloadLink.href = linkSource;
        downloadLink.download = reportPdfName;
        downloadLink.click();
	},

	bindDetalle : function() {

		$(document).on(
				"click",
				"#Detalle",
				function(e) {
					debugger;
					
					e.preventDefault();
					
					$(".oblipend-tabledetalle").hide();
					$(".oblipend-tabledetalledos").hide();

					var fecha = new Date();
					var impuesto = $("#impuesto").val();
					var mes = fecha.getMonth() + 1;

					if (impuesto == "1") {

						$("#detalle-predial").show();
						if(mes < 10){
						$("#fechreportepred").val(
								fecha.getDate() + "/0" + (fecha.getMonth() + 1)
										+ "/" + fecha.getFullYear());
						}else{
							$("#fechreportepred").val(
									fecha.getDate() + "/0" + (fecha.getMonth() + 1)
											+ "/" + fecha.getFullYear());
						}

					} else if (impuesto == "2") {

						$("#detalle-vehiculos").show();
						if(mes < 10){
						$("#fechreportevh").val(
								fecha.getDate() + "/0" + (fecha.getMonth() + 1)
										+ "/" + fecha.getFullYear());
						}else{
							$("#fechreportevh").val(
									fecha.getDate() + "/" + (fecha.getMonth() + 1)
											+ "/" + fecha.getFullYear());
						}

					} else if (impuesto == "3") {

						$("#detalle-ica").show();
						if (mes < 10){
						$("#fechreporteica").val(
								fecha.getDate() + "/0" + (fecha.getMonth() + 1)
										+ "/" + fecha.getFullYear());
						}else{
							$("#fechreporteica").val(
									fecha.getDate() + "/" + (fecha.getMonth() + 1)
											+ "/" + fecha.getFullYear());
						}

					} else if (impuesto == "4") {

						var numrespub = this.attributes[4].nodeValue;
						var angravpub = this.attributes[3].nodeValue;
						var orievalla = this.attributes[7].nodeValue;
						var oblivalla = this.attributes[8].nodeValue;
						var edooblivalla = this.attributes[9].nodeValue;

						$("#detalle-publiext").show();
						if (mes < 10) {
							$("#fechreportepub").val(
									fecha.getDate() + "/0"
											+ (fecha.getMonth() + 1) + "/"
											+ fecha.getFullYear());
						} else {
							$("#fechreportepub").val(
									fecha.getDate() + "/"
											+ (fecha.getMonth() + 1) + "/"
											+ fecha.getFullYear());
						}
						if ("01" == orievalla || "1"== orievalla)
						{
							
							$("#orivalla").val("Oriente-Occidente");
							
						}
						else if ("02" == orievalla || "2"== orievalla)
						{
							$("#orivalla").val("Occidente-Oriente");
						}
						else if ("03" == orievalla || "3"== orievalla)
						{
							$("#orivalla").val("Norte-Sur");
						}
						else if ("04" == orievalla || "4"== orievalla)
						{
							$("#orivalla").val("Sur-Norte");
						}
						else if ("05" == orievalla || "5"== orievalla)
						{
							$("#orivalla").val("Derecha");
						}
						else if ("06" == orievalla || "6"== orievalla)
						{
							$("#orivalla").val("Izquierda");
						}
						else if ("07" == orievalla || "7"== orievalla)
						{
							$("#orivalla").val("Ambos sentidos");
						}
						else
						{
							$("#orivalla").val("-");
						}

						$("#numResOB").val(numrespub);
						$("#angravPUB").val(angravpub);
						$("#obliga").val(oblivalla);
						$("#data-edoobli").val(edooblivalla);
						
						

					} else if (impuesto == "5") {

						$("#detalle-gasolina").show();
						if (mes < 10) {
							$("#fechreportegas").val(
									fecha.getDate() + "/0"
											+ (fecha.getMonth() + 1) + "/"
											+ fecha.getFullYear());
						} else {
							$("#fechreportegas").val(
									fecha.getDate() + "/"
											+ (fecha.getMonth() + 1) + "/"
											+ fecha.getFullYear());
						}

					} else if (impuesto == "6") {
						var cduDEL = this.attributes[2].nodeValue;
						var aniograv = this.attributes[3].nodeValue;
						var chipDelin = this.attributes[4].nodeValue;
						var direcDeli = this.attributes[5].nodeValue;
						var edoDelin = this.attributes[6].nodeValue;
						var obliDelin = this.attributes[7].nodeValue;
						
						var division = cduDEL.split("U");
						var anio = division[1].split('',2);
						var anioimp = anio[0] +  anio[1];

						$("#detalle-delurbana").show();

						if (mes < 10) {
							$("#fechreportedel").val(
									fecha.getDate() + "/0"
											+ (fecha.getMonth() + 1) + "/"
											+ fecha.getFullYear());
						} else {
							$("#fechreportedel").val(
									fecha.getDate() + "/"
											+ (fecha.getMonth() + 1) + "/"
											+ fecha.getFullYear());
						}
						
						$("#cduobDELI").val(cduDEL);
						$("#angravabDELI").val(aniograv);
						$("#chipDeli").val(chipDelin);
						$("#direcDeli").val(direcDeli);
						$("#edoobliDeli").val(edoDelin);
						$("#obliDeli").val(obliDelin);
						
						
						$("#varDeli").val(cduDEL);
						
						 var cdu  = $.trim($("#varDeli").val());
					 	 
				 	       var data = {};
				 	       
				 	       data.cdu = cdu;
				 	       
				 	       data.variableres=cdu;
				 	       
				 	      $("#varDeli").val(data.cdu);

						
						$("#varDeli").val(cduDEL);
						
						
							
						if (anioimp < 99){
							
							$("#angravDELI").val("20"+anioimp);
							
						}else{
							$("#angravDELI").val("Error");
						}

					}
				});
	},
	
	bindDetalledos : function() {
		$(document).on("click", "#Detalledos", function(e) {
			debugger;
					
			e.preventDefault();
			$(".oblipend-tabledetalledos").hide();

			var impuesto = $("#impuesto").val();

			if (impuesto == "1") {

				$("#detalle-predial").show();

			} else if (impuesto == "2") {

				$("#detalle-vehiculos").show();

			} else if (impuesto == "3") {

				$("#detalle-dos-ica").show();
				
//				var numAnioICA = this.attributes[3].nodeValue;
//				var perICA = this.attributes[4].nodeValue;
//				var edoobligICA = this.attributes[5].nodeValue;
//				var obligICA = this.attributes[6].nodeValue;
//				
//				$("#angravICA").val(numAnioICA);
//				$("#periodoICA").val(perICA);
//				$("#edoobliICA").val(edoobligICA);
//				$("#obliICA").val(obligICA);
 

			} else if (impuesto == "4") {
				
				var resolu = $("#numResOB").val();
				var aniogravavble = $("#angravPUB").val();
				var esobli = $("#data-edoobli").val();
				var oblig = $("#obliga").val();
 

				$("#detalle-dos-publiext").show();
				$("#numResPUBLICI").val(resolu);
				$("#angravPUBLICI").val(aniogravavble);
				$("#esdobli").val(esobli);
				$("#det-obli").val(oblig);


			} else if (impuesto == "5") {

				$("#detalle-dos-gasolina").show();
				
				var numAnioGas = this.attributes[3].nodeValue;
				var perGas = this.attributes[4].nodeValue;
				var edoobligGAS = this.attributes[5].nodeValue;
				var obligGAS = this.attributes[6].nodeValue;
				
				$("#angravGAS").val(numAnioGas);
				$("#periodoGAS").val(perGas);
				$("#edoobliGAS").val(edoobligGAS);
				$("#obliGAS").val(obligGAS);

			} else if (impuesto == "6") {

				$("#detalle-dos-delurbana").show();
				
				var cdusel = $("#cduobDELI").val();
				var angravsel = $("#angravabDELI").val();
				var chipsel = $("#chipDeli").val();
				var dirsel = $("#direcDeli").val();
				var edosel = $("#edoobliDeli").val();
				var oblisel = $("#obliDeli").val();
				
				$("#anioselDeli").val(angravsel);
				$("#cduselDeli").val(cdusel);
				$("#edoobliselDELI").val(edosel);
				$("#obliselDELI").val(oblisel);
				

			}
		});
	},
	
	
	hayErrores_getPdfString : function (response){
		var flagValidacion = false;
		if(response.errores!=null && response.errores.id_msj!=null && response.errores.id_msj.trim()!=""){
			flagValidacion = true;
			alert(response.errores.id_msj + " - " + response.errores.txt_msj);
		}
		
		return flagValidacion;
	}
};