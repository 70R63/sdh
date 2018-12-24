ACC.product = {
    _autoload: [
        "enableVariantSelectors",
        "bindFacets"
    ],
    bindFacets: function ()
    {
        $(document).on("click", ".js-show-facets", function ()
        {
            var selectRefinementsTitle = $(this).data("selectRefinementsTitle");
            ACC.colorbox.open(selectRefinementsTitle, {
                href: "#product-facet",
                inline: true,
                width: "480px",
                onComplete: function ()
                {
                	$('#cboxTitle').insertBefore('#cboxLoadedContent');
                	$('#cboxClose').insertBefore('#cboxLoadedContent');
                	$('.headline-text').attr({'aria-label': selectRefinementsTitle,'tabindex': '0','id': 'customTitle'});
                	$('#cboxClose').attr({'aria-label': PSACC.textCloseOverlay,'tabindex': '0'});
                    $(document).on("click", ".js-product-facet .js-facet-name", function (e)
                    {
                        e.preventDefault();
                        $(".js-product-facet  .js-facet").removeClass("active");
                        $(this).parents(".js-facet").addClass("active");
                        $.colorbox.resize();
                    });
                    $(document).on("keypress", ".js-product-facet .js-facet-name", function(e) {
           			 if (e.keyCode === 32 || e.keyCode === 0) {
           				 $(this).trigger('click');
           			  }
                    });
                },
                onClosed: function ()
                {
                    $(document).off("click", ".js-product-facet .js-facet-name");
                }
            });
        });
        enquire.register("screen and (min-width:" + screenSmMax + ")", function ()
        {
            $("#cboxClose").click();
        });
    },
    enableAddToCartButton: function ()
    {
        $('.js-enable-btn').each(function ()
        {
            if (!($(this).hasClass('outOfStock') || $(this).hasClass('out-of-stock')))
            {
                $(this).removeAttr("disabled");
            }
        });
    },
    enableVariantSelectors: function ()
    {
        $('.variant-select').removeAttr("disabled");
    }
};
$(document).ready(function ()
{
    ACC.product.enableAddToCartButton();
});