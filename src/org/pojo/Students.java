package org.pojo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

@Entity
public class Students {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer sid;
	private String sname;
	@ManyToOne
	@JoinColumn(name="cid")
	private Classes classes;
	
	@Transient  /*��ʾ�����Բ�����ӳ��*/
	private Integer cid;

	@Override
	public String toString() {
		return "Students [sid=" + sid + ", sname=" + sname + ", classes=" + classes + ", cid=" + cid + "]";
	}

	public Integer getSid() {
		return sid;
	}

	public void setSid(Integer sid) {
		this.sid = sid;
	}

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public Classes getClasses() {
		return classes;
	}

	public void setClasses(Classes classes) {
		this.classes = classes;
	}

	public Integer getCid() {
		return cid;
	}

	public void setCid(Integer cid) {
		this.cid = cid;
	}
	
/*
	@Transient���߿�ܴ����Բ�ӳ�䣬һ�㲻��ô��
	private Integer cid;
	*/
	
	
	
}
