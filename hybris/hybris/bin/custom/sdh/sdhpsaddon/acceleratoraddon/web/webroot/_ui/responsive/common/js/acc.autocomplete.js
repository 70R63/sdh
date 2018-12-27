/*
 * [y] hybris Platform
 *
 * Copyright (c) 2000-2016 SAP SE or an SAP affiliate company.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of SAP
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with SAP.
 */
ACC.autocomplete = {
	_autoload: [
		"bindSearchAutocomplete",
        "bindDisableSearch",
        "removeAriaLabelFromSearchInput"
	],
	bindSearchAutocomplete: function ()
	{
		// extend the default autocomplete widget, to solve issue on multiple instances of the searchbox component
		$.widget( "custom.yautocomplete", $.ui.autocomplete, {
			_create: function(){
				// get instance specific options form the html data attr
				var option = this.element.data("options");
				// set the options to the widget
				this._setOptions({
					minLength: option.minCharactersBeforeRequest,
					displayProductImages: option.displayProductImages,
					delay: option.waitTimeBeforeRequest,
					autocompleteUrl: option.autocompleteUrl,
					source: this.source
				});
				// call the _super()
				$.ui.autocomplete.prototype._create.call(this);
			},
			options: {
				cache: {}, // init cache per instance
				focus: function (){ return false; }, // prevent textfield value replacement on item focus
				select: function (event, ui){
                    window.location.href = ui.item.url;
                }
			},
			_renderItem: function (ul, item){
				if (item.type === "autoSuggestion"){
					var renderHtml = "<a href='"+ item.url + "' ><div class='name'>" + item.value + "</div></a>";
					return $("<li>")
							.data("item.autocomplete", item)
							.append(renderHtml)
							.appendTo(ul);
				}
				else if (item.type === "productResult"){
					var renderProductHtml = "<a href='" + item.url + "' >";
					if (item.image !== null){
						renderProductHtml += "<div class='thumb'><img src='" + item.image + "'  /></div>";
					}
					renderProductHtml += 	"<div class='name'>" + item.value +"</div>";
					renderProductHtml += 	"</a>";
					return $("<li>").data("item.autocomplete", item).append(renderProductHtml).appendTo(ul);
				}
			},
			source: function (request, response)
			{
				var self=this;
				var term = request.term.toLowerCase();
				if (term in self.options.cache)
				{
					return response(self.options.cache[term]);
				}
				$.getJSON(self.options.autocompleteUrl, {term: request.term}, function (data)
				{
					var autoSearchData = [];
					if(data.suggestions !== null){
						$.each(data.suggestions, function (i, obj)
						{
							autoSearchData.push({
								value: obj.term,
								url: ACC.config.encodedContextPath + "/search?text=" + obj.term,
								type: "autoSuggestion"
							});
						});
					}
					if(data.products !== null){
						$.each(data.products, function (i, obj)
						{
							autoSearchData.push({
								value: ACC.autocomplete.escapeHTML(obj.name),
								code: obj.code,
								desc: obj.description,
								manufacturer: obj.manufacturer,
								url: ACC.config.encodedContextPath + obj.url,
								type: "productResult",
								image: (obj.images!==null && self.options.displayProductImages) ? obj.images[0].url : null // prevent errors if obj.images = null
							});
						});
					}
					self.options.cache[term] = autoSearchData;
					return response(autoSearchData);
				});
			}
		});
		var $search = $(".js-site-search-input");
		if($search.length>0){
			$search.yautocomplete();
		}
	},
	bindDisableSearch: function (){
        $('#js-site-search-input').keyup(function(){
        	$('#js-site-search-input').val($('#js-site-search-input').val().replace(/^\s+/gm,''));
            $('.js_search_button').prop('disabled', this.value === "" ? true : false);
        });
       },
   removeAriaLabelFromSearchInput: function(){
	   $(document).ready(function(){
	     $('.jumbotron .js-site-search-input').removeAttr('aria-label placeholder');
     });
  },
   escapeHTML: function (input) {
	    return input.replace(/&/g,'&amp;').replace(/</g,'&lt;').replace(/>/g,'&gt;');
	}
};