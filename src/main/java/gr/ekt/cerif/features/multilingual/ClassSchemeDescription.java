/**
 * 
 */
package gr.ekt.cerif.features.multilingual;

import gr.ekt.cerif.entities.second.Language;
import gr.ekt.cerif.features.semantics.ClassScheme;
import gr.ekt.cerif.pk.ClassSchemeTranslationId;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Holds the multi-lingual description of a class scheme entity.
 * 
 */
@Entity
@Table(name="cfClassSchemeDescr")
@IdClass(ClassSchemeTranslationId.class)
public class ClassSchemeDescription implements ClassSchemeTranslation {
	
	/**
	 * Serialization version.
	 */
	private static final long serialVersionUID = -2804499062529714599L;
	
	/**
	 * The class scheme.
	 */
	@Id
	@ManyToOne
	@JoinColumn(name="cfClassSchemeId")
	private ClassScheme scheme;
	
	/**
	 * The language.
	 */
	@Id
	@ManyToOne
	@JoinColumn(name="cfLangCode")
	private Language language;
	
	/**
	 * The translation.
	 */
	@Id
	@Column(name="cfTrans")
	@Enumerated(EnumType.STRING)
	private Translation translation;
	
	/**
	 * The class scheme description.
	 */
	@Column(name="cfDescr")
	private String description;
	
	/**
	 * The class scheme description source.
	 */
	@Column(name="cfDescrSrc")
	private String descriptionSrc;

	/**
	 * @return the classScheme
	 */
	public ClassScheme getClassScheme() {
		return scheme;
	}

	/**
	 * @param classScheme the classScheme to set
	 */
	public void setClassScheme(ClassScheme scheme) {
		this.scheme = scheme;
	}

	/**
	 * @return the language
	 */
	public Language getLanguage() {
		return language;
	}

	/**
	 * @param language the language to set
	 */
	public void setLanguage(Language language) {
		this.language = language;
	}

	/**
	 * @return the translation
	 */
	public Translation getTranslation() {
		return translation;
	}

	/**
	 * @param translation the translation to set
	 */
	public void setTranslation(Translation translation) {
		this.translation = translation;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	public String getDescriptionSrc() {
		return descriptionSrc;
	}

	public void setDescriptionSrc(String descriptionSrc) {
		this.descriptionSrc = descriptionSrc;
	}
}
