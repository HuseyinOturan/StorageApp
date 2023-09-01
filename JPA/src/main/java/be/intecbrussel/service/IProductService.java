package be.intecbrussel.service;

import be.intecbrussel.model.Product;
import be.intecbrussel.model.Storage;

public interface IProductService {

    // create
    void addProduct(Product product);
    //read
    Product getProduct(long id);
    //update
    void updateProduct(Product product);
    // delete

    void deleteProduct(long id);

    void deleteProduct(Product product);

    void uptadeProductName(Product product, String newName);



}
