package br.com.lpoo.projetolpooe1_luana.model;

import br.com.lpoo.projetolpooe1_luana.model.Diretores;
import br.com.lpoo.projetolpooe1_luana.model.Empresa;
import br.com.lpoo.projetolpooe1_luana.model.Funcionarios;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2024-07-11T19:45:17", comments="EclipseLink-2.7.12.v20230209-rNA")
@StaticMetamodel(Departamentos.class)
public class Departamentos_ { 

    public static volatile SingularAttribute<Departamentos, Diretores> diretores;
    public static volatile SingularAttribute<Departamentos, String> telefone;
    public static volatile SingularAttribute<Departamentos, String> nome;
    public static volatile SingularAttribute<Departamentos, Integer> id;
    public static volatile SingularAttribute<Departamentos, Funcionarios> funcionarios;
    public static volatile SingularAttribute<Departamentos, Empresa> empresa;
    public static volatile SingularAttribute<Departamentos, String> local;

}