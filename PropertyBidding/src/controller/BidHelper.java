package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.Bid;
import model.Bidder;
import model.Property;

public class BidHelper {

	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("PropertyBidding");
	
	// searchForBidById returns the Bid objects that
	// corresponds to the bid in the table
	// pointed to by primary key tempId
	public Bid searchForBidById(Integer tempId) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		Bid found = em.find(Bid.class, tempId);
		em.close();
		return found;
	}
	
	// searchForBidByBidder returns a List of Bid objects that
	// are associated with Bidder bidr
	public List<Bid> searchForBidByBidder(Bidder bidr) {
		
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		
		TypedQuery<Bid> typedQuery  = 
				em.createQuery("select bids from Bid bids where bids.bidder.getId()  = :selectedBidder", Bid.class);
		
		typedQuery.setParameter("selectedBidder", bidr.getId());
		
		List<Bid> result = typedQuery.getResultList();
		
		em.close();

		return result;
	}
	
	public List<Property> showAllProperties() {
		EntityManager em = emfactory.createEntityManager();
		List<Property> allProperties = em.createQuery("SELECT p FROM Property p").getResultList();
		return allProperties;
	}
	
	public List<Bidder> showAllBidders() {
		EntityManager em = emfactory.createEntityManager();
		List<Bidder> allBidders = em.createQuery("SELECT b FROM Bidder b").getResultList();
		return allBidders;
	}
	
	// searchForBidByProperty returns a List of Bid objects that
	// are associated with the Property prop
	public List<Bid> searchForBidByProperty(Property prop) {
		
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		
		TypedQuery<Bid> typedQuery  = 
				em.createQuery("select bids from Bid bids where bids.property.getId()  = :selectedProperty", Bid.class);
		
		typedQuery.setParameter("selectedProperty", prop.getId());
		
		List<Bid> result = typedQuery.getResultList();
		
		em.close();

		return result;
	}
	
	// showAllBids returns a List of Bid objects consisting
	// of the bids from the property bidding database
	public List<Bid> showAllBids() {
		
		EntityManager em = emfactory.createEntityManager();
		List<Bid> allBids = em.createQuery("SELECT i FROM Bid i").getResultList();
		return allBids;
	}
	
	// insertBid is executed to take in the bid parameter
	// and add it to the property bidding database table
	public void insertBid(Bid bd) {
		
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(bd);    // save the new score
		em.getTransaction().commit();
		em.close();
		
	}
	
	// updateBid merges changes made to a property bid
	// object back to the database instance
	public void updateBid(Bid bidToEdit) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.merge(bidToEdit);
		em.getTransaction().commit();
		em.close();
	}
}
