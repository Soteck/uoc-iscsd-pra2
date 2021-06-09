package es.soteck.uoc.iscsd.pra2.ejb.repository;

import es.soteck.uoc.iscsd.pra2.ejb.base.BaseRepository;
import es.soteck.uoc.iscsd.pra2.ejb.entity.Category;

import javax.ejb.Local;

@Local
public interface CategoryRepositoryInterface extends BaseRepository<Category> {
}
