package com.mulcam.sample.entity;

public class Challenge {
	private int cid;
	private String cname;
	private int camount;
	
	public Challenge() {}
	public Challenge(int cid, String cname, int camount) {
		super();
		this.cid = cid;
		this.cname = cname;
		this.camount = camount;
	}
	@Override
	public String toString() {
		return "Challenge [cid=" + cid + ", cname=" + cname + ", camount=" + camount + "]";
	}
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public int getCamount() {
		return camount;
	}
	public void setCamount(int camount) {
		this.camount = camount;
	}

}