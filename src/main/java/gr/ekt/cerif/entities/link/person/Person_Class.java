/**
 * 
 */
package gr.ekt.cerif.entities.link.person;

import gr.ekt.cerif.features.semantics.Class;
import gr.ekt.cerif.entities.base.Person;
import gr.ekt.cerif.entities.link.CerifLinkEntity;
import gr.ekt.cerif.pk.person.Person_ClassId;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Links an person with a class.
 * 
 */
@Entity
@Table(name="cfPers_Class")
@IdClass(Person_ClassId.class)
public class Person_Class implements CerifLinkEntity {
	
	/**
	 * Serialization version.
	 */
	private static final long serialVersionUID = -2556507434557546L;
	
	/**
	 * The person.
	 */
	@Id
	@ManyToOne 
	@JoinColumn(name="cfPersId")
	private Person person;
	
	/**
	 * The class.
	 */
	@Id
	@ManyToOne
	@JoinColumn(name="cfClassId")	
	private Class theClass;
	
	/**
	 * The start date.
	 */
	@Id
	@Column (name="cfStartDate")
	private Date startDate;
	
	/**
	 * The end date.
	 */
	@Id
	@Column (name="cfEndDate")
	private Date endDate;
	
	/**
	 * The fraction.
	 */
	@Column(name="cfFraction")
	private Double fraction;
	

	/**
	 * Returns the person.
	 * @return the person.
	 */
	public Person getPerson() {
		return person;
	}

	/**
	 * Sets the person.
	 * @param person the person.
	 */
	public void setPerson(Person person) {
		this.person = person;
	}
	
	/**
	 * @return the theClass
	 */
	public Class getTheClass() {
		return theClass;
	}

	/**
	 * @param theClass the theClass to set
	 */
	public void setTheClass(Class theClass) {
		this.theClass = theClass;
	}
	
	/**
	 * Returns the start date.
	 * @return the start date.
	 */
	public Date getStartDate() {
		return startDate;
	}

	/**
	 * Sets the start date.
	 * @param startDate the start date.
	 */
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	/**
	 * Returns the end date.
	 * @return the end date.
	 */
	public Date getEndDate() {
		return endDate;
	}

	/**
	 * Sets the end date.
	 * @param endDate the end date.
	 */
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	/**
	 * Returns the fraction.
	 * @return the fraction.
	 */
	public Double getFraction() {
		return fraction;
	}

	/**
	 * Sets the fraction.
	 * @param fraction the fraction.
	 */
	public void setFraction(Double fraction) {
		this.fraction = fraction;
	}
}
