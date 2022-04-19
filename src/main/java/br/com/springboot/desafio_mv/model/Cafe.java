package br.com.springboot.desafio_mv.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "cafe")
public class Cafe {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long cafeId;

	@Column(name = "item_cafe", columnDefinition = "LONGTEXT")
	@JsonProperty("itemCafe")
	private String itemCafe;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "usuario_id", nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	@JsonIgnore
	private Usuario usuario;

	public Long getCafeId() {
		return cafeId;
	}

	public void setCafeId(Long cafeId) {
		this.cafeId = cafeId;
	}

	@JsonProperty("itemCafe")
	public String getItemCafe() {
		return itemCafe;
	}

	@JsonProperty("itemCafe")
	public void setItemCafe(String itemCafe) {
		this.itemCafe = itemCafe;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}
