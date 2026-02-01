package com.jrs.repository.interfaces;

import java.sql.SQLException;
import java.util.List;

// Generic Interface
public interface CrudRepository<T> {
    void create(T t) throws SQLException;
    List<T> getAll() throws SQLException;
    void delete(int id) throws SQLException;
}