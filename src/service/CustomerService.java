package service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import model.Account;
import model.CustomerDetail;
import model.CustomerPfm;
import model.CustomerPfmPK;
import model.Login;

import bean.CustomerBean;

public class CustomerService {
	
	EntityManagerFactory emf= Persistence.createEntityManagerFactory("PMS");
	EntityManager em= emf.createEntityManager();
	EntityTransaction et = em.getTransaction();

	public String save(CustomerBean bean) {
		// TODO Auto-generated method stub
		
		CustomerDetail cd= new CustomerDetail();
		cd.setAccountNumber(bean.getAccountNumber());
		cd.setAddress(bean.getAddress());
		cd.setAnswer(bean.getAnswer());
		cd.setContactNumber(bean.getContactNumber());
		cd.setUsername(bean.getUsername());
		cd.setCustomerName(bean.getCustomerName());
		cd.setStatus("d");
		Login login=new Login();
		login.setPassword(bean.getPassword());
		login.setRole("c");
		login.setUsername(bean.getUsername());
		Account a= new Account();
		a.setAccountNumber(bean.getAccountNumber());
		a.setBalance(0.0f);
		et.begin();
		em.merge(cd);
		em.merge(login);
		em.merge(a);
		et.commit();
		return "success";
	}

	public List<CustomerDetail> getInactiveCustomer() {
		// TODO Auto-generated method stub
		
		Query q = em.createQuery("select c from CustomerDetail c where c.status=?1");
		q.setParameter(1, "d");
		@SuppressWarnings("unchecked")
		List<CustomerDetail> cd= q.getResultList();
		
		return cd;
	}
	
	public List<CustomerDetail> getAllCustomer(){
		Query q = em.createQuery("select c from CustomerDetail c");
		@SuppressWarnings("unchecked")
		List<CustomerDetail> cd= q.getResultList();
		
		return cd;
	}
	
	public String activate(int id)
	{
		CustomerDetail cust = em.find(CustomerDetail.class, id);
		if(cust==null)
			return "fail";
		else{
			cust.setStatus("a");
			et.begin();
			em.merge(cust);
			et.commit();
			return "success";
		}		
	}
	
	public String resetPassword(CustomerBean bean)
	{
		Login log= em.find(Login.class, bean.getUsername());
		if(log!=null)
		{
			log.setPassword(bean.getPassword());
			et.begin();
			em.merge(log);
			et.commit();
			return "success";
		}		
		else 
			return "fail";
	}

	public String deactivate(int cid) {
		// TODO Auto-generated method stub
		CustomerDetail cust = em.find(CustomerDetail.class, cid);
		
		if(cust!=null)
		{
			CustomerPfmPK pk=new  CustomerPfmPK();
			
			pk.setCustUser(cid);
			
			Query query=em.createQuery("select cp from CustomerPfm cp where cp.id.custUser=?1");
			query.setParameter(1, cid);
			CustomerPfm customerPfm=(CustomerPfm) query.getSingleResult();
			
			Login log=em.find(Login.class, cust.getUsername());
			Account acc= em.find(Account.class,cust.getAccountNumber());
			System.out.println(log.getUsername());
			System.out.println(acc.getAccountNumber());
			et.begin();
			System.out.println(cust.getAccountNumber());
			System.out.println(1);
			String accno= cust.getAccountNumber();
			System.out.println(accno);
			em.remove(customerPfm);
			em.remove(cust);
			em.remove(log);
			em.remove(acc);
			et.commit();
			return "success";
		}
		else 
		{
			return "fail";
		}
	}
	
	public CustomerDetail getcustDetail(String username)
	{
		Query q =em.createQuery("Select c from CustomerDetail c where c.username=?1");
		q.setParameter(1, username);
		CustomerDetail cd=(CustomerDetail)q.getSingleResult();
		return cd;
	}

	public void update(CustomerBean bean) {
		// TODO Auto-generated method stub
		CustomerDetail detail= new CustomerDetail();
		detail.setAccountNumber(bean.getAccountNumber());
		detail.setAddress(bean.getAddress());
		detail.setAnswer(bean.getAnswer());
		detail.setContactNumber(bean.getContactNumber());
		detail.setCustomerName(bean.getCustomerName());
		detail.setId(Integer.parseInt(bean.getCustId()));
		detail.setStatus("a");
		detail.setUsername(bean.getUsername());
		Login login=new Login();
		login.setUsername(bean.getUsername());
		login.setRole("c");
		login.setPassword(bean.getPassword());
		et.begin();
		em.merge(detail);
		em.merge(login);
		et.commit();
	}

	public CustomerDetail retreiveVal(String username) {
		// TODO Auto-generated method stub
		System.out.println(username);
		Query q=em.createQuery("Select c from CustomerDetail c where c.username= ?1");
		q.setParameter(1, username);
		CustomerDetail detail= (CustomerDetail) q.getSingleResult();
		return detail;
	}
}