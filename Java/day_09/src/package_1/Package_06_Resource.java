package package_1;

public class Package_06_Resource {
	// private : 해당 클래스의 내부에서만 접근할 수 있는 멤버
	private int n1;
	// public : 제약 없이 접근할 수 있는 멤버
	public int n2;
	// 디폴트 접근지정자 : 동일한 패키지 내부에서는 public, 
	//				   서로 다른 패키지에서는 private
	int n3;
	// protected 접근 지정자 : 동일 패키지 내부에서는 public
	//						서로 다른 패키지에서는 private
	//						단, 다른 패키지에서 상속되는 경우 public
	//						(자식 클래스에서는 public)
	protected int n4;

}
