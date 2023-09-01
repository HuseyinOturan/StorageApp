package be.intecbrussel.repository;

import be.intecbrussel.model.Storage;

public interface IStorageRepository {

    // create

    void createStorage(Storage storage);

    // read
    Storage readStorage(Long id);

    // update

    void updateStorage(Storage storage);
    // delete

    void deleteStorage(Long id);
}
