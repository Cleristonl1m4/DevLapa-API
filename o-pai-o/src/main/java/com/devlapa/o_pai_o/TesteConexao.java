package com.devlapa.o_pai_o;

import java.sql.Connection;
import java.sql.DriverManager;

public class TesteConexao {
    public static void main(String[] args) {
        String url = "jdbc:postgresql://localhost:5432/DevLapa";
        String usuario = "postgres";
        String senha = "1973";

        try {
            Connection conexao = DriverManager.getConnection(url, usuario, senha);
            System.out.println("✅ Conexão bem sucedida!");
            conexao.close();
        } catch (Exception e) {
            System.out.println("❌ Erro na conexão: " + e.getMessage());
        }
    }
}