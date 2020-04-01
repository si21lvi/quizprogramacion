package modelo;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import modelo.TipoUsuario;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-04-01T12:22:45")
@StaticMetamodel(Usuario.class)
public class Usuario_ { 

    public static volatile SingularAttribute<Usuario, String> clave;
    public static volatile SingularAttribute<Usuario, String> estado;
    public static volatile SingularAttribute<Usuario, String> correo;
    public static volatile SingularAttribute<Usuario, TipoUsuario> tipoUsuario;

}