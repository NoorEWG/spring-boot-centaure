package com.edgb.cdhcentaure.model;

import java.util.ArrayList;
import java.util.List;

public class GraphData {

	private String name;
	private List<Long> data;
	
	public GraphData() {
		this.name =  "";
		this.data = new ArrayList<Long>();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Long> getData() {
		return data;
	}

	public void setData(List<Long> data) {
		this.data = data;
	}
	
	
	
}
