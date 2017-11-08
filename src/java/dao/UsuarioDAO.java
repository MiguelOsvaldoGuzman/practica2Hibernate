/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import hbm.HibernateUtil;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import pojo.Usuario;
import pojo.TipoPersona;

/**
 *
 * @author RigoBono
 */
public class UsuarioDAO {
    Session session;
    
    public UsuarioDAO(){
        session=HibernateUtil.getLocalSession();
    }
    
    public  Usuario getUsuarioById(int id){
        return (Usuario)session.load(Usuario.class, id);
    }
    
    public List<Usuario>  getUsuarioByName(String nombre){
        List<Usuario> listaDeUsuarios=(List<Usuario>)
                session.createCriteria(Usuario.class)
                .add(Restrictions.eq("Nombre", nombre));
        return listaDeUsuarios;
    }
    
    public boolean updateById(int id,Usuario persona){
        Usuario personaAModificar=getUsuarioById(id);
        try{
            Transaction transaccion=session.beginTransaction();
            personaAModificar.setNombre(persona.getNombre());
            session.update(personaAModificar);
            transaccion.commit();
            return true;
        }catch(Exception e){
            return false;
        }
    }
    
    public boolean saveUsuario(String nombre,String paterno,String materno,String telefono,int idTipoPersona){
        Usuario personaUsuario=new Usuario();
        TipoPersona tipoDeTanque=(TipoPersona)session.load(TipoPersona.class, idTipoPersona);
        personaUsuario.setNombre(nombre);
        personaUsuario.setMaterno(materno);
        personaUsuario.setPaterno(paterno);
        personaUsuario.setTelefono(telefono);
        personaUsuario.setTipoPersona(tipoDeTanque);
        try{
            Transaction transaccion=session.beginTransaction();
            session.save(personaUsuario);
            transaccion.commit();
            return true;
        }catch(Exception e){
            
        }finally{
            
        }
        return true;
    }
    
}
