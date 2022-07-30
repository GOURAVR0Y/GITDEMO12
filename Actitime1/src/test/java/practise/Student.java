package practise;

public class Student {

	
	public String name;
	public String stream;
	public String course;
	Student(String name){
		this.name=name;
	}
	
	public static void main(String[] args) {
		
		Student s=new Student("Gourav Roy");
		Student s1=new Student("Ashish");
		s.stream="AE&I";
		s.course="Java Developer";
		System.out.println(s.name);
		System.out.println(s.stream);
		System.out.println(s.course);
		System.out.println(s);
		System.out.println(s1.name);
		System.out.println(s1.name);
		System.out.println(s1.name);
		System.out.println(s1.name);
	}

}
