package vo;

import java.sql.Clob;
import java.sql.Date;

public class M_ReviewVO {

	private int m_review_idx;
	private int m_region1_idx;
	private int m_region2_idx;
	private int motel_idx;
	private int m_room_idx;
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
	
	public M_ReviewVO() {;}

	public int getM_review_idx() {
		return m_review_idx;
	}

	public void setM_review_idx(int m_review_idx) {
		this.m_review_idx = m_review_idx;
	}

	public int getM_region1_idx() {
		return m_region1_idx;
	}

	public void setM_region1_idx(int m_region1_idx) {
		this.m_region1_idx = m_region1_idx;
	}

	public int getM_region2_idx() {
		return m_region2_idx;
	}

	public void setM_region2_idx(int m_region2_idx) {
		this.m_region2_idx = m_region2_idx;
	}

	public int getMotel_idx() {
		return motel_idx;
	}

	public void setMotel_idx(int motel_idx) {
		this.motel_idx = motel_idx;
	}

	public int getM_room_idx() {
		return m_room_idx;
	}

	public void setM_room_idx(int m_room_idx) {
		this.m_room_idx = m_room_idx;
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
