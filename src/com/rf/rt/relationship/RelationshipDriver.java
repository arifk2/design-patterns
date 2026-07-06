package com.rf.rt.relationship;

class Player {
	private String name;
	private String address;

	public Player(String name, String address) {
		this.name = name;
		this.address = address;
	}

	public String getName() {
		return name;
	}

	public String getAddress() {
		return address;
	}

	@Override
	public String toString() {
		return "Player [name=" + name + ", address=" + address + "]";
	}

}

class Team {
	private Player player;

	public void setPlayer(Player player) {
		this.player = player;
	}

	public Player getPlayer() {
		return player;
	}

}

class TeamComposition {

	private Player player;

	public void setPlayer(String name, String address) {
		this.player = new Player(name, address);
	}

	public Player getPlayer() {
		return player;
	}
}

public class RelationshipDriver {
	public static void main(String[] args) {
		/**
		 * Here if the team is destroyed, then also we have player: Aggregation
		 */
		Player player = new Player("Arif", "Aggregation : Near Union Bank");
		Team cricketTeam = new Team();
		cricketTeam.setPlayer(player);

		System.out.println(cricketTeam.getPlayer());

		/**
		 * Here if the team is destroyed, then player also will be destroyed:
		 * Composition
		 */
		TeamComposition hockey = new TeamComposition();
		hockey.setPlayer("Khan", "Composition:: Near Union Bank");
		System.out.println(hockey.getPlayer());
	}
}
