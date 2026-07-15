package com.rf.rt.dp.adapter;

/**
 * Step1: Target interface
 */
interface PaymentGateway {
	void pay(double amount);
}

/**
 * Step2: Existing RazorPay
 */
class RazorPayGateway implements PaymentGateway {

	@Override
	public void pay(double amount) {
		System.out.println("Paid ₹" + amount + " using Razorpay");
	}
}

/**
 * Step 3: Third-Party Stripe AP
 */
class StripeGateway {

	public void makePayment(double amount) {
		System.out.println("Paid ₹" + amount + " using Stripe");
	}
}

/**
 * Step4: Adapter: as we know we having existing payment method with different
 * payment method and new third party has new payment method, so we introduced
 * adapter.
 */
class StripeAdapter implements PaymentGateway {
	private StripeGateway stripe;

	public StripeAdapter(StripeGateway stripe) {
		this.stripe = stripe;
	}

	@Override
	public void pay(double amount) {
		stripe.makePayment(amount);
	}
}

public class AdapterDesignPatternDriver {

	public static void main(String[] args) {
		// Existing
		PaymentGateway razorPayment = new RazorPayGateway();
		razorPayment.pay(1001);

		// With Adapter
		PaymentGateway gateway = new StripeAdapter(new StripeGateway());
		gateway.pay(1000);
	}
}
