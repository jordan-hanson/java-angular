package com.observepoint.test.test.controllers;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.observepoint.test.test.TestApplicationTests;
import com.observepoint.test.test.models.User;
import com.observepoint.test.test.repositories.UserRepository;
import com.observepoint.test.test.services.UserService;
import io.restassured.module.mockmvc.RestAssuredMockMvc;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;

import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

// mocking service to test controller

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,
        classes = TestApplicationTests.class,
        properties = {
                "command.line.runner.enabled=false"})
@AutoConfigureMockMvc
public class UserControllerUnitTestNoDB {
    @Autowired
    private WebApplicationContext webApplicationContext;

    private MockMvc mockMvc;

    @MockBean
    private UserService userService;

    @MockBean
    private UserRepository userrepos;

    private List<User> userList;

    private User u1; // special as needed for security

    @Before
    public void setUp()
    {
        userList = new ArrayList<>();

        u1 = new User();

        u1.setFirstname("JHanson");
        u1.setLastname("Tester");
        u1.setCode(908);
        u1.setManager("Katelyn Miller");
        u1.setDepartment("Engineering");
        u1.setUserid(101);
        userList.add(u1);

        User u2 = new User();

        u2.setFirstname("Ky");
        u2.setLastname("Tester");
        u2.setCode(918);
        u2.setManager("Katelyn Miller");
        u2.setDepartment("Engineering");
        u2.setUserid(102);
        userList.add(u2);

        User u3 = new User();

        u3.setFirstname("Kylee");
        u3.setLastname("Tester");
        u3.setCode(918);
        u3.setManager("Katelyn Miller");
        u3.setDepartment("Engineering");
        u3.setUserid(103);
        userList.add(u3);

        User u4 = new User();

        u4.setFirstname("Amy");
        u4.setLastname("Tester");
        u4.setCode(908);
        u4.setManager("Katelyn Miller");
        u4.setDepartment("Engineering");
        u4.setUserid(104);
        userList.add(u4);

        User u5 = new User();

        u5.setFirstname("Kytley");
        u5.setLastname("Tester");
        u5.setCode(938);
        u5.setManager("Katelyn Miller");
        u5.setDepartment("Engineering");
        u5.setUserid(105);
        userList.add(u5);

        System.out.println("\n*** Seed Data ***");
        for (User u : userList)
        {
            System.out.println(u.getUserid());
        }
        System.out.println("*** Seed Data ***\n");

        RestAssuredMockMvc.webAppContextSetup(webApplicationContext);

        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext)
                .build();
    }

    @After
    public void tearDown()
    {
    }

    @Test
    public void listAllUsers() throws
            Exception
    {
        String apiUrl = "/users/users";

        Mockito.when(userrepos.findById(u1.getUserid()))
                .thenReturn(java.util.Optional.ofNullable(u1));

        Mockito.when(userService.findAll())
                .thenReturn(userList);

        RequestBuilder rb = MockMvcRequestBuilders.get(apiUrl)
                .accept(MediaType.APPLICATION_JSON);

        // the following actually performs a real controller call
        MvcResult r = mockMvc.perform(rb)
                .andReturn(); // this could throw an exception
        String tr = r.getResponse()
                .getContentAsString();

        ObjectMapper mapper = new ObjectMapper();
        String er = mapper.writeValueAsString(userList);

        System.out.println("Expect: " + er);
        System.out.println("Actual: " + tr);

        assertEquals("Rest API Returns List",
                er,
                tr);
    }

//    @Test
    public void getUserById() throws
            Exception
    {
        String apiUrl = "/users/user/12";

        Mockito.when(userrepos.findById(u1.getUserid()))
                .thenReturn(java.util.Optional.ofNullable(u1));

        Mockito.when(userService.findUserById(101))
                .thenReturn(userList.get(1));

        RequestBuilder rb = MockMvcRequestBuilders.get(apiUrl)
                .accept(MediaType.APPLICATION_JSON);
        MvcResult r = mockMvc.perform(rb)
                .andReturn(); // this could throw an exception
        String tr = r.getResponse()
                .getContentAsString();

        ObjectMapper mapper = new ObjectMapper();
        String er = mapper.writeValueAsString(userList.get(1));

        System.out.println("Expect: " + er);
        System.out.println("Actual: " + tr);

        assertEquals("Rest API Returns List",
                er,
                tr);
    }

    @Test
    public void getUserByIdNotFound() throws
            Exception
    {
        String apiUrl = "/users/user/77";

        Mockito.when(userrepos.findById(u1.getUserid()))
                .thenReturn(java.util.Optional.ofNullable(u1));

        Mockito.when(userService.findUserById(77))
                .thenReturn(null);

        RequestBuilder rb = MockMvcRequestBuilders.get(apiUrl)
                .accept(MediaType.APPLICATION_JSON);
        MvcResult r = mockMvc.perform(rb)
                .andReturn(); // this could throw an exception
        String tr = r.getResponse()
                .getContentAsString();

        String er = "";

        System.out.println("Expect: " + er);
        System.out.println("Actual: " + tr);

        assertEquals("Rest API Returns List",
                er,
                tr);
    }

    @Test
    public void addNewUser() throws
            Exception
    {
        String apiUrl = "/users/user";

        Mockito.when(userrepos.findById(u1.getUserid()))
                .thenReturn(java.util.Optional.ofNullable(u1));

        Mockito.when(userService.save(any(User.class)))
                .thenReturn(userList.get(0));

        RequestBuilder rb = MockMvcRequestBuilders.post(apiUrl)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content("{\"firstname\": \"TestM\", \"lastname\": \"Technical\", \"code\" : \"789\", \"department\" : \"Engineering\", \"manager\" : \"Katelyn Moody\"}");

        mockMvc.perform(rb)
                .andExpect(status().isCreated())
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    public void updateUser() throws
            Exception
    {
        String apiUrl = "/users/user/{userid}";

        Mockito.when(userrepos.findById(u1.getUserid()))
                .thenReturn(java.util.Optional.ofNullable(u1));

        Mockito.when(userService.save(any(User.class)))
                .thenReturn(userList.get(0));

        RequestBuilder rb = MockMvcRequestBuilders.patch(apiUrl,
                100L)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content("{\"firstname\": \"Updated\", \"lastname\": \"Technical\", \"code\" : \"789\", \"department\" : \"Engineering\", \"manager\" : \"Katelyn Moody\"}");

        mockMvc.perform(rb)
                .andExpect(status().is2xxSuccessful())
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    public void deleteUserById() throws
            Exception
    {
        String apiUrl = "/users/user/{userid}";

        RequestBuilder rb = MockMvcRequestBuilders.delete(apiUrl,
                "3")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON);

        Mockito.when(userrepos.findById(u1.getUserid()))
                .thenReturn(java.util.Optional.ofNullable(u1));

        mockMvc.perform(rb)
                .andExpect(status().is2xxSuccessful())
                .andDo(MockMvcResultHandlers.print());
    }
}
