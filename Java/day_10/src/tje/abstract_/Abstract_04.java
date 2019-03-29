package tje.abstract_;

// 추상 클래스의 단점
// 추상 메소드 구현의 강제성!!
// 많은 수를 다양한 기능을 정의할 수 있는
// 추상 메소드를 갖는 추상 클래스는 상속에 부담을 주게 됩니다.
// 자식 클래스에서 사용하지 않을 추상 메소드라도, 객체 생성을 위해
// 반드시 구현해야 하는 문제점!!!

abstract class Abstract_B {
	public abstract void test_1();
	public abstract void test_2();
	public abstract void test_3();
	public abstract void test_4();
	public abstract void test_5();
	public abstract void test_6();
	public abstract void test_7();
	public abstract void test_8();
	public abstract void test_9();
	public abstract void test_10();
}

//추상클래스의 추상메소드가 많이 존재하는 경우
//자식클래스의 부담을 덜어주기 위한 패턴
//어댑터 클래스
//추상 클래스의 모든 추상 메소드를 더미 메소드 형태로 미리 구현해 놓은 클래스

class Abstract_BAdapter extends Abstract_B {
	public void test_1() {}
	public void test_2() {}
	public void test_3() {}
	public void test_4() {}
	public void test_5() {}
	public void test_6() {}
	public void test_7() {}
	public void test_8() {}
	public void test_9() {}
	public void test_10() {}
}

class Abstract_B_Sub2 extends Abstract_BAdapter {
	// test_1 메소드를 용도에 맞게 오버라이딩을 구현
	public void test_1() {
		System.out.println("Abstract_B_Sub2 에서 구현한 test_1 메소드");
	}
}


// test_1 메소드를 필요로 하는 자식클래스
class Abstract_B_Sub1 extends Abstract_B {
	// test_1 메소드를 용도에 맞게 오버라이딩을 구현
	public void test_1() {
		System.out.println("Abstract_B_Sub1 에서 구현한 test_1 메소드");
	}

	@Override
	public void test_2() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void test_3() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void test_4() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void test_5() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void test_6() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void test_7() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void test_8() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void test_9() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void test_10() {
		// TODO Auto-generated method stub
		
	}
}



public class Abstract_04 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
