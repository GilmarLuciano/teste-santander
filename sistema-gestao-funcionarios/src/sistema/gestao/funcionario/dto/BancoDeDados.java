package sistema.gestao.funcionario.dto;

import java.util.HashMap;
import java.util.Map;

import sistema.gestao.funcionarios.model.Funcionario;

public class BancoDeDados {
    private Map<String, Funcionario> funcionarios;

    public BancoDeDados() {
        this.funcionarios = new HashMap<>();
    }

    // Adicionar novo funcion�rio
    public void adicionarFuncionario(Funcionario funcionario) {
        funcionarios.put(funcionario.getId(), funcionario);
    }

    // Obter detalhes de um funcion�rio existente
    public Funcionario obterFuncionario(String id) {
        return funcionarios.get(id);
    }

    // Atualizar detalhes de um funcion�rio existente
    public void atualizarFuncionario(Funcionario funcionario) {
        funcionarios.put(funcionario.getId(), funcionario);
    }

    // Excluir um funcion�rio existente
    public void excluirFuncionario(String id) {
        funcionarios.remove(id);
    }

    // Outros m�todos de consulta e manipula��o podem ser adicionados conforme necess�rio
}
