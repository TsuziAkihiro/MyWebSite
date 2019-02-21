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
	private String itemId;
	private Date createDate;


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
	public String getItemId() {
		return itemId;
	}
	public void setItemId(String itemId) {
		this.itemId = itemId;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}


}