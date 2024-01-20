package com.pezao;

import java.sql.*;

public class ProdutoDAOImpl implements ProdutoDAO {

    private static final String URL = "jdbc:postgresql://localhost:5432/PezaoSistemas";
    private static final String USUARIO = "postgres";
    private static final String SENHA = "326444";

    @Override
    public void cadastrarProduto(Produto produto) throws SQLException {
        String sql = "INSERT INTO produto (descricao, tamanho, modelo, marca, quantidade, data_cadastro, observacao) " +
                     "VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (Connection connection = DriverManager.getConnection(URL, USUARIO, SENHA);
             PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            statement.setString(1, produto.getDescricao());
            statement.setString(2, produto.getTamanho());
            statement.setString(3, produto.getModelo());
            statement.setString(4, produto.getMarca());
            statement.setInt(5, produto.getQuantidade());
            statement.setString(6, produto.getDataCadastro());
            statement.setString(7, produto.getObservacao());

            statement.executeUpdate();

            try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    produto.setCodigo(generatedKeys.getInt(1));
                } else {
                    throw new SQLException("Falha ao obter o ID gerado para o produto.");
                }
            }
        }
    }
}
