package gr.ekt.cerif.services.link.result;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import gr.ekt.cerif.entities.link.result.ResultPublication_ResultProduct;
import gr.ekt.cerif.entities.result.ResultProduct;
import gr.ekt.cerif.entities.result.ResultPublication;

@Component
public class LinkResultPublicationResultProductRepositoryImpl implements
		LinkResultPublicationResultProductRepository {
	
	private static final Logger log = LoggerFactory.getLogger(LinkResultPublicationResultProductRepositoryImpl.class);
	
	@Autowired
	private LinkResultPublicationResultProductCrudRepository linkResultPublicationResultProductCrudRepository;

	@Override
	public void delete(ResultPublication_ResultProduct entity) {
		linkResultPublicationResultProductCrudRepository.delete(entity);
	}

	@Override
	public void delete(Iterable<ResultPublication_ResultProduct> entities) {
		linkResultPublicationResultProductCrudRepository.delete(entities);
	}

	@Override
	public Iterable<ResultPublication_ResultProduct> save(
			Iterable<ResultPublication_ResultProduct> entities) {
		return linkResultPublicationResultProductCrudRepository.save(entities);
	}

	@Override
	public ResultPublication_ResultProduct save(
			ResultPublication_ResultProduct entity) {
		return linkResultPublicationResultProductCrudRepository.save(entity);
	}

	@Override
	public List<ResultPublication_ResultProduct> findByResultPublication(
			ResultPublication resultPublication) {
		return linkResultPublicationResultProductCrudRepository.findByResultPublication(resultPublication);
	}

	@Override
	public List<ResultPublication_ResultProduct> findByResultProduct(
			ResultProduct resultProduct) {
		return linkResultPublicationResultProductCrudRepository.findByResultProduct(resultProduct);
	}

}
