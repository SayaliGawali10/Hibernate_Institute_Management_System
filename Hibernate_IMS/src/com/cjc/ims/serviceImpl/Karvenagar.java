package com.cjc.ims.serviceImpl;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.cjc.ims.model.Batch;
import com.cjc.ims.model.Course;
import com.cjc.ims.model.Faculty;
import com.cjc.ims.model.Student;
import com.cjc.ims.serviceI.Cjc;
import com.config.HibernateUtil;

public class Karvenagar implements Cjc {

	 Scanner sc=new Scanner(System.in);
	 
	   
	@Override
	public void addCourse() {
		
       Course c=new Course();
		
		System.out.println("Enter Course Id");
		c.setCid(sc.nextInt());
		sc.nextLine();
		
		System.out.println("Enter Course Name");
		c.setCname(sc.nextLine());
		
		    Session session=HibernateUtil.getSessionFactory().openSession();
		    
		    session.persist(c);
		    
		    session.beginTransaction().commit();
		
		    
		}

	@Override
	public void viewCourse() {
       Session session=HibernateUtil.getSessionFactory().openSession();
		
		String hql="from Course";
		
		Query<Course> query=session.createQuery(hql, Course.class);
		
		List<Course> list=query.getResultList();
		
		list.forEach((c)->{
			
			System.out.println(c);
		});
		
	}

	@Override
	public void addFaculty() {
        Faculty f=new Faculty();
		
		System.out.println("Enter Faculty Id");
		f.setFid(sc.nextInt());
		sc.nextLine();
		
		System.out.println("Enter Faculty Name");
		f.setFname(sc.nextLine());
		
		Session session=HibernateUtil.getSessionFactory().openSession();
	    
	    session.persist(f);
	    
	    session.beginTransaction().commit();
		
	   
	    
	    System.out.println("Assign Courses to Faculty");
	    viewCourse();
	        
	         System.out.println("Enter Course ID");
	         int cid=sc.nextInt();
		     
		     session.beginTransaction();

		     Course course = session.get(Course.class, cid);
		     
		     boolean courseFound = false;

		     if (course != null) {
		        
		         f.setCourse(course);
		         courseFound = true;
		         
		         session.merge(f);
		         session.getTransaction().commit();
		         System.out.println("Course added successfully to Faculty!");
		     } 
		     else {
		         
		         session.getTransaction().rollback();
		         try 
		         {
		             throw new IDNotFoundException("Invalid Course ID");
		         } 
		         catch (IDNotFoundException e) {
		             System.out.println(e.getMessage());
		         }
		     }

		     session.close();
    }

	@Override
	public void viewFaculty() {
      
		Session session=HibernateUtil.getSessionFactory().openSession();
		
		String hql="from Faculty";
		
		Query<Faculty> query=session.createQuery(hql, Faculty.class);
		
		List<Faculty> list=query.getResultList();
		
		list.forEach((f)->{
			
			System.out.println(f);
		});
		
		
	}

	@Override
	public void addBatch() {
      Batch b=new Batch();
		
		System.out.println("Enter Batch Id");
		b.setBid(sc.nextInt());
		
		System.out.println("Enter Batch Name");
		b.setBname(sc.next());
		
        Session session=HibernateUtil.getSessionFactory().openSession();
	    
	    session.persist(b);
	    
	    session.beginTransaction().commit();
	
       System.out.println("Assign Faculties to Batch");
	    
       viewFaculty();
	    
       System.out.println("Enter Faculty ID");
	     int fid=sc.nextInt();
	     
	     session.beginTransaction();

	     Faculty faculty = session.get(Faculty.class, fid);
	     
	     boolean facultyFound = false;

	     if (faculty != null) {
	        
	         b.setFaculty(faculty);
	         facultyFound = true;
	         
	         session.merge(b);
	         session.getTransaction().commit();
	         System.out.println("Course added successfully to Faculty!");
	     } 
	     else {
	         
	         session.getTransaction().rollback();
	         try 
	         {
	             throw new IDNotFoundException("Invalid Course ID");
	         } 
	         catch (IDNotFoundException e) {
	             System.out.println(e.getMessage());
	         }
	     }

	     session.close();
  
  
 }

	@Override
	public void viewBatch() {
    Session session=HibernateUtil.getSessionFactory().openSession();
		
		String hql="from Batch";
		
		Query<Batch> query=session.createQuery(hql, Batch.class);
		
		List<Batch> list=query.getResultList();
		
		list.forEach((b)->{
			
			System.out.println(b);
		});
		
		
	}
		
	

	@Override
	public void addStudent() {
       Student s=new Student();
		
		System.out.println("Enter Student Id");
		s.setSid(sc.nextInt());
		sc.nextLine();
		
		System.out.println("Enter Student Name");
		s.setSname(sc.nextLine());
		
        Session session=HibernateUtil.getSessionFactory().openSession();
	    
	    session.persist(s);
	    
	    session.beginTransaction().commit();
		
       System.out.println("Assign Batches to Student");
	    
       viewBatch();
	    
       System.out.println("Enter Batch ID");
	     int bid=sc.nextInt();
	     
	     session.beginTransaction();

	     Batch batch = session.get(Batch.class, bid);
	     
	     boolean facultyFound = false;

	     if (batch != null) {
	        
	         s.setBatch(batch);
	         facultyFound = true;
	         
	         session.merge(s);
	         session.getTransaction().commit();
	         System.out.println("Course added successfully to Faculty!");
	     } 
	     else {
	         
	         session.getTransaction().rollback();
	         try 
	         {
	             throw new IDNotFoundException("Invalid Course ID");
	         } 
	         catch (IDNotFoundException e) {
	             System.out.println(e.getMessage());
	         }
	     }

	     session.close();
  
  
	        
  
  
	}
	@Override
	public void viewStudent() {
		
		  Session session=HibernateUtil.getSessionFactory().openSession();
			
			String hql="from Student";
			
			Query<Student> query=session.createQuery(hql, Student.class);
			
			List<Student> list=query.getResultList();
			
			list.forEach((s)->{
				
				System.out.println(s);
			});
}
}