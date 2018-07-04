package com.manish.Hibernate;

import org.hibernate.HibernateException;
import org.hibernate.Session;

public class Client {

	public static void main(String[] args) {

		Session session = HibernateUtil.getSessionFactory().openSession();

		try {
			session.beginTransaction();
			Addresss address1 = new Addresss("OMR Road", "Chennai", "TN", "600097");
			Addresss address2 = new Addresss("Ring Road", "Banglore", "Karnataka", "560000");
			Students student1 = new Students("Eswar", address1);
			Students student2 = new Students("Joe", address2);
		
			session.save(student1);
			session.save(student2);
			
			session.getTransaction().commit();

		} catch (HibernateException e) {

			e.printStackTrace();
		} finally {
			session.close();
		}

	}

}