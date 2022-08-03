package br.com.company.models;

import java.util.ArrayList;

import br.com.company.models.EnumTypesContainer.Gender;
import br.com.company.models.EnumTypesContainer.Month;

public class FuncionarioHorista extends Funcionario {
	
	private Double valorDaHoraTrabalhada;
	
	public FuncionarioHorista(String nome, String sobreNome, String email, Gender sexo, Double valorDaHoraTrabalhada) {
				
		super(nome, sobreNome, email, sexo);
		
		super.checkConditions(valorDaHoraTrabalhada <= 0.0 && valorDaHoraTrabalhada != null, "O valor da hora trabalhada é inválido");
		this.valorDaHoraTrabalhada = valorDaHoraTrabalhada;
		
	}
	
	
	private FuncionarioHorista(String nome, String sobreNome, String email, Gender sexo, String codFuncionario, Double valorDaHoraTrabalhada) {
		
		super(nome, sobreNome, email, sexo,codFuncionario);
		this.valorDaHoraTrabalhada = valorDaHoraTrabalhada;
		
	}
	
	public Funcionario getFuncionario() {
		return new FuncionarioHorista(super.getNome(),super.getSobreNome(),super.getEmail(),super.getSexo(),super.getCod_funcionario(),this.getValorDaHoraTrabalhada());
	}
	
	private Double getValorDaHoraTrabalhada() {
		return this.valorDaHoraTrabalhada;
	}
		
	@Override
	public String toString() {
		return "Funcionario Horista "+super.toString();
	}

	@Override
	public Double getSalario(Month mes, Integer ano, ArrayList<Contrato> contratos) {
		
		return contratos.stream().filter(x-> x.getAno().equals(ano)).filter(x-> x.getMes() == mes).filter(x->x.getFuncionario().getCod_funcionario() == super.getCod_funcionario() ).mapToDouble(x->x.getServico().getHorasTotal()).sum();

	}

}

