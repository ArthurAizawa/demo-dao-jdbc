package model.dao;

import model.dao.impl.SellerDaoJDBC;

public class DaoFactory {
    //expondo o metodo da interface mas instanciando a suplementação
    public static SellerDao createSellerDao(){
        return new SellerDaoJDBC();
    }
}
