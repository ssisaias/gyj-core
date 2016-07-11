package com.ufc.web.gyj.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.google.api.services.youtube.model.ResourceId;
import com.google.api.services.youtube.model.SearchResult;
import com.google.api.services.youtube.model.Thumbnail;
import com.ufc.web.gyj.model.MyVideo;
import com.ufc.web.gyj.youtube.Search;

@Controller
public class HomeController {

	@RequestMapping(value={"/index","/"})
	public String index(Model model){
		return "index";
	}
	
	@RequestMapping(value={"moderador/cadastroAcademia"})
	public String cadastroAcademia(Model model){
		return "moderador/cadastroAcademia";
	}
	
	@RequestMapping(value={"/cadastro"})
	public String cadastro(Model model){
		return "cadastro";
	}
	
	@RequestMapping(value={"/home"})
	public String home(Model model){
		List<SearchResult> lista = null;//Search.pesquisar("never gonna goza you up");
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
//			        System.out.println(" Video Id" + rId.getVideoId());
//			        System.out.println(" Title: " + singleVideo.getSnippet().getTitle());
//			        System.out.println(" Thumbnail: " + thumbnail.getUrl());
//			        System.out.println("\n-------------------------------------------------------------\n");
			        MyVideo v = new MyVideo();
			        v.id = rId.getVideoId();
			        v.titulo = singleVideo.getSnippet().getTitle();
			        v.thumbnail = thumbnail.getUrl();
			        videos.add(v);
			      }
			    }
			model.addAttribute("videosList", videos);
		}
		return "home";
	}
	
	@RequestMapping(value={"/login"})
	public String login(Model model){
		return "login";
	}
	
	private static void prettyPrint(Iterator<SearchResult> iteratorSearchResults, String query) {
		
	    System.out.println("\n=============================================================");
	    System.out.println(
	        "   First 25 videos for search on \"" + query + "\".");
	    System.out.println("=============================================================\n");

	    if (!iteratorSearchResults.hasNext()) {
	      System.out.println(" There aren't any results for your query.");
	    }

	    while (iteratorSearchResults.hasNext()) {

	      SearchResult singleVideo = iteratorSearchResults.next();
	      ResourceId rId = singleVideo.getId();

	      // Double checks the kind is video.
	      if (rId.getKind().equals("youtube#video")) {
	        Thumbnail thumbnail = (Thumbnail) singleVideo.getSnippet().getThumbnails().get("default");

	        System.out.println(" Video Id" + rId.getVideoId());
	        System.out.println(" Title: " + singleVideo.getSnippet().getTitle());
	        System.out.println(" Thumbnail: " + thumbnail.getUrl());
	        System.out.println("\n-------------------------------------------------------------\n");
	      }
	    }
	  }
}	
