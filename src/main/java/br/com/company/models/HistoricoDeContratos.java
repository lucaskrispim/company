package br.com.company.models;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class HistoricoDeContratos extends Historico {
	
	private Historico<Contrato> contratos;

	public Double getTotalPrevisto() {

		return this.contratos.getAll().stream().mapToDouble(x -> Double.valueOf(x.getTotalPrevisto().replace(",", "."))).sum();

	}

	public Double getTotal() {

		return this.contratos.getAll().stream().mapToDouble(x -> Double.valueOf(x.getTotal().replace(",", "."))).sum();

	}

	public List<Contrato> getListaEmOrdemAlfabeticaDeCliente() {

		return (List<Contrato>) super.getAll().stream().sorted(ClientNameComparator).collect(Collectors.toList());

	}
	
	public List<Contrato> getListaEmOrdemAlfabeticaReversaDeCliente() {

		return (List<Contrato>) super.getAll().stream().sorted(ClientNameComparatorReverse).collect(Collectors.toList());

	}
	
	public List<Contrato> getListaEmOrdemCrescenteDeValorDeServico() {

		return (List<Contrato>) super.getAll().stream().sorted(ServiceValueComparator).collect(Collectors.toList());

	}
	
	private static Comparator <Contrato> ClientNameComparator = new Comparator<Contrato>() {

		@Override
		public int compare(Contrato  c1, Contrato  c2) {
			return c1.getCliente().getNome().compareTo(c2.getCliente().getNome());
		}

		
	};
	
	private static Comparator <Contrato> ClientNameComparatorReverse = new Comparator<Contrato>() {

		@Override
		public int compare(Contrato  c1, Contrato  c2) {
			return c2.getCliente().getNome().compareTo(c1.getCliente().getNome());
		}

		
	};
	
	private static Comparator <Contrato> ServiceValueComparator = new Comparator<Contrato>() {

		@Override
		public int compare(Contrato  c1, Contrato  c2) {
			return Double.compare(Double.valueOf(c1.getServico().getValorTotal()),Double.valueOf(c2.getServico().getValorTotal()));
		}

		
	};
}
