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
import com.ifma.formulario.controller.DisciplinaController;
import com.ifma.formulario.view.menu.BarraDeFerramentas;
import net.miginfocom.swing.MigLayout;

/**
 *
 * @author Carvalho
 */
@SuppressWarnings("serial")
public class TelaDisciplina extends JInternalFrame {
    
	private DisciplinaController disciplinaController;
	private JLabel lblCodigo, lblNome, lblEmenta, lblCargaHoraria;
    private JTextField txtCodigo, txtNome, txtEmenta, txtCargaHoraria;
    private JButton btCadastrar;
    private JPanel panel;
    private BarraDeFerramentas toolbar;
    private Font fonte;
    private final String ESTILO_LABEL = "pushx,growx,gapleft 250,gapright 0", 
						 ESTILO_TEXT = "pushx,growx,gapright 250,height 30:30:30",
						 ESTILO_BUTTON = "span,pushx,growx,gapleft 250,gapright 250, gapy 20, height 30:30:30";
    private final int TAMANHO_TEXT = 30;
    
    public TelaDisciplina() {
        this.title = "Cadastro de Disciplina";
        panel = new JPanel();
        panel.setLayout(new MigLayout("al center center,wrap 2"));
        this.iniciarComponentes();
        Toolkit tk = getToolkit();
		Dimension d = tk.getScreenSize();
		this.setSize(d.width, d.height);
        this.setTitle("Cadastro de Disciplina");
        this.setVisible(true);
    }
    
    public void iniciarComponentes() {
    	//Criacao da barra de ferramentas
        toolbar = new BarraDeFerramentas(JToolBar.HORIZONTAL);
        this.add(toolbar, "North");
        disciplinaController = new DisciplinaController(this);
        
        //Criacao e Adicao dos componentes ao frame
        fonte = new Font(null, Font.PLAIN, 25);
        panel.add(lblCodigo = new JLabel("C�digo"), ESTILO_LABEL);
        lblCodigo.setFont(fonte);
        panel.add(txtCodigo = new JTextField(TAMANHO_TEXT), ESTILO_TEXT);
        panel.add(lblNome = new JLabel("Disciplina"), ESTILO_LABEL);
        lblNome.setFont(fonte);
        panel.add(txtNome = new JTextField(TAMANHO_TEXT), ESTILO_TEXT);
        panel.add(lblEmenta = new JLabel("Ementa"), ESTILO_LABEL);
        lblEmenta.setFont(fonte);
        panel.add(txtEmenta = new JTextField(TAMANHO_TEXT), ESTILO_TEXT);
        panel.add(lblCargaHoraria = new JLabel("Carga Hor�ria"), ESTILO_LABEL);
        lblCargaHoraria.setFont(fonte);
        panel.add(txtCargaHoraria = new JTextField(TAMANHO_TEXT), ESTILO_TEXT);
        panel.add(btCadastrar = new JButton("Cadastrar"), ESTILO_BUTTON);
        this.add(panel, "Center");
        btCadastrar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent ae) {
				try {
					disciplinaController.cadastrar();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		});
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

	public JTextField getTxtEmenta() {
		return txtEmenta;
	}

	public void setTxtEmenta(JTextField txtEmenta) {
		this.txtEmenta = txtEmenta;
	}

	public JTextField getTxtCargaHoraria() {
		return txtCargaHoraria;
	}

	public void setTxtCargaHoraria(JTextField txtCargaHoraria) {
		this.txtCargaHoraria = txtCargaHoraria;
	}
    
}

