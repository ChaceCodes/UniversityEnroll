package bbd.studentroll;

public class Student 
{
	private String name;
	private int studentNumber;
	private String dob;
	
	public Student(String name, int UFID, String dob) 
	{
		this.name = name;
		this.studentNumber = UFID;
		this.dob = dob;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getUFID() {
		return studentNumber;
	}

	public void setUFID(int studentNumber) {
		this.studentNumber = studentNumber;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}
	
	
	
}
