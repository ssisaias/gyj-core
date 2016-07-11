window.onload = function(){
	
}

function adicionarNaPlaylist(id,event) {
		if(id != null)
		window.location.href="/home/addvideo?id="+id;
		alert("Video " + id + " adicionado.");
}