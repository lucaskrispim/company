package br.com.company.models;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ServicoTest {
	
	Servico servico;
	
	@BeforeAll
	public void setUp() {
		this.servico = new Servico("lavar roupa", 1.0, 1.0, 1.0);
    }
		
    @Test
    public void servicoDeveEnviarErroSeNaoTiverDescricao()
    {
    	IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> new Servico(null, 1.0, 1.0, 1.0));
    
    	assertEquals("Argumento ilegal para a variável descricao!", exception.getMessage());
    }
    
    @Test
    public void servicoDeveEnviarErroSeNaoTiverValorCobradoPorHora()
    {
    	IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> new Servico("lavar roupa", null, 1.0, 1.0));
    
    	assertEquals("Argumento ilegal para a variável valor cobrado por hora de serviço!", exception.getMessage());
    }

    @Test
    public void servicoDeveEnviarErroSeNaoTiverHorasPrevistas()
    {
    	IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> new Servico("lavar roupa", 1.0, null, 1.0));
    
    	assertEquals("Argumento ilegal para a variável horas previstas!", exception.getMessage());
    }
    
    @Test
    public void servicoDeveEnviarErroSeNaoTiverHotasTotal()
    {
    	IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> new Servico("lavar roupa", 1.0, 1.0, null));
    
    	assertEquals("Argumento ilegal para a variável horas total!", exception.getMessage());
    }
    
    @Test
    public void servicoNaoDeveUltrapassarXHotasTotal()
    {
    	IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> new Servico("lavar roupa", 1.0, 1.0,2400.1));
    
    	assertEquals("Argumento ilegal para a variável horas total!", exception.getMessage());
    }
    
//  @Test
//  public void contratoDeveEnviarErroSeContratoComHorasExcedentes()
//  {
//  	IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> historico.add(cc));
//  
//  	assertEquals("O contrato não pode ser nulo ou não pode exceder 2400 horas de serviço!", exception.getMessage());
//  }
    
    @Test
    public void verificarCodigoDoServico() {
       assertEquals(this.servico.getCod_servico(),"S1");
    }
    
    @Test
    public void verificarDescricaoDoServico() {
       assertEquals(this.servico.getDescricao(),"lavar roupa");
    }
    		
    @Test
    public void verificarValorCobradoPorHoraoDoServico() {
       assertEquals(this.servico.getValorCobradoPorHora(),1.0);
    }
    
    @Test
    public void verificarHorasPrevistasDoServico() {
       assertEquals(this.servico.getHorasPrevistas(),1.0);
    }
    
    @Test
    public void verificarHorasTotalDoServico() {
       assertEquals(this.servico.getHorasTotal(),1.0);
    }
    
    @Test
    public void verificarOrcamentoDoServico() {
       assertEquals(this.servico.getOrcamento(),"1");
    }
    
    @Test
    public void verificarValorTotalDoServico() {
       assertEquals(this.servico.getValorTotal(),"1");
    }
    
}
