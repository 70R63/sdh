ACC.chat = {
        _autoload: ["chatPopover"],
            chatPopover: function(){
                $("[data-toggle=popover]").webuiPopover({
                  html: true,
                  trigger: 'click',
                  closeable: false,
                  arrow: 'no',
                  offsetLeft: 0,
                  width: $('.pop-over').width() + 80,
                  content: function() {
                    return $('#popover-content').html();
                  },
                  onShow: function() {
	                	var total_left = parseInt((parseInt($('.webui-popover').css('left') ,10) + parseInt(5, 10)), 10) + parseInt(($(window).width() - ($('.webui-popover').offset().left + $('.webui-popover').outerWidth())), 10);
	                	var total_top = parseInt($('.webui-popover').css('top'), 10) - parseInt($(document).scrollTop(), 10);
	                	$('.webui-popover').css({"left": total_left, "top": total_top});
                  }
               });
               $(document).on("click", ".popover .close" , function(e){
                  $(".popover").webuiPopover('hide');
                  e.preventDefault();
                });
                $(document).on("click", ".js-newWindow", function() {
                	$("[data-toggle=popover]").webuiPopover('hide');
                    var $this = $(this);
                    var url = $this.attr("value");
                    window.open(url,'chat-window', 'width=475, height=460').focus();
                  });
                $('#close').click(function(){
                   window.close();
                });
}};