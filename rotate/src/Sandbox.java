import java.util.Arrays;

public class Sandbox {

    public static void main(String[] args) {

        int[][] ogArr = new int[][] {
                new int[]{1,2,3},
                new int[]{4,5,6},
                new int[]{7,8,9}
        };

        int[][] result = new int[3][3];

        for (int i = 0; i < ogArr.length; i++) {
           for (int j = 0; j < ogArr.length; j++) {
               int elem = ogArr[i][j];
               int outerIndex = (elem + ogArr.length) % ogArr.length;

               for (int innerIndex = 1; innerIndex <= ogArr.length; innerIndex++) {

                   if (innerIndex == ogArr.length) {

                       if (outerIndex != 0) {
                           result[outerIndex - 1][0] = elem;

                       } else {
                           result[ogArr.length - 1][0] = elem;

                       }

                   } else if (elem <= ogArr.length * (ogArr.length - innerIndex)) {

                       if (outerIndex != 0) {
                           result[outerIndex - 1][innerIndex] = elem;

                       } else {
                           result[ogArr.length - 1][innerIndex] = elem;

                       }

                   }
               }

           }
        }


        for (int[] ints : result) {
            System.out.println(Arrays.toString(ints));
        }
    }

}
