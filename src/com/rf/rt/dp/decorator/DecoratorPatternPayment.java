package com.rf.rt.dp.decorator;

// component
interface Payment {
	void pay(double amount);
}

// concrete class
class CardPayment implements Payment {

	@Override
	public void pay(double amount) {
		System.out.println("Amount Paid by the card: " + amount);
	}
}

class UPIPayment implements Payment {

	@Override
	public void pay(double amount) {
		System.out.println("Amount Paid by the UPI: " + amount);
	}
}

abstract class PaymentDecorator implements Payment {
	protected Payment payment;

	protected PaymentDecorator(Payment payment) {
		this.payment = payment;
	}
}

class EncryptionDecorator extends PaymentDecorator {

	public EncryptionDecorator(Payment payment) {
		super(payment);
	}

	@Override
	public void pay(double amount) {
		System.out.println("Applying Encryption using EncryptionDecorator");
		payment.pay(amount);
	}
}

class FraudDetectionDecorator extends PaymentDecorator {

	public FraudDetectionDecorator(Payment payment) {
		super(payment);
	}

	@Override
	public void pay(double amount) {
		System.out.println("Applying Fraud Detection using FraudDetectionDecorator");
		payment.pay(amount);
	}
}

class LoggingDecorator extends PaymentDecorator {

	protected LoggingDecorator(Payment payment) {
		super(payment);
	}

	@Override
	public void pay(double amount) {
		System.out.println("Logging applied during payment");
		payment.pay(amount);
	}

}

public class DecoratorPatternPayment {
	public static void main(String[] args) {
		PaymentDecorator paymentDecorator = new FraudDetectionDecorator(
				new EncryptionDecorator(new LoggingDecorator(new UPIPayment())));
		paymentDecorator.pay(1000);
	}
}
