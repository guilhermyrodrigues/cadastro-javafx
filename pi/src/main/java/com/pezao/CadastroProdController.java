package com.pezao;

import java.sql.SQLException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class CadastroProdController {

    @FXML
    private Button btnCadastrar;

    @FXML
    private TextField tfDataCadastro;

    @FXML
    private TextField tfDescricao;

    @FXML
    private TextField tfMarca;

    @FXML
    private TextField tfModelo;

    @FXML
    private TextField tfObservacao;

    @FXML
    private TextField tfQuantidade;

    @FXML
    private TextField tfTamanho;

    private ProdutoDAO produtoDAO;

    public CadastroProdController() {
        this.produtoDAO = new ProdutoDAOImpl();
    }

    @FXML
    void handlerCadastrarProduto(ActionEvent event) {
        String dataCadastro = tfDataCadastro.getText();
        String descricao = tfDescricao.getText();
        String marca = tfMarca.getText();
        String modelo = tfModelo.getText();
        String observacao = tfObservacao.getText();
        int quantidade = Integer.parseInt(tfQuantidade.getText());
        String tamanho = tfTamanho.getText();

        Produto novoProduto = new Produto();
        novoProduto.setDataCadastro(dataCadastro);
        novoProduto.setDescricao(descricao);
        novoProduto.setMarca(marca);
        novoProduto.setModelo(modelo);
        novoProduto.setObservacao(observacao);
        novoProduto.setQuantidade(quantidade);
        novoProduto.setTamanho(tamanho);

        try {
            produtoDAO.cadastrarProduto(novoProduto);
            // Limpar os campos após o cadastro, se necessário
            limparCampos();
        } catch (SQLException e) {
            e.printStackTrace();
            // Trate a exceção, exibindo uma mensagem de erro ou outro tratamento adequado
        }
    }

    private void limparCampos() {
        tfDataCadastro.clear();
        tfDescricao.clear();
        tfMarca.clear();
        tfModelo.clear();
        tfObservacao.clear();
        tfQuantidade.clear();
        tfTamanho.clear();
    }

}
