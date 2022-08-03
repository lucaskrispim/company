package br.com.company.models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.company.models.EnumTypesContainer.Gender;

import static org.junit.jupiter.api.Assertions.*;

public class ClienteTest {
	
	private Cliente cliente;
	
    @Test
    public void shouldClienteHasName()
    {
    	IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> new Cliente(null, "da Silva", "dasilva@gmail.com", Gender.MASCULINO));
    
    	assertEquals("Argumento ilegal para a variável nome!", exception.getMessage());
    }
    
    @Test
    public void shouldClienteHasLastName()
    {
    	IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> new Cliente("Lucas", null, "dasilva@gmail.com", Gender.MASCULINO));
    
    	assertEquals("Argumento ilegal para a variável sobrenome!", exception.getMessage());
    }
    
	
}
