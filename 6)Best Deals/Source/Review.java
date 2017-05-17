

import java.util.ArrayList;
import java.util.List;


public class Review {
    public String productname;
    public String username;
    public String producttype;
    public String reviewdate;
    public String reviewtext;
    public String reviewrating;
    public String price;
    public String mnm;
    public String retname;
    public String retcity;
    public String retzip;
    public String retstate;
    public String sale;
    public String rebate;
    public String age;
    public String gender;
    public String occupation;


    public Review(String productname, String username, String producttype,String reviewrating,String reviewdate,String reviewtext,String mnm,String price,String retname,String retcity,String retzip,String retstate,String sale,String rebate,String age,String gender,String occupation)
    {
    this.productname=productname;
    this.username=username;
    this.producttype=producttype;
    this.reviewdate=reviewdate;
    this.reviewtext=reviewtext;
    this.reviewrating=reviewrating;
    this.mnm=mnm;
    this.price=price;
    this.retname=retname;
    this.retcity=retcity;
    this.retzip=retzip;
    this.retstate=retstate;
    this.sale=sale;
    this.rebate=rebate;
    this.age=age;
    this.gender=gender;
    this.occupation=occupation;
    }



}
