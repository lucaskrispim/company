package br.com.company.models;

import java.util.ArrayList;
import java.util.List;

abstract class Historico<T>{

	private List<T> lista;

	public Historico() {

		this.lista = new ArrayList<T>();
	}
	
	public void add(T obj) {
		this.checkConditions(obj == null  ,"O objeto não pode ser nulo!");
		this.lista.add(obj);

	}

	public void remove(T obj) {

		if (verifyIfHasObj(obj))
			this.lista.remove(obj);

	}

	public boolean verifyIfHasObj(T obj) {
		return this.lista.contains(obj);
	}

	public T getObjCopy(T obj) {

		return (T) new ArrayList<T>(lista).stream().filter(x->x.equals(obj)).findFirst();

	}
	
	public T getI(int i) {
		return lista.get(i);
	}

	public ArrayList<T> getAll() {

		return new ArrayList<T>(lista);

	}
		
	private void checkConditions(Boolean cond,String msg) {
		if (cond) throw new IllegalArgumentException(msg);
	}
	
}
