package edu.ifam.dra.chat.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.ifam.dra.chat.model.Mensagem;

@Repository
public interface MensagemRepository extends JpaRepository<Mensagem, Long> {

}
