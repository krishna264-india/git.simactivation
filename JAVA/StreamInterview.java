import java.util.Comparator;
import java.util.List;
import java.util.Map;

public class StreamInterview {
    public static void main(String[] args){
       // Implement an Employee class and sort employees by salary, then name.
       List<Employee> employees = new ArrayList<>();
       employees.add(new Employee(1, "Alice", 30, 50000));
       employees.add(new Employee(2, "Bob", 25, 60000));
       employees.add(new Employee(3, "Charlie", 35, 40000));

         List<Employee> sortedEmployees = employees.stream()
                .sorted(Comparator.comparing(Employee::getSalary)
                .thenComparing(Employee::getName))
                .collect(Collectors.toList());

        // Print sorted employees
        sortedEmployees.forEach(System.out::println);

        // print the names of employees older than 28
         List<String> names = employees.stream()
                   .filter(e->e.getAge()>28)
                   .map(Employee::getName)
                   .collect(Collectors.toList());
         names.forEach(System.out::println);

        // Find the average salary of employees
        double averageSalary = employees.stream()
                .mapToDouble(Employee::getSalary)
                .average()
                .orElse(0.0);
        System.out.println("Average Salary: " + averageSalary);
    // Group employees by age
        Map<Integer, List<Employee>> groupedByAge = employees.stream()
                .collect(Collectors.groupingBy(Employee::getAge));
        groupedByAge.forEach((age, empList) -> {
            System.out.println("Age: " + age);
            empList.forEach(e -> System.out.println("  " + e));
        });
        // Count employees with salary greater than 45000
        long count = employees.stream()
                .filter(e -> e.getSalary() > 45000)
                .count();
    }

    Map<Integer, Optional<Employee>> highestPaidByAge = employees.stream()
            .collect(Collectors.groupingBy(Employee::getAge
                    , Collectors.maxBy(Comparator.comparing(Employee::getSalary)))
            );
//String s="hello world"; remove the vowels from the string using stream functions
            String s="hello world";
            String result=s.chars()//converts string to insttream of characters
                       filter(ch->"aeiouAEIOU".indexOf(ch)==-1)// filter out the vowels
                       .mapToObj(ch->String.valueOf((char)ch))// convert int back to char and then to string
                       .collect(Collectors.joining());// join the characters back to a string
                String result=s.replaceAll("[aeiouAEIOU]", "");// using regex to remove vowels
                String result="";
                for(char ch:s.toCharArray()){
                    if("aeiouAEIOU".indexOf(ch)==-1){
                        result+=ch;
                    }
                }

// there some more employees in the company,find the employee with avaerage salary
            double averageSalary = employees.stream()
            .sorted(Comparator.averagingDouble(Employee::getSalary))
            .findFirst()
                .orElse(null);
// thrid higest salary
    Employee thirdHighestSalary=employees.sttream()
                .sorted(Comparator.comparing(Employee::getSalary).reversed())
                .skip(2)
                .findFirst()
                .orElse(null);
    }



