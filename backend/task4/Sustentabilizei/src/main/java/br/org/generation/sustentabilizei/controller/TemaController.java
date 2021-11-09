package br.org.generation.sustentabilizei.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.org.generation.sustentabilizei.model.Tema;
import br.org.generation.sustentabilizei.repository.TemaRepository;

@RestController
@RequestMapping ("/temas")
@CrossOrigin (origins= "*", allowedHeaders= "*")
public class TemaController {

	@Autowired
	private TemaRepository temaRepository;
	
	@GetMapping
	public ResponseEntity <List<Tema>> getAll()
	{
		return ResponseEntity.ok(temaRepository.findAll());
	
	}
	
	
}