package br.com.springboot.desafio_mv.dto.Usuario;

public class UsuarioSaidaDTO{
	
	private Long usuarioId;
	private String usuarioCpf;
	private String usuarioNome;
	
	public Long getUsuarioId() {
		return usuarioId;
	}
	
	public void setUsuarioId(Long usuarioId) {
		this.usuarioId = usuarioId;
	}
	
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
