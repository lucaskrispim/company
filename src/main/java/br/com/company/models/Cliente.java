package br.com.company.models;

import br.com.company.models.EnumTypesContainer.Gender;

public class Cliente extends Pessoa {

	static private Integer cod;
	private String cod_cliente;
	
	public Cliente(String nome, String sobreNome, String email, Gender sexo) {
		
		super(nome, sobreNome, email, sexo);

		if(this.cod == null) this.cod = 0; 
		this.cod++;
		this.cod_cliente = "C".concat(cod.toString());

	}
	
	private Cliente(String nome, String sobreNome, String email, Gender sexo, String codCliente) {
				
		super(nome, sobreNome, email, sexo);

		this.cod_cliente = codCliente;
	}
	
	public Cliente getCliente() {
		return new Cliente(super.getNome(),super.getSobreNome(),super.getEmail(),super.getSexo(), this.getCodCliente());
	}
	
	public String getCodCliente() {
		return this.cod_cliente;
	}
	
	@Override
	public String toString() {
		return "Cliente [" + this.getTratamento() + ", Email=" + super.getEmail() + ", Genero=" + super.getSexo()
				+ ", cod_cliente=" + this.getCodCliente() + "]";
	}

	@Override
	public String getTratamento() {
		
		if( super.getSexo() ==  Gender.MASCULINO) return "Prezado Senhor "+ super.getSobreNome();
		
		return "Prezada Senhora "+ super.getSobreNome(); 
	}
		
}
