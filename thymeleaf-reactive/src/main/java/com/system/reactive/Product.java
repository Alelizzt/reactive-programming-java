package com.system.reactive;

public class Product {

	private int number;
	private String concept;
	private int amount;
	
	public Product() {
		super();
	}

	public Product(int number, String concept, int amount) {
		super();
		this.number = number;
		this.concept = concept;
		this.amount = amount;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getConcept() {
		return concept;
	}

	public void setConcept(String concept) {
		this.concept = concept;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}
	
}
