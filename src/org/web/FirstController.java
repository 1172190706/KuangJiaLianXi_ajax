package org.web;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.pojo.Classes;
import org.pojo.Students;
import org.services.ServiceClasses;
import org.services.ServiceStudent;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/first")
@CrossOrigin("*") // 1.服务器端解决跨域问题*代表来者不拒
public class FirstController {
	
	@Resource
	private ServiceStudent ss;
	
	@Resource
	private ServiceClasses sc;
	
	/**
	 * 查询全部学生
	 * @param s
	 * @return
	 */
	// 2.服务器解决跨域method表示可接受的请求类型
	@RequestMapping(value="/list",method=RequestMethod.POST)
	//@RequestMapping("/list")
	@ResponseBody
	public List<Students> list(Students s) {
	//	hsr.setHeader("Access-Control-Allow-Origin", "*");
		System.out.println("controller:list");
		System.out.println("controller:"+s); 
		String sql="select * from students where 1=1 ";
	         		       
		if(s!=null&&s.getSname()!=null&&!"".equals(s.getSname().trim())){
			sql+=" and sname like '%"+s.getSname()+"%' ";
		}
	
		if(s!=null&&s.getClasses()!=null&&s.getClasses().getCid()!=null){
			s.setCid(s.getClasses().getCid());
			sql+=" and cid="+s.getCid();
		}
		
		System.out.println(sql);
		
		 List<Students> selectAll = ss.selectAll(sql);
		 
		return selectAll;
		
	}

	/**
	 *查询全部班级
	 * @param hsr
	 * @return
	 */
	@RequestMapping(value="/listClasses",method=RequestMethod.POST)
	//@RequestMapping("/listClasses")
	@ResponseBody
	public List<Classes> listClasses() {
		//HttpServletResponse hsr	hsr.setHeader("Access-Control-Allow-Origin", "*");
		String sql = "select * from classes";
	   List<Classes> cl = sc.selectAllClasses(sql);
		System.out.println(cl);
		return cl;
	}
	
	/**
	 * 删除
	 * @param sid
	 */
	@RequestMapping(value="/del",method=RequestMethod.POST)
	@ResponseBody
	public void del(Integer sid) {
		System.out.println("del");
		System.out.println(sid);
		ss.del(sid);
	}
	

	/**
	 * 添加
	 */
	@RequestMapping(value="/addStudent",method=RequestMethod.POST)
	@ResponseBody
	public void addStudent(Students s) {
		System.out.println("controller:add"+s);
		Classes classes = new Classes();
		classes.setCid(s.getCid());
		s.setClasses(classes);
		ss.addStudent(s);
	}
	
	
	/**
	 * 修改
	 */
	@RequestMapping(value="/update",method=RequestMethod.POST)
	@ResponseBody
	public Students update(Integer sid) {
		System.out.println("controller:update"+sid);
		Students students = ss.update(sid);
		return students;
	}
	
	
	
}
