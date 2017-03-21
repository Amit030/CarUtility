import java.util.ArrayList;

public class Customer {
	int ID;
	String Name;
	String Car;
	ArrayList<Car>carList=new ArrayList<>();
	public String getCar() {
		return Car;
	}
	public void setCar(String car) {
		Car = car;
	}
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	
	
}
