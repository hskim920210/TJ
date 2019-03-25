import java.util.*;

public class Array_13 {

	public static void main(String[] args) {
		// 사용자에게 배열의 크기를 입력받아 배열을 생성하고
		// 각 요소에 값을 입력받아 입력된 정수의 순서대로 값을 출력

		// 출력이 종료된 후 사용자에게 정렬 방식을 입력받기 ( 오름차순 : 1, 내림차순 : 2 )
		// 사용자가 선택한 정렬 방식으로 배열을 정렬한 후 출력
		
		Scanner kb = new Scanner(System.in);
		System.out.print("배열의 크기를 입력하세요. : ");
		int[] numbers = new int[kb.nextInt()];
		
		for ( int i = 0 ; i < numbers.length ; i ++ ) {
			System.out.printf("%d 번째 정수를 입력 : ", i+1);
			numbers[i] = kb.nextInt();
		}
		// 입력이 종료된 후, 출력
		for ( int i = 0 ; i < numbers.length ; i ++ ) {
			System.out.printf("%d  ", numbers[i]);	
		}
		System.out.println();
		System.out.println("정렬 방식을 선택하세요.");
		System.out.print("(오름차순 : 1, 내림차순 : 2) : ");
		int sorting_method = kb.nextInt();
		
		
		for (int i = 0; i < numbers.length - 1; i++) {
			for (int j = i + 1; j < numbers.length; j++) {
				// 오름차순 정렬 조건
				boolean flag_asc = sorting_method == 1 && numbers[i] > numbers[j];
				// 내림차순 정렬 조건
				boolean flag_desc = sorting_method == 2 && numbers[i] < numbers[j];
				if (flag_asc || flag_desc) {
					int temp = numbers[j];
					numbers[j] = numbers[i];
					numbers[i] = temp;
				}
			}
		}
		
		// 정렬이 종료된 후 출력
		System.out.println();
		for (int k = 0; k < numbers.length; k++) {
			System.out.printf("%d ", numbers[k]);
		}
		
		
		
		
		
		/* < 내가 완성한 코드 >

		Scanner kb = new Scanner(System.in);
		int array_size;
		int[] numbers;

		System.out.print("배열의 크기를 입력하세요. : ");
		array_size = kb.nextInt();

		numbers = new int[array_size];

		for (int i = 0; i < array_size; i++) {
			System.out.printf("%d번째 정수를 입력하세요. : ", i + 1);
			numbers[i] = kb.nextInt();
		}

		System.out.print("\n오름차순 정렬은 1, 내림차순 정렬은 2를 입력하세요. : ");
		int key = kb.nextInt();

		if (key == 1) {
			for (int a = 0; a < numbers.length - 1; a++) {
				for (int b = a + 1; b < numbers.length; b++) {
					int temp;
					if (numbers[a] > numbers[b]) {
						temp = numbers[b];
						numbers[a] = numbers[b];
						numbers[b] = temp;
					}
				}
			}
			System.out.println();
			for (int k = 0; k < numbers.length; k++) {

				System.out.printf("%d ", numbers[k]);
			}
		} else if (key == 2) {
			for (int a = 0; a < numbers.length - 1; a++) {
				for (int b = a + 1; b < numbers.length; b++) {
					int temp;
					if (numbers[a] < numbers[b]) {
						temp = numbers[a];
						numbers[a] = numbers[b];
						numbers[b] = temp;
					}
				}
			}
			System.out.println();
			for (int k = 0; k < numbers.length; k++) {
				System.out.printf("%d ", numbers[k]);
			}
		}
		*/
	}

}
