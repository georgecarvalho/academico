/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ifma.formulario.view.start;

import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.ifma.formulario.model.LimitaNroCaracteres;
import com.ifma.formulario.view.menu.MenuPrincipal;

/**
 *
 * @author 01aluno
 */
@SuppressWarnings("serial")
public class Login extends JFrame {

    private final Container contents;
    private final JLabel idLabel;
    private final JLabel passwordLabel;
    private final JTextField id;
    private final JPasswordField password;
    private final JButton login;
    Font fonte = new Font("Times New Roman", Font.PLAIN, 14);

    public Login() {
        super("Tela de Login");
        contents = getContentPane();
        contents.setLayout(null);

        //criacao dos componentes
        //Campo de usuario
        idLabel = new JLabel("Usuário");
        idLabel.setBounds(70, 70, 100, 20);
        idLabel.setFont(fonte);
        id = new JTextField(12);
        id.setDocument(new LimitaNroCaracteres(15));
        id.setBounds(125, 70, 100, 25);
        //Campo de senha
        passwordLabel = new JLabel("Senha");
        passwordLabel.setBounds(70, 100, 100, 20);
        passwordLabel.setFont(fonte);
        password = new JPasswordField(8);
        password.setDocument(new LimitaNroCaracteres(5));
        password.setBounds(125, 100, 100, 25);
        password.setEchoChar('*');
        //Botao Login
        login = new JButton("Login");
        login.setBounds(135, 140, 80, 40);

        //adicao dos componentes ao container
        contents.add(idLabel);
        contents.add(id);
        contents.add(passwordLabel);
        contents.add(password);
        contents.add(login);
        TextFieldHandler tfh = new TextFieldHandler();
        login.addActionListener(tfh);
        id.addActionListener(tfh);
        password.addActionListener(tfh);
        setSize(350, 300);
        setLocationRelativeTo(null);
        setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private class TextFieldHandler implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (id.getText().equals("admin")) {
                if (new String(password.getPassword()).equals("admin")) {
                    JOptionPane.showMessageDialog(null, "Seja bem-vindo, " + id.getText() + "!", "Login conclu�do com sucesso", 1);
                    @SuppressWarnings("unused")
					MenuPrincipal menu = new MenuPrincipal();
                    dispose();
                } else {
                    JOptionPane.showMessageDialog(null, "You Shall Not Pass!", "Senha incorreta!", 0);
                }
            } else {
                JOptionPane.showMessageDialog(null, "You Shall Not Pass!", "Usuario ou Senha incorretos!", 0);
            }
        }
    }
    
    public static void main(String[] args) {
        Login login = new Login();
        login.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
