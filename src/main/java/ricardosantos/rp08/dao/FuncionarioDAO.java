/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ricardosantos.rp08.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ricardosantos.rp08.entity.Funcionario;

/**
 *
 * @author ricardo
 */
public interface FuncionarioDAO extends JpaRepository<Funcionario,Long> {
    
}
