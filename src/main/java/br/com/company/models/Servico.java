package br.com.company.models;

import java.text.DecimalFormat;

public class Servico {
	private String descricao;
	private Double valorCobradoPorHora;
	private Double horasPrevistas;
	private Double horasTotal;
	static private Integer cod;
	private String cod_servico;
	
	public Servico(String descricao, Double valorCobradoPorHora, Double horasPrevistas, Double hotasTotal) {
		
		this.checkConditions(descricao == null  || descricao.trim().isEmpty(),"Argumento ilegal para a variável descricao!");
		this.checkConditions(valorCobradoPorHora == null || valorCobradoPorHora <= 0.0,"Argumento ilegal para a variável valor cobrado por hora de serviço!");		
		this.checkConditions(horasPrevistas == null || horasPrevistas <= 0.0,"Argumento ilegal para a variável horas previstas!");
		this.checkConditions(hotasTotal == null || hotasTotal<0.0,"Argumento ilegal para a variável horas total!");
		
		this.descricao = descricao;
		this.valorCobradoPorHora = valorCobradoPorHora;
		this.horasPrevistas = horasPrevistas;
		this.horasTotal = hotasTotal;
		
		if(this.cod == null) this.cod = 0; 
		
		this.cod++;
		
		this.cod_servico = "S".concat(cod.toString());
	}
	
	
	private Servico(String descricao, Double valorCobradoPorHora, Double horasPrevistas, Double hotasTotal, String codServico) {
				
		this.descricao = descricao;
		this.valorCobradoPorHora = valorCobradoPorHora;
		this.horasPrevistas = horasPrevistas;
		this.horasTotal = hotasTotal;
	
		this.cod_servico = codServico;
	}
	
	
	public Servico getServico() {
		return new Servico(this.getDescricao(),this.getValorCobradoPorHora(),this.getHorasPrevistas(),this.getHorasTotal(),this.getCod_servico());
	}


	private void checkConditions(Boolean cond,String msg) {
		if (cond) throw new IllegalArgumentException(msg);
	}

	public String getCod_servico() {
		return this.cod_servico;
	}
	
	public String getDescricao() {
		return this.descricao;
	}

	public Double getValorCobradoPorHora() {
		return this.valorCobradoPorHora;
	}

	public Double getHorasPrevistas() {
		return this.horasPrevistas;
	}

	public Double getHorasTotal() {
		return this.horasTotal;
	}
	
	public String getOrcamento() {
		return  new DecimalFormat("#.##").format(this.horasPrevistas*this.valorCobradoPorHora);
	}
	
	public String getValorTotal() {
		return  new DecimalFormat("#.##").format(this.horasTotal*this.valorCobradoPorHora);
	}
	
	@Override
	public String toString() {
		return "Servico [Descricao = " + this.getDescricao() + ", Valor Cobrado Por Hora=" + this.getValorCobradoPorHora() + ", Horas Previstas="
				+ this.getHorasPrevistas() + ", Horas Total=" + this.getHorasTotal() + ", cod_servico=" + this.getCod_servico() + "]";
	}
	
	
}

