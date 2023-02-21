class Solution {
    public String largestNumber(int[] nums) {
        Comparator<String> comp = (x, y) -> (y+x).compareTo((x+y));

        List<String> numbers = Arrays.stream(nums)
                                    .mapToObj(Integer::toString)
                                    .sorted(comp)
                                    .toList();
        

        String number = String.join("", numbers);

        return (number.charAt(0) == '0')? "0" : number;
    }
}
