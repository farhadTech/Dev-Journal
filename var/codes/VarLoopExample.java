import java.util.List;

public class VarLoopExample {
    public static void main(String[] args) {
        var list = List.of("Apple", "Banana", "Cherry", "Grape");

        for(var fruit : list) {
            System.out.println(fruit);
        }
    }
}
