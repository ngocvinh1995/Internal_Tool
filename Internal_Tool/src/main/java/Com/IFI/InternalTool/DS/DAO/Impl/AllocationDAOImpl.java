package Com.IFI.InternalTool.DS.DAO.Impl;

import javax.persistence.EntityManagerFactory;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import Com.IFI.InternalTool.DS.DAO.AllocationDAO;
import Com.IFI.InternalTool.DS.Model.Allocation;
import Com.IFI.InternalTool.DS.Model.Employee;

@Repository("AllocationDAO")
@Transactional
public class AllocationDAOImpl implements AllocationDAO {
	
	@Autowired
	private EntityManagerFactory entityManagerFactory;
	@Override
	public boolean saveAllocation(Allocation allocation) {
		Session session = entityManagerFactory.unwrap(SessionFactory.class).openSession();
		Transaction tx = null;
		tx=session.beginTransaction();
		session.saveOrUpdate(allocation);
		tx.commit();
		session.close();
		return true;
	}
	@Override
	public boolean deleteAllocation(long allocation_id) {
		Session session = entityManagerFactory.unwrap(SessionFactory.class).openSession();
		Transaction tx = null;
		tx=session.beginTransaction();
		String hql = "Delete from Allocation where allocation_id=:allocation_id";
		Query query = session.createQuery(hql);
		query.setParameter("allocation_id", allocation_id);
		query.executeUpdate();
		tx.commit();
		session.close();
		return false;
	}
	@Override
	public Allocation getAllocationById(long allocation_id) {
		Session session = entityManagerFactory.unwrap(SessionFactory.class).openSession();
		String hql = "FROM Allocation where allocation_id=:allocation_id";
		Query query = session.createQuery(hql);
		query.setParameter("allocation_id", allocation_id);
		Allocation allocation = (Allocation) query.uniqueResult();
		session.close();
		return allocation;
	}
	
}