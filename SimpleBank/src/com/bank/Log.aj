package com.bank;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Calendar;


public aspect Log {
	File file = new File("log.txt");
    Calendar cal = Calendar.getInstance();
    //Aspecto1: Deben hacer los puntos de cortes (pointcut) para crear un log con los tipos de transacciones realizadas.
    pointcut success() : call(* create*(..) );
    after() : success() {
    	System.out.println("**** User created ****");
    }
    
    pointcut transaction(): call (* make*(..) );
    after() : transaction(){
    	guardarTransaccion("Transacción Realizada");
    }
    
    pointcut money(): call (* my*(..) );
    after() : money(){
    	guardarTransaccion("Dinero Retirado");
    }
    
    void guardarTransaccion(String tipo) {
    	System.out.format("**** %s ****\n",tipo);
    	try(BufferedWriter bw =
                new BufferedWriter(new FileWriter(file,true)))
       {
          
           bw.write(tipo + " " + cal.getTime() + "");
           bw.close();
       }
       catch(IOException e)
       {
           System.out.println("Error opening the file out.txt."+ e.getMessage());
       }
    }

}
