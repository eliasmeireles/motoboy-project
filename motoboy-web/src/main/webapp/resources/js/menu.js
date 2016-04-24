$(init); 

function init() {
	$(".nav-link-login").click(login);
	$(".title-motoboy").click(motoboyLogin);
	$(".title-cliente").click(clienteLogin);
	$(".menu-responsiv").click(subMenuMobile);
	$(".memove-menu").click(subMenuMobile);
	$(".remove-login").click(loginReste);
	
	function subMenuMobile() {
		loginReste();
		$('.menu-container').toggleClass("active-menu");
		$('.menu-nav-bar').toggleClass("active-menu");
		$('.memove-menu').toggleClass("remover");
	}
	
	function login() {
		subMenuMobile();
		$('.login-form').toggleClass("active");
		$('.remove-login').toggleClass("active-login");
	}
	
	function motoboyLogin() {
		$('.motoboy-login_container').toggleClass("active");
		$('.clinete-login').toggleClass("hidden");
		$('.cliente-login_container').removeClass("active");
	}
	function clienteLogin() {
		$('.cliente-login_container').toggleClass("active");
		$('.motoboy-login').toggleClass("hidden");
		$('.motoboy-login_container').removeClass("active");
	}
	
	function loginReste() {
		$('.login-form').removeClass("active");
		$('.remove-login').removeClass("active-login");
		$('.motoboy-login_container').removeClass("active");
		$('.clinete-login').removeClass("active hidden");
		$('.cliente-login_container').removeClass("active");
		$('.cliente-login_container').removeClass("active");
		$('.motoboy-login').removeClass("active hidden");
		$('.motoboy-login_container').removeClass("active");
	}
}