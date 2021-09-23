//creating package
package items;

//Importing libraries
import java.util.*;
import java.lang.Exception;

class Item
{
	//Data memebers declaration
	private int itno;
	private String itname;
	private double rate;
	//constructor
	Item(int itno,String itname,double rate)
	{
		this.itno=itno;
		this.itname=itname;
		this.rate=rate;
	}
	
	//setter and getter methods
	void setItno(int itno)
	{
		this.itno=itno;
	}
	void setItname(String itname)
	{
		this.itname=itname;
	}
	void setRate(double rate)
	{
		this.rate=rate;
	}
	int getItno()
	{
		return itno;
	}
	String getItname()
	{
		return itname;
	}
	double getRate()
	{
		return rate;
	}
}

class ItemsList
{
	//Items list creation
	HashMap<Integer,Item> itms=new HashMap<Integer,Item>();
	void createItemsList()
	{
		itms.put(1,new Item(1,"apple",50.5));
		itms.put(2,new Item(2,"banana",25.0));
		itms.put(3,new Item(3,"orange",20.7));
		itms.put(4,new Item(4,"pineapple",67));
		itms.put(5,new Item(5,"mango",45));
		itms.put(6,new Item(6,"tomato",20));
		itms.put(7,new Item(7,"carrot",35));
	}
}

//Exception class
class InvalidItno extends Exception
{
	InvalidItno(String str)
	{
		super(str);
	}
}

class Changing
{
	ItemsList itls=new ItemsList();
	
	//creating items list
	void createList()
	{
		itls.createItemsList();
	}
	//changing rate of item
	void changeRate(int id,double new_rate)
	{
		try
		{
			Item it=itls.itms.get(id);
			if(it==null)
				throw new InvalidItno("The given item id doesnot exist");
			else
				it.setRate(new_rate);
		}
		catch(InvalidItno e)
		{
			System.out.println(e.getMessage());
		}
	}
	void print()
	{
		Iterator itr=itls.itms.entrySet().iterator();
		System.out.println("Item No\t Item Name\t Item Rate");
		while(itr.hasNext())
		{
			Map.Entry mapElement=(Map.Entry)itr.next();
			Item it=((Item)mapElement.getValue());
			System.out.println(it.getItno()+"\t "+it.getItname()+"\t\t "+it.getRate());
		}
	}
	//adding new item
	void addItem(){
		int item_id;
		// Inputiting the Item Id to be inserted
		System.out.println("Enter the Item id : ");
		Scanner sc = new Scanner(System.in);
		item_id = sc.nextInt();
		// Checking for the duplicate Item id's
		if(itls.itms.containsKey(item_id)){  
		try{
			throw new InvalidItno("The Item Number already exists in the shopping cart");
			}
		
		catch(InvalidItno ex){
			System.out.println(ex.getMessage());
			// Terminating if the Item no already exists
			System.exit(0);
		}
		}
		
		// If the Item Id doesnt exists
		else{
			String item_name;
			System.out.println("Enter the Item Name :");
			item_name = sc.next();
		Iterator itr=itls.itms.entrySet().iterator();
		boolean flag = true;
		while(itr.hasNext())
		{
			Map.Entry mapElement=(Map.Entry)itr.next();
			Item it=((Item)mapElement.getValue());
			
			// If the Item Name already exists in the shopping cart
			if(it.getItname().toLowerCase().equals(item_name.toLowerCase())){
				flag = false;
				try{
					throw new InvalidItno("Item Name Already Exists");
				}
				catch(InvalidItno ex){
					System.out.println(ex.getMessage());
					// Terminating if the Item name already exists
					System.exit(0);
				}
				break;
			}
		}
		
		// If the Item name is unique add it 
		if(flag){
			double rate;
			System.out.println("Enter the Item Price : ");
			rate = sc.nextDouble();
			itls.itms.put(item_id,new Item(item_id,item_name,rate));
		}
		}
	}
	
	//removing item
	//Added Remove item
	void removeItem(int item_id){
		
		// If item Doesnt exists
		if(!itls.itms.containsKey(item_id)){
			 try{
				 throw new InvalidItno("Item Doesnt exist in the cart");
			 }
			 catch(InvalidItno ex){
				 System.out.println(ex.getMessage());
				 // Terminating if the Item Id already exists 
				 System.exit(0);
			 }
		}
		else
			itls.itms.remove(item_id);
	}
	
}

/*
class Items
{
	public static void main(String[] args)
	{
		Changing ch=new Changing();
		ch.createList();
		ch.print();
		System.out.println("new rates");
		ch.changeRate(8,5.0);
		ch.print();
		System.out.println("Before Add");
		ch.addItem(31,"carrot",102.32);
		System.out.println("After Adding Item");
		ch.print();
		ch.removeItem(8);
		ch.print();
	}
}

*/