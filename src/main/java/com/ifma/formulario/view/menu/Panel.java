package com.ifma.formulario.view.menu;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Panel extends JPanel {
	
	ImageIcon fundo = new ImageIcon(getClass().getResource("C:\\Users\\Carvalho\\Documents\\JavaProjects\\Atividade5_LP3\\src\\view\\images\\background.jpg"));
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Image img = fundo.getImage();
		g.drawImage(img, 0, 0, this);
	}
}
