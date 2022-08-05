package br.com.company.models;

import br.com.company.models.EnumTypesContainer.Gender;

abstract class Pessoa {

	
	private String nome;
	private String sobreNome;
	private String email;
	private Gender sexo;
	
	public Pessoa(String nome, String sobreNome, String email, Gender sexo) {
		
		this.checkConditions(nome == null  || nome.trim().isEmpty(),"Argumento ilegal para a variável nome!");
		this.checkConditions(sobreNome == null || sobreNome.trim().isEmpty(),"Argumento ilegal para a variável sobrenome!");		
		this.checkConditions(email == null || email.trim().isEmpty(),"Argumento ilegal para a variável email!");
		this.checkConditions(sexo == null || sexo.toString().trim().isEmpty(),"Argumento ilegal para a variável sexo!");
		
		this.nome = nome;
		this.sobreNome = sobreNome;
		this.email = email;
		this.sexo = sexo;
		
	}
	
	protected void checkConditions(Boolean cond,String msg) {
		if (cond) throw new IllegalArgumentException(msg);
	}
	
	public String getNome() {
		return this.nome;
	}

	public String getSobreNome() {
		return sobreNome;
	}
	
	public String getNomeCompleto() {
		return this.getNome()+" "+this.getSobreNome();
	}

	public String getEmail() {
		return email;
	}

	public Gender getSexo() {
		return sexo;
	}

	abstract String getTratamento();
	
}
