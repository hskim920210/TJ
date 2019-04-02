package tje.collection;

// 제네릭을 지원하는 사용자 정의 클래스의 생성
// class 클래스명 <타입문자 - T(다수개가 선언될 수 있다.)> {
//		클래스의 내용 ...
// }

class Contents <T> {
	private T data;
	public Contents(T data) {
		this.data = data;
	}
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}
}


public class Collection_04 {

	public static void main(String[] args) {
		Contents <Integer> intContents = new Contents<>(10);
		Contents <Double> doubleContents = new Contents<>(10.1);
		
		System.out.println(intContents.getData());
		System.out.println(doubleContents.getData());
	}

}
