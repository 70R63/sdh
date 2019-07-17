ACC.oblipend = {

	 _autoload: ["bindBuscarObliPend"],
	 
	 bindBuscarObliPend: function(){
		
		 $(document).on("click", "#buscarObliPend", function (e) {
	 	        e.preventDefault();
	 	        
	 	       $(".oblipend-table").hide();
	 	       
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
		 
	 }
};