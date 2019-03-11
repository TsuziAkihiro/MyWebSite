package beans;

import java.io.Serializable;

/**
 * 配達
 *
 */
public class DeliveryDataBeans implements Serializable{

	private int id;
	private String prefecture;
	private int fee;


	public DeliveryDataBeans(){

	}
	public DeliveryDataBeans(int id, String prefecture, int fee) {
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
	public int getFee() {
		return fee;
	}
	public void setFee(int fee) {
		this.fee = fee;
	}


}