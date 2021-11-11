public class ItemBean{
String itemId,iName;
int iQuantity,iPrice;
String getName(){
	return this.iName;
}
String getId(){
	return this.itemId;
}
int  getQuantity(){
	return this.iQuantity;
}
int getPrice(){
	return this.iPrice;
}
void setName(String iName){
	this.iName=iName;
}
void setId(String itemId){
	this.itemId=itemId;
}
void setPrice(int iPrice){
	this.iPrice=iPrice;
}
void setQuantity(int iQuantity){
	this.iQuantity=iQuantity;
}
}


