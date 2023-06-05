
public class Menu {
	private int number, price, quantity;
	private String name;
	
	//name: Menu
	//function: for the linked list to store the data
	//parameters: number, name, price, quantity
	//return: -
	public Menu(int number, String name, int price, int quantity) {
		this.number = number;
		this.name = name;
		this.price = price;
		this.quantity = quantity;	
	}
	
	//name: getNumber
	//function: to getNumber for the linked list
	//argument: - 
	//return: int type - number
	public int getNumber() {
		return number;
	}
	
	//name: setNumber
	//function: to setNumber from the linked list
	//argument: number 
	//return: void
	public void setNumber(int number) {
		this.number = number;
	}

	//name: getPrice
	//function: to getPrice for the linked list
	//argument: -
	//return: int price
	public int getPrice() {
		return price;
	}

	//name: setPrice
	//function: to setPrice from the linked list
	//argument: price
	//return: void	
	public void setPrice(int price) {
		this.price = price;
	}

	//name: getQuantity
	//function: to getQuantity for the linked list
	//argument: - 
	//return: int quantity
	public int getQuantity() {
		return quantity;
	}

	//name: setQuantity
	//function: to setQuantity from the linked list
	//argument: quantity
	//return: void
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}


	//name: getName
	//function: to getName for the linked list
	//argument: -
	//return: String name
	public String getName() {
		return name;
	}

	//name: setName
	//function: to setName from the linked list
	//argument: name
	//return: void
	public void setName(String name) {
		this.name = name;
	}
	
	//name: updateQuantity
	//function: to update the quantity of an item
	//argument: quantity
	//return: int quantity
	public int updateQuantity(int quantity) {
		return --this.quantity;
	}
}
