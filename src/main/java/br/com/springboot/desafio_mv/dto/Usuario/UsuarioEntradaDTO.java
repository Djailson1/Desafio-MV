package br.com.springboot.desafio_mv.dto.Usuario;

public class UsuarioEntradaDTO {
	
	private String usuarioCpf;
	private String usuarioNome;

	public String getUsuarioCpf() {
		return usuarioCpf;
	}

	public void setUsuarioCpf(String usuarioCpf) {
		this.usuarioCpf = usuarioCpf;
	}

	public String getUsuarioNome() {
		return usuarioNome;
	}

	public void setUsuarioNome(String usuarioNome) {
		this.usuarioNome = usuarioNome;
	}
}
