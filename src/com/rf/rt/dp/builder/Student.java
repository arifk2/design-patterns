package com.rf.rt.dp.builder;

/**
 * This is builder design pattern use to:
 * 
 * 1) Avoid bombard all fields in the constructor.
 * 
 * 2) Also some time we want to create of own object with the default value.
 * 
 * 3) For the object having lots of fields with same data type, there may be
 * chance that a developer insert wrong value.
 * 
 * 4) Creating Immutable Objects.
 * 
 * 5) Many optional fields, needs immutability, or strict validation
 */
public class Student {

	private String name; // mandatory
	private String gender;
	private int age;
	private String qualification;
	private String schoolName;

	private Student(StudentBuilder builder) {
		this.name = builder.name;
		this.age = builder.age;
		this.gender = builder.gender;
		this.qualification = builder.qualification;
		this.schoolName = builder.schoolName;
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", gender=" + gender + ", age=" + age + ", qualification=" + qualification
				+ ", schoolName=" + schoolName + "]";
	}

	public static class StudentBuilder {
		private String name;
		private String gender;

		private int age;
		private String qualification;
		private String schoolName;

		public StudentBuilder(String name) {
			this.name = name;
		}

		public StudentBuilder setGender(String gender) {
			this.gender = gender;
			return this;
		}

		public StudentBuilder setAge(int age) {
			this.age = age;
			return this;
		}

		public StudentBuilder setQualification(String qualification) {
			this.qualification = qualification;
			return this;
		}

		public StudentBuilder setSchoolName(String schoolName) {
			this.schoolName = schoolName;
			return this;
		}

		public Student build() {
			return new Student(this);
		}
	}

	public static void main(String[] args) {
		Student student = new Student.StudentBuilder("Arif").setAge(32).setGender("Male").setQualification("Btech")
				.setSchoolName("St Xavier's").build();
		System.out.println(student);
	}
}
