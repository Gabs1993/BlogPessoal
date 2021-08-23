package org.generation.BlogPessoal.repository;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.generation.BlogPessoal.model.Usuario;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class UsuarioRepositoryTest {

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@BeforeAll
	void start() {
		
		LocalDate data =  LocalDate.parse("2000-07-22", DateTimeFormatter.ofPattern("yyyy-MM-dd"));
		Usuario usuario = new Usuario(0L, "joao da silva", "joao@gmail.com.br", "13456527", data);
		
		if(!usuarioRepository.findByUsuario(usuario.getUsuario()).isPresent())
			usuarioRepository.save(usuario);
		
		usuario = new Usuario(0L, "Carlos da silva", "carlos@gmail.com.br", "13456527", data);
		
		if(!usuarioRepository.findByUsuario(usuario.getUsuario()).isPresent())
			usuarioRepository.save(usuario);
		
		usuario = new Usuario(0L, "Pedro da silva", "pedro@gmail.com.br", "13456527", data);
		
		if(!usuarioRepository.findByUsuario(usuario.getUsuario()).isPresent())
			usuarioRepository.save(usuario);
		
		usuario = new Usuario(0L, "Paulo Antunes", "paulo@gmail.com.br", "13456527", data);
		
		if(!usuarioRepository.findByUsuario(usuario.getUsuario()).isPresent())
			usuarioRepository.save(usuario);
	}
	
	@Test
	@DisplayName("♨ Retorna Nome")
	public void findByretornaNome() {
		
		Usuario usuario = usuarioRepository.findByNome("joao da silva");
		assertTrue(usuario.getNome().equals("joao da silva"));
	}

	@Test	
	@DisplayName("♨ Retorna 3 usuarios")
	public void findAllByNomeContainingIgnoreCaseRetornaTresUsuarios() { 
		
		List<Usuario>  listaDeUsuarios = usuarioRepository.findAllByNomeContainingIgnoreCase("Silva");
		assertEquals(3, listaDeUsuarios.size());
	}
	
	@AfterAll
	public void end() {
		System.out.println("Teste finalizado");
	}
	
}
