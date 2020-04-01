/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Silvia
 */
@Entity
@Table(name="TIPO_USUARIO")
public class Usuario implements Serializable {

    @OneToMany(mappedBy = "usuario") 
 

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional=false)
    @NotNull
    @Size(min=8, max= 50)
     private String correo;
    
    @Basic(optional=false)
    @Size(min=8, max= 50)
    @NotNull
    private String clave;

   
    @Basic(optional=false)
    @NotNull
    @Size(min=1, max= 1)
    private String estado; 
    @JoinColumn(name="TIPO_USUARIO_ID", referencedColumnName="ID")
    @ManyToOne(optional=false)
    private TipoUsuario tipoUsuario;
    
    

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (correo != null ? correo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usuario)) {
            return false;
        }
        Usuario other = (Usuario) object;
        if ((this.correo == null && other.correo != null) || (this.correo != null && !this.correo.equals(other.correo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Usuario[ id=" + correo + " ]";
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    

    

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
     public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public TipoUsuario getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(TipoUsuario tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }
    
}
