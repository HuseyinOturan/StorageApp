package be.intecbrussel;

import be.intecbrussel.model.Product;
import be.intecbrussel.model.Storage;
import be.intecbrussel.service.ProductService;
import be.intecbrussel.service.StorageService;
import jdk.swing.interop.SwingInterOpUtils;

public class StorageApp {
    public static void main(String[] args) {

        Product p1 = new Product("Apple",1.50,2.75);
        Product p2 = new Product("Potato",0.95,0.50);
        Product p3 = new Product("Banana",3.60,4.50);
        Product p4 = new Product("Train",50,60);


        Storage s1 = new Storage("Fruits and Trains ");
        Storage s2= new Storage("mijn storage");

        s1.add(p1,p2,p3);
        s2.add(p4);

        // STORAGE METHODS


         StorageService storageService=new StorageService();

        // add methode

         storageService.addStorage(s1);

        // read method
         storageService.getStorage(s1.getId());

        // update method

        s1.setName("mijn storage");

        storageService.updateStorage(s1);

         // delete method

         storageService.deleteStorage(s1.getId());


        /*

      //  METHOD VAN PRODUCT

        ProductService productService=new ProductService();

        // Add method

        productService.addProduct(p2);
        productService.addProduct(p3);

        //Update method

         p2.setName("Huseyin");
         productService.updateProduct(p2);

        // read method

        System.out.println("read method");
        System.out.println(productService.getProduct(1));
        productService.deleteProduct(1);

        // delete method

        productService.deleteProduct(p3);

        System.out.println(" delete method , p3 is delete" + p2);

*/




















    }
}