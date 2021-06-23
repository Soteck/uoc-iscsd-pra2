package es.soteck.uoc.iscsd.pra2.front;

import es.soteck.uoc.iscsd.pra2.ejb.bean.CategoryLocal;
import es.soteck.uoc.iscsd.pra2.ejb.pojo.CategoryVO;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@SessionScoped
@ManagedBean(name = "EditCategoryMB")
public class EditCategoryMB {

	@EJB
	private CategoryLocal categoryLocal;

	protected String categoryName = null;
	private CategoryVO category;

	public CategoryVO getCategory(){
		if(category == null || !category.getName().equals(categoryName)){
			category = categoryLocal.findByName(categoryName);
		}
		return category;
	}

	public void setCategory(CategoryVO category) {
		this.category = category;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

    public Object actualizarCategoria() {
		categoryLocal.update(category.getName(), category.getDescription());
		this.categoryName = null;
		this.category = null;
		return "listCategoryView.xhtml";
    }
}
