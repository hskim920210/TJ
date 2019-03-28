
public class Exercise_Child2 extends Exercise_Parent2 {
	private String name;
	
	public Exercise_Child2() {
		this("ȫ�浿");
		System.out.println("Child() call");
	}
	
	public Exercise_Child2(String name) {
		this.name = name;
		System.out.println("Child(String name) call");
	}
}
