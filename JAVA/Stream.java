import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Stream {
      public static void main(String []args){
        List<Integer> list=Arrays.asList(10,20,40,50,40);
        System.out.println(list);
        Set list1=list.stream().map(x->10+10).collect(Collectors.toSet());
        Set num=list.stream().sorted().collect(Collectors.toSet());
         System.out.println(num);
        // List<Integer> filteIntegers=(List<Integer>) list.stream ().map(x->2*2);

        record Item(String name,int quantity, double price){

        }
        record Order(String orderId,String customerName,List<Item> items){

        }
        record OrderSummary(String orderId, String customerName,int totalItems,double totalAmount){

        }
        List<Order> orders=Arrays.asList(new Order("OD234", "Krishna" ,List.of(new Item("NoteBook",9,25.00), new Item("pencoials",3,15.00))),
                                         new Order("OD235", "Venu" ,List.of(new Item("Pen",2,17.00),new Item("eraser",2,8.00))),
                                         new Order("OD235", "Venu" ,List.of(new Item("Marker",2,12.00),new Item("Water Bottle",1,21.00)))
                                         );
            List<OrderSummary> orderSummaries=orders.stream()
                                              .map(order->{
                                                int totalItems=order.items().stream().mapToInt(Item::quantity).sum();
                                                double totalAmount=order.items().stream().mapToDouble(item->item.price()*item.quantity()).sum();
                                                new OrderSummary(order.orderId(),order.customerName(),totalItems,totalAmount);
                                              })
                                              .collect(Collectors.toList());

            List<OrderSummary> orderSummaries1=orders.stream()
                                               .map(order-> order.items().stream().collect(
                                                Collectors.summarizingInt(Item::quantity),
                                                Collectors.summarizingDouble(item->item.price()*item.quantity()),
                                                (totalItems,totalAmount)-> new OrderSummary(order.orderId(),order.customerName(),totalItems,totalAmount)
                                               ))
                                               .collect(Collectors.toList());
        record Employee(String name,List<String> skills){

        }
        final List<String> requiredSkills=List.of("javaScript","React");
        List<Employee> employees=Arrays.asList(new Employee("Mercury", List.of("javaScript","React","Node.js")),
                                               new Employee("Mars", List.of("Java","Spring", "react","Node.js")),
                                               new Employee("Venus",List.of("JavaScript","React")),
                                               new Employee("Uranus", List.of("Python","Django"))
                                               );
                            List<String> result=employees.stream()
                                                .filter(employee-> new HashSet<>(employee.skills()).containsAll(requiredSkills))
                                                .map(Employee::name)
                                                .toList();

          List<Employee> employees = Arrays.asList(
            new Employee(101, "Alice", 60000),
            new Employee(102, "Bob", 75000),
            new Employee(103, "Charlie", 90000)
            );

            List<String> names=employees.stream()
                                         .filter(name->name.startsWith("A"));
                                         .collect(Collectors.toList());
                
                   names.forEach(System.out::println);
                   
                Optional<Employee> highestpaid=employees.stream()
                                               .max(Comparator.comparingDouble(Employee::getSalary));

                            highestpaid.isPresent(emp->
                            System.out.println("Highest Paid Employee: " + emp));   
                            
        Map<Integer,Double> idToSalaryMap = employees.stream()
                                            .collect(Collectors.toMap(
                                                Employee::getId,
                                                Employee::getSalary
                                            ));

                        idToSalaryMap.forEach((id, salary) ->
                                    System.out.println("ID: " + id + ", Salary: $" + salary));
    }
    
}
