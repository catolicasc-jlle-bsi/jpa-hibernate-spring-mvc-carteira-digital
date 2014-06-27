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
import br.org.pucsc.carteira.entity.Document;
import br.org.pucsc.carteira.entity.Flag;
import br.org.pucsc.carteira.service.BankService;
import br.org.pucsc.carteira.service.DocumentService;
import br.org.pucsc.carteira.service.FlagService;


@Controller
@RequestMapping("/api/card")
public class CardRestService {

	@Autowired
	DocumentService documentCardService;
	
	@Autowired
	BankService bankService;
	
	@Autowired
	FlagService flagService;
	
	@RequestMapping(method = RequestMethod.GET)
	public @ResponseBody List<Document> listCards() {

		List<Document> cards = documentCardService.getAll(); 
		return cards;
	}
	
	@RequestMapping(value="{id}", method = RequestMethod.GET)
	public @ResponseBody Document readCard(@PathVariable Long id) {
 
		Document card = documentCardService.getById(id);
		return card;
	}
	
	@RequestMapping(value="{id}", method = RequestMethod.DELETE)
	@ResponseStatus(value = HttpStatus.OK)
	public void deleteCard(@PathVariable Long id) {

		Document card = documentCardService.getById(id);
		documentCardService.remove(card);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	@ResponseStatus(value = HttpStatus.OK)
	public void postCard(@RequestBody Document card) {
		
		card.setId(null);
		documentCardService.save(card);	
	}
	
	@RequestMapping(method = RequestMethod.PUT)
	@ResponseStatus(value = HttpStatus.OK)
	public void putCard(@RequestBody Document card) {
		
		documentCardService.save(card);	
	}
}
