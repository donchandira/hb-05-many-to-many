package com.chandira.demo.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.chandira.demo.hibernate.entity.Instructor;
import com.chandira.demo.hibernate.entity.InstructorDetail;
import com.chandira.demo.hibernate.entity.Student;

public class DeleteDemo {

	public static void main(String[] args) {
		// create session factory
		SessionFactory sessionFactory = new Configuration().configure().addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class).buildSessionFactory();

		// create session
		Session session = sessionFactory.getCurrentSession();

		try {

			// begin the transaction
			session.beginTransaction();

			// get instructor by primary key
			int theID = 2;

			Instructor instructor = session.get(Instructor.class, theID);

			System.out.println("Found instructor: " + instructor);

			// delete instructor
			if (instructor != null) {
				System.out.println("Deleting: " + instructor); 
				session.delete(instructor);
			}

			// commit the transaction
			session.getTransaction().commit();

			System.out.println("Done!");

		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			sessionFactory.close();
		}

	}

}
