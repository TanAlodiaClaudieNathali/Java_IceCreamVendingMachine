import java.util.LinkedList;

public class Owner {	
	
	// name : receiveStorageState
	// function : (For owner) to receive the current storage state of the vending machine 
	// arguments : linked list of flavor and container
	// return : void
	public void receiveStorageState(LinkedList<Menu> flavor, LinkedList<Menu> container) {
		
		System.out.println("\nState of the storage:");
		
		for(Menu f: flavor) {

			System.out.println("Product: "+f.getName()+" - Quantity: "+f.getQuantity());
		}
		
		for (Menu c: container) {
			System.out.println("Product: " + c.getName() + " - Quantity: " + c.getQuantity());
		}
		System.out.println("");
	}
}
