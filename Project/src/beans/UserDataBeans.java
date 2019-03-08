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
	private String fileName;


	private int id;

	// コンストラクタ
	public UserDataBeans() {
		this.loginId = "";
		this.name = "";
		this.mailAddress = "";
		this.postalCode = "";
		this.prefecture = "";
		this.address = "";
		this.password = "";
	}

	public UserDataBeans(String loginId, String name) {
		this.loginId = loginId;
		this.name = name;
	}

	public UserDataBeans(int id, String loginId, String name, String fileName) {
		this.loginId = loginId;
		this.name = name;
		this.id = id;
		this.fileName = fileName;
	}

	public UserDataBeans(int id, String loginId, String name, String mailAddress, String postalCode, String prefecture, String address) {
		this.id = id;
		this.loginId = loginId;
		this.name = name;
		this.mailAddress = mailAddress;
		this.postalCode = postalCode;
		this.prefecture = prefecture;
		this.address = address;
	}



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


	public String getFileName() {
		return fileName;
	}


	public void setFileName(String fileName) {
		this.fileName = fileName;
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
