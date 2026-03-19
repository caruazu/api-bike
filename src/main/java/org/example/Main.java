package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class Main {
    public static void main(String[] args) {
        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();

        session.beginTransaction();

        Usuario u = new Usuario();
        u.setNome("BBBBB");

        session.save(u);

        session.getTransaction().commit();
        session.close();
        factory.close();
    }
}