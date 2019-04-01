package tje.util;

// 싱글턴 패턴으로 구현된 날자 객체 반환 클래스
import java.util.Calendar;
// 날자 정보를 저장하기 위한 클래스
import java.util.Date;
import java.text.ParseException;
// 날자 정보를 문자열로 처리하기 위한 클래스
// 1. Date 클래스의 객체를 문자열로 반환
// 2. 문자열로 저장된 날자정보를 Date 클래스의 객체로 반환
import java.text.SimpleDateFormat;

public class Date_03 {

	public static void main(String[] args) throws ParseException {
		// 특정 날자에 관련된 정보를 문자열로 저장
		String targetDate = "2019/04/01 16:43:05";

		

		// Date 클래스의 객체를 문자열로 변환
		String format = "yyyy/MM/dd HH:mm:ss"; 
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		
		Date date = sdf.parse(targetDate);

		System.out.println("타겟 시간은 " + date);

	}

}
