package be.intecbrussel.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class Storage {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;
    private String name;
     // one storage to many product
    @OneToMany(cascade = {CascadeType.MERGE,CascadeType.REMOVE})
    private List<Product> storageContent;

    protected Storage(){

        this.storageContent=new ArrayList<>();
    }

    public Storage(String name) {
        this.name = name;
        this.storageContent = new ArrayList<>();
    }


    public void add(Product... products){
        for (Product product :products) {
            add(product);
        }
    }
    public void add(Product product){
        storageContent.add(product);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Product> getStorageContent() {
        return storageContent;
    }

    public void setStorageContent(List<Product> storageContent) {
        this.storageContent = storageContent;
    }

    public long getId() {
        return id;
    }


    @Override
    public String toString() {
        return "Storage{" +
                "name='" + name + '\'' +
                ", storageContent=" + storageContent +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Storage storage)) return false;
        return getId() == storage.getId() && Objects.equals(getName(), storage.getName()) && Objects.equals(getStorageContent(), storage.getStorageContent());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getStorageContent());
    }
}
