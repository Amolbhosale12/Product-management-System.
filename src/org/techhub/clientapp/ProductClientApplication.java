/*
Project Title : Product Managment System

case 1: Add New Product( id,name,price,company)
note: collection should not accept duplicate product name and company
case 2: View All Product
case 3: count total number of Product
case 4: display company wise product count
case 5: search product by name or by company or by id or by price
case 6: delete product by company name or id or by product name
case 7: find the product details in desecending order by price
case 8: find second highest price product details
case 9 : display the company name who having maximum product count
case 10:update price of product by company name and its product name
 */
package org.techhub.clientapp;
import java.sql.SQLOutput;
import java.util.*;
import org.product.model.*;
import org.techhub.repository.*;
public class ProductClientApplication {
    public static void main(String []args){
        Scanner sc=new Scanner(System.in);
        ProductRepository pr=null;// when we create object inside case.everytime make

        do{
            System.out.println("enter 1:add new product.");
            System.out.println("enter 2:view all product details.");
            System.out.println("enter 3:count total number of product.");
            System.out.println("enter 4:display company  wise product count.");
            System.out.println("enter 5:search product by id ,name,price ,company name");
            System.out.println("enter 6:delete product by id,name,price,company name");
            System.out.println("enter 7:find the product details in descending order by price.");
            System.out.println("enter 8:find second highest price product details");
            System.out.println("enter 9:display the company name who having maximum product count.");
            System.out.println("enter 10:update price of product by company name and its product name.");
            int choice;
            System.out.println("Enter your choice here:");
            choice=sc.nextInt();
            switch(choice){
                case 1:System.out.println("Enter all details of product:id,name,price,company name.");
                       int id=sc.nextInt();
                       String name=sc.next();
                       int price=sc.nextInt();
                       String company=sc.next();
                       // create object of product class
                    Product p=new Product(id,name,price,company);
                    pr=new ProductRepository();
                    if(pr.acceptInput(p)){
                        System.out.println("new product added successfully....");
                    }
                    else{
                        System.out.println("not added.");
                    }
                    break;
                case 2:
                    /* here display all product.
                     */
                    pr.showData();
                    break;
                case 3:
                    int count=pr.totalCount();
                    System.out.println("available product count:"+count);
                    /* here display the total count of product.
                       as we know that we create object of repository class only once. but
                       in repository class we create arryList no of times means every arrayList has only one object.
                     */
                    break;
                case 4:
                    pr.CompanyWiseProductCount();
                    break;
                case 5:
                    System.out.println("enter 1:search by id");
                    System.out.println("enter 2:search by name");
                    System.out.println("enter 3:search by price");
                    System.out.println("enter 4:search by company name");
                    int c;
                    c=sc.nextInt();
                    switch(c){
                        case 1:System.out.println("enter id here:");
                              int sid=sc.nextInt();
                              pr.searchById(sid);
                            break;
                        case 2:System.out.println("enter name here:");
                             String sname=sc.next();
                             pr.searchByName(sname);
                            break;
                        case 3:System.out.println("enter price here:");
                             int sprice=sc.nextInt();
                             pr.searchByPrice(sprice);
                            break;
                        case 4:System.out.println("enter company name here");
                             String scompany=sc.next();
                             List l=pr.searchByCompanyName(scompany);
                             if(l.size()>0){
                                 for(Object obj:l){
                                     p=(Product)obj;
                                     System.out.println(p.getId()+" "+p.getName()+" "+p.getPrice()+" "+p.getCompany());
                                 }
                             }
                             else{
                                 System.out.println("Data not found.");
                             }

                            break;
                        default:
                            System.out.println("Invalid Input.");
                    }
                    break;
                case 6:
                    System.out.println("enter 1: delete by  id.");
                    System.out.println("enter 2: delete by name.");
                    System.out.println("enter 3: delete by price.");
                    System.out.println("enter 4: delete by company name.");
                    int ch=sc.nextInt();
                    switch(ch){
                        case 1:
                            System.out.println("enter id here:");
                            int Did=sc.nextInt();
                            pr.deleteById(Did);
                            break;
                        case 2:
                            System.out.println("enter name here:");
                            String Dname=sc.next();
                            pr.deleteByName(Dname);

                            break;
                        case 3:
                            System.out.println("enter price here:");
                            int Dprice=sc.nextInt();
                            pr.deleteByPrice(Dprice);
                            break;
                        case 4:
                            System.out.println("enter company name here:");
                            String Dcompany=sc.next();
                            pr.deleteByCompany(Dcompany);
                            break;
                    }

                    break;
                case 7:
                    // call method of descending order
                     ArrayList a=pr.descendingOrderByPrice();
                    if(a.size()>0){
                        // we have two ways to print data or invoke data from ArrayList as follows using simple for loop
                        // and inhance for loop.


                        for(int i=0;i<a.size();i++){
                            Product dp=(Product)a.get(i);
                            System.out.println(dp.getId()+" "+dp.getName()+" "+dp.getPrice()+" "+dp.getCompany());
                        }
//                        for(Object obj:a){
//                            p= (Product)obj;
//                            System.out.println(p.getId()+" "+p.getName()+" "+p.getPrice()+" "+p.getCompany());
//                        }
                    }
                    else{
                        System.out.println("Data not available for perform operation in descending order.");
                    }
                    break;
                case 8:
                    a=pr.descendingOrderByPrice();
                    p=(Product)a.get(1);
                    System.out.println(p.getId()+" "+p.getName()+" "+p.getPrice()+" "+p.getCompany());
                    break;
                case 9:
                    // display company name whose product count is maximum.
                    pr.displayMaxCountProductCompanyName();
                    break;
                case 10:
                    System.out.println("enter 1: update by product name");
                    System.out.println("enter 2: update by company name");
                        int c1=sc.nextInt();
                        switch(c1){
                            case 1:
                                System.out.println("enter product name and price here:");
                                String nam=sc.next();
                                int mprice=sc.nextInt();
                                a=pr.updateProductByPname(nam,mprice);
                                for(Object obj:a){
                                     p=(Product)obj;
                                    System.out.println(p.getId()+" "+p.getName()+" "+p.getPrice()+" "+p.getCompany());
                                }
                                break;
                            case 2:
                                System.out.println("enter company name and price here:");
                                String comNam=sc.next();
                                int mcprice=sc.nextInt();
                                 a=pr.updateProductByCname(comNam,mcprice);
                                 for(Object obj:a){
                                     p=(Product)obj;
                                     System.out.println(p.getId()+" "+p.getName()+" "+p.getPrice()+" "+p.getCompany());
                                 }
                                break;
                            default:System.out.println("Invalid input.");

                        }
                    break;
                default:System.out.println("Invalid input.");
            }

        }while(true);// infinite loop

    }
}
