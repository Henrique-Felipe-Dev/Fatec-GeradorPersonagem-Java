/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.view;

import com.company.controller.ControllerUsuario;
import com.company.model.bean.Usuario;

import javax.swing.*;
import java.sql.SQLException;
import java.util.List;


/**
 *
 * @author ProfAlexandre
 */
public class ManterUsuario {
    
    public static void inserir () throws SQLException, ClassNotFoundException {
        String login = JOptionPane.showInputDialog("Login");
        String Senha = JOptionPane.showInputDialog("Senha");
        String status = JOptionPane.showInputDialog("Status");
        String tipo = JOptionPane.showInputDialog("Tipo");
        Usuario usuEntrada = new Usuario(login, Senha, status,tipo);
        ControllerUsuario contUsu = new ControllerUsuario();
        Usuario usuSaida = contUsu.inserir(usuEntrada);
        JOptionPane.showMessageDialog(null,"" + usuSaida.toString());
    }
    
    public static void alterar () throws SQLException, ClassNotFoundException {
        int id = Integer.parseInt(JOptionPane.showInputDialog("id"));
        String login = JOptionPane.showInputDialog("Login");
        String Senha = JOptionPane.showInputDialog("Senha");
        String status = JOptionPane.showInputDialog("Status");
        String tipo = JOptionPane.showInputDialog("Tipo");
        Usuario usuEntrada = new Usuario(id,login, Senha, status,tipo);
        ControllerUsuario contUsu = new ControllerUsuario();
        Usuario usuSaida = contUsu.alterar(usuEntrada);
        JOptionPane.showMessageDialog(null,"" + usuSaida.toString());
    }
 
    public static void excluir () throws SQLException, ClassNotFoundException {
        int id = Integer.parseInt(JOptionPane.showInputDialog("id"));
        Usuario usuEntrada = new Usuario(id);
        ControllerUsuario contUsu = new ControllerUsuario();
        Usuario usuSaida = contUsu.excluir(usuEntrada);
        JOptionPane.showMessageDialog(null,"" + usuSaida.toString());
    }
    
    public static void listar () throws SQLException, ClassNotFoundException {
        
        String login = JOptionPane.showInputDialog("Login");
        Usuario usuEntrada = new Usuario(login);
        ControllerUsuario contUsu = new ControllerUsuario();
        List<Usuario> lista = contUsu.listar(usuEntrada);
        JOptionPane.showMessageDialog(null,"" + lista.get(0).getLogin());
    }

    public static void buscar () throws SQLException, ClassNotFoundException {
        int id = Integer.parseInt(JOptionPane.showInputDialog("id"));
        Usuario usuEntrada = new Usuario(id);
        ControllerUsuario contUsu = new ControllerUsuario();
        Usuario usuSaida = contUsu.buscar(usuEntrada);
        JOptionPane.showMessageDialog(null,"" + usuSaida.toString());
        
    }

    public static boolean validar () throws SQLException, ClassNotFoundException {
        boolean validado = false;
        String login = JOptionPane.showInputDialog("Login");
        String Senha = JOptionPane.showInputDialog("Senha");
        Usuario usuEntrada = new Usuario(login, Senha);
        ControllerUsuario contUsu = new ControllerUsuario();
        validado = contUsu.validar(usuEntrada);
        return validado;
    }

    public static void menu() throws SQLException, ClassNotFoundException {
        int operacao = Integer.parseInt(JOptionPane.showInputDialog("0 - Sair \n 1 - Inserir \n 2 - Alterar \n 3 - Excluir \n 4 - Buscar \n 5 - Listar"));
        switch (operacao) {
            case 0:
               int sair = JOptionPane.showConfirmDialog(null,"Deseja Sair");
               System.out.println("Valor de Sair = " + sair);
               if(sair > 0) menu();
               break;
            case 1:
               inserir();
               break;
           case 2:
               alterar();
               break;
           case 3:
               excluir();
               break;
           case 4:
               buscar();
               break;
           case 5:
               listar();
               break;
           default:
               JOptionPane.showMessageDialog(null,"Erro opcao invalida");
               menu();
               break;
        }
    }

    
    
}


