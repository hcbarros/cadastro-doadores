package br.com.doadores.controller;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.doadores.model.Doador;
import br.com.doadores.service.DoadorService;


@RestController
@RequestMapping("/doadores")
public class DoadorController {

	@Autowired
	private DoadorService service;
	
	
	@GetMapping(value = "/candidatosPorEstado")
	public List<Object[]> candidatosPorEstado() {
		return service.candidatosPorEstado();		
	}
	
	@GetMapping(value = "/imcMedioPorFaixaEtaria")
	public List<Object[]> imcMedioPorFaixaEtaria() {
		return service.imcMedioPorFaixaEtaria();		
	}
	
	@GetMapping(value = "/percentualObesosPorSexo")
	public List<Object[]> percentualObesosPorSexo() {
		return service.percentualObesosPorSexo();		
	}
	
	@GetMapping(value = "/mediaIdadePorTipo")
	public List<Object[]> mediaIdadePorTipoSanguineo() {
		return service.mediaIdadePorTipoSanguineo();		
	}
	
	@GetMapping(value = "/doadoresPorTipoReceptor")
	public List<Object[]> doadoresPorTipoReceptor() {
		return service.doadoresPorTipoReceptor();		
	}
	
}


