/**
 * 
 */
package gr.ekt.cerif.services.second;

import gr.ekt.cerif.entities.second.Prize;

import org.springframework.data.repository.CrudRepository;

/**
 * A repository for prizes.
 * 
 */
public interface PrizeRepository extends CrudRepository<Prize, String> {

}
