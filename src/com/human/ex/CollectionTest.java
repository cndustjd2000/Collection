package com.human.ex;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class CollectionTest {

	public static void main(String[] args) {
		
		//선언
		ArrayList<Integer> arrList
		=new ArrayList<Integer>();
		//Integer는 Wrapper클래스 (기본 자료형, double)
		
		//추가, add는 List에 추가
		arrList.add(40);
		arrList.add(30);
		arrList.add(20);
		arrList.add(10);
		
		
		/*//get으로 확인 인덱스로 값 찾기
		for(int i=0;i<arrList.size();i++) {//size는 List의 크기
			System.out.println(arrList.get(i));//get은 List 불러오기
		}
		
		System.out.println("---------------");
		
		//remove : 삭제
		arrList.remove(1);
		//Integer 30을 삭제 //int는 index : 인덱스 1 삭제, 해당 객체
		
		for(int i:arrList) {//int는 index
			System.out.println(i);
		}
		
		
		System.out.println("---------------");
		
		
		arrList.remove((Integer)10);
		//Integer는 Object, 10객체를 삭제, true 리턴
		
		for(int i:arrList) {
			System.out.println(i);
		}*/
		
		
		//데이터 오름차순 정렬
		Collections.sort(arrList);
		Iterator<Integer> iter=arrList.iterator();
		while(iter.hasNext()) {
			System.out.println(iter.next());
		}
		
		
		//indexOf : 찾는 데이터의 위치를 리턴
		int index=arrList.indexOf((Integer)20);
		System.out.println(index);		
		//boxing 되어서 자동 형변환 됨
		index=arrList.indexOf(20);
		System.out.println(index);
		
				
		//contains : 존재유무, true false 리턴
		System.out.println(arrList.contains(20));
		
		
		//개체로 넣어서 구현
		
		
		
		
		
		
		
		
		
	}

}
