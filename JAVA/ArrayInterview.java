public class ArrayInterview {
    public static void main(String[] args) {
        
    }
    // Method to find the intersection of two arrays
    public int[] intersection(int[] nums1, int[] nums2) {
        
        Set<Integer> set=new HashSet<>();
        for(int num:nums1){
            set.add(num);
        }
        // Store elements of nums1 in a set for quick lookup
        Set<Integer> resultSet=new HashSet<>();
        for(int num:nums2){
            if(set.contains(num)){
                resultSet.add(num);
            }
        }
        // Convert resultSet to array
        int[] result=new int[resultSet.size()];
        int index=0;
        for(int num:resultSet){
            result[index++]=num;// Add each element from the set to the result array
        }
        return result;
    }
}
