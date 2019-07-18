ACC.oblipend = {

	 _autoload: ["bindBuscarObliPend", "bindDetalle"],
	 
	 bindBuscarObliPend: function(){
		
		 $(document).on("click", "#buscarObliPend", function (e) {
	 	        e.preventDefault();
	 	        
	 	       $(".oblipend-table").hide();
	 	      $(".oblipend-tabledetalle").hide();
	 	       
	 	       var impuesto = $("#impuesto").val();
	 	      
	 	       if(impuesto == "1"){
	 	    	   
	 	    	   $("#oblipend-predial").show();
	 	    	   
	 	       }else  if(impuesto == "2"){
	 	    	   
	 	    	   $("#oblipend-vehiculos").show();
	 	    	   
	 	       }else  if(impuesto == "3"){
	 	    	   
	 	    	   $("#oblipend-ica").show();
	 	    	   
	 	       }else  if(impuesto == "4"){
	 	    	   
	 	    	   $("#oblipend-publiext").show();
	 	    	   
	 	       }else  if(impuesto == "5"){
	 	    	   
	 	    	   $("#oblipend-gasolina").show();
	 	    	   
	 	       }else  if(impuesto == "6"){
	 	    	   
	 	    	   $("#oblipend-delurbana").show();
	 	    	   
	 	       }
	 	       
		 });
		 
	 },
	 
	 bindDetalle: function(){
		
		 $(document).on("click", "#Detalle", function (e) {
	 	        e.preventDefault();
	 	        
	 	       $(".oblipend-tabledetalle").hide();
	 	       
	 	        
	 	       var impuesto = $("#impuesto").val();
		 	      
	 	       if(impuesto == "1"){
	 	    	   
	 	    	  $("#detalle-predial").show();
	 	    	 
	 	       }else  if(impuesto == "2"){
	 	    	   
	 	    	   $("#detalle-vehiculos").show();
	 	    	   
	 	       }else  if(impuesto == "3"){
	 	    	   
	 	    	   $("#detalle-ica").show();
	 	    	   
	 	       }else  if(impuesto == "4"){
	 	    	   
	 	    	   $("#detalle-publiext").show();
	 	    	   
	 	       }else  if(impuesto == "5"){
	 	    	   
	 	    	   $("#detalle-gasolina").show();
	 	    	   
	 	       }else  if(impuesto == "6"){
	 	    	   
	 	    	   $("#detalle-delurbana").show();
	 	    	   
	 	       }
		 });
	 }
};