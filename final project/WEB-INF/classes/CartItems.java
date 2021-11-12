public class CartItems
{
	private int id;
	private String name;
	private int quantity;
	private int price;
	private int totalprice;
	public void setId(int id)
	{
		this.id=id;
	}
	public void setName(String name)
	{
		this.name=name;
	}
	public void setQuantity(int quantity)
	{
		this.quantity=quantity;
	}
	public void setPrice(int price)
	{
		this.price=price;
	}
	public void setTotalPrice(int totalprice)
	{
		this.totalprice=totalprice;
	}
	public int getId()
	{
		return id;
	}
	public String getName()
	{
		return name;
	}
	public int getQuantity()
	{
		return quantity;
	}
	public int getPrice()
	{
		return price;
	}
	public int getTotalPrice()
	{
		return totalprice;
	}
}