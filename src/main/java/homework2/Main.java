//        1 Напишите метод, на вход которого подаётся двумерный строковый массив размером 4х4. При
//        подаче массива другого размера необходимо бросить исключение MyArraySizeException.

//        2 Далее метод должен пройтись по всем элементам массива, преобразовать в int и
//        просуммировать. Если в каком-то элементе массива преобразование не удалось (например, в
//        ячейке лежит символ или текст вместо числа), должно быть брошено исключение
//        MyArrayDataException с детализацией, в какой именно ячейке лежат неверные данные.

//        3 В методе main() вызвать полученный метод, обработать возможные исключения
//        MyArraySizeException и MyArrayDataException и вывести результат расчета.

package homework2;

public class Main {
    public static void main(String[] args) throws MyArrayDataException, MyArraySizeException{
        String[][] myArray = {
                {"1", "2", "3", "4"},
                {"1", "2", "3", "4"},
                {"1", "2", "3", "4"},
                {"1", "2", "3", "4"}
        };
        checkArray(myArray);
    }
    public static void checkArray(String[][] array) throws MyArraySizeException, MyArrayDataException {
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            if (array.length != 4 || array[i].length !=4){
                throw new MyArraySizeException("Массив отличается от заданного размера 4x4");
            } else {
                for (int j = 0; j < array.length; j++) {
                    if (isDigit(array[i][j])){
                        sum += Integer.parseInt(array[i][j]);
                    } else {
                        throw new MyArrayDataException(String.format("В ячейке [%s], [%s] массива не число", i, j));
                    }
                }
            }
        }
        System.out.println("Массив соответствует заданому размеру 4х4");
        System.out.println("Сумма элементов массива = " + sum);
    }

    public static boolean isDigit(String s){
        try {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException e){
            return false;
        }
    }
}
