
public class Operator_10 {

	public static void main(String[] args) {
		// 정수를 저장할 수 있는 gender 변수를 선언하고,
		// gender 변수에 주민등록번호 7번째 자리의 값으로 초기화하세요.
		// gender 변수의 값을 비교하여 성별을 출력하세요
		// (1~4까지의 값으로 초기화)
		// (1,3은 남성, 2,4는 여성)
		
		
		// 1. 입력
		int gender;
		gender = 2;
		
		boolean man = gender == 1 || gender == 3;

		String result;
		result = man ? "남성" : "여성";
		
		/*String result1;
		  String result2;
		result1 = (gender = 1)||(gender = 3) ? "남자" : "여자";
		result2 = (gender / 2) == 0 ? "여성" : "남성" */
		
		System.out.printf("이 사람은 %s 입니다.\n", result);

		
		// 2. 처리
		/* String result = "";
		 * result = gender == 1 || gender == 3 ? "남성" : "여성"; 이렇게 하면 숫자가 -999 일 때도 여성이라 나옴.
		 * 
		 * result = gender == 1 || gender == 3 ? "남성" : result;
		 * result = gender == 2 || gender == 4 ? "여성" : result;
		 * System.out.printf("당신은 '%s' 입니다.\n", result);
		 * 
		 */
		
		String res = "";
		res = gender == 1 || gender == 3 ? "남성" : res;
		res = gender == 2 || gender == 4 ? "여성" : res;
		
		System.out.printf("이 사람은 %s 입니다.", res);
		
	}

}
