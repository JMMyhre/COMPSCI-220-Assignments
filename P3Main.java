package Project2;

public class Main {

	public static void main(String args[]) {
		Report obj = new Report();
		obj.loadData();// accesses the different places in report to output the correct formatting to the screen
		obj.youngest("M");
		obj.youngest("F");
		obj.Height("M");
		obj.Height("F");
		obj.StateList();
	}
	
}
