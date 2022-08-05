package br.com.company.models;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.time.LocalDate;

import org.junit.jupiter.api.BeforeAll;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import br.com.company.models.EnumTypesContainer.Gender;
import br.com.company.models.EnumTypesContainer.Month;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ContratoTest {
	
	Contrato contrato;
	
	Contrato contrato2;
	
	Funcionario f;
	
	Servico s;
	
	Cliente c;
	
	@BeforeAll
	public void setUp() {

		this.f = new FuncionarioHorista("Lucas", "da silva", "dasilva@gmail.com",Gender.MASCULINO,1.0);
		
		this.s = new Servico("lavar roupa", 1.0, 10.0, 1.0);
		    	
		this.c = new Cliente("Giu","Da Silva" ,"giu@hotmail.com",Gender.MASCULINO);
		
		this.contrato = new Contrato(this.c,this.s,this.f);
	
		this.contrato2 = new Contrato(this.c,this.s,this.f);
    }
	
    @Test
    public void contratoDeveEnviarErroSeNaoTiverCliente()
    {
    	IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> new Contrato(null,this.s,this.f));
    
    	assertEquals("Argumento ilegal para a variável cliente!", exception.getMessage());
    }
    
    @Test
    public void contratoDeveEnviarErroSeNaoTiverServico()
    {
    	IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> new Contrato(this.c,null,this.f));
    
    	assertEquals("Argumento ilegal para a variável serviço!", exception.getMessage());
    }
    
    @Test
    public void contratoDeveEnviarErroSeNaoTiverFuncionario()
    {
    	IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> new Contrato(this.c,this.s,null));
    
    	assertEquals("Argumento ilegal para a variável funcionário!", exception.getMessage());
    }
    
    @Test
    public void verificarCodigoDoContrato() {
    	
       assertEquals(this.contrato.getCodContrato(),String.valueOf(LocalDate.now().getYear()).concat("-1"));
    }

    @Test
    public void verificarCodigoDoContrato2() {
    	
       assertEquals(this.contrato2.getCodContrato(),String.valueOf(LocalDate.now().getYear()).concat("-2"));
    }
    
    @Test
    public void verificarClienteDoContrato() {
    	  
    	assertTrue(this.contrato.getCliente().getCodCliente() == this.c.getCodCliente());
    	
    	assertTrue(this.contrato.getCliente().getNome() == this.c.getNome());
    	
    	assertTrue(this.contrato.getCliente().getSobreNome() == this.c.getSobreNome());
    
    	assertTrue(this.contrato.getCliente().getEmail() == this.c.getEmail());
    	
    	assertTrue(this.contrato.getCliente().getSexo() == this.c.getSexo());
    }
    
    @Test
    public void verificarFuncionarioDoContrato() {
    	  
    	assertTrue(this.contrato.getFuncionario().getCod_funcionario() == this.f.getCod_funcionario());
    	
    	assertTrue(this.contrato.getFuncionario().getNome() == this.f.getNome());
    	
    	assertTrue(this.contrato.getFuncionario().getSobreNome() == this.f.getSobreNome());
    
    	assertTrue(this.contrato.getFuncionario().getEmail() == this.f.getEmail());
    	
    	assertTrue(this.contrato.getFuncionario().getSexo() == this.f.getSexo());
    }
    
    @Test
    public void verificarServicoDoContrato() {
    	
    	assertTrue(this.contrato.getServico().getCod_servico() == this.s.getServico().getCod_servico());
    	
    	assertTrue(this.contrato.getServico().getDescricao() == this.s.getServico().getDescricao());
    	
    	assertTrue(this.contrato.getServico().getHorasPrevistas() == this.s.getServico().getHorasPrevistas());
    	
    	assertTrue(this.contrato.getServico().getValorCobradoPorHora() == this.s.getServico().getValorCobradoPorHora());
    	
    	assertTrue(this.contrato.getServico().getHorasTotal() == this.s.getServico().getHorasTotal());
    	
    	assertTrue(this.contrato.getServico().getOrcamento().equals(this.s.getServico().getOrcamento()));
    	
    	assertTrue(this.contrato.getServico().getValorTotal().equals(this.s.getServico().getValorTotal()));
    	
    }
        
    @Test
    public void verificaTotalPrevistoDoContrato() {
    	assertTrue(this.contrato.getTotalPrevisto().equals(this.s.getServico().getOrcamento()));
    }
    
    @Test
    public void verificaTotalDoContrato() {
    	assertTrue(this.contrato.getTotal().equals(this.s.getServico().getValorTotal()));
    }
    
    @Test
    public void verificaAnoDoContrato() {
    	assertTrue(this.contrato.getAno().equals( LocalDate.now().getYear() ));
    }
    
    @Test
    public void verificaMesDoContrato() {
    	assertTrue(this.contrato.getMes().equals( Month.fromValue(LocalDate.now().getMonthValue()) ));
    }
}
