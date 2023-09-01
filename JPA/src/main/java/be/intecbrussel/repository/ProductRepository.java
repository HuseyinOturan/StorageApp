package be.intecbrussel.repository;

import be.intecbrussel.config.EMFProvider;
import be.intecbrussel.model.Product;
import be.intecbrussel.model.Storage;
import jakarta.persistence.EntityManager;

public class ProductRepository implements IProductRepository{
    @Override
    public void createProduct(Product product) {

        EntityManager em= EMFProvider.getEMF().createEntityManager();

        em.getTransaction().begin();
        em.persist(product);
        em.getTransaction().commit();

        em.close();
    }

    @Override
    public Product readProduct(long id) {
        // is verpilicht commit en begin in de find method ?
        // herhangi bir degisiklik olmadigi icin begin ve commit zorunlu degil. Ancak degisiklik
        // oldugunda database de commit kullanmak gerekiyor. Cunku database de degisiklik var.
        // Burada get transaction a gerek yok. Bevestig gerekli oldugunda commit ve begin gerekli.

        EntityManager em = EMFProvider.getEMF().createEntityManager();
        Product dbProduct= em.find(Product.class,id);
        em.close();
        return dbProduct;
    }

    @Override
    public void updateProduct(Product product) {

        EntityManager em=EMFProvider.getEMF().createEntityManager();
        em.getTransaction().begin();
        Product mergeDbProduct= em.merge(product);
        // Burada kullanmamiz sebebi product klasinda hask code ve qguals methodlari olusturduk.
        // Uptade yapabilmemiz icin oncelikle database de objenin olmasi lazim. Bunun icin
        // service de kod yazip ayrimini yapiyoruz
        // burada product un  ID si yok. Ancak merge methodundan sonra id olusuyor persistence contekste.
        // equals methodu productun butun pro. bakiyor. ROLLBACK E gelirse bu method yazdirmiyor.
        // Niet bevestingen. Niet Ccommit
        if(mergeDbProduct.getId() != product.getId()) {
            em.getTransaction().rollback();
        } else {
            em.getTransaction().commit();
        }

        em.close();
    }

    @Override
    public void deleteProduct(Product product) {

        EntityManager em = EMFProvider.getEMF().createEntityManager();
        em.getTransaction().begin();
        Product dbProduct= em.find(Product.class,product.getId());
        em.remove(dbProduct);
        em.getTransaction().commit();
        em.close();

    }

  @Override
    public void deleteProduct(long id) {

        EntityManager em = EMFProvider.getEMF().createEntityManager();
        em.getTransaction().begin();
        Product dbProduct= em.find(Product.class,id);
        em.remove(dbProduct);
        em.getTransaction().commit();
        em.close();

    }

    @Override
    public void updateProductName(Product product, String newName) {
         EntityManager em=EMFProvider.getEMF().createEntityManager();
         em.getTransaction().begin();

         Product dbProduct= em.merge(product);
         dbProduct.setName(newName);
         em.getTransaction().commit();
         em.close();
    }
}
