package es.soteck.uoc.iscsd.pra2.ejb.bean;


import es.soteck.uoc.iscsd.pra2.ejb.repository.CategoryRepositoryInterface;

import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless
public class CategoryBean implements CategoryLocal, CategoryRemote {

	@EJB
	private CategoryRepositoryInterface categoryRepository;
}
