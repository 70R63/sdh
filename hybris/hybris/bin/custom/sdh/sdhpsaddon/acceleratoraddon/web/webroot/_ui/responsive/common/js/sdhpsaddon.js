ACC.publicsector = {
    bindAll: function ()
    {
        this.applyCheckboxClass();
        this.redirectDraftToCheckout();
        this.toggleNavigationMenuForAccessibility();
        this.initOnCheckboxRadioClick();
        this.disableCheckoutSteps();
        this.initDefaultCheckbox();
        this.retrieveRelationshipAllDraft();
        this.retrieveRelationshipAllApplications();
        this.preventConfirmationDraftCodeClick();
        this.applyBackButtonClass();
        this.applyAriaLabelOnLabel();
        this.bindEventonMobileSearch();
        this.closeGloablMessages();
        this.addAriaLabelinColorBox();
        this.accordion();
        this.bindOnAccordian();
        this.tooltip();
        this.stickem();
    },

    accordion: function(){
        $("#accordion").accordion({
            collapsible: true,
            active: false,
            heightStyle: "content",
            create: function(){
                $(this).find('.panel-heading').before('<hr>');
                ACC.publicsector.bindOnAccordian();
            }
        });
        $("#accordion").accordion({icons: {"header": "ui-icon-plus", "activeHeader": "ui-icon-minus"}});
        $('.open').click(function () {
            $('.ui-accordion-header').removeClass('ui-corner-all').addClass('ui-accordion-header-active ui-state-active ui-corner-top').attr({'aria-selected': 'true'});
            $('.ui-accordion-header .ui-icon').removeClass('ui-icon-triangle-1-e').addClass('ui-icon-triangle-1-s');
            $('.ui-accordion-content').addClass('ui-accordion-content-active').attr({'aria-expanded': 'true','aria-hidden': 'false'}).show();
            $(this).hide();
            $('.close').show();
        });
        $('.close').click(function () {
            $('.ui-accordion-header').removeClass('ui-accordion-header-active ui-state-active ui-corner-top').addClass('ui-corner-all').attr({'aria-selected': 'false'});
            $('.ui-accordion-header .ui-icon').removeClass('ui-icon-triangle-1-s').addClass('ui-icon-triangle-1-e');
            $('.ui-accordion-content').removeClass('ui-accordion-content-active').attr({'aria-expanded': 'false','aria-hidden': 'true'}).hide();
            $(this).hide();
            $('.open').show();
        });
        $('.ui-accordion-header').click(function () {
            $('.open').show();
            $('.close').show();
            ACC.publicsector.bindAccordionIcon(this);
            ACC.publicsector.bindAccordionHtml();
            ACC.publicsector.initOnAccordian($(this).find('.accordion-toggle'));
        });
        $('#accordion .panel-heading').each(function(){
            $(this).removeAttr('tabindex role aria-selected');
        });
        $(document).on("keydown", ".accordion-toggle", function(e) {
            if (e.keyCode === 32 || e.keyCode === 0 || e.keyCode === 13) {
                if($(this).hasClass('relationDocumentsLink')){
                    ACC.account.bindRelationshipUserDocuments(this);
                }else if($(this).hasClass('relationApplicationsLink')){
                    ACC.account.bindRelationshipUserApplications(this);
                }else if($(this).hasClass('relationAddressesLink')){
                    ACC.address.bindRelationshipUserAddresses(this);
                }else if($(this).hasClass('relationbillsLink')){
                    ACC.account.bindRelationshipUserBills(this);
                }
                ACC.publicsector.bindAccordionIcon($(this).parents('.ui-accordion-header'));
                ACC.publicsector.bindAccordionHtml();
                ACC.publicsector.initOnAccordian(this);
                $(this).attr('aria-expanded', $(this).parents('.ui-accordion-header').attr('aria-expanded'));
            }
        });
    },

    bindAccordionIcon: function(thisObject)
    {
        if($(thisObject).find('.ui-accordion-header-icon').hasClass('ui-icon-plus')){
            $(thisObject).find('.accordion-toggle').addClass('ui-icon-plus');
        }else{
            $(thisObject).find('.accordion-toggle').removeClass('ui-icon-plus');
        }
    },

    bindAccordionHtml: function(){
        $('.ui-accordion-header').each(function() {
            ACC.publicsector.bindAccordionIcon(this);
        });
        $('#accordion .panel-heading').each(function(){
            $(this).removeAttr('tabindex role aria-selected');
        });

    },

    initOnAccordian: function(thisObject){
        var accordianHeading,accordianHeading_new;
        accordianHeading = $(thisObject).find('span.accordian-heading').html();
        accordianHeading_new = accordianHeading.replace(/&amp;/g, '&');
        if($(thisObject).attr('aria-expanded')==="true"){
            $(thisObject).attr({'aria-expanded': 'true', 'aria-label': accordianHeading_new +' '+ PSACC.textNotExpanded});
        }else if($(thisObject).attr('aria-expanded')==="false"){
            $(thisObject).attr({'aria-expanded': 'false', 'aria-label': accordianHeading_new +' '+ PSACC.textExpanded});
        }
        ACC.publicsector.bindAllAccordian(thisObject);

    },

    bindAllAccordian: function(thisObject){
        $('#accordion .accordion-toggle').not(thisObject).each(function(){
            ACC.publicsector.bindAccordianHeading();
        });
    },

    bindOnAccordian: function(){
        $('#accordion .accordion-toggle').each(function(){
            ACC.publicsector.bindAccordianHeading();
        });

        var $no_accordian = $('.no-accordian').parents('.ui-accordion-content').prev('div.panel-heading').find('.panel-title a');
        $no_accordian.removeClass('accordion-toggle').removeAttr('href aria-label aria-expanded');
        $('.no-accordian').parents('.ui-accordion-content').addClass('show');
        $no_accordian.on('click', function(){
            return false;
        });
    },

    tooltip: function(){
        $('.glyphicon-question-sign').tooltip({
            position: {
                my: "center bottom-20",
                at: "center top",
                using: function( position, feedback ) {
                    $( this ).css( position );
                    $( "<div>" )
                        .addClass( "arrow" )
                        .addClass( feedback.vertical )
                        .addClass( feedback.horizontal )
                        .appendTo( this );
                }
            }
        });
    },
    stickem: function(){
        $(document).ready(function() {
            $('.global-content-space').stickem();
            $(function() {
                $.fn.scrollBottom = function() {
                    return $(document).height() - this.scrollTop() - this.height();
                };
                var $el = $('.stickem');
                var $window = $(window);

                $window.bind("scroll resize", function() {
                    var footer_height = $('.main-footer').height() + $('.main-footer .container-fluid').height()
                    var scroll_container = footer_height -$('.main-footer .container-fluid').height();
                    var visibleFoot = footer_height - $window.scrollBottom();
                    var gap = $window.height() - $el.height() - 10;
                    var scrollTop = $window.scrollTop();
                    if(scrollTop < scroll_container + 10){
                        $el.css({
                            top: (scroll_container - scrollTop) + "px",
                            bottom: "auto"
                        });
                    }else if (visibleFoot > gap) {
                        if($('.stickem .col-sm-4').height()>1000){
                            visibleFoot = footer_height - $window.scrollBottom() + footer_height;
                        }
                        $el.css({
                            top: "auto",
                            bottom: visibleFoot + "px"
                        });
                    }else{
                        $el.css({
                            top: 0,
                            bottom: "auto"
                        });
                    }
                });
            });
        });
    },


    retrieveRelationshipAllDraft: function()
    {
        $(document).on('click', 'button.retrieveRelationshipDraftsLink', function(e) {
        	e.preventDefault();
            ACC.publicsector.retrieveSubmitFormAction(this);
        });
    },
    retrieveRelationshipAllApplications: function()
    {
        $(document).on('click', 'button.retrieveRelationshipApplicationsLink',  function(e) {
        	e.preventDefault();
            ACC.publicsector.retrieveSubmitFormAction(this);
        });
    },
    redirectDraftToCheckout: function()
    {
        $("#draftConfirmationRegistered a:first").on('click', function(e){
            e.preventDefault();
            var $retrieveDraft = $(this);
            var $form = $retrieveDraft.closest('form');
            $form.submit();
        });
    },
    applyCheckboxClass: function() {
        if($('input[type="checkbox"]').is(':checked')){
            $('.checkbox label.control-label').addClass('checked');
            $(this).parent('.checkbox').attr('aria-checked','true');
        }else{
            $('.checkbox label.control-label').removeClass('checked');
            $(this).parent('.checkbox').attr('aria-checked','false');
        }
        $(document).on('click', '.checkbox label.control-label', function() {
            var isCheck = $(this).find('input[type="checkbox"]').prop('checked');
            if(isCheck === false) {
                $(this).find('input[type="checkbox"]').prop('checked', true);
                $(this).parent('.checkbox').attr( 'aria-checked','true');
                $(this).addClass('checked');
            } else {
                $(this).find('input[type="checkbox"]').prop('checked', false);
                $(this).parent('.checkbox').attr( 'aria-checked','false');
                $(this).removeClass('checked');
            }
            $(this).trigger('checkboxClick');
        });
    },
    toggleNavigationMenuForAccessibility: function(){
        $('.js-toggle-sm-navigation').off('click').on('click', function(){
            $('.navigation--bottom').show();
        });
        $('.close-nav .glyphicon-remove').off('click').on('click', function(){
            $('.navigation--bottom').hide();
        });
        $('.nav__links--primary .nav__link--drill__down').attr({'tabindex': '0',"aria-label": PSACC.headerOpenSubMenus});
        $(document).on('keypress', '.js-enquire-offcanvas-navigation .js-enquire-has-sub .js_nav__link--drill__down', function(e) {
            if (e.keyCode === 32 || e.keyCode === 0) {
                $(this).trigger('click');
            }
        });
    },
    initOnCheckboxRadioClick: function () {
        $('.card-section-content .checkbox.consentDeclaration').attr( 'tabindex','0');
        $(document).on('keypress',
            'span.xforms-items span, .card-section-content .checkbox.consentDeclaration, .checkout-step-paymentmethod .form-group .checkbox, .form-group .checkbox',
                function(e) {
            if (e.keyCode === 32 || e.keyCode === 0) {
                $(this).find('label.checkbox, label.radio, label.consentDeclarations, label.control-label').trigger('click');
                ACC.yform.addAriaCheckboxRadioAttribute();
            }
        });
        $(document).on("keypress", ".form-group .checkbox", function(e) {
            if (e.keyCode === 32 || e.keyCode === 0 || e.keyCode === 13) {
                if($(this).find('label').hasClass('usePrimaryAddressShip')){
                    ACC.publicsector.initCheckboxOnKeypress(this);
                    ACC.address.usePrimaryAddressShippingContent();
                    ACC.publicsector.initDefaultCheckbox();
                }else if($(this).find('label').hasClass('saveAddressInMyAddressBook') ||
                    $(this).find('label').hasClass('defaultAddress') ||
                    $(this).find('label').hasClass('savePaymentMethod')){
                    ACC.publicsector.initCheckboxOnKeypress(this);
                }else if($(this).find('label').hasClass('useShippingAddress')){
                    ACC.publicsector.initCheckboxOnKeypress(this);
                    $('#useShippingAddress').trigger('change');
                }else if($(this).find('label').hasClass('usePrimaryAddress')){
                    ACC.publicsector.initCheckboxOnKeypress(this);
                    $('#usePrimaryAddress').trigger('change');
                }else{
                    ACC.publicsector.initCheckboxOnKeypress(this);
                    $(this).find('input[type="checkbox"]').trigger("change");
                }
            }
        });
    },
    disableCheckoutSteps: function(){
        $('.checkout-steps .not_visited').off('click').on('click',function(e) {
            e.preventDefault();
            return false;
        });
    },
    initCheckboxOnKeypress: function(thisObject){
        var isCheck = $(thisObject).find('input[type="checkbox"]').is(':checked');
        if(isCheck === false) {
            $(thisObject).find('input[type="checkbox"]').prop('checked', true);
            $(thisObject).attr( 'aria-checked','true');
            $(thisObject).find('label.control-label').addClass('checked');
        } else {
            $(thisObject).find('input[type="checkbox"]').prop('checked', false);
            $(thisObject).attr( 'aria-checked','false');
            $(thisObject).find('label.control-label').removeClass('checked');
        }
    },
    initDefaultCheckbox: function(){
        $( ".checkbox label.control-label" ).each(function() {
            var isCheck = $(this).find('input[type="checkbox"]').prop('checked');
            if(isCheck === false) {
                $(this).find('input[type="checkbox"]').prop('checked', false);
                $(this).parent('.checkbox').attr( 'aria-checked','false');
                $(this).removeClass('checked');
            }else{
                $(this).find('input[type="checkbox"]').prop('checked', true);
                $(this).parent('.checkbox').attr( 'aria-checked','true');
                $(this).addClass('checked');
            }
        });
    },
    preventConfirmationDraftCodeClick: function(){
        $(document).on('click', '.reference-no', function(e){
            e.preventDefault();
            return false;
        });
    },
    applyBackButtonClass: function(){
        $(document).on("ready", function(){
            if(navigator.userAgent.toLowerCase().indexOf('firefox') > -1){
                $('.account-section').addClass('account-sections-backButton');
                $('.mobile-menu .js-toggle-sm-navigation, .mobile__nav__row--btn.js-toggle-sm-navigation').addClass('header-MegaMenu');
                $(document).bind('cbox_complete', function(){
                    $("#cboxClose").addClass("colorBox-cboxClose");
                });
                $('.grid-item.dashlet-application-request, .grid-item.dashlet-aboutMe, .grid-item.dashlet-addressBook').addClass('dashlet-action-buttons');
                $('.myDraftsList').addClass('drafts-list-buttons');
            }else if((navigator.userAgent.match(/Trident/) || navigator.userAgent.match(/rv:11/)) || (typeof $.browser !== "undefined" && $.browser.msie === 1)){
                $('.account-section').addClass('account-sections-backIcon');
            }
            $(document).bind('cbox_complete', function(){
                $("#cboxClose").addClass("cboxClose");
            });
        });
    },
    applyAriaLabelOnLabel: function(){
        $(document).on("ready ajaxComplete", function(){
            $('label.control-label,.orbeon label.xforms-label, legend').each(function(){
                $(this).attr( 'aria-label',$.trim($(this).html().replace(/<[^>]*>/g, "")));
            });
            $("span[role='radio']").each(function(i){
                $(this).parents(".fr-grid-content").find("label").attr("id", "radioButton"+(i+1));
                $(this).parents('.fr-grid-content').attr({'role': 'radiogroup','aria-labelledby': 'radioButton'+(i+1)});
            });
        });
    },
    bindEventonMobileSearch: function(){
        $('#js-site-search-input').on('click',function(){
            return false;
        });
    },
    closeGloablMessages: function(){
        $(document).on("click","button.global-alert.close", function(){
            $(this).parents('.global-alerts').hide();
        });
    },
    addAriaLabelinColorBox: function(){
        $(document).on("ready", function(){
            $('#colorbox').attr("aria-labelledby", "customTitle");
        });
    },
    retrieveSubmitFormAction: function(retrieveLinkObj){
    	var $retrieveLink = $(retrieveLinkObj);
        var $form = $retrieveLink.parents('form');
        $form.submit();
    },
    bindAccordianHeading: function(){
        var accordianHeading = $(this).find('span.accordian-heading').html();
        if (accordianHeading) {
            var accordianHeading_new = accordianHeading.replace(/&amp;/g, '&');
            $(this).attr({'aria-expanded': 'false', 'aria-label': accordianHeading_new +' '+PSACC.textNotExpanded});
        }
    }
};
$(document).ready(function()
{
    ACC.publicsector.bindAll();
    $('#usePrimaryAddress').prop('checked', true);
});
