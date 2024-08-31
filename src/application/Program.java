package application;

import java.util.Date;
import java.util.List;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {
    public static void main(String[] args) {
        SellerDao sellerDao = DaoFactory.createSellerDao();

        System.out.println("=== TESTE 1: seller by id ===");
        Seller seller = sellerDao.findById(3);
        System.out.println(seller);

        System.out.println("=== TESTE 2: seller findByDepartmente ===");
        Department department = new Department(2, null);
        List<Seller> list = sellerDao.findByDepartment(department);
        for(Seller obj : list){
            System.out.println(obj);
        }

        System.out.println("=== TESTE 3: findAll ===");
        list = sellerDao.findAll();
        for(Seller obj : list){
            System.out.println(obj);
        }

        System.out.println("=== TEST 4: seller insert ===");
        Seller newSeller = new Seller(9, "Chris", "chris@gmai.com", new Date(), 4000.00, department);
        sellerDao.insert(newSeller);
        System.out.println("Insert! New id: "+newSeller.getId());
        
        System.out.println("=== TEST 5: seller insert ===");
        seller = sellerDao.findById(1);
        seller.setName("Yuri");
        sellerDao.update(seller);
        System.out.println("Update Complet!");
    }
}
