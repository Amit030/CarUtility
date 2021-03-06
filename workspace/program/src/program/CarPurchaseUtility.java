import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

class Admin  implements Constants{
	Customer addNewCustomer(int id,String name,int carId,int carType,String model,int price){
		Customer obj = new Customer();
		obj.SetId(id);
		obj.SetName(name);
		obj.SetListOfPurchasedCars(addNewCarToCustomer(carType,carId,model,price));
		return obj;
	}
	Car addNewCarToCustomer(int carType,int carId,String model,int price){
		Car obj;
		switch(carType){
			case MARUTI:
				obj = new Maruti();
				obj.id = carId;
				obj.model = model;
				obj.price = price;
				return obj;
			
			case HYUNDAI: 
				obj = new Hyundai();
				obj.id = carId;
				obj.model = model;
				obj.price = price;
				return obj;
		
			case TOYOTA:
				obj = new Toyota();
				obj.id = carId;
				obj.model = model;
				obj.price = price;
				return obj;
			default :
				obj = new Car();
		}
		return obj;
	}
	
	void listAllCustomers(){
		
	}
	void individualCustomer(){
	
	}
	void generatePrize(){
	
	}
}

class Controler extends Admin{
	int choice;
	HashMap<Integer,Customer> customerHash = new HashMap<Integer,Customer>();
	HashMap<Integer,Boolean> carHash = new HashMap<Integer,Boolean>();
	
	
	void Operationoption(){
		System.out.println("Choose the respective option to perform task n"
				  +"Press 1 : Add new Customern"
				  +"Press 2 : Add new Car to existing Customern"
				  +"press 3 : List of Customern"
				  +"Press 4 : Details of individual Customer Based On IDn"
				  +"Press 5 : Generate prizes for Customern"
				  +"Press 0 : Exitn");
		Scanner sc = new Scanner(System.in);
		choice = sc.nextInt();
	}
	void actionOnChoice(){
		switch(choice){
			case ADD_NEW_CUSTOMER :
				Scanner sc = new Scanner(System.in);
				System.out.println("Enter new Customer Idn");
				int id = sc.nextInt();
				
				if(!customerHash.containsKey(id)){
					System.out.println("Enter new Customer Namen");
					String name = sc.next();
					System.out.println("Enter new Inter Case idn");
					int carId = sc.nextInt();
					System.out.println("Press 1 :Marutin" + "Press 2: Hyundain" + "Press 3: Toyotan");
					int carType = sc.nextInt();
					if(!carHash.containsKey(carId)){
						System.out.println("Enter Car model non");
						String model = sc.next();
						System.out.println("Enter Car pricen");
						int price = sc.nextInt();
						Integer wId = new Integer(id);
						Integer wCarId = new Integer(carId);
						customerHash.put(wId,addNewCustomer(id,name,carId,carType,model,price));
						carHash.put(wCarId,true);
						//printing hash here V 
						for(Map.Entry<Integer,Customer> entry:customerHash.entrySet()){    
        						int key=entry.getKey();  
        						Customer b=entry.getValue();  
        						System.out.println(key+" Details:");  
        						System.out.println(b.name);   
    						}    
						System.out.println("ended.....n");
					}
					else{
						System.out.println("#Car already exists#n");
					}
				}
				else{
					System.out.println("#Customer already exists#n");
				}
			break;
			/*case ADD_NEW_CAR_TO_EXISTING_CUSTOMER :
				addNewCarToCustomer();
			break;
			case LIST_OF_CUSTOMER :
				listAllCustomer();
			break;
			case DETAILS_OF_INDIVIDUAL_CUSTOMER :
				IndividualCustomer();
			break;
			case GENERATE_PRIZE :
				generatePrize();
			break;
			*/
			default :
				System.out.println("default case running ..n");
			
		}
	}
	
}

class Customer {
	int id;
	String name;
	ArrayList<Car> listOfPurchasedCars = new ArrayList<Car>();
	Customer(){
		id = 0;
		name ="";
	}
	Customer(int i , String name , Car carObj){
		this.id = id;
		this.name = name;
		listOfPurchasedCars.add(carObj);
	}
	int GetId(){
		return id;
	}
	void SetId(int id){
		this.id = id; 
	}
	String GetName(){
		return name;
	}
	void SetName(String name){
		this.name = name;
	}
	void SetListOfPurchasedCars(Car carObj){
		listOfPurchasedCars.add(carObj);
	}
	ArrayList<Car> GetListOfPurchasedCars(){
		return listOfPurchasedCars;
	}
}

class Car{
	int id;
	String model;
	int price;
	Car(){
		id=0;
		model="";
		price=0;
	}
	Car(int id,String model,int price){
		this.id = id;
		this.model = model;
		this.price = price;
	}
	int GetId(){
		return id;	
	}
	void SetId(int id){
		this.id = id; 
	}
	String GetModel(){
		return model;
	}
	void SetModel(String model){
		this.model = model;
	}
	int GetPrice(){
		return price;
	}
	void SetPrice(int price){
		this.price = price;
	}
}

class Maruti extends Car implements Constants{
	int resaleValue = MARUTI_RESALE_PERCENT*price;
}

class Hyundai extends Car implements Constants{
	int resaleValue = HYUNDAI_RESALE_PERCENT*price;
}

class Toyota extends Car implements Constants{
	int resaleValue = TOYOTA_RESALE_PERCENT*price;
}

interface Constants{
	int MARUTI_RESALE_PERCENT = (80/100);
	int HYUNDAI_RESALE_PERCENT = (60/100);
	int TOYOTA_RESALE_PERCENT = (40/100);
	int ADD_NEW_CUSTOMER = 1;
	int ADD_NEW_CAR_TO_EXISTING_CUSTOMER = 2;
	int LIST_OF_CUSTOMER =3;
	int DETAILS_OF_INDIVIDUAL_CUSTOMER = 4;
	int GENERATE_PRIZE =5;
	int MARUTI = 1;
	int HYUNDAI = 2;
	int TOYOTA = 3;
}
public class CarPurchaseUtility{
		
	public static void main(String args[]){
		Controler cont = new Controler();
		cont.Operationoption();
		cont.actionOnChoice();
	}
	}












