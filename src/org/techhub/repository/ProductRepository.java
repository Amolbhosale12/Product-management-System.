package org.techhub.repository;
import java.util.*;
import org.product.model.*;

public class ProductRepository {
    static ArrayList<Product> a=new ArrayList<Product>();// this is ArrayList where we can store object of class in the form  of different data.
    //below method used to copy product reference into arraylist. and perform operation on it.
    public  boolean acceptInput(Product p){
        return a.add(p);
    }
    public void showData(){//below method used to display all the product information.
        if(a.isEmpty()){
            System.out.println("Data not found");
        }
        else{
            for(Object obj:a){
                Product d =(Product)obj;
                System.out.println(d.getId()+" "+d.getName()+" "+d.getPrice()+" "+d.getCompany());
            }
        }
    }

    public int totalCount(){// here we calculate total count of product available.
       int tcount=a.size();
        // System.out.println("available product count:"+tcount);
        return tcount;
    }
    public void searchById(int sid){
        for(Object obj:a){
            Product p=(Product)obj;
            if(p.getId()==sid){
                System.out.println(p.getId()+" "+p.getName()+" "+p.getPrice()+" "+p.getCompany());
            }
        }
    }
    public void searchByName(String name){
        for(Object obj:a){
            Product p=(Product) obj;
            if(p.getName().equals(name)){
                System.out.println(p.getId()+" "+p.getName()+" "+p.getPrice()+" "+p.getCompany());
            }

        }

    }
    public void searchByPrice(int price){
        for(Object obj:a){
            Product p=(Product)obj;
            if(p.getPrice()==price){
                System.out.println(p.getId()+" "+p.getName()+" "+p.getPrice()+" "+p.getCompany());
            }
        }

    }
    public List searchByCompanyName(String company){
        List l=new ArrayList();
        for(Object obj:a){
            Product p=(Product)obj;
            if(p.getCompany().equals(company)){
                //System.out.println(p.getId()+" "+p.getName()+" "+p.getPrice()+" "+p.getCompany());
                l.add(p);
            }
        }
        return l;

    }
    public void deleteById(int id){
        boolean flag=false;
        Product p=null;
        for(Object obj:a){
             p=(Product)obj;
            if(p.getId()==id){
                flag=true;
                break;
            }
        }
        if(flag){
            int index=a.lastIndexOf(p);
            a.remove(index);
            System.out.println("product deleted successfully.......");
        }
        else{
            System.out.println("product not found.");


        }


    }
    public void deleteByName(String name){
        Product p=null;
        boolean flag=false;
        for(Object obj:a){
             p=(Product)obj;
            if(p.getName().equals(name)){
                flag=true;
                break;
            }
        }
        if(flag){
            int index=a.indexOf(p);
            a.remove(index);
        }
        else{
            System.out.println("Product not found.");
        }
    }
    public void deleteByPrice(int price){
        boolean flag=false;
        Product p=null;
        for(Object obj:a){
             p=(Product)obj;
            if(p.getPrice()==price){
                flag=true;
                break;
            }
        }
        if(flag){
            int index=a.indexOf(p);
            a.remove(index);
            System.out.println("Data deleted successfully......");
        }
        else{
            System.out.println("Product Data not found.");
        }
    }
    public void deleteByCompany(String company){
        boolean flag=false;
        Product p=null;
        for(Object obj:a){
             p=(Product)obj;
            if(p.getCompany().equals(company)){
                flag=true;
                break;
            }
        }
        if(flag){
            int index=a.indexOf(p);
            a.remove(index);
            System.out.println("Data deleted successfully...");
        }
        else{
            System.out.println("Product Data not found.");
        }
    }
   // ArrayList a=new ArrayList();
    public ArrayList descendingOrderByPrice(){
        for(int i=0;i<a.size();i++){
            for(int j=i+1;j<a.size();j++){
                //Product prev=(Product)a.get(i);
                //Product next=(Product)a.get(j);
                if(((Product)a.get(i)).getPrice() < ((Product)a.get(j)).getPrice()){
                    Object obj=a.get(i);
                    a.set(i,(Product)a.get(j));
                    a.set(j,(Product)obj);
                }
            }
        }
        return a;
    }

    // calculate second highest price and print details of that product like id,name,price and company name.
    public ArrayList secondHighvalue(){
        for(int i=0;i<a.size();i++){
            for(int j=i+1;j<a.size();j++){
                //Product prev=(Product)a.get(i);
                //Product next=(Product)a.get(j);
                if(((Product)a.get(i)).getPrice() < ((Product)a.get(j)).getPrice()){
                    Object obj=a.get(i);
                    a.set(i,(Product)a.get(j));
                    a.set(j,(Product)obj);
                }
            }
        }
        return a;

    }
    //display the company name who having maximum product count
    // ArrayList<Product> a=new ArrayList<Product>();
    public void CompanyWiseProductCount(){
        int count=1;
        ArrayList b=new ArrayList(a);
        for(int i=0;i<b.size();i++){
            if(b.get(i).equals(-1)){
                continue;
            }
            count=1;
            for(int j=i+1;j<b.size();j++){
                if(((Product)b.get(i)).getCompany().equals(((Product)b.get(j)).getCompany())){
                    count++;
                    b.set(j,-1);
                }
            }
           // System.out.println("  company name  "   + "             count");
            System.out.println(((Product)b.get(i)).getCompany()+"=>"+count);

        }

    }
    public void displayMaxCountProductCompanyName(){
        int count=1;
        int max=0;
        int d=-1;
        ArrayList b=new ArrayList(a);
        for(int i=0;i<b.size();i++){
            if(b.get(i).equals(-1)){
                continue;
            }
            count=1;
            for(int j=i+1;j<b.size();j++){
                if(((Product)b.get(i)).getCompany().equals(((Product)b.get(j)).getCompany())){
                    count++;
                    b.set(j,-1);
                }
            }
            if(count>max){
                max=count;
                 d=b.indexOf(b.get(i));
            }

        }
        // System.out.println("  company name  "   + "             count");
        System.out.println(((Product) b.get(d)).getCompany() + "=>" + max);
    }
    // update price of product by company name and its product name.;
    //ArrayList a=new ArrayList();
    public ArrayList updateProductByPname(String pname,int price){
        for(Object obj:a){
            Product p=(Product)obj;
            if(p.getName().equals(pname)){
                p.setPrice(price);
            }
        }
        return a;

    }
    // below logic work when we want to change price of product by using company name.
    public ArrayList updateProductByCname(String cname,int price){
        for(Object obj:a) {
            Product p=(Product)obj;
            if(p.getCompany().equals(cname)){
                p.setPrice(price);
            }
        }
        return a;
    }
}
