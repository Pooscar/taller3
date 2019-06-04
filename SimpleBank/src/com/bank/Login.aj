package com.bank;

public aspect Login {
	//Aspecto2: El login debe realizarse antes de la transacción
	pointcut transaction(): call (* make*(..) );
    before() : transaction(){
    	pedirDatos();
    }
    
    pointcut money(): call (* my*(..) );
    before() : money(){
    	pedirDatos();
    }
	
    void pedirDatos() {
    	System.out.println("Ingrese su usuario y id");
    	String nombre = Bank.readConsole("Usuario :");
        int id = Integer.valueOf(Bank.readConsole("Id: "));
        System.out.format("Bienvenido %s, id: %d\n\n", nombre, id);
    }
    
}
