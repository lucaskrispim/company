package br.com.company.models;

import java.util.ArrayList;

import br.com.company.models.EnumTypesContainer.Gender;
import br.com.company.models.EnumTypesContainer.Month;

public class FuncionarioAssalariado extends Funcionario{
	
	private Double salario;
	
	public FuncionarioAssalariado(String nome, String sobreNome, String email, Gender sexo, Double salario) {
				
		super(nome, sobreNome, email, sexo);
		
		super.checkConditions(salario == null || salario <= 0.0, "O valor do salario é inválido!");
		
		this.salario = salario;
		
	}
	
	private FuncionarioAssalariado(String nome, String sobreNome, String email, Gender sexo, String codFuncionario, Double salario) {
		
		super(nome, sobreNome, email, sexo,codFuncionario);
		
		this.salario = salario;
	
	}
	
	public Funcionario getFuncionario() {
		return new FuncionarioAssalariado(super.getNome(),super.getSobreNome(),super.getEmail(),super.getSexo(), super.getCod_funcionario(), this.salario);
	}
	
	@Override
	public String toString() {
		return "Funcionario Assalariado "+super.toString();
	}

	@Override
	public Double getSalario(Month mes, Integer ano, ArrayList<Contrato> contratos) {
		return this.salario;
	}

}
