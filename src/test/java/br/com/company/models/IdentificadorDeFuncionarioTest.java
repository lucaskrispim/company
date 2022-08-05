package br.com.company.models;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import br.com.company.models.EnumTypesContainer.Gender;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class IdentificadorDeFuncionarioTest {
	
	Funcionario funcionarioAssalariado;
	Funcionario funcionarioComissionado;
	Funcionario funcionarioHorista;
	
	
	@BeforeAll
	public void setUp() {
		this.funcionarioAssalariado = new FuncionarioAssalariado("Lucas", "da silva", "dasilva@gmail.com",Gender.MASCULINO,10.0);
		this.funcionarioComissionado = new FuncionarioComissionado("Lucas", "da silva", "dasilva@gmail.com",Gender.MASCULINO,10.0);
		this.funcionarioHorista = new FuncionarioHorista("Lucas", "da silva", "dasilva@gmail.com",Gender.MASCULINO,10.0);
    }
		
    @Test
    public void verificarFuncionarioAssalariado() {
       assertEquals(IdentificadorDeFuncionario.getTipoDeFuncionario(this.funcionarioAssalariado),"Assalariado");
    }
	
    @Test
    public void verificarFuncionarioComissionado() {
       assertEquals(IdentificadorDeFuncionario.getTipoDeFuncionario(this.funcionarioComissionado),"Comisionado");
    }
    
    @Test
    public void verificarFuncionarioHorista() {
       assertEquals(IdentificadorDeFuncionario.getTipoDeFuncionario(this.funcionarioHorista),"Horista");
    }
    
    @Test
    public void verificarFuncionarioNulo() {
       assertEquals(IdentificadorDeFuncionario.getTipoDeFuncionario(null),null);
    }
}
