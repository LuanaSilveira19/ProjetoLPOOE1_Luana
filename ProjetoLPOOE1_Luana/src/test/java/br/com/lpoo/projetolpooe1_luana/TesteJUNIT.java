package br.com.lpoo.projetolpooe1_luana;

import br.com.lpoo.projetolpooe1_luana.dao.PersistenciaJPA;
import br.com.lpoo.projetolpooe1_luana.model.Departamentos;
import br.com.lpoo.projetolpooe1_luana.model.Diretores;
import br.com.lpoo.projetolpooe1_luana.model.Empresa;
import br.com.lpoo.projetolpooe1_luana.model.Funcionarios;
import java.util.List;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author luana
 */
public class TesteJUNIT {

    PersistenciaJPA jpa = new PersistenciaJPA();

    @Before // o que fazer antes da persistencia
    public void setUp() {
        jpa.conexaoAberta();
    }

    @After
    public void tearDown() {
        jpa.fecharConexao();
    }

    @Test
    public void testePersistencia() throws Exception {

        Empresa e = new Empresa();
        Departamentos d = new Departamentos();
        Funcionarios f1 = new Funcionarios();
        Diretores dir = new Diretores();
        Departamentos d2 = new Departamentos();
        Funcionarios f2 = new Funcionarios();
        Diretores dir2 = new Diretores();
        
        dir.setNome("Laura");
        dir.setData_nasc("08/02/1994");
        dir.setEndereco("Bairro Boa vista, 347, Rio Pardo");
        dir.setSalario(4500.7653);
        dir.setCargo("Administrador");
        
        dir2.setNome("Gustavo");
        dir2.setData_nasc("08/07/1992");
        dir2.setEndereco("Bairro Ramiz Galvão, 271, Rio Pardo");
        dir2.setSalario(3450.987666);
        dir2.setCargo("Contador");

        jpa.persist(dir);
        jpa.persist(dir2);

        f1.setNome("Patricia");
        f1.setData_nasc("20/01/2004");
        f1.setEndereco("Bairro Fortaleza, 34, Rio Pardo");
        f1.setSalario(2370.2543);
        
        f2.setNome("Amanda");
        f2.setData_nasc("15/01/1989");
        f2.setEndereco("Bairro Vera Cruz, 81, Passo Fundo");
        f2.setSalario(1562.654);
        
        jpa.persist(f1);
        jpa.persist(f2);
        
        d.setLocal("Sala 02, 4º andar");
        d.setNome("Imoveis");
        d.setTelefone("32432442444");
        d.setDiretores(dir);
        d.setFuncionarios(f1);
        
        d2.setLocal("Sala 05, 3º andar");
        d2.setNome("Contabilidade");
        d2.setTelefone("73655627384");
        d2.setDiretores(dir2);
        d2.setFuncionarios(f2);

        jpa.persist(d);
        jpa.persist(d2);
        e.setNome("ABC");
        e.setCNPJ("2817384442124");
        e.setTelefone("9999999999");
        e.setEndereco("São José, 426, Passo Fundo-RS");
        e.setEmail("ABC@gmail.com");
        e.adicionaDepartamentos(d);
        e.contrataFuncionario(dir);
        e.contrataFuncionario(f1);
        e.adicionaDepartamentos(d2);
        e.contrataFuncionario(dir2);
        e.contrataFuncionario(f2);

        jpa.persist(e);

      
        Empresa persistidoEmpresa = (Empresa) jpa.find(Empresa.class, e.getId());
        Assert.assertEquals(e.getNome(), persistidoEmpresa.getNome());

    }
}
