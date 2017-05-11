package com.cpetot.service;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.cpetot.AbstractMockTest;
import com.cpetot.repository.UserRepository;
import com.cpetot.services.MovieService;
import com.cpetot.services.UserService;
import com.cpetot.services.UserServiceImpl;

public class UserServiceTest extends AbstractMockTest {

	@Mock
	private MovieService movieService;

	@Mock
	private UserRepository userRepo;

	private UserService userService;

	@Rule
	public ExpectedException thrown = ExpectedException.none();

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
		this.userService = new UserServiceImpl(userRepo, movieService);
	}

	@Test
	public void findAllShouldReturnAllUsers() {
		// TODO Implementar.
		// Usar testUsers() para el Mock
		// Verificar que findAll retorna una lista con un miembro 'clark'
		Assert.fail();

	}

	@Test
	public void getUserShouldReturnUserWithUsername() {
		// TODO Implementar.
		// Usar testUser() para el Mock
		// Verificar que el user retornado no sea null
		// Verificar que el user retornado tenga username igual a 'clark'
		Assert.fail();

	}

	@Test
	public void getNotExistingUserShouldThrowException() {
		// TODO Implementar.
		// Retornar null en el mock
		// Esperar excepcion apropiada
		// Llamar al getUser()
		Assert.fail();

	}

	@Test
	public void addMovieToUserWatchListShouldReturnUserWithWatchList() {
		// TODO Implementar
		// Explicar refactor
		Assert.fail();

	}

	@Test
	public void addPG13MovieToUserUnder13ShouldThrowException() {
		// TODO Implementar
		Assert.fail();

	}



}
