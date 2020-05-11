package com.human.ex;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

class Rectangle implements Comparable<Rectangle>{
	public double width,height;

	public double area() {
		return width*height;
	}
	
	public Rectangle(double width, double height) {
		super();
		this.width = width;
		this.height = height;
	}

	@Override
	public String toString() {
		return "Rectangle [width=" + width + ", height=" + height + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(height);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(width);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Rectangle other = (Rectangle) obj;
		/*if (this.height != other.height)
			return false;
		if (this.width != other.width)
			return false;*/
		if(this.width*this.height==other.width*other.height) {
			return true;
		}else {
			return false;
		}
		//return true;
	}

	@Override
	public int compareTo(Rectangle other) {
		// -1 : 교환필요, 0 : 같음, 1 : 교환 불필요
		int returnValue=0;
		
		if(this.area()==other.area()) {
			returnValue=0;
		}else if(this.area()>other.area()) {
			returnValue=1;
		}else if(this.area()<other.area()) {
			returnValue=-1;
		}
		//this와 other를 비교해서 this가 클 때 -1이 리턴이라면 내림차순 정렬
		//this와 other를 비교해서 this가 클 때 1이 리턴이라면 오름차순 정렬
		return returnValue;
	}
	
}

class RectangleWidthAsc implements Comparator<Rectangle>{

	@Override
	public int compare(Rectangle arg0, Rectangle arg1) {
		int returnValue=0;
		if(arg0.width>arg1.width) {
			returnValue=1;
		}else if(arg0.width<arg1.width){
			returnValue=-1;
		}else {
			
		}
		return returnValue;
	}
	
}

public class CollectionTest1 {

	public static void main(String[] args) {
		//컬랙션을 사용하려면 equals와 hashCode를 재정의 해야한다.
		
		//int String : 잘 실행 됨
		//우리가 만든 클래스의 문제점
		
		//System.out.println(new Rectangle(10,10));
		
		ArrayList<Rectangle> arrList
		=new ArrayList<Rectangle>();
		
		arrList.add(new Rectangle(10,10));
		arrList.add(new Rectangle(11,11));
		arrList.add(new Rectangle(12,12));
		arrList.add(new Rectangle(13,13));
		arrList.add(new Rectangle(14,14));
		arrList.add(new Rectangle(13,20));
		
		for(int i=0;i<arrList.size();i++) {
			System.out.println(arrList.get(i));
		}
		
		System.out.println("----------------");
		
		arrList.remove(1);
		arrList.remove(new Rectangle(12,12));
		for(Rectangle r : arrList) {
			System.out.println(r);
		}
		
		System.out.println("----------------");
		
		Rectangle rect=new Rectangle(15,15);
		arrList.add(rect);
		arrList.remove(rect);
		for(Rectangle r : arrList) {
			System.out.println(r);
		}
		
		
		//객체정렬
		//compareTo  ,  compare
		//compareTo >> comparable 인터페이스 : 매개변수가 1개, 자기자신과 매개변수 비교
		//compare >> comparator 인터페이스 : 매개변수 2개, 매개변수 2개 비교
		//넓이로 정렬
		Collections.sort(arrList);
		System.out.println("----------------");
		for(Rectangle r : arrList) {
			System.out.println(r);
		}
		
		//width로 혹은 height로 정렬
		Collections.sort(arrList,new Comparator<Rectangle>() {

			@Override
			public int compare(Rectangle arg0, Rectangle arg1) {
				int returnValue=0;
				if(arg0.width>arg1.width) {
					returnValue=-1;
				}else if(arg0.width<arg1.width){
					returnValue=1;
				}else {
					
				}
				return returnValue;
			}
			
		});
		
		//width의 크기로 정렬
		Collections.sort(arrList,new RectangleWidthAsc());
		System.out.println("----------------");
		for(Rectangle r : arrList) {
			System.out.println(r);
		}
		
		Collections.sort(arrList,(a,b)->{
			int returnValue=0;
			if(((Rectangle)a).height<((Rectangle)b).height) {
				returnValue=1;
			}else if(((Rectangle)a).height>((Rectangle)b).height){
				returnValue=-1;
			}
			return returnValue;
		});
		
		System.out.println("----------------");
		for(Rectangle r : arrList) {
			System.out.println(r);
		}
		
		/*Comparator<Rectangle> com=new Comparator<Rectangle>() {

			@Override
			public int compare(Rectangle o1, Rectangle o2) {
				return 0;
			}
			
		};
		Collections.sort(arrList,com);
		
		System.out.println("----------------");
		for(Rectangle r : arrList) {
			System.out.println(r);
		}*/
		
		
		
	}

}
