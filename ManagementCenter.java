import java.util.LinkedList;
public class ManagementCenter {
	
	// name : receivesOrder.
	// function : For the management center to receive the order from the system to supply the quantity of the items.
	// arguments : linked list of flavor and container.
	// return : void.
	public void receivesOrder(LinkedList<Menu> flavor, LinkedList<Menu> container) {
		for(Menu f: flavor) {
			if(f.getQuantity() <= 25) {
				f.setQuantity((f.getQuantity() + 25));
			}
		}
		
		for(Menu c: container) {
			if(c.getQuantity() <= 25) {
				c.setQuantity((c.getQuantity() + 25 ));
			}
		}
		
		System.out.println("");
		System.out.println("All needed items have been replenished, current state: ");
		
		for(Menu f: flavor) {
			System.out.println("Product: " + f.getName() + " - " + f.getQuantity());
		}
		
		for(Menu c: container) {
			System.out.println("Product: " + c.getName() + " - " + c.getQuantity());
		}
		
		System.out.println("");
		
	}
}
