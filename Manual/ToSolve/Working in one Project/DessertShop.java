
public class DessertShop {
	private DessertItem[] myDessertItems;
	private int numberOfItems;
	private final int RECEIPT_WIDTH = 30;
	
	public DessertShop() {
		myDessertItems = new DessertItem[100];
		numberOfItems = 0;
	}
	
	public int numberOfItems() {
		return numberOfItems;
	}
	
	public void enterItem(DessertItem item) {
		this.myDessertItems[numberOfItems] = item;
		numberOfItems++;
	}
	
	public void clear() {
		for(int i = 0; i < numberOfItems; i++)
			this.myDessertItems[i] = null;
		numberOfItems = 0;
	}
	
	public int totalCost() {
		int sum = 0;
		for(int i = 0; i < numberOfItems; i++) 
			sum += myDessertItems[i].getCost(); 
		return sum;
	}	
	
	public final static double TAX_RATE = 6.5;		// 6.5%
	public final static int COST_WIDTH = 6;
	
	public String cents2dollarsAndCents(int cents) {
		String s = "";
		
		if (cents < 0) {
			s += "-";
			cents *= -1;
		}
		
		int dollars = cents / 100;
		cents = cents % 100;
		
		if (dollars > 0) 
			s += dollars;
		
		s += ".";
		
		if (cents < 10)
			s += "0";
		
		s += cents;
		
		return s;
	}
	
	public int totalTax() {
		return (int)Math.round(this.totalCost() *TAX_RATE / 100.00);
	}
	
	public String toString() {
		String s = "";		// receipt
		
		
		s += "    " + "Derlicious!!! "+ "\n";
		s += "    " + "--------------------" + "\n";
		
		for(int j = 0; j < numberOfItems; j++){
		
			String l = myDessertItems[j].getName();		// items of every line
			
//			String item = myDessertItems[j].getClass().toString().substring(6);		// get the item category
			
			String p = cents2dollarsAndCents(myDessertItems[j].getCost());	// price of every item
			if (p.length() > COST_WIDTH)		// verify the price is within length
				p = p.substring(0, COST_WIDTH);
			
			if (myDessertItems[j] instanceof IceCream) {		// print if ice cream
				while(l.length() < RECEIPT_WIDTH - p.length()){
					l += " ";
				}
				s += l + p + "\n";
			}
			else if (myDessertItems[j] instanceof Sundae) {		// print if Sundae
				
				s += ((Sundae)myDessertItems[j]).getTopping() + " Sundae with\n";
				
				while(l.length() < RECEIPT_WIDTH - p.length()){
					l += " ";
				}
				s += l + p + "\n";
			}
			else if (myDessertItems[j] instanceof Candy){		// print if Candy
				s += ((Candy) myDessertItems[j]).getWeight() + " lbs @ " + 
						cents2dollarsAndCents(((Candy) myDessertItems[j]).getPricePerPound()) + " /lb.\n";
				
				while(l.length() < RECEIPT_WIDTH - p.length()){
					l += " ";
				}
				s += l + p + "\n";	
			}
			else {		// print if Cookie
				s += ((Cookie)myDessertItems[j]).getNumber() + " @ " + 
						cents2dollarsAndCents(((Cookie)myDessertItems[j]).getPricePerDozen()) + " /dz\n";
				
				while(l.length() < RECEIPT_WIDTH - p.length()){
					l += " ";
				}
				s += l + p + "\n";			
			}	
		}
		
		String line = "\nTax";		
		String tax = cents2dollarsAndCents(this.totalTax());	// print tax
		while(line.length() <= RECEIPT_WIDTH - tax.length())
			line += " ";
		s += line + tax;
		
		String totalCost = cents2dollarsAndCents(this.totalCost() + this.totalTax());	// print total cost
		line = "\nTotal Cost";
		while(line.length() <= RECEIPT_WIDTH - totalCost.length())
			line += " ";
		s += line + totalCost;
	
		return s;
	}
	  public static void main(String[] args) {
		  
		    DessertShop checkout = new DessertShop();
		    
		    checkout.enterItem(new Candy("Peanut Butter Fudge", 2.25, 399));
		    checkout.enterItem(new IceCream("Vanilla Ice Cream",105));
		    checkout.enterItem(new Sundae("Choc. Chip Ice Cream",145, "Hot Fudge", 50));
		    checkout.enterItem(new Cookie("Oatmeal Raisin Cookies", 4, 399));
		    
		    System.out.println("\nNumber of items: " + checkout.numberOfItems() + "\n");
		    System.out.println("\nTotal cost: " + checkout.totalCost() + "\n");
		    System.out.println("\nTotal tax: " + checkout.totalTax() + "\n");
		    System.out.println("\nCost + Tax: " + (checkout.totalCost() + checkout.totalTax()) + "\n");
		    System.out.println(checkout);
		    
		    checkout.clear();
		    
		    checkout.enterItem(new IceCream("Strawberry Ice Cream",145));
		    checkout.enterItem(new Sundae("Vanilla Ice Cream",105, "Caramel", 50));
		    checkout.enterItem(new Candy("Gummy Worms", 1.33, 89));
		    checkout.enterItem(new Cookie("Chocolate Chip Cookies", 4, 399));
		    checkout.enterItem(new Candy("Salt Water Taffy", 1.5, 209));
		    checkout.enterItem(new Candy("Candy Corn",3.0, 109));
		    
		    System.out.println("\nNumber of items: " + checkout.numberOfItems() + "\n");
		    System.out.println("\nTotal cost: " + checkout.totalCost() + "\n");
		    System.out.println("\nTotal tax: " + checkout.totalTax() + "\n");
		    System.out.println("\nCost + Tax: " + (checkout.totalCost() + checkout.totalTax()) + "\n");
		    System.out.println(checkout);
		  }
}
