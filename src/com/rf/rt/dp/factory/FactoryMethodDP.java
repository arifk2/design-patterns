package com.rf.rt.dp.factory;

interface INotificationFactory {
	public Notification getNotificationFactory();
}

class SMSNotificationFactory implements INotificationFactory {

	@Override
	public Notification getNotificationFactory() {
		return new SMSNotification();
	}
}

class EmailNotificationFactory implements INotificationFactory {

	@Override
	public Notification getNotificationFactory() {
		return new EmailNotification();
	}
}

class NotificationService {

	static void sendMessage(String message, INotificationFactory notificationFactory) {
		Notification notification = notificationFactory.getNotificationFactory();
		System.out.println(notification.send(message));
	}
}

public class FactoryMethodDP {
	public static void main(String[] args) {

		INotificationFactory smsNotificationFactory = new SMSNotificationFactory();
		NotificationService.sendMessage("My name is arif khan", smsNotificationFactory);
	}
}
