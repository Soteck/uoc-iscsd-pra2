package es.soteck.uoc.iscsd.pra2.ejb.bean;

import es.soteck.uoc.iscsd.pra2.ejb.pojo.CategoryVO;

import javax.ejb.Local;
import java.util.List;

@Local
public interface CategoryLocal {

	CategoryVO add(String name, String description);

	List<CategoryVO> list();

	void delete(String name);

	CategoryVO update(String name, String description);

	CategoryVO findByName(String name);


}
