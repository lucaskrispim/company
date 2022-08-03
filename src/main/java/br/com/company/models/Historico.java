package br.com.company.models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Historico {

	private ArrayList<Contrato> contratos;
	
	public Historico() {

		this.contratos = new ArrayList<Contrato>();
	}
		
	public void add(Contrato contrato) {
		this.contratos.add(contrato);

	}
	
	public void remove(Contrato contrato) {
		
		if( verifyIfHasContrato(contrato) ) this.contratos.remove(contrato);
	
	}
	
	public boolean verifyIfHasContrato(Contrato contrato) {
		return getContrato(contrato.getCodContrato()) != null;
	}
	
	public Contrato getContrato(String cod_contrato) {
		
		return this.contratos.stream().filter(c -> c.getCodContrato() == cod_contrato).map(c -> c.getContrato()).findFirst().orElse(null);
				
	}
	
	public ArrayList<Contrato> getContratos(){
		
		ArrayList<Contrato> contratosCopy = new ArrayList<>();
		
		for(Contrato contrato : contratos) {
			contratosCopy.add( this.getContrato(contrato.getCodContrato()) );
		}
					
		return contratosCopy;
		
	}
	
	public Double getTotalPrevisto() {
				
		return this.contratos.stream().mapToDouble(x-> Double.valueOf(x.getTotalPrevisto().replace(",", ".")) ).sum();
		
	}
	
	public Double getTotal() {
		
		return this.contratos.stream().mapToDouble(x-> Double.valueOf(x.getTotal().replace(",", ".")) ).sum();
		
	}
	
	public List<Contrato> getListaEmOrdemAlfabeticaDeCliente(){
				
		return this.getContratos().stream().sorted((c1,c2)->c1.getCliente().getNome().compareTo(c2.getCliente().getNome())).collect(Collectors.toList());
		
	}
	
}

