package org.generation.BlogPessoal.repository;

import java.util.List;

import org.generation.BlogPessoal.model.tema;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TemaRepository extends JpaRepository<tema, Long> {
	public List<tema> findAllByDescricaoContainingIgnoreCase(String descricao);

}
