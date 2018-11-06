/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ricardosantos.rp08.controllers;

import ricardosantos.rp08.entity.Funcionario;

/**
 *
 * @author ricardo
 */
class EmployeeNotFoundException extends RuntimeException {

	EmployeeNotFoundException(Long id) {
		super("Não podemos encontrar o funcionario " + id);
	}
}