/*
 * Copyright 2012-2016 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.cpetot.web;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.cpetot.AbstractMockTest;
import com.cpetot.services.UserService;

public class UserWatchListControllerTest extends AbstractMockTest {

	protected MockMvc mvc;

	@Mock
	private UserService userService;

	@InjectMocks
	private UserWatchListController controller;

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		mvc = MockMvcBuilders.standaloneSetup(this.controller).build();
	}

	@Test
	public void requestingAddPG13MovieToUserUnder13ShouldReturnError() throws Exception {
		// TODO Implementar
		// Usar testUser() para el mock y ponerle una edad menor a 13
		// Usar post().content() para pasarle el titulo de la pelicula
		Assert.fail();
	}

	@Test
	public void requestingAddMovieToWatchListShouldReturnAccepted() throws Exception {
		// TODO Implementar
		// User testUser() para el mock
		// Preguntar por status ACCEPTED
		Assert.fail();
	}

}
