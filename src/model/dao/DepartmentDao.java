package model.dao;

import java.util.List;

import model.entities.Department;

public interface DepartmentDao {

    void insert(Department obj); //inserindo ao banco de dados o obj
    void update(Department obj);
    void deleteById(Integer id);
    Department findById(Integer id);
    List<Department> findAll();
    
}
