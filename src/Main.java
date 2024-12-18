import java.util.Scanner;

class Main {

    public static void main(String[] args) {
        Scanner inputString = new Scanner(System.in);

        System.out.println("Введите пример пожалуйста (соблюдите павило ввода) ( 2 + 2 ):");

        String input = inputString.nextLine();

        try {
            String res = calc(input);
            System.out.println("Output: " + res);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }



    public static String calc(String inputString) {

        String[] stringConcatenated = inputString.trim().split(" ");

        if (stringConcatenated.length != 3) {
            throw new IllegalArgumentException("throws Exception // не правильный формат ввода");
        }

        try {
            int a = Integer.parseInt(stringConcatenated[0]);
            int b = Integer.parseInt(stringConcatenated[2]);
            String operator = stringConcatenated[1];

            if (a < 1 || a > 10 || b < 1 || b > 10) {
                throw new IllegalArgumentException("throws Exception // Числа должны быть от 1 до 10 включительно");
            }

            int finishResult;
            switch (operator) {
                case "+":
                    finishResult = a + b;
                    break;
                case "-":
                    finishResult = a - b;
                    break;
                case "*":
                    finishResult = a * b;
                    break;
                case "/":
                    if (b == 0) {
                        throw new ArithmeticException("throws Exception // делить на 0 нельзя!");
                    }
                    finishResult = a / b;
                    break;
                default:
                    throw new IllegalArgumentException("throws Exception // оператор неверен");
            }

            return String.valueOf(finishResult);

        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("throws Exception // пожалуйста вводите только числа");
        }
    }
}
