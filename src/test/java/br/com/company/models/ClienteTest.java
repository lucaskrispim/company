package br.com.company.models;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import br.com.company.models.EnumTypesContainer.Gender;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ClienteTest {
	
	private Cliente cliente;
	private Cliente clienteFeminino;
	
	@BeforeAll
	public void setUp() {
		this.cliente = new Cliente("Lucas", "da silva", "dasilva@gmail.com",Gender.MASCULINO);
		this.clienteFeminino = new Cliente("Ana", "da silva", "dasilva@gmail.com",Gender.FEMININO);
    }
	
    @Test
    public void clienteDeveEnviarErroSeNaoTiverNome()
    {
    	IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> new Cliente(null, "da Silva", "dasilva@gmail.com", Gender.MASCULINO));
    
    	assertEquals("Argumento ilegal para a variável nome!", exception.getMessage());
    }
    
    @Test
    public void clienteDeveEnviarErroSeNaoTiverSobreNome()
    {
    	IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> new Cliente("Lucas", null, "dasilva@gmail.com", Gender.MASCULINO));
    
    	assertEquals("Argumento ilegal para a variável sobrenome!", exception.getMessage());
    }
    
    @Test
    public void clienteDeveEnviarErroSeNaoTiverEmail()
    {
    	IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> new Cliente("Lucas", "da silva", null, Gender.MASCULINO));
    
    	assertEquals("Argumento ilegal para a variável email!", exception.getMessage());
    }
    
    @Test
    public void clienteDeveEnviarErroSeNaoTiverGenero()
    {
    	IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> new Cliente("Lucas", "da silva", "dasilva@gmail.com", null));
    	assertEquals("Argumento ilegal para a variável sexo!", exception.getMessage());
    }
    	
    @Test
    public void verificarCodigoDoCliente() {
       assertEquals(this.cliente.getCodCliente(),"C1");
    }
    
    @Test
    public void verificarCodigoDoCliente2() {
       assertEquals(this.clienteFeminino.getCodCliente(),"C2");
    }
    
    @Test
    public void verificarNomeDoCliente() {
       assertEquals(this.cliente.getNome(),"Lucas");
    }
    
    @Test
    public void verificarSobreNomeDoCliente() {
       assertEquals(this.cliente.getSobreNome(),"da silva");
    }
    
    @Test
    public void verificarEmailDoCliente() {
       assertEquals(this.cliente.getEmail(),"dasilva@gmail.com");
    }
    
    @Test
    public void verificarGeneroDoCliente() {
       assertEquals(this.cliente.getSexo(),Gender.MASCULINO);
    }
        
    @Test
    public void verificarTratamentoDoClienteMsculino() {
       assertEquals(this.cliente.getTratamento(),"Prezado Senhor da silva");
    }

    @Test
    public void verificarTratamentoDoClienteFeminino() {
       assertEquals(this.clienteFeminino.getTratamento(),"Prezada Senhora da silva");
    }
	
}
