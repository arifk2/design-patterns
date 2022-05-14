package com.claims.builder.dp;

import java.util.Date;

public class ClaimsCalculator {

	private final String claimId;
	private final String customerId;
	private final Date submitdDate;
	private final Double amount;
	private final int age;
	private final String address;
	private final String limits;
	private final String locations;
	private final String country;

	private ClaimsCalculator(ClaimBuilder builder) {
		this.claimId = builder.claimId;
		this.customerId = builder.customerId;
		this.submitdDate = builder.submitdDate;
		this.amount = builder.amount;
		this.age = builder.age;
		this.address = builder.address;
		this.limits = builder.limits;
		this.locations = builder.locations;
		this.country = builder.country;

	}

	public String getClaimId() {
		return claimId;
	}

	public String getCustomerId() {
		return customerId;
	}

	public Date getSubmitdDate() {
		return submitdDate;
	}

	public Double getAmount() {
		return amount;
	}

	public int getAge() {
		return age;
	}

	public String getAddress() {
		return address;
	}

	public String getLimits() {
		return limits;
	}

	public String getLocations() {
		return locations;
	}

	public String getCountry() {
		return country;
	}

	@Override
	public String toString() {
		return "ClaimsCalculator [claimId=" + claimId + ", customerId=" + customerId + ", submitdDate=" + submitdDate
				+ ", amount=" + amount + ", age=" + age + ", address=" + address + ", limits=" + limits + ", locations="
				+ locations + ", country=" + country + "]";
	}

	public static class ClaimBuilder {
		private String claimId;
		private String customerId;
		private Date submitdDate;
		private Double amount;
		private int age;
		private String address;
		private String limits;
		private String locations;
		private String country;

		// define the mandatory fields in the constructor
		public ClaimBuilder(String claimId, String customerId, Date submitdDate, Double amount) {
			this.claimId = claimId;
			this.customerId = customerId;
			this.submitdDate = submitdDate;
			this.amount = amount;
		}

		public ClaimBuilder age(int age) {
			this.age = age;
			return this;
		}

		public ClaimBuilder address(String address) {
			this.address = address;
			return this;
		}

		public ClaimBuilder limits(String limits) {
			this.limits = limits;
			return this;
		}

		public ClaimBuilder locations(String locations) {
			this.locations = locations;
			return this;
		}

		public ClaimBuilder country(String country) {
			this.country = country;
			return this;

		}

		public ClaimsCalculator build() {
			ClaimsCalculator claimsCalculator = new ClaimsCalculator(this);
			return claimsCalculator;
		}

	}

}
