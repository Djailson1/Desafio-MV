package br.com.springboot.desafio_mv.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.springboot.desafio_mv.dto.Cafe.CafeEntradaDTO;
import br.com.springboot.desafio_mv.model.Cafe;
import br.com.springboot.desafio_mv.model.Usuario;
import br.com.springboot.desafio_mv.repository.CafeRepository;
import br.com.springboot.desafio_mv.repository.UsuarioRepository;

@Service
public class CafeService {

	@Autowired
	private CafeRepository repository;
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	public void criarItemCafe(CafeEntradaDTO cDTO, Long usuario_id) {
		Usuario usuario = usuarioRepository.buscaUsuarioPorId(usuario_id);
		if(usuario == null) {
			throw new RuntimeException("Usuário com ID " + usuario_id + " não existe. Informe um ID de usuário existente.");
		}

		repository.criarItemCafe(cDTO.getItemCafe(), usuario.getUsuarioId());
	}
	
	public Long buscaUltimoId() {
		return repository.buscaUltimoId();		
	}
	
	public Cafe buscaCafePorId(Long id) {
		Cafe cafeSaida = repository.buscaCafePorId(id);
		
		if(cafeSaida == null)
			throw new RuntimeException("ID " + id + " não pertence a nenhum item de café da manhã.");
		
		return cafeSaida;
	}
}
