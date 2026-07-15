package com.rf.rt.dp.facade;

//Subsystem 1: Inventory Management
class InventorySystem {

	public boolean checkStock(String itemId) {
		System.out.println("Inventory: Checking stock for item: " + itemId);
		return true;
	}

	public void deductStock(String itemId) {
		System.out.println("Inventory: item " + itemId + " removed from stock.");
	}
}

//Subsystem 2: Payment Gateway
class PaymentGateway {
	public boolean processPayment(double amount) {
		System.out.println("Payment: Processing charge of $" + amount);
		return true;
	}
}

//Subsystem 3: Shipping Service
class ShippingService {
	public void scheduleDelivery(String itemId) {
		System.out.println("Shipping: Dispatching item " + itemId + " to courier");
	}
}

//Subsystem 4: Notification Service
class NotificationService {
	public void sendConfirmation() {
		System.out.println("Notification: Sending confirmation email to buyers.	");
	}
}

class OrderFacade {
	private final InventorySystem inventory;
	private final PaymentGateway payment;
	private final ShippingService shipping;
	private final NotificationService notification;

	// Subsystems are initialized internally or injected
	public OrderFacade() {
		this.inventory = new InventorySystem();
		this.payment = new PaymentGateway();
		this.shipping = new ShippingService();
		this.notification = new NotificationService();
	}

	// Single point of entry for the client
	public boolean checkout(String itemId, double price) {
		System.out.println("=== Facade: Processing Checkout ===");

		if (!inventory.checkStock(itemId)) {
			System.out.println("Checkout Failed: Item unavailable.");
			return false;
		}

		if (!payment.processPayment(price)) {
			System.out.println("Checkout Failed: Payment rejected.");
			return false;
		}

		inventory.deductStock(itemId);
		shipping.scheduleDelivery(itemId);
		notification.sendConfirmation();

		System.out.println("=== Facade:  Checkout complete ===");
		return true;
	}
}

public class ECommerceOrderDriver {
	public static void main(String[] args) {
		OrderFacade facade = new OrderFacade();
		boolean success = facade.checkout("JAVA-INTERVIEW", 999);
		System.out.println("Was order sucessful? " + success);
	}
}