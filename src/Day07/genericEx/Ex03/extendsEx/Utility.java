package Day07.genericEx.Ex03.extendsEx;

public class Utility {
// printArray 메소드는 제너릭 덕분에 어떤 타입의 배열도 수용할 수 있는 유연한 메소드로 탄생!
      public static <T> void printArray(T[] array){
          for(T element : array) System.out.println(element);
      }


    public static void main(String[] args) {
        String[] strArray = {"Hello" , "Java"};
        Utility.printArray(strArray);
        Integer[] integers = {1,2,3,4,5};
        Utility.printArray(integers);
    }

}
