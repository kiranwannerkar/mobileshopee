package com.ty.mobileshop;

import java.util.*;

public class MobileShop {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("enter the number of mobiles");
		int n = sc.nextInt();
		Map<String, Map<Integer, Map<Integer, List<Mobile>>>> shop = new HashMap<>();
		for (int i = 0; i < n; i++) {
			System.out.println("Enter operating system");
			String os = sc.next();
			System.out.println("Enter ram");
			int ram = sc.nextInt();
			System.out.println("Enter Memory");
			int mem = sc.nextInt();
			System.out.println("Enter Price");
			int price = sc.nextInt();
			System.out.println("Enter rating");
			int rating = sc.nextInt();
			shop.computeIfAbsent(os, k -> new HashMap<>()).computeIfAbsent(ram, k -> new HashMap<>())
					.computeIfAbsent(mem, k -> new ArrayList<>()).add(new Mobile(price, rating));
		}
		System.out.println("no of customer who visited john shop");
		int q = sc.nextInt();
		while (q-- > 0) {
			System.out.println("enter operating system");
			String os = sc.next();
			System.out.println("enter ram");
			int ram = sc.nextInt();
			System.out.println("enter memory");
			int mem = sc.nextInt();
			System.out.println("enter budget");
			int budget = sc.nextInt();
			List<Mobile> eligibleMobiles = shop.getOrDefault(os, Collections.emptyMap())
					.getOrDefault(ram, Collections.emptyMap()).getOrDefault(mem, Collections.emptyList());
			int rating = -1;
			for (Mobile m : eligibleMobiles) {
				if (m.price <= budget && m.rating > rating) {
					rating = m.rating;
				}
			}
			System.out.println(rating != -1 ? rating : -1);
		}
		sc.close();
	}

	private static class Mobile {
		int price;
		int rating;

		public Mobile(int price, int rating) {
			this.price = price;
			this.rating = rating;
		}
	}
}
