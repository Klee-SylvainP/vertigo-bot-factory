package io.vertigo.chatbot.designer.domain;

import io.vertigo.core.lang.Generated;
import io.vertigo.datamodel.structure.model.DtObject;
import io.vertigo.datamodel.structure.stereotype.Field;
import io.vertigo.datamodel.structure.util.DtObjectUtil;

/**
 * This class is automatically generated.
 * DO NOT EDIT THIS FILE DIRECTLY.
 */
@Generated
public final class TopIntent implements DtObject {
	private static final long serialVersionUID = 1L;

	private Long topId;
	private String intentRasa;
	private String code;
	private Long count;
	
	/**
	 * Champ : DATA.
	 * Récupère la valeur de la propriété 'Topic ID'.
	 * @return Long topId
	 */
	@Field(smartType = "STyId", label = "Topic ID")
	public Long getTopId() {
		return topId;
	}

	/**
	 * Champ : DATA.
	 * Définit la valeur de la propriété 'Topic ID'.
	 * @param topId Long
	 */
	public void setTopId(final Long topId) {
		this.topId = topId;
	}
	
	/**
	 * Champ : DATA.
	 * Récupère la valeur de la propriété 'Rasa intent'.
	 * @return String intentRasa
	 */
	@Field(smartType = "STyLabel", label = "Rasa intent")
	public String getIntentRasa() {
		return intentRasa;
	}

	/**
	 * Champ : DATA.
	 * Définit la valeur de la propriété 'Rasa intent'.
	 * @param intentRasa String
	 */
	public void setIntentRasa(final String intentRasa) {
		this.intentRasa = intentRasa;
	}
	
	/**
	 * Champ : DATA.
	 * Récupère la valeur de la propriété 'Topic code'.
	 * @return String code
	 */
	@Field(smartType = "STyLabel", label = "Topic code")
	public String getCode() {
		return code;
	}

	/**
	 * Champ : DATA.
	 * Définit la valeur de la propriété 'Topic code'.
	 * @param code String
	 */
	public void setCode(final String code) {
		this.code = code;
	}
	
	/**
	 * Champ : DATA.
	 * Récupère la valeur de la propriété 'Count'.
	 * @return Long count
	 */
	@Field(smartType = "STyNumber", label = "Count")
	public Long getCount() {
		return count;
	}

	/**
	 * Champ : DATA.
	 * Définit la valeur de la propriété 'Count'.
	 * @param count Long
	 */
	public void setCount(final Long count) {
		this.count = count;
	}
	
	/** {@inheritDoc} */
	@Override
	public String toString() {
		return DtObjectUtil.toString(this);
	}
}
