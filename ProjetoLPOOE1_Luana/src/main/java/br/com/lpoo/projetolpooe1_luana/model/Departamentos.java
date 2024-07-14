
package br.com.lpoo.projetolpooe1_luana.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author luana
 */
@Entity
@Table(name="tb_departamentos")
public class Departamentos implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "departamentos_id")
    private Integer id;
    
    @ManyToOne
    @JoinColumn(name="empresa_id", referencedColumnName = "empresa_id",  foreignKey = @ForeignKey(name = "FK_empresa"))
    private Empresa empresa;
  
    @Column(nullable = false, length = 100, name = "nome_departamentos")
    private String nome;
    
    @Column(nullable = false, length = 200, name = "local_departamento")
    private String local;
    
    @Column(nullable = false, length = 11, name = "telefone_departamento")
    private String telefone;
    
    @OneToOne
    @JoinColumn(name = "diretores_id")
    private Diretores diretores;
    
    @OneToOne
    @JoinColumn(name = "funcionarios_id")
    private Funcionarios funcionarios;

    public Funcionarios getFuncionarios() {
        return funcionarios;
    }

    public void setFuncionarios(Funcionarios funcionarios) {
        this.funcionarios = funcionarios;
    }
    

    public Diretores getDiretores() {
        return diretores;
    }

    public void setDiretores(Diretores diretores) {
        this.diretores = diretores;
    }
    public Departamentos() {
    }
    

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

  public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    
    
    
    
}
