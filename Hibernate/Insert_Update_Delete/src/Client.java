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
			client_1.DeleteRecord(3);
			
			client_1.DisplayRecords();
		}
		catch (HibernateException e) {
			System.out.println("Exception is : " + e);
		}
	}
		public void InsertRecordInDatabase (int id, String fname, String lname, int salary) throws HibernateException
		{
			Session session = factory.openSession();
			Transaction tx = session.beginTransaction();
			
			Employee e1 = new Employee(id, fname, lname, salary);
			session.save(e1);
			tx.commit();
			
			session.close();
			
		}
	
	public void DisplayRecords() throws HibernateException{
		Session session = factory.openSession();
		List empList = session.createQuery("FROM Employee").list();
		for (Iterator iterator = empList.iterator(); iterator.hasNext();) {
			
			Employee emp = (Employee) iterator.next();
			System.out.print("First Name: " + emp.getFirstName());
			System.out.print("Last Name: " + emp.getLastName());
			System.out.println(" Salary: " + emp.getSalary());
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