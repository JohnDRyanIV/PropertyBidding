package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import model.Bidder;

public class BidderHelper {
	
	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("WebPropertyBidding");
	
	public void insertBidder(Bidder b) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(b);
		em.getTransaction().commit();
		em.close();
	}
	
	public List<Bidder> showAllBidders() {
		EntityManager em = emfactory.createEntityManager();
		List<Bidder> allBidders = em.createQuery("SELECT b FROM Bidder b").getResultList();
		return allBidders;
	}
	
	// Not used in program, bidder information is always kept on file. All that matters is deleting bids
	public void deleteBidder(Bidder toDelete) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Bidder> typedQuery = em.createQuery("select b from Bidder b where b.name = :selectedName", Bidder.class);
		
		// Substitute parameter with actual data from bidder item
		typedQuery.setParameter("selectedName", toDelete.getName());
		
		// only one result
		Bidder result = typedQuery.getSingleResult();
		
		// remove
		em.remove(result);
		em.getTransaction().commit();
		em.close();
	}
	
	public void updateBidder(Bidder toEdit) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		
		em.merge(toEdit);
		em.getTransaction().commit();
		em.close();
	}
	
	public List<Bidder> searchForBidderByName(String bidderName) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Bidder> typedQuery = em.createQuery("select b from Bidder b where b.name = :selectedName", Bidder.class);
		typedQuery.setParameter("selectedName", bidderName);
		List<Bidder> foundBidders = typedQuery.getResultList();
		em.close();
		return foundBidders;
	}
	
	public Bidder searchForBidderById(int idToEdit) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		Bidder found = em.find(Bidder.class, idToEdit);
		em.close();
		return found;
	}
	
	public void cleanUp() {
		emfactory.close();
	}

}
