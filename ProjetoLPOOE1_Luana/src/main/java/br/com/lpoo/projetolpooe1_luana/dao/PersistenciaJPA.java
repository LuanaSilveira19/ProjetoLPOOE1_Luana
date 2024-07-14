
package br.com.lpoo.projetolpooe1_luana.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author luana
 */
public class PersistenciaJPA implements InterfacePersistencia {
    EntityManagerFactory factory;
    EntityManager entity; 

    public PersistenciaJPA() {
       
        factory = Persistence.createEntityManagerFactory("pu_ProjetoLPOOE1");
       
        entity = factory.createEntityManager();
    }

    @Override
    public Boolean conexaoAberta() {
        return entity.isOpen();
    }

    @Override
    public void fecharConexao() {
        entity.close();
    }

    @Override
    public Object find(Class c, Object id) throws Exception {
        return entity.find(c, id);
    }

    @Override
    public void persist(Object o) throws Exception {
        entity.getTransaction().begin();
        entity.persist(o);
        entity.getTransaction().commit();
    }

    @Override
    public void remover(Object o) throws Exception {
        entity.getTransaction().begin();
        entity.remove(o);
        entity.getTransaction().commit();
    }

}
