package br.com.springboot.desafio_mv.dto.Cafe;

import br.com.springboot.desafio_mv.model.Usuario;

public class CafeSaidaDTO {

	private Long cafeId;
	private String itemCafe;
	private Usuario usuario;

	public Long getCafeId() {
		return cafeId;
	}

	public void setCafeId(Long cafeId) {
		this.cafeId = cafeId;
	}

	public String getItemCafe() {
		return itemCafe;
	}

	public void setItemCafe(String itemCafe) {
		this.itemCafe = itemCafe;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
}
