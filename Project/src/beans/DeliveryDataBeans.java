package beans;

import java.io.Serializable;

/**
 * 配達
 *
 */
public class DeliveryDataBeans implements Serializable{

	private int id;
	private String prefecture;
	private String fee;

	public DeliveryDataBeans(int id, String prefecture, String fee) {
		this.id = id;
		this.prefecture = prefecture;
		this.fee = fee;
	}


	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPrefecture() {
		return prefecture;
	}
	public void setPrefecture(String prefecture) {
		this.prefecture = prefecture;
	}
	public String getFee() {
		return fee;
	}
	public void setFee(String fee) {
		this.fee = fee;
	}


}