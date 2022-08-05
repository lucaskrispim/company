package br.com.company.models;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeAll;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import br.com.company.models.EnumTypesContainer.Gender;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class FuncionarioAssalariadoTest {
	private Funcionario funcionario;
	private Funcionario funcionarioFeminino;
	
	@BeforeAll
	public void setUp() {
		this.funcionario = new FuncionarioAssalariado("Lucas", "da silva", "dasilva@gmail.com",Gender.MASCULINO,10.0);
		this.funcionarioFeminino = new FuncionarioAssalariado("Ana", "da silva", "dasilva@gmail.com",Gender.FEMININO,10.0);
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
       assertEquals(this.funcionario.getSalario(null, null, null),10.0);
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
