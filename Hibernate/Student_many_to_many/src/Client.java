
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;


public class Client {
	
	private static SessionFactory factory;
	
	public static void getSessionFactory() {
		
		try {
			Configuration conf = new Configuration().configure();
			StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(conf.getProperties());
			factory = conf.buildSessionFactory(builder.build());
		}
		
		catch(Throwable ex) {
			System.err.println("Failed to create Session Factory Object "+ex);	
			throw new ExceptionInInitializerError(ex);
		}
	}
	
	public static void main(String args[]) {
		try
		{
			getSessionFactory();
			Client c = new Client();
			Session session = factory.openSession();
			Transaction tx = session.beginTransaction();

			Student s1 = new Student(558, "Keerthi Reddy");
			Student s2 = new Student(458, "Vivek Satvik");
			Student s3 = new Student(123, "Sravanthi");
			Student s4 = new Student(544, "Meghana");
			
			Set<Student> hs1 = new HashSet<Student>();
			hs1.add(s1);
			hs1.add(s2);
			
			Set<Student> hs2 = new HashSet<Student>();
			hs2.add(s3);
			hs2.add(s4);
						
			Teacher t1 = new Teacher(1, "C", "Haritha", hs1);
			Teacher t2 = new Teacher(2, "C++", "Kranthi", hs2);
			Teacher t3 = new Teacher(3, "Java", "Raj Shekhar",hs1);
			Teacher t4 = new Teacher(4, "Python", "Suresh", hs2);

			//session.save(t1);
			//session.save(t2);
			//session.save(t3);
			//session.save(t4);
			
			tx.commit();
			c.displayRecords();
			
		}
		catch(HibernateException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void displayRecords() throws HibernateException{
		Session session = factory.openSession();
		List tchList = session.createQuery("From Teacher").list();
		display(tchList);
		session.close();
	}
	
	public void display(List obj) {
		for(Iterator iterator = obj.iterator(); iterator.hasNext();) {
			Teacher clg = (Teacher) iterator.next();
			System.out.println("Students studying under "+clg.getName()+":\n");
			Set<Student> std = clg.getStd();
			Iterator it = std.iterator();
			while(it.hasNext()) {
				System.out.println(it.next().toString());
			}
		}
	}
	
	
}