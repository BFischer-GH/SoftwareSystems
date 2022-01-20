package ss.week4.EXTRA;

public class ECK7_2 {
    // creates a transposed matrix method
    public static int[][] computeTranspose(int [][] matrix){
        int[][] transpose;
        int R = matrix.length;
        int C = matrix[0].length;
        transpose = new int[C][R];
        for (int i = 0; i < C; i++) {
            for (int j = 0; j < R; j++) {
                transpose[i][j] = matrix [j][i];

            }

        }
        return transpose;
    }
// Create print mehtod  of 2D array
    public static void print (int[][] array){
        for(int[] row: array) {
            System.out.print("  ");
            for(int item: row){
                System.out.printf(" %5d", item);
            }
            System.out.println(); //Empty line
        }

    }
// Print example
    public static void main(String[] args) {
        int[][] orig = {
                {1,2,3,4,5,6},
                {10,20,30,40,50,60},
                {100,200,300,400,500,600}
        };
        System.out.println("Original Matrix:" );
        System.out.println();
        print(orig);
        System.out.println();
        System.out.println("Transposed Matrix:");
        System.out.println();
        print(computeTranspose(orig));

    }
}
