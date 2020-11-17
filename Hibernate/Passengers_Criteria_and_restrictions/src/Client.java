


import java.util.Iterator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;
import org.hibernate.service.ServiceRegistry;



public class Client {
	private static SessionFactory factory;

	public static void getSessionFactory() {
		try {
			Configuration configuration = new Configuration().configure();
	        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
	        factory = configuration.buildSessionFactory(serviceRegistry);		
		}catch(Throwable ex) {
			System.err.println("Failed to create sessionFactory object" +ex);
			throw new ExceptionInInitializerError(ex);
		}
	}
	public static void main(String[] args) throws InterruptedException {
		getSessionFactory();
		Client client_1 = new Client();
		
		Passenger in=new Passenger(1,"keerthi",211,25);
		client_1.insertData(in);
		Passenger in1=new Passenger(2,"Taqueeuddin",312,18);
		client_1.insertData(in1);
		Passenger in2=new Passenger(3,"Harshitha",211,10);
		client_1.insertData(in2);
		Passenger in3=new Passenger(4,"sheldon",123,20);
		client_1.insertData(in3);
		Passenger in4=new Passenger(5,"vivek",234,22);
		client_1.insertData(in4);
		
		client_1.displayRecords();
		client_1.DisplayRecords2();
		
	}
	public void displayRecords() throws InterruptedException {
		// TODO Auto-generated method stub
		Session session=factory.openSession();
		List passengers=session.createQuery("FROM Passenger").list();
		for(Iterator it=passengers.iterator(); it.hasNext();) {
			Passenger p=(Passenger)it.next();
			System.out.println("Passenger ID:"+p.getPId());
			System.out.println("Passenger name:"+p.getPassName());
			System.out.println("train Number:"+p.getTrainNo());
			System.out.println("Age:"+p.getAge());
			
			
			
		}
		session.close();
	}
	private void insertData(Passenger pObj) {
		// TODO Auto-generated method stub
		Session session=factory.openSession();
		Transaction tx=session.beginTransaction();
		session.save(pObj);
		tx.commit();
		System.out.println("Passenger and Train_details are inserted in db");
		session.close();
		
	}
	/* Display based on a criteria*/
	public void DisplayRecords2() throws HibernateException {
		Session session = factory.openSession();
		Criteria cr = session.createCriteria(Passenger.class);
		
		cr.add(Restrictions.gt("age", 10));
		List passenger = cr.list();
		
		for (Iterator iterator = passenger.iterator(); iterator.hasNext();) {
			Passenger p=(Passenger)iterator.next();
			System.out.println("Passenger ID:"+p.getPId());
			System.out.println("Passenger name:"+p.getPassName());
			System.out.println("train Number:"+p.getTrainNo());
			System.out.println("Age:"+p.getAge());
		}
		
	}


}
