package br.com.fiap.entity;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="TAB_BEBIDA")
@SequenceGenerator(name="bebida", sequenceName="SQ_TB_BEBIDA", allocationSize=1)
public class Bebida implements Serializable{
	
	@Id
	@Column(name="CD_BEBIDA")
	@GeneratedValue(generator="bebida", strategy=GenerationType.SEQUENCE)
	private int id;
	
	@Enumerated(EnumType.STRING)
	@Column(name="DS_TIPO")
	private TipoBebida tipo;
	
	@Column(name="NM_BEBIDA", nullable=false)
	private String bebida;
	
	@Temporal(TemporalType.DATE)
	@Column(name="DT_VALIDADE", length=50)
	private Calendar validade;
	
	@Lob
	@Column(name="FL_ROTULO")
	private byte[] rotulo;
	
	@Column(name="ST_ALCOOLICO")
	private boolean alcoolico;

	public Bebida(TipoBebida tipo, String bebida, Calendar validade, byte[] rotulo, boolean alcoolico) {
		super();
		this.tipo = tipo;
		this.bebida = bebida;
		this.validade = validade;
		this.rotulo = rotulo;
		this.alcoolico = alcoolico;
	}

	public Bebida() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public TipoBebida getTipo() {
		return tipo;
	}

	public void setTipo(TipoBebida tipo) {
		this.tipo = tipo;
	}

	public String getBebida() {
		return bebida;
	}

	public void setBebida(String bebida) {
		this.bebida = bebida;
	}

	public Calendar getValidade() {
		return validade;
	}

	public void setValidade(Calendar validade) {
		this.validade = validade;
	}

	public byte[] getRotulo() {
		return rotulo;
	}

	public void setRotulo(byte[] rotulo) {
		this.rotulo = rotulo;
	}

	public boolean isAlcoolico() {
		return alcoolico;
	}

	public void setAlcoolico(boolean alcoolico) {
		this.alcoolico = alcoolico;
	}
	
	
	
	
	
}
