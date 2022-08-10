package br.com.company.models;

import java.util.HashMap;
import br.com.company.models.EnumTypesContainer.Category;

public class RankingDeClientes {
	
	public HashMap<String, ValorTotalECategoria> getClientesEValorTotalDeServicos(HistoricoDeContratos historico) {
		
		checkConditions(historico == null, "O hisotrico não pode ser nulo");
		
		HashMap<String, ValorTotalECategoria> ranking = new HashMap<String, ValorTotalECategoria>();
		
		for(int i = 0; i < historico.getAll().size() ; i++) {
		
			if ( ranking.get( ((Contrato) historico.getI(i)).getCliente().getNomeCompleto())  == null) {
				
				ranking.put(((Contrato) historico.getI(i)).getCliente().getNomeCompleto(), new ValorTotalECategoria(Double.valueOf( ((Contrato) historico.getI(i)).getServico().getValorTotal()), this.checkCategory(Double.valueOf(((Contrato) historico.getI(i)).getServico().getValorTotal())) ));
			}else {
				ValorTotalECategoria vtc = ranking.get(((Contrato) historico.getI(i)).getCliente().getNomeCompleto());
				ranking.put(((Contrato) historico.getI(i)).getCliente().getNomeCompleto(), new ValorTotalECategoria( Double.valueOf(((Contrato) historico.getI(i)).getServico().getValorTotal())+vtc.getValorTotal(), checkCategory(Double.valueOf(((Contrato) historico.getI(i)).getServico().getValorTotal())+vtc.getValorTotal())) );
			}		
		}
		
			
		return ranking;
	}
	
	public Double getTotalPorCliente(String nome, String sobreNome,HistoricoDeContratos historico) {
		
		checkConditions(historico == null, "O hisotrico não pode ser nulo");
		checkConditions(nome == null || nome.trim().isEmpty(), "Argumento inválido para o nome do cliente");
		checkConditions(sobreNome == null || sobreNome.trim().isEmpty(), "Argumento inválido para o sobrenome do cliente");
		
		HashMap<String, ValorTotalECategoria> ranking = this.getClientesEValorTotalDeServicos(historico);
		
		return ranking.get(nome.trim()+" "+sobreNome.trim()).getValorTotal();
		
	}
	
	public Category getCategoriaPorCliente(String nome, String sobreNome,HistoricoDeContratos historico) {
		
		checkConditions(historico == null, "O hisotrico não pode ser nulo");
		checkConditions(nome == null || nome.trim().isEmpty(), "Argumento inválido para o nome do cliente");
		checkConditions(sobreNome == null || sobreNome.trim().isEmpty(), "Argumento inválido para o sobrenome do cliente");
		
		HashMap<String, ValorTotalECategoria> ranking = this.getClientesEValorTotalDeServicos(historico);
		
		return ranking.get(nome.trim()+" "+sobreNome.trim()).getCategoria();
		
	}
	

	private Category checkCategory(Double v) {
		
		if( v >= 30000.0) return Category.A;
				
		if( v< 30000.0 && v >=10000.0) return Category.B;
		
		return Category.C;
		
	}
	
	private class ValorTotalECategoria{
		
		private Double valorTotal;
		private Category categoria;
		
		public ValorTotalECategoria(Double valorTotal,Category categoria) {
			
			this.checkConditions(valorTotal == null || valorTotal <= 0.0,"Argumeto ilegal para valor!");
			this.checkConditions(categoria == null,"Argumeto ilegal para categoria!");
			
			this.valorTotal = valorTotal;
			this.categoria = categoria;
		}
		
		public Category getCategoria() {
			return this.categoria;
		}
		
		public Double getValorTotal() {
			return this.valorTotal;
		}
		
		private void checkConditions(Boolean cond,String msg) {
			if (cond) throw new IllegalArgumentException(msg);
		}
	}
	
	private static void checkConditions(Boolean cond,String msg) {
		if (cond) throw new IllegalArgumentException(msg);
	}
}
