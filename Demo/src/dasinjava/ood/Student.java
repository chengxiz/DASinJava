package dasinjava.ood;

public class Student implements Person {
		String id;
		String name;
		int age;
		public Student(String i, String n, int a){
			id = i;
			name = n;
			age = a;
		}
		protected int studyHours() {return age/2;}
		public String getID() {return id;}
		public String getName() {return name;}
		public int getAge() {return age;}
		public boolean equals(Person other) {
			if (!(other instanceof Student)) return false;
			Student s = (Student) other;
			return id.equals(s.id);
		}
		public String toString() {
			return "Student(ID:"+ id + ", Name:" +name +", Age:" + age + ")";
		}    
}
