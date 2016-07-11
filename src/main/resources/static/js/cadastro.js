window.onload = function(){
	var nome = document.getElementById("nome");
	var email = document.getElementById("email");
	var senha = document.getElementById("senha");
	var conf = document.getElementById("conf-senha");
	var cadastrar = document.getElementById("cadastrar");
	var span = document.getElementById("span");

	cadastrar.addEventListener('click',campoVazio,false);
	
	function campoVazio(event){
		if(nome.value.length == 0 || email.value.length == 0 || senha.value.length == 0 || conf.value.length == 0){
			event.preventDefault();
			span.innerHTML = "Campo obrigatório em branco, por favor preencher.";
		}
	}
	
}