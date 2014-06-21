
package br.org.pucsc.carteira.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.org.pucsc.carteira.entity.Flag;
import br.org.pucsc.carteira.service.FlagService;

@Controller
@RequestMapping(value = "/flag")
public class FlagController {

	@Autowired
	FlagService flagService;
	
	public FlagService getFlagService() {
		return flagService;
	}

	public void setFlagService(FlagService flagService) {
		this.flagService = flagService;
	}

	@RequestMapping(value="/" ,method = RequestMethod.GET)
	public String getIndex(Model model){
		
		List<Flag> flags = getFlagService().getAll();
		model.addAttribute("flags", flags);
	
		return "flag/list";
	}
	
	@RequestMapping(value="/read" ,method = RequestMethod.GET)
	public String getRead(String id, Model model){
		
		Flag flag = getFlagService().getById(Long.valueOf(id));
		model.addAttribute("flag", flag);
	
		return "flag/edit";
	}
	
	@RequestMapping(value="/new" ,method = RequestMethod.GET)
	public String getNew(Model model){
				
		model.addAttribute("flag", new Flag());
	
		return "flag/edit";
	}
	
	@RequestMapping(value="/delete",method=RequestMethod.GET)
	public String getDelete(HttpServletRequest request){
		String id = request.getParameter("id");
		System.out.println("******** flag delete: "+id);
		
		Flag flag = getFlagService().getById(Long.valueOf(id));
		
		flagService.remove(flag);
		
		return "flag/edit";
	}
	
	@RequestMapping(value="/save",method=RequestMethod.POST)
	public String postSave(HttpServletRequest request){
		
		boolean isCreate = true;
				
		if (request.getParameter("id") != null && !request.getParameter("id").equals("")) {
			isCreate = false;
		}
		
		String description = request.getParameter("description") != null ? request.getParameter("description") : "";
		
		Flag flag = null;
		
		if (isCreate) {
			flag = new Flag();
			
			flag.setDescription(description);
			
		} else {
			flag = getFlagService().getById(Long.valueOf(request.getParameter("id")));

			flag.setDescription(description);
		}

		flag = getFlagService().save(flag);
		
		request.setAttribute("flag",flag);
		
		return "redirect:/flag/";
	}
			
}
