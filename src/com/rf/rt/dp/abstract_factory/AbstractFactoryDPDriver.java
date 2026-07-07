package com.rf.rt.dp.abstract_factory;

/**
 * If you have multiple payment gateways (Razorpay, Amazon Pay, Stripe, PayPal,
 * etc.) and each gateway provides multiple related services (Payment, Refund,
 * Receipt), then the Abstract Factory Pattern is an excellent choice.
 */
/*
PaymentAbstractFactory
│
├── Payment.java
├── Refund.java
├── Receipt.java
│
├── RazorPayPayment.java
├── RazorPayRefund.java
├── RazorPayReceipt.java
│
├── AmazonPayPayment.java
├── AmazonPayRefund.java
├── AmazonPayReceipt.java
│
├── PaymentGatewayFactory.java
├── RazorPayFactory.java
├── AmazonPayFactory.java
│
└── AbstractFactoryDPDriver.java

*/

/************ Step1: Product Interface ************/

interface Payment {
	void pay(double amount);
}

interface Refund {
	void refund(double amount);
}

interface Receipt {
	void generateReceipt();
}

/************ Step2: RazorPay Implementation ************/

class RazorPayPayment implements Payment {

	@Override
	public void pay(double amount) {
		System.out.println("Paid ₹" + amount + " using RazorPay");
	}
}

class RazorPayRefund implements Refund {

	@Override
	public void refund(double amount) {
		System.out.println("Refund ₹" + amount + " using RazorPay");
	}
}

class RazorPayRecipt implements Receipt {

	@Override
	public void generateReceipt() {
		System.out.println("Generating RazorPay Receipt");
	}
}

/************ Step3: AmazonPay Implementation ************/

class AmazonPayPayment implements Payment {

	@Override
	public void pay(double amount) {
		System.out.println("Paid ₹" + amount + " using AmazonPay");
	}
}

class AmazonPayRefund implements Refund {

	@Override
	public void refund(double amount) {
		System.out.println("Refund ₹" + amount + " using AmazonPay");
	}
}

class AmazonPayRecipt implements Receipt {

	@Override
	public void generateReceipt() {
		System.out.println("Generating AmazonPay Receipt");
	}
}

/************ Step4: Abstract Factory ************/

interface PaymentGatewayFactory {
	Payment createPayment();

	Refund createRefund();

	Receipt createReceipt();
}

/************ Step5: RazorPay Factory ************/
class RazorPayFactory implements PaymentGatewayFactory {

	@Override
	public Payment createPayment() {
		return new RazorPayPayment();
	}

	@Override
	public Refund createRefund() {
		return new RazorPayRefund();
	}

	@Override
	public Receipt createReceipt() {
		return new RazorPayRecipt();
	}
}

/************ Step6: AmazonPay Factory ************/
class AmazonPayFactory implements PaymentGatewayFactory {

	@Override
	public Payment createPayment() {
		return new AmazonPayPayment();
	}

	@Override
	public Refund createRefund() {
		return new AmazonPayRefund();
	}

	@Override
	public Receipt createReceipt() {
		return new AmazonPayRecipt();
	}
}

public class AbstractFactoryDPDriver {
	public static void main(String[] args) {
		PaymentGatewayFactory factory = new RazorPayFactory();
		Payment payment = factory.createPayment();
		Refund refund = factory.createRefund();
		Receipt receipt = factory.createReceipt();

		payment.pay(10000);
		refund.refund(10000);
		receipt.generateReceipt();

		PaymentGatewayFactory amazonPayFactory = new AmazonPayFactory();
		Payment amzPayment = amazonPayFactory.createPayment();
		Refund amzRefund = amazonPayFactory.createRefund();
		Receipt amzReceipt = amazonPayFactory.createReceipt();
		
		amzPayment.pay(200);
		amzRefund.refund(200);
		amzReceipt.generateReceipt();
	}
}
