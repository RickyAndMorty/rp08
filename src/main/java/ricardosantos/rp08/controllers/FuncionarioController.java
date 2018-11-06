/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ricardosantos.rp08.controllers;

import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ricardosantos.rp08.dao.FuncionarioDAO;
import ricardosantos.rp08.entity.Funcionario;

/**
 *
 * @author ricardo
 */
@RestController
public class FuncionarioController {

    private FuncionarioDAO funcionarios;

    FuncionarioController(FuncionarioDAO funcionarios) {
        this.funcionarios = funcionarios;
    }

    @GetMapping("/funcionarios")
    List<Funcionario> listar() {
        return funcionarios.findAll();
    }

    @PostMapping("/funcionarios")
    Funcionario addFuncionario(@RequestBody Funcionario newEmployee) {
        return funcionarios.save(newEmployee);
    }

    @GetMapping("/funcionarios/{id}")
    Funcionario getOne(@PathVariable Long id) {

        return funcionarios.findById(id)
                .orElseThrow(() -> new EmployeeNotFoundException(id));
    }

    @PutMapping("/funcionarios/{id}")
    Funcionario updateFuncionario(@RequestBody Funcionario novoFuncionario, @PathVariable Long id) {

        return funcionarios.findById(id)
                .map(funcionario -> {
                    funcionario.setNome(novoFuncionario.getNome());
                    funcionario.setIdade(novoFuncionario.getIdade());
                    funcionario.setSalario(novoFuncionario.getSalario());
                    return funcionarios.save(funcionario);
                })
                .orElseGet(() -> {
                    novoFuncionario.setId(id);
                    return funcionarios.save(novoFuncionario);
                });
    }

    @DeleteMapping("/funcionarios/{id}")
    void deletarFuncionario(@PathVariable Long id) {
        funcionarios.deleteById(id);
    }

}
