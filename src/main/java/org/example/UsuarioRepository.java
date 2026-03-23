package org.example;

import org.hibernate.Session;

import java.util.List;

public class UsuarioRepository {

    public List<Usuario> selectAll(){
        try (Session session = HibernateUtil.getSessionFactory().openSession()){
            return session.createQuery("from Usuario",Usuario.class).getResultList();
        }
    }
}
