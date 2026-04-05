import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class StreamQuestion {
    public static void main(String[] args) {
        // We have a list of integers. Find out all the numbers starting with 1 using stream function
       //a. 11, 18, 20, 24, 85, 66, 13
       List<Integer> numbers=Arrays.asList( 11, 18, 20, 24, 85, 66, 13);
          int result = numbers.stream()
                .map(String::valueOf)
                .filter(s->s.startsWith("1"))
                .forEach(System.out::println);

       /*
         We have a list of employees, in which we have id, name, age, gender and salary.
         a. How many male and female employees are there in the organization.
         b. Take out average salary based on employee gender.
        */

         Employee emp1=new Employee(1,"John",28,"Male",50000);
         Employee emp2=new Employee(2,"Alice",24,"Female",60000);
            Employee emp3=new Employee(3,"Bob",30,"Male",55000);
            Employee emp4=new Employee(4,"Diana",26,"Female",62000);
            List<Employee> employees=Arrays.asList(emp1,emp2,emp3,emp4);
            long maleCount = employees.stream()
                    .filter(e -> e.getGender().equalsIgnoreCase("Male"))
                    .count();   
            long femaleCount = employees.stream()
                    .filter(e -> e.getGender().equalsIgnoreCase("Female"))
                    .count();
            double averageMaleSalary = employees.stream()
                    .filter(e -> e.getGender().equalsIgnoreCase("Male"))
                    .mapToDouble(Employee::getSalary)
                    .average()
                    .orElse(0.0);
            double averageFemaleSalary = employees.stream()
                    .filter(e -> e.getGender().equalsIgnoreCase("Female"))
                    .mapToDouble(Employee::getSalary)   
                    .average()
                    .orElse(0.0);
            System.out.println("Average Male Salary: " + averageMaleSalary);
            System.out.println("Average Female Salary: " + averageFemaleSalary);
            System.out.println("Male Employees: " + maleCount);
            System.out.println("Female  Employees: " + femaleCount);
/*
Write a java program to find sum of even numbers and sum of odd numbers in a given 
list using java 8 streams.
 */
            List<Integer> numList=Arrays.asList(1,2,3,4,5,6,7,8,9,10);
            int evenSum = numList.stream()
                    .filter(n -> n % 2 == 0)
                    .mapToInt(Integer::intValue)
                    .sum();
            int oddSum = numList.stream()
                    .filter(n -> n % 2 != 0)
                    .mapToInt(Integer::intValue)
                    .sum();
            System.out.println("Sum of Even Numbers: " + evenSum);
            System.out.println("Sum of Odd Numbers: " + oddSum);
//How to find duplicate elements in a given integers list in java using Streams function.
            List<Integer> intList=Arrays.asList(1,2,3,4,5,3,2,6,7,8,1);
            System.out.println("Duplicate Elements:");
                 int duplicate = intList.stream()
                    .filter(i -> intList.indexOf(i) != intList.lastIndexOf(i))
                    .distinct()
                    .forEach(System.out::println);
/* I need to compare if two arrays are same, but the order does not matter, just compare the elements in arr1 to elements in arr2
a. arr1 = [3, 2, 5, 7]
b. arr2 = [2, 3, 5, 7]
 */
            int[] arr1 = {3, 2, 5, 7};
            int[] arr2 = {2, 3, 5, 7};
            List<Integer> list1 = IntStream.of(arr1).boxed().toList();
            List<Integer> list2 = IntStream.of(arr2).boxed().toList();
              list1.stream()
              .filter(list2::contains)
              .forEach(System.out::println);

            Arrays.sort(arr1);
            Arrays.sort(arr2);
            boolean areEqual = Arrays.equals(arr1, arr2);
            System.out.println("Are the two arrays equal (order does not matter)? " + areEqual);
//I will provide a string, remove all the occurrences of a given character from that string?
            String input = "banana";
            char remove = 'a';

           String result = input.replaceAll(remove + "", "");
           System.out.println(result); 

    //Write Java 8 Stream code to group employees by department and find the highest salary per department.
           Employee e1 = Arrays.asList(
                new Employee(1, "John", "IT", 70000),
                new Employee(2, "Alice", "HR", 60000),
                new Employee(3, "Bob", "IT", 80000),
                new Employee(4, "Diana", "Finance", 90000),
                new Employee(5, "Eve", "HR", 75000)
        );
        Map<String, Optional<Employee>> highestSalaryByDept = e1.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment,
                        Collectors.maxBy(Comparator.comparing(Employee::getSalary))));
            highestSalaryByDept.forEach((dept, emp) -> {
                emp.ifPresent(e -> System.out.println("Department: " + dept + ", Highest Salary: " + e.getSalary()));
            });
        // square of add numbers and even numbers in a given list and find sum of them;
        List<Integer> numberList = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        int sumOfSquares = numberList.stream()
        .filter(n->n%2==0)
        .mapToInt(n->n*n)// square of even numbers
        .sum() + numberList.stream()
        .filter(n->n%2!=0)
        .mapToInt(n->n*n)// square of odd numbers
        .sum();
        System.out.println("Sum of squares of even and odd numbers: " + sumOfSquares);
// Remove duplicates & add back duplicates
        List<Integer> nums = Arrays.asList(1, 2, 3, 2, 4, 5, 3, 6);
        List<Integer> distinctList = nums.stream()
                .distinct()
                .collect(Collectors.toList());
        System.out.println("List after removing duplicates: " + distinctList);
        // duplicate elements
        List<Integer> duplicates = nums.stream()
                .filter(n -> nums.indexOf(n) != nums.lastIndexOf(n))
                .distinct()
                .collect(Collectors.toList());
        System.out.println("Duplicate elements: " + duplicates);
//Find the 2nd highest element
        List<Integer> values = Arrays.asList(10, 5, 8, 12, 7, 15, 20);
        Integer secondHighest = values.stream()
                .distinct()
                .sorted(Comparator.reverseOrder())
                .skip(1)
                .findFirst()
                .orElse(null);
        System.out.println("Second highest element: " + secondHighest);
//Count occurrences of each element
        List<String> items = Arrays.asList("apple", "banana", "apple", "orange", "banana", "apple");
        Map<String, Long> occurrenceMap = items.stream()
                .collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
        System.out.println("Occurrences of each element: " + occurrenceMap);
// Find last element of a list
        List<String> fruits = Arrays.asList("apple", "banana", "orange", "grape");
        String lastElement = fruits.stream()
                .reduce((first, second) -> second)// get last element
                .orElse(null);
        System.out.println("Last element of the list: " + lastElement);
// Check if two strings are equal
        String str1 = "hello";
        String str2 = "hello";
        boolean areStringsEqual = IntStream.range(0, str1.length())
                .allMatch(i -> str1.charAt(i) == str2.charAt(i));
        System.out.println("Are the two strings equal? " + areStringsEqual);


        // Java Streams - Find Top 3 Max and Min Numbers
        List<Integer> numList2 = Arrays.asList(5, 3, 8, 1, 4, 7, 9, 2, 6);
        List<Integer> top3Max = numList2.stream()
                .sorted(Comparator.reverseOrder())
                .limit(3)
                .collect(Collectors.toList());
        List<Integer> top3Min = numList2.stream()
                .sorted()
                .limit(3)
                .collect(Collectors.toList());
        System.out.println("Top 3 Max Numbers: " + top3Max);
        System.out.println("Top 3 Min Numbers: " + top3Min);

  List<String> fruit=Arrays.asList("apple","banana","orange","grape","",null);
  // find the longest string in the list
  //remove empty strings and null values from the list

        String longestFruit=fruit.stream()
                .filter(s ->!s.isBlank())// remove empty strings
                .filter(Objects::nonNull) // remove null values

                .max(Comparator.comparingInt(String::length))
                .orElse(null);
    }
}
