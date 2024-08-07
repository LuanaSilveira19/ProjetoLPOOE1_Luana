
package br.com.lpoo.projetolpooe1_luana.dao;

import br.com.lpoo.projetolpooe1_luana.model.Departamentos;
import br.com.lpoo.projetolpooe1_luana.model.Diretores;
import br.com.lpoo.projetolpooe1_luana.model.Empresa;
import br.com.lpoo.projetolpooe1_luana.model.Funcionarios;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

/**
 *
 * @author luana
 */
public class PersistenciaJPA implements InterfacePersistencia {
    
    public EntityManagerFactory factory;    //fabrica de gerenciadores de entidades
    public EntityManager entity; 
    public PersistenciaJPA() {
        //parametro: é o nome da unidade de persistencia (Persistence Unit)
        factory = Persistence.createEntityManagerFactory("pu_ProjetoLPOOE1");
        //conecta no bd e executa a estratégia de geração.
        entity = factory.createEntityManager();
    }

    @Override
    public Boolean conexaoAberta() {
        if (entity == null || !entity.isOpen()) {
            entity = factory.createEntityManager();
        }
        return entity.isOpen();
    }

    @Override
    public void fecharConexao() {
        if (entity != null && entity.isOpen()) {
            entity.close();
        }
    }

    @Override
    public Object find(Class c, Object id) throws Exception {
        EntityManager em = getEntityManager();
        return em.find(c, id);//encontra um determinado registro 
    }
    
  
     public void persist(Object o) {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(o);
            em.getTransaction().commit();
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            e.printStackTrace();
            throw new RuntimeException("Erro ao persistir a entidade: " + o.getClass().getSimpleName(), e);
        } finally {
            if (em != null && em.isOpen()) {
                em.close();
            }
        }
    }

    //Todos os métodos agora chamam getEntityManager() para garantir que o EntityManager esteja sempre aberto e pronto para uso.
     
    public EntityManager getEntityManager() {
        if (entity == null || !entity.isOpen()) {
            entity = factory.createEntityManager();
        }
        return entity;
    }

    @Override
    public void remover(Object o) throws Exception {
//        No método remover, antes de chamar remove, usamos merge se o objeto não estiver gerenciado.
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            if (!em.contains(o)) {
                o = em.merge(o); // Anexa o objeto ao contexto de persistência, se necessário
            }
            em.remove(o);
            em.getTransaction().commit();
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            throw e;
        }
    }
   

    public List<Funcionarios> getFuncionarios() {
        EntityManager em = getEntityManager();
        try {
            TypedQuery<Funcionarios> query = 
                    em.createQuery("SELECT m FROM Funcionarios m", Funcionarios.class);
            return query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
  
      public List<Diretores> getDiretores() {
        EntityManager em = getEntityManager();
        try {
            TypedQuery<Diretores> query = 
                    em.createQuery("SELECT m FROM Diretores m", Diretores.class);
            return query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
      }
      public List<Departamentos> getDepartamentos() {
        EntityManager em = getEntityManager();
        try {
            TypedQuery<Departamentos> query = 
                    em.createQuery("SELECT m FROM Departamentos m", Departamentos.class);
            return query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
      
      public List<Empresa> getEmpresa() {
        EntityManager em = getEntityManager();
        try {
            TypedQuery<Empresa> query = 
                    em.createQuery("SELECT m FROM Empresa m", Empresa.class);
            return query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
      public boolean existeAssociacaoFuncionario(Funcionarios funcionario) {
        EntityManager em = getEntityManager(); 
        try {
            // Cria uma consulta para verificar se o funcionário está associado a algum departamento
            String query = "SELECT COUNT(d) FROM Departamentos d WHERE d.funcionarios = :funcionario";
            Long count = em.createQuery(query, Long.class)
                           .setParameter("funcionario", funcionario)
                           .getSingleResult();
            return count > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            em.close();
        }
    }
      
       public boolean existeAssociacaoDiretor(Diretores diretores) {
        EntityManager em = getEntityManager(); 
        try {
            // Cria uma consulta para verificar se o funcionário está associado a algum departamento
            String query = "SELECT COUNT(d) FROM Departamentos d WHERE d.diretores = :diretores";
            Long count = em.createQuery(query, Long.class)
                           .setParameter("diretores", diretores)
                           .getSingleResult();
            return count > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            em.close();
        }
    }
       

}
