package sistema.gestao.funcionarios.controller;

import sistema.gestao.funcionario.dto.BancoDeDados;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/funcionarios")
public class FuncionarioController {

    private BancoDeDados bancoDeDados = new BancoDeDados();

    @PostMapping
    public ResponseEntity<String> adicionarFuncionario(@RequestBody Funcionario funcionario) {
        bancoDeDados.adicionarFuncionario(funcionario);
        return ResponseEntity.ok("Funcion�rio adicionado com sucesso.");
    }

    @GetMapping("/{id}")
    public ResponseEntity<Funcionario> obterFuncionario(@PathVariable String id) {
        Funcionario funcionario = bancoDeDados.obterFuncionario(id);
        if (funcionario == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(funcionario);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> atualizarFuncionario(@PathVariable String id, @RequestBody Funcionario funcionario) {
        Funcionario existente = bancoDeDados.obterFuncionario(id);
        if (existente == null) {
            return ResponseEntity.notFound().build();
        }
        bancoDeDados.atualizarFuncionario(funcionario);
        return ResponseEntity.ok("Funcion�rio atualizado com sucesso.");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> excluirFuncionario(@PathVariable String id) {
        Funcionario existente = bancoDeDados.obterFuncionario(id);
        if (existente == null) {
            return ResponseEntity.notFound().build();
        }
        bancoDeDados.excluirFuncionario(id);
        return ResponseEntity.ok("Funcion�rio exclu�do com sucesso.");
    }
}