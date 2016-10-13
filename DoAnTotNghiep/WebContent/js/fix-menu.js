$(document).ready(function() {
	var documentEl = $(document);
	var flag = true; //để chỉ xảy ra 1 lần thôi, kt 1 lần thôi
	
	documentEl.on("scroll", function() {
		var currscrollpos = $(documentEl).scrollTop();
	//	console.log("" + currscrollpos);
		if (currscrollpos > 170 && flag == true) {
			$("#tabMenu").css("position", "fixed");
			$("#tabMenu").css("top","0");
			$("#tabMenu").css("z-index", "2");
			if(currscrollpos >190){
				flag = false;
			}
		}
		
		if (currscrollpos <= 170 && flag == false) {
			$("#tabMenu").css("position", "static");
			if(currscrollpos <150){
				flag = true;
			}
		}
	});
});
