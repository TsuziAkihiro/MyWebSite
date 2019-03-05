package beans;

import java.io.Serializable;

/**
 * アイテム
 *
 */
public class ItemDataBeans implements Serializable{

	private int id;
	private String name;
	private String detail;
	private int price;
	private String fileName;

	// コンストラクタ
	public ItemDataBeans() {

	}

	public ItemDataBeans(int id, String name, String detail,int price, String fileName) {
		this.id = id;
		this.name = name;
		this.detail = detail;
		this.price = price;
		this.fileName = fileName;

	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}



}