
class GetSetTest {

	// 클래스의 멤버필드 선언
	// 모든 멤버필드들을 private으로 선언하는 경우 외부에서 접근이 제한됨
	// 이러한 경우 각각의 멤버필드에 대헤 값을 수정하거나 값을 확인할 수 있는 추가적인 메소드를 제공해야 한다.
	// 자바에서는 Setter, Getter 메소드를 사용하여 이를 처리할 수 있다.
	// Setter 메소드 : 특정 멤버필드의 값을 설정할 수 있는 메소드
	// Setter 메소드의 작명규칙 : void set멤버필드의이름(멤버필드의 첫글자는 대문자)
	// Getter 메소드 : 특정 멤버필드의 값을 반환할 수 있는 메소드
	// Getter 메소드의 작명규칙 : 멤버필드의타입 get멤버필드의이름(멤버필드의 첫글자는 대문자)
	private int n1;
	private int n2;
	private double d;
	private float f;
	private char c;
	private boolean b;
	private String s;

	public int getN1() {
		return n1;
	}

	public void setN1(int n1) {
		this.n1 = n1;
	}

	public int getN2() {
		return n2;
	}

	public void setN2(int n2) {
		this.n2 = n2;
	}

	public double getD() {
		return d;
	}

	public void setD(double d) {
		this.d = d;
	}

	public float getF() {
		return f;
	}

	public void setF(float f) {
		this.f = f;
	}

	public char getC() {
		return c;
	}

	public void setC(char c) {
		this.c = c;
	}

	public boolean isB() {
		return b;
	}

	public void setB(boolean b) {
		this.b = b;
	}

	public String getS() {
		return s;
	}

	public void setS(String s) {
		this.s = s;
	}

}

public class Class_05_GettersAndSetters {
	public static void main(String[] args) {
		GetSetTest obj = new GetSetTest();
		// private 으로 지정된 멤버는 외부에서 접근이 차단된다.
		// obj.n1 = 10;
		// obj.n2 = 20;
		
		obj.setN1(100);
		System.out.println(obj.getN1());
		
	}

}
