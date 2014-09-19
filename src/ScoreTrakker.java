import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class ScoreTrakker {
	private ArrayList<Student> list;
	private String studentName;
	private int studentScore;
	private String score;
	private String wrongScore;
	private String[] files = {"scores.txt", "badscore.txt", "nofile.txt"};
	
	public void loadDataFromFile(String fileName) throws FileNotFoundException{
		list = new ArrayList<Student>();
		FileReader reader = null;
		reader = new FileReader(fileName);
		Scanner in = new Scanner(reader);
		while (in.hasNextLine()) {
			studentName = in.nextLine();
			score = in.nextLine();
			try {
				studentScore = Integer.parseInt(score);
				list.add(new Student(studentName, studentScore));
			}
			catch (NumberFormatException e) {
				System.out.println("Incorrect format for " + studentName + " not a valid score: " + score);
			}
		}
	}
	
	public void printInOrder() {
		Collections.sort(list);
		for (Student s : list)
			System.out.println(s);
		System.out.println();
	}
	
	public void processFiles() {
		for (String fileName : files) {
			try {
				loadDataFromFile(fileName);
				printInOrder();
			}
			catch (Exception e) {
				System.out.println("Can't open file: " + fileName);
			}
		}
	}
	
	public static void main(String[] args) {
		ScoreTrakker st = new ScoreTrakker();
		st.processFiles();
	}
}
