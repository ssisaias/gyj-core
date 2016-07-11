window.onload = function(){
	var nomeUser = document.getElementById("nome");
	var emailUser = document.getElementById("email");
	var senha = document.getElementById("senha");
	var conf = document.getElementById("conf-senha");
	var cadastrarUser = document.getElementById("cadastrar");
	var spanCampo = document.getElementById("campos");
	var spanSenha = document.getElementById("confirmarSenha");

	cadastrarUser.addEventListener('click',campoVazioUser,false);
	
	function campoVazioUser(event){
		if(nomeUser.value.length == 0 || emailUser.value.length == 0 || senha.value.length == 0 || conf.value.length == 0){
			event.preventDefault();
			spanCampo.innerHTML = "Campos obrigatórios em branco, por favor preencher.";
		}
		if(senha.value != conf.value){
			event.preventDefault();
			spanSenha.innerHTML = "A senha e a Confirmação da senha devem ser iguais.";
		}
	}
	
	var nomeAcademia = document.getElementById("nomeAcademia");
	var enderecoAcademia = document.getElementById("enderecoAcademia");
	var cidadeAcademia = document.getElementById("cidadeAcademia");
	var emailAcademia = document.getElementById("emailAcademia");
	var telefoneAcademia = document.getElementById("telefoneAcademia");
	var cadastrarAcademia = document.getElementById("cadastrarAcademia");
	var spanAcademia = document.getElementById("camposAcademia");
	
	cadastrarAcademia.addEventListener('click',campoVazioAcademia,false);
	
	function campoVazioAcademia(event){
		if(nomeAcademia.value.length == 0 || enderecoAcademia.value.length == 0 || cidadeAcademia.value.length == 0){
			event.preventDefault();
			spanAcademia.innerHTML = "Campos obrigatórios em branco, por favor preencher.";
		}
	}
}