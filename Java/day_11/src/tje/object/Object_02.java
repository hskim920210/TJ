package tje.object;

// toString 메소드의 사용
// toString 메소드는 클래스의 객체 정보를 문자열로 반환하는 기능
// 객체의 클래스명 + '@' + 해시코드값(16진수)
// 사용자 정의 클래스(직접 개발한 클래스)에 toString 메소드를 
// 오버라이딩하여 간단하게 클래스의 정보를 문자열로 제공할 수 있음
class Object_B {
}

// 2차원 평면의 점의 좌표를 저장하는 클래스
class Point {
	private int x;
	private int y;

	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}
	
	public String toString() {
		String result;
		result = "(" + this.hashCode() + ") X : " + this.x + ", Y : " + this.y;
		return result;
		}

}

public interface Object_02 {
	public static void main(String[] args) {
		Object_B obj = new Object_B();
		System.out.println(obj.toString());

		// 객체에 toString 메소드가 호출되는 경우
		// 1. 출력메소드의 매개변수로 객체의 레퍼런스 값을 전달하는 경우
		// (해당 객체를 Object 타입으로 전달받아 toString 메소드를 자동으로 실행)
		System.out.println(obj);

		// 2. 객체의 레퍼런스 변수에 대해서 문자열 결합이 실행되는 경우
		String msg = "obj = " + obj;
		System.out.println(msg);
		
		// Point 클래스의 객체 생성 후, 좌표 정보를 확인
		Point p = new Point(53, 17);
		System.out.printf("(%d) X : %d, Y = %d\n", p.hashCode(), p.getX(), p.getY());
		
		// 오버라이딩 된 toString 메소드를 통해서 클래스의 정보를 확인할 수 있다.
		System.out.println(p);
		
	}

}
