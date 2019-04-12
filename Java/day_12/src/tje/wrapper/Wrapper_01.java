package tje.wrapper;

public class Wrapper_01 {
	public static void main(String[] args) {
		// ����Ŭ����
		// �ڹ��� �⺻ �ڷ����� 1:1�� ���εǾ� �ִ� Ŭ����
		// �ڹ��� �⺻ �ڷ����� ��ü�� ǥ���ϱ� ���� ������� Ŭ����
		// byte -> Byte, short -> Short, int -> Integer
		// long -> Long, float -> Float, double -> Double
		// char -> Character, boolean -> Boolean

		// ����Ŭ������ ��ü�� �����Ͽ� ������ ���� �����ϴ� ���

		// �⺻�ڷ����� �����͸� ��ü ���·� ó���ϱ� ���� Ŭ����
		// JDK 1.4 ���������� ����
		Integer i1 = new Integer(100);
		Integer i2 = new Integer(17);

		System.out.printf("%d + %d = %d\n", i1.intValue(), i2.intValue(), i1.intValue() + i2.intValue());
		System.out.println(i1 + i2);
		System.out.println(i1);
		System.out.println(i2);
		
		// JDK 1.5 ���Ŀ����� ����
		// ����ڽ�, �����ڽ�
		// �⺻ Ÿ���� ���� ��ü Ÿ������ ���� �ڽ��� ����
		
		// ����ڽ�
		// - �⺻���� ���� ����Ŭ���� Ÿ������ �ڵ� ��ȯ
		Integer i3 = 100;   // Integer i3 = new Integer(100); �� ���� �ڵ�
		Integer i4 = 27;    // Integer i4 = new Integer(27);  �� ���� �ڵ�
		// ���� ��ڽ� ����
		// - ��ü Ÿ���� ���� �⺻ �ڷ��� Ÿ������ �ڵ� ��ȯ��.
		int sum = i3 + i4;  // int sum = i3.intValue() + i4.intValue();
		
		// �⺻ �ڷ����� Object�� Ÿ������ �����ϴ� �ڵ�
		// ���� �ڽ��� Ȱ��
		Object intObj = 10; // Object intObj = new Integer(10);
		
	}

}