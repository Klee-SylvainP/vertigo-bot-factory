package io.vertigo.chatbot.designer.dao;

import javax.inject.Inject;

import io.vertigo.core.lang.Generated;
import io.vertigo.core.node.Node;
import io.vertigo.datamodel.task.definitions.TaskDefinition;
import io.vertigo.datamodel.task.model.Task;
import io.vertigo.datamodel.task.model.TaskBuilder;
import io.vertigo.datastore.entitystore.EntityStoreManager;
import io.vertigo.datastore.impl.dao.DAO;
import io.vertigo.datastore.impl.dao.StoreServices;
import io.vertigo.datamodel.smarttype.SmartTypeManager;
import io.vertigo.datamodel.task.TaskManager;
import io.vertigo.chatbot.designer.domain.Synonym;

/**
 * This class is automatically generated.
 * DO NOT EDIT THIS FILE DIRECTLY.
 */
@Generated
public final class SynonymDAO extends DAO<Synonym, java.lang.Long> implements StoreServices {

	/**
	 * Contructeur.
	 * @param entityStoreManager Manager de persistance
	 * @param taskManager Manager de Task
	 * @param smartTypeManager SmartTypeManager
	 */
	@Inject
	public SynonymDAO(final EntityStoreManager entityStoreManager, final TaskManager taskManager, final SmartTypeManager smartTypeManager) {
		super(Synonym.class, entityStoreManager, taskManager, smartTypeManager);
	}


	/**
	 * Creates a taskBuilder.
	 * @param name  the name of the task
	 * @return the builder 
	 */
	private static TaskBuilder createTaskBuilder(final String name) {
		final TaskDefinition taskDefinition = Node.getNode().getDefinitionSpace().resolve(name, TaskDefinition.class);
		return Task.builder(taskDefinition);
	}

	/**
	 * Execute la tache TkGetSynonymByMeaning.
	 * @param meaId Long
	 * @return DtList de Synonym synonyms
	*/
	@io.vertigo.datamodel.task.proxy.TaskAnnotation(
			name = "TkGetSynonymByMeaning",
			request = "SELECT 	syn.*" + 
 "			from synonym syn 						" + 
 "			where syn.mea_id = #meaId#",
			taskEngineClass = io.vertigo.basics.task.TaskEngineSelect.class)
	@io.vertigo.datamodel.task.proxy.TaskOutput(smartType = "STyDtSynonym")
	public io.vertigo.datamodel.structure.model.DtList<io.vertigo.chatbot.designer.domain.Synonym> getSynonymByMeaning(@io.vertigo.datamodel.task.proxy.TaskInput(name = "meaId", smartType = "STyId") final Long meaId) {
		final Task task = createTaskBuilder("TkGetSynonymByMeaning")
				.addValue("meaId", meaId)
				.build();
		return getTaskManager()
				.execute(task)
				.getResult();
	}

}
