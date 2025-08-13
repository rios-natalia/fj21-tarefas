package br.com.caelum.tarefas.modelo;

import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Tarefa {
	@Id
	@GeneratedValue
	private Long id;
	@NotNull
	@Size(min = 5)
	private String descricao;
	private boolean finalizado;
	@Temporal(TemporalType.DATE)
	private Calendar dataFinalizacao;

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescricao() {
		return this.descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public boolean isFinalizado() {
		return this.finalizado;
	}

	public void setFinalizado(boolean finalizado) {
		this.finalizado = finalizado;
	}

	public Calendar getDataFinalizacao() {
		return this.dataFinalizacao;
	}

	public void setDataFinalizacao(Calendar dataFinalizacao) {
		this.dataFinalizacao = dataFinalizacao;
	}
}
