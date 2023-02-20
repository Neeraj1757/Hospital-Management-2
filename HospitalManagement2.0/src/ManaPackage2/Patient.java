package ManaPackage2;

public class Patient {
	private int Patientid;
	private String name;
	private int age;
	private String sex;
	private String address;

	public Patient() {

	}

	public Patient(String name, int age, String sex, String address) {
		this.name = name;
		this.age = age;
		this.sex = sex;
		this.address = address;
	}

	public Patient(int Patientid, String name, int age, String sex, String address) {
		this.Patientid = Patientid;
		this.name = name;
		this.age = age;
		this.sex = sex;
		this.address = address;
	}

	public int getPatientid() {
		return Patientid;
	}

	public void setPatientid(int patientid) {
		Patientid = patientid;
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

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Patient{" + "Patientid=" + Patientid + ", name='" + name + '\'' + ", age='" + age + '\'' + ", sex='"
				+ sex + '\'' + ", address=" + address + '}';
	}

}