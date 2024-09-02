package com.practice2.model.entity;

public class Circle extends Point {
	private int radius;
	
	public Circle() {}
	public Circle(int x, int y, int radius) {
		super(x, y);
		this.radius = radius;
	}
	@Override
	public void draw() {
		super.draw();
		System.out.printf("원면적 : %.1f \n", (java.lang.Math.PI * radius * radius));
		System.out.printf("원 둘레 : %.1f \n", (2 * java.lang.Math.PI * radius));
	}
	
	
	
}
