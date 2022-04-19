package br.com.springboot.desafio_mv.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.springboot.desafio_mv.dto.Cafe.CafeSaidaDTO;
import br.com.springboot.desafio_mv.dto.Cafe.ConverteCafeParaDTO;
import br.com.springboot.desafio_mv.model.Cafe;
import br.com.springboot.desafio_mv.service.CafeService;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/api/cafe")
public class CafeController {
	
	@Autowired
	private CafeService service;
	
	@Autowired
	private ConverteCafeParaDTO dto;

	@PostMapping("/{usuario_id}/criar")
	public ResponseEntity<CafeSaidaDTO> criarItemCafe(@RequestBody Cafe cafe, @PathVariable("usuario_id") Long usuario_id) {
		
		service.criarItemCafe(dto.cafeEntradaDTO(cafe), usuario_id);

		Long ultimoId = service.buscaUltimoId();
		CafeSaidaDTO cafeSaida = dto.cafeSaidaDTO(service.buscaCafePorId(ultimoId));

		return new ResponseEntity<>(cafeSaida, HttpStatus.CREATED);
	}
}
