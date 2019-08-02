package com.ifma.formulario.view.start;

import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JWindow;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class Splash extends JFrame{
    
    private final int LARGURA_IMG = 420;
    private final int ALTURA_IMG = 250;
    private final int TEMPO_DE_SPLASH = 6000;
    private final String CAMINHO_GIF = "imagens/loading.gif";
     
    
    public Splash(){
        
        JWindow janelaSplash = new JWindow();
        
        janelaSplash.getContentPane().add(
                new JLabel(
                        "",
                        new ImageIcon(getClass().getResource(CAMINHO_GIF)),
                        SwingConstants.CENTER
                )
        );
             
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension dimension = toolkit.getScreenSize();
        
        janelaSplash.setBounds(
                (dimension.width - LARGURA_IMG) / 2,
                (dimension.height - ALTURA_IMG)/ 2,
                LARGURA_IMG,
                ALTURA_IMG
        );
        
        janelaSplash.setVisible(true);
        
        try{
            Thread.sleep(TEMPO_DE_SPLASH);
        }catch(InterruptedException e){}
        @SuppressWarnings("unused")
		Login login = new Login();
        janelaSplash.dispose();
    }   
    
    public static void main(String[] args) {
        Splash splash = new Splash();
        splash.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

}