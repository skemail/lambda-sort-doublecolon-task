package cydeo;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.function.BiFunction;
import java.util.function.Function;
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

    public static <T> T getId(List<T> elements,Predicate<T> predicate){

        for (T element : elements) {
           if(predicate.test(element)){
               return element;
           }
        }

        throw new RuntimeException("Id not find") ;
    }


    public static <T> List<String> getSpecificAttributes(List<T> elements, Function<T,String> function){

        List<String> result = new ArrayList<>();

        for (T element : elements) {
            result.add((function.apply(element)));
        }

        return result;
    }
    public static List<PromotedEmployee> promote(List<Employee> elements, Function<Employee,PromotedEmployee> function){
        List<PromotedEmployee> result = new ArrayList<>();

        for (Employee element : elements) {
            result.add(function.apply(element));
        }
        return result;
    }
}
