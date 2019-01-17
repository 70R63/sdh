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
var oDoc = document;
ACC.navigation = {
    _autoload: [
        "myAccountNavigation",
        "offcanvasNavigation",
        "myAccountNavigationToggleMobile"
    ],
    offcanvasNavigation: function(){
        enquire.register("screen and (max-width:"+screenSmMax+")", {
            match: function() {
                $(document).on("click",".js-enquire-offcanvas-navigation .js-enquire-has-sub .js_nav__link--drill__down",function(e){
                    e.preventDefault();
                    $(".js-userAccount-Links").hide();
                    $(".js-enquire-offcanvas-navigation  ul.js-offcanvas-links").addClass("active");
                    $(".js-enquire-offcanvas-navigation .js-enquire-has-sub").removeClass("active");
                    $(this).parent(".js-enquire-has-sub").addClass("active");
                });
                $(document).on("click",".js-enquire-offcanvas-navigation .js-enquire-sub-close",function(e){
                    e.preventDefault();
                    $(".js-userAccount-Links").show();
                    $(".js-enquire-offcanvas-navigation  ul.js-offcanvas-links").removeClass("active");
                    $(".js-enquire-offcanvas-navigation .js-enquire-has-sub").removeClass("active");
                });
            },
            unmatch: function() {
                $(".js-userAccount-Links").show();
                $(".js-enquire-offcanvas-navigation  ul.js-offcanvas-links").removeClass("active");
                $(".js-enquire-offcanvas-navigation .js-enquire-has-sub").removeClass("active");
                $(document).off("click",".js-enquire-offcanvas-navigation .js-enquire-has-sub > a");
                $(document).off("click",".js-enquire-offcanvas-navigation .js-enquire-sub-close");
            }
        });
    },
    myAccountNavigation: function(){
        //copy the site logo
        $('.js-mobile-logo').html( $('.js-site-logo a').clone());
        //Add the order form img in the navigation
        $('.nav-form').html($('<span class="glyphicon glyphicon-list-alt"></span>'));
        var sSignBtn_a ="";
        var myAccountBtn_a ="";
        var sSignBtn_li ="";
        var myAccountBtn_li ="";
        //my account items
        var navClose = '';
        navClose += '<div class="close-nav">';
        navClose += '<button tabindex="0" title="'+PSACC.textCloseMenu+'" aria-label="'+PSACC.textNavClose+
            '" type="button" class="js-toggle-sm-navigation btn"><span class="glyphicon glyphicon-remove"></span></button>';
        navClose += '</div>';
        var headerHyperLinks = $(".liOffcanvas a");

        sSignBtn_li = jQuery( '<li/>' );
        myAccountBtn_li = jQuery( '<li/>' );

        //create Welcome User + expand/collapse and close button
        //This is for mobile navigation. Adding html and classes.
        var oUserInfo = $(".nav__right ul span.logged_in");

        //Check to see if user is logged in
        if(oUserInfo && oUserInfo.length === 1)
        {
            var sUserBtn = '';
            sUserBtn += "<li class=\"auto \">";
            sUserBtn += "<div class=\"userGroup\">";
            sUserBtn += '<span class="glyphicon glyphicon-user myAcctUserIcon"></span>';
            sUserBtn += "<div class=\"userName\">" + oUserInfo[0].innerHTML + "</div>";
            sUserBtn += "<a tabindex=\"0\" aria-label='"+PSACC.signedInUserOptionsToggle+
                "' class=\"collapsed js-nav-collapse\" id=\"signedInUserOptionsToggle\" data-toggle=\"collapse\"  data-target=\".offcanvasGroup1\">";
            sUserBtn += '<span class="glyphicon glyphicon-chevron-up myAcctExp"></span>';
            sUserBtn += '</a>';
            sUserBtn += '</div>';
            sUserBtn += navClose;
            $('.js-sticky-user-group').html(sUserBtn);
            sSignBtn_a = ACC.navigation.createHyperLink(PSACC.textSignInRegister, 'userSign', headerHyperLinks[1]);
        	myAccountBtn_a = ACC.navigation.createHyperLink(PSACC.textMyAccountTitle, 'myAccount', headerHyperLinks[0]);

            sSignBtn_li.attr('class','auto liUserSign').append(sSignBtn_a[0].outerHTML);
            myAccountBtn_li.attr('class','auto liUserAccountLink').append(myAccountBtn_a[0].outerHTML);
            $('.js-userAccount-Links').append(myAccountBtn_li);
            $('.js-userAccount-Links').append(sSignBtn_li);
        } else {
        	sSignBtn_a = ACC.navigation.createHyperLink(PSACC.textSignInRegister, 'userSign', headerHyperLinks[0]);
            sSignBtn_li.attr('class','auto liUserSign').append(sSignBtn_a[0].outerHTML + navClose);
            var navButtons = (sSignBtn_li[0].outerHTML);
            $('.js-sticky-user-group').html(navButtons);
        }
        $('.sub-navigation-section div.title').attr('tabindex','0');
        $(document).on("keypress", ".js-myAccount-toggle, .js_nav__link--drill__down", function(e) {
            ACC.navigation.keypressAction(e);
        });
    },
    createHyperLink: function(title, styleClass, linkElement) {
    	var hyperLink = jQuery( '<a/>' );
    	if (linkElement) {
    		var linkObj = $(linkElement)
    		hyperLink.attr('title', title);
    		hyperLink.attr('class', styleClass);
    		hyperLink.attr('href', linkObj.attr('href'));
    		hyperLink.text(linkObj.text());
    	}
    	return hyperLink;
    },
    myAccountNavigationToggleMobile: function(){
        $(document).on("click", "#signedInUserOptionsToggle", function() {
                $('.offcanvasGroup1').slideToggle(500);
                $(this).find('span.myAcctExp').toggleClass('glyphicon-chevron-down glyphicon-chevron-up');
                $(this).removeAttr('style','');
                return false;
        });
        $(document).on("keypress", "#signedInUserOptionsToggle", function(e) {
            ACC.navigation.keypressAction(e);
        });
    },
    keypressAction: function(e){
       if (e.keyCode === 32 || e.keyCode === 0 || e.keyCode === 13) {
           $(this).trigger('click');
            return false;
        }
        return true;
    }
};
