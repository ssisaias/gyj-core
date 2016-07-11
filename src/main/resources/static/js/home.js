window.onload = function(){
	
}

function adicionarNaPlaylist(id,event) {
		if(id != null)
		window.location.href="addvideo?id="+id;
		alert("Video " + id + " adicionado.");
}