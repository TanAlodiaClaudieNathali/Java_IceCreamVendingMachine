import java.util.*;

public class IceCreamVendingMachine {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		LinkedList<Menu> flavor = new LinkedList<Menu>();
		Menu f1 = new Menu(0, "Chocolate", 1200, 50);
		Menu f2 = new Menu(1, "Vanilla", 1000, 50);
		Menu f3 = new Menu(2, "Choco & Vanilla", 1100, 50);
		
		LinkedList<Menu> container = new LinkedList<Menu>();
		Menu c1 = new Menu (0, "Cup", 20, 50);
		Menu c2 = new Menu(1, "Cone", 50, 60);
		
		flavor.add(f1);
		flavor.add(f2);
		flavor.add(f3);
		
		container.add(c1);
		container.add(c2);
	
		String option = "";
		
		Owner owner = new Owner();
		ManagementCenter manager = new ManagementCenter();
		
		int selectedF, selectedC;
		
		while(true) {
		selectedF = flavorSelection(sc, flavor);
		
		selectedC = containerSelection(sc, container);
		
		option = transaction(sc, flavor, container, selectedF, selectedC, option);
		
		sendStorageState(flavor, container, option, owner, selectedF, selectedC);
		
		sendOrder(flavor, container, manager, selectedF, selectedC);
		}
	}

	// name : flavorSelection
	// function : for user to select a flavor of ice cream.
	// arguments : input from user(using sc) and linked list of flavor 
	// return : int selectedF (selectedF)
	private static int flavorSelection(Scanner sc, LinkedList<Menu> flavor) {
		System.out.println("Please select a flavor with the corresponding number: ");
		for(Menu f : flavor) {
			System.out.println(f.getNumber()+" - "+f.getName()+": "+ f.getPrice() + " won");
		}
		System.out.println("3 - Random(Choco or Vanilla)");
		
		int selectedF = sc.nextInt();
		
		if(selectedF == 3 ) {
			Random randomGenerator = new Random();
			selectedF = randomGenerator.nextInt(2);				
			System.out.println("you get "+ flavor.get(selectedF).getName().toLowerCase() + " flavor.");
		}
		return selectedF;
	}
	
	// name : containerSelection
	// function : For user to select a container for ice cream
	// arguments : input from user(using sc) and linked list of container 
	// return : int selectedC (selected container)
	private static int containerSelection(Scanner sc, LinkedList<Menu> container) {
		System.out.println("");
		System.out.println("Please select a container with the corresponding number: ");
		
		for(Menu c : container) {
			System.out.println(c.getNumber()+" - "+c.getName()+": "+c.getPrice() +" won");
		}
		int selectedC = sc.nextInt();
	
		return selectedC;
	}
	
	// name : transaction
	// function : For user to do the transaction; the transaction include confirm their order, make payment and get their order. 
	// arguments : input from user(using sc and saved as option), linked list of flavor and container, selectedF and selectedC(selected flavor and container)
	// return : String option(to be used in sending storage state to the owner)
	private static String transaction(Scanner sc, LinkedList<Menu> flavor, LinkedList<Menu> container, int selectedF, int selectedC, String option) {
		int sumPrice = flavor.get(selectedF).getPrice() + container.get(selectedC).getPrice();
		
		System.out.println("You selected "+ flavor.get(selectedF).getName().toLowerCase() + " ice cream in a " + container.get(selectedC).getName().toLowerCase() + " for " + sumPrice + " won.\nDo you want to proceed? (y/n)");;
		option = sc.next();
		if(option.equals("n")) {
			System.exit(0);
		}
		
		System.out.println("Please insert the money : ");
		int insertedMoney = sc.nextInt();
		while(insertedMoney < sumPrice) {
			System.out.println("You inserted " + insertedMoney + " won. You need to insert " + (sumPrice-insertedMoney) + " won more. Do you want to continue transaction?(y/n)");
			option = sc.next();
			if(option.equals("n")) {
				System.out.println("Here is your inserted money : " + insertedMoney + " won.");
				System.exit(0);
			}
			System.out.println("Please insert " + (sumPrice-insertedMoney) + " more.");
			insertedMoney += sc.nextInt();
		}
		
		if(insertedMoney > sumPrice) {
			System.out.println("Here is your exchange : " + (insertedMoney-sumPrice) + " won");
		}
		System.out.println("Here is your " + flavor.get(selectedF).getName().toLowerCase() + " ice cream! Thank you.");
				
		return option;
	}
	
	// name : sendStorageState
	// function : For the system to send the current storage state of the vending machine to the owner.
	// arguments : linked list of flavor and container, option (from user to confirm the transaction), owner class, selectedF and selectedC(selected flavor and selected container)
	// return : void
	private static void sendStorageState(LinkedList<Menu> flavor, LinkedList<Menu> container, String option, Owner owner, int selectedF, int selectedC) {
		for(Menu f : flavor) {
			for(Menu c: container) {
				if((f.getNumber() ==  flavor.get(selectedF).getNumber()) && !option.equals("n") && c.getNumber() == container.get(selectedC).getNumber()) {
					f.updateQuantity(flavor.get(selectedF).getQuantity());
					c.updateQuantity(container.get(selectedC).getQuantity());
					owner.receiveStorageState(flavor, container);
				}
			}
		}	
	}
	
	// name : sendOrder
	// function : For the system to send order to the management center if the quantity of the item less than certain value(in this case, less than 25) 
	// arguments : linked list of flavor and container, ManagementCenter class, selectedF and selectedC(selected flavor and selected container)
	// return : void
	private static void sendOrder(LinkedList<Menu> flavor, LinkedList<Menu> container, ManagementCenter manager, int selectedF, int selectedC) {
		if(flavor.get(selectedF).getQuantity() <= 25 || container.get(selectedC).getQuantity() <= 25) {
			manager.receivesOrder(flavor, container);
		}
	}
}

