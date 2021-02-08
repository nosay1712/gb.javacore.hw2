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
