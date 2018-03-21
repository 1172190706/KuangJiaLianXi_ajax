package org.services;

import java.util.List;

import javax.annotation.Resource;

import org.dao.StudentDao;
import org.pojo.Students;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Transactional
@Service
public class ServiceStudent {
	
	@Resource
	private StudentDao sd;
	

	public List<Students> selectAll(String sql) {
		return sd.selectAll(sql);
	}


	public void del(Integer sid) {
		sd.del(sid);
		
	}


	public void addStudent(Students s) {
		sd.addStudent(s);
		
	}


	public Students update(Integer sid) {
          Students students = sd.update(sid);
		return students;		
	}
	
	

}
