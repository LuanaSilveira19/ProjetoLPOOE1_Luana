
package br.com.lpoo.projetolpooe1_luana.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author luana
 */
@Entity
@Table(name="tb_empresa")
public class Empresa implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "empresa_id")
    private Integer id;
    
    @OneToMany( mappedBy = "empresa", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<Departamentos>dep=new ArrayList();
    
  /*  @OneToMany( mappedBy = "empresa", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<Pessoas>p=new ArrayList();*/
    
    @Column(nullable = false, length = 100, name = "nome_empresa")
    private String nome;
    
    @Column(nullable = false, length = 200, name = "endereço_empresa")
    private String endereco;
    
   @Column(nullable = false, length = 14, name = "CNPJ_empresa")
    private String CNPJ;
    
   @Column(nullable = false, length = 10, name = "telefone_empresa")
    private String telefone;
    
  @Column(nullable = false, length = 100, name = "email_empresa")
    private String email;

  /*  public List<Pessoas> getP() {
        return p;
    }

    public void setP(List<Pessoas> p) {
        this.p = p;
    }*/

    public List<Departamentos> getDep() {
        return dep;
    }

    public void setDep(List<Departamentos> dep) {
        this.dep = dep;
    }
     public void adicionaDepartamentos(Departamentos obj){
                 obj.setEmpresa(this);
                 this.dep.add(obj);
   }
    public void removeDepartamentos(Departamentos obj){
                 this.dep.remove(obj);
   }
    
   /*   public void contrataFuncionario(Pessoas obj){
                 obj.setEmpresa(this);
                 this.p.add(obj);
   }
    public void demiteFuncionario(Pessoas obj){
                 this.p.remove(obj);
   }*/
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

    public String getCNPJ() {
        return CNPJ;
    }

    public void setCNPJ(String CNPJ) {
        this.CNPJ = CNPJ;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
  @Override
public String toString() {
    return this.nome;
}
}
