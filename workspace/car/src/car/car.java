import java.util.*;
import java.util.ArrayList;
import java.util.List;

interface AdminChoice{
    int ADD_COUSTOMER=1;
    int ADD_CAR=2;
    int LIST_ALL_COUSTORMER=3;
    int SORT_USER_LIST=4;
    int GENERATE_PRIZES=5;
    
}
interface CarAddChoice{
    int MARUTI=2;
    int HYUNDAI=3;
    int TOYOTA=1;
}

class AddCoustomer{
    private int coustomerId;
    private String coustomerName;
    ArrayList<NewCarAdd> list=new ArrayList<NewCarAdd>();
    
    AddCoustomer(){
        coustomerId=0;
        coustomerName=" ";
        
    }
    
     public int checkListCustomer(int id,  ArrayList<AddCoustomer>coustomer){
        /* for(int i=0;i<coustomer.size();i++){
             if(id==coustomer.coustomerId)
              return 1;
             
         }*/
         return 0;
     }
    
    
    public void setCoustomerId(int coustomerId,AddCoustomer coustomerAdd){
        coustomerAdd.coustomerId=coustomerId;
    }
    public void setCoustomerName(String coustomerName,AddCoustomer coustomerAdd){
        coustomerAdd.coustomerName=coustomerName;
    }
    public void addCoustomer(AddCoustomer coustomerAdd,int coustomerId,String coustomerName){
        setCoustomerId(coustomerId,coustomerAdd);
        setCoustomerName(coustomerName,coustomerAdd);
        
        
    }
    
    
}
/*

//car properties
class CarProperties{
    private int idCar;
    private String modelCar;
    private int price;
    Scanner scanf=new Scanner(System.in);
    CarProperties(){
        idCar=0;
        modelCar=" ";
        price=0;
    }
    
    
    
    System.out.println("Enter the coustomer Id:-");
    coustomerId=scanf.coustomerId();
    AddCoustomer coustomer=new AddCoustomer();
    
    
    
    public void setId(int id){
        idCar=id;
    }
    public void setModelCar(String modelCar){
        this.modelCar=modelCar;
    }
    public void setPrice(int price){
        this.price=price;
    }
    
    
    
}


/*
 
 class NewCarAdd implements CarAddChoice{
 private int options;
 Scanner scanf=new Scanner(System.in);
 System.out.println("Choose any options to add car:- n 1. Toyota n 2. Maruti n 3. Hyundai ");
 options=scanf.nextInt();
 switch(options)
 {
 case TOYOTA:
 
 break;
 case MARUTI:
 
 break;
 case HYUNDAI:
 
 break;
 }
 
 
 }
 
 
 class Toyota{
 
 }
 
 class Maruti{
 
 }
 class Hyundai{
 
 }
 
 */

class Options implements AdminChoice{
    private int entry;
    ArrayList<AddCoustomer>coustomer=new ArrayList<AddCoustomer>();
    public int id,flag=0;
    public String name;
    public int carId;
    public String modelCar;
    public int price;
    public void optionsEntry(){
        System.out.println("Choose the option:- n 1. Add new Coustomer n 2. Add car n 3. Display the User List n 4. Sort the User list n 5. Generate Prizes ");
        Scanner scanf=new Scanner(System.in);
        entry=scanf.nextInt();
        switch(entry){
            case ADD_COUSTOMER:
                AddCoustomer coustomerAdd=new AddCoustomer();
                //coustomerAdd.AddCoustomer();
                //---------
                coustomer.add(coustomerAdd);
                System.out.println("Enter the Coustomer Id:-");
                id=scanf.nextInt();
                System.out.println("Enter the Coustomer Name:-");
                name=scanf.next();
                coustomerAdd.addCoustomer(coustomerAdd,id,name);
                break;
            case ADD_CAR:
                //NewCarAdd addCar= new NewCarAdd();
                 System.out.println("Enter the Coustomer Id:-");
                 id=scanf.nextInt();
                 //--------
                 flag=checkListCustomer(id,coustomer);
                 if(flag==1)
                 {
                 System.out.println("Enter the Car Id:-");
                 carId=scanf.nextInt();
                 System.out.println("Enter the car of Model:-");
                 modelCar=scanf.next();
                 System.out.println("Enter the Price of Car:-");
                 price=scanf.nextInt();
                 }
                 else{
                     System.out.println("Error");
                 }
                
                
                break;
            case LIST_ALL_COUSTORMER:
                break;
            case SORT_USER_LIST:
                break;
            case GENERATE_PRIZES:
                break;
        }
        
    }
    
    
}

class Admin{
    private String adminName;
    private String adminPassword;
    private void checkAdminData(String adminName,String adminPassword){
        
        if(adminName.equals("sumit") && adminPassword.equals("sumit")){
            System.out.println("Enter Sucessfully");
            Options options=new Options();
            options.optionsEntry();
        }
        else{
            System.out.println("Error");
            throw new ArithmeticException("not valid");
        }
    }
    public void loginAdmin(){
        System.out.println("Enter the UserName:- ");
        Scanner scanf=new Scanner(System.in);
        adminName=scanf.next();
        System.out.println("Enter the Password:-");
        adminPassword=scanf.next();
        checkAdminData(adminName,adminPassword);
    }
}





public class car{
    public static void main(String args[]){
        try{
            Admin sumit=new Admin();
            sumit.loginAdmin();
        }catch(ArithmeticException ae){
            System.out.println("Exception Catch");
        }
    }
}
