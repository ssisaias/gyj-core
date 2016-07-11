window.onload = function(){
	var nome = document.getElementById("nome");
	var email = document.getElementById("email");
	var senha = document.getElementById("senha");
	var conf = document.getElementById("conf-senha");
	var cadastrar = document.getElementById("cadastrar");
	var spanCampo = document.getElementById("campos");
	var spanSenha = document.getElementById("confirmarSenha");

	cadastrar.addEventListener('click',campoVazio,false);
	
	function campoVazio(event){
		if(nome.value.length == 0 || email.value.length == 0 || senha.value.length == 0 || conf.value.length == 0){
			event.preventDefault();
			spanCampo.innerHTML = "Campos obrigatórios em branco, por favor preencher.";
		}
		if(senha.value != conf.value){
			event.preventDefault();
			spanSenha.innerHTML = "A senha e a Confirmação da senha devem ser iguais.";
		}
	}
	
}