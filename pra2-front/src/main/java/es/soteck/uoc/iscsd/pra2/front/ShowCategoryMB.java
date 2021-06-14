package es.soteck.uoc.iscsd.pra2.front;

import es.soteck.uoc.iscsd.pra2.ejb.bean.CategoryLocal;
import es.soteck.uoc.iscsd.pra2.ejb.pojo.CategoryVO;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@SessionScoped
@ManagedBean(name = "ShowCategoryMB")
public class ShowCategoryMB {

	@EJB
	private CategoryLocal categoryLocal;

	protected String categoryName = null;

	public CategoryVO getCategory(){
		return categoryLocal.findByName(categoryName);
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
}
