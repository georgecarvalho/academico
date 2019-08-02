package com.ifma.formulario.view.menu;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JToolBar;

@SuppressWarnings("serial")
public class BarraDeFerramentas extends JToolBar {
	
    JButton toolNovo, toolAbrir, toolSalvar, toolDeletar;
    private String CAMINHO_NOVO = "C:\\Users\\Carvalho\\Documents\\JavaProjects\\Atividade5_LP3\\src\\view\\images\\1-Novo.png",
    			   CAMINHO_ABRIR = "C:\\Users\\Carvalho\\Documents\\JavaProjects\\Atividade5_LP3\\src\\view\\images\\2-Abrir.png",
    			   CAMINHO_SALVAR = "C:\\Users\\Carvalho\\Documents\\JavaProjects\\Atividade5_LP3\\src\\view\\images\\3-Salvar.png",
    			   CAMINHO_DELETAR = "C:\\Users\\Carvalho\\Documents\\JavaProjects\\Atividade5_LP3\\src\\view\\images\\4-Deletar.png";
    
	public BarraDeFerramentas(int orientation) {
		
		super(orientation);
		this.add(toolNovo = new JButton());
        toolNovo.setIcon(new ImageIcon(CAMINHO_NOVO));
        this.add(toolAbrir = new JButton());
        toolAbrir.setIcon(new ImageIcon(CAMINHO_ABRIR));
        this.add(toolSalvar = new JButton());
        toolSalvar.setIcon(new ImageIcon(CAMINHO_SALVAR));
        this.add(toolDeletar = new JButton());
        toolDeletar.setIcon(new ImageIcon(CAMINHO_DELETAR));
        this.setVisible(true);
        
	}
	
}
