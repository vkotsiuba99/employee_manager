package com.job.employeemanager.controller;

import static org.mockito.Mockito.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.job.employeemanager.model.Employee;
import com.job.employeemanager.service.EmployeeService;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@ContextConfiguration(classes = {EmployeeController.class})
@ExtendWith(SpringExtension.class)
class EmployeeControllerTest {
    @Autowired
    private EmployeeController employeeController;

    @MockBean
    private EmployeeService employeeService;

    /**
     * Method under test: {@link EmployeeController#addEmployee(Employee)}
     */
    @Test
    void testAddEmployee() throws Exception {
        Employee employee = new Employee();
        employee.setEmail("jane.doe@example.org");
        employee.setEmployeeCode("Employee Code");
        employee.setId(123L);
        employee.setImageUrl("https://example.org/example");
        employee.setJobTitle("Dr");
        employee.setName("Name");
        employee.setPhone("4105551212");
        when(this.employeeService.addEmployee((Employee) any())).thenReturn(employee);

        Employee employee1 = new Employee();
        employee1.setEmail("jane.doe@example.org");
        employee1.setEmployeeCode("Employee Code");
        employee1.setId(123L);
        employee1.setImageUrl("https://example.org/example");
        employee1.setJobTitle("Dr");
        employee1.setName("Name");
        employee1.setPhone("4105551212");
        String content = (new ObjectMapper()).writeValueAsString(employee1);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/employee/add")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(this.employeeController)
                .build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().isCreated())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "{\"id\":123,\"name\":\"Name\",\"email\":\"jane.doe@example.org\",\"jobTitle\":\"Dr\",\"phone\":\"4105551212\",\"imageUrl"
                                        + "\":\"https://example.org/example\",\"employeeCode\":\"Employee Code\"}"));
    }

    /**
     * Method under test: {@link EmployeeController#updateEmployee(Employee)}
     */
    @Test
    void testUpdateEmployee() throws Exception {
        Employee employee = new Employee();
        employee.setEmail("jane.doe@example.org");
        employee.setEmployeeCode("Employee Code");
        employee.setId(123L);
        employee.setImageUrl("https://example.org/example");
        employee.setJobTitle("Dr");
        employee.setName("Name");
        employee.setPhone("4105551212");
        when(this.employeeService.updateEmployee((Employee) any())).thenReturn(employee);

        Employee employee1 = new Employee();
        employee1.setEmail("jane.doe@example.org");
        employee1.setEmployeeCode("Employee Code");
        employee1.setId(123L);
        employee1.setImageUrl("https://example.org/example");
        employee1.setJobTitle("Dr");
        employee1.setName("Name");
        employee1.setPhone("4105551212");
        String content = (new ObjectMapper()).writeValueAsString(employee1);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.put("/employee/update")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        MockMvcBuilders.standaloneSetup(this.employeeController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "{\"id\":123,\"name\":\"Name\",\"email\":\"jane.doe@example.org\",\"jobTitle\":\"Dr\",\"phone\":\"4105551212\",\"imageUrl"
                                        + "\":\"https://example.org/example\",\"employeeCode\":\"Employee Code\"}"));
    }

    /**
     * Method under test: {@link EmployeeController#deleteEmployee(Long)}
     */
    @Test
    void testDeleteEmployee() throws Exception {
        doNothing().when(this.employeeService).deleteEmployee((Long) any());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.delete("/employee/delete/{id}", 123L);
        MockMvcBuilders.standaloneSetup(this.employeeController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    /**
     * Method under test: {@link EmployeeController#deleteEmployee(Long)}
     */
    @Test
    void testDeleteEmployee2() throws Exception {
        doNothing().when(this.employeeService).deleteEmployee((Long) any());
        MockHttpServletRequestBuilder deleteResult = MockMvcRequestBuilders.delete("/employee/delete/{id}", 123L);
        deleteResult.contentType("https://example.org/example");
        MockMvcBuilders.standaloneSetup(this.employeeController)
                .build()
                .perform(deleteResult)
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    /**
     * Method under test: {@link EmployeeController#getAllEmployeeById(Long)}
     */
    @Test
    void testGetAllEmployeeById() throws Exception {
        Employee employee = new Employee();
        employee.setEmail("jane.doe@example.org");
        employee.setEmployeeCode("Employee Code");
        employee.setId(123L);
        employee.setImageUrl("https://example.org/example");
        employee.setJobTitle("Dr");
        employee.setName("Name");
        employee.setPhone("4105551212");
        when(this.employeeService.findEmployeeById((Long) any())).thenReturn(employee);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/employee/find/{id}", 123L);
        MockMvcBuilders.standaloneSetup(this.employeeController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "{\"id\":123,\"name\":\"Name\",\"email\":\"jane.doe@example.org\",\"jobTitle\":\"Dr\",\"phone\":\"4105551212\",\"imageUrl"
                                        + "\":\"https://example.org/example\",\"employeeCode\":\"Employee Code\"}"));
    }

    /**
     * Method under test: {@link EmployeeController#getAllEmployeeById(Long)}
     */
    @Test
    void testGetAllEmployeeById2() throws Exception {
        Employee employee = new Employee();
        employee.setEmail("jane.doe@example.org");
        employee.setEmployeeCode("Employee Code");
        employee.setId(123L);
        employee.setImageUrl("https://example.org/example");
        employee.setJobTitle("Dr");
        employee.setName("Name");
        employee.setPhone("4105551212");
        when(this.employeeService.findEmployeeById((Long) any())).thenReturn(employee);
        MockHttpServletRequestBuilder getResult = MockMvcRequestBuilders.get("/employee/find/{id}", 123L);
        getResult.contentType("https://example.org/example");
        MockMvcBuilders.standaloneSetup(this.employeeController)
                .build()
                .perform(getResult)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "{\"id\":123,\"name\":\"Name\",\"email\":\"jane.doe@example.org\",\"jobTitle\":\"Dr\",\"phone\":\"4105551212\",\"imageUrl"
                                        + "\":\"https://example.org/example\",\"employeeCode\":\"Employee Code\"}"));
    }

    /**
     * Method under test: {@link EmployeeController#getAllEmployees()}
     */
    @Test
    void testGetAllEmployees() throws Exception {
        when(this.employeeService.findAllEmployees()).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/employee/all");
        MockMvcBuilders.standaloneSetup(this.employeeController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }

    /**
     * Method under test: {@link EmployeeController#getAllEmployees()}
     */
    @Test
    void testGetAllEmployees2() throws Exception {
        when(this.employeeService.findAllEmployees()).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder getResult = MockMvcRequestBuilders.get("/employee/all");
        getResult.contentType("https://example.org/example");
        MockMvcBuilders.standaloneSetup(this.employeeController)
                .build()
                .perform(getResult)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }
}

