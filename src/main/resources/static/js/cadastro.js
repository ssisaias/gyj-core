window.onload = function(){
	var nomeUser = document.getElementById("nome");
	var emailUser = document.getElementById("email");
	var senha = document.getElementById("senha");
	var conf = document.getElementById("conf-senha");
	var cadastrarUser = document.getElementById("cadastrar");
	var spanCampo = document.getElementById("errorCampos");
	var spanSenha = document.getElementById("errorSenha");

	cadastrarUser.addEventListener('click',campoVazioUser,false);
	
	function campoVazioUser(event){
		if(nomeUser.value.length == 0 || emailUser.value.length == 0 || senha.value.length == 0 || conf.value.length == 0){
			event.preventDefault();
			spanCampo.style.color = "red";
			spanCampo.innerHTML = "Campos obrigatórios em branco, por favor preencher.";
		}
		if(senha.value != conf.value){
			event.preventDefault();
			spanSenha.style.color = "red";
			spanSenha.innerHTML = "A senha e a Confirmação da senha devem ser iguais.";
		}
	}
}