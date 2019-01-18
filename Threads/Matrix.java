package lab03;

public class Matrix extends Thread { 

    private static int [][] a; 
    private static int [][] b; 
    private static int [][] c;
    
    private static int x;
    private static int y; 
    private static int z1; 
    private static int z2; 

    //This construct is used to calculate the required static variables
    public Matrix(int[][] matrixA, int[][] matrixB) {
        
        a = matrixA;
        b = matrixB;
        
        x = matrixA.length;           // a's number of rows
	y =  matrixB[0].length;        // b's no. of columns

	z1 = matrixA[0].length;       // a's no. of columns
	z2 =  matrixB.length;          // b's no. of rows
    }

    //Run method where the matrix multiplication happens
    public void run(){
    
        if(z1 != z2) { 
	    System.out.println("Cannnot multiply");
	    System.exit(0);
	}

        c = new int [x][y]; 
	int i, j, k, s; 

	for(i=0; i<x; i++) 
	    for(j=0; j<y; j++) {
		for(s=0, k=0; k<z1; k++) 
		    s += a[i][k] * b[k][j];
		c[i][j] = s;
	    }

	
    }
    public static int [][] multiply(int [][] a, int [][] b){
                   
        Thread [] threadArray = new Thread [a.length];  //Define a thread array with a size of a's no. of rows
        
        try {
            for(int i=0;i<a.length;i++){
                threadArray[i] = new Matrix(a,b);
                threadArray[i].run();
                threadArray[i].start();
            }
        } catch (NullPointerException e) {
            return null;
        }
        
         //This is where the synchronisation happens
        /* Synchronization is the process where the threads waited until the other threads finished its calculations*/
        try {                      
            for(int i=0;i<a.length;i++){
                threadArray[i].join();
            }
        } catch (InterruptedException e) {
            return null;
        }
        
        return c; 
	
    }

}