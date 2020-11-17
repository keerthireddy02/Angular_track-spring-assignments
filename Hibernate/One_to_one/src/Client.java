
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
			Employee emp1=new Employee(3,"keerthi","Reddy",4000);
			emp1.setAddress(add1);
			client_1.insertData(emp1,add1);
			
			Address add2=new Address("orlando","Florida", "USA","213");
			Employee emp2=new Employee(3,"Sheldon","Cooper",8000);
			emp2.setAddress(add2);
			client_1.insertData(emp2,add2);
			
			client_1.displayRecords();
		}
		catch (HibernateException e) {
			System.out.println("Exception is : " + e);
		}
	}
		public void insertData(Employee empObj, Address addObj) throws HibernateException
		{
			Session session = factory.openSession();
			Transaction tx = session.beginTransaction();
			
			session.save(empObj);
			session.save(addObj);
			tx.commit();
			System.out.println("employess and address are inserted in database..");
			session.close();
			
		}
	
	public void displayRecords() throws HibernateException{
		Session session = factory.openSession();
		List employees = session.createQuery("FROM Employee").list();
		for (Iterator iterator = employees.iterator(); iterator.hasNext();) {
			
			Employee emp = (Employee) iterator.next();
			System.out.print("First Name: " + emp.getFirstName());
			System.out.print("Last Name: " + emp.getLastName());
			System.out.println(" Salary: " + emp.getSalary());
			Address add=emp.getAddress();
			System.out.println("Address");
			System.out.println("Street :"+add.getStreet());
			System.out.println("City :"+add.getCity());
			System.out.println("State :"+add.getState());
			System.out.println("Zipcode :"+add.getZipcode());
		}
		
		session.close();
		
	}
	
	public void DisplayRecords_NativeSQL() throws HibernateException
	{
		Session session = factory.openSession();
		String sql = "SELECT * FROM hibernate_create_insert_update_delete where salary > 8000" ;
		SQLQuery query = session.createSQLQuery(sql);
		query.addEntity(Employee.class);
		List results = query.list();
		
		for (Iterator iterator =
				results.iterator(); iterator.hasNext();) {
			Employee emp = (Employee) iterator.next();
			System.out.print("First Name: " + emp.getFirstName());
			System.out.print("Last Name: " + emp.getLastName());
			System.out.print("Salary: " + emp.getSalary());
			
		}
		session.close();
	}
	
	
	public void UpdateRecord(Integer EmpId, int salary) throws HibernateException
	{
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		
		Employee employee = (Employee )session.get(Employee.class, EmpId);
		employee.setSalary(salary);
		tx.commit();
		
		session.close();
		
	}
	public void DeleteRecord(Integer EmployeeID) throws HibernateException
	{
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		
		Employee employee = (Employee )session.get(Employee.class, EmployeeID);
		session.delete(employee);
		tx.commit();
		
		session.close();
		
	}
	
	
}