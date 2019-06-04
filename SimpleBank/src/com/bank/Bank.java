package com.bank;

import java.util.ArrayList;
import java.util.Scanner;

public class Bank {

    static ArrayList<User> users = new ArrayList<>();
    private static Scanner input = new Scanner(System.in);
    public static void initBank(){
        users.add(new User(1,"Usuario1",1,0.0));
        users.add(new User(2,"Usuario2",2,10000.0));
        users.add(new User(3,"Usuario3",3,1000000.0));
        users.add(new User(4,"Usuario4",4,500.0));

    }

    public static void main(String[] args) {
        int opcion = 0;
        initBank();
        while(opcion != 5){
            opcion = menu();
        };

    }
    public static int menu(){
        System.out.println("Banco AspectJ");
        System.out.println("------------------------------------");
        System.out.println("1 - Crear Usuario");
        System.out.println("2 - Hacer Transaccion");
        System.out.println("3 - Retirar dinero");
        System.out.println("4 - Ver usuarios");
        System.out.println("5 - Salir");
        System.out.println("------------------------------------");
        int option = Integer.valueOf(readConsole("Opcion"));
        switch (option) {
        case 1:
            System.out.println("Crear Usuario");
            System.out.println("------------------------------------");
            createUser();
        break;
        case 2:
            System.out.println("Hacer transaccion");
            System.out.println("------------------------------------");
             makeTransaction(); 
        break;
        case 3:
            System.out.println("Retirar dinero");
            System.out.println("------------------------------------");
             myMoney();
        break;
        case 4:
            System.out.println("Ver Usuarios");
            viewUsers();
        break;
        case 5:
        break;
        default:
            System.out.println("Opcion incorrecta");
            break;
        }
        return option;
    }

    public static  String readConsole(String mensaje){
        System.out.println(mensaje);  
        String inputText;
        inputText = input.nextLine();           
        return inputText;
    }

    public static void createUser(){
        String nombre = readConsole("Nombre :");
        int id = Integer.valueOf(readConsole("Id: "));
        double money = Double.valueOf(readConsole("Dinero: "));
        users.add(new User(users.size(),nombre,id,money));
    }

    public static void makeTransaction(){
        int id = Integer.valueOf(readConsole("Key: "));
        double money = Double.valueOf(readConsole("Dinero a consignar: "));
        users.get(id-1).setMoney(users.get(id-1).getMoney() + money);
    }
    public static void myMoney(){
        int id = Integer.valueOf(readConsole("Key: "));
        double money = Double.valueOf(readConsole("Dinero a consignar: "));
        users.get(id-1).setMoney(users.get(id-1).getMoney() - money);
    }
    public static void viewUsers(){
        System.out.println("------------------------------------");
        for(User u:users){  
            System.out.println(u);
        }
        System.out.println("------------------------------------");
    }
    
}
