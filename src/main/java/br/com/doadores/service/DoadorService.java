package br.com.doadores.service;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.doadores.model.Doador;
import br.com.doadores.repository.DoadorRepository;


@Service
public class DoadorService {

	@Autowired
	private DoadorRepository repository;
	
	
	public List<Object[]> candidatosPorEstado() {
		return repository.candidatosPorEstado();
	}
		
	public List<Object[]> imcMedioPorFaixaEtaria() {
		return repository.imcMedioPorFaixaEtaria();
	}
	
	public List<Object[]> percentualObesosPorSexo() {
		return repository.percentualObesosPorSexo();
	}
	
	public List<Object[]> mediaIdadePorTipoSanguineo() {
		return repository.mediaIdadePorTipoSanguineo();
	}
	
	public List<Object[]> doadoresPorTipoReceptor() {
		return repository.doadoresPorTipoReceptor();
	}
	
}
