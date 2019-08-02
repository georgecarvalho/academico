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
import com.ifma.formulario.controller.GradeController;
import com.ifma.formulario.view.menu.BarraDeFerramentas;
import net.miginfocom.swing.MigLayout;

/**
 *
 * @author Carvalho
 */
@SuppressWarnings("serial")
public class TelaGrade extends JInternalFrame {

	private GradeController gradeController;
	private JPanel panel;
	private BarraDeFerramentas toolbar;
	@SuppressWarnings("unused")
	private JLabel lblAno, lblCurso, lblDisciplina;
	private JComboBox<String> cbAno, cbCurso, cbDisciplina;
	private JTable table;
	private JButton btAdicionar;
	private final String ESTILO_LABEL = "pushx,growx,gapleft 250,gapright 0",
			ESTILO_COMBOBOX = "pushx,growx,gapright 250,height 30:30:30",
			ESTILO_BUTTON = "span,pushx,growx,gapleft 250,gapright 250, gapy 20, height 30:30:30",
			ESTILO_TABLE = "span,pushx,growx,gapleft 250,gapright 250, gapy 20";
	// private final int TAMANHO_TEXT = 30;

	public TelaGrade() {

		panel = new JPanel();
		panel.setLayout(new MigLayout("al center center, wrap 2"));
		this.iniciarComponentes();
		Toolkit tk = getToolkit();
		Dimension d = tk.getScreenSize();
		this.setSize(d.width, d.height);
		this.add(panel, "Center");
		this.setTitle("Grade de disciplinas");
		this.setVisible(true);
	}

	public void iniciarComponentes() {
		// Criacao da barra de ferramentas
		toolbar = new BarraDeFerramentas(JToolBar.HORIZONTAL);
		this.add(toolbar, "North");
		gradeController = new GradeController(this);

		// criacao das caixas de selecao
		panel.add(lblAno = new JLabel("Ano:"), ESTILO_LABEL);
		panel.add(cbAno = new JComboBox<String>(), ESTILO_COMBOBOX);
		cbAno.addItem("2017");
		cbAno.addItem("2018");
		cbAno.addItem("2019");

		panel.add(lblCurso = new JLabel("Curso:"), ESTILO_LABEL);
		panel.add(cbCurso = new JComboBox<String>(), ESTILO_COMBOBOX);

		panel.add(lblDisciplina = new JLabel("Disciplina:"), ESTILO_LABEL);
		panel.add(cbDisciplina = new JComboBox<String>(), ESTILO_COMBOBOX);
		
		try {
			gradeController.preencherComboBox();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (NullPointerException e) {
			e.printStackTrace();
		}
		
		panel.add(btAdicionar = new JButton("Adicionar"), ESTILO_BUTTON);
		
		// criacao da grade
		String colunas[] = { "Disciplina", "Carga Hor�ria" };
		final DefaultTableModel model = new DefaultTableModel();
		model.setColumnIdentifiers(colunas);
		table = new JTable();
		table.setModel(model);
    	JScrollPane scrollPane = new JScrollPane(table);
		panel.add(scrollPane, ESTILO_TABLE);
		btAdicionar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent ae) {
				try {
					String[] dados = gradeController.adicionarNaTabela();
					model.addRow(dados);
				} catch (SQLException e) {
					e.printStackTrace();
				} catch (NullPointerException e) {
					e.printStackTrace();
				}
			}
		});
		this.add(panel, "Center");

	}

	public JComboBox<String> getCbAno() {
		return cbAno;
	}

	public JComboBox<String> getCbCurso() {
		return cbCurso;
	}

	public JComboBox<String> getCbDisciplina() {
		return cbDisciplina;
	}

	public JTable getTable() {
		return table;
	}

}
