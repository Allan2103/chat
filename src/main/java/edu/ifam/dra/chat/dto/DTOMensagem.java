package edu.ifam.dra.chat.dto;

import java.util.Calendar;

import edu.ifam.dra.chat.model.Mensagem;

public class DTOMensagem {
	
	private Long id;
	
	private Calendar dataHora;
	private String conteudo;
	private Long emissor;
	private Long receptor;
	
	public DTOMensagem() {
	}
	
	public DTOMensagem(Mensagem mensagem) {
		this.id = mensagem.getId();
		this.dataHora = mensagem.getDataHora();
		this.conteudo = mensagem.getConteudo();
		this.emissor = mensagem.getEmissor().getId();
		this.receptor = mensagem.getReceptor().getId();
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Calendar getDataHora() {
		return dataHora;
	}
	public void setDataHora(Calendar dataHora) {
		this.dataHora = dataHora;
	}
	public String getConteudo() {
		return conteudo;
	}
	public void setConteudo(String conteudo) {
		this.conteudo = conteudo;
	}
	public Long getEmissor() {
		return emissor;
	}
	public void setEmissor(Long emissor) {
		this.emissor = emissor;
	}
	public Long getReceptor() {
		return receptor;
	}
	public void setReceptor(Long receptor) {
		this.receptor = receptor;
	}
	
	

}
