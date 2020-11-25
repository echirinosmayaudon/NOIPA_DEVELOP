/*test per eliminari gli errori del validatore w3c*/
$(window).on("load",function() {
$('#yui3-css-stamp').appendTo('body');
	$('link').each(function(){
		$(this).removeAttr('charset');
	});
});
/*test per eliminari gli errori del validatore w3c*/

$(document).ready(function(){
$('body').keyup(function(e){	
 if (e.key=== "Tab"){
	  $('body').addClass("navTabellare");
  }else{
	  $('body').removeClass("navTabellare"); 
  }
});	

$('body').click(function(e){	
  $('body').removeClass("navTabellare"); });
}
);
	