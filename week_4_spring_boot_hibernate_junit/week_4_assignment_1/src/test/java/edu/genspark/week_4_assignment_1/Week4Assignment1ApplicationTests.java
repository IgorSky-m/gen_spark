package edu.genspark.week_4_assignment_1;

import edu.genspark.week_4_assignment_1.api.ICRUDService;
import edu.genspark.week_4_assignment_1.essences.phone.dto.UserPhone;
import edu.genspark.week_4_assignment_1.essences.user.dto.AppUser;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class Week4Assignment1ApplicationTests {

	@Autowired
	private ICRUDService<AppUser, UUID> service;
	private final AppUser INITIAL_TABLE_USER = getInitialStaticUser();


	@BeforeEach
	public void addData(){
		service.save(INITIAL_TABLE_USER);
	}

	@AfterEach
	public void deleteAll(){
		service.deleteAll();
	}

	@Test
	void create() {
		AppUser generated = generate(1);

		service.save(generated);
		AppUser oneById = service.getOneById(generated.getId());

		assertNotNull(oneById);


		assertEquals(generated.getPhones().size(), oneById.getPhones().size());
		assertEquals(generated.getId(), oneById.getId());
		assertEquals(generated.getName(), oneById.getName());

	}

	@Test
	void count(){
		assertEquals(1, service.getAll().size());
	}


	@Test
	void findById(){


		Optional<AppUser> oneById = service.findOneById(INITIAL_TABLE_USER.getId());

		assertTrue(oneById.isPresent());

		AppUser user = oneById.get();

		assertEquals(INITIAL_TABLE_USER.getId(), user.getId());
		assertEquals(INITIAL_TABLE_USER.getName(), user.getName());
	}


	@Test
	void testUpdate(){

		Optional<AppUser> oneById = service.findOneById(INITIAL_TABLE_USER.getId());

		assertTrue(oneById.isPresent());

		AppUser user = oneById.get();

		assertEquals(INITIAL_TABLE_USER.getLogin(), user.getLogin());

		String updatedLogin = "NewLogin";

		user.setLogin(updatedLogin);

		service.update(user.getId(), user);

		AppUser updated = service.getOneById(user.getId());

		assertNotEquals(updated.getLogin(), INITIAL_TABLE_USER.getLogin());
		assertEquals(updatedLogin, updated.getLogin());

		assertEquals(INITIAL_TABLE_USER.getId(), updated.getId());
	}

	@Test
	void testDeleteById(){
		List<AppUser> all = service.getAll();

		assertEquals(1, all.size());

		AppUser oneById = service.getOneById(INITIAL_TABLE_USER.getId());

		assertNotNull(oneById);

		service.deleteById(oneById.getId());

		assertFalse(service.findOneById(oneById.getId()).isPresent());
	}



	private AppUser generate(int numberOfUserPhones, UUID...userStaticId){
		UUID id = userStaticId.length > 0 ? userStaticId[0] : UUID.randomUUID() ;
		ThreadLocalRandom random = ThreadLocalRandom.current();
		AppUser user = new AppUser();
		user.setId(id);
		user.setName("Name" + random.nextInt());
		user.setLogin("Login "+random.nextInt());
		user.setPassword("Pass "+random.nextInt());

		List<UserPhone> phones = new ArrayList<>();

		for (int i = 0; i < numberOfUserPhones; i++) {
			UserPhone phone = new UserPhone();
			phone.setId(UUID.randomUUID());
			phone.setNumber(getRandomPhone(random));
			phones.add(phone);
		}

		user.setPhones(phones);

		return user;
	}

	private String getRandomPhone(ThreadLocalRandom random){
		return String.format("(%s)%s-%s", random.nextInt(100, 999), random.nextInt(10, 99), random.nextInt(1000, 9999));

	}


	private AppUser getInitialStaticUser(){
		AppUser user = new AppUser();
		user.setId(UUID.fromString("15ba41d2-706c-4a47-b3ed-4c45b932067f"));
		user.setName("InitialName");
		user.setLogin("InitialLogin");
		user.setPassword("InitialPass");

		UserPhone phone = new UserPhone();
		phone.setId(UUID.fromString("99ba41d2-706c-4a47-b3ed-4c45b932067f"));
		phone.setNumber("(123)456-7890");

		UserPhone phone2 = new UserPhone();
		phone2.setId(UUID.fromString("88ba41d2-706c-4a47-b3ed-4c45b932067f"));
		phone2.setNumber("(321)456-7890");
		user.setPhones(List.of(phone, phone2));

		return user;
	}
}
