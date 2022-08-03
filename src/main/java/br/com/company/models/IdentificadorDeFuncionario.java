package br.com.company.models;

public class IdentificadorDeFuncionario {
	
	public static String getTipoDeFuncionario(Funcionario funcionario) {
				
		if (funcionario instanceof FuncionarioHorista) {
			return "Horista";
		}
		
		if (funcionario instanceof FuncionarioAssalariado) {
			return "Assalariado";
		}
		
		if (funcionario instanceof FuncionarioComissionado) {
			return "Comisionado";
		}
		
		return null;
		
	}

}
