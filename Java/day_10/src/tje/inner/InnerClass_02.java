package tje.inner;

//클래스의 선언 형태
//1. 일반적인 클래스의 선언
//	- 파일 내부에 class 키워드를 사용하여 클래스를 선언
//2. 익명(무명)
//	- 이름이 없는 클래스
//3. 중첩클래스
//	- 다른 클래스의 내부에 선언되는 클래스
//	  2개의 추상메소드를 포함하고 있는 부모클래스.

// 중첩클래스
// 클래스 내부에 선언된 중첩클래스
// - 외부의 모든 멤버를 자유롭게 접근할 수 있는 특징
class Outer {
	private int out_num;
	public Outer(int out_num, int in_num) {
		this.out_num = out_num;
		// 내부 클래스의 객체 생성
		// 외부 클래스는 내부 클래스의 객체를 생성할 수 있다.
		// (클래스의 외부에서는 내부 클래스의 객체를 생성할 수 없다.)
		// 아래의 Inner 클래스는 Outer 클래스 에서만 사용할 수 있는 클래스
		Inner inner = new Inner(in_num);
		inner.printInfo();
	}
	
	class Inner {
		private int in_num;
		public Inner(int in_num) {
			this.in_num = in_num;
		}
		public void printInfo() {
			// 외부 클래스의 private 멤버에도 접근이 가능
			System.out.printf("out_num = %d, in_num = %d\n", out_num, in_num);
		}
	}
}


public class InnerClass_02 {

	public static void main(String[] args) {
		Outer outer = new Outer(10,20);
		// 내부의 클래스는 외부 클래스의 범위를 벗어나면 객체를 생성할 수 없다.
		// Outer.Inner inner = new Outer.Inner(10);
		
		// 내부 클래스의 객체는 외부 클래스의 객체를 사용하는 경우 생성할 수 있다. 근데 아래처럼 잘 안씀
		Outer.Inner inner = outer.new Inner(777);
		inner.printInfo();

	}

}
