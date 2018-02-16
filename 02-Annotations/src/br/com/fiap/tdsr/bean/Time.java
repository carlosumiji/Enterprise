package br.com.fiap.tdsr.bean;


import br.com.fiap.tdsr.anotacao.Tabela;
import br.com.fiap.tdsr.anotacao.ValidaVazio;

@Tabela(nome="TAB_TIME")
public class Time {

	@ValidaVazio(mensagem="Nome é obrigatório")
	
	private String time;
	
	@ValidaVazio(mensagem="Título é mandatorio")
	
	private int titulo;

	
	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public int getTitulo() {
		return titulo;
	}

	public void setTitulo(int titulo) {
		this.titulo = titulo;
	}

	public Time(String time, int titulo) {
		super();
		this.time = time;
		this.titulo = titulo;
	}

	public Time() {
		super();
	}
	
	
	
}
