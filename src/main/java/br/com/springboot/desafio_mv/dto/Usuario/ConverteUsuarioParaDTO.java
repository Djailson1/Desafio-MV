package br.com.springboot.desafio_mv.dto.Usuario;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import br.com.springboot.desafio_mv.model.Usuario;

@Component
public class ConverteUsuarioParaDTO{

	public UsuarioEntradaDTO entradaUsuarioDTO(Usuario usuario){
		UsuarioEntradaDTO usuarioEntradaDTO = new UsuarioEntradaDTO();
		usuarioEntradaDTO.setUsuarioCpf(usuario.getUsuarioCpf());
		usuarioEntradaDTO.setUsuarioNome(usuario.getUsuarioNome());
        
        return usuarioEntradaDTO;
    }
	
	public UsuarioSaidaDTO saidaUsuarioDTO(Usuario usuario){
		UsuarioSaidaDTO usuarioSaidaDTO = new UsuarioSaidaDTO();
		usuarioSaidaDTO.setUsuarioId(usuario.getUsuarioId());
		usuarioSaidaDTO.setUsuarioCpf(usuario.getUsuarioCpf());
		usuarioSaidaDTO.setUsuarioNome(usuario.getUsuarioNome());
        
        return usuarioSaidaDTO;
    }

	public List<UsuarioSaidaDTO> listaSaidaUsuarioDTO(List<Usuario> listaUsuarios) {
		List<UsuarioSaidaDTO> usuarios = new ArrayList<UsuarioSaidaDTO>();
		for(Usuario usuarioSaidaDTO : listaUsuarios) {
			usuarios.add(saidaUsuarioDTO(usuarioSaidaDTO));
		}

		return usuarios;
	}
}
