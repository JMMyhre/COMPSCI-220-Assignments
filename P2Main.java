package Project2;

public class Main {

	public static void main(String args[]) {
		Report obj = new Report();
		obj.loadData();// accesses the different places in report to output the correct formatting to the screen
		obj.scores();
		obj.maxsp();
		obj.maxlp();
		obj.maxscore();
		obj.maxart();
		obj.maxathletic();
		obj.top();
		System.out.println();
		System.out.println("Error Codes:");
		System.out.println("-----------------------------------");
		obj.errors();
	}
	
}
