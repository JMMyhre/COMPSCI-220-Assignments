package Project2;
public class Skater extends Person{				//ensure to extend your program to initiate polymorphism and inheritance

	
	private String club;
	private double Long;
	private double Short;
	private double artistic;
	private double athleticism;
	private double total;									
	
	public Skater(String name,int age,String height,String gender,String state,String club,double shortProgram,double longProgram,double artistic,double athleticism) {		//constructor added age,height,state,gender to skater constructor for project 4
		super(name,age,height,gender,state);					
		this.club=club;
		this.total=shortProgram+longProgram;
		this.Short=shortProgram;
		this.Long=longProgram;
		this.artistic=artistic;
		this.athleticism=athleticism;
		
		
	}
	

	public String getClub() {
		return club;
	}

	public void setClub(String club) {
		this.club = club;
	}

	public double getLong() {
		return Long;
	}

	public void setLong(double longProgram) {
		this.Long= longProgram;
	}

	public double getShort() {
		return Short;
	}

	public void setShort(double shortProgram) {
		this.Short = shortProgram;
	}

	public double getArtistic() {
		return artistic;
	}

	public void setArtistic(double artistic) {
		this.artistic = artistic;
	}

	public double getAthleticism() {
		return athleticism;
	}

	public void setAthleticism(double athleticism) {
		this.athleticism = athleticism;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}
}
	