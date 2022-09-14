package edu.caensup.sio.td0.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.view.RedirectView;

import edu.caensup.sio.td0.models.Element;

@Controller
@SessionAttributes("items")
@RequestMapping("/items")
public class MainController {
	
	private Element getElementByName(@SessionAttribute List<Element> items, @PathVariable String nom) {
		
		int index = items.indexOf(new Element(nom, 1));
		return items.get(index);
		
	}

	@ModelAttribute("items") 
    public List<Element> getItems(){
        return new ArrayList<>();
    }
	
	@RequestMapping("")
	public String index() {
		return "/index";
	}
	
	@GetMapping("/new")
	public String addNew() {
		return "/newForm";
	}
	
	@PostMapping("/new")
	public RedirectView addNewSubmit(@SessionAttribute List<Element> items, @RequestParam String nom) {
		
		String[] noms = nom.trim().split("\n");
		
		for (String nm : noms) {
			
			if(nm != "") {
				items.add(new Element(nm, 1));
			}
			
		}
		
		return new RedirectView("/items");
		
	}
	
	@GetMapping("/inc/{nom}")
	public RedirectView incEval(@SessionAttribute List<Element> items, @PathVariable String nom) {
		
		getElementByName(items, nom).inc();
		return new RedirectView("/items");
		
	}
	
	@GetMapping("/dec/{nom}")
	public RedirectView decEval(@SessionAttribute List<Element> items, @PathVariable String nom) {
		
		getElementByName(items, nom).dec();
		return new RedirectView("/items");
		
	}
	
	@GetMapping("/delete/{nom}")
	public RedirectView removeEval(@SessionAttribute List<Element> items, @PathVariable String nom) {
		
		items.remove(items.indexOf(new Element(nom, 1)));
		return new RedirectView("/items");
		
	}
	
}
