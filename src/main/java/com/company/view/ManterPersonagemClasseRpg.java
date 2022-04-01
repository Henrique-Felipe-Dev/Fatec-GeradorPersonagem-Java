package com.company.view;

import com.company.controller.ControllerPersonagemClasseRpg;
import com.company.model.bean.PersonagemClasseRpg;

import javax.swing.*;
import java.sql.SQLException;
import java.util.List;

public class ManterPersonagemClasseRpg {

    static ControllerPersonagemClasseRpg contPc;

    public static void excluir() throws SQLException, ClassNotFoundException {
        int id = Integer.parseInt(JOptionPane.showInputDialog("ID"));
        PersonagemClasseRpg pcEntrada = new PersonagemClasseRpg(id);
        contPc = new ControllerPersonagemClasseRpg();
        PersonagemClasseRpg pcSaida = contPc.excluir(pcEntrada);
        JOptionPane.showMessageDialog(null, pcSaida.toString());
    }

    public static void alterar() throws SQLException, ClassNotFoundException {
        int id = Integer.parseInt(JOptionPane.showInputDialog("ID"));
        int idPersonagem = Integer.parseInt(JOptionPane.showInputDialog("idPersonagem"));
        int idClasse = Integer.parseInt(JOptionPane.showInputDialog("idClasse"));
        String obs = JOptionPane.showInputDialog("Obs");
        PersonagemClasseRpg pcEntrada = new PersonagemClasseRpg(id,idPersonagem,idClasse,obs);
        contPc = new ControllerPersonagemClasseRpg();
        PersonagemClasseRpg pcSaida = contPc.alterar(pcEntrada);
        JOptionPane.showMessageDialog(null, pcSaida.toString());
    }

    public static void listar() throws SQLException, ClassNotFoundException {
        String nome = JOptionPane.showInputDialog("Obs");
        PersonagemClasseRpg pcEntrada = new PersonagemClasseRpg(nome);
        contPc = new ControllerPersonagemClasseRpg();
        List<PersonagemClasseRpg> listapcSaida = contPc.listar(pcEntrada);
        for(PersonagemClasseRpg pl : listapcSaida) {
            JOptionPane.showMessageDialog(null, pl.toString());
        }
    }

    public static void buscar() throws SQLException, ClassNotFoundException {
        int id = Integer.parseInt(JOptionPane.showInputDialog("ID"));
        PersonagemClasseRpg pcEntrada = new PersonagemClasseRpg(id);
        contPc = new ControllerPersonagemClasseRpg();
        PersonagemClasseRpg pcSaida = contPc.buscar(pcEntrada);
        JOptionPane.showMessageDialog(null, pcSaida.toString());
    }

    public static void inserir() throws SQLException, ClassNotFoundException {
        int idPersonagemersonagem = Integer.parseInt(JOptionPane.showInputDialog("idPersonagemersonagem"));
        int idClasse = Integer.parseInt(JOptionPane.showInputDialog("idClasse"));
        String obs = JOptionPane.showInputDialog("Observação");
        PersonagemClasseRpg pcEntrada = new PersonagemClasseRpg(idPersonagemersonagem,idClasse,obs);
        contPc = new ControllerPersonagemClasseRpg();
        PersonagemClasseRpg pcSaida = contPc.inserir(pcEntrada);
        JOptionPane.showMessageDialog(null, pcSaida.toString());

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
