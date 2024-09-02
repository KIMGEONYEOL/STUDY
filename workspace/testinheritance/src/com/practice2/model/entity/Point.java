package com.practice2.model.entity;

public class Point {
	protected int x;
	protected int y;
	
	public Point() {}
	public Point(int x, int y) {
		this.x = x;
		this.y = y;				
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	
	public void draw() {
		System.out.println("x 좌표 : " + this.x + " y 좌표 : " + this.y);
	}
	
	
}
