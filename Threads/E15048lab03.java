package lab03;

class E15048lab03 { 
    public static int [][] a = {{1, 1, 1},
				{1, 1, 1},
				{1, 1, 1}};
    
    public static int [][] b = {{1, 1, 1},
				{1, 1, 1},
				{1, 1, 1}};


    public static void print_matrix(int [][] a) {
        for (int[] a1 : a) {
            for (int j = 0; j < a1.length; j++) {
                System.out.print(a1[j] + " ");
            }
            System.out.println();
        }
    }
    

    public static void main(String [] args) { 
        
        //final long startTime = System.nanoTime();

        int [][] x = Matrix.multiply(b, b);
	print_matrix(x); // see if the multipication is correct 
        
        //final long duration = System.nanoTime() - startTime;
        //System.out.println("\n" + duration/1000000);

    }
}
