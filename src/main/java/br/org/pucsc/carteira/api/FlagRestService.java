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

import br.org.pucsc.carteira.entity.Flag;
import br.org.pucsc.carteira.service.FlagService;


@Controller
@RequestMapping("/api/flag")
public class FlagRestService {

	@Autowired
	FlagService flagService;
	
	@RequestMapping(value="/", method = RequestMethod.GET)
	public @ResponseBody List<Flag> listFlags() {

		List<Flag> flags = flagService.getAll(); 
		return flags;
	}
	
	@RequestMapping(value="{id}", method = RequestMethod.GET)
	public @ResponseBody Flag readFlag(@PathVariable Long id) {
 
		Flag flag = flagService.getById(id);
		return flag;
	}
	
	@RequestMapping(value="{id}", method = RequestMethod.DELETE)
	@ResponseStatus(value = HttpStatus.OK)
	public void deleteFlag(@PathVariable Long id) {

		Flag flag = flagService.getById(id);
		flagService.remove(flag);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	@ResponseStatus(value = HttpStatus.OK)
	public void postFlag(@RequestBody Flag flag) {
		
		flagService.save(flag);	
	}
	
	@RequestMapping(method = RequestMethod.PUT)
	@ResponseStatus(value = HttpStatus.OK)
	public void putFlag(@RequestBody Flag flag) {
		
		flagService.save(flag);	
	}
}
