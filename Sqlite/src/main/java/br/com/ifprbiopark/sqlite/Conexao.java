/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ifprbiopark.sqlite;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author bruna.charnovski
 */
public class Conexao {

    public static void main(String[] args) {
        conect();
    }

    public static void conect() {
        try {
            Connection c = DriverManager.getConnection("jdbc:sqlite:tds.db");
            Statement stm = c.createStatement();
            // criando uma tabela
            stm.execute("CREATE TABLE IF NOT EXISTS ALUNO(ID INTEGER, NOME VARCHAR(50))");

            // inserindo registros
            stm.execute("INSERT INTO ALUNO (ID, NOME) VALUES (1,'BRUNA'), (2,'MARCOS')");
            
            // lendo registros
            String sql = "SELECT  * FROM ALUNO";
            PreparedStatement pstm = c.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()){
                System.out.print("ID: ");
                System.out.print(rs.getInt("ID"));
                System.out.print(" NOME: ");
                System.out.println(rs.getString("NOME"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
