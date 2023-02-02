package cydeo;

import net.datafaker.Faker;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class DataGenerator {

    public static final List<Address> ADDRESS_LIST = new ArrayList<>();
    public static final List<Company> COMPANY_LIST = new ArrayList<>();
    public static final List<Employee> EMPLOYEE_LIST = new ArrayList<>();

    private final static Faker FAKER = new Faker();


    public static void createAllAddresses() {

        for (int i = 0; i < 10; i++) {
            ADDRESS_LIST.add(new Address(i + 1, FAKER.address().streetAddress(), FAKER.address().city(), FAKER.address().state(), FAKER.address().zipCode()));
        }

        System.out.println("***for checking your code - GET ALL ADDRESSES***");
        ADDRESS_LIST.forEach(System.out::println);

    }

    public static void createAllCompanies() {
        //COMPANY_LIST.add(new Company(0,"Bank of America",ADDRESS_LIST.get(8)));
        for (int i = 0; i < 10; i++) {
            COMPANY_LIST.add(new Company(i + 1, FAKER.company().name(), ADDRESS_LIST.get(i)));
        }
        System.out.println("***for checking your code - GET ALL COMPANIES***");
        COMPANY_LIST.forEach(System.out::println);
    }

    public static void createAllEmployees() {
        for (int i = 0; i < 100; i++) {
            Gender gender = FAKER.gender().binaryTypes().equals("Female")?Gender.FEMALE:Gender.MALE;
            EMPLOYEE_LIST.add(new Employee(i + 1, FAKER.name().fullName(), gender, (new Random().nextInt(50)) + 20, COMPANY_LIST.get(new Random().nextInt(10))));
        }

        System.out.println("***for checking your code - GET ALL EMPLOYEES***");
        EMPLOYEE_LIST.forEach(System.out::println);

    }

}
