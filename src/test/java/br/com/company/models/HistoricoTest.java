package br.com.company.models;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeAll;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import br.com.company.models.EnumTypesContainer.Gender;
import br.com.company.models.EnumTypesContainer.Month;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class HistoricoTest {

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
		    	
		this.cl1 = new Cliente("BBB","BBB" ,"BBB@hotmail.com",Gender.MASCULINO);
		
		this.cl2 = new Cliente("AAA","AAA" ,"AAA@hotmail.com",Gender.MASCULINO);
		
		this.cl3 = new Cliente("CCC","CCC" ,"CCC@hotmail.com",Gender.MASCULINO);
		
		this.c1 = new Contrato(this.cl1,this.s1,this.f);
	
		this.c2 = new Contrato(this.cl2,this.s2,this.f);
		
		this.c3 = new Contrato(this.cl3,this.s3,this.f);
		
		historico = new Historico();
		
		historico.add(c1);
		
		historico.add(c2);
		
		historico.add(c3);
		
		this.ss = new Servico("lavar roupa", 100000000.0, 100000000.0, 100000000.0);
		
		this.cc = new Contrato(this.cl1,this.ss,this.f);
    }
	
    @Test
    public void contratoDeveEnviarErroSeContratoComHorasExcedentes()
    {
    	IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> historico.add(cc));
    
    	assertEquals("O contrato não pode ser nulo ou não pode exceder 2400 horas de serviço!", exception.getMessage());
    }
	
	
    @Test
    public void contratoDeveEnviarErroSeContratoNulo()
    {
    	IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> historico.add(null));
    
    	assertEquals("O contrato não pode ser nulo ou não pode exceder 2400 horas de serviço!", exception.getMessage());
    }
	
    @Test
    public void verificaOrdemAlfabeticaNomeCliente() {
    	
    	assertEquals(historico.getListaEmOrdemAlfabeticaDeCliente().get(0).getCliente().getNome(),"AAA");
    }
    
    @Test
    public void verificaOrdemAlfabeticaReversaNomeCliente() {
    	assertEquals(historico.getListaEmOrdemAlfabeticaReversaDeCliente().get(0).getCliente().getNome(),"CCC");
    }
    
    @Test
    public void verificaOrdemCrescenteDeValorDoServico() {
    	assertEquals(historico.getListaEmOrdemCrescenteDeValorDeServico().get(0).getServico().getValorTotal(),"1");
    }
    
    @Test
    public void verificaSalarioDoFuncionario() {
    	assertEquals( f.getSalario(Month.fromValue(LocalDate.now().getMonthValue()), LocalDate.now().getYear(), historico.getContratos()) ,3.0);
    }
	
}
