package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicUpdate;

@Entity
@Table(name = "post_table")
public class PostModel {

	@Id
	@GeneratedValue
	private long id;
	private String posttitle;
	@Lob
	private String postcontent;
	private String postcategory;
	private String postlanguage;
	@Lob
	private String postdescription;
	private String email;
	@Lob
	private String postimageurl;

	private int postlike;

	public PostModel() {

	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getPosttitle() {
		return posttitle;
	}

	public void setPosttitle(String posttitle) {
		this.posttitle = posttitle;
	}

	public String getPostcontent() {
		return postcontent;
	}

	public void setPostcontent(String postcontent) {
		this.postcontent = postcontent;
	}

	public String getPostcategory() {
		return postcategory;
	}

	public void setPostcategory(String postcategory) {
		this.postcategory = postcategory;
	}

	public String getPostlanguage() {
		return postlanguage;
	}

	public void setPostlanguage(String postlanguage) {
		this.postlanguage = postlanguage;
	}

	public String getPostdescription() {
		return postdescription;
	}

	public void setPostdescription(String postdescription) {
		this.postdescription = postdescription;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPostimageurl() {
		return postimageurl;
	}

	public void setPostimageurl(String postimageurl) {
		this.postimageurl = postimageurl;
	}

	public int getpostLike() {
		return postlike;
	}

	public void setpostLike(int postlike) {
		this.postlike = postlike;
	}

	public PostModel(long id, String posttitle, String postcontent, String postcategory, String postlanguage,
			String postdescription, String email, String postimageurl, int postlike) {
		super();
		this.id = id;
		this.posttitle = posttitle;
		this.postcontent = postcontent;
		this.postcategory = postcategory;
		this.postlanguage = postlanguage;
		this.postdescription = postdescription;
		this.email = email;
		this.postimageurl = postimageurl;
		this.postlike = postlike;
	}

}
