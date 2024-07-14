
package br.com.lpoo.projetolpooe1_luana.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author luana
 */
@Entity
@Table(name="tb_diretores")
public class Diretores extends Pessoas implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "diretores_id")
    private Integer id;
    
    @Column(nullable = false, length = 100, name = "cargo_diretor")
    private String cargo;
 
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    
  
    
}
