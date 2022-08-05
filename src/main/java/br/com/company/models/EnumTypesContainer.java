package br.com.company.models;

public class EnumTypesContainer {
	
    public enum Gender {
        MASCULINO("Masculino"),
        FEMININO("Feminino");

        private final String name;

        Gender(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }
    
	public enum Month {

	    Janeiro(1),
	    Fevereiro(2),
	    Marco(3),
	    Abril(4),
	    Maio(5),
	    Junho(6),
	    Julho(7),
	    Agosto(8),
	    Setembro(9),
	    Outubro(10),
	    Novembro(11),
	    Dezembro(12);

	    private int value;

	    Month(int value) {
	        this.value = value;
	    }

	    public int getValue() {
	        return value;
	    }
	    
	    public static Month fromValue(int value) {
	        for (Month m : values()) {
	            if (m.value == value) {
	                return m;
	            }
	        }
	        throw new IllegalArgumentException("Mes nao encontrado!");
	    }

	}
	
	public enum Category {

	    A(1),
	    B(2),
	    C(3);

	    private int value;

	    Category(int value) {
	        this.value = value;
	    }

	    public int getValue() {
	        return value;
	    }
	    
	    public static Category fromValue(int value) {
	        for (Category m : values()) {
	            if (m.value == value) {
	                return m;
	            }
	        }
	        throw new IllegalArgumentException("Categoria não encontrado!");
	    }

	}

}
