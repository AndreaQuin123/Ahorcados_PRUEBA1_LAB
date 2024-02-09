/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AhorcadosJuego;

import java.util.ArrayList;

public class AdminPalabrasSecretas {
    static ArrayList<String> palabrasSecretas;
    

    public AdminPalabrasSecretas(){
        palabrasSecretas=new ArrayList<>();
        palabrasSecretas.add("VALORANT");
        palabrasSecretas.add("GATO");
        palabrasSecretas.add("CAYUCO");
        palabrasSecretas.add("BUS");
        palabrasSecretas.add("AMAYA");
    }

    public static void agregarPalabra(String palabraSecreta) {
        palabrasSecretas.add(palabraSecreta);
    }
    
    public static ArrayList getpalabrasSecretas(){
        return palabrasSecretas;
    }
}
