import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        try {
            // Ввод строки с операцией
            System.out.println("Введите операцию (например, 3 + 5):");
            String input = scanner.nextLine().trim();

            // Разделяем строку на части
            String[] parts = input.split(" ");

            // Проверка, что в строке ровно 3 части: два числа и один оператор
            if (parts.length != 3) {
                throw new IllegalArgumentException("Неверный формат ввода! Ожидается: число оператор число");
            }

            // Преобразуем числа и операцию
            int num1 = Integer.parseInt(parts[0]);
            int num2 = Integer.parseInt(parts[2]);
            String operator = parts[1];

            // Проверка на допустимые числа (от 1 до 10)
            if (num1 < 1 || num1 > 10 || num2 < 1 || num2 > 10) {
                throw new IllegalArgumentException("Числа должны быть от 1 до 10!");
            }

            int result = 0;

            // Выполнение арифметической операции
            switch (operator) {
                case "+":
                    result = num1 + num2;
                    break;
                case "-":
                    result = num1 - num2;
                    break;
                case "*":
                    result = num1 * num2;
                    break;
                case "/":
                    if (num2 == 0) {
                        throw new ArithmeticException("Деление на ноль невозможно!");
                    }
                    result = num1 / num2;
                    break;
                default:
                    throw new IllegalArgumentException("Неверная арифметическая операция! Ожидаются +, -, *, /");
            }

            // Вывод результата
            System.out.println("Результат: " + result);

        } catch (NumberFormatException e) {
            System.out.println("Ошибка! Ввод должен содержать только целые числа.");
        } catch (IllegalArgumentException | ArithmeticException e) {
            System.out.println("Ошибка! " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
