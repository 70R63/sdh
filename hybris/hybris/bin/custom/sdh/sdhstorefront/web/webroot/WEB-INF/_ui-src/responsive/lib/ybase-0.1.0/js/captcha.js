ACC.captcha = {
	bindAll: function ()
	{
		this.renderWidget();
	},

	renderWidget: function ()
	{
		$.ajax({
			url: ACC.config.encodedContextPath + "/register/captcha/widget/recaptcha",
			type: 'GET',
			cache: false,
			success: function (html)
			{
				if ($(html) != [])
				{
					$(html).appendTo('.js-recaptcha-captchaaddon');
					$.getScript('https://www.google.com/recaptcha/api.js?hl=' + document.documentElement.lang, function ()
					{
					});
				}
			}
		});
	}
};

$(document).ready(function ()
{
	if ($('#loginForm').html() != null )
	{
		ACC.captcha.bindAll();
	}
});
