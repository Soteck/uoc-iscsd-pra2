package es.soteck.uoc.iscsd.pra2.ejb.repository;

import es.soteck.uoc.iscsd.pra2.ejb.entity.Category;

import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.io.Serializable;
import java.util.List;

@Stateless
@TransactionManagement
public class CategoryRepository implements CategoryRepositoryInterface {


	@PersistenceContext(unitName = "GAO-PU")
	private EntityManager em;


	@Override
	public Category add(Category data) {
		em.persist(data);
		em.flush();
		return data;
	}

	@Override
	public void delete(Serializable id) {
		Category data = this.get(id);
		em.remove(data);
	}

	@Override
	public Category update(Serializable id, Category data) {
		Category bddData = this.get(id);
//		bddData.setName(data.getName());
		bddData.setDescription(data.getDescription());
		em.flush();
		return bddData;
	}

	@Override
	public Category get(Serializable id) {
		return em.find(Category.class, id);
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Category> list() {
		Query query = em.createQuery("select c from Category c");
		return query.getResultList();
	}
}
