package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.entity.Course;
import com.luv2code.hibernate.entity.Instructor;
import com.luv2code.hibernate.entity.InstructorDetail;


public class DeleteCourseInstructorDemo {

	public static void main(String[] args) {
		SessionFactory session = new Configuration().
				configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Course.class)
				.buildSessionFactory();
		
		Session ses = session.getCurrentSession();
		
		try {
			
			int theid=1;
			
			
			  Course crs = ses.get(Course.class, theid);
			  
			  System.out.println("Deleting course from list :"+crs.getId());
			  
			  ses.delete(crs);
			  
			  ses.getTransaction().commit();
			  
			  System.out.println("Done");
			 
			
			/*
			 * ses.beginTransaction();
			 * 
			 * Instructor ins = ses.get(Instructor.class, theid);
			 * 
			 * System.out.println("Deleting the Id from Instructor ::"+ins);
			 * 
			 * ses.delete(ins);
			 * 
			 * ses.getTransaction().commit();;
			 */
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			
			ses.close();
			System.out.println("Got an Exception!!!");
		}

	}

}
