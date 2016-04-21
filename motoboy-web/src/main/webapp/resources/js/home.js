$(function() {

	$('.menu-nav-bar .nav-link .navication-link').click(function() {
		var link = $(this).attr('href');
		if (link.indexOf('#') > -1) {
			var a = link.substring(0, link.indexOf('#'));

			if (a === location.pathname) {
				link = link.substring(link.indexOf('#'));
			}

			link;
			$(this).attr('href', link);
			smoothScroll($($.attr(this, 'href')));
		}
	});
});

function smoothScroll(target) {
	var offsetHeight = $('.header-menu').height();
	
	$('html, body').animate({
		scrollTop : target.offset().top - offsetHeight
	}, 500);
}

function trocaAtivo(element) {
	var active = document.querySelector('.nav-link-active');
	if (active) {
		active.classList.remove('nav-link-active')
	}
	element.classList.add('nav-link-active');
}