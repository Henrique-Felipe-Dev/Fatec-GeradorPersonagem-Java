package com.company;

import com.company.view.*;

import javax.swing.*;
import java.sql.SQLException;

public class Main {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        if (ManterUsuario.validar()) {
            menu();
        } else {
            JOptionPane.showMessageDialog(null, "Usuario Invalido");
        }
    }

    public static void menu() throws SQLException, ClassNotFoundException {

        try{
            int operacao = Integer.parseInt(
                    JOptionPane.showInputDialog(
                            """
                                    0 - Sair\s
                                    1 - Usuario\s
                                    2 - Personagem\s
                                    3 - ClasseRpg\s
                                    4 - PersonagemClasseRpg"""
                    )
            );
            switch (operacao) {
                case 0 -> {
                    int sair = JOptionPane.showConfirmDialog(
                            null, "Deseja Sair"
                    );
                    if (sair > 0) menu();
                    System.out.println("Valor de Sair = " + sair);
                }
                case 1 -> ManterUsuario.menu();
                case 2 -> ManterPersonagem.menu();
                case 3 -> ManterClasseRpg.menu();
                case 4 -> ManterPersonagemClasseRpg.menu();
                default -> {
                    JOptionPane.showMessageDialog(
                            null, "Erro opcao invalida"
                    );
                    menu();
                }
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
