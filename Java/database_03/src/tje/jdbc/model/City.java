package tje.jdbc.model;

// City 테이블의 정보를 저장하기 위한
// 모델 클래스의 정의
// - 모든 모델 클래스는 Java Bean(자바 객체) 제약조건을 준수한다.
// - Java Bean 제약 조건 : 모든 멤버 필드에 대한 
//                      Getter, Setter 메소드를 제공하는것.
public class City {
	// JDBC 프로그래밍에서 정의하는 모델 클래스들은
	// 테이블의 컬럼명과 일치하는 멤버 변수들을 포함한다.
	private int id;
	private String name;
	private String countryCode;
	private String district;
	private int population;
	
	public City() {}

	public City(int id, String name, String countryCode, String district, int population) {
		super();
		this.id = id;
		this.name = name;
		this.countryCode = countryCode;
		this.district = district;
		this.population = population;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public int getPopulation() {
		return population;
	}

	public void setPopulation(int population) {
		this.population = population;
	}
	
	
}
