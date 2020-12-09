import java.util.*;
import java.io.File; 
import java.io.FileNotFoundException; 

class Car{
	String name;
	double horsePower;
	
	public Car(String name, Double horsePower) {
		this.name = name;
		this.horsePower = horsePower;
	}
	
	public String toString()
    {
        return  this.name + " " + this.horsePower;
    }
}

class Sort implements Comparator<Car>
{
	public int compare(Car obj1, Car obj2) {             // To sort Car on the basis of horse power
        if (obj1.horsePower > obj2.horsePower) return -1;
        if (obj1.horsePower < obj2.horsePower) return 1;
        return 0;
    }  
}

public class CognitreeTest {
	
	public static void main(String[] args) throws FileNotFoundException {
	    String path = args[0];
	    int number = Integer.parseInt(args[1]);
	    String Origin = args[2];
	    Scanner scanner = new Scanner(new File(path));
	    	    
	    double totalHorsePower = 0.0;
	    ArrayList<Car> cars = new ArrayList<Car>();
	 
	    while(scanner.hasNextLine()){
		String nextLine = scanner.nextLine();
		String[] data = nextLine.split(",");
		   if(Origin.equals(data[1])) {
		   	double power = Double.parseDouble(data[2]);
		   	totalHorsePower += power;
		   	cars.add(new Car(data[0], power));
		   }
	    }
	    
	    double avgHorsePower = totalHorsePower / cars.size();
	    
	    Collections.sort(cars, new Sort());
	    for (int i=0; i<cars.size() && number > 0; i++) {
            	if(cars.get(i).horsePower > avgHorsePower) {
            	    System.out.println(cars.get(i) + " " + Origin);
            	    number--;
                }else {
            	    break;
                }
	    }
	    
    }

}
