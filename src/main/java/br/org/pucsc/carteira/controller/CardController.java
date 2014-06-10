
package br.org.pucsc.carteira.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.org.pucsc.carteira.entity.DocumentCard;
import br.org.pucsc.carteira.service.DocumentCardServiceImpl;

@Controller
@RequestMapping(value = "/card")
public class CardController {

	@Autowired
	DocumentCardServiceImpl documentCardService;
	
	public DocumentCardServiceImpl getDocumentCardService() {
		return documentCardService;
	}

	public void setDocumentCardService(DocumentCardServiceImpl documentCardService) {
		this.documentCardService = documentCardService;
	}

	@RequestMapping(value="/" ,method = RequestMethod.GET)
	public String getIndex(Model model){
		
		List<DocumentCard> cards = getDocumentCardService().getAll();
		model.addAttribute("cards", cards);
	
		return "card/list";
	}
	
	@RequestMapping(value="/read" ,method = RequestMethod.GET)
	public String getRead(String id, Model model){
		
		DocumentCard card = getDocumentCardService().getById(Long.valueOf(id));
		model.addAttribute("card", card);
	
		return "card/edit";
	}
	
	@RequestMapping(value="/new" ,method = RequestMethod.GET)
	public String getNew(Model model){
				
		model.addAttribute("card", new DocumentCard());
	
		return "card/edit";
	}
	
	@RequestMapping(value="/delete",method=RequestMethod.GET)
	public String getDelete(HttpServletRequest request){
		String id = request.getParameter("id");
		System.out.println("******** card delete: "+id);
		
		DocumentCard card = getDocumentCardService().getById(Long.valueOf(id));
		
		documentCardService.remove(card);
		
		return "card/edit";
	}
	
	@RequestMapping(value="/save",method=RequestMethod.POST)
	public String postSave(HttpServletRequest request){
		
		boolean isCreate = true;
				
		if (request.getParameter("id") != null && !request.getParameter("id").equals("")) {
			isCreate = false;
		}
		
		String name = request.getParameter("name") != null ? request.getParameter("name") : "";
		String cardName = request.getParameter("cardName") != null ? request.getParameter("cardName") : "";
		String cardNumber = request.getParameter("cardNumber") != null ? request.getParameter("cardNumber") : "";
		String dateValidatedMounth = request.getParameter("dateValidatedMounth") != null ? request.getParameter("dateValidatedMounth") : "";
		String dateValidatedYear = request.getParameter("dateValidatedYear") != null ? request.getParameter("dateValidatedYear") : "";
		String verifyCode = request.getParameter("verifyCode") != null ? request.getParameter("verifyCode") : "";
		
		DocumentCard card = null;
		
		if (isCreate) {
			card = new DocumentCard();
			
			card.setName(name);
			card.setCardName(cardName);
			card.setCardNumber(cardNumber);
			card.setDateValidatedMounth(dateValidatedMounth);
			card.setDateValidatedYear(dateValidatedYear);
			card.setVerifyCode(verifyCode);
			
		} else {
			card = getDocumentCardService().getById(Long.valueOf(request.getParameter("id")));
			
			card.setName(name);
			card.setCardName(cardName);
			card.setCardNumber(cardNumber);
			card.setDateValidatedMounth(dateValidatedMounth);
			card.setDateValidatedYear(dateValidatedYear);
			card.setVerifyCode(verifyCode);
		}

		card = getDocumentCardService().save(card);
		
		request.setAttribute("card",card);
		
		return "redirect:/card/";
	}
			
}
