package Project2;

public class Report {
	private FileInput inFile = new FileInput("fsdataNew.txt");
	private Skater skaterList[] = new Skater[50];
	private int nSkaters=0;
	
	private void printSkaterList() {
		//prints the original order and data sheet retrieved from the txt document
		for (int i=0; i< nSkaters; i++ ) { 
			System.out.println(skaterList[i].getName() +"\t" +
		                       skaterList[i].getClub() +"\t" +
							   skaterList[i].getShortProgram()+"\t"+
							   skaterList[i].getLongProgram()+"\t"+
							   skaterList[i].getExecuteElement()+"\t"+
							   skaterList[i].getProgramComponent()+"\t"+
							   skaterList[i].getEvent());
			
		}
	}
	
	// loads the data from the text document and puts the separate elements into the different arrays created in Skater.java
	public void loadData() {
		String buffer = inFile.readFromFile();
		int i=0;
		while (buffer != null) {
			String name, club, ev;
			double sp, lp, ex, pc;
			name = buffer.substring(0,21);
			club = buffer.substring(21,47);
			sp   = Double.parseDouble(
					buffer.substring(47,54).trim());
			 lp  = Double.parseDouble(
					 buffer.substring(54,62).trim());
			 ex  = Double.parseDouble(
					 buffer.substring(62,69).trim());
			 pc  = Double.parseDouble(
					 buffer.substring(69,74).trim());
			 ev = buffer.substring(75,77);
			skaterList[i] = new Skater(name, club, sp, lp, ex,pc,ev);
			i++;
			buffer = inFile.readFromFile();
		}
		nSkaters = i;
		printSkaterList();
		inFile.closeFile();// closes the file to prevent data leakage
	}
	
	// gets the person with the highest score in the short program
	public void maxsp() {
		double topscore = 0.0;
		String topskater = " ";
		for(int i = 0; i<nSkaters;i++) {// cycles through all the skaters
			if (skaterList[i].getShortProgram() > topscore) {
				topscore = skaterList[i].getShortProgram();
				topskater = skaterList[i].getName();
			}
		}
		System.out.println("Winner of short program: "+topskater);
	}
	public void maxlp() {// gets the person with the highest score in the long program
		double topscore = 0.0;
		String topskater = " ";
		for(int i = 0; i<nSkaters;i++) {// cycles through all the skaters
			if (skaterList[i].getLongProgram() > topscore) {
				topscore = skaterList[i].getLongProgram();
				topskater = skaterList[i].getName();
			}
		}
		System.out.println("Winner of long program: "+topskater);
	}
	// gets the person with the highest score overall, the winner. Could be optimized forgot that the skaterList[i].getTotal existed
	public void maxscore() { 
		double topscore = 0.0;
		String topskater = " ";
		for(int i = 0; i<nSkaters;i++) {
			if ((skaterList[i].getLongProgram()+skaterList[i].getShortProgram()) > topscore) {
				topscore = (skaterList[i].getLongProgram()+skaterList[i].getShortProgram());
				topskater = skaterList[i].getName();
			}
		}
		System.out.println("Winner of competition: "+topskater);
	}
	// gets the person with the highest executed/artistic element in the competition
	public void maxart() {
		double topscore = 0.0;
		String topskater = " ";
		for(int i = 0; i<nSkaters;i++) {
			if (skaterList[i].getProgramComponent() > topscore) {
				topscore = skaterList[i].getProgramComponent();
				topskater = skaterList[i].getName();
			}
		}
		System.out.println("Skater with highest artistic points: "+topskater);
	}
	// gets the person with the highest athletic points
	public void maxathletic() {
		double topscore = 0.0;
		String topskater = " ";
		for(int i = 0; i<nSkaters;i++) {
			if (skaterList[i].getExecuteElement() > topscore) {
				topscore = skaterList[i].getExecuteElement();
				topskater = skaterList[i].getName();
			}
		}
		System.out.println("skater with highest athleticism points: "+topskater);
	}
	//gets the top 5 skaters and puts them on the usa mens figure skating team
	public void top() {
		double[] add = new double[nSkaters];
		double[] large = new double[5];
		String[] names = new String[nSkaters];
		String[] topfive = new String[5];
		double temp = 0.0;
		for(int j = 0; j<nSkaters;j++) {
			add[j] = skaterList[j].getShortProgram()+skaterList[j].getLongProgram()+skaterList[j].getProgramComponent()+skaterList[j].getExecuteElement();
			names[j] = skaterList[j].getName();
		}
	    for (int j = 0; j < add.length; j++) {
	        for (int i = 4; i >= 0; i--) {
	        	//checks backward to see if it is the largest one and then changes the other ones
	        	if (add[j] > large[i]) {
	                if (i == 4) {
	                    large[i] = add[j];
	                }
	                else{
	                    temp = large[i];
	                    large[i] = add[j];
	                    large[i+1] = temp;
	                }
	            }
	        }
	    }
	    for (int l = 0; l<topfive.length;l++) {
	    	for(int g = 0;g<add.length;g++) {
	    		if(add[g] == large[l]) {
	    			topfive[l] = names[g];
	    		}
	    	}
	    }
		System.out.println("And the 2017 USA Men Figure Skating team are");
		for(int m = 0; m<5;m++) {
			System.out.println(topfive[m]);
		}
	}
	// gets the scores in total and sorts the list based on the total points overall of everything
	public void scores() {
		double[] add = new double[nSkaters];
		double[] large = new double[nSkaters];
		double[] shortprogram = new double [nSkaters];
		double[] sp = new double [nSkaters];
		double[] longprogram = new double [nSkaters];
		double[] lp = new double [nSkaters];
		double[] total = new double[nSkaters];
		double[] t = new double[nSkaters];
		String[] names = new String[nSkaters];
		String[] clubs = new String[nSkaters];
		String[] top = new String[nSkaters];
		String[] cl = new String[nSkaters];
		String[] events = new String[nSkaters];
		String[] eve = new String[nSkaters];
		double temp = 0.0;
		for(int j = 0; j<nSkaters;j++) {
			add[j] = skaterList[j].getShortProgram()+skaterList[j].getLongProgram();
			names[j] = skaterList[j].getName();
			shortprogram[j] = skaterList[j].getShortProgram();
			longprogram[j] = skaterList[j].getLongProgram();
			clubs[j] = skaterList[j].getClub();
			total[j] = skaterList[j].getTotal();
			events[j] = skaterList[j].getEvent();
		}
		
		// same thing as top 5 but with limit of all the players involved
	    for (int j = 0; j < add.length; j++) {
	        for (int i = 47; i >= 0; i--) {
	            if (add[j] > large[i]) {
	                if (i == 47) {
	                    large[i] = add[j];
	                }
	                else{
	                    temp = large[i];
	                    large[i] = add[j];
	                    large[i+1] = temp;
	                }
	            }
	        }
	    }
	    for (int l = 0; l<top.length;l++) {
	    	for(int g = 0;g<add.length;g++) {
	    		if(add[g] == large[l]) {
	    			top[l] = names[g];
	    			sp[l] = shortprogram[g];
	    			lp[l] = longprogram[g];
	    			cl[l] = clubs[g];
	    			t[l] = total[g];
	    			eve[l] = events[g];
	    		}
	    	}
	    }
		System.out.println("\n\n\n\n");
		for(int m = 0; m<top.length;m++) {
			System.out.printf(top[m]+cl[m]+sp[m]+"  "+lp[m]+"  "+"%.2f %s\n",t[m],eve[m]);
		}
	}
	// cycles through and determines the different errors with the inputs
	public void errors() {
		for(int i = 0; i< nSkaters;i++) {
			String EC = " ";
			String[] ECS = new String[nSkaters];// creates the error array
			String name = skaterList[i].getName();
			String[] parts = name.split(" ");
			// checks the first name to see if it is ok
			if(Character.isUpperCase(parts[0].charAt(0)) != true) {
				if(EC == " ") {
					EC = "A";
				}
				else {
					EC = EC+",A";
				}
			}
			// checks the last name to see if it is ok
			if(Character.isUpperCase(parts[1].charAt(0)) != true) {
				if(EC == " ") {
					EC = "B";
				}
				else {
					EC = EC+",B";
				}
			}
			double lp = skaterList[i].getLongProgram();
			String lps = String.valueOf(lp);
			String[] splitr = lps.split("\\.");
			int dLength = splitr[1].length();
			int iLength = splitr[0].length();
			
			if(dLength != 2 || !(iLength <= 3)) {// checks the long program to see if it is formatted correctly
				if(EC == " ") {
					EC = "C";
				}
				else {
					EC = EC+",C";
				}
			}
			double sp = skaterList[i].getShortProgram();
			String sps = String.valueOf(sp);
			String[] splitter = sps.split("\\.");
			int decimalLength = splitter[1].length();
			int integerLength = splitter[0].length();
			
			if(decimalLength != 2 || !(integerLength <= 3)) {// checks the Short program to see if it is formatted correctly
				if(EC == " ") {
					EC = "D";
				}
				else {
					EC = EC+",D";
				}
			}
			double ee = skaterList[i].getExecuteElement();
			String ees = String.valueOf(ee);
			String[] splr = ees.split("\\.");
			int dL = splr[1].length();
			int iL = splr[0].length();
			// checks the executed element to see if it is formatted correctly
			if(dL != 2 || !(iL <= 3)) {
				if(EC == " ") {
				if(EC == " ") {
					EC = "E";
				}
				else {
					EC = EC+",E";
				}
			}
			}
			double pc = skaterList[i].getProgramComponent();
			String pcs = String.valueOf(pc);
			String[] spl = pcs.split("\\.");
			int d = spl[1].length();
			int in = spl[0].length();
			
			if(d != 2 || !(in <= 3)) {// checks the program component to see if it is formatted correctly
				if(EC == " ") {
					EC = "F";
				}
				else {
					EC = EC+",F";
				}
			}
			double tep = skaterList[i].getExecuteElement()+skaterList[i].getProgramComponent();
			double longp = skaterList[i].getLongProgram();
			
			if(!(tep < longp)) { // checks to see if the total of the executed element and the program component are less then the long program points
				if(EC == " ") {
					EC = "G";
				}
				else {
					EC = EC+",G";
				}
			}
			

			

			ECS[i] = EC;
			if (ECS[i] == " ") {// prints out the list of error codes for people who only have errors, if they dont have errors they are not printed
				
			}
			else {
				System.out.println(skaterList[i].getName()+"   "+ECS[i]);
			}
		}
		

		
	}
}
