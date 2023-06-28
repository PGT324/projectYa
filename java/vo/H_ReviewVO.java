package vo;

import java.sql.Clob;
import java.sql.Date;

public class H_ReviewVO {
	
	private int h_review_idx;
	private int h_region1_idx;
	private int h_region2_idx;
	private int hotel_idx;
	private int h_room_idx;
	private int users_idx;
	private String name;
	private String grade;
	private String resdate;
	private String nickname;
	private int kind;
	private int clean;
	private int convinience;
	private int location;
	private Date regdate;
	private String content;
	private String title;
	
	public H_ReviewVO() {;}

	public int getH_review_idx() {
		return h_review_idx;
	}

	public void setH_review_idx(int h_review_idx) {
		this.h_review_idx = h_review_idx;
	}

	public int getH_region1_idx() {
		return h_region1_idx;
	}

	public void setH_region1_idx(int h_region1_idx) {
		this.h_region1_idx = h_region1_idx;
	}

	public int getH_region2_idx() {
		return h_region2_idx;
	}

	public void setH_region2_idx(int h_region2_idx) {
		this.h_region2_idx = h_region2_idx;
	}

	public int getHotel_idx() {
		return hotel_idx;
	}

	public void setHotel_idx(int hotel_idx) {
		this.hotel_idx = hotel_idx;
	}

	public int getH_room_idx() {
		return h_room_idx;
	}

	public void setH_room_idx(int h_room_idx) {
		this.h_room_idx = h_room_idx;
	}

	public int getUsers_idx() {
		return users_idx;
	}

	public void setUsers_idx(int users_idx) {
		this.users_idx = users_idx;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public String getResdate() {
		return resdate;
	}

	public void setResdate(String resdate) {
		this.resdate = resdate;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public int getKind() {
		return kind;
	}

	public void setKind(int kind) {
		this.kind = kind;
	}

	public int getClean() {
		return clean;
	}

	public void setClean(int clean) {
		this.clean = clean;
	}

	public int getConvinience() {
		return convinience;
	}

	public void setConvinience(int convinience) {
		this.convinience = convinience;
	}

	public int getLocation() {
		return location;
	}

	public void setLocation(int location) {
		this.location = location;
	}

	public Date getRegdate() {
		return regdate;
	}

	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	
	
	

}
