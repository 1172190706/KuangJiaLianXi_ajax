package org.services;

import java.util.List;

import javax.annotation.Resource;

import org.dao.ClassesDao;
import org.pojo.Classes;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ServiceClasses {
	
	@Resource
	private ClassesDao cd;

	public List<Classes> selectAllClasses(String sql) {
		
		return cd.selectAllClasses(sql);
	}

}
