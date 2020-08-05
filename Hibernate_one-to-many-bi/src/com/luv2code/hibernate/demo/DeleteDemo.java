package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.entity.Instructor;
import com.luv2code.hibernate.entity.InstructorDetail;


public class DeleteDemo {

	public static void main(String[] args) {
		SessionFactory session = new Configuration().
				configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class).addAnnotatedClass(InstructorDetail.class).buildSessionFactory();
		
		Session ses = session.getCurrentSession();
		
		try {
			
			int theid=1;
			
			ses.beginTransaction();
			
			Instructor ins = ses.get(Instructor.class,theid);
			
			System.out.println("Print the ins object :"+theid);
			
			if(ins != null)
			{
				System.out.println("Deleting ::"+theid);
			}
			ses.delete(ins);
			
			ses.getTransaction().commit();

			System.out.println("Done");
		}
		finally {
			
			System.out.println("Got an Exception!!!");
		}

	}

}
