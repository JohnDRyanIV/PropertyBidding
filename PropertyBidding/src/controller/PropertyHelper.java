package controller;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import model.Property;

public class PropertyHelper {

	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("WebPropertyBidding");
	
	public void insertProperty(Property p) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(p);
		em.getTransaction().commit();
		em.close();
	}
	
	public List<Property> showAllProperties() {
		EntityManager em = emfactory.createEntityManager();
		List<Property> allProperties = em.createQuery("SELECT p FROM Property p").getResultList();
		return allProperties;
	}
	
	// Sells the property at the current date
	public void sellProperty(Property toSell) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		toSell.sellProperty();
		em.merge(toSell);
		em.getTransaction().commit();
		em.close();
	}
	
	public void deleteProperty(Property toDelete) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		// Might also need to add date here, if query plays nice with possibly null values
		TypedQuery<Property> typedQuery = em.createQuery("SELECT p FROM Property p WHERE p.address = :selectedAddress AND p.city = :selectedCity AND p.state = :selectedState AND p.zip = :selectedZip", Property.class);
		
		// Substitute parameter with actual data from the toDelete item
		typedQuery.setParameter("selectedAddress", toDelete.getAddress());
		typedQuery.setParameter("selectedCity", toDelete.getCity());
		typedQuery.setParameter("selectedState", toDelete.getState());
		typedQuery.setParameter("selectedZip", toDelete.getZip());
		
		// max 1 result
		typedQuery.setMaxResults(1);
		
		// get result and save it
		Property result = typedQuery.getSingleResult();
		
		em.remove(result);
		em.getTransaction().commit();
		em.close();
		
	}
	
	public void updateProperty(Property toEdit) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.merge(toEdit);
		em.getTransaction().commit();
		em.close();
	}
	
	public List<Property> searchForPropertyByAddress(String address) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Property> typedQuery = em.createQuery("SELECT p FROM Property p WHERE p.address = :selectedAddress", Property.class);
		typedQuery.setParameter("selectedAddress", address);
		List<Property> foundItems = typedQuery.getResultList();
		em.close();
		return foundItems;
	}
	
	public List<Property> searchForPropertyByCity(String city) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Property> typedQuery = em.createQuery("SELECT p FROM Property p WHERE p.city = :selectedCity", Property.class);
		typedQuery.setParameter("selectedCity", city);
		List<Property> foundItems = typedQuery.getResultList();
		em.close();
		return foundItems;
	}
	
	public List<Property> searchForPropertyByState(String state) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Property> typedQuery = em.createQuery("SELECT p FROM Property p WHERE p.state = :selectedState", Property.class);
		typedQuery.setParameter("selectedState", state);
		List<Property> foundItems = typedQuery.getResultList();
		em.close();
		return foundItems;
	}
	
	public List<Property> searchForPropertyByZip(String zip) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Property> typedQuery = em.createQuery("SELECT p FROM Property p WHERE p.zip = :selectedZip", Property.class);
		typedQuery.setParameter("selectedZip", zip);
		List<Property> foundItems = typedQuery.getResultList();
		em.close();
		return foundItems;
	}
	
	public List<Property> searchForPropertyByDateSold(LocalDate sold) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Property> typedQuery = em.createQuery("SELECT p FROM Property p WHERE p.dateSold = :selectedDateSold", Property.class);
		typedQuery.setParameter("selectedDateSold", sold);
		List<Property> foundItems = typedQuery.getResultList();
		em.close();
		return foundItems;
	}
	
	public Property searchForPropertyById(int idToEdit) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		Property found = em.find(Property.class, idToEdit);
		em.close();
		return found;
	}
	
	public void cleanUp() {
		emfactory.close();
	}
}
