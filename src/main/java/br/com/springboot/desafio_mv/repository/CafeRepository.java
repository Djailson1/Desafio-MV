package br.com.springboot.desafio_mv.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.springboot.desafio_mv.model.Cafe;

@Repository
public interface CafeRepository extends JpaRepository<Cafe, Long> {

	@Transactional
	@Modifying
	@Query(value = "INSERT INTO cafe (item_cafe, usuario_id) VALUES (?1, ?2)", nativeQuery = true)
	void criarItemCafe(String itemCafe, Long usuario_id);
	
	@Query(value = "SELECT MAX(c.cafe_id) FROM cafe c ORDER BY c.cafe_id DESC", nativeQuery = true)
	Long buscaUltimoId();
	
	@Query(value = "SELECT * FROM cafe c WHERE c.cafe_id = ?1", nativeQuery = true)
	Cafe buscaCafePorId(Long cafe_id);
}
