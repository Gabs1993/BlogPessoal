package org.generation.BlogPessoal.controller;

import java.util.List;

import org.generation.BlogPessoal.model.tema;
import org.generation.BlogPessoal.repository.TemaRepository;
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

@RestController
@CrossOrigin (origins = "*", allowedHeaders = "*" )
@RequestMapping ("/tema")
public class TemaController<Tema> {

		@Autowired
		private TemaRepository repository;
		
		@GetMapping
		public ResponseEntity<List<tema>> getAll () {
			return ResponseEntity.ok(repository.findAll());
		}
		
		@GetMapping ("/{id}")
		public ResponseEntity<tema> getById (@PathVariable Long id) {
			return repository.findById(id).map(resp -> ResponseEntity.ok(resp))
					.orElse(ResponseEntity.notFound().build());
		}
		
		@GetMapping("/descricao/{descricao}")
		public ResponseEntity<List<tema>> getByName(@PathVariable String descricao){
			return ResponseEntity.ok(repository.findAllByDescricaoContainingIgnoreCase(descricao));
		}
		
		@PostMapping
		public ResponseEntity<tema> post (@RequestBody tema tema){
			return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(tema));
		}
		
		@PutMapping
		public ResponseEntity<tema> put (@RequestBody tema tema){
			return ResponseEntity.ok(repository.save(tema));
		}
		@DeleteMapping("/{id}")
		public void delete (@PathVariable long id) {
			repository.deleteById(id);
		}
		
		
}
