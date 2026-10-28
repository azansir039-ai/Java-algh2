import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RecursionTasks {

    // 1. Числа от 1 до N
    public static void printAscending(int n) {
        printAscendingFrom(1, n);
    }

    private static void printAscendingFrom(int current, int n) {
        if (current > n) return;
        System.out.print(current + (current == n ? "\n" : " "));
        printAscendingFrom(current + 1, n);
    }

    // 2. Числа от N до 1
    public static void printDescending(int n) {
        if (n <= 0) return;
        System.out.print(n + (n == 1 ? "\n" : " "));
        printDescending(n - 1);
    }

    // 3. Сумма чисел от 1 до N
    public static long sumToN(int n) {
        if (n <= 0) return 0;
        return n + sumToN(n - 1);
    }

    // 4. Факториал
    public static long factorial(int n) {
        if (n < 0) throw new IllegalArgumentException("n must be non-negative");
        if (n <= 1) return 1;
        return (long) n * factorial(n - 1);
    }

    // 5. Возведение в степень
    public static long power(int a, int n) {
        if (n < 0) throw new IllegalArgumentException("n must be non-negative");
        if (n == 0) return 1;
        return (long) a * power(a, n - 1);
    }

    // 6. Сумма цифр
    public static int sumDigits(int n) {
        long value = Math.abs((long) n);
        return sumDigitsPositive(value);
    }

    private static int sumDigitsPositive(long n) {
        if (n < 10) return (int) n;
        return (int) (n % 10) + sumDigitsPositive(n / 10);
    }

    // 7. Количество цифр неотрицательного числа
    public static int countDigits(int n) {
        if (n < 0) throw new IllegalArgumentException("n must be non-negative");
        if (n < 10) return 1;
        return 1 + countDigits(n / 10);
    }

    // 8. Произведение цифр
    public static int productDigits(int n) {
        long value = Math.abs((long) n);
        return productDigitsPositive(value);
    }

    private static int productDigitsPositive(long n) {
        if (n < 10) return (int) n;
        return (int) (n % 10) * productDigitsPositive(n / 10);
    }

    // 9. Максимальная цифра
    public static int maxDigit(int n) {
        return maxDigitPositive(Math.abs((long) n));
    }

    private static int maxDigitPositive(long n) {
        if (n < 10) return (int) n;
        return Math.max((int) (n % 10), maxDigitPositive(n / 10));
    }

    // 10. Минимальная цифра
    public static int minDigit(int n) {
        return minDigitPositive(Math.abs((long) n));
    }

    private static int minDigitPositive(long n) {
        if (n < 10) return (int) n;
        return Math.min((int) (n % 10), minDigitPositive(n / 10));
    }

    // 11. Число Фибоначчи: F(0) = 0, F(1) = 1
    public static long fibonacci(int n) {
        if (n < 0) throw new IllegalArgumentException("n must be non-negative");
        if (n <= 1) return n;
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    // 12. Сумма элементов массива, начиная с index
    public static long arraySum(int[] array, int index) {
        if (index >= array.length) return 0;
        return array[index] + arraySum(array, index + 1);
    }

    // 13. Максимум массива
    public static int arrayMax(int[] array) {
        if (array.length == 0) throw new IllegalArgumentException("Array is empty");
        return arrayMaxFrom(array, 0);
    }

    private static int arrayMaxFrom(int[] array, int index) {
        if (index == array.length - 1) return array[index];
        return Math.max(array[index], arrayMaxFrom(array, index + 1));
    }

    // 14. Минимум массива
    public static int arrayMin(int[] array) {
        if (array.length == 0) throw new IllegalArgumentException("Array is empty");
        return arrayMinFrom(array, 0);
    }

    private static int arrayMinFrom(int[] array, int index) {
        if (index == array.length - 1) return array[index];
        return Math.min(array[index], arrayMinFrom(array, index + 1));
    }

    // 15. Количество чётных элементов
    public static int countEven(int[] array, int index) {
        if (index >= array.length) return 0;
        return (array[index] % 2 == 0 ? 1 : 0) + countEven(array, index + 1);
    }

    // 16. Проверка сортировки по неубыванию
    public static boolean isAscending(int[] array) {
        return isAscendingFrom(array, 0);
    }

    private static boolean isAscendingFrom(int[] array, int index) {
        if (index >= array.length - 1) return true;
        return array[index] <= array[index + 1] && isAscendingFrom(array, index + 1);
    }

    // 17. НОД по алгоритму Евклида
    public static int gcd(int a, int b) {
        long result = gcdPositive(Math.abs((long) a), Math.abs((long) b));
        return Math.toIntExact(result);
    }

    private static long gcdPositive(long a, long b) {
        if (b == 0) return a;
        return gcdPositive(b, a % b);
    }

    // 18. НОК положительных чисел
    public static long lcm(int a, int b) {
        if (a <= 0 || b <= 0) {
            throw new IllegalArgumentException("Numbers must be positive");
        }
        return (long) a / gcd(a, b) * b;
    }

    // 19. Вывод положительного числа в двоичной системе
    public static void printBinary(int n) {
        if (n <= 0) throw new IllegalArgumentException("n must be positive");
        printBinaryRecursive(n);
        System.out.println();
    }

    private static void printBinaryRecursive(int n) {
        if (n > 1) printBinaryRecursive(n / 2);
        System.out.print(n % 2);
    }

    // 20. Сумма квадратов от 1 до N
    public static long sumSquares(int n) {
        if (n <= 0) return 0;
        return (long) n * n + sumSquares(n - 1);
    }

    // 21. Переворот строки
    public static String reverse(String text) {
        if (text.length() <= 1) return text;
        return reverse(text.substring(1)) + text.charAt(0);
    }

    // 22. Проверка палиндрома
    public static boolean isPalindrome(String text) {
        return isPalindrome(text, 0, text.length() - 1);
    }

    private static boolean isPalindrome(String text, int left, int right) {
        if (left >= right) return true;
        return text.charAt(left) == text.charAt(right)
                && isPalindrome(text, left + 1, right - 1);
    }

    // 23. Количество вхождений символа
    public static int countChar(String text, char target) {
        return countChar(text, target, 0);
    }

    private static int countChar(String text, char target, int index) {
        if (index == text.length()) return 0;
        return (text.charAt(index) == target ? 1 : 0)
                + countChar(text, target, index + 1);
    }

    // 24. Подсчёт английских и русских гласных
    public static int countVowels(String text) {
        return countVowels(text, 0);
    }

    private static int countVowels(String text, int index) {
        if (index == text.length()) return 0;
        char current = Character.toLowerCase(text.charAt(index));
        boolean vowel = "aeiouаеёиоуыэюя".indexOf(current) >= 0;
        return (vowel ? 1 : 0) + countVowels(text, index + 1);
    }

    // 25. Удаление всех вхождений символа
    public static String removeChar(String text, char target) {
        if (text.isEmpty()) return "";
        char first = text.charAt(0);
        String rest = removeChar(text.substring(1), target);
        return first == target ? rest : first + rest;
    }

    // 26. Замена символов
    public static String replaceChar(String text, char oldChar, char newChar) {
        return replaceChar(text, oldChar, newChar, 0);
    }

    private static String replaceChar(String text, char oldChar, char newChar, int index) {
        if (index == text.length()) return "";
        char current = text.charAt(index) == oldChar ? newChar : text.charAt(index);
        return current + replaceChar(text, oldChar, newChar, index + 1);
    }

    // 27. Проверка, что все символы одинаковые
    public static boolean hasSameCharacters(String text) {
        return hasSameCharacters(text, 1);
    }

    private static boolean hasSameCharacters(String text, int index) {
        if (index >= text.length()) return true;
        return text.charAt(index) == text.charAt(0)
                && hasSameCharacters(text, index + 1);
    }

    // 28. Подсчёт слов, разделённых пробелами
    public static int countWords(String text) {
        return countWords(text, 0, false);
    }

    private static int countWords(String text, int index, boolean insideWord) {
        if (index == text.length()) return 0;
        boolean isSpace = text.charAt(index) == ' ';
        int startsWord = !isSpace && !insideWord ? 1 : 0;
        return startsWord + countWords(text, index + 1, !isSpace);
    }

    // 29. Частоты символов и проверка анаграммы
    public static Map<Character, Integer> characterFrequencies(String text) {
        Map<Character, Integer> frequencies = new HashMap<>();
        countFrequencies(text, 0, frequencies);
        return frequencies;
    }

    private static void countFrequencies(
            String text, int index, Map<Character, Integer> frequencies) {
        if (index == text.length()) return;
        char current = text.charAt(index);
        frequencies.put(current, frequencies.getOrDefault(current, 0) + 1);
        countFrequencies(text, index + 1, frequencies);
    }

    public static boolean areAnagrams(String first, String second) {
        return characterFrequencies(first).equals(characterFrequencies(second));
    }

    // 30. Рекурсивное сравнение строк
    public static int compareStrings(String first, String second) {
        return compareStrings(first, second, 0);
    }

    private static int compareStrings(String first, String second, int index) {
        if (index == first.length() || index == second.length()) {
            return first.length() - second.length();
        }
        if (first.charAt(index) != second.charAt(index)) {
            return first.charAt(index) - second.charAt(index);
        }
        return compareStrings(first, second, index + 1);
    }

    // 31. Быстрое возведение в степень за O(log n)
    public static long fastPower(long a, int n) {
        if (n < 0) throw new IllegalArgumentException("n must be non-negative");
        if (n == 0) return 1;
        long half = fastPower(a, n / 2);
        return half * half * (n % 2 == 0 ? 1 : a);
    }

    // 32. Рекурсивный бинарный поиск
    public static int binarySearch(int[] array, int target) {
        return binarySearch(array, target, 0, array.length - 1);
    }

    private static int binarySearch(int[] array, int target, int left, int right) {
        if (left > right) return -1;
        int middle = left + (right - left) / 2;
        if (array[middle] == target) return middle;
        if (target < array[middle]) return binarySearch(array, target, left, middle - 1);
        return binarySearch(array, target, middle + 1, right);
    }

    // 33. Сортировка слиянием
    public static int[] mergeSort(int[] array) {
        int[] result = array.clone();
        mergeSort(result, 0, result.length - 1);
        return result;
    }

    private static void mergeSort(int[] array, int left, int right) {
        if (left >= right) return;
        int middle = left + (right - left) / 2;
        mergeSort(array, left, middle);
        mergeSort(array, middle + 1, right);
        merge(array, left, middle, right);
    }

    private static void merge(int[] array, int left, int middle, int right) {
        int[] merged = new int[right - left + 1];
        int i = left;
        int j = middle + 1;
        int k = 0;

        while (i <= middle && j <= right) {
            merged[k++] = array[i] <= array[j] ? array[i++] : array[j++];
        }
        while (i <= middle) merged[k++] = array[i++];
        while (j <= right) merged[k++] = array[j++];
        System.arraycopy(merged, 0, array, left, merged.length);
    }

    // 34. Быстрая сортировка
    public static void quickSort(int[] array) {
        quickSort(array, 0, array.length - 1);
    }

    private static void quickSort(int[] array, int left, int right) {
        if (left >= right) return;
        int pivotIndex = partition(array, left, right);
        quickSort(array, left, pivotIndex - 1);
        quickSort(array, pivotIndex + 1, right);
    }

    private static int partition(int[] array, int left, int right) {
        int pivot = array[right];
        int boundary = left;
        for (int i = left; i < right; i++) {
            if (array[i] <= pivot) swap(array, boundary++, i);
        }
        swap(array, boundary, right);
        return boundary;
    }

    private static void swap(int[] array, int first, int second) {
        int temporary = array[first];
        array[first] = array[second];
        array[second] = temporary;
    }

    // 35. Ханойская башня
    public static void hanoi(int disks, char from, char to, char auxiliary) {
        if (disks <= 0) return;
        hanoi(disks - 1, from, auxiliary, to);
        System.out.println("Move disk " + disks + " from " + from + " to " + to);
        hanoi(disks - 1, auxiliary, to, from);
    }

    // 36. Все подмножества массива
    public static List<List<Integer>> subsets(int[] array) {
        List<List<Integer>> result = new ArrayList<>();
        buildSubsets(array, 0, new ArrayList<>(), result);
        return result;
    }

    private static void buildSubsets(
            int[] array, int index, List<Integer> current, List<List<Integer>> result) {
        if (index == array.length) {
            result.add(new ArrayList<>(current));
            return;
        }
        buildSubsets(array, index + 1, current, result);
        current.add(array[index]);
        buildSubsets(array, index + 1, current, result);
        current.remove(current.size() - 1);
    }

    // 37. Все уникальные перестановки строки
    public static List<String> uniquePermutations(String text) {
        char[] characters = text.toCharArray();
        Arrays.sort(characters);
        List<String> result = new ArrayList<>();
        buildPermutations(characters, new boolean[characters.length],
                new StringBuilder(), result);
        return result;
    }

    private static void buildPermutations(
            char[] characters, boolean[] used, StringBuilder current, List<String> result) {
        if (current.length() == characters.length) {
            result.add(current.toString());
            return;
        }
        for (int i = 0; i < characters.length; i++) {
            if (used[i]) continue;
            if (i > 0 && characters[i] == characters[i - 1] && !used[i - 1]) continue;
            used[i] = true;
            current.append(characters[i]);
            buildPermutations(characters, used, current, result);
            current.deleteCharAt(current.length() - 1);
            used[i] = false;
        }
    }

    // 38. Поиск пути в лабиринте; координаты результата имеют вид [row, column]
    public static List<int[]> findMazePath(
            int[][] maze, int startRow, int startCol, int endRow, int endCol) {
        if (maze.length == 0 || maze[0].length == 0) return null;
        boolean[][] visited = new boolean[maze.length][maze[0].length];
        List<int[]> path = new ArrayList<>();
        return findMazePath(maze, startRow, startCol, endRow, endCol, visited, path)
                ? path : null;
    }

    private static boolean findMazePath(
            int[][] maze, int row, int col, int endRow, int endCol,
            boolean[][] visited, List<int[]> path) {
        if (row < 0 || row >= maze.length || col < 0 || col >= maze[0].length
                || maze[row][col] == 1 || visited[row][col]) return false;

        visited[row][col] = true;
        path.add(new int[]{row, col});
        if (row == endRow && col == endCol) return true;

        int[] rowSteps = {-1, 1, 0, 0};
        int[] colSteps = {0, 0, -1, 1};
        for (int i = 0; i < rowSteps.length; i++) {
            if (findMazePath(maze, row + rowSteps[i], col + colSteps[i],
                    endRow, endCol, visited, path)) return true;
        }
        path.remove(path.size() - 1);
        return false;
    }

    // 39. Все решения задачи о N ферзях
    public static List<List<String>> solveNQueens(int n) {
        List<List<String>> solutions = new ArrayList<>();
        if (n <= 0) return solutions;
        buildQueens(n, 0, new int[n], new boolean[n],
                new boolean[2 * n - 1], new boolean[2 * n - 1], solutions);
        return solutions;
    }

    private static void buildQueens(
            int n, int row, int[] columns, boolean[] usedColumns,
            boolean[] usedDiagonals1, boolean[] usedDiagonals2,
            List<List<String>> solutions) {
        if (row == n) {
            List<String> board = new ArrayList<>();
            for (int r = 0; r < n; r++) {
                char[] line = new char[n];
                Arrays.fill(line, '.');
                line[columns[r]] = 'Q';
                board.add(new String(line));
            }
            solutions.add(board);
            return;
        }

        for (int col = 0; col < n; col++) {
            int diagonal1 = row - col + n - 1;
            int diagonal2 = row + col;
            if (usedColumns[col] || usedDiagonals1[diagonal1]
                    || usedDiagonals2[diagonal2]) continue;

            columns[row] = col;
            usedColumns[col] = true;
            usedDiagonals1[diagonal1] = true;
            usedDiagonals2[diagonal2] = true;
            buildQueens(n, row + 1, columns, usedColumns,
                    usedDiagonals1, usedDiagonals2, solutions);
            usedColumns[col] = false;
            usedDiagonals1[diagonal1] = false;
            usedDiagonals2[diagonal2] = false;
        }
    }

    // 40. Выражения из цифр с учётом приоритета умножения
    public static List<String> expressionsForTarget(String digits, long target) {
        List<String> result = new ArrayList<>();
        if (digits.isEmpty()) return result;
        buildExpressions(digits, target, 0, 0, 0, new StringBuilder(), result);
        return result;
    }

    private static void buildExpressions(
            String digits, long target, int index, long value, long lastOperand,
            StringBuilder expression, List<String> result) {
        if (index == digits.length()) {
            if (value == target) result.add(expression.toString());
            return;
        }

        long number = 0;
        int originalLength = expression.length();
        for (int end = index; end < digits.length(); end++) {
            if (end > index && digits.charAt(index) == '0') break;
            number = number * 10 + digits.charAt(end) - '0';
            String part = digits.substring(index, end + 1);

            if (index == 0) {
                expression.append(part);
                buildExpressions(digits, target, end + 1, number, number,
                        expression, result);
                expression.setLength(originalLength);
            } else {
                expression.append('+').append(part);
                buildExpressions(digits, target, end + 1, value + number, number,
                        expression, result);
                expression.setLength(originalLength);

                expression.append('-').append(part);
                buildExpressions(digits, target, end + 1, value - number, -number,
                        expression, result);
                expression.setLength(originalLength);

                expression.append('*').append(part);
                buildExpressions(digits, target, end + 1,
                        value - lastOperand + lastOperand * number,
                        lastOperand * number, expression, result);
                expression.setLength(originalLength);
            }
        }
    }

    public static void main(String[] args) {
        int[] sample = {1, 2, 4, 7};
        int[] unsorted = {5, 2, 8, 1};

        System.out.print("1. Числа от 1 до 5: ");
        printAscending(5);
        System.out.print("2. Числа от 5 до 1: ");
        printDescending(5);
        System.out.println("3. Сумма от 1 до 5: " + sumToN(5));
        System.out.println("4. Факториал 5: " + factorial(5));
        System.out.println("5. 2 в степени 10: " + power(2, 10));
        System.out.println("6. Сумма цифр 583: " + sumDigits(583));
        System.out.println("7. Количество цифр в 583: " + countDigits(583));
        System.out.println("8. Произведение цифр 234: " + productDigits(234));
        System.out.println("9. Максимальная цифра в 583: " + maxDigit(583));
        System.out.println("10. Минимальная цифра в 583: " + minDigit(583));
        System.out.println("11. Fibonacci(10): " + fibonacci(10));
        System.out.println("12. Сумма массива: " + arraySum(sample, 0));
        System.out.println("13. Максимум массива: " + arrayMax(sample));
        System.out.println("14. Минимум массива: " + arrayMin(sample));
        System.out.println("15. Чётных элементов: " + countEven(sample, 0));
        System.out.println("16. Массив отсортирован: " + isAscending(sample));
        System.out.println("17. НОД(48, 18): " + gcd(48, 18));
        System.out.println("18. НОК(12, 18): " + lcm(12, 18));
        System.out.print("19. Число 13 в двоичной системе: ");
        printBinary(13);
        System.out.println("20. Сумма квадратов до 3: " + sumSquares(3));
        System.out.println("21. Переворот Java: " + reverse("Java"));
        System.out.println("22. Строка «казак» — палиндром: " + isPalindrome("казак"));
        System.out.println("23. Буква 'a' в banana: " + countChar("banana", 'a'));
        System.out.println("24. Гласных в «Привет, Java»: " + countVowels("Привет, Java"));
        System.out.println("25. Удалить 'a' из banana: " + removeChar("banana", 'a'));
        System.out.println("26. Заменить a на o в banana: " + replaceChar("banana", 'a', 'o'));
        System.out.println("27. Все символы одинаковые: " + hasSameCharacters("aaaaa"));
        System.out.println("28. Слов в строке: " + countWords("one two  three"));
        System.out.println("29. listen и silent — анаграммы: " + areAnagrams("listen", "silent"));
        System.out.println("30. Сравнение abc и abd: " + compareStrings("abc", "abd"));
        System.out.println("31. Быстрое 2 в степени 10: " + fastPower(2, 10));
        System.out.println("32. Индекс числа 4: " + binarySearch(sample, 4));
        System.out.println("33. Сортировка слиянием: " + Arrays.toString(mergeSort(unsorted)));
        int[] quickSorted = unsorted.clone();
        quickSort(quickSorted);
        System.out.println("34. Быстрая сортировка: " + Arrays.toString(quickSorted));
        System.out.println("35. Ханойская башня для 3 дисков:");
        hanoi(3, 'A', 'C', 'B');
        System.out.println("36. Подмножества [1, 2]: " + subsets(new int[]{1, 2}));
        System.out.println("37. Перестановки ABC: " + uniquePermutations("ABC"));

        int[][] maze = {
            {0, 1, 0, 0},
            {0, 0, 0, 1},
            {1, 0, 1, 0},
            {0, 0, 0, 0}
        };
        List<int[]> path = findMazePath(maze, 0, 0, 3, 3);
        System.out.println("38. Путь в лабиринте найден: " + (path != null)
            + (path == null ? "" : ", длина пути: " + path.size()));

        System.out.println("39. Все решения задачи о 4 ферзях: " + solveNQueens(4));
        System.out.println("40. Выражения из 123 с результатом 6: "
            + expressionsForTarget("123", 6));
    }
}