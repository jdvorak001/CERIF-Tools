/**
 * 
 */
package gr.ekt.cerif.services.second;

import gr.ekt.cerif.entities.second.Indicator;

import org.springframework.data.repository.CrudRepository;

/**
 * A repository for indicators.
 * 
 */
public interface IndicatorRepository extends CrudRepository<Indicator, String> {

}
