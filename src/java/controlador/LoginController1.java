/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import dao.UsuariooDAO;
import java.io.IOException;
import java.io.Serializable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import modelo.Usuario;

/**
 *
 * @author Silvia
 */
@Named(value = "loginController1")
@SessionScoped

public class LoginController1 implements Serializable {
    
    private final static Logger LOGGER= Logger.getLogger("controller.LoginController1 ");
    
    private Usuario usuario;
    private Usuario usuarioAutenticado=null;
    List<Usuario> listado;
    
    
    @EJB 
    private UsuariooDAO ejbDao;
    public LoginController1() {
        usuario=new Usuario();
    }
    public void login() throws IOException{
            

        
        FacesContext ctx= FacesContext.getCurrentInstance();
        
        usuarioAutenticado = ejbDao.encontrarUsuarioPorLogin(usuario.getCorreo(), usuario.getClave());

 

        if (usuarioAutenticado != null) {
            LOGGER.log(Level.INFO, "BIENVENIDO");
            ctx.getExternalContext().redirect("home.xhtml");
        } else {
            LOGGER.log(Level.SEVERE, "NO ENCONTRADO");
            ctx.getExternalContext().redirect("index.xhtml");
        }

 

        usuario = new Usuario();
    }
         
    
    public List<Usuario> getListado(){
        listado= ejbDao.listar();
        
        return listado;
    }
    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
}
