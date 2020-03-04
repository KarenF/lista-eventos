package br.com.java.listaEventos.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import org.hibernate.annotations.DynamicUpdate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "convidado")
@Data
@AllArgsConstructor
@NoArgsConstructor
@DynamicUpdate
public class Convidado implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -9214606507062630635L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idConvidado;
	@NotBlank
	private String nomeConvidado;
	@NotBlank
	private String rg;

	@JoinColumn(name = "eventos", referencedColumnName = "id")
	@ManyToOne(fetch = FetchType.LAZY)
	private Eventos eventos;
}
