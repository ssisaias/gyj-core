package com.ufc.web.gyj.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.google.api.services.youtube.model.ResourceId;
import com.google.api.services.youtube.model.SearchResult;
import com.google.api.services.youtube.model.Thumbnail;
import com.ufc.web.gyj.DAO.AcademiaDAO;
import com.ufc.web.gyj.model.Academia;
import com.ufc.web.gyj.model.MyVideo;
import com.ufc.web.gyj.youtube.Search;

import scala.annotation.meta.setter;

@Controller
public class PublicInfoController {
	
	@Autowired
	AcademiaDAO AcadDao;
	
	@RequestMapping(value={"/index","/"})
	public String index(Model model){
		SecurityContext context = SecurityContextHolder.getContext();
		if (context.getAuthentication().getName().equals("anonymousUser")) { //Usuario nao autenticado 
			
		}
		return "index";
	}
	
	@RequestMapping(value={"/academias"})
	public String academias(Model model){
		List<Academia> academias = AcadDao.findAll();
		model.addAttribute("academias", academias);
		return "academias";
	}

	
	@RequestMapping(value={"moderador/cadastroAcademia"})
	public String cadastroAcademia(Model model){
		return "moderador/cadastroAcademia";
	}
	
	@RequestMapping(value={"/cadastro"})
	public String cadastro(Model model){
		return "cadastro";
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
