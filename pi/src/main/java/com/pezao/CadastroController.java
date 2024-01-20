package com.pezao;

import java.sql.SQLException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class CadastroController {

    @FXML
    private TextField tfCargo;

    @FXML
    private TextField tfCpf;

    @FXML
    private TextField tfDataNascimento;

    @FXML
    private TextField tfEmail;

    @FXML
    private TextField tfEndereco;

    @FXML
    private TextField tfNome;

    @FXML
    private TextField tfTelefone;

    @FXML
    private TextField tfDadaAdmissao;

    private FuncionarioDAO funcionarioDAO;

    public CadastroController() {
        this.funcionarioDAO = new FuncionarioDAOImpl();
    }

    @FXML
    void handlerCadastrar(ActionEvent event) {
        String nome = tfNome.getText();
        String cpf = tfCpf.getText();
        String dataNascimento = tfDataNascimento.getText();
        String endereco = tfEndereco.getText();
        String telefone = tfTelefone.getText();
        String email = tfEmail.getText();
        String cargo = tfCargo.getText();
        String dataAdmissao = tfDadaAdmissao.getText();

        Funcionario novoFuncionario = new Funcionario();
        novoFuncionario.setNome(nome);
        novoFuncionario.setCpf(cpf);
        novoFuncionario.setDataNascimento(dataNascimento);
        novoFuncionario.setEndereco(endereco);
        novoFuncionario.setTelefone(telefone);
        novoFuncionario.setEmail(email);
        novoFuncionario.setCargo(cargo);
        novoFuncionario.setDataAdmissao(dataAdmissao);

        try {
            funcionarioDAO.cadastrarFuncionario(novoFuncionario);
            // Limpar os campos após o cadastro, se necessário
            limparCampos();
        } catch (SQLException e) {
            e.printStackTrace();
            // Trate a exceção, exibindo uma mensagem de erro ou outro tratamento adequado
        }
    }

    private void limparCampos() {
        tfNome.clear();
        tfCpf.clear();
        tfDataNascimento.clear();
        tfEndereco.clear();
        tfTelefone.clear();
        tfEmail.clear();
        tfCargo.clear();
        tfDadaAdmissao.clear();
    }
}
