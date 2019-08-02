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
import com.ifma.formulario.controller.ProfDiscController;
import com.ifma.formulario.view.menu.BarraDeFerramentas;
import net.miginfocom.swing.MigLayout;

/**
 *
 * @author Carvalho
 */
@SuppressWarnings("serial")
public class TelaProfDisc extends JInternalFrame {
    
    private JPanel panel;
    private BarraDeFerramentas toolbar;
    @SuppressWarnings("unused")
	private JLabel lblProfessor, lblDisciplina;
    private JComboBox<String> cbProfessor, cbDisciplina;
    private JTable table;
    private ProfDiscController profDiscController;
    private JButton btAdicionar;
    private final String ESTILO_LABEL = "pushx,growx,gapleft 250,gapright 0",
			ESTILO_COMBOBOX = "pushx,growx,gapright 250,height 30:30:30",
			ESTILO_BUTTON = "span,pushx,growx,gapleft 250,gapright 250, gapy 20, height 30:30:30",
			ESTILO_TABLE = "span,pushx,growx,gapleft 250,gapright 250, gapy 20";
    
    public TelaProfDisc(){
        panel = new JPanel();
        panel.setLayout(new MigLayout("al center center,wrap 2"));
        this.iniciarComponentes();
        Toolkit tk = getToolkit();
		Dimension d = tk.getScreenSize();
		this.setSize(d.width, d.height);
        this.setTitle("Professor/Disciplina");
        this.setVisible(true);
    }
    
    public void iniciarComponentes() {
    	//Criacao da barra de ferramentas
        toolbar = new BarraDeFerramentas(JToolBar.HORIZONTAL);
        this.add(toolbar, "North");
        profDiscController = new ProfDiscController(this);
        
        //criacao das caixas de selecao
        panel.add(lblProfessor = new JLabel("Professor:"), ESTILO_LABEL);
        panel.add(cbProfessor = new JComboBox<String>(), ESTILO_COMBOBOX);
        
        panel.add(lblDisciplina = new JLabel("Disciplina:"), ESTILO_LABEL);
        panel.add(cbDisciplina = new JComboBox<String>(), ESTILO_COMBOBOX);
        
        try {
        	profDiscController.preencherComboBox();
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
     				String profDisc = cbProfessor.getSelectedItem().toString().concat("/" + cbDisciplina.getSelectedItem().toString());
     				String[] dados = profDisc.split("/");
     				model.addRow(dados);
     			}
     		});
        this.add(panel, "Center");
    }

	public JComboBox<String> getCbProfessor() {
		return cbProfessor;
	}

	public JComboBox<String> getCbDisciplina() {
		return cbDisciplina;
	}
    
}
