package es.soteck.uoc.iscsd.pra2.front;

import es.soteck.uoc.iscsd.pra2.ejb.bean.CategoryLocal;
import es.soteck.uoc.iscsd.pra2.ejb.pojo.CategoryVO;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.util.List;

@SessionScoped
@ManagedBean(name = "ListCategoriesMB")
public class ListCategoriesMB {

	@EJB
	private CategoryLocal categoryLocal;


	public List<CategoryVO> getCategories() {
		return categoryLocal.list();
	}

	public String listCategories() {
		return "listCategoryView.xhtml";
	}

}
