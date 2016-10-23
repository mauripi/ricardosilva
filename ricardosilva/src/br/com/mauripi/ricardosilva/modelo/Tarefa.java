package br.com.mauripi.ricardosilva.modelo;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.Type;
import org.springframework.format.annotation.DateTimeFormat;



@Entity(name="tarefa")
public class Tarefa  implements Serializable {

	private static final long serialVersionUID = 3761434470773941518L;
	@Id
	@GeneratedValue
	private Integer id;
	@NotNull (message="A descrição deve ser preenchida")
	@Size(min=5,max=200, message="Descrição deve ter no mínimo 5 e no máximo 200 carateres")
	@Column(nullable=false,length=200)
	private String descricao;
	@Type(type="yes_no")
	private boolean finalizado;
	@DateTimeFormat(style = "M-")
	@Temporal(javax.persistence.TemporalType.DATE)
	private Date dataFinalizacao;
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public boolean getFinalizado() {
		return finalizado;
	}
	public void setFinalizado(boolean finalizado) {
		this.finalizado = finalizado;
	}
	public Date getDataFinalizacao() {
		return dataFinalizacao;
	}
	public void setDataFinalizacao(Date dataFinalizacao) {
		this.dataFinalizacao = dataFinalizacao;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((dataFinalizacao == null) ? 0 : dataFinalizacao.hashCode());
		result = prime * result
				+ ((descricao == null) ? 0 : descricao.hashCode());
		result = prime * result + (finalizado ? 1231 : 1237);
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Tarefa other = (Tarefa) obj;
		if (dataFinalizacao == null) {
			if (other.dataFinalizacao != null)
				return false;
		} else if (!dataFinalizacao.equals(other.dataFinalizacao))
			return false;
		if (descricao == null) {
			if (other.descricao != null)
				return false;
		} else if (!descricao.equals(other.descricao))
			return false;
		if (finalizado != other.finalizado)
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
