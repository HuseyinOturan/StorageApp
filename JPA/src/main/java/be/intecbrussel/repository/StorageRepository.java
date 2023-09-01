package be.intecbrussel.repository;

import be.intecbrussel.config.EMFProvider;
import be.intecbrussel.model.Product;
import be.intecbrussel.model.Storage;
import jakarta.persistence.EntityManager;

import java.util.ArrayList;
import java.util.Arrays;

public class StorageRepository implements IStorageRepository {
    @Override
    public void createStorage(Storage storage) {

        // prductler kaydedilmediginden dolayi exec. alabirsin. Kaydetmek icin productleri
        // for loop dongusunu kullanabilirsin.veya cascade kullanabilirsin Store in icinde.

        EntityManager em=EMFProvider.getEMF().createEntityManager();
        em.getTransaction().begin();
        em.persist(storage);
        em.getTransaction().commit();
        em.close();

    }

    @Override
    public Storage readStorage(Long id) {

        EntityManager em=EMFProvider.getEMF().createEntityManager();
        em.getTransaction().begin();
        Storage findStorage= em.find(Storage.class,id);
        em.getTransaction().commit();
        em.close();
        return findStorage;
    }

    @Override
    public void updateStorage(Storage storage) {

        EntityManager em=EMFProvider.getEMF().createEntityManager();
        em.getTransaction().begin();
        em.merge(storage);
        em.getTransaction().commit();
        em.close();

    }

    @Override
    public void deleteStorage(Long id) {
        EntityManager em = EMFProvider.getEMF().createEntityManager();
        em.getTransaction().begin();
        Storage deleteStorage= em.find(Storage.class,id);
        em.remove(deleteStorage);
        em.getTransaction().commit();
        em.close();


    }




}
