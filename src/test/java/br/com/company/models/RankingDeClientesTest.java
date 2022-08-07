package br.com.company.models;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeAll;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestMethodOrder;

import br.com.company.models.EnumTypesContainer.Category;
import br.com.company.models.EnumTypesContainer.Gender;
import br.com.company.models.EnumTypesContainer.Month;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)

public class RankingDeClientesTest {

	Contrato c1;
	
	Contrato c2;
	
	Contrato c3;
	
	Contrato cc;
	
	Funcionario f;
	
	Servico s1;
	
	Servico s2;
	
	Servico s3;
	
	Servico ss;
	
	Cliente cl1;
	
	Cliente cl2;
	
	Cliente cl3;
	
	Historico historico;
		
	@BeforeAll
	public void setUp() {

		this.f = new FuncionarioHorista("Lucas", "da silva", "dasilva@gmail.com",Gender.MASCULINO,1.0);
		
		this.s1 = new Servico("lavar roupa", 100.0, 10.0, 1.0);
		
		this.s2 = new Servico("lavar roupa", 1.0, 10.0, 1.0);
		
		this.s3 = new Servico("lavar roupa", 10.0, 10.0, 1.0);
		
		this.ss = new Servico("lavar roupa", 50000.0, 10.0, 1.0);
		    	
		this.cl1 = new Cliente("BBB","BBB" ,"BBB@hotmail.com",Gender.MASCULINO);
		
		this.cl2 = new Cliente("AAA","AAA" ,"AAA@hotmail.com",Gender.MASCULINO);
		
		this.cl3 = new Cliente("CCC","CCC" ,"CCC@hotmail.com",Gender.MASCULINO);
		
		this.c1 = new Contrato(this.cl1,this.s1,this.f);
	
		this.c2 = new Contrato(this.cl2,this.s2,this.f);
		
		this.c3 = new Contrato(this.cl3,this.s3,this.f);
		
		this.cc = new Contrato(this.cl1,this.ss,this.f);
		
		historico = new HistoricoDeContratos();
		
		historico.add(this.c1);
		
		historico.add(this.c2);
		
		historico.add(this.c3);
		
		//r = new RankingDeClientes();
		
    }
	
    @Test
    @Order(1)
    public void verificaValorTotalPorCliente() {
    	
    	assertEquals( new RankingDeClientes().getTotalPorCliente(this.cl1.getNome(), this.cl1.getSobreNome(),this.historico), 100.0);
    	
    	historico.add(this.c1);
    	
    	assertEquals( new RankingDeClientes().getTotalPorCliente(this.cl1.getNome(), this.cl1.getSobreNome(),this.historico), 200.0);
    }
    
    
    @Test
    @Order(2)
    public void verificaCategoriaPorCliente() {
    	
    	assertEquals( new RankingDeClientes().getCategoriaPorCliente(this.cl1.getNome(), this.cl1.getSobreNome(),this.historico), Category.C);
    	
    	historico.add(this.cc);
    	
    	assertEquals( new RankingDeClientes().getCategoriaPorCliente(this.cl1.getNome(), this.cl1.getSobreNome(),this.historico), Category.A);
    }
    
	
	
	
}
