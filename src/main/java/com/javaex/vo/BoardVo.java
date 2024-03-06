package com.javaex.vo;

public class BoardVo {

	private int bno;
	private String title;
	private String writer;
	private String content;
	private int hit;
	private String reg_date;

	public BoardVo() {
		super();
	}
	
	public BoardVo(String title, String writer, String content) {
		super();
		this.title = title;
		this.writer = writer;
		this.content = content;
	}

	public BoardVo(int bno, String title, String writer, String content, int hit, String reg_date) {
		super();
		this.bno = bno;
		this.title = title;
		this.writer = writer;
		this.content = content;
		this.hit = hit;
		this.reg_date = reg_date;
	}

	public int getBno() {
		return bno;
	}

	public void setBno(int bno) {
		this.bno = bno;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getHit() {
		return hit;
	}

	public void setHit(int hit) {
		this.hit = hit;
	}

	public String getReg_date() {
		return reg_date;
	}

	public void setReg_date(String reg_date) {
		this.reg_date = reg_date;
	}

	@Override
	public String toString() {
		return "BoardVo [bno=" + bno + ", title=" + title + ", writer=" + writer + ", content=" + content + ", hit="
				+ hit + ", reg_date=" + reg_date + "]";
	}

}
