package io.vertigo.chatbot.designer.domain.analytics;

import io.vertigo.core.lang.Generated;
import io.vertigo.datamodel.structure.model.DtObject;
import io.vertigo.datamodel.structure.stereotype.Field;
import io.vertigo.datamodel.structure.util.DtObjectUtil;

/**
 * This class is automatically generated.
 * DO NOT EDIT THIS FILE DIRECTLY.
 */
@Generated
public final class TopIntentCriteria implements DtObject {
	private static final long serialVersionUID = 1L;

	private java.util.List<Long> catIds = new java.util.ArrayList<>();
	private java.util.List<Long> labels = new java.util.ArrayList<>();
	
	/**
	 * Champ : DATA.
	 * Récupère la valeur de la propriété 'Category Ids'.
	 * @return List de Long catIds
	 */
	@Field(smartType = "STyId", cardinality = io.vertigo.core.lang.Cardinality.MANY, label = "Category Ids")
	public java.util.List<Long> getCatIds() {
		return catIds;
	}

	/**
	 * Champ : DATA.
	 * Définit la valeur de la propriété 'Category Ids'.
	 * @param catIds List de Long
	 */
	public void setCatIds(final java.util.List<Long> catIds) {
		io.vertigo.core.lang.Assertion.check().isNotNull(catIds);
		//---
		this.catIds = catIds;
	}
	
	/**
	 * Champ : DATA.
	 * Récupère la valeur de la propriété 'Labels'.
	 * @return List de Long labels
	 */
	@Field(smartType = "STyId", cardinality = io.vertigo.core.lang.Cardinality.MANY, label = "Labels")
	public java.util.List<Long> getLabels() {
		return labels;
	}

	/**
	 * Champ : DATA.
	 * Définit la valeur de la propriété 'Labels'.
	 * @param labels List de Long
	 */
	public void setLabels(final java.util.List<Long> labels) {
		io.vertigo.core.lang.Assertion.check().isNotNull(labels);
		//---
		this.labels = labels;
	}
	
	/** {@inheritDoc} */
	@Override
	public String toString() {
		return DtObjectUtil.toString(this);
	}
}
