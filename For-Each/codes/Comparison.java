public class Comparison {
    public static void main(String[] args) {

        // Using for-each (Simpler & Readable)
        int[] numbers = {10, 20, 30, 40};

        for(int num : numbers) {
            System.out.println(num);
        }

        // Using Traditional for Loop (More Control)
        for(int i = 0; i < numbers.length; i++) {
            System.out.println("Index of " + i + " is " + numbers[i]);
        }

        // for-each CANNOT modify elements (only modifies the copy):
        for(int num : numbers) {
            num += 5; // Modifying num, but does not change array
        }
        System.out.println(numbers[0]); //Still 10


        // using Traditional for to Modify Elements
        for(int i = 0; i < numbers.length; i++) {
            numbers[i] += 5;
        }
        System.out.println(numbers[0]); // 15
    }
}
