ACC.close = {
    _autoload: [
        ["bindCloseAccountModalButtons", $(".js-close-account-popup-button").length !== 0],
        ["bindCloseAccountButton", $(".js-close-account-popup-button").length !== 0]
    ],

    bindCloseAccountModalButtons: function () {
        $('.js-close-account-popup-button').click(function (event) {
            event.preventDefault();
            var popupTitle = $('.js-close-account-popup-button').data("popupTitle");
            ACC.colorbox.open(popupTitle, {
                inline: true,
                href: "#popup_confirm_account_removal",
                className: "js-close-account-popup",
                width: '500px',
                onComplete: function () {
                	$('#cboxTitle').insertBefore('#cboxLoadedContent');
                 	$('#cboxClose').insertBefore('#cboxLoadedContent');
                 	$('#cboxTitle').find('.headline .headline-text').attr({'aria-label': popupTitle, 'tabindex': '0', 'id': 'customTitle'});
                 	$('#cboxClose').attr({'aria-label': PSACC.textCloseOverlay,'tabindex': '0'});
                    $(this).colorbox.resize();
                }
            })
        });
    },

    bindCloseAccountButton: function () {
        $(document).on("click", '.js-close-account-action', function (event) {
            event.preventDefault();
            var url = ACC.config.encodedContextPath + '/my-account/close-account';
            $.ajax({
                url: url,
                type: 'POST',
                success: function (response) {
                    ACC.colorbox.close();
                    var urlClose = ACC.config.encodedContextPath + '/logout?closeAcc=true'
                    window.location.replace(urlClose);
                },
                error: function (jqXHR, textStatus, errorThrown) {
                    alert("Failed to close account. Error: [" + errorThrown + "]"); // NOSONAR
                    window.location.reload();
                }
            });
        });
    }
};
