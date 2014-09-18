
public class Student implements Comparable<Student>{
	private String name;
	private int score;
	
	public Student(String name, int score) {
		this.name = name;
		this.score = score;
	}


	public int compareTo(Student test) {
		return this.score - test.score;
	}


	public String toString() {
		return name + " " + score;
	}
}
