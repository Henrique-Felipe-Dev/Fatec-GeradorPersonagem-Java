package com.company.view;

import com.company.controller.ControllerPersonagem;
import com.company.model.bean.Personagem;

import javax.swing.*;
import java.sql.SQLException;
import java.util.List;

public class ManterPersonagem {

    static ControllerPersonagem contPerson;

    public static void excluir() throws SQLException, ClassNotFoundException {
        int id = Integer.parseInt(JOptionPane.showInputDialog("ID"));
        Personagem personEntrada = new Personagem(id);
        contPerson = new ControllerPersonagem();
        Personagem personSaida = contPerson.excluir(personEntrada);
        JOptionPane.showMessageDialog(null, personSaida.toString());
    }

    public static void alterar() throws SQLException, ClassNotFoundException {
        int id = Integer.parseInt(JOptionPane.showInputDialog("ID"));
        String nome = JOptionPane.showInputDialog("Nome");
        String raca = JOptionPane.showInputDialog("Raça");
        String sexo = JOptionPane.showInputDialog("Sexo");
        int idade = Integer.parseInt(JOptionPane.showInputDialog("Idade"));
        double dano = Double.parseDouble(JOptionPane.showInputDialog("Dano"));
        double hp = Double.parseDouble(JOptionPane.showInputDialog("Hp"));
        Personagem personEntrada = new Personagem(
                id, nome, raca, sexo, idade, dano, hp
        );
        contPerson = new ControllerPersonagem();
        Personagem personSaida = contPerson.alterar(personEntrada);
        JOptionPane.showMessageDialog(null, personSaida.toString());
    }

    public static void listar() throws SQLException, ClassNotFoundException {
        String nome = JOptionPane.showInputDialog("Nome");
        Personagem personEntrada = new Personagem(nome);
        contPerson = new ControllerPersonagem();
        List<Personagem> listapersonSaida = contPerson.listar(personEntrada);
        for(Personagem person : listapersonSaida) {
            JOptionPane.showMessageDialog(null, person.toString());
        }
    }

    public static void buscar() throws SQLException, ClassNotFoundException {
        int id = Integer.parseInt(JOptionPane.showInputDialog("ID"));
        Personagem personEntrada = new Personagem(id);
        contPerson = new ControllerPersonagem();
        Personagem personSaida = contPerson.buscar(personEntrada);
        JOptionPane.showMessageDialog(null, personSaida.toString());
    }

    public static void inserir() throws SQLException, ClassNotFoundException {
        String nome = JOptionPane.showInputDialog("Nome");
        String raca = JOptionPane.showInputDialog("Raca");
        String sexo = JOptionPane.showInputDialog("Sexo");
        int idade = Integer.parseInt(JOptionPane.showInputDialog("Idade"));
        double dano = Double.parseDouble(JOptionPane.showInputDialog("Dano"));
        double hp = Double.parseDouble(JOptionPane.showInputDialog("Hp"));
        Personagem personEntrada = new Personagem(
                nome, raca, sexo, idade, dano, hp
        );
        contPerson = new ControllerPersonagem();
        Personagem personSaida = contPerson.inserir(personEntrada);
        JOptionPane.showMessageDialog(null, personSaida.toString());

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
