package entities;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import entities.enums.OrderStatus;

public class Order {
	private Date moment;
	private OrderStatus status;
	
	private SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	private SimpleDateFormat sdf2 = new SimpleDateFormat("dd/MM/yyyy");
	
	private Client client;
	private List<OrderItem> orderItem = new ArrayList<>();
	
	public Order() {
	}

	public Order(Date moment, OrderStatus status, Client client) {
		this.moment = moment;
		this.status = status;
		this.client = client;
	}

	public Date getMoment() {
		return moment;
	}

	public void setMoment(Date moment) {
		this.moment = moment;
	}

	public OrderStatus getStatus() {
		return status;
	}

	public void setStatus(OrderStatus status) {
		this.status = status;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public List<OrderItem> getOrderLists() {
		return orderItem;
	}

	public void addItem(OrderItem item) {
		orderItem.add(item);
	}
	
	public void removeItem(OrderItem item) {
		orderItem.remove(item);
	}
	
	public double total() {
		double sum = 0.0;
		for(OrderItem item : orderItem) {
			sum += item.subTotal();
		}
		return sum;
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		
		sb.append("ORDER SUMMARY:\n");
		sb.append(String.format("Order moment: %s\n", sdf1.format(getMoment())));
		sb.append(String.format("Order status: %s\n", getStatus()));
		sb.append(String.format("Client: %s ", client.getName()));
		sb.append(String.format("(%s)", sdf2.format(client.getBirthDate())));		
		sb.append(String.format(" - %s\n", client.getEmail()));
		sb.append("Order items:");
		
		for(OrderItem item : orderItem) {
			sb.append(item.getProduct().getName());
			sb.append(String.format(", $%.2f, ", item.getPrice()));
			sb.append("Quantity: " + item.getQuantity());
			sb.append(String.format(", Subtotal: $%.2f\n", item.subTotal()));
		}
		
		sb.append("Total price: " + String.format("$%.2f", total()));
		
		return sb.toString();
	}
}
