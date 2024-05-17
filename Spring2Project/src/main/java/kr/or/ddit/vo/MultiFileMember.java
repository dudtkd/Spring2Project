package kr.or.ddit.vo;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class MultiFileMember {

	private String userId;
	private String password;
	private List<MultipartFile> pictureList;
//	private MultipartFile[] pictureList;
	
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public List<MultipartFile> getPictureList() {
		return pictureList;
	}
	public void setPictureList(List<MultipartFile> pictureList) {
		this.pictureList = pictureList;
	}
	
	
}
