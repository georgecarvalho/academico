/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ifma.formulario.view.spf;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JToolBar;
import javax.swing.table.DefaultTableModel;
import com.ifma.formulario.controller.AlunoCursoController;
import com.ifma.formulario.view.menu.BarraDeFerramentas;
import net.miginfocom.swing.MigLayout;

/**
 *
 * @author Carvalho
 */
@SuppressWarnings("serial")
public class TelaAlunoCurso extends JInternalFrame {
    
    private JPanel panel;
    private BarraDeFerramentas toolbar;
    @SuppressWarnings("unused")
	private JLabel lblAluno, lblCurso;
    private JComboBox<String> cbAluno, cbCurso;
    private JTable table;
    private AlunoCursoController alunoCursoController;
    private JButton btAdicionar;
    private final String ESTILO_LABEL = "pushx,growx,gapleft 250,gapright 0",
			ESTILO_COMBOBOX = "pushx,growx,gapright 250,height 30:30:30",
			ESTILO_BUTTON = "span,pushx,growx,gapleft 250,gapright 250, gapy 20, height 30:30:30",
			ESTILO_TABLE = "span,pushx,growx,gapleft 250,gapright 250, gapy 20";
    
    public TelaAlunoCurso(){
        panel = new JPanel();
        panel.setLayout(new MigLayout("al center center, wrap 2"));
        this.iniciarComponentes();
        Toolkit tk = getToolkit();
		Dimension d = tk.getScreenSize();
		this.setSize(d.width, d.height);
        this.setTitle("Aluno/Curso");
        this.setVisible(true);
    }
    
    public void iniciarComponentes() {
    	//Criacao da barra de ferramentas
        toolbar = new BarraDeFerramentas(JToolBar.HORIZONTAL);
        this.add(toolbar, "North");
        alunoCursoController = new AlunoCursoController(this);
        
        //criacao das caixas de selecao
        panel.add(lblAluno = new JLabel("Aluno:"), ESTILO_LABEL);
        panel.add(cbAluno = new JComboBox<String>(), ESTILO_COMBOBOX);
        
        panel.add(lblCurso = new JLabel("Curso:"), ESTILO_LABEL);
        panel.add(cbCurso = new JComboBox<String>(), ESTILO_COMBOBOX);
        
        try {
        	alunoCursoController.preencherComboBox();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (NullPointerException e) {
			e.printStackTrace();
		}
        
        panel.add(btAdicionar = new JButton("Adicionar"), ESTILO_BUTTON);
        
     // criacao da grade
     		String colunas[] = { "Aluno", "Curso" };
     		final DefaultTableModel model = new DefaultTableModel();
     		model.setColumnIdentifiers(colunas);
     		table = new JTable();
     		table.setModel(model);
         	JScrollPane scrollPane = new JScrollPane(table);
     		panel.add(scrollPane, ESTILO_TABLE);
     		btAdicionar.addActionListener(new ActionListener() {
     			@Override
     			public void actionPerformed(ActionEvent ae) {
     				String alunoCurso = cbAluno.getSelectedItem().toString().concat("/" + cbCurso.getSelectedItem().toString());
     				String[] dados = alunoCurso.split("/");
     				model.addRow(dados);
     			}
     		});
        this.add(panel, "Center");
    }

	public JComboBox<String> getCbAluno() {
		return cbAluno;
	}

	public JComboBox<String> getCbCurso() {
		return cbCurso;
	}
    
    
}
