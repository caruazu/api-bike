package org.example;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class HibernateUtil {

    private static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory(){
        if (sessionFactory == null) {
            try {
                Properties hibernateProperties = getProperties();
                Configuration configuration = new Configuration().configure("hibernate.cfg.xml");

//                Mapeia as propriedades carregadas do arquivo externo
                configuration.setProperty("hibernate.connection.url", hibernateProperties.getProperty("db.url"));
                configuration.setProperty("hibernate.connection.username", hibernateProperties.getProperty("db.user"));
                configuration.setProperty("hibernate.connection.password", hibernateProperties.getProperty("db.password"));

                mapEntities(configuration);

                sessionFactory = configuration.buildSessionFactory();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return sessionFactory;
    }

    private static void mapEntities(Configuration configuration) {
        configuration.addAnnotatedClass(Usuario.class);
    };

//  carregar o arquivo com os dados
    public static Properties getProperties(){
        Properties hibernateProperties = new Properties();
        String fileName = "hibernate.properties";

        try (InputStream input = HibernateUtil.class.getClassLoader().getResourceAsStream(fileName)) {
            if (input == null) {
                throw new IOException("Arquivo '" + fileName + "' não encontrado na pasta resources.");
            }
            
            hibernateProperties.load(input);
        }catch (IOException e){
            throw new RuntimeException("Falha ao carregar as propriedades do banco.", e);
        }

        return hibernateProperties;
    }
}
