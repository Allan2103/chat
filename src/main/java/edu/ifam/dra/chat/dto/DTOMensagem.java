package edu.ifam.dra.chat.dto;

import edu.ifam.dra.chat.model.Mensagem;

public class DTOMensagem {
	private String mensagem;
	private long idEmissor;
	private long idReceptor;
	
	public DTOMensagem() {}
	
	public DTOMensagem(Mensagem mensagem) {
		super();
		this.mensagem = mensagem.getConteudo();
		this.idEmissor = mensagem.getEmissor().getId();
		this.idReceptor = mensagem.getReceptor().getId();
	}

	public String getMensagem() {
		return mensagem;
	}

	public long getIdEmissor() {
		return idEmissor;
	}

	public long getIdReceptor() {
		return idReceptor;
	}


}
