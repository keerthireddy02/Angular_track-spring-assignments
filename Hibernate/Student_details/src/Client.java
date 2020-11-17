
import java.util.Iterator;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class Client{
	private static SessionFactory factory;
	
	
	public static void getSessionFactory() {
		
		try {
			Configuration conf = new Configuration().configure();
			StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(conf.getProperties());
			factory= conf.buildSessionFactory(builder.build()); 
		}
		catch (Throwable ex) {
			System.err.println("Failed to create sessionFactory object."+ ex);
			throw new ExceptionInInitializerError(ex);
		}
	}
	
	
	public static void main(String[] args) {
		
		
		try {
			
			getSessionFactory();
			Client client_1 = new Client();
			/*
			client_1.InsertRecordInDatabase(1,"Rohit", "p", 7000);
			client_1.InsertRecordInDatabase(2,"Surya", "N", 5000);
			client_1.InsertRecordInDatabase(3,"Charan", "K", 7000);
			client_1.InsertRecordInDatabase(4,"Chandu", "D", 7000);
			client_1.InsertRecordInDatabase(5,"Hardik", "p", 7000);
			client_1.InsertRecordInDatabase(6,"Rahul", "p", 7000);
			client_1.InsertRecordInDatabase(7,"Bharath", "p", 8000);
			
			
			System.out.println("Listing employees..");
			client_1.DisplayRecords();
			
			System.out.println("Updated the record..");
			client_1.UpdateRecord(1, 8000);
			client_1.DisplayRecords();
			
			System.out.println("Displaying data using Native SQL..");
			client_1.DisplayRecords_NativeSQL();
			
			System.out.println("Deleting the 3rd record...");
			client_1.DeleteRecord(5);
			
			client_1.DisplayRecords();
			*/
			
			Address add1=new Address("Flemingo Road","Washington DC", "USA","222");
			Student stu1=new Student(3,"keerthi","Reddy","cse");
			stu1.setAddress(add1);
			client_1.insertData(stu1,add1);
			
			Address add2=new Address("orlando","Florida", "USA","213");
			Student stu2=new Student(3,"Sheldon","Cooper","eee");
			stu2.setAddress(add2);
			client_1.insertData(stu2,add2);
			
			client_1.displayRecords();
		}
		catch (HibernateException e) {
			System.out.println("Exception is : " + e);
		}
	}
		public void insertData(Student stuObj, Address addObj) throws HibernateException
		{
			Session session = factory.openSession();
			Transaction tx = session.beginTransaction();
			
			session.save(stuObj);
			session.save(addObj);
			tx.commit();
			System.out.println("employess and address are inserted in database..");
			session.close();
			
		}
	
	public void displayRecords() throws HibernateException{
		Session session = factory.openSession();
		List students = session.createQuery("FROM Student").list();
		for (Iterator iterator = students.iterator(); iterator.hasNext();) {
			
			Student stu = (Student) iterator.next();
			System.out.print("First Name: " + stu.getFirstName());
			System.out.print("Last Name: " + stu.getLastName());
			System.out.println(" Branch: " + stu.getBranch());
			Address add=stu.getAddress();
			System.out.println("Address");
			System.out.println("Street :"+add.getStreet());
			System.out.println("City :"+add.getCity());
			System.out.println("State :"+add.getState());
			System.out.println("Zipcode :"+add.getZipcode());
		}
		
		session.close();
		
	}
	
	
	
	
}