package com.cjc.ims.client;

import java.util.Scanner;
import com.cjc.ims.serviceI.Cjc;
import com.cjc.ims.serviceImpl.Karvenagar;
public class Test {

	public static void main(String[] args) {
		
	    Scanner sc=new Scanner(System.in);
		
	    Cjc c=new Karvenagar();
		
	    while(true) {
	    System.out.println("****MENU****");
		System.out.println("1.AddCourse");
		System.out.println("2.ViewCourse");
		System.out.println("3.AddFaculty");
		System.out.println("4.ViewFaculty");
		System.out.println("5.AddBatch");
		System.out.println("6.ViewBatch");
		System.out.println("7.AddStudent");
		System.out.println("8.ViewStudent");
		
		
		System.out.println("Enter Your Choice");
		
		int ch=sc.nextInt();
		switch(ch) {
		   
		        case 1:
		    	      c.addCourse();
		    	      break;
		    	   
		        case 2:
			    	   c.viewCourse(); 
			    	   break;
			    	   
		        case 3:
			    	   c.addFaculty();
			    	   break;	
			    	   
		        case 4:
			    	   c.viewFaculty();
			    	   break;
			    	   
			    case 5:
				       c.addBatch();
				       break;
				    	   
			    case 6:
				      c.viewBatch();   
				      break;		   
		        
			    case 7:
			    	   c.addStudent();
			    	   break;
			    	   
			    case 8:
				       c.viewStudent();
				      break;
				    	   
			    default:
				       System.out.println("Invalid Choice, Please Select Valid Choice");
		}	          	
		}
	}
}

