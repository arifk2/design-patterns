package com.rf.rt.dp.decorator;

// Step1: Component
interface Formatter {
	public String format(String data);
}

// Step2: Concrete class
class JsonFormatter implements Formatter {

	@Override
	public String format(String data) {
		return "{ message: " + data + " }";
	}
}

class XmlFormatter implements Formatter {

	@Override
	public String format(String data) {
		return "<message>" + data + "</message>";
	}
}

abstract class FormatterDecorator implements Formatter {
	protected Formatter formatter;

	protected FormatterDecorator(Formatter formatter) {
		this.formatter = formatter;
	}
}

class RateLimiterDecorator extends FormatterDecorator {

	public RateLimiterDecorator(Formatter formatter) {
		super(formatter);
	}

	@Override
	public String format(String data) {
		System.out.println("Rate limit added");
		return formatter.format(data);
	}
}

class LoadBalancerDecorator extends FormatterDecorator {

	public LoadBalancerDecorator(Formatter formatter) {
		super(formatter);
	}

	@Override
	public String format(String data) {
		System.out.println("Load Balancer added.");
		return formatter.format(data);
	}
}

public class DecoratorPatternDriver1 {
	public static void main(String[] args) {
		Formatter formatter = new RateLimiterDecorator(new LoadBalancerDecorator(new JsonFormatter()));
		System.out.println(formatter.format("Hello Arif"));
	}
}
