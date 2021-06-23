package es.soteck.uoc.iscsd.pra2.front;

import es.soteck.uoc.iscsd.pra2.ejb.bean.CategoryLocal;
import es.soteck.uoc.iscsd.pra2.ejb.pojo.CategoryVO;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@SessionScoped
@ManagedBean(name = "AddCategoryMB")
public class AddCategoryMB {

    @EJB
    private CategoryLocal categoryLocal;

    private CategoryVO category = new CategoryVO();

    public CategoryVO getCategory() {
        return category;
    }

    public void setCategory(CategoryVO category) {
        this.category = category;
    }

    public String anadirCategoria() {
        categoryLocal.add(category.getName(), category.getDescription());
        category = new CategoryVO();
        return "listCategoryView.xhtml";
    }
}
