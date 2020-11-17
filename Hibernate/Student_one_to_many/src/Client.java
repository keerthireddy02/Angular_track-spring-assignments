
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

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
			
			Set<Student> students=new HashSet<>();
			Student stu1=new Student("keerthi","Reddy","cse");
			Student stu2=new Student("Sheldon","Cooper","eee");
			Student stu3=new Student("Sheldon","Cooper","eee");
			students.add(stu1);
			students.add(stu2);
			students.add(stu3);
			
			College clg1= new College("VNR","Washington DC", "USA","222",students);
			//client_1.insertData(clg1);
		
			/*stu2.setCollege(c1);
			client_1.insertData(stu2,clg1);
			
			College clg2=new College("GRIET","Hyderabad","Telangana","123");
			Set<College> c2=new HashSet<College>();
			stu3.setCollege(c2);
			client_1.insertData(stu2,clg2);
			*/
			client_1.displayRecords();
		}
		catch (HibernateException e) {
			System.out.println("Exception is : " + e);
		}
	}
		public void insertData(College clgObj) throws HibernateException
		{
			Session session = factory.openSession();
			Transaction tx = session.beginTransaction();
			session.save(clgObj);
			tx.commit();
			System.out.println("Students & Colleges are inserted in database..");
			session.close();
			
		}
	
/*	public void displayRecords() throws HibernateException{
		Session session = factory.openSession();
		List students = session.createQuery("FROM Student").list();
		for (Iterator iterator = students.iterator(); iterator.hasNext();) {
			
			Student stu = (Student) iterator.next();
			System.out.print("First Name: " + stu.getFirstName());
			System.out.print("Last Name: " + stu.getLastName());
			System.out.println(" Branch: " + stu.getBranch());
			College add=stu.getCollege();
			System.out.println("Address");
			System.out.println("College Name :"+add.getName());
			System.out.println("City :"+add.getCity());
			System.out.println("State :"+add.getState());
			System.out.println("Zipcode :"+add.getZipcode());
		}
		
		session.close();
		
	}  */
		public void displayRecords() throws HibernateException{
			Session session = factory.openSession();
			List tchList = session.createQuery("From College").list();
			display(tchList);
			session.close();
		}
		
		public void display(List obj) {
			for(Iterator iterator = obj.iterator(); iterator.hasNext();) {
				College clg = (College) iterator.next();
				System.out.println("Students studying under "+clg.getName()+":\n");
				Set<Student> std = clg.getStudents();
				Iterator it = std.iterator();
				while(it.hasNext()) {
					System.out.println(it.next().toString());
				}
			}
	
		}
	
	
}