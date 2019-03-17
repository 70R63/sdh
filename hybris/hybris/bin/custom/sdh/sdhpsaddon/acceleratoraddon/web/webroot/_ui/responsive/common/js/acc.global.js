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
ACC.global = {
    _autoload: [
        ["passwordStrength", $('.password-strength').length > 0],
        "bindToggleOffcanvas",
        "bindToggleXsSearch",
        "bindHoverIntentMainNavigation",
        "initImager",
        "backToHome",
        "bindDropdown",
        "closeAccAlert",
        "updateMenu"
    ],
    updateMenu: function () {
    	if(ACC.hideMenuInformacionReportada == true)
    	{	
    		$("a:contains('Mi Información Reportada')").closest("li").remove();
    	}
    	
    	if(ACC.hideMenuImpuestos == true)
    	{	
    		$("a:contains('Impuestos')").closest("li").remove();
    	}
    	
    	if(ACC.hideMenuBuzon == true)
    	{	
    		$("a:contains('Mi Buzón')").closest("li").remove();
    	}
    	
    	if(ACC.hideMenuTramites == true)
    	{	
    		$("a:contains('Trámites')").closest("li").remove();
    	}
    	
    	if(ACC.hideMenuFacturacion == true)
    	{	
    		$("a:contains('Facturación')").closest("li").remove();
    	}
    	
    	if(ACC.hideMenuDeclaraciones == true)
    	{	
    		$("a:contains('Declaraciones')").closest("li").remove();
    	}
    	
    	if(ACC.hideMenuPagos == true)
    	{	
    		$("a:contains('Pagos')").closest("li").remove();
    	}
    	
    	if(ACC.hideMenuConsultas == true)
    	{	
    		$("a:contains('Consultas')").closest("li").remove();
    	}
    	
    	
    	
    	
    	
    	
    	
    	if(ACC.hideSubmenuDelineacionUrbana == true)
    	{	
    		$("a:contains('Delineación Urbana')").closest("li").remove();
    	}
    	
    	if(ACC.hideSubmenuICA == true)
    	{	
    		$("a:contains('Delineación Urbana')").closest("li").remove();
    	}
    	
    	if(ACC.hideSubmenuICA == true)
    	{	
    		$("a:contains('Delineación Urbana')").closest("li").remove();
    	}
    	
    	if(ACC.hideSubmenuICA == true)
    	{	
    		$("a:contains('ICA')").closest("li").remove();
    	}
    	
    	if(ACC.hideSubmenuPredial == true)
    	{	
    		$("a:contains('Predial unificado')").closest("li").remove();
    	}
    	
    	if(ACC.hideSubmenuPublicidadExt == true)
    	{	
    		$("a:contains('Publicidad exterior')").closest("li").remove();
    	}
    	
    	if(ACC.hideSubmenuVehicular == true)
    	{	
    		$("a:contains('Sobre vehículos automotores')").closest("li").remove();
    	}
    	
    	if(ACC.hideSubmenuGasolina == true)
    	{	
    		$("a:contains('Sobretasa a la gasolina')").closest("li").remove();
    	}
    	
    },
    
    passwordStrength: function () {
        $('.password-strength').pstrength({
            verdicts: [ACC.pwdStrengthTooShortPwd,
                ACC.pwdStrengthVeryWeak,
                ACC.pwdStrengthWeak,
                ACC.pwdStrengthMedium,
                ACC.pwdStrengthStrong,
                ACC.pwdStrengthVeryStrong],
            minCharText: ACC.pwdStrengthMinCharText
        });
    },
    bindToggleOffcanvas: function () {
        $(document).on("click", ".js-toggle-sm-navigation", function () {
            ACC.global.toggleClassState($("main"), "offcanvas");
            ACC.global.toggleClassState($("html"), "offcanvas");
            ACC.global.toggleClassState($("body"), "offcanvas");
            ACC.global.resetXsSearch();
        });
    },
    bindToggleXsSearch: function () {
        $(document).on("click", ".js-toggle-xs-search", function () {
            ACC.global.toggleClassState($(".site-search"), "active");
            ACC.global.toggleClassState($(".js-mainHeader .navigation--middle"), "search-open");
        });
    },
    resetXsSearch: function () {
        $('.site-search').removeClass('active');
        $(".js-mainHeader .navigation--middle").removeClass("search-open");
    },
    toggleClassState: function ($e, c) {
        $e.hasClass(c) ? $e.removeClass(c) : $e.addClass(c);
        return $e.hasClass(c);
    },
    showMenu: function(menuItem){
        var $menuItem = $(menuItem),
            itemWidth = $menuItem.width();
        var $subNav = $menuItem.find('.js_sub__navigation'),
            subNavWidth = $subNav.outerWidth();
        var $mainNav = $('.js_navigation--bottom'),
            mainNavWidth = $mainNav.width();
        // get the left position for sub-navigation to be centered under each <li>
        var leftPos = ($menuItem.position().left) + (itemWidth / 2) - (subNavWidth / 2);
        // get the top position for sub-navigation. this is usually the height of the <li> unless there is more than one row of <li>
        var topPos = $menuItem.position().top + $menuItem.height();
        if (leftPos > 0 && leftPos + subNavWidth < mainNavWidth) {
            // .sub-navigation is within bounds of the .main-navigation
            $subNav.css({
                "left": leftPos,
                "top": topPos,
                "right": "auto"
            });
        } else if (leftPos < 0) {
            // .suv-navigation can't be centered under the <li> because it would exceed the .main-navigation on the left side
            $subNav.css({
                "left": 0,
                "top": topPos,
                "right": "auto"
            });
        } else if (leftPos + subNavWidth > mainNavWidth) {
            // .suv-navigation can't be centered under the <li> because it would exceed the .main-navigation on the right side
            $subNav.css({
                "right": 0,
                "top": topPos,
                "left": "auto"
            });
        }
        $menuItem.addClass("show-sub");
        $menuItem.siblings().removeClass("show-sub");
    },
    bindHoverIntentMainNavigation: function () {
        enquire.register("screen and (min-width:" + screenMdMin + ")", {
            match: function () {
                // on screens larger or equal screenMdMin (1024px) calculate position for .sub-navigation
            	$("nav.navigation--bottom > .navigation__overflow > ul > li > span > a").focus(function () {
                	ACC.global.showMenu($(this).parent().parent());
                });
                $("nav.navigation--bottom > .navigation__overflow > ul > li").hoverIntent(function () {
                	ACC.global.showMenu(this);
                },function () {
                    $(this).removeClass("show-sub");
                });
            },
            unmatch: function () {
                // on screens smaller than screenMdMin (1024px) remove inline styles from .sub-navigation and remove hoverIntent
                $("nav.navigation--bottom > .navigation__overflow > ul > li .js_sub__navigation").removeAttr("style");
                $("nav.navigation--bottom > .navigation__overflow > ul > li").hoverIntent(function () {
                    // unbinding hover
                });
            }
        });
    },
    initImager: function (elems) {
        elems = elems || '.js-responsive-image';
        this.imgr = new Imager(elems);
    },
    reprocessImages: function (elems) {
        elems = elems || '.js-responsive-image';
        if (this.imgr === undefined) {
            this.initImager(elems);
        } else {
            this.imgr.checkImagesNeedReplacing($(elems));
        }
    },
    // usage: ACC.global.addGoogleMapsApi("callback function"); // callback function name like "ACC.global.myfunction"
    addGoogleMapsApi: function (callback) {
        if (callback !== undefined && $(".js-googleMapsApi").length === 0) {
            $('head').append('<script class="js-googleMapsApi" type="text/javascript" src="//maps.googleapis.com/maps/api/js?key=' + ACC.config.googleApiKey + '&sensor=false&callback=' + callback + '"></script>');
        } else if (callback !== undefined) {
            eval(callback + "()");
        }
    },
    backToHome: function () {
        $(".backToHome").on("click", function () {
            var sUrl = ACC.config.contextPath;
            window.location = sUrl;
        });
    },

    bindDropdown: function() {
    	$(document).on("click", ".dropdown-toggle", dropdownToggle);
    },

    closeAccAlert: function () {
        $(".closeAccAlert").on("click", function () {
            $(this).parent('.getAccAlert').remove();
        });
    },

  //***** Dropdown begins *****

    dropdownParent: function($this) {
        var selector = $this.attr('href')
        selector = selector && (/#[A-Za-z]/).test(selector) && selector.replace(/.*(?=#[^\s]*$)/, ''); // strip for ie7
        var $parent = selector && $(selector);
        return $parent && $parent.length ? $parent : $this.parent();
    },

    dropdownClearMenus: function(e) {
    	// if right click, exit
        if (e && e.which === 3)
        	return;
        // remove class added on dropdownToggle
        $('.dropdown-backdrop').remove();
        $(".dropdown-toggle").each(function () {
          var $parent       = dropdownParent($(this))
          if (!$parent.hasClass('open'))
        	  return;
          if (e && e.type === 'click' && (/input|textarea/i).test(e.target.tagName) && $.contains($parent[0], e.target))
        	  return;
          $parent.removeClass('open');
        })
      },

     dropdownToggle: function(e) {
    	var $this = $(this)
        if ($this.is('.disabled, :disabled'))
        	return;
        var $parent  = dropdownParent($this);
        var isActive = $parent.hasClass('open');
        dropdownClearMenus();

        if (!isActive) {
          if ('ontouchstart' in document.documentElement && !$parent.closest('.navbar-nav').length) {
            // if mobile we use a backdrop because click events don't delegate
            $(document.createElement('div'))
              .addClass('dropdown-backdrop')
              .insertAfter($(this))
              .on('click', dropdownClearMenus)
          }
          if (e.isDefaultPrevented())
        	  return;
          // expand the <ul> on the dropdown
          $this.trigger('focus').attr('aria-expanded', 'true');
          // set parent to open
          $parent.toggleClass('open');
        }
        return false;
    }
    //***** Dropdown ends *****
};