package br.com.springboot.desafio_mv.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.springboot.desafio_mv.model.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

	@Transactional
	@Modifying
	@Query(value = "INSERT INTO usuario (usuario_cpf, usuario_nome) VALUES (?1, ?2)", nativeQuery = true)
	void criarUsuario(String usuarioCpf, String usuarioNome);
	
	@Query(value = "SELECT MAX(u.usuario_id) FROM usuario u ORDER BY u.usuario_id DESC", nativeQuery = true)
	Long buscaUltimoId();
	
	@Query(value = "SELECT * FROM usuario u WHERE u.usuario_id = ?1", nativeQuery = true)
	Usuario buscaUsuarioPorId(Long usuario_id);
	
	@Query(value = "SELECT * FROM usuario", nativeQuery = true)
	List<Usuario> listaUsuarios();
	
	@Transactional
    @Modifying
    @Query(value = "UPDATE usuario u SET u.usuario_nome = ?1 WHERE u.usuario_id = ?2",
            nativeQuery = true)
	void atualizarUsuario(String usuario_nome, String usuario_id);
	
	@Transactional
    @Modifying
	@Query(value="DELETE FROM usuario WHERE usuario_id = ?1", nativeQuery=true)
	void deletarUsuario(Long usuario_id);
}