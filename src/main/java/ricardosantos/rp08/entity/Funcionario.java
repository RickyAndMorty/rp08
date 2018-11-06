/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ricardosantos.rp08.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import lombok.Data;

/**
 *
 * @author ricardo
 */
@Data
@Entity
public class Funcionario {
    private @Id @GeneratedValue Long id;
    private String nome;
    private int idade;
    private float salario;
    
    public Funcionario(){
        this.nome = String.valueOf(' ');
        this.idade = 0;
        this.salario = 0;        
    }
    
    public Funcionario(String nome, int idade,float salario){
        this.nome = nome;
        this.idade = idade;
        this.salario = salario;
    }
    
    public String getNome(){
        return nome;
    }
    
    public int getIdade(){
        return idade;
    }
    
    public float getSalario(){
        return salario;
    }
    
    public Long getId(){
        return id;
    }
    
    public void setNome(String nome){
        this.nome = nome;
    }
    
    public void setIdade(int idade){
        this.idade = idade;
    }
    
    public void setSalario(float salario){
        this.salario = salario;
    }
    
    public void setId(Long id){
        this.id = id;
    }
    
}
