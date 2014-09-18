import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class ScoreTrakker {
	private ArrayList<Student> list;
	private String studentName;
	private int studentScore;
	
	public void loadDataFromFile(String fileName) {
		list = new ArrayList<Student>();
		FileReader reader = null;
		try {
			reader = new FileReader(fileName);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		Scanner in = new Scanner(reader);
		while (in.hasNextLine()) {
			studentName = in.nextLine();
			studentScore = in.nextInt();
			if (in.hasNextLine())
				in.nextLine();
			list.add(new Student(studentName, studentScore));
		}
		in.close();	
	}
	
	public void printInOrder() {
		Collections.sort(list);
		for (Student s : list)
			System.out.println(s);
	}
	
	public void processFiles(String fileName) {
		try {
			loadDataFromFile(fileName);
			printInOrder();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		ScoreTrakker st = new ScoreTrakker();
		st.processFiles("scores.txt");
	}
}
