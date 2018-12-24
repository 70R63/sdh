ACC.dashboard = {
	_autoload: [
		"bindDashboard"
	],

	bindDashboard: function(){
		$('.grid').masonry({
			 columnWidth: '.grid-sizer',
			 gutter: '.gutter-sizer',
			 itemSelector: '.grid-item',
			 percentPosition: true,
			 horizontalOrder: true
	   });
	}
};



