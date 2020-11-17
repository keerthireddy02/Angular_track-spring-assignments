import java.util.Iterator;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
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
		
		Insurance in=new Insurance(1,"ACCIDENT_TERM",2,40000);
		//client_1.insertData(in);
		//Insurance in1=new Insurance(4,"PARENT_TERM",5,200000);
		//client_1.insertData(in1);
		Insurance in2=new Insurance(5,"SHORT_TERM",1,500000);
		//client_1.insertData(in2);
		//Insurance in3=new Insurance(6,"LONG_TERM",5,600000);
		//client_1.insertData(in3);
		//client_1.displayRecords();
		//client_1.UpdateRecord(1, 300000);
		client_1.displayRecords();
		client_1.deleteRecord(7);
		//client_1.displayRecords();
	}
	public void displayRecords() throws InterruptedException {
		// TODO Auto-generated method stub
		Session session=factory.openSession();
		List customer=session.createQuery("FROM Insurance").list();
		for(Iterator it=customer.iterator(); it.hasNext();) {
			Insurance cust=(Insurance)it.next();
			System.out.println("Policy:"+cust.getPolicy());
			System.out.println("Policy name:"+cust.getPName());
			System.out.println("amount:"+cust.getAmount());
			System.out.println("tenure:"+cust.getTenure());
			
		}
		session.close();
	}
	private void insertData(Insurance custObj) {
		// TODO Auto-generated method stub
		Session session=factory.openSession();
		Transaction tx=session.beginTransaction();
		session.save(custObj);
		tx.commit();
		System.out.println("Employee and address are inserted in db");
		session.close();
		
	}
	
	public void UpdateRecord(Integer policyNo, int amt) throws HibernateException
	{
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		
		Insurance cust = (Insurance)session.get(Insurance.class, policyNo);
		cust.setAmount(amt);
		tx.commit();
		
		session.close();
		
	}
	
	public void deleteRecord(Integer policyNo) throws HibernateException
	{
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		
		Insurance cust = (Insurance)session.get(Insurance.class, policyNo);
		session.delete(cust);
		tx.commit();
		
		session.close();
		
	}

}