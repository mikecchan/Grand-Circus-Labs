package com.gc.dto;

import java.io.Serializable;

public class ProductDto implements Serializable {
	/**
	 * The serialization runtime associates with each serializable class a version
	 * number, called a serialVersionUID, which is used during deserialization to
	 * verify that the sender and receiver of a serialized object have loaded
	 * classes for that object that are compatible with respect to serialization.
	 */
	private static final long serialVersionUID = 1L;
	private int productID;
	private String type;
	private String flavor;
	private double listprice;

	public ProductDto() {

		// productID = 0;
		// code = "";
		// description = "";
		// listPrice = 0;
	}

	public int getProductID() {
		return productID;
	}



	public void setProductID(int productID) {
		this.productID = productID;
	}



	public String getType() {
		return type;
	}



	public void setType(String type) {
		this.type = type;
	}



	public String getFlavor() {
		return flavor;
	}



	public void setFlavor(String flavor) {
		this.flavor = flavor;
	}



	public double getListprice() {
		return listprice;
	}



	public void setListprice(double listprice) {
		this.listprice = listprice;
	}



	public static long getSerialversionuid() {
		return serialVersionUID;
	}



	@Override
	public String toString() {
		return "Primary key assigned as 0, represents us assigning null to the query: " + productID + ", type=" + type
				+ ", flavor=" + flavor + ", listprice=" + listprice;
	}

}
