package com.rf.rt.solid;

public class DiscountCalculator {
	/**
	 * This method is violating SOLID principle: of OPEN CLOSE
	 * 
	 * @param type
	 * @param amount
	 * @return
	 */
	public double calculateDiscount(String type, double amount) {
		if (type.equals("SEASONAL"))
			return amount * 0.10;

		else if (type.equals("FESTIVE"))
			return amount * 0.20;
		else if (type.equals("VIP"))
			return amount * 0.30;
		return 0;
	}

	public double caculate(Discount discount, double amount) {
		return discount.apply(amount);
	}

	public static void main(String[] args) {
		Discount seasonalDiscount = new SeasonalDiscount();
		System.out.println(seasonalDiscount.apply(1000));

		Discount festiveDiscount = new FestiveDiscount();
		System.out.println(festiveDiscount.apply(1000));

	}
}

interface Discount {
	double apply(double amount);
}

class SeasonalDiscount implements Discount {

	@Override
	public double apply(double amount) {
		return amount * 0.10;
	}
}

class FestiveDiscount implements Discount {

	@Override
	public double apply(double amount) {
		return amount * 0.20;
	}
}

// Interface Segregation Principle
/**
 * Design interface in such a way so that we should not force to override those
 * method which is not relevant to that class and we have to through exception.
 * In-place of that create small-small interface with relevant method for which
 * we are going to provide implementation.
 * 
 * 
 * In below example in Worker interface we are violating ISP as RobotImpl don't
 * have eat implementation
 * 
 * For that we have broken Worker interface into two interface as: Workable and
 * Eatable, so that Robot can implement Workable and Human can implement both
 * interfaces.
 * 
 * 
 */

interface Worker {
	void eat();

	void work();
}

class RobotImpl implements Worker {

	@Override
	public void eat() {
		throw new UnsupportedOperationException();

	}

	@Override
	public void work() {
		System.out.println("can work");
	}
}

interface Workable {
	void work();
}

interface Eatable {
	void eat();
}

class RobotISP implements Workable {

	@Override
	public void work() {
		System.out.println("Work");
	}
}

class Human implements Workable, Eatable {

	@Override
	public void eat() {
		System.out.println("Eat");
	}

	@Override
	public void work() {
		System.out.println("Work");
	}
}

/**
 * Dependency Inversion Control
 */
interface Database {
	void connect(String url, String username, String password);
}

class MySQL implements Database {

	@Override
	public void connect(String url, String username, String password) {
		System.out.println("MYSQL Database conencted");
		System.out.println(username);
		System.out.println(password);
		System.out.println(url);
	}
}

class Oracle implements Database {

	@Override
	public void connect(String url, String username, String password) {

		System.out.println("Oracle Database connected");
		System.out.println(username);
		System.out.println(password);
		System.out.println(url);
	}
}

class DatabaseDriver {
	private Database database;

	public DatabaseDriver(Database database) {
		this.database = database;
	}

	public void connect(String url, String username, String password) {
		this.database.connect(url, username, password);
	}

	public void setDatabase(Database database) {
		this.database = database;
	}
}

class Main {
	public static void main(String[] args) {
		DatabaseDriver mySQLDatabaseDriver = new DatabaseDriver(new MySQL());
		mySQLDatabaseDriver.connect("http://localhost;3332:MYSQLInstance", "DXC", "DXC@20226!!");
	}
}