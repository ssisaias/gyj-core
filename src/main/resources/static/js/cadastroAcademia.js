window.onload = function(){
	
	var nomeAcademia = document.getElementById("nomeAcademia");
	var enderecoAcademia = document.getElementById("enderecoAcademia");
	var cidadeAcademia = document.getElementById("cidadeAcademia");
	var cadastrarAcademia = document.getElementById("cadastrarAcademia");
	var spanAcademia = document.getElementById("spanAcademia");
	
	cadastrarAcademia.addEventListener('click',campoVazioAcademia,false);
	
	function campoVazioAcademia(event){
		if(nomeAcademia.value.length == 0 || enderecoAcademia.value.length == 0 || cidadeAcademia.value.length == 0){
			event.preventDefault();
			spanAcademia.innerHTML = "Campos obrigatórios em branco, por favor preencher.";
		}
	}
}