package br.com.fiap.tdsr.teste;


import br.com.fiap.tdsr.anotacao.Tabela;
import br.com.fiap.tdsr.bean.Time;

public class Exercicio {

	public static void main(String[] args) {
		
		Time time = new Time("Criciuma", 21);

			Tabela tabela = time.getClass().getAnnotation(Tabela.class);
			if(tabela != null) {
				System.out.println("SELECT * FROM " + tabela.nome());
			}
		
		
	}

}
