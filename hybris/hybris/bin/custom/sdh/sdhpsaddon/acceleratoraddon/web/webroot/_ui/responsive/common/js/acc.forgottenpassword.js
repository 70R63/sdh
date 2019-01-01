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
ACC.forgottenpassword = {

	_autoload: [
		"bindLink"
	],

	bindLink: function(){
		$(document).on("click",".js-password-forgotten",function(e){
			e.preventDefault();

			ACC.colorbox.open(
				$(this).data("cboxTitle"),
				{
					href: $(this).attr("href"),
					width: "350px",
					fixed: true,
					top: 150,
					onOpen: function()
					{
						$('#validEmail').remove();
					},
					onComplete: function(){
						$('#cboxTitle').insertBefore('#cboxLoadedContent');
		            	$('#cboxClose').insertBefore('#cboxLoadedContent');
		            	$('.headline-text').attr({'aria-label': $('#cboxTitle .headline-text').html(),'tabindex': '0','id': 'customTitle'});
		            	$('#cboxClose').attr({'aria-label': PSACC.textCloseOverlay,'tabindex': '0'});
						$('form#forgottenPwdForm').ajaxForm({
							success: function(data)
							{
								if ($(data).closest('#validEmail').length)
								{
									if ($('#validEmail').length === 0)
									{
										$(".forgotten-password").replaceWith(data);
										ACC.colorbox.resize();
									}
								}
								else
								{
									$("#forgottenPwdForm .control-group").replaceWith($(data).find('.control-group'));
									ACC.colorbox.resize();
								}
							}
						});
					}
				}
			);
		});
		$(document).ready(function() {
			$(".forgot-password-disabled").addClass("js-password-forgotten").removeClass("forgot-password-disabled");
		});
	}

};