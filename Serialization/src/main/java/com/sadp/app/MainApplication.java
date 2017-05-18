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
        // I would prefer a logger instead. This is a small application but it is better habit to have logger.
        System.out.println("Java Serialization");

        List<Employee> employeeList = getEmployeeList();

        // It is better to have a separate method for both seriliazation and desirialization. Makes the code more readable.
        try {
            writeListOfEmployeesToJson(new File("employeeData.json"),employeeList);
            System.out.println("Object serialized properly.");
        } catch (IOException e) {
            System.out.println("Object could not be serialized properly.");
            e.printStackTrace();
        }

        TypeReference<List<Employee>> typeReference = new TypeReference<List<Employee>>() {};
        List<Employee> employeeReadList = Collections.emptyList();
        try {
            employeeReadList = readListOfEmployeesFromJson(new File("employeeData.json"), typeReference);
            System.out.println("Object de-serialized properly.");
        } catch (IOException e) {
            System.out.println("Object could not be de-serialized properly.");
            e.printStackTrace();
        }
        System.out.println("Employee Details: ");
        System.out.println();

        printEmployeeDetails(employeeReadList);

    }

    private static void printEmployeeDetails(List<Employee> employeeReadList) {
        employeeReadList.forEach((x)-> {
            //You can write a good toString method using Guava library in the WMployee object itself and directly print the employee details using toString instead of 
            //printing details in this main method. 
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

    private static <T> T readListOfEmployeesFromJson(File file, TypeReference<T> typeReference) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(file, typeReference);
    }

    private static void writeListOfEmployeesToJson(File file, List<Employee> employeeList) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(file, employeeList);
    }
}
