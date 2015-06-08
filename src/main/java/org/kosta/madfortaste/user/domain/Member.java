package org.kosta.madfortaste.user.domain;

import java.util.Date;

public class Member implements User{
	
	private String id;
	private String password;
	private String name;
	private String address;
	private String gender;
	private String birth;
	private String tel;
	private int exp;
	private LevelInfo levelInfo;
	private int point;
	private Date joinDate;
	private String profileImg = "default";

	public Member() {
		super();
	}

	public Member(String id, String password, String name, String address,
			String gender, String birth, String tel) {
		super();
		this.id = id;
		this.password = password;
		this.name = name;
		this.address = address;
		this.gender = gender;
		this.birth = birth;
		this.tel = tel;
	}
	
	public Member(String id, String password, String name, String address,
			String gender, String birth, String tel, String profileImg) {
		super();
		this.id = id;
		this.password = password;
		this.name = name;
		this.address = address;
		this.gender = gender;
		this.birth = birth;
		this.tel = tel;
		this.profileImg = profileImg;
	}

	public Member(String id, String password, String name, String address,
			String gender, String birth, String tel, int exp, LevelInfo levelInfo,
			int point, Date joinDate, String profileImg) {
		super();
		this.id = id;
		this.password = password;
		this.name = name;
		this.address = address;
		this.gender = gender;
		this.birth = birth;
		this.tel = tel;
		this.exp = exp;
		this.levelInfo = levelInfo;
		this.point = point;
		this.joinDate = joinDate;
		this.profileImg = profileImg;
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getBirth() {
		return birth;
	}

	public void setBirth(String birth) {
		this.birth = birth;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public int getExp() {
		return exp;
	}

	public void setExp(int exp) {
		this.exp = exp;
	}

	public int getPoint() {
		return point;
	}

	public void setPoint(int point) {
		this.point = point;
	}

	public Date getJoinDate() {
		return joinDate;
	}

	public void setJoinDate(Date joinDate) {
		this.joinDate = joinDate;
	}

	public String getProfileImg() {
		return profileImg;
	}

	public void setProfileImg(String profileImg) {
		this.profileImg = profileImg;
	}

	public LevelInfo getLevelInfo() {
		return levelInfo;
	}

	public void setLevelInfo(LevelInfo levelInfo) {
		this.levelInfo = levelInfo;
	}

	@Override
	public String toString() {
		return "Member [id=" + id + ", password=" + password + ", name=" + name
				+ ", address=" + address + ", gender=" + gender + ", birth="
				+ birth + ", tel=" + tel + ", exp=" + exp + ", levelInfo="
				+ levelInfo + ", point=" + point + ", joinDate=" + joinDate
				+ ", profileImg=" + profileImg + "]";
	}
	

}