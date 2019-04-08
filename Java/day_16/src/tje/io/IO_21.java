package tje.io;

import java.util.*;
import java.io.*;
import java.text.SimpleDateFormat;

// 사칙연산의 결과를 저장할 수 있는 
// CalculatorResult 클래스를 작성하세요
// CalculatorResult 클래스는 연산에 사용된 좌항, 우항의 정보
// 연산자 부호, 연산의 결과를 저장할 수 있습니다.
// CalculatorResult 클래스는 toString 메소드를 통해서
// 연산식과 결과를 출력할 수 있습니다.

class CalculatorResult implements Serializable{
	private int leftValue;
	private int rightValue;
	private String operator;
	private double result;
	
	public CalculatorResult(int leftValue, int rightValue, String operator, double result) {
		this.leftValue = leftValue;
		this.rightValue = rightValue;
		this.operator = operator;
		this.result = result;
	}
	
	@Override
	public String toString() {
		return String.format("%d %s %d = %.2f", this.leftValue, this.operator, this.rightValue, this.result);
		}
	
	// 내가 한것
//	public int n1;
//	public int n2;
//	public char sign;
//	public int result;
//	
//	public String lhs = "" + n1 + sign + n2;
//	public String rhs = "" + result;
//	
//	public CalculatorResult (int n1, int n2, char sign) {
//		n1 = this.n1;
//		n2 = this.n2;
//		sign = this.sign;
//	}
//	
//	@Override
//	public String toString() {
//		return String.format("%d %c %d = %d\nlhs = %s, rhs = %s\n", n1, sign, n2, result, lhs, rhs); 
//	}
}

public class IO_21 {

	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
		// 사용자에게 정수 2개와 계산식에 사용될 부호를 입력받아 계산을 출력하기.
		// 결과는 CalculatorResult 클래스의 객체를 생성하여
		// 저장한 후, toString 메소드를 사용하여 출력.
		
		BufferedReader in = 
				new BufferedReader(
						new InputStreamReader(System.in));
		
		int leftValue, rightValue;
		String operator;
		double result = 0;
		String isExit;
		
		// 반복문을 활용하여 사용자가 종료를 원할 때까지 계산을 수행하고
		// 아래의 history 컬렉션에
		// 계산식의 결과를 저장하는 CalculatorResult 객체를 저장하세요.
		ArrayList<CalculatorResult> history = new ArrayList<>();
		
		do {
			System.out.print("1번째 정수 : ");
			leftValue = Integer.parseInt(in.readLine());
			
			System.out.print("연산 부호 : ");
			operator = in.readLine();
			
			System.out.print("2번째 정수 : ");
			rightValue = Integer.parseInt(in.readLine());
			
			if ( operator.equals("+") )
				result = leftValue + rightValue;
			else if ( operator.equals("-") )
				result = leftValue - rightValue;
			else if ( operator.equals("*") )
				result = leftValue * rightValue;
			else if ( operator.equals("/") )
				result = (double)leftValue / rightValue;
			
			CalculatorResult cr = new CalculatorResult(leftValue, rightValue, operator, result);
			System.out.println(cr);
			history.add(cr);
			
			System.out.print("종료하시겠습니까 ? (y/n) : ");
			isExit = in.readLine();
		} while ( isExit.equals("n") || isExit.equals("N") );
		
		
		System.out.println("계산 내역 출력");
		for( int i = 0 ; i < history.size() ; i++ )
			System.out.printf("%d -> %s\n", i+1, history.get(i));
		
		// history에 기록된 객체를 저장.
		// 파일명은 년도_월_일_시간_분.dat로 저장
		// D:\\dev\\java_se\\file_log 경로에
		
		// 현재 시간에 관련된 날짜 객체 반환
		Date now = Calendar.getInstance().getTime();
		// 파일명을 생성하기 위한 SimpleDateFormat 객체 생성
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy_MM_dd_HH_mm");
		// 확장자를 포함한 파일명 생성
		String fileName = sdf.format(now) + ".dat";
		
		String dirPath = "D:\\\\dev\\\\java_se\\\\file_log";
		File dir = new File(dirPath);
		if( !dir.exists() ) { 
			dir.mkdirs();
		}
		
		File file = new File(dir, fileName);
		
		// 출력 스트림 생성
		ObjectOutputStream out = 
				new ObjectOutputStream(
						new BufferedOutputStream(
								new FileOutputStream(file)));
		
		// 객체를 파일에 출력
		out.writeObject(history);
		out.flush();
		out.close();
		
		System.out.println("프로그램 종료");

		// 오브젝트 다시 가져오기
//		ObjectInputStream inn =
//				new ObjectInputStream(
//						new BufferedInputStream(
//								new FileInputStream(file)));
//		
//		ArrayList<CalculatorResult> list = (ArrayList<CalculatorResult>) inn.readObject();
//		
//		for( int i = 0 ; i < history.size() ; i++ )
//			System.out.println(history.get(i));
		
		


		
		// 내가 한것
//		String dirPath = "D:\\dev\\java_se\\file_test";
//		File dir = new File(dirPath);
//		
//		File file = new File(dir, "object_07.txt");
//		
//		
//		
//		BufferedReader in = 
//				new BufferedReader(
//						new InputStreamReader(System.in));
//		String inp;
//		
//		System.out.print("첫번째 정수 : ");
//		int n1 = (int) in.read() - '0';
//		in.skip(2);
//		System.out.print("두번째 정수 : ");
//		int n2 = (int) in.read() - '0';
//		in.skip(2);
//		System.out.print("부호 : ");
//		String op = in.readLine();
//		
//		double result;
//		
//		if( op.equals("+") )
//			result = n1 + n2;
//		else if ( op.equals("-") )
//			result = n1 - n2;
//		else if ( op.equals("*") )
//			result = n1 * n2;
//		else if ( op.equals("/") )
//			result = n1 / n2;
//		else if ( op.equals("%") )
//			result = n1 % n2;
//		else result = -0000;
//
//		
//		CalculatorResult a = new CalculatorResult(n1,n2,op,result);
//		
//		System.out.println(a);
		
		

	}
}
