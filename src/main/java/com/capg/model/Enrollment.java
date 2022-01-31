package com.capg.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "testenroll")
public class Enrollment {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "tid")
	private int tid;

	@Column(name = "CourseType", length = 20)
	private String courseType;

	@Column(name = "test_id", length = 20)
	private long test_id;

	@Column(name = "user_id", length = 20)
	private int user_id;

	@Column(name = "enroll_test", length = 20)
	private int enroll_test;

	@Column(name = "Status", length = 20)
	private String statusCheck;

	public int getTid() {
		return tid;
	}

	public void setTid(int id) {
		this.tid = id;
	}

	public String getCourseType() {
		return courseType;
	}

	public void setCourseType(String courseType) {
		this.courseType = courseType;
	}

	public String getStatusCheck() {
		return statusCheck;
	}

	public void setStatusCheck(String statusCheck) {
		this.statusCheck = statusCheck;
	}

	public int getEnroll_test() {
		return enroll_test;
	}

	public void setEnroll_test(int enroll_test) {
		this.enroll_test = enroll_test;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public int getUser_id() {
		return user_id;
	}

	public long getTest_id() {
		return test_id;
	}

	public void setTest_id(long test_id) {
		this.test_id = test_id;
	}

	@Override
	public String toString() {
		return "Enrollment [id=" + tid + ", test_id= " + test_id + ", courseType=" + courseType + ", statusCheck="
				+ statusCheck + ",user_id=" + user_id + ", enroll_test=" + enroll_test + "]";
	}

}
