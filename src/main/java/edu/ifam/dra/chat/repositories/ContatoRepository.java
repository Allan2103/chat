package edu.ifam.dra.chat.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.ifam.dra.chat.model.Contato;

@Repository
public interface ContatoRepository extends JpaRepository<Contato, Long> {
	
}
