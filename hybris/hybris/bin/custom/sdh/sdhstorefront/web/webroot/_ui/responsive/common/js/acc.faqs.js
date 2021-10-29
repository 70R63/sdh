ACC.faqs = {

	_autoload: ["bindSearchCategory", "bindSearchKeyWord", "bindCopyText"],



	bindSearchCategory: function() {
		$(document).on("change", "#categoriaBuscar", function(e) {
			e.preventDefault();
			
			var currentUrl = window.location.href;
			var categoryId = document.getElementById("categoriaBuscar").value;

			if (currentUrl.includes("?")) {
				currentUrl = currentUrl.split('?')[0];
			}

			window.location.href = currentUrl + "?categoryId=" + categoryId;


		});
	},

	bindSearchKeyWord: function() {
		$(document).on("click", "#keyWordSearch", function(e) {
			e.preventDefault();
			var currentUrl = window.location.href;
			var keyWord = $("#faqKeyWord").val();
			if (currentUrl.includes("?")) {
				currentUrl = currentUrl.split('?')[0];
			}
			window.location.href = currentUrl + "?keyWord=" + keyWord;

		});
	},

	bindCopyText: function() {
		$(document).on("click", "#btnCopyUrl", function(e) {
			e.preventDefault();
			var copyText = document.getElementById("urlCopy");
			copyText.select();
			copyText.setSelectionRange(0, 99999); 
			document.execCommand("copy");

			// alert("Copied the text: " + copyText.value);
			alert("Copiado");

		});

	}


};