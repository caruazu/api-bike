package org.example;

import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class UsuarioDAO {

    public List<Usuario> selectAll(){
        try (Session session = HibernateUtil.getSessionFactory().openSession()){
            return session.createQuery("from Usuario",Usuario.class).getResultList();
        }
    }

    public void save(Usuario usuario){
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()){
            transaction = session.beginTransaction();
            session.save(usuario);
            transaction.commit();
        } catch (Exception e){
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }
}
