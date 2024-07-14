package br.com.lpoo.projetolpooe1_luana.model;

import br.com.lpoo.projetolpooe1_luana.model.Departamentos;
import br.com.lpoo.projetolpooe1_luana.model.Pessoas;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2024-07-11T19:45:17", comments="EclipseLink-2.7.12.v20230209-rNA")
@StaticMetamodel(Empresa.class)
public class Empresa_ { 

    public static volatile ListAttribute<Empresa, Pessoas> p;
    public static volatile SingularAttribute<Empresa, String> telefone;
    public static volatile SingularAttribute<Empresa, String> endereco;
    public static volatile SingularAttribute<Empresa, String> nome;
    public static volatile SingularAttribute<Empresa, String> CNPJ;
    public static volatile SingularAttribute<Empresa, Integer> id;
    public static volatile ListAttribute<Empresa, Departamentos> dep;
    public static volatile SingularAttribute<Empresa, String> email;

}