import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class SortingInterview {
    public static void main(String[] args){
         List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("Ravi", 30));
        employees.add(new Employee("Bala", 25));
        employees.add(new Employee("Anita", 35));

        employee.stream().sort((e1,e2)->Integer.compare(e2.getAge(),e1.getAge()));

        // Print sorted employees
        for (Employee e : employees) {
            System.out.println(e);
        }

        employess.stream().collect(Collectors.partitioningBy(
            p->p.getAge()%2==0))
            List<Employee> even= partitioned.get(true);

         employees.stream().max(Comparator.comparing(Employee::getAge))
                          .ifPresent(System.out::println);
        

            List<Integer> numbers= Arrays.asList(23,25,100,98,99);

            int max= numbers.stream().max(Integer::compare).orElse(0);

            int evenNumber= numbers.stream().
                             .collect(Collectors.partitioningBy(num-> num%2==0));

            int sort = numbers.stream().sorted().collect(Collectors.toList());

            


    }
}
