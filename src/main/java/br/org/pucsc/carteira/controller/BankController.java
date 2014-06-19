
package br.org.pucsc.carteira.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.org.pucsc.carteira.entity.Bank;
import br.org.pucsc.carteira.service.BankService;

@Controller
@RequestMapping(value = "/bank")
public class BankController {

	@Autowired
	BankService bankService;
	
	public BankService getBankService() {
		return bankService;
	}

	public void setBankService(BankService bankService) {
		this.bankService = bankService;
	}

	@RequestMapping(value="/" ,method = RequestMethod.GET)
	public String getIndex(Model model){
		
		List<Bank> banks = getBankService().getAll();
		model.addAttribute("banks", banks);
	
		return "bank/list";
	}
	
	@RequestMapping(value="/read" ,method = RequestMethod.GET)
	public String getRead(String id, Model model){
		
		Bank bank = getBankService().getById(Long.valueOf(id));
		model.addAttribute("bank", bank);
	
		return "bank/edit";
	}
	
	@RequestMapping(value="/new" ,method = RequestMethod.GET)
	public String getNew(Model model){
				
		model.addAttribute("bank", new Bank());
	
		return "bank/edit";
	}
	
	@RequestMapping(value="/delete",method=RequestMethod.GET)
	public String getDelete(HttpServletRequest request){
		String id = request.getParameter("id");
		System.out.println("******** bank delete: "+id);
		
		Bank bank = getBankService().getById(Long.valueOf(id));
		
		bankService.remove(bank);
		
		return "bank/edit";
	}
	
	@RequestMapping(value="/save",method=RequestMethod.POST)
	public String postSave(HttpServletRequest request){
		
		boolean isCreate = true;
				
		if (request.getParameter("id") != null && !request.getParameter("id").equals("")) {
			isCreate = false;
		}
		
		String code = request.getParameter("code") != null ? request.getParameter("code") : "";
		String description = request.getParameter("description") != null ? request.getParameter("description") : "";
		
		Bank bank = null;
		
		if (isCreate) {
			bank = new Bank();
			
			bank.setDescription(description);
			bank.setCode(code);
			
		} else {
			bank = getBankService().getById(Long.valueOf(request.getParameter("id")));

			bank.setDescription(description);
			bank.setCode(code);
		}

		bank = getBankService().save(bank);
		
		request.setAttribute("bank",bank);
		
		return "redirect:/bank/";
	}
			
}
