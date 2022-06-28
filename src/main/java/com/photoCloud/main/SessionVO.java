package com.example.demo.controller;

public class SessionVO {

	private String ID;
	private String dir;
	
	public SessionVO (String ID, String dir) {
		this.ID = ID;
		this.dir = dir;
	}
	
	public void setAll (String ID, String dir) {
		this.ID = ID;
		this.dir = dir;
	}

	public String getID() {
		return ID;
	}

	public void setID(String ID) {
		ID = ID;
	}

	public String getdir() {
		return dir;
	}

	public void setdir(String dir) {
		this.dir = dir;
	}
}