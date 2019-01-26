package com.edgb.cdhcentaure.service;

import java.util.List;


public interface IService<A> {

	List<A> getAll();
    A getById(int id);
    boolean add(A obj);
    void update(A obj);
    boolean delete(int id);

}
