package cydeo;


import java.util.*;
import java.util.function.Consumer;

import static cydeo.DataGenerator.*;
import static cydeo.Service.*;
import static cydeo.Gender.*;
import static cydeo.Role.*;

public class Main {

    public static void main(String[] args) {
        createAllAddresses();
        createAllCompanies();
        createAllEmployees();
        int rand = (int) (Math.random() *10); //random int rom 0 to 10

        //When you start to solve new question, comment out the System.out.println statement



        //EXAMPLE
        System.out.println("***get all employees if their Id number is odd");
        System.out.println(filter(getAllEmployees(),employee -> employee.getId()%2!=0));


        System.out.println("***get all employees if their Id number is even");
        System.out.println(filter(getAllEmployees(),employee -> employee.getId()%2==0));

        System.out.println("***get all employees if they are FEMALE***");
        System.out.println(filter(getAllEmployees(),employee -> employee.getGender()==FEMALE));


        System.out.println("***get all employees if they are MALE***");
        System.out.println(filter(getAllEmployees(),employee -> employee.getGender()==MALE));


        System.out.println("***get all employees if they are older than 50");
        System.out.println(filter(getAllEmployees(),employee -> employee.getAge()>50));


        System.out.println("***get all employees whose company name info starts with A or a");
        System.out.println(filter(getAllEmployees(),employee -> employee.getCompany().getCompanyName().toLowerCase().startsWith("a")));


        System.out.println("*** get all employees their company is located in Utah Indiana or California as a state ");
        System.out.println(filter(getAllEmployees(),employee -> employee.getCompany().getAddress().getState().equals("Indiana")
                ||employee.getCompany().getAddress().getState().equals("Utah")
                ||employee.getCompany().getAddress().getState().equals("California")));

        System.out.println("get all companies if the company name consist of ,");
        System.out.println(filter(getAllCompanies(),company -> company.getCompanyName().contains(",")));


        System.out.println("get all companies if the company name ends with a");
        System.out.println(filter(getAllCompanies(),company -> company.getCompanyName().toLowerCase().endsWith("a")));


        System.out.println("get all companies if their street information starts with numeric value");
        System.out.println(filter(getAllCompanies(),company -> Character.isDigit(company.getAddress().getStreet().charAt(0))));

        System.out.println("get the single employee with id information. If there is no employee with the id then throw exception");
        System.out.println(getId(getAllEmployees(),employee -> employee.getId()==99));


        System.out.println("get the single company with id information. If there is no company with the id then throw exception");
        System.out.println(getId(getAllCompanies(), company-> company.getId()==9));

        System.out.println("get the single address with id information. If there is no address with the id then throw exception");
        System.out.println(getId(getAllAddress(), address-> address.getId()==9));

        System.out.println("show all the employees full name and corresponding age information in one list");
        System.out.println(getSpecificAttributes(getAllEmployees(), employee -> employee.getFullName() + " | " + employee.getAge()));


        System.out.println("show all the employees address information with their age in one list");
        System.out.println(getSpecificAttributes(getAllEmployees(), employee -> employee.getCompany().getAddress() + " | Age: " + employee.getAge()));


        System.out.println("***get just the fullName of all employees if their Id number is even***");
        System.out.println(getSpecificAttributes
                (filter(getAllEmployees(),employee -> employee.getId()%2==0), employee -> employee.getFullName() + " | " + employee.getAge()));

        System.out.println("***just print the employees if their address id is 6");
        System.out.println(filter(getAllEmployees(), employee -> employee.getCompany().getAddress().getId()==6));

        System.out.println("***just print the companies if they are located in address id 2");
        System.out.println(filter(getAllCompanies(), company -> company.getAddress().getId()==2));

        System.out.println("***get one employee with id and if she/he is older than 50 promote her/him - create an PromotedEmployee object with any information");
        System.out.println(promote(filter(getAllEmployees(),employee -> employee.getAge()>50), employee ->
                new PromotedEmployee((rand<4)?MANAGER:(rand<8)?SUPERVISOR:CEO,(rand<3)?100000:(rand<6)?120000:130000,employee)));

        System.out.println("***get all female employees older than 45 and promote all with 100.000 salary and manager role");
        System.out.println(promote(filter(getAllEmployees(),employee -> employee.getGender()==FEMALE||employee.getAge()>45), employee ->
                new PromotedEmployee(MANAGER,100000,employee)));

        System.out.println("***print all employees***");
        Consumer<List<Employee>> displayEmployee = System.out::println;
        displayEmployee.accept(filter(getAllEmployees(),employee -> true));


        System.out.println("print all companies");
        Consumer<List<Company>> displayCompanies= System.out::println;
        displayCompanies.accept(filter(getAllCompanies(),company -> true));

        System.out.println("print all address");
        Consumer<List<Address>> displayAddresses= System.out::println;
        displayAddresses.accept(filter(getAllAddress(),address -> true));


        System.out.println("***SORTING QUESTIONS***");

        System.out.println("***sort all employees with id in ascending order***");
        getAllEmployees().sort( (o1,o2)-> o1.getId().compareTo(o2.getId()) );
        System.out.println(getAllEmployees());

        System.out.println("***sort all employees with id in descending order***");
        getAllEmployees().sort( (o1,o2)-> o2.getId().compareTo(o1.getId()) );
        System.out.println(getAllEmployees());

        System.out.println("sort all employees with age in ascending order");
        getAllEmployees().sort(Comparator.comparing(Employee::getAge));
        System.out.println(getAllEmployees());

        System.out.println("sort all employees with age in descending order");
        getAllEmployees().sort(Comparator.comparing(Employee::getAge).reversed());
        System.out.println(getAllEmployees());

        System.out.println("sort all employees with company id in ascending order");
        getAllEmployees().sort(Comparator.comparing(employee -> employee.getCompany().getId()));

    }
}
