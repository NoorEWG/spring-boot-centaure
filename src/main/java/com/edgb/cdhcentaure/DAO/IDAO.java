package com.edgb.cdhcentaure.DAO;

import java.util.List;

public interface IDAO<A> {
	    List<A> getAll();
	    A getById(int id);
	    void add(A obj);
	    void update(A obj);
	    void delete(int id);
	    boolean exists(int id);
}
