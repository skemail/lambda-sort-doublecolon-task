package cydeo;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class Service {


    public static List<Address> getAllAddress() {
        return DataGenerator.ADDRESS_LIST;
    }

    public static List<Company> getAllCompanies() {
        return DataGenerator.COMPANY_LIST;
    }

    public static List<Employee> getAllEmployees() {
        return DataGenerator.EMPLOYEE_LIST;
    }


    //***********DEFINE YOUR NECESSARY METHODS HERE***********

    public static <T> List<T> filter(List<T> elements, Predicate<T> predicate) {
        List<T> result = new ArrayList<>();

        for (T element : elements) {
            if (predicate.test(element)) {
                result.add(element);
            }
        }
        return result;
    }

}
