package beans;

import java.io.Serializable;
import java.util.Date;

/**
 * お気に入り
 *
 */
public class FavoriteDataBeans implements Serializable{

	private int id;
	private int userId;
	private int itemId;
	private Date createDate;

	private String name;
	private int price;
	private String fileName;


	public FavoriteDataBeans() {

	}

	public FavoriteDataBeans(int id, int userId,int itemId, Date createDate) {
		this.id = id;
		this.userId = userId;
		this.itemId = itemId;
		this.createDate = createDate;
	}


	public FavoriteDataBeans(int id, int userId,int itemId, Date createDate, String name, int price, String fileName) {
		this.id = id;
		this.userId = userId;
		this.itemId = itemId;
		this.createDate = createDate;

		this.name = name;
		this.price = price;
		this.fileName = fileName;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getItemId() {
		return itemId;
	}
	public void setItemId(int itemId) {
		this.itemId = itemId;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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