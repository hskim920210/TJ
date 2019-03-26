


class ThisA {
	private int num;
	public void setNum(ThisA this, int input_num) { // this 라는 숨겨진 매개변수. 공유하는 메소드로 현재 실행 객체의 멤버 필드에 접근.
		// 클래스의 멤버필드들은 각각의 객체별로 생성됩니다.(서로 다른 영역)
		// 반면, 멤버 메소드는 하나만 존재하며 모든 객체들이 공유하게 됩니다.
		// 이때, 아래와 같이 특정 멤버필드를 제어하는 코드가 
		// 각각의 객체별로 실행될 수 있도록 this라는 숨겨진 키워드를 제공합니다.
		// 아래의 코드가 컴파일된 이후 실행이 될때는
		// this.num = input_num;
		// 변환되어 실행됩니다.
		// this : 현재 메소드를 실행하고 있는 객체의 참조값
		num = input_num;
		
		// 위의 코드가 컴파일 된 이후에 생성되는 모습은 this.num input_num; 으로 실행된다.
	}
	
	public void showInfo(ThisA this) {
		System.out.printf("num = %d\n",num);
		// 위의 코드가 컴파일 된ㅇ ㅣ후에 생성되는 모습은  System.out.printf("num = %d\n",this.num);
		}
}

public class Class_13_This {

	public static void main(String[] args) {
		ThisA a1 = new ThisA();
		ThisA a2 = new ThisA();
		ThisA a3 = new ThisA();
		
		a1.setNum(10); a2.setNum(20); a3.setNum(30);
		a1.showInfo(); a2.showInfo(); a3.showInfo();

	}

}
