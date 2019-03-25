
public class Method_07 {
	
	// 메소드 오버로딩의 조건에 리턴값의 타입은 해당되지 않는다.

	public static void sum() {}
	public static void sum(int i) {}
	public static int sum(int i, char c) {return 0;}
	public static void sum(char i1, int i2) {}
	public static void sum(int i1, int i2) {}
	public static void sum(float f) {}
	// public static float sum(float f) {return 1.1f;} -> 리턴값을 고려하지 않으면 바로 위의 메소드와 구별되지 못한다.

}
