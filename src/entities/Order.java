package entities;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import entities.enums.OrderStatus;

public class Order {
	
	private static final SimpleDateFormat SDF = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	
	private Date moment;
	private OrderStatus os;
	
	private List<OrderItem> itens = new ArrayList<>();
	private Client client = new Client();
	
	public Order() {
	}

	public Order(Date moment, OrderStatus os, Client client) {
		this.moment = moment;
		this.os = os;
		this.client = client;
	}

	public Date getMoment() {
		return moment;
	}

	public void setMoment(Date moment) {
		this.moment = moment;
	}

	public OrderStatus getOs() {
		return os;
	}

	public void setOs(OrderStatus os) {
		this.os = os;
	}

	public List<OrderItem> getItens() {
		return itens;
	}
	
	public void addItem(OrderItem item) {
		itens.add(item);
	}
	
	public void removeItem(OrderItem item) {
		itens.remove(item);
	}
	
	public Double total() {
		return 0.0;
	}

	public Client getClient() {
		return client;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("ORDER SUMMARY:")
		.append("\nOrder moment: " + SDF.format(moment))
		.append("\nOrder status: " + os)
		.append("\n" + client)
		.append("");
		return null;
	}		

}
