package io.vertigo.chatbot.commons.domain.topic;

import io.vertigo.core.lang.Generated;
import io.vertigo.datamodel.structure.model.Entity;
import io.vertigo.datamodel.structure.model.UID;
import io.vertigo.datastore.impl.entitystore.StoreVAccessor;
import io.vertigo.datamodel.structure.stereotype.Field;
import io.vertigo.datamodel.structure.util.DtObjectUtil;

/**
 * This class is automatically generated.
 * DO NOT EDIT THIS FILE DIRECTLY.
 */
@Generated
public final class ScriptIntention implements Entity {
	private static final long serialVersionUID = 1L;

	private Long sinId;
	private String script;

	@io.vertigo.datamodel.structure.stereotype.Association(
			name = "AScriptIntentionTopic",
			fkFieldName = "topId",
			primaryDtDefinitionName = "DtTopic",
			primaryIsNavigable = true,
			primaryRole = "Topic",
			primaryLabel = "Topic",
			primaryMultiplicity = "1..1",
			foreignDtDefinitionName = "DtScriptIntention",
			foreignIsNavigable = false,
			foreignRole = "ScriptIntention",
			foreignLabel = "ScriptIntention",
			foreignMultiplicity = "0..*")
	private final StoreVAccessor<io.vertigo.chatbot.commons.domain.topic.Topic> topIdAccessor = new StoreVAccessor<>(io.vertigo.chatbot.commons.domain.topic.Topic.class, "Topic");

	/** {@inheritDoc} */
	@Override
	public UID<ScriptIntention> getUID() {
		return UID.of(this);
	}
	
	/**
	 * Champ : ID.
	 * Récupère la valeur de la propriété 'ID'.
	 * @return Long sinId <b>Obligatoire</b>
	 */
	@Field(smartType = "STyId", type = "ID", cardinality = io.vertigo.core.lang.Cardinality.ONE, label = "ID")
	public Long getSinId() {
		return sinId;
	}

	/**
	 * Champ : ID.
	 * Définit la valeur de la propriété 'ID'.
	 * @param sinId Long <b>Obligatoire</b>
	 */
	public void setSinId(final Long sinId) {
		this.sinId = sinId;
	}
	
	/**
	 * Champ : DATA.
	 * Récupère la valeur de la propriété 'Script'.
	 * @return String script
	 */
	@Field(smartType = "STyText", label = "Script")
	public String getScript() {
		return script;
	}

	/**
	 * Champ : DATA.
	 * Définit la valeur de la propriété 'Script'.
	 * @param script String
	 */
	public void setScript(final String script) {
		this.script = script;
	}
	
	/**
	 * Champ : FOREIGN_KEY.
	 * Récupère la valeur de la propriété 'Topic'.
	 * @return Long topId <b>Obligatoire</b>
	 */
	@io.vertigo.datamodel.structure.stereotype.ForeignKey(smartType = "STyId", label = "Topic", fkDefinition = "DtTopic" )
	public Long getTopId() {
		return (Long) topIdAccessor.getId();
	}

	/**
	 * Champ : FOREIGN_KEY.
	 * Définit la valeur de la propriété 'Topic'.
	 * @param topId Long <b>Obligatoire</b>
	 */
	public void setTopId(final Long topId) {
		topIdAccessor.setId(topId);
	}

 	/**
	 * Association : Topic.
	 * @return l'accesseur vers la propriété 'Topic'
	 */
	public StoreVAccessor<io.vertigo.chatbot.commons.domain.topic.Topic> topic() {
		return topIdAccessor;
	}
	
	/** {@inheritDoc} */
	@Override
	public String toString() {
		return DtObjectUtil.toString(this);
	}
}
