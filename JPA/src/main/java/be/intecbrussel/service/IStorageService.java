package be.intecbrussel.service;

import be.intecbrussel.model.Product;
import be.intecbrussel.model.Storage;

public interface IStorageService {


    // create
    void addStorage(Storage storage);
    //read
    Storage getStorage(Long id);
    //update
    void updateStorage(Storage storage);
    // delete
    void deleteStorage(Long id);





}
