
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
@Table(name="tb_funcionarios")
public class Funcionarios extends Pessoas implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "funcionarios_id")
    private Integer id;
 
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
       
}
