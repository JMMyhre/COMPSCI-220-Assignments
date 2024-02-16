package Project2;

public class Skater {
	private String name;
	private String club;
	private double shortProgram;
	private double longProgram;
	private double executeElement;
	private double programComponent;
	private double total;
	
	public Skater(String name, String club, double shortProgram, double longProgram, double executeElement,
			double programComponent) {
		super();
		this.name = name;
		this.club = club;
		this.shortProgram = shortProgram;
		this.longProgram = longProgram;
		this.executeElement = executeElement;
		this.programComponent = programComponent;
		this.total = this.shortProgram+this.longProgram;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getClub() {
		return club;
	}
	public void setClub(String club) {
		this.club = club;
	}
	public double getShortProgram() {
		return shortProgram;
	}
	public void setShortProgram(double shortProgram) {
		this.shortProgram = shortProgram;
	}
	public double getLongProgram() {
		return longProgram;
	}
	public void setLongProgram(double longProgram) {
		this.longProgram = longProgram;
	}
	public double getExecuteElement() {
		return executeElement;
	}
	public void setExecuteElement(double executeElement) {
		this.executeElement = executeElement;
	}
	public double getProgramComponent() {
		return programComponent;
	}
	public void setProgramComponent(double programComponent) {
		this.programComponent = programComponent;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	
	

}
