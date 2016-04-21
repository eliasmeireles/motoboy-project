$(window).scroll(function (event) {
	var offsetHeight = $('.header-menu').height();
	var carouselPosition   = parseInt($('#como-funciona').offset().top);
	var scrollTop     = $(window).scrollTop() + offsetHeight;
	
	if (scrollTop == carouselPosition ) {
		initCarousel();
	}
});

function initCarousel() {
	startSlide();
	$(".previous").click(previous);
	$(".next").click(slide);
}
function previous() {
	stopSlide();
	var slideSize = $('.slide').length;
	var activeSlide = $($('.slide.active')).index();
	
	$($('.slide')[activeSlide]).removeClass('active active-to-right slide-off');
	
	if(activeSlide === 0) {
		activeSlide = slideSize;
	}
	
	$($('.slide')[activeSlide - 1]).addClass('active active-to-right').removeClass('slide-off');
	startSlide();
}


function slide() {
	stopSlide();
	var active = $(".slide.active");
	var next = active.next('.slide');

	if (!next.length > 0) {
		next = $($('.slide')[0]);
	}
	
	$('.slide').removeClass('active-to-right');
	active.toggleClass('active').addClass('slide-off');
	next.toggleClass('active').addClass("slide-off");
	startSlide();
}

function stopSlide() {
    clearInterval(interval);
    interval = null;
}
function startSlide() {
	interval = setInterval(slide, 7000);
	return interval;
};