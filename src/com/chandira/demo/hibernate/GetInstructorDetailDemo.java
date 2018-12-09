package com.chandira.demo.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.chandira.demo.hibernate.entity.Instructor;
import com.chandira.demo.hibernate.entity.InstructorDetail;

public class GetInstructorDetailDemo {

	public static void main(String[] args) {
		// create session factory
		SessionFactory sessionFactory = new Configuration().configure().addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class).buildSessionFactory();

		// create session
		Session session = sessionFactory.getCurrentSession();

		try {
			int theId=4;

			// begin the transaction
			session.beginTransaction();

			// get the instructor detail object
			InstructorDetail instructorDetail = session.get(InstructorDetail.class, theId);
			
			// print the instructor detail
			System.out.println("Temp instructor Detail: "+ instructorDetail );
			
			// print the associated instructor
			System.out.println("The associated instructor: "+ instructorDetail.getInstructor());
						
			// commit the transaction
			session.getTransaction().commit();

			System.out.println("Done!");

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// handle connection leak issue
			session.close();
			sessionFactory.close();
		}

	}

}
