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
		// -1 : ��ȯ�ʿ�, 0 : ����, 1 : ��ȯ ���ʿ�
		int returnValue=0;
		
		if(this.area()==other.area()) {
			returnValue=0;
		}else if(this.area()>other.area()) {
			returnValue=1;
		}else if(this.area()<other.area()) {
			returnValue=-1;
		}
		//this�� other�� ���ؼ� this�� Ŭ �� -1�� �����̶�� �������� ����
		//this�� other�� ���ؼ� this�� Ŭ �� 1�� �����̶�� �������� ����
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
		//�÷����� ����Ϸ��� equals�� hashCode�� ������ �ؾ��Ѵ�.
		
		//int String : �� ���� ��
		//�츮�� ���� Ŭ������ ������
		
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
		
		
		//��ü����
		//compareTo  ,  compare
		//compareTo >> comparable �������̽� : �Ű������� 1��, �ڱ��ڽŰ� �Ű����� ��
		//compare >> comparator �������̽� : �Ű����� 2��, �Ű����� 2�� ��
		//���̷� ����
		Collections.sort(arrList);
		System.out.println("----------------");
		for(Rectangle r : arrList) {
			System.out.println(r);
		}
		
		//width�� Ȥ�� height�� ����
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
		
		//width�� ũ��� ����
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
