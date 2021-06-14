package es.soteck.uoc.iscsd.pra2.ejb.bean;

import es.soteck.uoc.iscsd.pra2.ejb.pojo.CategoryVO;

import javax.ejb.Remote;
import java.util.List;

@Remote
public interface CategoryRemote {

	CategoryVO add(String name, String description);

	List<CategoryVO> list();

	void delete(String name);

	CategoryVO update(String name, String description);

	CategoryVO findByName(String name);

}
