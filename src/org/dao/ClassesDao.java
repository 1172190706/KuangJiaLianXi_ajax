package org.dao;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.pojo.Classes;
import org.springframework.stereotype.Repository;

@Repository
public class ClassesDao {
	
	@Resource
	private SessionFactory sf;

	public Session set() {
		return sf.getCurrentSession();
	}
	
	public List<Classes> selectAllClasses(String sql) {
		return set().createSQLQuery(sql).addEntity(Classes.class).list();
	}

	
	
}
