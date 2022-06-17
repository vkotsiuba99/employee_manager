package com.job.employeemanager.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class EmployeeTest {
    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link Employee#Employee()}
     *   <li>{@link Employee#setEmail(String)}
     *   <li>{@link Employee#setEmployeeCode(String)}
     *   <li>{@link Employee#setId(Long)}
     *   <li>{@link Employee#setImageUrl(String)}
     *   <li>{@link Employee#setJobTitle(String)}
     *   <li>{@link Employee#setName(String)}
     *   <li>{@link Employee#setPhone(String)}
     *   <li>{@link Employee#getEmail()}
     *   <li>{@link Employee#getEmployeeCode()}
     *   <li>{@link Employee#getId()}
     *   <li>{@link Employee#getImageUrl()}
     *   <li>{@link Employee#getJobTitle()}
     *   <li>{@link Employee#getName()}
     *   <li>{@link Employee#getPhone()}
     * </ul>
     */
    @Test
    void testConstructor() {
        Employee actualEmployee = new Employee();
        actualEmployee.setEmail("jane.doe@example.org");
        actualEmployee.setEmployeeCode("Employee Code");
        actualEmployee.setId(123L);
        actualEmployee.setImageUrl("https://example.org/example");
        actualEmployee.setJobTitle("Dr");
        actualEmployee.setName("Name");
        actualEmployee.setPhone("4105551212");
        assertEquals("jane.doe@example.org", actualEmployee.getEmail());
        assertEquals("Employee Code", actualEmployee.getEmployeeCode());
        assertEquals(123L, actualEmployee.getId().longValue());
        assertEquals("https://example.org/example", actualEmployee.getImageUrl());
        assertEquals("Dr", actualEmployee.getJobTitle());
        assertEquals("Name", actualEmployee.getName());
        assertEquals("4105551212", actualEmployee.getPhone());
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link Employee#Employee(String, String, String, String, String, String)}
     *   <li>{@link Employee#setEmail(String)}
     *   <li>{@link Employee#setEmployeeCode(String)}
     *   <li>{@link Employee#setId(Long)}
     *   <li>{@link Employee#setImageUrl(String)}
     *   <li>{@link Employee#setJobTitle(String)}
     *   <li>{@link Employee#setName(String)}
     *   <li>{@link Employee#setPhone(String)}
     *   <li>{@link Employee#getEmail()}
     *   <li>{@link Employee#getEmployeeCode()}
     *   <li>{@link Employee#getId()}
     *   <li>{@link Employee#getImageUrl()}
     *   <li>{@link Employee#getJobTitle()}
     *   <li>{@link Employee#getName()}
     *   <li>{@link Employee#getPhone()}
     * </ul>
     */
    @Test
    void testConstructor2() {
        Employee actualEmployee = new Employee("Name", "jane.doe@example.org", "Dr", "4105551212",
                "https://example.org/example", "Employee Code");
        actualEmployee.setEmail("jane.doe@example.org");
        actualEmployee.setEmployeeCode("Employee Code");
        actualEmployee.setId(123L);
        actualEmployee.setImageUrl("https://example.org/example");
        actualEmployee.setJobTitle("Dr");
        actualEmployee.setName("Name");
        actualEmployee.setPhone("4105551212");
        assertEquals("jane.doe@example.org", actualEmployee.getEmail());
        assertEquals("Employee Code", actualEmployee.getEmployeeCode());
        assertEquals(123L, actualEmployee.getId().longValue());
        assertEquals("https://example.org/example", actualEmployee.getImageUrl());
        assertEquals("Dr", actualEmployee.getJobTitle());
        assertEquals("Name", actualEmployee.getName());
        assertEquals("4105551212", actualEmployee.getPhone());
    }
}

