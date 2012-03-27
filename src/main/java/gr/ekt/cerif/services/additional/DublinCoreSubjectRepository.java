package gr.ekt.cerif.services.additional;

import gr.ekt.cerif.features.additional.DublinCoreSubject;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * A repository for dublin core subject.
 * 
 */
@Component
public class DublinCoreSubjectRepository {

	@PersistenceContext(unitName="cerif-persistence-unit")
	EntityManager entityManager;
	
	@Transactional
	public void save(DublinCoreSubject entity) {
		if (entity.getId() == null || entity.getScheme() == null || entity.getTranslation() == null || entity.getLanguage() == null) {
			throw new IllegalArgumentException("Please provide a dc, a translation and a language.");
		}
		
		entityManager.merge(entity);
	}
	
	@Transactional
	public void save(List<DublinCoreSubject> entityList) {
		for (DublinCoreSubject entity : entityList) {
			save(entity);
		}
	}
}

