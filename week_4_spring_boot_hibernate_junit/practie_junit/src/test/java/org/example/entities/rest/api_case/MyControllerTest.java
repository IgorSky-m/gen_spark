package org.example.entities.rest.api_case;

import org.example.entities.rest.api_case.api.IMyService;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.List;
import java.util.UUID;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class MyControllerTest {

    private final UUID first = UUID.fromString("7c2e1f2f-d5e6-46e8-acad-abbb8a79ad53");
    private final UUID second = UUID.fromString("f195d613-b70d-45d3-a684-8f25c78c669f");
    private final UUID third = UUID.fromString("91220ce6-2c2d-46b1-84e3-2ae748bb6708");


    private MockMvc mockMvc;
    @Mock
    private IMyService service;

    @InjectMocks
    private MyController controller;

    @BeforeAll
    public void setupAll() {
        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
        when(service.findAll()).thenReturn(createAll());

        when(service.findById(first))
                .thenReturn(createFirst());

        when(service.findById(second))
                .thenReturn(createSecond());

        when(service.findById(third))
                .thenReturn(createThird());

        when(service.findById(null))
        .thenThrow(new IllegalArgumentException("Entity not found"));

    }

    @BeforeEach
    public void setup() {


    }


    @AfterEach
    public void reset() {
        Mockito.reset(service);
    }

    @Test
    @DisplayName("get all test")
    public void getAll() throws Exception {
        MyEntity firstEntity = createFirst();
        MyEntity secondEntity = createSecond();
        MyEntity thirdEntity = createThird();

        mockMvc.perform(
                MockMvcRequestBuilders.get("/my").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(3)))
                .andExpect(jsonPath("$[0].id", is(firstEntity.getId().toString())))
                .andExpect(jsonPath("$[0].name", is(firstEntity.getName())))
                .andExpect(jsonPath("$[0].description", is(firstEntity.getDescription())))
                .andExpect(jsonPath("$[1].id", is(secondEntity.getId().toString())))
                .andExpect(jsonPath("$[1].name", is(secondEntity.getName())))
                .andExpect(jsonPath("$[1].description", is(secondEntity.getDescription())))
                .andExpect(jsonPath("$[2].id", is(thirdEntity.getId().toString())))
                .andExpect(jsonPath("$[2].name", is(thirdEntity.getName())))
                .andExpect(jsonPath("$[2].description", is(thirdEntity.getDescription())));
    }


    @Test
    @DisplayName("get one test")
    public void getOne() throws Exception {

        MyEntity firstEntity = createFirst();

        mockMvc.perform(
                        MockMvcRequestBuilders.get("/my/" + first).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", is(firstEntity.getId().toString())))
                .andExpect(jsonPath("$.name", is(firstEntity.getName())))
                .andExpect(jsonPath("$.description", is(firstEntity.getDescription())));

        MyEntity secondEntity = createSecond();

        mockMvc.perform(
                        MockMvcRequestBuilders.get("/my/" + second).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", is(secondEntity.getId().toString())))
                .andExpect(jsonPath("$.name", is(secondEntity.getName())))
                .andExpect(jsonPath("$.description", is(secondEntity.getDescription())));

        MyEntity thirdEntity = createThird();

        mockMvc.perform(
                        MockMvcRequestBuilders.get("/my/" + thirdEntity).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", is(thirdEntity.getId().toString())))
                .andExpect(jsonPath("$.name", is(thirdEntity.getName())))
                .andExpect(jsonPath("$.description", is(thirdEntity.getDescription())));
    }


    private List<MyEntity> createAll() {
        return List.of(createFirst(), createSecond(), createThird());
    }

    private MyEntity createFirst() {
        return MyEntity.builder()
                .id(first)
                .name("Entity1")
                .description("this is first description")
                .build();
    }

    private MyEntity createSecond() {
        return MyEntity.builder()
                .id(second)
                .name("Entity2")
                .description("this is second description")
                .build();
    }

    private MyEntity createThird() {
        return MyEntity.builder()
                .id(third)
                .name("Entity2")
                .description("this is second description")
                .build();
    }


}