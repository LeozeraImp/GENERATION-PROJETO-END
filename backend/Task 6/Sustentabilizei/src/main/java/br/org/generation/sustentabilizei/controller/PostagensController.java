package br.org.generation.sustentabilizei.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.org.generation.sustentabilizei.model.Postagens;
import br.org.generation.sustentabilizei.repository.PostagensRepository;

@RestController
@RequestMapping("/postagens")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class PostagensController {
	
	@Autowired
	private PostagensRepository postagensRepository;
	
	@GetMapping
	public ResponseEntity<List<Postagens>> getAll() {
		return ResponseEntity.ok(postagensRepository.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Postagens> getById(@PathVariable long id) {
		return postagensRepository.findById(id)
				.map(resposta -> ResponseEntity.ok(resposta))
				.orElse(ResponseEntity.notFound().build());
	}
	
	@GetMapping("/titulo/{titulo}")
	public ResponseEntity<List<Postagens>> getByTitulo(@PathVariable String titulo) {
		return ResponseEntity.ok(postagensRepository.findAllByTituloContainingIgnoreCase(titulo));
	}
	
	@PostMapping
	public ResponseEntity<Postagens> postCategoria(@RequestBody Postagens postagens){
		return ResponseEntity.status(HttpStatus.CREATED).body(postagensRepository.save(postagens));	
	}
	
	@PutMapping
	public ResponseEntity<Postagens> putPostagens(@RequestBody Postagens postagens) {
		return postagensRepository.findById(postagens.getId())
				.map(resposta -> ResponseEntity.ok(postagensRepository.save(postagens)))
				.orElse(ResponseEntity.notFound().build());
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable long id) {
		return postagensRepository.findById(id)
				.map(check -> {
					postagensRepository.deleteById(id);
					return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
					})
					.orElse(ResponseEntity.notFound().build());
				}
	}

