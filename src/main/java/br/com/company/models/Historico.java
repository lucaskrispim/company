package br.com.company.models;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Historico {

	private ArrayList<Contrato> contratos;

	public Historico() {

		this.contratos = new ArrayList<Contrato>();
	}

	public void add(Contrato contrato) {
		this.checkConditions(contrato == null  || contrato.getServico().getHorasTotal() > 2400.0,"O contrato não pode ser nulo ou não pode exceder 2400 horas de serviço!");
		this.contratos.add(contrato);

	}

	public void remove(Contrato contrato) {

		if (verifyIfHasContrato(contrato))
			this.contratos.remove(contrato);

	}

	public boolean verifyIfHasContrato(Contrato contrato) {
		return getContrato(contrato.getCodContrato()) != null;
	}

	public Contrato getContrato(String cod_contrato) {

		return this.contratos.stream().filter(c -> c.getCodContrato() == cod_contrato).map(c -> c.getContrato())
				.findFirst().orElse(null);

	}

	public ArrayList<Contrato> getContratos() {

		ArrayList<Contrato> contratosCopy = new ArrayList<>();

		for (Contrato contrato : contratos) {
			contratosCopy.add(this.getContrato(contrato.getCodContrato()));
		}

		return contratosCopy;

	}

	public Double getTotalPrevisto() {

		return this.contratos.stream().mapToDouble(x -> Double.valueOf(x.getTotalPrevisto().replace(",", "."))).sum();

	}

	public Double getTotal() {

		return this.contratos.stream().mapToDouble(x -> Double.valueOf(x.getTotal().replace(",", "."))).sum();

	}

	public List<Contrato> getListaEmOrdemAlfabeticaDeCliente() {

		return this.getContratos().stream().sorted(ClientNameComparator).collect(Collectors.toList());

	}
	
	public List<Contrato> getListaEmOrdemAlfabeticaReversaDeCliente() {

		return this.getContratos().stream().sorted(ClientNameComparatorReverse).collect(Collectors.toList());

	}
	
	public List<Contrato> getListaEmOrdemCrescenteDeValorDeServico() {

		return this.getContratos().stream().sorted(ServiceValueComparator).collect(Collectors.toList());

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
	
	private void checkConditions(Boolean cond,String msg) {
		if (cond) throw new IllegalArgumentException(msg);
	}
}
