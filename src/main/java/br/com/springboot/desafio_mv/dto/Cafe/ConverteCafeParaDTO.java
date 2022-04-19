package br.com.springboot.desafio_mv.dto.Cafe;

import org.springframework.stereotype.Component;

import br.com.springboot.desafio_mv.model.Cafe;

@Component
public class ConverteCafeParaDTO {

	public CafeEntradaDTO cafeEntradaDTO(Cafe cafe){
		CafeEntradaDTO cafeEntradaDTO = new CafeEntradaDTO();
		cafeEntradaDTO.setItemCafe(cafe.getItemCafe());
		cafeEntradaDTO.setUsuario(cafe.getUsuario());
        
        return cafeEntradaDTO;
    }
	
	public CafeSaidaDTO cafeSaidaDTO(Cafe cafe){
		CafeSaidaDTO saidaUsuarioDTO = new CafeSaidaDTO();
		saidaUsuarioDTO.setCafeId(cafe.getCafeId());
		saidaUsuarioDTO.setItemCafe(cafe.getItemCafe());
		saidaUsuarioDTO.setUsuario(cafe.getUsuario());
        
        return saidaUsuarioDTO;
    }
}
