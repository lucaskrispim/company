package br.com.company.models;


import java.util.ArrayList;

import br.com.company.models.EnumTypesContainer.Gender;
import br.com.company.models.EnumTypesContainer.Month;

abstract class Funcionario extends Pessoa{
	
	private String cod_funcionario; 
	static private Integer cod;
	
	public Funcionario(String nome, String sobreNome, String email, Gender sexo) {
		super(nome, sobreNome, email, sexo);
		
		if( cod == null ) this.cod = 0;
		this.cod++;
		
		this.cod_funcionario = "F".concat(cod.toString());

	}
	
	protected Funcionario(String nome, String sobreNome, String email, Gender sexo, String cod_funcionario) {
		super(nome, sobreNome, email, sexo);
		this.cod_funcionario = cod_funcionario;
	}
	
	public String getCod_funcionario() {
		return this.cod_funcionario;
	}
	
	protected String getTratamento() {
		if( super.getSexo() ==  Gender.MASCULINO) return "Prezado Senhor "+ super.getNome()+" "+super.getSobreNome();
		
		return "Prezada Senhora "+ super.getNome()+" "+super.getSobreNome();
	}
	
	@Override
	public String toString() {
		return "[" + this.getTratamento() + ", Email=" + this.getEmail() + ", Genero=" + this.getSexo()
				+ ", cod_funcionario=" + this.getCod_funcionario() + "]";
	}
	
	public abstract Funcionario getFuncionario();
	
	public abstract Double getSalario(Month mes, Integer ano, ArrayList<Contrato> contratos);

}
