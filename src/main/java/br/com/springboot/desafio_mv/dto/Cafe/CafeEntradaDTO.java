package br.com.springboot.desafio_mv.dto.Cafe;

import br.com.springboot.desafio_mv.model.Usuario;

public class CafeEntradaDTO {

	private String itemCafe;

	private Usuario usuario;

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
