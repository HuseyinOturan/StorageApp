package be.intecbrussel.config;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

//EMF= Entity Manager Factory
// singelton
public class EMFProvider {

    private static EntityManagerFactory entityManagerFactory;

    private EMFProvider(){}

    public static EntityManagerFactory getEMF() {

        if (entityManagerFactory == null) {

            entityManagerFactory = Persistence.createEntityManagerFactory("mysql");
        }

        return entityManagerFactory;


    }
}



