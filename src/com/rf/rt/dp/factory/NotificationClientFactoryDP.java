package com.rf.rt.dp.factory;

interface Notification {

	public String send(String message);

}

class SMSNotification implements Notification {

	@Override
	public String send(String message) {
		return "Messgae send via SMS: " + message;
	}
}

class EmailNotification implements Notification {

	@Override
	public String send(String message) {
		return "Messgae send via EMAIL: " + message;
	}
}

class NotificationFactory {
	/**
	 * Here we end up with if else ladder and violate open close principle of SOLID,
	 * that is why factory method came in picture
	 * 
	 * @param type
	 * @param message
	 * @return
	 */
	public static Notification getInstance(String type, String message) {
		if (type.equals("SMS"))
			return new SMSNotification();
		else if (type.equals("EMAIL"))
			return new EmailNotification();
		else {
			throw new UnsupportedOperationException("Not valid");
		}
	}
}

public class NotificationClientFactoryDP {
	public static void main(String[] args) {
		NotificationClientFactoryDP notificationClient = new NotificationClientFactoryDP();
		notificationClient.sendNotification("Hello Arif");
	}

	public void sendNotification(String message) {
		Notification smsNotification = NotificationFactory.getInstance("EMAIL", message);
		System.out.println(smsNotification.send(message));
	}
}
