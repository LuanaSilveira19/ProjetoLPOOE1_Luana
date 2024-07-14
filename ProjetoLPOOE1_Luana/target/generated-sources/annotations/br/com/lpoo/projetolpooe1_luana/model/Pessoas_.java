package br.com.lpoo.projetolpooe1_luana.model;

import br.com.lpoo.projetolpooe1_luana.model.Empresa;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2024-07-11T19:45:17", comments="EclipseLink-2.7.12.v20230209-rNA")
@StaticMetamodel(Pessoas.class)
public abstract class Pessoas_ { 

    public static volatile SingularAttribute<Pessoas, String> endereco;
    public static volatile SingularAttribute<Pessoas, Double> salario;
    public static volatile SingularAttribute<Pessoas, String> nome;
    public static volatile SingularAttribute<Pessoas, Integer> id;
    public static volatile SingularAttribute<Pessoas, String> data_nasc;
    public static volatile SingularAttribute<Pessoas, Empresa> empresa;

}