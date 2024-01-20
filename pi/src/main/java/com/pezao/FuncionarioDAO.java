package com.pezao;

import java.sql.SQLException;

public interface FuncionarioDAO {
   public void cadastrarFuncionario(Funcionario funcionario) throws SQLException;
}
