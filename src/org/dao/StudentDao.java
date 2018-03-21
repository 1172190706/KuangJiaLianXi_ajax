package org.dao;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.pojo.Students;
import org.springframework.stereotype.Repository;

@Repository
public class StudentDao {
	
	@Resource
	private SessionFactory sf;

	public List<Students> selectAll(String sql) {
		Session session = sf.getCurrentSession();
		SQLQuery sqlQuery = session.createSQLQuery(sql);
		sqlQuery.addEntity(Students.class);
		List students = sqlQuery.list();
		System.out.println("studentdao,dao:"+students);
		return students;
	}

	public void del(Integer sid) {
		System.out.println("dao:"+sid);
		Session session = sf.getCurrentSession();
		Students students = session.get(Students.class, sid);
		session.delete(students);
	}

	public void addStudent(Students s) {
		System.out.println("dao:addStudent");
		System.out.println(s);
		Session session = sf.getCurrentSession();
		session.saveOrUpdate(s);//有主键就执行更新，如果没有主键就执行插入
		
	}

	public Students update(Integer sid) {
		System.out.println("dao:update");
		Session session = sf.getCurrentSession();
		Students students = session.get(Students.class, sid);
		return students;
	}


	
	

}
