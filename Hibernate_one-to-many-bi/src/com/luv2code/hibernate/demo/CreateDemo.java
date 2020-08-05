package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.entity.Instructor;
import com.luv2code.hibernate.entity.InstructorDetail;


public class CreateDemo {

	public static void main(String[] args) {
		SessionFactory session = new Configuration().
				configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class).addAnnotatedClass(InstructorDetail.class).buildSessionFactory();
		
		Session ses = session.getCurrentSession();
		
		try {
			Instructor theInstructor=
					new Instructor("Junaid", "Charaniya", "junaidcharaniya@mail");
			
			InstructorDetail theInstructorDetail =
					new InstructorDetail("www.youtube.com/junaid", "Cricket");
			
			theInstructor.setInstructordetail(theInstructorDetail);
			
			ses.beginTransaction();
			
			ses.save(theInstructor);
			
			ses.getTransaction().commit();

			System.out.println("Done");
		}
		finally {
			
			System.out.println("Got an Exception!!!");
		}

	}

}
