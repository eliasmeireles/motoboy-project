$(init);

function init() {
	$(".link-login").click(subMenuMobile);
	$(".toggle-login").click(subMenuMobile);

	function subMenuMobile() {
		$('.toggle-login').toggleClass("active");
		$('.btn-login').find('.login-container').toggleClass("active");
	}
}
$(window).scroll(function (event) {
	$('.toggle-login').removeClass("active");
	$('.btn-login').find('.login-container').removeClass("active");
});