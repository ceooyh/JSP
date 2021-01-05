package vo;

public class memberVo {
	private String id;
	private String pass;
	private String name;
	private int age;
	private String grade;
	
	public memberVo(String id, String pass, String name, int age,String grade) {
		this.id = id;
		this.pass = pass;
		this.name = name;
		this.age = age;
		this.grade = grade;
	}
	public memberVo(String id, String pass, String name, int age) {
		this.id = id;
		this.pass = pass;
		this.name = name;
		this.age = age;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	@Override
	public String toString() {
		return "memberVo [id=" + id + ", pass=" + pass + ", name=" + name + ", age=" + age + ", grade=" + grade + "]";
	}
}
