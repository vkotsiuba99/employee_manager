package com.job.employeemanager.service;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.job.employeemanager.exception.UserNotFoundException;
import com.job.employeemanager.model.Employee;
import com.job.employeemanager.repository.EmployeeRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {EmployeeService.class})
@ExtendWith(SpringExtension.class)
class EmployeeServiceTest {
    @MockBean
    private EmployeeRepository employeeRepository;

    @Autowired
    private EmployeeService employeeService;

    /**
     * Method under test: {@link EmployeeService#addEmployee(Employee)}
     */
    @Test
    void testAddEmployee() {
        Employee employee = new Employee();
        employee.setEmail("jane.doe@example.org");
        employee.setEmployeeCode("Employee Code");
        employee.setId(123L);
        employee.setImageUrl("https://example.org/example");
        employee.setJobTitle("Dr");
        employee.setName("Name");
        employee.setPhone("4105551212");
        when(this.employeeRepository.save((Employee) any())).thenReturn(employee);

        Employee employee1 = new Employee();
        employee1.setEmail("jane.doe@example.org");
        employee1.setEmployeeCode("Employee Code");
        employee1.setId(123L);
        employee1.setImageUrl("https://example.org/example");
        employee1.setJobTitle("Dr");
        employee1.setName("Name");
        employee1.setPhone("4105551212");
        assertSame(employee, this.employeeService.addEmployee(employee1));
        verify(this.employeeRepository).save((Employee) any());
    }

    /**
     * Method under test: {@link EmployeeService#addEmployee(Employee)}
     */
    @Test
    void testAddEmployee2() {
        when(this.employeeRepository.save((Employee) any())).thenThrow(new UserNotFoundException("An error occurred"));

        Employee employee = new Employee();
        employee.setEmail("jane.doe@example.org");
        employee.setEmployeeCode("Employee Code");
        employee.setId(123L);
        employee.setImageUrl("https://example.org/example");
        employee.setJobTitle("Dr");
        employee.setName("Name");
        employee.setPhone("4105551212");
        assertThrows(UserNotFoundException.class, () -> this.employeeService.addEmployee(employee));
        verify(this.employeeRepository).save((Employee) any());
    }

    /**
     * Method under test: {@link EmployeeService#findAllEmployees()}
     */
    @Test
    void testFindAllEmployees() {
        ArrayList<Employee> employeeList = new ArrayList<>();
        when(this.employeeRepository.findAll()).thenReturn(employeeList);
        List<Employee> actualFindAllEmployeesResult = this.employeeService.findAllEmployees();
        assertSame(employeeList, actualFindAllEmployeesResult);
        assertTrue(actualFindAllEmployeesResult.isEmpty());
        verify(this.employeeRepository).findAll();
    }

    /**
     * Method under test: {@link EmployeeService#findAllEmployees()}
     */
    @Test
    void testFindAllEmployees2() {
        when(this.employeeRepository.findAll()).thenThrow(new UserNotFoundException("An error occurred"));
        assertThrows(UserNotFoundException.class, () -> this.employeeService.findAllEmployees());
        verify(this.employeeRepository).findAll();
    }

    /**
     * Method under test: {@link EmployeeService#updateEmployee(Employee)}
     */
    @Test
    void testUpdateEmployee() {
        Employee employee = new Employee();
        employee.setEmail("jane.doe@example.org");
        employee.setEmployeeCode("Employee Code");
        employee.setId(123L);
        employee.setImageUrl("https://example.org/example");
        employee.setJobTitle("Dr");
        employee.setName("Name");
        employee.setPhone("4105551212");
        when(this.employeeRepository.save((Employee) any())).thenReturn(employee);

        Employee employee1 = new Employee();
        employee1.setEmail("jane.doe@example.org");
        employee1.setEmployeeCode("Employee Code");
        employee1.setId(123L);
        employee1.setImageUrl("https://example.org/example");
        employee1.setJobTitle("Dr");
        employee1.setName("Name");
        employee1.setPhone("4105551212");
        assertSame(employee, this.employeeService.updateEmployee(employee1));
        verify(this.employeeRepository).save((Employee) any());
    }

    /**
     * Method under test: {@link EmployeeService#updateEmployee(Employee)}
     */
    @Test
    void testUpdateEmployee2() {
        when(this.employeeRepository.save((Employee) any())).thenThrow(new UserNotFoundException("An error occurred"));

        Employee employee = new Employee();
        employee.setEmail("jane.doe@example.org");
        employee.setEmployeeCode("Employee Code");
        employee.setId(123L);
        employee.setImageUrl("https://example.org/example");
        employee.setJobTitle("Dr");
        employee.setName("Name");
        employee.setPhone("4105551212");
        assertThrows(UserNotFoundException.class, () -> this.employeeService.updateEmployee(employee));
        verify(this.employeeRepository).save((Employee) any());
    }

    /**
     * Method under test: {@link EmployeeService#findEmployeeById(Long)}
     */
    @Test
    void testFindEmployeeById() {
        Employee employee = new Employee();
        employee.setEmail("jane.doe@example.org");
        employee.setEmployeeCode("Employee Code");
        employee.setId(123L);
        employee.setImageUrl("https://example.org/example");
        employee.setJobTitle("Dr");
        employee.setName("Name");
        employee.setPhone("4105551212");
        Optional<Employee> ofResult = Optional.of(employee);
        when(this.employeeRepository.findEmployeeById((Long) any())).thenReturn(ofResult);
        assertSame(employee, this.employeeService.findEmployeeById(123L));
        verify(this.employeeRepository).findEmployeeById((Long) any());
    }

    /**
     * Method under test: {@link EmployeeService#findEmployeeById(Long)}
     */
    @Test
    void testFindEmployeeById2() {
        when(this.employeeRepository.findEmployeeById((Long) any())).thenReturn(Optional.empty());
        assertThrows(UserNotFoundException.class, () -> this.employeeService.findEmployeeById(123L));
        verify(this.employeeRepository).findEmployeeById((Long) any());
    }

    /**
     * Method under test: {@link EmployeeService#findEmployeeById(Long)}
     */
    @Test
    void testFindEmployeeById3() {
        when(this.employeeRepository.findEmployeeById((Long) any()))
                .thenThrow(new UserNotFoundException("An error occurred"));
        assertThrows(UserNotFoundException.class, () -> this.employeeService.findEmployeeById(123L));
        verify(this.employeeRepository).findEmployeeById((Long) any());
    }

    /**
     * Method under test: {@link EmployeeService#deleteEmployee(Long)}
     */
    @Test
    void testDeleteEmployee() {
        doNothing().when(this.employeeRepository).deleteEmployeeById((Long) any());
        this.employeeService.deleteEmployee(123L);
        verify(this.employeeRepository).deleteEmployeeById((Long) any());
    }

    /**
     * Method under test: {@link EmployeeService#deleteEmployee(Long)}
     */
    @Test
    void testDeleteEmployee2() {
        doThrow(new UserNotFoundException("An error occurred")).when(this.employeeRepository)
                .deleteEmployeeById((Long) any());
        assertThrows(UserNotFoundException.class, () -> this.employeeService.deleteEmployee(123L));
        verify(this.employeeRepository).deleteEmployeeById((Long) any());
    }
}

