package es.soteck.uoc.iscsd.pra2.ejb.bean;


import es.soteck.uoc.iscsd.pra2.ejb.entity.Category;
import es.soteck.uoc.iscsd.pra2.ejb.pojo.CategoryVO;
import es.soteck.uoc.iscsd.pra2.ejb.repository.CategoryRepositoryInterface;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.util.ArrayList;
import java.util.List;

@Stateless
public class CategoryBean implements CategoryLocal, CategoryRemote {

	@EJB
	private CategoryRepositoryInterface categoryRepository;

	@Override
	public CategoryVO add(String name, String description) {
		Category category = new Category();
		category.setName(name);
		category.setDescription(description);
		return entityToVO(categoryRepository.add(category));
	}

	@Override
	public List<CategoryVO> list() {
		List<Category> data = categoryRepository.list();
		return entityToVO(data);
	}

	@Override
	public void delete(String name) {
		this.categoryRepository.delete(name);
	}

	@Override
	public CategoryVO update(String name, String description) {
		Category data = new Category();
		data.setDescription(description);
		return entityToVO(this.categoryRepository.update(name, data));
	}

	@Override
	public CategoryVO findByName(String name) {
		return entityToVO(this.categoryRepository.get(name));
	}

	private CategoryVO entityToVO(Category category) {
		CategoryVO ret = new CategoryVO();
		ret.setName(category.getName());
		ret.setDescription(category.getDescription());
		return ret;
	}

	private List<CategoryVO> entityToVO(List<Category> categories) {
		List<CategoryVO> ret = new ArrayList<>();
		for (Category cat : categories) {
			ret.add(this.entityToVO(cat));
		}
		return ret;
	}

}
