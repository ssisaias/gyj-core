package com.ufc.web.gyj.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.google.api.services.youtube.model.ResourceId;
import com.google.api.services.youtube.model.SearchResult;
import com.google.api.services.youtube.model.Thumbnail;
import com.ufc.web.gyj.model.MyVideo;
import com.ufc.web.gyj.youtube.Search;

@Controller
public class PlaylistController {
	
	@RequestMapping(value={"/home"})
	public String home(Model model, @RequestParam(required=false,name="q") String query){
		//System.err.println(query);
		if (query ==null || query.isEmpty()) {
			model.addAttribute("vazio",true);
			return "/user/home";
		}
		List<SearchResult> lista = Search.pesquisar(query);
		if (lista == null || lista.size() == 0) {
			model.addAttribute("vazio",true);
		}
		else{
			List<MyVideo> videos = new ArrayList<MyVideo>(); 
			Iterator<SearchResult> iResults = lista.iterator();
			while (iResults.hasNext()) {

			      SearchResult singleVideo = iResults.next();
			      ResourceId rId = singleVideo.getId();
			      // Double checks the kind is video.
			      if (rId.getKind().equals("youtube#video")) {
			        Thumbnail thumbnail = (Thumbnail) singleVideo.getSnippet().getThumbnails().get("default");
			        MyVideo v = new MyVideo();
			        v.id = rId.getVideoId();
			        v.titulo = singleVideo.getSnippet().getTitle();
			        v.thumbnail = thumbnail.getUrl();
			        videos.add(v);
			      }
			    }
			model.addAttribute("videosList", videos);
		}
		return "/user/home";
	}
	
	@RequestMapping("/home/addvideo")
	public String removerUser(HttpServletRequest request){
		if(request.getParameter("id")!= null){
			//adiciona o video na playlist
			String id = request.getParameter("id");
			System.err.println(id);
		}
		
		return "redirect:/admin/index";
	}
}
