/**
 * 
 */
package gr.ekt.cerif.entities.link.organisationunit;

import gr.ekt.cerif.entities.base.OrganisationUnit;
import gr.ekt.cerif.entities.link.CerifLinkEntity;
import gr.ekt.cerif.entities.result.ResultPatent;
import gr.ekt.cerif.features.semantics.Class;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;

/**
 * 
 */
@Entity
@Table(name="cfOrgUnit_ResPat", uniqueConstraints=@UniqueConstraint(columnNames={"cfOrgUnitId","cfResPatId","cfClassId","cfStartDate","cfEndDate"}))
public class OrganisationUnit_ResultPatent implements CerifLinkEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 93566753823439971L;

	/**
	 * 
	 */
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	/**
	 * The organisation unit.
	 */
	@ManyToOne(optional=false)
	@JoinColumn(name="cfOrgUnitId")
	private OrganisationUnit organisationUnit;
	
	/**
	 * The result patent.
	 */
	@ManyToOne(optional=false)
	@JoinColumn(name="cfResPatId")
	private ResultPatent resultPatent;
	
	/**
	 * The class.
	 */
	@ManyToOne(optional=false)
	@JoinColumn(name="cfClassId")	
	private Class theClass;
	
	/**
	 * The start date.
	 */
	@NotNull
	@Column (name="cfStartDate")
	private Date startDate;
	
	/**
	 * The end date.
	 */
	@NotNull
	@Column (name="cfEndDate")
	private Date endDate;
	
	/**
	 * The fraction.
	 */
	@Column(name="cfFraction")
	private Double fraction;

	/**
	 * The relative order between creators and/or contributors.
	 */
	@Column(name="cfOrder")
	private Integer order;
	
	/**
	 * Default Constructor
	 */
	public OrganisationUnit_ResultPatent() {
		
	}
	
	/**
	 * 
	 * @param organisationUnit
	 * @param resultPatent
	 * @param startDate
	 * @param endDate
	 * @param fraction
	 */
	public OrganisationUnit_ResultPatent(OrganisationUnit organisationUnit,
			ResultPatent resultPatent, Date startDate, Date endDate,
			Double fraction) {
		this.organisationUnit = organisationUnit;
		this.resultPatent = resultPatent;
		this.startDate = startDate;
		this.endDate = endDate;
		this.fraction = fraction;
	}

	/**
	 * @return the organisationUnit
	 */
	public OrganisationUnit getOrganisationUnit() {
		return organisationUnit;
	}

	/**
	 * @param organisationUnit the organisationUnit to set
	 */
	public void setOrganisationUnit(OrganisationUnit organisationUnit) {
		this.organisationUnit = organisationUnit;
	}

	/**
	 * @return the resultPatent
	 */
	public ResultPatent getResultPatent() {
		return resultPatent;
	}

	/**
	 * @param resultPatent the resultPatent to set
	 */
	public void setResultPatent(ResultPatent resultPatent) {
		this.resultPatent = resultPatent;
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
	 * @return the startDate
	 */
	public Date getStartDate() {
		return startDate;
	}

	/**
	 * @param startDate the startDate to set
	 */
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	/**
	 * @return the endDate
	 */
	public Date getEndDate() {
		return endDate;
	}

	/**
	 * @param endDate the endDate to set
	 */
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	/**
	 * @return the fraction
	 */
	public Double getFraction() {
		return fraction;
	}

	/**
	 * @param fraction the fraction to set
	 */
	public void setFraction(Double fraction) {
		this.fraction = fraction;
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * Returns the order.
	 * @return a number.
	 */
	public Integer getOrder() {
		return order;
	}
	
	/**
	 * Sets the order.
	 * @param order a number.
	 */
	public void setOrder(Integer order) {
		this.order = order;
	}
		
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "OrganisationUnit_ResultPatent [id=" + id
				+ ", organisationUnit=" + organisationUnit + ", resultPatent="
				+ resultPatent + ", theClass=" + theClass + ", startDate="
				+ startDate + ", endDate=" + endDate + ", fraction=" + fraction
				+ "]";
	}
	
}
