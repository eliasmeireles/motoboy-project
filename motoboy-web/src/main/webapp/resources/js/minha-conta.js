$(init);

function init() {
	var faturas = $(".minhas-faturas-data");
	var alterarCartao = $(".alterar-cartao");
	var cancelar = $(".cancelar-conta");
	var minhaConta = $(".minha-conta-option");
	
	$(".faturas").click(minha_faturas);
	$(".alterar").click(alterar_cartao);
	$(".cancelar").click(cancelar_conta);
	
	function minha_faturas() {
		conta();
		faturas.removeClass("hidden");
	};
	function alterar_cartao() {
		conta();
		alterarCartao.removeClass("hidden");
	};
	function cancelar_conta() {
		conta();
		cancelar.removeClass("hidden");
	};
	function conta() {
		minhaConta.addClass("hidden");
	};
};