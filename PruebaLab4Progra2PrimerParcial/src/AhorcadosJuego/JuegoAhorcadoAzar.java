/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AhorcadosJuego;

import java.util.ArrayList;
import java.util.Random;
import javax.swing.JOptionPane;

/**
 *
 * @author dell
 */
public class JuegoAhorcadoAzar extends JuegoAhorcadoBase{
    
    ArrayList<String> palabrasPosibles =new ArrayList();
    public JuegoAhorcadoAzar(ArrayList palabrasSecretas){
        palabrasPosibles = palabrasSecretas;
        seleccionarPalabraAzar();
        inicializarPalabraSecreta();
        intentos=10;
    }
    
    private void seleccionarPalabraAzar() {
        Random random = new Random();
        int indice = random.nextInt(palabrasPosibles.size());
        palabrasecreta = palabrasPosibles.get(indice).toUpperCase();
    }
    
    public void actualizarPalabraActual(char letra){
        char[] palabrareemplazar = palabraactual.toCharArray();
        if(verificarLetra(letra)==true){
            for(int i=0; i<palabrasecreta.toCharArray().length;i++){
                if(palabrasecreta.toCharArray()[i]==letra){
                    palabrareemplazar[i]=letra;
                }
            }
            palabraactual = new String(palabrareemplazar);
        } else{
            intentos-=1;
        }
    }
    
    public boolean verificarLetra(char letra){
        for(char letraverificar: palabrasecreta.toCharArray()){
            if(letraverificar==letra){
                return true;
            }
        }
        return false;
    }
    
    public void inicializarPalabraSecreta(){
        palabraactual="";
        for(int i=0; i<palabrasecreta.length();i++){
            palabraactual+="_";
        }
    }
    
    public boolean hasGanado(){
        if(palabraactual.equals(palabrasecreta)){
            return true;
        }
        return false;
    }
    
    public void jugar(){
        while(intentos>0){
            String palabradeshebrada="";
            for(int i=0;i<palabraactual.length();i++){
                palabradeshebrada+=palabraactual.charAt(i)+" ";
            }
            String prueba=null;
            do{
                prueba = JOptionPane.showInputDialog(null, "Ingrese la letra que desea probar\nPista: "+palabradeshebrada+"\nIntentos restantes: "+intentos, "Ahorcado Fijo", JOptionPane.INFORMATION_MESSAGE);
            }while(prueba==null);
            prueba=prueba.toUpperCase();
            char letra = prueba.charAt(0);
            actualizarPalabraActual(letra);
            if(hasGanado()==true && intentos>0){
                JOptionPane.showMessageDialog(null,"Felicidades, has ganado :3 ");
                intentos=0;
            } else if (intentos==0){
                JOptionPane.showMessageDialog(null,"Mejor suerte a la proxima ;-; ");
            }
            }
                     
            
        }
    }
