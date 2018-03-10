package br.com.fiap.jpa.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="TB_SORBETE")
@SequenceGenerator(name="sorvete",sequenceName="SQ_TB_SORVETE", allocationSize=1)
public class Sorvete {

	@Id
	@Column(name="NM_CODIGO")
	@GeneratedValue(generator="sorvetes",strategy=GenerationType.SEQUENCE)
	private int codigo;
	
	@Column(name="DS_SABOR", nullable=false,length=50)
	private String sabor;
	
	@Column(name="VL_PRECO", nullable=false)
	private double preco;

	public Sorvete() {
		super();
	}

	public Sorvete(String sabor, double preco) {
		super();
		this.sabor = sabor;
		this.preco = preco;
	}

	public String getSabor() {
		return sabor;
	}

	public void setSabor(String sabor) {
		this.sabor = sabor;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}
	
	
	
}
