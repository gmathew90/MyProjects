

import java.util.ArrayList;
import java.util.List;


public class item {
    public String retailer;
    public String name;
    public String id;
    public String image;
    public String condition;
    public int price;
    List<String> accessories;
    public item(){
        accessories=new ArrayList<String>();
    }

void setId(String id) {
	this.id = id;
}

void setRetailer(String retailer) {
	this.retailer = retailer;
}


void setImage(String image) {
	this.image = image;
}

void setCondition(String condition) {
	this.condition = condition;
}

void setPrice(int price) {
	this.price = price;
}

List getAccessories() {
	return accessories;
}


void setName(String name) {
	this.name = name;
}





}
