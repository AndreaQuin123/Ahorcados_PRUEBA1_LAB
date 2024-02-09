package AhorcadosJuego;

import java.awt.CardLayout;
import java.awt.Component;
import java.awt.FlowLayout;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class JuegoAhorcadoFijo extends JuegoAhorcadoBase{
    
    public JuegoAhorcadoFijo(String palabrasecreta){
        
        if (palabrasecreta == null){
            palabrasecreta = "MIAU";
        }
        
        this.palabrasecreta=palabrasecreta.toUpperCase();
        inicializarPalabraSecreta();
        intentos=10;
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

    public boolean verificarLetra(char letra) {
        for (char letraverificar : palabrasecreta.toCharArray()) {
            if (letraverificar == letra) {
                return true;
            }
        }
        return false;
    }

    public void inicializarPalabraSecreta() {
        palabraactual = "";
        for (int i = 0; i < palabrasecreta.length(); i++) {
            palabraactual += "_";
        }
    }

    public boolean hasGanado() {
        if (palabraactual.equals(palabrasecreta)) {
            return true;
        }
        return false;
    }

    public void jugar() {

        String palabraMutilada = "";

        for (int i = 0; i < palabraactual.length(); i++) {
            palabraMutilada += palabraactual.charAt(i) + " ";
        }

        //haciendo el frame porque el joptionpane nos fallo :(
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setBounds(0, 0, 400, 300);
        frame.setLocationRelativeTo(null);

        frame.setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));

        JTextField letraAdivinada = new JTextField(16);
        letraAdivinada.setMaximumSize(letraAdivinada.getPreferredSize());

        JPanel PANEL = new JPanel(new FlowLayout(FlowLayout.CENTER));
        PANEL.add(letraAdivinada);

        JButton boton = new JButton("Adivinar letra");
        boton.setAlignmentX(300);

        JLabel mensaje = new JLabel();
        JLabel mensaje2 = new JLabel();
        JLabel mensaje3 = new JLabel();
        mensaje.setText("Ingrese la letra que intenta adivinar.");
        mensaje2.setText("Pista: " + palabraMutilada);
        mensaje3.setText("Intentos restantes: " + intentos);

        frame.add(Box.createVerticalStrut(10));
        frame.add(mensaje);
        frame.add(mensaje2);
        frame.add(mensaje3);
        frame.add(Box.createVerticalStrut(10));
        frame.add(letraAdivinada);
        frame.add(Box.createVerticalStrut(10));
        frame.add(boton);

        frame.setVisible(true);

        
        boton.addActionListener(e -> {
            
            String prueba = letraAdivinada.getText().toUpperCase();

            if (!prueba.isEmpty()) {
                char letra = prueba.charAt(0);
                actualizarPalabraActual(letra);
                
                 mensaje2.setText("Pista: " + palabraactual.replaceAll(".", "$0 "));
                 mensaje3.setText("Intentos restantes: " + intentos);

                letraAdivinada.setText("");
            }

            if (hasGanado() == true && intentos > 0) {

                JOptionPane.showMessageDialog(null, "Felicidades, has acertado!! :3 ");
                intentos = 0;
                frame.dispose();

            } else if (intentos == 0) {

                JOptionPane.showMessageDialog(null, "Mejor suerte a la proxima ; w ;");
                frame.dispose();

            }
        });
    }
}
