package br.org.pucsc.carteira.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class IndexController {

	  @RequestMapping("/")
	  public String execute() {
		  
	      return "welcome";
	  }
	
}


