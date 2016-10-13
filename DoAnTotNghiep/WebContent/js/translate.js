$(document).ready(function(){
	$("#translate").on("click",function(){
	 	var source=$("#source").val();
	 	var dest= $("#dest").val();
	 	var text= $("#mytext").val();
	 	
	 	$.ajax({
	 		url : "https://glosbe.com/gapi/translate",
	 		data : "from="+source+"&dest="+dest+"&format=json&phrase="+text+"&callback=?",
	 		dataType: "json",
	 		success : function(response){
	 			var result = response.result;
	 			var jsonArray= response.tuc;
	 			var data="";
	 			if(jsonArray.length !=0){
		 			for(var i=0; i<jsonArray.length; i++){
		 				data = data+""+i+". "+jsonArray[i].phrase.text+"\n";
		 			}
		 			$("#result").val(""+data);
	 			}
	 			else {
	 				$("#result").val("not found");
	 			}
	 		},
	 		error : function(errormessage){
	 			alert("error :" + errormessage);
	 		},
	 	});
	});
});
