/**
 * 
 */
package gr.ekt.cerif.entities.result;

import gr.ekt.cerif.entities.link.organisationunit.OrganisationUnit_ResultPatent;
import gr.ekt.cerif.entities.link.person.Person_ResultPatent;
import gr.ekt.cerif.entities.link.project.Project_ResultPatent;
import gr.ekt.cerif.entities.link.result.ResultPatent_Class;
import gr.ekt.cerif.entities.link.result.ResultPatent_Equipment;
import gr.ekt.cerif.entities.link.result.ResultPatent_Facility;
import gr.ekt.cerif.entities.link.result.ResultPatent_Funding;
import gr.ekt.cerif.entities.link.result.ResultPatent_Indicator;
import gr.ekt.cerif.entities.link.result.ResultPatent_Measurement;
import gr.ekt.cerif.entities.link.result.ResultPatent_Medium;
import gr.ekt.cerif.entities.link.result.ResultPatent_ResultPatent;
import gr.ekt.cerif.entities.link.result.ResultPatent_Service;
import gr.ekt.cerif.entities.link.result.ResultProduct_ResultPatent;
import gr.ekt.cerif.entities.link.result.ResultPublication_ResultPatent;
import gr.ekt.cerif.entities.second.Country;
import gr.ekt.cerif.entities.second.FederatedIdentifier;
import gr.ekt.cerif.features.multilingual.ResultPatentAbstract;
import gr.ekt.cerif.features.multilingual.ResultPatentKeyword;
import gr.ekt.cerif.features.multilingual.ResultPatentTitle;
import gr.ekt.cerif.features.multilingual.ResultPatentVersionInfo;

import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * Represents a patent result entity.
 * 
 */
@Entity
@Table(name="cfResPat")
public class ResultPatent implements CerifResultEntity {
	
	/**
	 * Serialization version.
	 */
	private static final long serialVersionUID = -1523634389757097712L;

	/**
	 * The patent unique identifier.
	 */
	@Id
	@Column(name="cfResPatId")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;

	/**
	 * The patent country.
	 */
	@ManyToOne
	@JoinColumn(name="cfCountryCode")
	private Country country;
	
	/**
	 * The date of patent registration.
	 */
	@Deprecated
	@Column(name="cfRegistrDate")
	private Date registrationDate;

	/**
	 * The date of patent approval.
	 */
	@Deprecated
	@Column(name="cfApprovDate")
	private Date approvalDate;

	/**
	 * The patent number.
	 */
	@Deprecated
	@Column(name="cfPatentNum")
	private String number;
	
	/**
	 * The URI.
	 */
	@Column(name="cfURI")
	private String uri;
	
	/**
	 * The UUID.
	 */
	@Column(name="cfUUID")
	private String uuid;
	
	
	/**
	 * Multilingual.
	 */
	@OneToMany(mappedBy="resultPatent")
	private Set<ResultPatentTitle> resultPatentTitles;
	
	@OneToMany(mappedBy="resultPatent")
	private Set<ResultPatentAbstract> resultPatentAbstracts;
	
	@OneToMany(mappedBy="resultPatent")
	private Set<ResultPatentKeyword> resultPatentKeywords;
	
	@OneToMany(mappedBy="resultPatent")
	private Set<ResultPatentVersionInfo> resultPatentVersionInfos;
	
	
	/**
	 * Links.
	 */
	@OneToMany(mappedBy="resultPatent")
	private Set<Project_ResultPatent> projects_resultPatents;
	
	@OneToMany(mappedBy="resultPatent")
	private Set<Person_ResultPatent> persons_resultPatents;
	
	@OneToMany(mappedBy="resultPatent")
	private Set<ResultPatent_Class> resultPatents_classes;
	
	@OneToMany(mappedBy="resultPatent")
	private Set<ResultPatent_Funding> resultPatents_fundings;
	
	@OneToMany(mappedBy="resultPatent")
	private Set<ResultPatent_Indicator> resultPatents_indicators;
	
	@OneToMany(mappedBy="resultPatent")
	private Set<ResultPatent_Measurement> resultPatents_measurements;
	
	@OneToMany(mappedBy="resultPatent1")
	private Set<ResultPatent_ResultPatent> resultPatents_resultPatents1;

	@OneToMany(mappedBy="resultPatent2")
	private Set<ResultPatent_ResultPatent> resultPatents_resultPatents2;
	
	@OneToMany(mappedBy="resultPatent")
	private Set<ResultPublication_ResultPatent> resultPublications_resultPatents;
	
	@OneToMany(mappedBy="resultPatent")
	private Set<ResultPatent_Service> resultPatents_services;
	
	@OneToMany(mappedBy="resultPatent")
	private Set<ResultPatent_Equipment> resultPatents_equipments;
	
	@OneToMany(mappedBy="resultPatent")
	private Set<ResultPatent_Facility> resultPatents_facilities;
	
	@OneToMany(mappedBy="resultPatent")
	private Set<OrganisationUnit_ResultPatent> organisationUnits_resultPatents;
	
	@OneToMany(mappedBy="resultPatent")
	private Set<ResultPatent_Medium> resultPatents_mediums;
	
	@OneToMany(mappedBy="resultPatent")
	private Set<ResultProduct_ResultPatent> resultProducts_resultPatents;
	
	
	/**
	 * FederatedIdentifier entities related to ResultPatent instance.
	 */
	@Transient
	private List<FederatedIdentifier> federatedIdentifiers;
	
	//----------------------------------------------------------------------------------------------//

	/**
	 * Default Constructor
	 */
	public ResultPatent() {
		
	}
	
	/**
	 * 
	 * @param country
	 * @param registrationDate
	 * @param approvalDate
	 * @param number
	 * @param uri
	 * @param resultPatentTitles
	 * @param resultPatentAbstracts
	 * @param resultPatentKeywords
	 * @param resultPatentVersionInfos
	 */
	public ResultPatent(Country country, Date registrationDate,
			Date approvalDate, String number, String uri,
			Set<ResultPatentTitle> resultPatentTitles,
			Set<ResultPatentAbstract> resultPatentAbstracts,
			Set<ResultPatentKeyword> resultPatentKeywords,
			Set<ResultPatentVersionInfo> resultPatentVersionInfos) {
		this.country = country;
		this.registrationDate = registrationDate;
		this.approvalDate = approvalDate;
		this.number = number;
		this.uri = uri;
		this.resultPatentTitles = resultPatentTitles;
		this.resultPatentAbstracts = resultPatentAbstracts;
		this.resultPatentKeywords = resultPatentKeywords;
		this.resultPatentVersionInfos = resultPatentVersionInfos;
	}

	/**
	 * Returns the unique identifier.
	 * @return the unique identifier.
	 */
	public Long getId() {
		return id;
	}

	/**
	 * Sets the unique identifier.
	 * @param id the unique identifier.
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * Returns the country.
	 * @return the country.
	 */
	public Country getCountry() {
		return country;
	}

	/**
	 * Sets the country.
	 * @param country the country.
	 */
	public void setCountry(Country country) {
		this.country = country;
	}

	/**
	 * Returns the registration date.
	 * @return the registration date.
	 */
	public Date getRegistrationDate() {
		return registrationDate;
	}

	/**
	 * Sets the registration date.
	 * @param registrationDate the registration date.
	 */
	public void setRegistrationDate(Date registrationDate) {
		this.registrationDate = registrationDate;
	}

	/**
	 * Returns the approval date.
	 * @return the approval date.
	 */
	public Date getApprovalDate() {
		return approvalDate;
	}

	/**
	 * Sets the approval date.
	 * @param approvalDate the approval date.
	 */
	public void setApprovalDate(Date approvalDate) {
		this.approvalDate = approvalDate;
	}

	/**
	 * Returns the number.
	 * @return the number.
	 */
	public String getNumber() {
		return number;
	}

	/**
	 * Sets the number.
	 * @param number the number.
	 */
	public void setNumber(String number) {
		this.number = number;
	}

	/**
	 * Returns the URI.
	 * @return the URI.
	 */
	public String getUri() {
		return uri;
	}

	/**
	 * Sets the URI.
	 * @param uri the URI.
	 */
	public void setUri(String uri) {
		this.uri = uri;
	}	

	/**
	 * @return the uuid
	 */
	public String getUuid() {
		return uuid;
	}

	/**
	 * @param uuid the uuid to set
	 */
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public Set<ResultPatentTitle> getResultPatentTitles() {
		return resultPatentTitles;
	}

	public void setResultPatentTitles(Set<ResultPatentTitle> resultPatentTitles) {
		this.resultPatentTitles = resultPatentTitles;
	}

	public Set<ResultPatentAbstract> getResultPatentAbstracts() {
		return resultPatentAbstracts;
	}

	public void setResultPatentAbstracts(Set<ResultPatentAbstract> resultPatentAbstracts) {
		this.resultPatentAbstracts = resultPatentAbstracts;
	}

	public Set<ResultPatentKeyword> getResultPatentKeywords() {
		return resultPatentKeywords;
	}

	public void setResultPatentKeywords(Set<ResultPatentKeyword> resultPatentKeywords) {
		this.resultPatentKeywords = resultPatentKeywords;
	}

	public Set<ResultPatentVersionInfo> getResultPatentVersionInfos() {
		return resultPatentVersionInfos;
	}

	public void setResultPatentVersionInfos(Set<ResultPatentVersionInfo> resultPatentVersionInfos) {
		this.resultPatentVersionInfos = resultPatentVersionInfos;
	}

	/**
	 * @return the projects_resultPatents
	 */
	public Set<Project_ResultPatent> getProjects_resultPatents() {
		return projects_resultPatents;
	}

	/**
	 * @param projects_resultPatents the projects_resultPatents to set
	 */
	public void setProjects_resultPatents(Set<Project_ResultPatent> projects_resultPatents) {
		this.projects_resultPatents = projects_resultPatents;
	}
	
	/**
	 * @return the persons_resultPatents
	 */
	public Set<Person_ResultPatent> getPersons_resultPatents() {
		return persons_resultPatents;
	}
	
	/**
	 * @param persons_resultPatents the persons_resultPatents to set
	 */
	public void setPersons_resultPatents(
			Set<Person_ResultPatent> persons_resultPatents) {
		this.persons_resultPatents = persons_resultPatents;
	}
	
	/**
	 * @return the resultPatents_classes
	 */
	public Set<ResultPatent_Class> getResultPatents_classes() {
		return resultPatents_classes;
	}
	
	/**
	 * @param resultPatents_classes the resultPatents_classes to set
	 */
	public void setResultPatents_classes(
			Set<ResultPatent_Class> resultPatents_classes) {
		this.resultPatents_classes = resultPatents_classes;
	}

	/**
	 * @return the resultPatents_fundings
	 */
	public Set<ResultPatent_Funding> getResultPatents_fundings() {
		return resultPatents_fundings;
	}

	/**
	 * @param resultPatents_fundings the resultPatents_fundings to set
	 */
	public void setResultPatents_fundings(
			Set<ResultPatent_Funding> resultPatents_fundings) {
		this.resultPatents_fundings = resultPatents_fundings;
	}

	/**
	 * @return the resultPatents_indicators
	 */
	public Set<ResultPatent_Indicator> getResultPatents_indicators() {
		return resultPatents_indicators;
	}

	/**
	 * @param resultPatents_indicators the resultPatents_indicators to set
	 */
	public void setResultPatents_indicators(
			Set<ResultPatent_Indicator> resultPatents_indicators) {
		this.resultPatents_indicators = resultPatents_indicators;
	}

	/**
	 * @return the resultPatents_measurements
	 */
	public Set<ResultPatent_Measurement> getResultPatents_measurements() {
		return resultPatents_measurements;
	}

	/**
	 * @param resultPatents_measurements the resultPatents_measurements to set
	 */
	public void setResultPatents_measurements(
			Set<ResultPatent_Measurement> resultPatents_measurements) {
		this.resultPatents_measurements = resultPatents_measurements;
	}

	/**
	 * @return the resultPublications_resultPatents
	 */
	public Set<ResultPublication_ResultPatent> getResultPublications_resultPatents() {
		return resultPublications_resultPatents;
	}
	
	/**
	 * @param resultPublications_resultPatents the resultPublications_resultPatents to set
	 */
	public void setResultPublications_resultPatents(
			Set<ResultPublication_ResultPatent> resultPublications_resultPatents) {
		this.resultPublications_resultPatents = resultPublications_resultPatents;
	}

	/**
	 * @return the resultPatents_services
	 */
	public Set<ResultPatent_Service> getResultPatents_services() {
		return resultPatents_services;
	}

	/**
	 * @param resultPatents_services the resultPatents_services to set
	 */
	public void setResultPatents_services(
			Set<ResultPatent_Service> resultPatents_services) {
		this.resultPatents_services = resultPatents_services;
	}

	/**
	 * @return the resultPatents_equipments
	 */
	public Set<ResultPatent_Equipment> getResultPatents_equipments() {
		return resultPatents_equipments;
	}

	/**
	 * @param resultPatents_equipments the resultPatents_equipments to set
	 */
	public void setResultPatents_equipments(
			Set<ResultPatent_Equipment> resultPatents_equipments) {
		this.resultPatents_equipments = resultPatents_equipments;
	}

	/**
	 * @return the resultPatents_facilities
	 */
	public Set<ResultPatent_Facility> getResultPatents_facilities() {
		return resultPatents_facilities;
	}

	/**
	 * @param resultPatents_facilities the resultPatents_facilities to set
	 */
	public void setResultPatents_facilities(
			Set<ResultPatent_Facility> resultPatents_facilities) {
		this.resultPatents_facilities = resultPatents_facilities;
	}

	/**
	 * @return the resultPatents_resultPatents1
	 */
	public Set<ResultPatent_ResultPatent> getResultPatents_resultPatents1() {
		return resultPatents_resultPatents1;
	}

	/**
	 * @param resultPatents_resultPatents1 the resultPatents_resultPatents1 to set
	 */
	public void setResultPatents_resultPatents1(
			Set<ResultPatent_ResultPatent> resultPatents_resultPatents1) {
		this.resultPatents_resultPatents1 = resultPatents_resultPatents1;
	}

	/**
	 * @return the resultPatents_resultPatents2
	 */
	public Set<ResultPatent_ResultPatent> getResultPatents_resultPatents2() {
		return resultPatents_resultPatents2;
	}

	/**
	 * @param resultPatents_resultPatents2 the resultPatents_resultPatents2 to set
	 */
	public void setResultPatents_resultPatents2(
			Set<ResultPatent_ResultPatent> resultPatents_resultPatents2) {
		this.resultPatents_resultPatents2 = resultPatents_resultPatents2;
	}

	/**
	 * @return the organisationUnits_resultPatents
	 */
	public Set<OrganisationUnit_ResultPatent> getOrganisationUnits_resultPatents() {
		return organisationUnits_resultPatents;
	}

	/**
	 * @param organisationUnits_resultPatents the organisationUnits_resultPatents to set
	 */
	public void setOrganisationUnits_resultPatents(
			Set<OrganisationUnit_ResultPatent> organisationUnits_resultPatents) {
		this.organisationUnits_resultPatents = organisationUnits_resultPatents;
	}

	/**
	 * @return the resultPatents_mediums
	 */
	public Set<ResultPatent_Medium> getResultPatents_mediums() {
		return resultPatents_mediums;
	}

	/**
	 * @param resultPatents_mediums the resultPatents_mediums to set
	 */
	public void setResultPatents_mediums(
			Set<ResultPatent_Medium> resultPatents_mediums) {
		this.resultPatents_mediums = resultPatents_mediums;
	}
	
	/**
	 * Returns the resultProducts_resultPatents.
	 * @return the resultProducts_resultPatents.
	 */
	public Set<ResultProduct_ResultPatent> getResultProducts_resultPatents() {
		return resultProducts_resultPatents;
	}

	/**
	 * Sets the resultProducts_resultPatents.
	 * @param resultProducts_resultPatents the resultProducts_resultPatents.
	 */
	public void setResultProducts_resultPatents(
			Set<ResultProduct_ResultPatent> resultProducts_resultPatents) {
		this.resultProducts_resultPatents = resultProducts_resultPatents;
	}

	/**
	 * @return the federatedIdentifiers
	 */
	public List<FederatedIdentifier> getFederatedIdentifiers() {
		return federatedIdentifiers;
	}

	/**
	 * @param federatedIdentifiers the federatedIdentifiers to set
	 */
	public void setFederatedIdentifiers(List<FederatedIdentifier> federatedIdentifiers) {
		this.federatedIdentifiers = federatedIdentifiers;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ResultPatent other = (ResultPatent) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ResultPatent [id=" + id + ", country=" + country
				+ ", registrationDate=" + registrationDate + ", approvalDate="
				+ approvalDate + ", number=" + number + ", uri=" + uri
				+ ", uuid=" + uuid + "]";
	}

	
}
