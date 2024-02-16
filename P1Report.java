package Project2;

public class Report {
	private FileInput inFile = new FileInput("fsdata.txt");
	private Skater skaterList[] = new Skater[50];
	private int nSkaters=0;
	
	private void printSkaterList() {
		
		for (int i=0; i< nSkaters; i++ ) {
			System.out.println(skaterList[i].getName() +"\t" +
		                       skaterList[i].getClub() +"\t" +
							   skaterList[i].getShortProgram()+"\t"+
							   skaterList[i].getLongProgram()+"\t"+
							   skaterList[i].getExecuteElement()+"\t"+
							   skaterList[i].getProgramComponent());
			
		}
	}
	
	
	public void loadData() {
		String buffer = inFile.readFromFile();
		int i=0;
		while (buffer != null) {
			String name, club;
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
			skaterList[i] = new Skater(name, club, sp, lp, ex,pc);
			i++;
			buffer = inFile.readFromFile();
		}
		nSkaters = i;
		printSkaterList();
		inFile.closeFile();
	}
	
	
	public void maxsp() {
		double topscore = 0.0;
		String topskater = " ";
		for(int i = 0; i<nSkaters;i++) {
			if (skaterList[i].getShortProgram() > topscore) {
				topscore = skaterList[i].getShortProgram();
				topskater = skaterList[i].getName();
			}
		}
		System.out.println("Winner of short program: "+topskater);
	}
	public void maxlp() {
		double topscore = 0.0;
		String topskater = " ";
		for(int i = 0; i<nSkaters;i++) {
			if (skaterList[i].getLongProgram() > topscore) {
				topscore = skaterList[i].getLongProgram();
				topskater = skaterList[i].getName();
			}
		}
		System.out.println("Winner of long program: "+topskater);
	}
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
		double temp = 0.0;
		for(int j = 0; j<nSkaters;j++) {
			add[j] = skaterList[j].getShortProgram()+skaterList[j].getLongProgram();
			names[j] = skaterList[j].getName();
			shortprogram[j] = skaterList[j].getShortProgram();
			longprogram[j] = skaterList[j].getLongProgram();
			clubs[j] = skaterList[j].getClub();
			total[j] = skaterList[j].getShortProgram() + skaterList[j].getLongProgram();
		}
	    for (int j = 0; j < add.length; j++) {
	        for (int i = 20; i >= 0; i--) {
	            if (add[j] > large[i]) {
	                if (i == 20) {
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
	    		}
	    	}
	    }
		System.out.println("\n\n\n\n");
		for(int m = 0; m<top.length;m++) {
			System.out.printf(top[m]+cl[m]+sp[m]+"  "+lp[m]+"  "+"%.2f\n",t[m]);
		}
	}

	// Write a method to sort skaterList by total points
}
