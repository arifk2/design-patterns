package com.claims.builder.dp.driver;

import java.util.Date;

import com.claims.builder.dp.ClaimsCalculator;

public class ClaimCalculatorDriver {
	public static void main(String[] args) {

		ClaimsCalculator claimsCalculator = new ClaimsCalculator.ClaimBuilder("claimId", "customerId", new Date(),
				1230.12).address("Noida").age(40).locations("Noida").limits("NO LIMIT").country("INDIA").build();

		ClaimsCalculator claimsCalculator2 = new ClaimsCalculator.ClaimBuilder("CLAIM12", "CUST343", new Date(),
				9009.878).build();
		System.out.println(claimsCalculator);
		System.out.println(claimsCalculator2);

	}
}
