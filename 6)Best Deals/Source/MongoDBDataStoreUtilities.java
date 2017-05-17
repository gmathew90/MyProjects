
import com.mongodb.MongoClient;
import com.mongodb.MongoException;
import com.mongodb.WriteConcern;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.mongodb.DBCursor;
import java.util.*;

import com.mongodb.ServerAddress;
public class MongoDBDataStoreUtilities
{
	static DBCollection myReviews;
	public static void getConnection()
	{
		MongoClient mongo;
		mongo=new MongoClient("localhost",27017);
		DB db =mongo.getDB("CustomerReviews");
		myReviews=db.getCollection("myReviews");

	}

	public void storeReview(String productname, String username, String producttype,String reviewrating,String reviewdate,String reviewtext,String mnm,String price,String retname,String retcity,String retzip,String retstate,String sale,String rebate,String age,String gender,String occupation)
	{
 		HashMap<String, ArrayList<Review>> reviews= new HashMap<String, ArrayList<Review>>();
		try
		{
			reviews=MongoDBDataStoreUtilities.selectReview();
		}
		catch(Exception e)
		{
		}
		if(!reviews.containsKey(productname))
		{
			ArrayList<Review> arr = new ArrayList<Review>();
			reviews.put(productname, arr);
		}
		ArrayList<Review> listReview = reviews.get(productname);
		Review review = new Review(productname, username, producttype,reviewrating,reviewdate,reviewtext,mnm,price,retname,retcity,retzip,retstate,sale,rebate,age,gender,occupation);
		listReview.add(review);
		try
		{
			MongoDBDataStoreUtilities.insertReview(productname, username, producttype,reviewrating,reviewdate,reviewtext,mnm,price,retname,retcity,retzip,retstate,sale,rebate,age,gender,occupation);
		}
		catch(Exception e)
		{ }
	}

public static HashMap<String, ArrayList<Review>> selectReview()
{
getConnection();
HashMap<String, ArrayList<Review>> reviewHashmap=new HashMap<String, ArrayList<Review>>();
DBCursor cursor = myReviews.find();
while (cursor.hasNext())
{
BasicDBObject obj = (BasicDBObject) cursor.next();
if(! reviewHashmap.containsKey(obj.getString("productname")))
{
ArrayList<Review> arr = new ArrayList<Review>();
reviewHashmap.put(obj.getString("productname"), arr);
}
ArrayList<Review> listReview = reviewHashmap.get(obj.getString("productname"));
Review review =new
Review(obj.getString("productname"), obj.getString("username"),obj.getString(" producttype"),obj.getString("reviewrating"),obj.getString("reviewdate"),obj.getString("reviewtext"),obj.getString("mnm"),obj.getString("price"),obj.getString("retname"),obj.getString("retcity"),obj.getString("retzip"),obj.getString("retstate"),obj.getString("sale"),obj.getString("rebate"),obj.getString("age"),obj.getString("gender"),obj.getString("occupation"));
listReview.add(review);
}
return reviewHashmap;
}
public static void insertReview(String productname, String username, String producttype,String reviewrating,String reviewdate,String reviewtext,String mnm,String price,String retname,String retcity,String retzip,String retstate,String sale,String rebate,String age,String gender,String occupation)
{
getConnection();
BasicDBObject doc = new BasicDBObject("title", "myReviews").
append("username", username).
append("productname", productname).
append("producttype", producttype).
append("reviewrating", reviewrating).
append("reviewdate", reviewdate).
append("reviewtext", reviewtext).
append("mnm", mnm).
append("price",price).
append("retname",retname).
append("retcity",retcity).
append("retzip",retzip).
append("retstate",retstate).
append("sale",sale).
append("rebate",rebate).
append("age",age).
append("gender",gender).
append("occupation",occupation);
myReviews.insert(doc);
}


public static ArrayList<Review> TrendingTopReview()
{
getConnection();

DBObject sort = new BasicDBObject();
BasicDBObject Query = new BasicDBObject();
//Query.put("reviewrating",	new BasicDBObject("$gt", 3));
sort.put("reviewrating",-1);

DBCursor cursor = myReviews.find().sort(sort);
ArrayList<Review> arr = new ArrayList<Review>();
while (cursor.hasNext())
{
BasicDBObject obj = (BasicDBObject) cursor.next();


Review review =new Review(obj.getString("productname"), obj.getString("username"),obj.getString(" producttype"),obj.getString("reviewrating"),obj.getString("reviewdate"),obj.getString("reviewtext"),obj.getString("mnm"),obj.getString("price"),obj.getString("retname"),obj.getString("retcity"),obj.getString("retzip"),obj.getString("retstate"),obj.getString("sale"),obj.getString("rebate"),obj.getString("age"),obj.getString("gender"),obj.getString("occupation"));
arr.add(review);
}
return arr;
}


public static ArrayList<Review> DataAnalytics(String prd,String rate,String equ)
{
getConnection();

DBObject sort = new BasicDBObject();
BasicDBObject Query = new BasicDBObject();
if((prd.equals("All")) && (rate.equals("All")))
	{
		DBCursor cursor = myReviews.find();
	}
else
{
 	if(!(rate.equals("All")))
		{
			if(equ.equals("EqualTo"))
			{
				Query.put("reviewrating",rate);
			}
			if(equ.equals("LessThan"))
			{
			Query.put("reviewrating",	new BasicDBObject("$lt", rate));
			}
			if(equ.equals("GreaterThan"))
			{
			Query.put("reviewrating",	new BasicDBObject("$gt", rate));
			}
		}


if (!(prd.equals("All")))
	{
		Query.put("productname",prd);


	}
}

DBCursor cursor = myReviews.find(Query);
ArrayList<Review> arr = new ArrayList<Review>();
while (cursor.hasNext())
{
BasicDBObject obj = (BasicDBObject) cursor.next();


Review review =new Review(obj.getString("productname"), obj.getString("username"),obj.getString(" producttype"),obj.getString("reviewrating"),obj.getString("reviewdate"),obj.getString("reviewtext"),obj.getString("mnm"),obj.getString("price"),obj.getString("retname"),obj.getString("retcity"),obj.getString("retzip"),obj.getString("retstate"),obj.getString("sale"),obj.getString("rebate"),obj.getString("age"),obj.getString("gender"),obj.getString("occupation"));
arr.add(review);
}
return arr;
}
public static ArrayList<String> ProductList()
{
getConnection();
DBCursor cursor = myReviews.find();
ArrayList<String> arr = new ArrayList<String>();
while (cursor.hasNext())
{
BasicDBObject obj = (BasicDBObject) cursor.next();
arr.add(obj.getString("productname"));
}
return arr;
}

}
