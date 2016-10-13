$(document).ready(function(){
var includes = $(".include");
jQuery.each(includes, function() {
	var file = $(this).data("include") + ".jsp";
	$(this).load(file);
});
});
