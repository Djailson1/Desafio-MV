package br.com.springboot.desafio_mv.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.springboot.desafio_mv.dto.Usuario.ConverteUsuarioParaDTO;
import br.com.springboot.desafio_mv.dto.Usuario.UsuarioSaidaDTO;
import br.com.springboot.desafio_mv.model.Usuario;
import br.com.springboot.desafio_mv.service.UsuarioService;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/api/usuario")
public class UsuarioController {

	@Autowired
	private UsuarioService service;

	@Autowired
	private ConverteUsuarioParaDTO dto;

	@PostMapping("/criar")
	public ResponseEntity<UsuarioSaidaDTO> criarUsuario(@RequestBody Usuario usuario) {

		service.criarUsuario(dto.entradaUsuarioDTO(usuario));

		Long ultimoId = service.buscaUltimoId();
		UsuarioSaidaDTO usuarioSaida = dto.saidaUsuarioDTO(service.buscaUsuarioPorId(ultimoId));

		return new ResponseEntity<>(usuarioSaida, HttpStatus.CREATED);
	}

	@PutMapping("/editar/{usuario_id}")
	public ResponseEntity<UsuarioSaidaDTO> atualizarUsuario(@PathVariable("usuario_id") Long usuario_id, @RequestBody Usuario usuario) {
		Usuario usuarioEntrada = service.buscaUsuarioPorId(usuario_id);

		usuarioEntrada.setUsuarioNome(usuario.getUsuarioNome());
		service.atualizarUsuario(usuarioEntrada);

		UsuarioSaidaDTO usuarioSaida = dto.saidaUsuarioDTO(service.buscaUsuarioPorId(usuarioEntrada.getUsuarioId()));

		return new ResponseEntity<>(usuarioSaida, HttpStatus.OK);
	}
	
	@DeleteMapping("/excluir/{usuario_id}")
	public ResponseEntity<UsuarioSaidaDTO> deletarUsuario(@PathVariable("usuario_id") Long usuario_id) {
		Usuario usuarioEntrada = service.buscaUsuarioPorId(usuario_id);

		service.deletarUsuario(usuarioEntrada);

		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	@GetMapping("/buscar/{usuario_id}")
	public ResponseEntity<UsuarioSaidaDTO> buscarUsuarioPorId(@PathVariable("usuario_id") Long usuario_id) {
		UsuarioSaidaDTO usuarioSaida = dto.saidaUsuarioDTO(service.buscaUsuarioPorId(usuario_id));

		return new ResponseEntity<>(usuarioSaida, HttpStatus.OK);
	}
	
	@GetMapping("/")
	public ResponseEntity<List<UsuarioSaidaDTO>> listaUsuarios() {
		List<UsuarioSaidaDTO> usuariosSaida = dto.listaSaidaUsuarioDTO(service.listaUsuarios());

		return new ResponseEntity<>(usuariosSaida, HttpStatus.OK);
	}
}
