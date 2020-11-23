package cn.syhg.student;

public class Student {
	private String name;
	private String clas;
	private int number;
	private String sex;
	private int age;
	private String nation;
	public Student(String name, String clas, int number, String sex, int age,
			String nation) {
		super();
		this.name = name;
		this.clas = clas;
		this.number = number;
		this.sex = sex;
		this.age = age;
		this.nation = nation;
	}
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getClas() {
		return clas;
	}
	public void setClas(String clas) {
		this.clas = clas;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getNation() {
		return nation;
	}
	public void setNation(String nation) {
		this.nation = nation;
	}
	public String toString() {
		return "学生信息：\n姓名：" + name + ",  班级：" + clas + ",  学号："
				+ number + ",  性别：" + sex + ",  年龄：" + age + ",  民族："
				+ nation +"\n\n该生作业：\n";
	}
	
}
