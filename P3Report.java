package Project2;

public class Report {
	private FileInput inFile = new FileInput("fsdata2 (4).txt");
	private Skater skaterList[] = new Skater[50];
	private int nSkaters=0;
	
	private void printSkaterList() {
		//prints the original order and data sheet retrieved from the txt document
		for (int i=0; i< nSkaters; i++ ) { 
			System.out.println(skaterList[i].getName() +"\t" +
                    skaterList[i].getClub() +"\t" +
					   skaterList[i].getShort()+"\t"+
					   skaterList[i].getLong()+"\t"+
					   skaterList[i].getAthleticism()+"\t"+
					   skaterList[i].getArtistic()+"\t"+
					   skaterList[i].getGender()+"\t"+
					   skaterList[i].getAge()+"\t"+
					   skaterList[i].getHeight()+"\t"+
					   skaterList[i].getState());
			
		}
	}
	
	// loads the data from the text document and puts the separate elements into the different arrays created in Skater.java
	public void loadData() {
		String buffer = inFile.readFromFile();
		int i=0;
		while (buffer != null) {
			String name, club, gen, ht, state;
			double sp, lp, ex, pc;
			int age;
			name = buffer.substring(0,20);
			club = buffer.substring(21,46);
			sp   = Double.parseDouble(
					buffer.substring(47,53).trim());
			 lp  = Double.parseDouble(
					 buffer.substring(54,61).trim());
			 ex  = Double.parseDouble(
					 buffer.substring(62,68).trim());
			 pc  = Double.parseDouble(
					 buffer.substring(69,75).trim());
			 gen = buffer.substring(76,77).trim();
			 age =  Integer.parseInt(
					 buffer.substring(78,81).trim());
			 ht = buffer.substring(82,89).trim();
			 state = buffer.substring(90,92);
					 
			if(gen.equals("L")) {
				gen = "F";
			}
			else if (gen.equals("M")) {
				gen = "M";
			}
			skaterList[i] = new Skater(name,age,ht,gen,state,club,lp,sp,pc,ex);
			i++;
			buffer = inFile.readFromFile();
		}
		nSkaters = i;
		printSkaterList();
		inFile.closeFile();// closes the file to prevent data leakage
	}
	

	public void youngest(String gender) {
		int young = 200;
		int skate=0;
		for(int i = 0; i<nSkaters;i++) {
				if(skaterList[i].getAge() < young&&skaterList[i].getGender().equals(gender)) {
					skate = i;
					young = skaterList[i].getAge();
				}
		}
		if(gender == "M") {
			System.out.println("\nYoungest Male:\n--------------------------");
		}
		else if(gender == "F") {
			System.out.println("\nYoungest Female:\n--------------------------");
		}
		System.out.println("The youngest Skater is: "+skaterList[skate].DescriptionStatement());
	}
	public void Height(String gender) {
		String minHeight = " ";
		String maxHeight = " ";
		int feetMin = 1000;
		int inchesMin = 1000;
		int feetMax = -1000;
		int inchesMax = -1000;
		
		for(int i=0;i<nSkaters;i++) {
			if(skaterList[i].getGender().equals(gender)) {
				String height = skaterList[i].getHeight();
				int subs = 3;
				if(height.substring(3,4).equals("\"")) {
					subs = 3;
				}
				else if (!height.substring(3,4).equals("\"")) {
					subs = 4;
				}
				else {
					subs = 3;
				}
				int feet =  Integer.parseInt(height.substring(0,1));
				int inches = Integer.parseInt(height.substring(2,subs));
				if(feet<feetMin) {
					feetMin = feet;
					inchesMin = inches;
					minHeight = height;
				}
				else if(feet == feetMin&&inches<inchesMin) {
					feetMin = feet;
					inchesMin = inches;
					minHeight = height;
				}
				if(feet>feetMax) {
					feetMax = feet;
					inchesMax = inches;
					maxHeight = height;
				}
				else if(feet == feetMax&&inches>inchesMax) {
					feetMax = feet;
					inchesMax = inches;
					maxHeight = height;
				}
			}
		}
		if(gender == "M") {
			System.out.println("\nMale Height Range:\n--------------------------");
		}
		else if(gender == "F") {
			System.out.println("\nFemale Height Range:\n--------------------------");
		}
		System.out.println(minHeight+"-"+maxHeight);
		
	}
	public void StateList() {
		String states = "";
		System.out.println("\nPresent Skater States:\n--------------------------");
		for(int i=0;i<nSkaters;i++) {
			if(!states.contains(skaterList[i].getState())) {
				System.out.println(skaterList[i].getState());
				states += skaterList[i].getState();
			}
		}
	}
}
