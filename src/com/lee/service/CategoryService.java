package com.lee.service;

import java.util.List;

import com.lee.pojo.Category;
import com.lee.util.Page;

public interface CategoryService {

	List<Category> list();
	int total();
	List<Category> list(Page page);
	void add(Category c);
	void update(Category c);
	void delete(Category c);
	Category get(int id);
	
}
