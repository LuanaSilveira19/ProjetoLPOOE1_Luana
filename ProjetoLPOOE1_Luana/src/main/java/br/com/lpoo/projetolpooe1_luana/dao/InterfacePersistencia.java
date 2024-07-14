
package br.com.lpoo.projetolpooe1_luana.dao;

/**
 *
 * @author luana
 */
public interface InterfacePersistencia {
    public Boolean conexaoAberta();
    public void fecharConexao();
    public Object find(Class c, Object id) throws Exception;
    public void persist(Object o) throws Exception;
    public void remover(Object o) throws Exception;
    
}
