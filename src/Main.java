import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String myString = scanner.nextLine();
        if (Valid.getValid(myString)) {
            System.out.println(Unbox.unboxing(myString));
        } else {
            System.out.println("Строка не валидна");
        }
    }
}