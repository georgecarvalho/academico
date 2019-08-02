/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ifma.formulario.view.cadastro;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JToolBar;

import com.ifma.formulario.controller.AlunoController;
import com.ifma.formulario.view.menu.BarraDeFerramentas;

import net.miginfocom.swing.MigLayout;

/**
 *
 * @author Carvalho
 */
@SuppressWarnings("serial")
public class TelaAluno extends JInternalFrame {
    
	private AlunoController alunoController;
    private JLabel lblCodigo, lblNome, lblEndereco, lblRG, lblCPF, lblTelefone;
    private JTextField txtCodigo, txtNome, txtEndereco, txtRG, txtCPF, txtTelefone;
    private JButton btCadastrar;
    private JPanel panel;
    private BarraDeFerramentas toolBar;
    private Font fonte;
    private final String ESTILO_LABEL = "pushx,growx,gapleft 250,gapright 0", 
						 ESTILO_TEXT = "pushx,growx,gapright 250,height 30:30:30",
						 ESTILO_BUTTON = "span,pushx,growx,gapleft 250,gapright 250, gapy 20, height 30:30:30";
    private final int TAMANHO_TEXT = 30;
    
    public TelaAluno() {
        panel = new JPanel();
        panel.setLayout(new MigLayout("al center center,wrap 2"));
        this.iniciarComponentes();
        Toolkit tk = getToolkit();
		Dimension d = tk.getScreenSize();
		this.setSize(d.width, d.height);
        this.setTitle("Cadastro de Aluno");
        this.setVisible(true);
    }
    
    public void iniciarComponentes() {
    	alunoController = new AlunoController(this);
    	//Criacao da barra de ferramentas
        toolBar = new BarraDeFerramentas(JToolBar.HORIZONTAL);
        this.add(toolBar, "North");
        
        //Criacao e Adicao dos componentes ao frame
        fonte = new Font(null, Font.PLAIN, 25);
        panel.add(lblCodigo = new JLabel("C�digo"), ESTILO_LABEL);
        lblCodigo.setFont(fonte);
        
        panel.add(txtCodigo = new JTextField(TAMANHO_TEXT), ESTILO_TEXT);
        panel.add(lblNome = new JLabel("Nome"), ESTILO_LABEL);
        lblNome.setFont(fonte);
        
        panel.add(txtNome = new JTextField(TAMANHO_TEXT), ESTILO_TEXT);
        panel.add(lblEndereco = new JLabel("Endere�o"), ESTILO_LABEL);
        lblEndereco.setFont(fonte);
        
        panel.add(txtEndereco = new JTextField(TAMANHO_TEXT), ESTILO_TEXT);
        panel.add(lblRG = new JLabel("RG"), ESTILO_LABEL);
        lblRG.setFont(fonte);
        
        panel.add(txtRG = new JTextField(TAMANHO_TEXT), ESTILO_TEXT);
        panel.add(lblCPF = new JLabel("CPF"), ESTILO_LABEL);
        lblCPF.setFont(fonte);
        
        panel.add(txtCPF = new JTextField(TAMANHO_TEXT), ESTILO_TEXT);
        panel.add(lblTelefone = new JLabel("Telefone"), ESTILO_LABEL);
        lblTelefone.setFont(fonte);
        
        panel.add(txtTelefone = new JTextField(TAMANHO_TEXT), ESTILO_TEXT);
        panel.add(btCadastrar = new JButton("Cadastrar"), ESTILO_BUTTON);
        btCadastrar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent ae) {
				try {
					alunoController.cadastrar();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		});
        this.add(panel, "Center");
    }
    
    public JTextField getTxtCodigo() {
		return txtCodigo;
	}

	public void setTxtCodigo(JTextField txtCodigo) {
		this.txtCodigo = txtCodigo;
	}

	public JTextField getTxtNome() {
		return txtNome;
	}

	public void setTxtNome(JTextField txtNome) {
		this.txtNome = txtNome;
	}

	public JTextField getTxtEndereco() {
		return txtEndereco;
	}

	public void setTxtEndereco(JTextField txtEndereco) {
		this.txtEndereco = txtEndereco;
	}

	public JTextField getTxtRG() {
		return txtRG;
	}

	public void setTxtRG(JTextField txtRG) {
		this.txtRG = txtRG;
	}

	public JTextField getTxtCPF() {
		return txtCPF;
	}

	public void setTxtCPF(JTextField txtCPF) {
		this.txtCPF = txtCPF;
	}

	public JTextField getTxtTelefone() {
		return txtTelefone;
	}

	public void setTxtTelefone(JTextField txtTelefone) {
		this.txtTelefone = txtTelefone;
	}
    
}
