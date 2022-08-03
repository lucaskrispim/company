package br.com.company.models;

import java.time.LocalDate;

import br.com.company.models.EnumTypesContainer.Gender;
import br.com.company.models.EnumTypesContainer.Month;

public class Contrato {
	
	private Cliente cliente;
	private Servico servico;
	private Funcionario funcionario;
	private Double valor;
	static private String cod; 
	private String cod_contrato; 
	private Integer ano;
	private Month mes;
	
	public Contrato(Cliente cliente, Servico servico, Funcionario funcionario){
		this.checkConditions(cliente == null  || !(cliente instanceof Cliente) ,"Argumento ilegal para a variável cliente!");
		this.checkConditions(servico == null || !(servico instanceof Servico),"Argumento ilegal para a variável serviço!");		
		this.checkConditions(funcionario == null || !(funcionario instanceof Funcionario),"Argumento ilegal para a variável funcionário!");
	

		this.cliente = cliente;
		this.servico = servico;
		this.funcionario = funcionario;
		this.valor = servico.getValorCobradoPorHora();
		
		this.ano = LocalDate.now().getYear();
		this.mes = Month.fromValue(LocalDate.now().getMonthValue());
		
		
		if(this.cod == null) this.cod = LocalDate.now().getYear()+"-1";
				
		this.atualizaCoDContrato();
		
	}
	
	private Contrato(Cliente cliente, Servico servico, Funcionario funcionario,Integer ano, Month mes,String codContrato) {
		this.cliente = cliente;
		this.servico = servico;
		this.funcionario = funcionario;
		this.valor = servico.getValorCobradoPorHora();
		
		this.ano = ano;
		this.mes = mes;
		
		this.cod_contrato = codContrato;
		
	}
	
	public Contrato getContrato() {
		return new Contrato(this.getCliente(),this.getServico(),this.funcionario,this.getAno(),this.getMes(),this.getCodContrato());
	}
		
	public Cliente getCliente() {
		return this.cliente.getCliente();
	}

	public Servico getServico() {
		return this.servico.getServico();
	}

	public Funcionario getFuncionario() {
		return this.funcionario.getFuncionario();
	}

	public Double getValor() {
		return this.valor;
	}

	public String getCodContrato() {
		return this.cod_contrato;
	}
	
	private void setCodContrato(String newCode) {
		this.cod_contrato = newCode;
	}

	public Integer getAno() {
		return ano;
	}

	public Month getMes() {
		return mes;
	}

	private void atualizaCoDContrato() {
		
		LocalDate dateNow = LocalDate.now();
		
		if ( dateNow.getYear() == Integer.valueOf( this.cod.split("-")[0] ) ) {
			
			this.setCodContrato(String.valueOf(this.ano).concat("-"+ this.cod.split("-")[1]) );
			
			Integer i =  Integer.valueOf(this.cod.split("-")[1]) + 1;
			
			this.cod = dateNow.getYear()+"-"+i;
			
			return;
			
		}
		this.cod = LocalDate.now().getYear()+"-1";
			
	}
	
	private void checkConditions(Boolean cond,String msg) {
		if (cond) throw new IllegalArgumentException(msg);
	}
	
	public String getTotalPrevisto() {
		return this.servico.getOrcamento();
	}
	
	public String getTotal() {
		return this.servico.getValorTotal();
	}

	@Override
	public String toString() {
		return "Contrato \n" + this.getCliente() + ",\n" + this.getServico() + ",\n" + this.getFuncionario() + ",\nValor = "
				+ this.getValor() + ", Ano= "+ this.getAno() + ", Mes= "+ this.getMes() + ", Cod Contrato= "+ this.getCodContrato()+"\n\n";
	}

}

