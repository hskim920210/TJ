import java.util.Scanner;

public class Array_24 {

	public static void main(String[] args) {
		// 사용자에게 임의의 정수 5개를 입력받아 배열에 저장하기.
		// 배열을 복사하여 입력된 정수를 오름차순으로 정렬한 후, 원본배열과 정렬된 배열의 값을 출력하기.

		Scanner kb = new Scanner(System.in);

		int[] arr = new int[5];

		for (int i = 0; i < arr.length; i++) {
			System.out.printf("%d번째 정수를 입력하세요. : ", i + 1);
			arr[i] = kb.nextInt();
		}

		System.out.println("");

		// 원본 배열과 분리된 새로운 배열 생성
		int[] arr_copy = arr.clone();

		// 중첩된 반복문을 활용하여 정렬을 수행
		for (int i = 0; i < arr_copy.length - 1; i++) {
			for (int j = i + 1; j < arr_copy.length; j++) {
				if (arr_copy[i] > arr_copy[j]) { // 스왑로직. 내림차순은 부등호만 바꾸면 끝
					int temp = arr_copy[j];
					arr_copy[j] = arr_copy[i];
					arr_copy[i] = temp;
				}
			}
		}
		
		// 두개의 배열을 출력

		System.out.println("원본 배열은 다음과 같습니다.");
		for (int i = 0; i < arr.length; i++) {
			System.out.printf("arr[%d] = %d\n", i, arr[i]);
		}
		System.out.println("");
		System.out.println("복사된 배열은 다음과 같습니다.");
		for (int i = 0; i < arr.length; i++) {
			System.out.printf("arr_copy[%d] = %d\n", i, arr_copy[i]);
		}
		kb.close();

	}

}
