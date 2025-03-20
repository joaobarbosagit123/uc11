import java.sql.*;

public class Cadastro {
    public static void main(String[] args) {
        // Exibe mensagem de boas-vindas
        System.out.println("Bem-vindo ao sistema de cadastro!");

        try {
            // Estabelece a conexão com o banco de dados
            Connection conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/uc11", "root", "sua_senha");

            // Definindo os dados do produto a ser cadastrado
            String nome = "PS5";
            int valor = 5000;
            String status = "A Venda";

            // Prepara a query para inserir o produto
            String query = "INSERT INTO produtos (nome, valor, status) VALUES (?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, nome);
            stmt.setInt(2, valor);
            stmt.setString(3, status);

            // Executa a query de inserção
            int result = stmt.executeUpdate();

            // Exibe mensagem de sucesso ou falha
            if (result > 0) {
                System.out.println("Cadastro realizado com sucesso!");
            } else {
                System.out.println("Falha no cadastro.");
            }

        } catch (SQLException e) {
            // Exibe mensagem de erro caso ocorra um problema na conexão ou na query
            System.out.println("Erro: " + e.getMessage());
        }
    }
}
