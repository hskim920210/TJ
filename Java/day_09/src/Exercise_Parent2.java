
public class Exercise_Parent2 {

	
	public String nation;
	
	public Exercise_Parent2() {
		this("¥Î«—πŒ±π");
		System.out.println("Parent() call");
	}
	
	public Exercise_Parent2(String nation) {
		this.nation = nation;
		System.out.println("Parent(String nation) call");
	}
}
