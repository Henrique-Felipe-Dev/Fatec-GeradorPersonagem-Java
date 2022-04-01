package com.company.view;

import com.company.controller.ControllerClasseRpg;
import com.company.model.bean.ClasseRpg;

import javax.swing.*;
import java.sql.SQLException;
import java.util.List;

public class ManterClasseRpg {

    static ControllerClasseRpg contClasse;

    public static void excluir() throws SQLException, ClassNotFoundException {
        int id = Integer.parseInt(JOptionPane.showInputDialog("ID"));
        ClasseRpg classeEntrada = new ClasseRpg(id);
        contClasse = new ControllerClasseRpg();
        ClasseRpg classeSaida = contClasse.excluir(classeEntrada);
        JOptionPane.showMessageDialog(null, classeSaida.toString());
    }

    public static void alterar() throws SQLException, ClassNotFoundException {
        int id = Integer.parseInt(JOptionPane.showInputDialog("ID"));
        String tipo = JOptionPane.showInputDialog("Tipo");
        String arma = JOptionPane.showInputDialog("Arma");
        double bonusHp = Double.parseDouble(JOptionPane.showInputDialog("Bônus Dano"));
        double bonusDano = Double.parseDouble(JOptionPane.showInputDialog("Bônus Hp"));
        ClasseRpg classeEntrada = new ClasseRpg(
                id, tipo, arma, bonusHp, bonusDano
        );
        contClasse = new ControllerClasseRpg();
        ClasseRpg classeSaida = contClasse.alterar(classeEntrada);
        JOptionPane.showMessageDialog(null, classeSaida.toString());
    }

    public static void listar() throws SQLException, ClassNotFoundException {
        String nome = JOptionPane.showInputDialog("Nome");
        ClasseRpg classeEntrada = new ClasseRpg(nome);
        contClasse = new ControllerClasseRpg();
        List<ClasseRpg> listaclasseSaida = contClasse.listar(classeEntrada);
        for(ClasseRpg person : listaclasseSaida) {
            JOptionPane.showMessageDialog(null, person.toString());
        }
    }

    public static void buscar() throws SQLException, ClassNotFoundException {
        int id = Integer.parseInt(JOptionPane.showInputDialog("ID"));
        ClasseRpg classeEntrada = new ClasseRpg(id);
        contClasse = new ControllerClasseRpg();
        ClasseRpg classeSaida = contClasse.buscar(classeEntrada);
        JOptionPane.showMessageDialog(null, classeSaida.toString());
    }

    public static void inserir() throws SQLException, ClassNotFoundException {
        String tipo = JOptionPane.showInputDialog("Tipo");
        String arma = JOptionPane.showInputDialog("Arma");
        double bonusHp = Double.parseDouble(JOptionPane.showInputDialog("Bônus Dano"));
        double bonusDano = Double.parseDouble(JOptionPane.showInputDialog("Bônus Hp"));
        ClasseRpg classeEntrada = new ClasseRpg(
                tipo, arma, bonusHp, bonusDano
        );
        contClasse = new ControllerClasseRpg();
        ClasseRpg classeSaida = contClasse.inserir(classeEntrada);
        JOptionPane.showMessageDialog(null, classeSaida.toString());

    }

    public static void menu() throws SQLException, ClassNotFoundException {
        int operacao = Integer.parseInt(JOptionPane.showInputDialog("0 - Sair \n 1 - Inserir \n 2 - Alterar \n 3 - Excluir \n 4 - Buscar \n 5 - Listar"));
        switch (operacao) {
            case 0 -> {
                int sair = JOptionPane.showConfirmDialog(null, "Deseja Sair");
                System.out.println("Valor de Sair = " + sair);
                if (sair > 0) menu();
            }
            case 1 -> inserir();
            case 2 -> alterar();
            case 3 -> excluir();
            case 4 -> buscar();
            case 5 -> listar();
            default -> {
                JOptionPane.showMessageDialog(null, "Erro opcao invalida");
                menu();
            }
        }
    }
    
}
