package com.human.ex;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class CollectionTest {

	public static void main(String[] args) {
		
		//����
		ArrayList<Integer> arrList
		=new ArrayList<Integer>();
		//Integer�� WrapperŬ���� (�⺻ �ڷ���, double)
		
		//�߰�, add�� List�� �߰�
		arrList.add(40);
		arrList.add(30);
		arrList.add(20);
		arrList.add(10);
		
		
		/*//get���� Ȯ�� �ε����� �� ã��
		for(int i=0;i<arrList.size();i++) {//size�� List�� ũ��
			System.out.println(arrList.get(i));//get�� List �ҷ�����
		}
		
		System.out.println("---------------");
		
		//remove : ����
		arrList.remove(1);
		//Integer 30�� ���� //int�� index : �ε��� 1 ����, �ش� ��ü
		
		for(int i:arrList) {//int�� index
			System.out.println(i);
		}
		
		
		System.out.println("---------------");
		
		
		arrList.remove((Integer)10);
		//Integer�� Object, 10��ü�� ����, true ����
		
		for(int i:arrList) {
			System.out.println(i);
		}*/
		
		
		//������ �������� ����
		Collections.sort(arrList);
		Iterator<Integer> iter=arrList.iterator();
		while(iter.hasNext()) {
			System.out.println(iter.next());
		}
		
		
		//indexOf : ã�� �������� ��ġ�� ����
		int index=arrList.indexOf((Integer)20);
		System.out.println(index);		
		//boxing �Ǿ �ڵ� ����ȯ ��
		index=arrList.indexOf(20);
		System.out.println(index);
		
				
		//contains : ��������, true false ����
		System.out.println(arrList.contains(20));
		
		
		//��ü�� �־ ����
		
		
		
		
		
		
		
		
		
	}

}
