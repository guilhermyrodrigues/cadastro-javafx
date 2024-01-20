package com.pezao;

import java.sql.*;


public class FuncionarioDAOImpl implements FuncionarioDAO {

    private static final String URL = "jdbc:postgresql://localhost:5432/PezaoSistemas";
    private static final String USUARIO = "postgres";
    private static final String SENHA = "326444";

    @Override
    public void cadastrarFuncionario(Funcionario funcionario) throws SQLException {
        String sql = "INSERT INTO funcionario (nome, cpf, data_nascimento, endereco, telefone, email, cargo, data_admissao) " +
                     "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection connection = DriverManager.getConnection(URL, USUARIO, SENHA);
             PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            statement.setString(1, funcionario.getNome());
            statement.setString(2, funcionario.getCpf());
            statement.setString(3, (funcionario.getDataNascimento()));
            statement.setString(4, funcionario.getEndereco());
            statement.setString(5, funcionario.getTelefone());
            statement.setString(6, funcionario.getEmail());
            statement.setString(7, funcionario.getCargo());
            statement.setString(8, (funcionario.getDataAdmissao()));

            statement.executeUpdate();

            try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    funcionario.setId(generatedKeys.getInt(1));
                } else {
                    throw new SQLException("Falha ao obter o ID gerado para o funcionário.");
                }
            }
        }
    }

}
