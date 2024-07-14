
package br.com.lpoo.projetolpooe1_luana.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author luana
 */
@Entity
@Table(name="tb_pessoas")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Pessoas implements Serializable {
     @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "pessoas_id")
    private Integer id;
    
    @Column(nullable = false, length = 100, name = "nome_pessoas")
    private String nome;
    
    @Column(nullable = false, length = 200, name = "endereco_pessoas")
    private String endereco;
    
    @Column(nullable = false, length = 10, name = "data_nascimento")
    private String data_nasc;
    
    @Column(name = "Salario",columnDefinition = "decimal(12,2)")
    private double salario;
    
    @ManyToOne
    @JoinColumn(name="empresa_id", referencedColumnName = "empresa_id",  foreignKey = @ForeignKey(name = "FK_empresa"))
    private Empresa empresa;

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getData_nasc() {
        return data_nasc;
    }

    public void setData_nasc(String data_nasc) {
        this.data_nasc = data_nasc;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }
    
    
}
