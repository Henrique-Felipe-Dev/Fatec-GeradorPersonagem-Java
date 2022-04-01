package com.company.model.dao;

import com.company.model.bean.Personagem;
import com.company.util.Conexao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DaoPersonagem {

    private final Connection c;

    public DaoPersonagem() throws SQLException, ClassNotFoundException {
        this.c = new Conexao().getConnection();
    }

    public Personagem inserir(Personagem person) throws SQLException{

        try{
            String sql = "insert into personagem" +
                    " (nome, raca, sexo, idade, dano, hp)" +
                    " values (?,?,?,?,?,?)";

            // prepared statement para inserção
            PreparedStatement stmt = c.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            // seta os valores
            stmt.setString(1,person.getNome());
            stmt.setString(2,person.getRaca());
            stmt.setString(3,person.getSexo());
            stmt.setInt(4, person.getIdade());
            stmt.setDouble(5, person.getDano());
            stmt.setDouble(6, person.getHp());

            // executa
            stmt.executeUpdate();
            ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next()) {
                int id = rs.getInt(1);
                person.setId(id);
            }
            stmt.close();
            return person;
        }catch (SQLException e){
            System.out.println(e.getMessage());
            return new Personagem(1);
        }


    }

    public Personagem alterar(Personagem person) throws SQLException{

        try {
            String sql = "UPDATE personagem SET " +
                    "nome = ?, raca = ?, sexo = ?, idade = ?, dano = ?, hp = ? " +
                    " WHERE id = ?";
            // prepared statement para inserção
            PreparedStatement stmt = c.prepareStatement(sql);
            // seta os valores
            stmt.setString(1,person.getNome());
            stmt.setString(2,person.getRaca());
            stmt.setString(3,person.getSexo());
            stmt.setInt(4, person.getIdade());
            stmt.setDouble(5, person.getDano());
            stmt.setDouble(6, person.getHp());
            stmt.setInt(7, person.getId());

            // executa
            stmt.execute();
            stmt.close();
            return person;
        }catch (SQLException e){
            System.out.println(e.getMessage());
            return new Personagem(1);
        }


    }

    public Personagem excluir(Personagem person) throws SQLException{

        try{

            String sql = "delete from personagem WHERE id = ?";
            // prepared statement para inserção
            PreparedStatement stmt = c.prepareStatement(sql);
            // seta os valores
            stmt.setInt(1,person.getId());
            // executa
            stmt.execute();
            stmt.close();
            c.close();
            return person;

        }catch (SQLException e){
            System.out.println(e.getMessage());
            return new Personagem(1);
        }

    }

    public Personagem buscar(Personagem person) throws SQLException{
        String sql = "select * from personagem WHERE id = ?";
        PreparedStatement stmt = this.c.prepareStatement(sql);
        // seta os valores
        stmt.setInt(1,person.getId());
        // executa
        ResultSet rs = stmt.executeQuery();
        Personagem personSaida = null;
        while (rs.next()) {
            // criando o objeto Usuario
            personSaida = new Personagem(
                    rs.getInt(1),
                    rs.getString(2),
                    rs.getString(3),
                    rs.getString(4),
                    rs.getInt(5),
                    rs.getDouble(6),
                    rs.getDouble(7));
            // adiciona o usu à lista de usus
        }
        stmt.close();
        return personSaida;
    }

    public List<Personagem> listar(Personagem personEnt) throws SQLException{
        // usus: array armazena a lista de registros

        List<Personagem> persons = new ArrayList<>();

        String sql = "select * from personagem where nome like ?";
        PreparedStatement stmt = this.c.prepareStatement(sql);
        // seta os valores
        stmt.setString(1,"%" + personEnt.getNome() + "%");

        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            // criando o objeto Usuario
            Personagem person = new Personagem(
                    rs.getInt(1),
                    rs.getString(2),
                    rs.getString(3),
                    rs.getString(4),
                    rs.getInt(5),
                    rs.getDouble(6),
                    rs.getDouble(7));
            // adiciona o usu à lista de usus
            persons.add(person);
        }

        rs.close();
        stmt.close();
        return persons;

    }
    
}
