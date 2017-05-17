package com.sadp.app;

import com.sadp.pojo.Department;
import com.sadp.pojo.Employee;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MainApplication {

    public static void main(String[] args) {
        System.out.println("Java Serialization");

        List<Employee> employeeList = getEmployeeList();

        try {
            writeListOfEmployeesToJson(new File("employeeData.json"),employeeList);
            System.out.println("Object serialized properly.");
        } catch (IOException e) {
            System.out.println("Object could not be serialized properly.");
            e.printStackTrace();
        }

        TypeReference<List<Employee>> mapType = new TypeReference<List<Employee>>() {};
        List<Employee> employeeReadList = Collections.emptyList();
        try {
            employeeReadList = readListOfEmployeesFromJson(new File("employeeData.json"), mapType);
            System.out.println("Object de-serialized properly.");
        } catch (IOException e) {
            System.out.println("Object could not be de-serialized properly.");

            e.printStackTrace();
        }
        System.out.println("Employee Details: ");
        System.out.println();

        employeeReadList.forEach((x)-> {
            System.out.print("First Name: "+ x.getFirstName()+"\t");
            System.out.print("Last Name: "+ x.getLastName()+"\t");
            System.out.print("Address: "+ x.getAddress()+"\t");
            System.out.print("Salary: "+ x.getSalary()+"\t");
            System.out.println("Department Name:"+x.getDepartment().getDeptName());
        });

    }

    private static List<Employee> getEmployeeList() {
        List<Employee> employeeList = new ArrayList<>();
        Employee employee1 = new Employee(2l,"agam","jain","Delhi",new BigDecimal(45000));
        Employee employee2 = new Employee(3l,"shivanshu","malik","Delhi",new BigDecimal(41000));
        Employee employee3 = new Employee(4l,"shivam","choudary","Delhi",new BigDecimal(40000));

        Employee lead = new Employee(1l,"Suraj","Rawat","Delhi",new BigDecimal(40000));
        Department department = new Department();
        department.setDeptId(1l);
        department.setDeptName("Technology");
        department.setDeptLead(lead);
        lead.setDepartment(department);

        employee1.setDepartment(department);
        employee2.setDepartment(department);
        employee3.setDepartment(department);

        employeeList.add(employee1);
        employeeList.add(employee2);
        employeeList.add(employee3);
        return employeeList;
    }

    private static <T> T readListOfEmployeesFromJson(File file, TypeReference<T> mapType) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(file, mapType);
    }

    private static void writeListOfEmployeesToJson(File file, List<Employee> employeeList) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(file, employeeList);
    }
}
