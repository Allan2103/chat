package edu.ifam.dra.chat.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.ifam.dra.chat.dto.DTOMensagem;
import edu.ifam.dra.chat.model.Mensagem;
import edu.ifam.dra.chat.service.MensagemService;

@RequestMapping("/mensagem")
@RestController
public class MensagemController {

	@Autowired
	MensagemService mensagemService;
	
	@GetMapping("/{id}")
	public ResponseEntity<List<Mensagem>> getMensagensReceptor(@PathVariable Long id){
		try {
			return ResponseEntity.ok(mensagemService.getMensagensReceptor(id));
		} catch(Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ArrayList<Mensagem>());
		}
		
	}
	
	@PostMapping
	ResponseEntity<Mensagem> setContato(@RequestBody @Nullable DTOMensagem dtoMensagem) {
		return ResponseEntity.created(null).body(mensagemService.setMensagemFromDTOMensagem(dtoMensagem));
	}
	
}
