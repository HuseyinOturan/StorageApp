package be.intecbrussel.repository;

import be.intecbrussel.model.Product;
import be.intecbrussel.model.Storage;

public interface IProductRepository {

    // create

    void createProduct(Product product);

    // read
    Product readProduct(long id);

    // update

    void updateProduct(Product product);
    // delete

    void deleteProduct(Product product);

    void deleteProduct(long id);

    void updateProductName(Product product, String newName);
}
