/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author vanes
 */
public abstract class JuegoAhorcadoBase implements JuegoAhorcado{
    
    private String palabraSecreta;
    private String palabraActual;
    private int intentos;
    
    public JuegoAhorcadoBase(String palabraSecreta, String palabraActual, int intentos){
        this.palabraActual=palabraActual;
        this.palabraSecreta = palabraSecreta;
        this.intentos=intentos;
    }
    
    public abstract void actualizarPalabraActual(char letra);
    
    public abstract void verificarLetra(char letra);
    
    public abstract boolean hasGanado();
    
    
}
