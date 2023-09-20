package edu.ifam.dra.chat.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.ifam.dra.chat.model.Mensagem;
import edu.ifam.dra.chat.service.MensagemService;
import edu.ifam.dra.chat.dto.DTOMensagem;

@RequestMapping("/mensagem")
@RestController
public class MensagemController {

	@Autowired
	MensagemService mensagemService;
	
	DTOMensagem dtoMensagem;

	@GetMapping
	ResponseEntity<List<Mensagem>> getMensagem(){
		List<Mensagem> mensagens = mensagemService.getMensagens();
		if(mensagens.isEmpty())
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(mensagens);
		return ResponseEntity.ok(mensagens);
		
	}
	
	@GetMapping("/{id}")
	ResponseEntity<Mensagem> getMensagem(@PathVariable Long id) {
		try {
			return ResponseEntity.ok(mensagemService.getMensagem(id));
		} catch(Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new Mensagem());
		}
		
	}
	
	@PostMapping
	ResponseEntity<Mensagem> setMensagem(@RequestBody Mensagem mensagem) {
		mensagemService.setMensagem(mensagem);
		return ResponseEntity.created(null).body(mensagem);
	}
	
	@PutMapping("/{id}")
	ResponseEntity<Mensagem> setMensagem(@RequestBody Mensagem mensagem, @PathVariable Long id) {
		try {
			return ResponseEntity.accepted().body(mensagemService.setMensagem(id, mensagem));
		} catch(Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new Mensagem());
		}
	
	}
	
	@DeleteMapping("/{id}")
	ResponseEntity<Mensagem> deleteContato(@PathVariable Long id) {
		try {
			mensagemService.deleteMensagem(id);
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(new Mensagem());
		
		}catch(Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new Mensagem());
		}
	}
	
}
