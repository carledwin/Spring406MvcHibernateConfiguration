package com.cadastro.controller;

import java.util.List;
import java.util.Locale;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cadastro.model.Colaborador;
import com.cadastro.service.ColaboradorService;

@Controller
@RequestMapping("/")
public class ApplicationController {
	
	@Autowired
	private ColaboradorService service;
	
	@Autowired
	private MessageSource messageSource;
	
	@RequestMapping(value={"/", "/list"}, method = RequestMethod.GET)
	public String listAll(ModelMap model){
		List<Colaborador> colaboradores = service.findAllColaboradores();
		model.addAttribute("colaboradores", colaboradores);
		return "colaboradores";
	}
	
	@RequestMapping(value={"/new"}, method = RequestMethod.GET)
	public String newColaborador(ModelMap model){
		Colaborador colaborador = new Colaborador();
		model.addAttribute("colaborador", colaborador);
		model.addAttribute("edit", false);
		
		return "registration";
	}
	
	@RequestMapping(value={"/new"}, method = RequestMethod.POST)
	public String saveColaborador(@Valid Colaborador colaborador, BindingResult result, ModelMap model){
		
		if(result.hasErrors()){
			return "registration";
		}
		
		if(!service.isColaboradorSsnUnique(colaborador.getId(), colaborador.getSsn())){
			FieldError ssnError = new FieldError("colaborador", "ssn", messageSource.getMessage("non.unique.ssn", new String[]{colaborador.getSsn()}, Locale.getDefault()));
			result.addError(ssnError);
			
			return "registration";
		}
		
		service.saveColaborador(colaborador);
		
		model.addAttribute("success", "Colaborador " + colaborador.getName() + "registered successfully.");
		
		return "success";
	}
	
	
	@RequestMapping(value={"/edit-{ssn}-colaborador"}, method = RequestMethod.GET)
	public String editColaborador(@PathVariable String ssn, ModelMap model){
		Colaborador colaborador = service.findColaboradorBySsn(ssn);
		model.addAttribute("colaborador", colaborador);
		model.addAttribute("edit", true);
		
		return "registration";
	}
	
	@RequestMapping(value= {"/edit-{ssn}-colaborador"}, method = RequestMethod.POST)
	public String updateColaborador(@Valid Colaborador colaborador, BindingResult result, ModelMap model, @PathVariable String ssn){
		
		if(result.hasErrors()){
			return "registration";
		}
		
		if(!service.isColaboradorSsnUnique(colaborador.getId(), colaborador.getSsn())){
			FieldError ssnError = new FieldError("colaborador", "ssn", messageSource.getMessage("non.unique.ssn", new String[]{colaborador.getSsn()}, Locale.getDefault()));
			result.addError(ssnError);
			
			return "registration";
		}
		
		service.updateColaborador(colaborador);
		
		model.addAttribute("success", "Colaborador " + colaborador.getName() + "updated successfully.");
		
		return "success";
	}
	
	@RequestMapping(value = {"/delete-{ssn}-colaborador"}, method = RequestMethod.GET)
	public String deleteColaborador(@PathVariable String ssn){
		service.deleteColaboradorBySsn(ssn);
		
		return "redirect:/list";
	}
}
