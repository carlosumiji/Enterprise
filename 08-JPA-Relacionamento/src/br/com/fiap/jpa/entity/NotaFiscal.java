package br.com.fiap.jpa.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@SequenceGenerator(name="nota",sequenceName="SQ_T_NOTAFISCAL",allocationSize=1)
@Table(name="T_NOTAFISCAL")
public class NotaFiscal {

	@Id
	@GeneratedValue(generator="nota",strategy=GenerationType.SEQUENCE)
	@Column(name="CD_NOTA")
	private int codigo;
	
	@Column(name="VL_NOTA",nullable=false)
	private double valor;
	
	@Column(name="NR_CNPJ")
	private String cnpj;
	
	@OneToOne
	@JoinColumn(name="CD_PEDIDO")
	private Pedido pedido;

	public NotaFiscal() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

	public NotaFiscal( double valor, String cnpj, Pedido pedido) {
		super();
		this.valor = valor;
		this.cnpj = cnpj;
		this.pedido = pedido;
	}



	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}
}
