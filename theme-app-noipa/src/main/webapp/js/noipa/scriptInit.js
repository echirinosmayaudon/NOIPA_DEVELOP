		// Menu Mobile
		//$('.toggle-menu').jPushMenu();
		var leftMenu = -320;
		function shMenu(){
			if($('.cbp-spmenu').css("left")==0){
				moveLeft = leftMenu;
			} else {
				moveLeft = 0;
			}
			$('.cbp-spmenu').css("left",moveLeft)
		}
		$(function () {
			$(".jPushMenuBtn").click(function(e) {
				shMenu();
				e.preventDefault();
			});
			$(window).click(function() {
				$('.cbp-spmenu').css("left",leftMenu)
			});
			$('.cbp-spmenu, .jPushMenuBtn').click(function(event){
				event.stopPropagation();
			});
			
			$(window).resize(formatSidebar);
			formatSidebar();

//			function formatSidebar() {
//				if ($(window).width() < 768) {
//				  $('#menu').removeClass('navbar-collapse bs-navbar-collapse collapse p-0');
//				  $('#menu').addClass('cbp-spmenu cbp-spmenu-vertical cbp-spmenu-left shadow');
//				  //$('#menu').append($(".header .social"));
//				  
//				  //Ricerca si sposta nella barra in modalità mobile
//				  if($("#divBarSearch #navSearch").length==0){
//					$("#divBarSearch").append($("#navSearch"))
//				  }
//				  
//				} else {
//				  $('#menu').addClass('navbar-collapse bs-navbar-collapse collapse p-0');
//				  $('#menu').removeClass('cbp-spmenu cbp-spmenu-vertical cbp-spmenu-left shadow');
//				}
//			};
			
			
			function formatSidebar() {
				if ($(window).width() < 768) {
				  $('#menu').removeClass('navbar-collapse bs-navbar-collapse collapse p-0');
				  $('#menu').addClass('cbp-spmenu cbp-spmenu-vertical cbp-spmenu-left shadow');
				  
				  //Ricerca si sposta nella barra in modalità mobile
				  if($("#divBarSearch #navSearch").length==0){
				$("#divBarSearch").append($("#navSearch"))
				  }
				  //Aggiungi pulsante chiudi menu
				  if($("#menu #chiudi").length==0){
				$("#menu").prepend('<button id="chiudi" class="toggle-menu sr-only">Chiudi il menu</button>')
				  }
				  //Social si sposta nel menu modalità mobile
				  $('#menu').append($(".header div.social"))
				  
				} else {
				  $('#menu').addClass('navbar-collapse bs-navbar-collapse collapse p-0');
				  $('#menu').removeClass('cbp-spmenu cbp-spmenu-vertical cbp-spmenu-left shadow');
				  
				  //Social si sposta nel menu modalità mobile
				  $('.header .d-none.d-md-block.col-sm-4.col-md-4.col-lg-3').prepend($("#menu div.social"))
				}
			};
			
		});
		
		
		$('.link-video').click(function (e) {
			e.preventDefault();
			var src = $(this).attr("href")
			//alert(src)
			//var src = 'https://www.youtube.com/embed/zpOULjyy-n8?rel=0';
			$('#modalVideo').modal('show');
			$('#modalVideo iframe').attr('src', src);
		});
	
		$('#modalVideo button').click(function () {
			$('#modalVideo iframe').removeAttr('src');
		});
		
		$("body").prepend('<a class="scrollTop" href="#wrapper" aria-label="'+translateBackOnTop()+'" title="'+translateBackOnTop() +'">'+'<span class="fa fa-chevron-circle-up"></span></a>');
		$(window).scroll(function() {
			if ($(this).scrollTop() >= 250) {
				$('.scrollTop').fadeIn(200);
				
				//Ricerca si sposta nella barra in modalità mobile
				$("#divBarSearch").append($("#navSearch"))
				$("#slide-nav").addClass("affix").removeClass("affix-top")
			} else {
				$('.scrollTop').fadeOut(200);
				if ($(window).width() > 768) {
					//Ricerca si sposta nella header in modalità full
					$("#divSearch").append($("#navSearch"))
				}

				
				$("#slide-nav").removeClass("affix").addClass("affix-top")
				
			}
		});
		$('.scrollTop').click(function(e) {
			$('body,html').animate({
				scrollTop : 0
			}, 500);
			e.preventDefault();
		});
		
		
		// CookieBar
		opts = {
		  'acceptButton': '.cookieBarAccept',
		  'secure': false,
		  'path': '/cl',
		  'domain': ''
		}
		//$('.cookiebar').cookieBar(opts);
		
		if (navigator.userAgent.indexOf("MSIE 10") > -1) {
		    document.body.classList.add("ie10");
		}
		
		function translateBackOnTop() {
		var localeLang=Liferay.ThemeDisplay.getLanguageId();
			switch(localeLang) {
				case 'it_IT':
					return 'Torna su';
				case 'de_DE':
					return 'Wieder oben';
				case 'en_US':
					return 'Back on top';
			}
		}