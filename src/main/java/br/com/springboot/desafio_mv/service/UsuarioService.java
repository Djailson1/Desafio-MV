package br.com.springboot.desafio_mv.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.springboot.desafio_mv.dto.Usuario.UsuarioEntradaDTO;
import br.com.springboot.desafio_mv.model.Usuario;
import br.com.springboot.desafio_mv.repository.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository repository;
	
	public void criarUsuario(UsuarioEntradaDTO uDTO) {		
		repository.criarUsuario(uDTO.getUsuarioCpf(), uDTO.getUsuarioNome());
	}
	
	public Usuario buscaUsuarioPorId(Long id) {
		Usuario usuarioSaida = repository.buscaUsuarioPorId(id);
		
		if(usuarioSaida == null)
			throw new RuntimeException("ID " + id + " não pertence a nenhum usuário.");
		
		return usuarioSaida;
	}
	
	public List<Usuario> listaUsuarios(){
		List<Usuario> listaUsuarios = repository.listaUsuarios();
		
		if(listaUsuarios.isEmpty())
			throw new RuntimeException("Não existem registros pra listar.");
		
		return listaUsuarios;
	}
	
	public Long buscaUltimoId() {
		return repository.buscaUltimoId();		
	}
	
	public void atualizarUsuario(Usuario u) {
		Usuario usuarioSaida = buscaUsuarioPorId(u.getUsuarioId());
		
		repository.atualizarUsuario(usuarioSaida.getUsuarioNome(), usuarioSaida.getUsuarioCpf());
	}
	
	public void deletarUsuario(Usuario u) {
		Usuario usuarioSaida = buscaUsuarioPorId(u.getUsuarioId());
		
		repository.deletarUsuario(usuarioSaida.getUsuarioId());
	}
}
