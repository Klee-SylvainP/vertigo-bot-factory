/**
 * vertigo - simple java starter
 *
 * Copyright (C) 2020, Vertigo.io, team@vertigo.io
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.vertigo.chatbot.designer.admin.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.inject.Inject;

import io.vertigo.chatbot.designer.admin.services.PersonServices;
import io.vertigo.chatbot.designer.commons.controllers.AbstractDesignerController;
import io.vertigo.chatbot.designer.domain.commons.Person;
import io.vertigo.chatbot.designer.utils.UserSessionUtils;
import io.vertigo.ui.core.ViewContext;
import io.vertigo.ui.core.ViewContextKey;
import io.vertigo.vega.webservice.validation.UiMessageStack;

import static io.vertigo.chatbot.designer.utils.ListUtils.listLimitReached;

@Controller
@RequestMapping("/persons")
public class PersonListController extends AbstractDesignerController {

	private static final ViewContextKey<Person> personsKey = ViewContextKey.of("persons");

	private static final ViewContextKey<Long> connectedPersonIdKey = ViewContextKey.of("connectedPersonId");

	@Inject
	private PersonServices personServices;

	@GetMapping("/")
	public void initContext(final ViewContext viewContext, final UiMessageStack uiMessageStack) {
		viewContext.publishDtList(personsKey, personServices.getAllPersons());
		viewContext.publishRef(connectedPersonIdKey, UserSessionUtils.getLoggedPerson().getPerId());
		listLimitReached(viewContext, uiMessageStack);
		toModeReadOnly();
	}

	@PostMapping("/_delete")
	private ViewContext deletePerson(final ViewContext viewContext, @RequestParam("perId") final Long perId) {
		personServices.deletePerson(perId);
		viewContext.publishDtList(personsKey, personServices.getAllPersons());
		return viewContext;
	}

}
