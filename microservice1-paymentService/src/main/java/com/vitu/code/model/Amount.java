package com.vitu.code.model;

import org.springframework.stereotype.Component;

@Component
public class Amount {

	private int payId;
	private String cName;
	private Double pAmount;
	public Amount(int payId, String cName, Double pAmount) {
		super();
		this.payId = payId;
		this.cName = cName;
		this.pAmount = pAmount;
	}
	public int getPayId() {
		return payId;
	}
	public void setPayId(int payId) {
		this.payId = payId;
	}
	public String getcName() {
		return cName;
	}
	public void setcName(String cName) {
		this.cName = cName;
	}
	public Double getpAmount() {
		return pAmount;
	}
	public void setpAmount(Double pAmount) {
		this.pAmount = pAmount;
	}
	public Amount() {
		super();
	}
	
	
}
