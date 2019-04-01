package tje.util;

// 싱글턴 패턴으로 구현된 날자 객체 반환 클래스
import java.util.Calendar;
// 날자 정보를 저장하기 위한 클래스
import java.util.Date;

public class Date_01 {

	public static void main(String[] args) {
		// 현재 시간의 날자 정보를 처리하는 방법
		// java.util.Calendar를 통해 현재 시간에 관련된
		// Date 객체를 반환받아 처리할 수 있다.
		
		// 현재 시간 정보 추출
		Calendar cal = Calendar.getInstance();
		Date now = cal.getTime();
		
		System.out.println("현재 시간은 " + now.toString());

	}

}
