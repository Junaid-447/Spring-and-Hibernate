package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.entity.Instructor;
import com.luv2code.hibernate.entity.InstructorDetail;


public class GetInstructorDetailDemo {

	public static void main(String[] args) {
		SessionFactory session = new Configuration().
				configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.buildSessionFactory();
		
		Session ses = session.getCurrentSession();
		
		try {
			
			int theid=57;
			
			ses.beginTransaction();
			
			InstructorDetail instructordetail = ses.get(InstructorDetail.class, theid);
			
			System.out.println("Instructor Details :::"+instructordetail);
			
			System.out.println("Insructor from Instructor Details::"+instructordetail.getInstructor());;
			ses.getTransaction().commit();

			System.out.println("Done");
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
