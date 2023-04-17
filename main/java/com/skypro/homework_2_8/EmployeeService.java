package com.skypro.homework_2_8;

import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class EmployeeService {
    private static final int SIZE = 10;
    private Employee[] employees = new Employee[SIZE];

    EmployeeService() {
        employees[0] = new Employee("Ivan Ivanov Ivanovich1", 1, 120_000);
        employees[1] = new Employee("Ivan Ivanov Ivanovich2", 2, 110_000);
        employees[2] = new Employee("Ivan Ivanov Ivanovich3", 3, 89_000);
        employees[3] = new Employee("Ivan Ivanov Ivanovich4", 4, 70_000);
        employees[4] = new Employee("Ivan Ivanov Ivanovich5", 5, 68_000);
        employees[5] = new Employee("Ivan Ivanov Ivanovich6", 1, 126_000);
        employees[6] = new Employee("Ivan Ivanov Ivanovich7", 2, 105_000);
        employees[7] = new Employee("Ivan Ivanov Ivanovich8", 3, 89_000);
        employees[8] = new Employee("Ivan Ivanov Ivanovich9", 4, 78_000);
        employees[9] = new Employee("Ivan Ivanov Ivanovich10", 5, 90_000);
    }

    public Employee getEmpWithMaxSalary (int department)  {
        return Arrays.stream(employees)
                .filter(e -> e.getDepartment() == department)
                .max(Comparator.comparingDouble(Employee::getSalary))
                .orElseThrow(() -> new IllegalArgumentException("Department number is invalid"));
    }
    public Employee getEmpWithMinSalary (int department){
        return Arrays.stream(employees)
                .filter(e -> e.getDepartment() == department)
                .min(Comparator.comparingDouble(Employee::getSalary))
                .orElseThrow(() -> new IllegalArgumentException("Department number is invalid"));
    }
    public List<Employee> showAll(){
        return  Arrays.stream(employees)
                .filter(e-> e!= null)
                .sorted(Comparator.comparingInt(Employee::getDepartment))
                .collect(Collectors.toList());
    }
    public List<Employee> showByDepartment(Integer id) {
        return Arrays.stream(employees)
                .filter(e -> e != null)
                .filter(e -> e.getDepartment() == id)
                .collect(Collectors.toList());
    }
}
