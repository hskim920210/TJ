
public class Method_04 {
	// Call By Reference 방식의 메소드 호출
	// 메소드의 매개변수로 참조변수의 값을 넘겨주는 방식 ( 배열변수, 클래스의 객체 )
	// 호출된 메소드에서 참조값을 사용해 값을 변경하게 되면 호출한 곳이 가리키는 곳의 메모리에 직접 반영된다.

	public static void updateValue(int[] arr) {
		// main 메소드의 arr 배열이 참조하는 배열을 수정하는 코드
		arr[1] = 100;
		System.out.println("updateValue 메소드");
		for (int i = 0; i < arr.length; i++) {
			System.out.printf("arr[%d] = %d\n", i, arr[i]);
		}
	}

	public static void main(String[] args) {

		int[] arr = { 1, 2, 3 };

		System.out.println("main 메소드");
		for (int i = 0; i < arr.length; i++)
			System.out.printf("arr[%d] = %d\n", i, arr[i]);

		// 배열의 참조 값을 넘겨주는 메소드 호출 !!
		// updateValue 메소드에서 전달받은 참조값을 사용하여 값을 수정했을 때,
		// main 메소드의 arr 배열변수를 사용해서도 수정된 값을 확인할 수 있다.
		updateValue(arr);

		System.out.println("main 메소드");
		for (int i = 0; i < arr.length; i++)
			System.out.printf("arr[%d] = %d\n", i, arr[i]);
	}

}
