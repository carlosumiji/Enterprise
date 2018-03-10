package br.com.fiap.jpa.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="TB_FORNECEDOR")
public class Fornecedor {

	@Id
	@Column(name="NR_CNPJ")
	private String cnpj;
	
	@Column(name="NM_FORNECEDOR", nullable=false)
	private String nome;
	

	public Fornecedor(String cnpj, String nome) {
		super();
		this.cnpj = cnpj;
		this.nome = nome;
	}
	
	public Fornecedor() {
		super();
	}


	
	
	
}
