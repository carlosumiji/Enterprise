package br.com.fiap.view;

import java.text.SimpleDateFormat;
import java.time.Month;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import br.com.fiap.dao.CidadeDAO;
import br.com.fiap.dao.ClienteDAO;
import br.com.fiap.dao.EntityManagerFactorySingleton;
import br.com.fiap.dao.PacoteDAO;
import br.com.fiap.dao.TransporteDAO;
import br.com.fiap.dao.impl.CidadeDAOImpl;
import br.com.fiap.dao.impl.ClienteDAOImpl;
import br.com.fiap.dao.impl.PacoteDAOImpl;
import br.com.fiap.dao.impl.TransporteDAOImpl;
import br.com.fiap.entity.Cidade;
import br.com.fiap.entity.Cliente;
import br.com.fiap.entity.Pacote;
import br.com.fiap.entity.Transporte;

public class ConsoleView {

	public static void main(String[] args) {
		EntityManagerFactory fabrica = EntityManagerFactorySingleton.getInstance();
		EntityManager em = fabrica.createEntityManager();
		
		//listar as cidades
		CidadeDAO dao = new CidadeDAOImpl(em);
		List<Cidade> lista = dao.listar();
		System.out.println("Listar Cidades");
		for (Cidade cidade : lista) {
			System.out.println(cidade.getNome() + " " + cidade.getUf());
		}
		
		System.out.println("Buscar por Nome");
		lista = dao.buscarPorNome("a");
		for (Cidade cidade : lista) {
			System.out.println(cidade.getNome() + " " + cidade.getUf());
		}
		
		ClienteDAO clienteDao = new ClienteDAOImpl(em);
		List<Cliente> clientes = clienteDao.listar();
		System.out.println("Listar Cliente");
		for (Cliente cliente : clientes) {
			System.out.println(cliente.getNome());
		}
		
		
		PacoteDAO pacoteDao = new PacoteDAOImpl(em);
		TransporteDAO transporteDao = new TransporteDAOImpl(em);
		Transporte transporte = transporteDao.pesquisar(1);
		List<Pacote> pacotes = pacoteDao.buscarPorTransporte(transporte);
		System.out.println("Buscar Pacote Por Transporte");
		
		for (Pacote pacote : pacotes) {
			System.out.println(pacote.getDescricao());
		}
		
		
		clientes = clienteDao.buscarPorEstado("BA");
		System.out.println("Buscar cliente por estado");
		for (Cliente cliente : clientes) {
			System.out.println(cliente.getNome());
		}
		
		clientes = clienteDao.buscarPorDiasReserva(10);
		System.out.println("Buscar cliente com reserva");
		for (Cliente cliente : clientes) {
			System.out.println(cliente.getNome());
		}
		System.out.println("Buscar intervalo de datas");
		Calendar data1 = new GregorianCalendar(2015,Calendar.MAY, 1);
		Calendar data2 = new GregorianCalendar(2018,Calendar.MAY, 1);
		pacotes = pacoteDao.buscarPorDatas(data1, data2) ;
		for (Pacote pacote : pacotes) {
			System.out.println(pacote.getDescricao());
		}
		
		System.out.println("buscar cliente por nome e cidade");
		clientes = clienteDao.buscar("a", "a");
		for (Cliente cliente : clientes) {
			System.out.println(cliente.getNome()+ " " + cliente.getEndereco().getCidade().getNome());
		}
		
		List<String> estados = new ArrayList<>();
		estados.add("SP");
		estados.add("PR");
		estados.add("MG");
		
		clientes = clienteDao.buscarPorEstado(estados);
		System.out.println("buscar cliente por estado");
		for (Cliente cliente : clientes) {
			System.out.println(cliente.getNome() + " - " + cliente.getEndereco().getCidade().getUf());
		}
		
		
		
		em.close();
		fabrica.close();
		
	}

}



