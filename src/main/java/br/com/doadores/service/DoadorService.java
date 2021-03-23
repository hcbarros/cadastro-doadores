package br.com.doadores.service;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.doadores.repository.DoadorRepository;


@Service
public class DoadorService {

	@Autowired
	private DoadorRepository repository;
	
	
	
}
