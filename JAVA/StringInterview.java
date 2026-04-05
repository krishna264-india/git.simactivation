import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.Stack;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StringInterview {
    static List<Employee> employees = Arrays.asList(
 new Employee(1, "Ramesh", 29, "IT", "Mumbai", 100, "Male"),
 new Employee(2, "Suresh", 27, "Sales", "Chennai", 200, "Female"),
 new Employee(3, "Naresh", 28, "IT", "Chennai", 300, "Male"),
 new Employee(4, "Mahesh", 29, "Sales", "Gurgaon", 400, "Male"),
 new Employee(5, "Hesh", 25, "Sales", "Bangalore", 600, "Female"),
 new Employee(6, "Sushmitha", 27, "Admin", "Mumbai", 800, "Female"),
 new Employee(7, "Queen", 30, "Research", "Kochi", 900, "Female")
 );
    public static void main(String[] args) {


        //count number words in string 

        String s="I want java developer";
        int count=0;
        for(int i=0;i<s.length();i++){
            if((s.charAt(i)=='') && (s.charAt(i+1)!='')){
               count++;
            }
        }
        System.out.println(count);
       System.out.println("===================================================");

       //find non repeatiing characters in string

        String input="krishnareddy";
        String firstNonrepeat=Arrays.stream(input.split(""))
                                .collect(Collectors.groupingBy(
                                    Function.identity(), LinkedHashMap::new , Collectors.counting()
                                ))
                                .entrySet()// convert the map to a set of entries
                                .stream()
                                .filter(str-> str.getValue()==1)
                               // .map(Map.Entry::getKey())
                                .findFirst().get().getKey();
                                System.out.println(firstNonrepeat);
        
       //find the Duplicates
       System.out.println("------------duplicates--------------");
       String str="krishnareddy";
    //    int[] fre=new int[26];
    //    for(int i=0;i<str.length();i++){
    //       char ch=str.charAt(i);
    //       fre[ch-'a']++;
    //    }
    //    for(int i=0;i<str.length();i++){
    //     char ch=str.charAt(i);
    //     if(fre[ch-'a']>1){
    //         System.out.println(ch);
    //     }
      // }
       List<String> duplicates=Arrays.stream(str.split(""))
                               .collect(Collectors.groupingBy(Function.identity(),Collectors.counting()))
                               .entrySet().stream()
                               .fileter(s->s.getValue()>1)
                               .map(Map.Entry::getKey)
                               .collect(Collectors.toList());
            System.out.println(duplicates);
    

        System.out.println("------------LongestString--------------");

        String[] strArray={"java", "python","reactjs","springboot","microservices"};
        String longestString=Arrays.stream(strArray)
        .max(Comparator.comparing(String::length))
        .orElse(" ");
                        // .reduce((word1,word2)-> word1.length()>word2.length()?word1:word2)
                        // .get();
                            //  .max((s1,s2)-> s1.length()-s2.length())
                            //  .orElse("");
        System.out.println(longestString);
System.out.println("------------Length of each word--------------");
        List<String> list=Arrays.asList("a","bb","ccc","dddd");
        Map<Integer, List<String>> lengthOfwords=list.stream()
        .collect(Collectors.groupingBy(String::length));
        System.out.println(lengthOfwords);

    System.out.println("------------Stream operations--------------");
      //Find the employee who has second highest salary
 Employee withSecondHighestSalary = employees.stream()
                  .sorted(Comparator.comparing(Employee::getSalary))
                  .skip(1)
                  .findFirst().get();
 System.out.println(withSecondHighestSalary);

//Find the list of employee and sort them by their salary
 List<Employee> employeesWithSortedSalary = employees.stream()
               .sorted(Comparator.comparing(Employee::getSalary))
               .collect(Collectors.toList());
 System.out.println(employeesWithSortedSalary);

//Find the highest salary in each department
 Map<String, Optional<Employee>> highestSalForEachDedpt = employees.stream().
              collect(Collectors.groupingBy(Employee::getDepartNames, Collectors.minBy(Comparator.comparing(Employee::getSalary))));
 System.out.println(highestSalForEachDedpt);

//Find the average salary in all departments
 Map<String, Double> avgSalForEachDept = employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartNames, Collectors.averagingDouble(Employee::getSalary)));
 System.out.println("Average salary of each department " + avgSalForEachDept);

//Find the Employee who stays in Chennai and sort them by their names
 List<Employee> chennaiEmployee = employees.stream()
 .filter(emp -> emp.getAddress()
 .equals("Chennai"))
 .sorted(Comparator.comparing(Employee::getName))
 .collect(Collectors.toList());
 System.out.println("Employee staying in Chnnai and sorted by their names " + chennaiEmployee);
// Find the department who is having maximum number of employee
 Map.Entry<String, Long> deptMaxcount = employees.stream()
 .collect(Collectors.groupingBy(Employee::getDepartNames, Collectors.counting()))
 .entrySet().stream()
 .max(Map.Entry.comparingByValue())
 .get();
 System.out.println("Department having maximum number of employees " + deptMaxcount);


 List<String> words = Arrays.asList("radar", "hello", "deified", "java");

 List<String> palindromes = words.stream()
 .filter(s -> s.toLowerCase().equals(new StringBuilder(s.toLowerCase()).reverse().toString()))
 .collect(Collectors.toList());

 System.out.println("Palindromes: " + palindromes);

System.out.println("------------Revere the string--------------");
 String originalString = "Hello World"; // Step 1: Original string

 String reversedString = originalString
 // Step 1 & 2: Convert the string to a stream of characters and collect into a list
 .chars()
 .mapToObj(c -> (char)c)
 .collect(Collectors.toList())
 // Step 3: Reverse the list
 .stream()
 .sorted(Collections.reverseOrder())
 // Step 4 & 5: Convert the reversed list back into a stream, then collect into a string
 .collect(Collectors.collectingAndThen(Collectors.toList(), list -> {
 Collections.reverse(list);
 return list.stream();
 }))
 .map(String::valueOf)
 .collect(Collectors.joining());

 // Step 6: Display the reversed string
 System.out.println("Original string: " + originalString);
 System.out.println("Reversed string: " + reversedString);

 System.out.println("------------duplicates--------------");
    }

public static String stringCompress(String str) {
    if(str==null || str.isEmpty()) {
       return "";
    }
         int count=1;
     StringBuilder sb=new StringBuilder();
         for(int i=1; i<str.length(); i++) {
               if(str.charAt(i)==str.charAt(i-1)) {// if the character is same as previous one
                     count++;
             }
             else {
                sb.append(count).append(str.charAt(i-1));
                  count=1;
              } 
           }
            sb.append(count).append(str.charAt(str.length()-1));
             return sb.toString();
 }
   static String decodeString(String str){
    StringBuilder sb=new StringBuilder();
    int count=0;
    for(char c:str.toCharArray()){
        if(Character.isDigit(c)){
            count= count*10+Character.getNumericValue(c);
        }
        else{
            sb.append(String.valueOf(c).repeat(count));
            count=0;
        }
    }
    return sb.toString();
   }

 // second frequented name 
      List<String> fruits = Arrays.asList(
    "apple", "banana", "apple", "orange", "banana",
    "apple", "kiwi", "banana", "kiwi"
    );
      
    Map<String, Long> freq= fruits.stream()
                        .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
            
        List<Map.Entry<String,Long>> sorted= freq.entrySet()
                                    .stream()
                                    .sorted(Map.Entry.<String,Long>comparingByValue().reversed()) 
                                    .collect(Collectors.toList());
            if (sorted.size() >= 2) {
            Map.Entry<String, Long> second = sorted.get(1);
            System.out.println("2nd most frequent: " + second.getKey()
           + " (occurs " + second.getValue() + " times)");
        } 
        else {
            System.out.println("No second most frequent element");
       }

       //jp morgan
       String[] input={"java","","streams",""};
           String[] array= Arrays.stream(input)
                  .filter(Objects::nonNull)
                  .filter(s->!s.isBlank())
                  .toArray(String[]::new);
                  System.out.println(array);

/*
 * LeetCode 1513. Number of Substrings With Only 1s
 * Given a binary string s (a string consisting only of '0's and '1's),
 * return the number of substrings with all characters '1's.
 */
         public int numSub(String s) {
            long mod = 1000000007;
            long count=0;
            long len=0;
            for(int i=0;i<s.length();i++){
                if(s.charAt(i)=='1'){
                    count++;
                    len=(len+count)%mod;
                }
                else{
                    count=0;
                }
            }
            return (int)len;
    }
     public int leastInterval(char[] tasks, int n) {
        int[] freq=new int[26];
        for(char c:tasks){
            freq[c-'A']++;
        }
        Arrays.sort(freq);// Sort the frequencies
        int maxFreq=freq[25]-1;// Maximum frequency minus one
        int idleSlots=maxFreq*n;// Calculate initial idle slots
        for(int i=24;i>=0 && freq[i]>0;i--){
            idleSlots-=Math.min(freq[i],maxFreq);// Fill idle slots with other tasks
            
        }
        // If idleSlots is negative, it means we have enough tasks to fill all slots
        return tasks.length + Math.max(0, idleSlots);
    }

}

