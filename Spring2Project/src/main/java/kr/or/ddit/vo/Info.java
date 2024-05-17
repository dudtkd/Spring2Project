package kr.or.ddit.vo;

import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class Info {

		private String userId;
		private String password;
		private String userName;
		private String email;
		private String gender;
		private String developer;
		private boolean foreigner;
		private String korea;
		private String nationality;
		private String cars;
		private String hobby;
		private String introduction;
		private int coin;
		@DateTimeFormat(pattern = "yyyy-MM-dd")
		private Date dateOfBirth;
		private String agree;
		
		private String date;
		
		

		public String getDate() {
			return date;
		}
		public void setDate(String date) {
			this.date = date;
		}
		public String getAgree() {
			return agree;
		}
		public void setAgree(String agree) {
			this.agree = agree;
		}
		private Address address;
		private List<Card> cardList;

		
		public String getKorea() {
			return korea;
		}
		public void setKorea(String korea) {
			this.korea = korea;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public String getGender() {
			return gender;
		}
		public void setGender(String gender) {
			this.gender = gender;
		}
		public String getDeveloper() {
			return developer;
		}
		public void setDeveloper(String developer) {
			this.developer = developer;
		}

		public boolean isForeigner() {
			return foreigner;
		}
		public void setForeigner(boolean foreigner) {
			this.foreigner = foreigner;
		}
		public String getNationality() {
			return nationality;
		}
		public void setNationality(String nationality) {
			this.nationality = nationality;
		}
		public String getCars() {
			return cars;
		}
		public void setCars(String cars) {
			this.cars = cars;
		}
		public String getHobby() {
			return hobby;
		}
		public void setHobby(String hobby) {
			this.hobby = hobby;
		}

		public String getIntroduction() {
			return introduction;
		}
		public void setIntroduction(String introduction) {
			this.introduction = introduction;
		}
		public List<Card> getCardList() {
			return cardList;
		}
		public void setCardList(List<Card> cardList) {
			this.cardList = cardList;
		}
		public Address getAddress() {
			return address;
		}
		public void setAddress(Address address) {
			this.address = address;
		}
		public String getUserId() {
			return userId;
		}
		public void setUserId(String userId) {
			this.userId = userId;
		}
		public String getUserName() {
			return userName;
		}
		public void setUserName(String userName) {
			this.userName = userName;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		public int getCoin() {
			return coin;
		}
		public void setCoin(int coin) {
			this.coin = coin;
		}
		public Date getDateOfBirth() {
			return dateOfBirth;
		}
		public void setDateOfBirth(Date dateOfBirth) {
			this.dateOfBirth = dateOfBirth;
		}
		
		
	

}
