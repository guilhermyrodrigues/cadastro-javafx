package com.pezao;

import java.sql.SQLException;


public interface ProdutoDAO {
    void cadastrarProduto(Produto produto) throws SQLException;
}
