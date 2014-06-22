package br.org.pucsc.carteira.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import br.org.pucsc.carteira.entity.Bank;
import br.org.pucsc.carteira.service.BankService;

@Controller
@RequestMapping("/api/bank")
public class BankRestService {

	@Autowired
	BankService bankService;
	
	@RequestMapping(value="/", method = RequestMethod.GET)
	public @ResponseBody List<Bank> listBanks() {

		List<Bank> banks = bankService.getAll(); 
		return banks;
	}
	
	@RequestMapping(value="{id}", method = RequestMethod.GET)
	public @ResponseBody Bank readBank(@PathVariable Long id) {
 
		Bank bank = bankService.getById(id);
		return bank;
	}
	
	@RequestMapping(value="{id}", method = RequestMethod.DELETE)
	@ResponseStatus(value = HttpStatus.OK)
	public void deleteBank(@PathVariable Long id) {

		Bank bank = bankService.getById(id);
		bankService.remove(bank);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	@ResponseStatus(value = HttpStatus.OK)
	public void postBank(@RequestBody Bank bank) {
		
		bankService.save(bank);	
	}
	
	@RequestMapping(method = RequestMethod.PUT)
	@ResponseStatus(value = HttpStatus.OK)
	public void putBank(@RequestBody Bank bank) {

		bankService.save(bank);
	}
}
