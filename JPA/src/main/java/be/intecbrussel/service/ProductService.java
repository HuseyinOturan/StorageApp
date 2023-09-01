package be.intecbrussel.service;

import be.intecbrussel.model.Product;
import be.intecbrussel.repository.IProductRepository;
import be.intecbrussel.repository.ProductRepository;

public class ProductService implements IProductService{

    private IProductRepository repo =new ProductRepository();
    @Override
    public void addProduct(Product product) {

        if(product.getId()==0)
    repo.createProduct(product);

    }

    @Override
    public Product getProduct(long id) {
        if (id >= 1) {
            return repo.readProduct(id);
        }
        return null;
    }


    @Override
    public void updateProduct(Product product) {

        if (product.getId() != 0) {
            repo.updateProduct(product);
        }
    }

    @Override
    public void deleteProduct(long id) {

        if(id>=1)
        repo.deleteProduct(this.getProduct(id));


    }

    @Override
    public void deleteProduct(Product product) {

        if(product.getId() !=0) {
            repo.deleteProduct(product);
        }
    }

    @Override
    public void uptadeProductName(Product product, String newName) {
        repo.updateProductName(product,newName);
    }
}
