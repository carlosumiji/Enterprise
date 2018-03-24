package br.com.fiap.jpa.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
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
				
			  //Exemplo de Cascade - realiza ações em cadeia | forma individual CascadeType.REMOVE
			 //(cascade= {CascadeType.REMOVE, CascadeType.PERSIST}) <- forma de vetor/array/lista
	@OneToOne(fetch=FetchType.LAZY,cascade= {CascadeType.REMOVE, CascadeType.PERSIST})
	@JoinColumn(name="CD_PEDIDO")
	private Pedido pedido;

	@ManyToMany(cascade=CascadeType.PERSIST)
	@JoinTable(name="T_IMPOSTO_NOTA",
	joinColumns=@JoinColumn(name="cd_nota"),
	inverseJoinColumns=@JoinColumn(name="cd_imposto"))
	private List<Imposto> impostos;
	
	
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



	public List<Imposto> getImpostos() {
		return impostos;
	}



	public void setImpostos(List<Imposto> impostos) {
		this.impostos = impostos;
	}
}
