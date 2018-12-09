package com.chandira.demo.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.chandira.demo.hibernate.entity.Course;
import com.chandira.demo.hibernate.entity.Instructor;
import com.chandira.demo.hibernate.entity.InstructorDetail;

public class UpdateCourseDemo {

	public static void main(String[] args) {
		// create session factory
		SessionFactory sessionFactory = new Configuration().configure().addAnnotatedClass(Instructor.class).addAnnotatedClass(Course.class)
				.addAnnotatedClass(InstructorDetail.class).buildSessionFactory();

		// create session
		Session session = sessionFactory.getCurrentSession();

		try {
			int theId=4;

			// begin the transaction
			session.beginTransaction();

			// get course
			Course course = session.get(Course.class, 11);

			// set the course new values
			course.setTitle("Chandira's Hibernate Tutorials");
			
			session.save(course);
			
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
