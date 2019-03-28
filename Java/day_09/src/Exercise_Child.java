
public class Exercise_Child extends Exercise_Parent {
	private int studentNo;
	
	public Exercise_Child(String name, int studentNo) {
		// 부모 클래서의 생성자를 호출해야한다. (5번 문제의 이유)
		super(name);
		// this.name = name;
		this.studentNo = studentNo;
	}
}
