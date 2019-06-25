package tk.ta4anka.employeemanager.service;

import java.util.List;

public interface GenericService<T,ID> {
    void save(T t);
    List<T> findAll();
    void deleteById(ID id) ;
    T getById(ID id);
}
