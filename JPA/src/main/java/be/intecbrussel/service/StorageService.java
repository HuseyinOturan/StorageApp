package be.intecbrussel.service;

import be.intecbrussel.model.Product;
import be.intecbrussel.model.Storage;
import be.intecbrussel.repository.IStorageRepository;
import be.intecbrussel.repository.StorageRepository;

import java.util.ArrayList;
import java.util.List;

public class StorageService implements IStorageService {

    private IStorageRepository storageRepository = new StorageRepository();
    private IProductService productService = new ProductService();


    @Override
    public void addStorage(Storage storage) {

        // oncelikle productlerin yazdirilmasi gerekir yoksa exp. aliyoruz.

        // niet in de database if
        for (Product product : storage.getStorageContent()) {
            if (product.getId() == 0) {
                productService.addProduct(product);
            } else {
                productService.updateProduct(product);
            }
        }
        storageRepository.createStorage(storage);


    }

    @Override
    public Storage getStorage(Long id) {

        if (id >= 1) {
            return storageRepository.readStorage(id);
        }
        return null;
    }

    @Override
    public void updateStorage(Storage storage) {

        for (Product product : storage.getStorageContent()) {
            if (product.getId() == 0) {

                productService.addProduct(product);
            } else {
                productService.updateProduct(product);
            }
        }

        storageRepository.updateStorage(storage);
    }

    @Override
    public void deleteStorage(Long id) {

        if (id >= 1) {

            Storage storage = storageRepository.readStorage(id);

            List<Product> dProduct = new ArrayList<>(storage.getStorageContent());



            for (Product product : storageRepository.readStorage(id).getStorageContent()) {
                if (product.getId() >= 0) {
                    productService.deleteProduct(product);
                }

            }
            storageRepository.deleteStorage(id);
        }
    }
}
