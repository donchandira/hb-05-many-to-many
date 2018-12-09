package com.chandira.demo.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.chandira.demo.hibernate.entity.Course;
import com.chandira.demo.hibernate.entity.Instructor;
import com.chandira.demo.hibernate.entity.InstructorDetail;

public class DeleteCourseDemo {

	public static void main(String[] args) {
		// create session factory
		SessionFactory sessionFactory = new Configuration().configure().addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class).addAnnotatedClass(Course.class).buildSessionFactory();

		// create session
		Session session = sessionFactory.getCurrentSession();

		try {

			// begin the transaction
			session.beginTransaction();
			
			int theId = 10;
			
			// get a course
			Course course = session.get(Course.class, theId);
			
			// delete a course
			session.delete(course);

			// commit the transaction
			session.getTransaction().commit();

			System.out.println("Done!");

		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			session.close();
			sessionFactory.close();
		}

	}

}
