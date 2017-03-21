import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Controller implements Constants{
	ArrayList<Customer>customerslist=new ArrayList<Customer>();
	void showMenu(){
	System.out.println("-----ADMIN PANEL----- \n Press 1 TO Add New Customer"
	+ "\n Press 2 To Add new Car to an existing Customer \n Press 3 To List all Customers with their Deatils "
	+ "\n Press 4 to List individual Customer based on ID \n Press 5 Generate prizes for customer \n Press 0 To Exit");
	}
	
	
	void Responce(){
		 int choice;
         int id=1;
         char YorN;
		Scanner scanf=new Scanner(System.in);
		do{
			showMenu();
			choice=scanf.nextInt(); 
			switch(choice){
				case NEW_CUSTOMER :
					System.out.println("Plesase Enter Your Name");
					String Name=scanf.next();
					Customer customer=new Customer();
					customer.setName(Name);
					customer.setID(id);
					customerslist.add(customer);
					System.out.println("You Are Added with ID-"+id );
					id++;
					break;
				case ADD_NEW_CAR :
					int carId=1;
					System.out.println("Enter Your Id");
					int getID=scanf.nextInt();
					Customer customer2 = searchId(getID);
					if(customer2 == null){
						System.out.println("Wrong Id");
						break;
					}
					System.out.println("---Cars--- \n1.Add Maruti \n2.Add Toyota \n3.Add Hyundai");
					int carChoice = scanf.nextInt();
					double price = 0;String modelName = null;
					switch(carChoice){
						case MARUTI :
							System.out.println("Enter Model");
							modelName = scanf.next();
							System.out.println("Enter Price");
							price = scanf.nextDouble();
							Maruti maruti = new Maruti(carId,modelName,price);
							customer2.carList.add(maruti);
							carId++;
						break;
						case TOYOTA :
							System.out.println("Enter Model");
							modelName = scanf.next();
							System.out.println("Enter Price");
							price = scanf.nextDouble();
							Toyata toyota = new Toyata(carId, modelName, price);
							customer2.carList.add(toyota);
							carId++;
						break;
						case HYUNDAI :
							System.out.println("Enter Model");
							modelName = scanf.next();
							System.out.println("Enter Price");
							price = scanf.nextDouble();
							Hyundai hyundai = new Hyundai(carId, modelName, price);
							customer2.carList.add(hyundai);
							carId++;
						break;
							
					}
					System.out.println("Your details are Addded ");
					
					break;
				
			     			     
		case LIST_ALL_CUSTOMER_WITH_CARS :
			     displayCustomerWithCar();
				 break;
				
				
				
		case  LIST_ALL_CUSTOMER_WITH_ID :
				for(int i=0;i<customerslist.size();i++){
				Customer temp=customerslist.get(i);
				System.out.println(temp.getID() +" " +temp.getName()+ " ");
				}
				break;
				
		case GENERATE_PRIZE :
				generatePrize();
				break;
				
		case EXIT :
			    System.exit(0);
			    
		default:
			    System.out.println("Default Case you pressed wrong key");    
			    }
			    System.out.println("Do you want to continue Y or N");
			    YorN=scanf.next().charAt(0);	
	        	}
		while(YorN=='y' || YorN=='Y');
		        scanf.close();		
		        }
    private Customer searchId(int getID) {
		        Customer customer = null;
		        for(int i = 0; i < customerslist.size(); i++){
		    	customer = customerslist.get(i);
	    		int customerId = customer.getID();
	    		if(customerId==getID){
	    		System.out.println("Found");
			    break;
		    	}
		else
				System.out.println("Wrong input");
		        }
		        return customer;
	}


	private void displayCustomerWithCar() {
	           for(int i=0;i<customerslist.size();i++){
	           Customer customer=customerslist.get(i);
	           System.out.print("Customer Deatils \nCustomer ID--"+customer.getID() +  "\nCustomer Name " + customer.getName() + "\n");
	           ArrayList<Car>cars=customer.carList;
	           for(int j=0;j<cars.size();j++){
	           System.out.print("Car Model--"+cars.get(j).Model +"\nCar"
	           + " Price-- "+cars.get(j).price +"\n Car Resale Value \n"+ cars.get(j).reSaleValue);
		}
	}
	           System.out.println("\n");
		
}


	private void generatePrize() {
			int[] randomPrizeNum=new int[6];
			Random random=new Random();
			int [] winner=new int[6];
			int index=0;
			for(int i=0;i<customerslist.size();i++){
			randomPrizeNum[i]=1+random.nextInt((customerslist.size()-1)+1);
		}
			for(int i=0;i<customerslist.size();i++){
			for(int j=0;j<randomPrizeNum.length;j++){
			if(customerslist.get(i).getID() == randomPrizeNum[j]){
					winner[index++]=randomPrizeNum[j];
				}
			}
		}
			System.out.println("List of prize winners");
			for(int i=0;i<winner.length;i++){
			System.out.print(winner[i]+" ");
			
		}
	
	}

}




