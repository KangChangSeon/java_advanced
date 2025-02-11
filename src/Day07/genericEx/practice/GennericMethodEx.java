package Day07.genericEx.practice;

//어떤 타입의 배열을 받아 요소를 출력하는 제너릭 메서드 printArray를 작성하세요
public class GennericMethodEx<T>{

        public static <T> void printArray(T[] array) {
            for (T data : array) {
                System.out.print(data + " ");
            }
            System.out.println();
        }

    public static void main(String[] args) {
        String[] arr = {"a", "b", "c"};
        printArray(arr);


    }

}
