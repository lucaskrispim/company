package br.com.company.models;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeAll;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import br.com.company.models.EnumTypesContainer.Gender;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class FuncionarioHoristaTest {
	private Funcionario funcionario;
	private Funcionario funcionarioFeminino;
	
	@BeforeAll
	public void setUp() {
		this.funcionario = new FuncionarioHorista("Lucas", "da silva", "dasilva@gmail.com",Gender.MASCULINO,1.0);
		this.funcionarioFeminino = new FuncionarioHorista("Ana", "da silva", "dasilva@gmail.com",Gender.FEMININO,1.0);
    }
	
    @Test
    public void funcionarioAssalariadoDeveEnviarErroSeNaoTiverNome()
    {
    	IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> new FuncionarioAssalariado(null, "da Silva", "dasilva@gmail.com", Gender.MASCULINO,10.0));
    
    	assertEquals("Argumento ilegal para a variável nome!", exception.getMessage());
    }
    
    @Test
    public void funcionarioAssalariadoDeveEnviarErroSeNaoTiverSobreNome()
    {
    	IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> new FuncionarioAssalariado("Lucas", null, "dasilva@gmail.com", Gender.MASCULINO,10.0));
    
    	assertEquals("Argumento ilegal para a variável sobrenome!", exception.getMessage());
    }
    
    @Test
    public void funcionarioAssalariadoDeveEnviarErroSeNaoTiverEmail()
    {
    	IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> new FuncionarioAssalariado("Lucas", "da silva", null, Gender.MASCULINO,10.0));
    
    	assertEquals("Argumento ilegal para a variável email!", exception.getMessage());
    }
    
    @Test
    public void funcionarioAssalariadoDeveEnviarErroSeNaoTiverGenero()
    {
    	IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> new FuncionarioAssalariado("Lucas", "da silva", "dasilva@gmail.com", null,10.0));
    	assertEquals("Argumento ilegal para a variável sexo!", exception.getMessage());
    }
    
    @Test
    public void funcionarioAssalariadoDeveEnviarErroSeNaoTiverSalario()
    {
    	IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> new FuncionarioAssalariado("Lucas", "da silva", "dasilva@gmail.com", Gender.MASCULINO,null));
    	assertEquals("O valor do salario é inválido!", exception.getMessage());
    }
    	
    @Test
    public void verificarCodigoDoFuncionarioAssalariado() {
       assertEquals(this.funcionario.getCod_funcionario(),"F1");
    }
    
    @Test
    public void verificarCodigoDoFuncionarioAssalariado2() {
       assertEquals(this.funcionarioFeminino.getCod_funcionario(),"F2");
    }
    
    @Test
    public void verificarNomeDoFuncionarioAssalariado() {
       assertEquals(this.funcionario.getNome(),"Lucas");
    }
    
    @Test
    public void verificarSobreNomeDoFuncionarioAssalariado() {
       assertEquals(this.funcionario.getSobreNome(),"da silva");
    }
    
    @Test
    public void verificarEmailDoFuncionarioAssalariado() {
       assertEquals(this.funcionario.getEmail(),"dasilva@gmail.com");
    }
    
    @Test
    public void verificarGeneroDoFuncionarioAssalariado() {
       assertEquals(this.funcionario.getSexo(),Gender.MASCULINO);
    }
    
    @Test
    public void verificarSalarioDoFuncionarioAssalariado() {
    
		Servico s1 = new Servico("lavar roupa", 1.0, 10.0, 1.0);
		
		Servico s2 = new Servico("passar roupa", 1.0, 10.0, 1.0);
    	
		Cliente c1 = new Cliente("Giu","Da Silva" ,"giu@hotmail.com",Gender.MASCULINO);
		
		Cliente c2 = new Cliente("Maria Antonia","Tirapani" ,"mariaantoniatirapani@hotmail.com",Gender.FEMININO);
		
		Contrato contrato1 = new Contrato(c1,s1,this.funcionario);
		
		Contrato contrato2 = new Contrato(c2,s2,this.funcionario);
		
		Historico h = new Historico( );
		
		h.add(contrato1);
		
		h.add(contrato2);
			
		assertEquals(this.funcionario.getSalario(contrato1.getMes(),2022,h.getContratos()),2.0);
    
    }
        
    @Test
    public void verificarTratamentoDoFuncionarioAssalariadoMsculino() {
       assertEquals(this.funcionario.getTratamento(),"Prezado Senhor Lucas da silva");
    }

    @Test
    public void verificarTratamentoDoClienteFeminino() {
       assertEquals(this.funcionarioFeminino.getTratamento(),"Prezada Senhora Ana da silva");
    }
	
}
