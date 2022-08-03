package br.com.company.models;

import java.text.DecimalFormat;
import java.util.ArrayList;

import br.com.company.models.EnumTypesContainer.Gender;
import br.com.company.models.EnumTypesContainer.Month;

public class FuncionarioComissionado extends Funcionario{
	
	private Double comissao;
	
	public FuncionarioComissionado(String nome, String sobreNome, String email, Gender sexo, Double comissao) {
				
		super(nome, sobreNome, email, sexo);
		
		super.checkConditions(comissao <= 0.0 && comissao != null, "O valor da comissão é inválido");
		this.comissao = comissao;
		
	}
	
	private FuncionarioComissionado(String nome, String sobreNome, String email, Gender sexo, String codFuncionario, Double comissao) {
		
		super(nome, sobreNome, email, sexo,codFuncionario);
		this.comissao = comissao;
	
	}
	
	public Funcionario getFuncionario() {
		return new FuncionarioComissionado(super.getNome(),super.getSobreNome(),super.getEmail(),super.getSexo(),super.getCod_funcionario(), this.getComissao());
	}
	
	@Override
	public String toString() {
		return "Funcionario Comissionado "+super.toString();
	}
	
	private Double getComissao() {
		return this.comissao;
	}

	@Override
	public Double getSalario(Month mes, Integer ano, ArrayList<Contrato> contratos) {
		
		return contratos.stream().filter(x-> x.getAno().equals(ano)).filter(x-> x.getMes() == mes).filter(x->x.getFuncionario().getCod_funcionario() == super.getCod_funcionario() ).mapToDouble(x->Double.valueOf(x.getTotal())).sum()*this.getComissao();

	}
}
