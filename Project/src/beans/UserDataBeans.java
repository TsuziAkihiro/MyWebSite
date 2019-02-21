package beans;

import java.io.Serializable;

/**
 * ユーザー
 *
 */
public class UserDataBeans implements Serializable{

	private String loginId;
	private String name;
	private String mailAddress;
	private String postalCode;
	private String prefecture;
	private String address;
	private String password;


	private int id;


	public String getLoginId() {
		return loginId;
	}


	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getMailAddress() {
		return mailAddress;
	}


	public void setMailAddress(String mailAddress) {
		this.mailAddress = mailAddress;
	}


	public String getPostalCode() {
		return postalCode;
	}


	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}


	public String getPrefecture() {
		return prefecture;
	}


	public void setPrefecture(String prefecture) {
		this.prefecture = prefecture;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}

}
