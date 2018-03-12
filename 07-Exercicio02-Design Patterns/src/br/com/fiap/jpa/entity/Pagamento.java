package br.com.fiap.jpa.entity;

import java.sql.Date;
import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.crypto.Data;

@Entity
@Table(name="TB_PAGAMENTO")
@SequenceGenerator(name="pagamento",sequenceName="SQ_TB_PAGAMENTO",allocationSize=1)
public class Pagamento {

	@Id
	@GeneratedValue(generator="pagamento",strategy=GenerationType.SEQUENCE)
	@Column(name="CD_CODIGO")
	private int codigo;

	@Column(name="DT_DATAPAGAMENTO")
	@Temporal(TemporalType.DATE)
	private Calendar data;

	@Column(name="VL_VALORPAGAMENTO")
	private float valorPagamento;

	@Column(name="DS_FORMAPAGAMENTO")
	private Forma forma;
	
	public Pagamento() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Pagamento(int codigo, Calendar dataPagamento, float valorPagamento, Forma formaPagamento) {
		super();
		this.codigo = codigo;
		this.data = dataPagamento;
		this.valorPagamento = valorPagamento;
		this.forma = formaPagamento;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public Calendar getDataPagamento() {
		return data;
	}

	public void setDataPagamento(Calendar dataPagamento) {
		this.data = dataPagamento;
	}

	public float getValorPagamento() {
		return valorPagamento;
	}

	public void setValorPagamento(float valorPagamento) {
		this.valorPagamento = valorPagamento;
	}

	public Forma getFormaPagamento() {
		return forma;
	}

	public void setFormaPagamento(Forma formaPagamento) {
		this.forma = formaPagamento;
	}


	
}
