/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ifma.formulario.view.menu;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import com.ifma.formulario.view.cadastro.TelaAluno;
import com.ifma.formulario.view.cadastro.TelaCurso;
import com.ifma.formulario.view.cadastro.TelaDisciplina;
import com.ifma.formulario.view.cadastro.TelaProfessor;
import com.ifma.formulario.view.spf.TelaAlunoCurso;
import com.ifma.formulario.view.spf.TelaGrade;
import com.ifma.formulario.view.spf.TelaProfDisc;

/**
 *
 * @author 01aluno
 */
@SuppressWarnings("serial")
public class MenuPrincipal extends JFrame {

	/**
	 * 
	 */
	private JDesktopPane desktopPane;
	private JInternalFrame internalFrame;
	private JMenu menuArquivo, menuCadastro, menuSPF, menuAjuda;
	private JMenuItem itemSair;
	private JMenuItem itemAluno, itemCurso, itemDisciplina, itemProfessor;
	private JMenuItem itemGrade, itemProfDisc, itemMatAluno;
	private JMenuItem itemSobre;
	private JMenuBar menuBar;
	private MenuController menuController;

	public MenuPrincipal() {
		// Titulo
		super("Menu Principal");
		this.setLayout(null);
		this.iniciarComponentes();
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void iniciarComponentes() {
		desktopPane = new JDesktopPane();
		Toolkit tk = getToolkit();
		Dimension d = tk.getScreenSize();
		desktopPane.setSize(d.width, d.height);

		// Criacao de menus e itens de menu
		menuArquivo = new JMenu("Arquivo");
		itemSair = new JMenuItem("Sair");
		menuCadastro = new JMenu("Cadastro");
		itemAluno = new JMenuItem("Aluno");
		itemCurso = new JMenuItem("Curso");
		itemDisciplina = new JMenuItem("Disciplina");
		itemProfessor = new JMenuItem("Professor");
		menuSPF = new JMenu("SPF");
		itemGrade = new JMenuItem("Grade");
		itemProfDisc = new JMenuItem("Professor/Disciplina");
		itemMatAluno = new JMenuItem("Aluno/Curso");
		menuAjuda = new JMenu("Ajuda");
		itemSobre = new JMenuItem("Sobre");
		menuBar = new JMenuBar();

		// Criacao dos ouvintes dos itens de menu
		menuController = new MenuController();
		itemSair.addActionListener(menuController);
		itemAluno.addActionListener(menuController);
		itemCurso.addActionListener(menuController);
		itemDisciplina.addActionListener(menuController);
		itemProfessor.addActionListener(menuController);
		menuSPF.addActionListener(menuController);
		itemGrade.addActionListener(menuController);
		itemProfDisc.addActionListener(menuController);
		itemMatAluno.addActionListener(menuController);
		menuAjuda.addActionListener(menuController);
		itemSobre.addActionListener(menuController);

		// Adicao dos itens aos menus
		menuArquivo.add(itemSair);
		menuCadastro.add(itemAluno);
		menuCadastro.add(itemCurso);
		menuCadastro.add(itemDisciplina);
		menuCadastro.add(itemProfessor);
		menuSPF.add(itemGrade);
		menuSPF.add(itemProfDisc);
		menuSPF.add(itemMatAluno);
		menuAjuda.add(itemSobre);

		// Adicao dos menus ao painel
		menuBar.add(menuArquivo);
		menuBar.add(menuCadastro);
		menuBar.add(menuSPF);
		menuBar.add(menuAjuda);
		desktopPane.add(menuBar);
		this.setJMenuBar(menuBar);
		this.add(desktopPane);
	}

	private class MenuController implements ActionListener {
		
		@Override
		public void actionPerformed(ActionEvent ae) {
		
			if(internalFrame != null) {
				desktopPane.removeAll();
			}
			
			if (ae.getSource() == itemSair) {
				int sair = JOptionPane.showConfirmDialog(null, "Deseja realmente sair?", "Sair",JOptionPane.YES_NO_OPTION);
				if (sair == 0) {
					System.exit(sair);
				}
			}
			if (ae.getSource() == itemAluno) {
				internalFrame = new TelaAluno();
				desktopPane.add(internalFrame);
			}
			if (ae.getSource() == itemCurso) {
				internalFrame = new TelaCurso();
				desktopPane.add(internalFrame);
			}
			if (ae.getSource() == itemDisciplina) {
				internalFrame = new TelaDisciplina();
				desktopPane.add(internalFrame);
			}
			if (ae.getSource() == itemProfessor) {
				internalFrame = new TelaProfessor();
				desktopPane.add(internalFrame);
			}
			if (ae.getSource() == itemGrade) {
				internalFrame = new TelaGrade();
				desktopPane.add(internalFrame);
			}
			if (ae.getSource() == itemProfDisc) {
				internalFrame = new TelaProfDisc();
				desktopPane.add(internalFrame);
			}
			if (ae.getSource() == itemMatAluno) {
				internalFrame = new TelaAlunoCurso();
				desktopPane.add(internalFrame);
			}
			if (ae.getSource() == itemSobre) {
				JOptionPane.showMessageDialog(null, "Nome do Aplicativo: GSApp\nVers�o: 1.0\nAno: 2019");
			}
		}

	}

	public static void main(String[] args) {
		MenuPrincipal menuPrincipal = new MenuPrincipal();
		menuPrincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
