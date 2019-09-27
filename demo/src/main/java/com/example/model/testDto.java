package com.example.model;

import java.util.Date;

public class testDto {
	private int myno;
	private String myname;
	private String mytitle;
	private String mycontent;
	public String getMycontent() {
		return mycontent;
	}
	public void setMycontent(String mycontent) {
		this.mycontent = mycontent;
	}
	private Date mydate;
	public int getMyno() {
		return myno;
	}
	public void setMyno(int myno) {
		this.myno = myno;
	}
	public String getMyname() {
		return myname;
	}
	public void setMyname(String myname) {
		this.myname = myname;
	}
	public String getMytitle() {
		return mytitle;
	}
	public void setMytitle(String mytitle) {
		this.mytitle = mytitle;
	}
	public Date getMydate() {
		return mydate;
	}
	public void setMydate(Date mydate) {
		this.mydate = mydate;
	}
	
}
