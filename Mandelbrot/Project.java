
//package project;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import javax.swing.JFrame;

public class Project extends JFrame {

    private final int MAX_ITER = 1000;
    private final double scale = 400;
    private final BufferedImage I;
    private double zx, zy, cX, cY;
    private double xNew,yNew;

    public Project() {
        super("Mandelbrot Set");
        setBounds(0, 0, 600, 800);
        setResizable(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        I = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_RGB);
        for (int x = 0; x < getWidth(); x++) {
            for (int y = 0; y < getHeight(); y++) {             
                zx = zy = 0;
                cX = (x - 600/2f) / scale;
                cY = (y - 800/2f) / scale;
                int iter = MAX_ITER;
                
                while (iter > 0) {
                    if(((cX > -1)&&(cX < 1)) && ((cY > -1)&&(cY < 1))){
                        xNew =  (zx * zx - zy * zy + cX);
                        yNew =  (2* zx * zy + cY);

                        zx = xNew;
                        zy = yNew;
        
                    }
                    if((zx*zx + zy*zy)>4){
                            break;
                    }
                    iter--;
                }
                I.setRGB(x, y, iter | (iter << 10));
            }
        }
    }
    
    public Project(float cXMin, float cXMax, float cYMin, float cYMax) {
        super("Mandelbrot Set");
        setBounds(0, 0, 600, 800);
        setResizable(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        I = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_RGB);
        for (int x = 0; x < getWidth(); x++) {
            for (int y = 0; y < getHeight(); y++) {             
                zx = zy = 0;
                cX = (x - 600/2f) / scale;
                cY = (y - 800/2f) / scale;
                int iter = MAX_ITER;
                
                while (iter > 0) {
                    if(((cX > cXMin)&&(cX < cXMax)) && ((cY > cYMin)&&(cY < cYMax))){
                        xNew =  (zx * zx - zy * zy + cX);
                        yNew =  (2* zx * zy + cY);

                        zx = xNew;
                        zy = yNew;
              
                    }
                    if((zx*zx + zy*zy)>4){
                            break;
                    }
                    iter--;
                }
                I.setRGB(x, y, iter | (iter << 10));
            }
        }
    }
    
    public Project(float cXMin, float cXMax, float cYMin, float cYMax, int maxIter) {
        super("Mandelbrot Set");
        setBounds(0, 0, 600, 800);
        setResizable(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        I = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_RGB);
        for (int x = 0; x < getWidth(); x++) {
            for (int y = 0; y < getHeight(); y++) {             
                zx = zy = 0;
                cX = (x - 600/2f) / scale;
                cY = (y - 800/2f) / scale;
                int iter = maxIter;
                
                while (iter > 0) {
                        if(((cX > cXMin)&&(cX < cXMax)) && ((cY > cYMin)&&(cY < cYMax))){
                        xNew =  (zx * zx - zy * zy + cX);
                        yNew =  (2* zx * zy + cY);

                        zx = xNew;
                        zy = yNew;
    
                    }
                    if((zx*zx + zy*zy)>4){
                            break;
                    }
                    iter--;
                }
                I.setRGB(x, y, iter | (iter << 10));
            }
        }
    }

    @Override
    public void paint(Graphics g) {
        g.drawImage(I, 0, 0, this);
    }

    public static void main(String[] args) {
        int arrayLength = args.length;
        if("Mandelbrot".equals(args[0])){
            if(arrayLength == 1){
                new Project().setVisible(true);
            }else if(arrayLength == 5){
                float cXMin = Float.parseFloat(args[1]);
                float cXMax = Float.parseFloat(args[2]);
                float cYMin = Float.parseFloat(args[3]);
                float cYMax = Float.parseFloat(args[4]);
                new Project(cXMin,cXMax,cYMin,cYMax).setVisible(true);
            }else if(arrayLength == 6){
                float cXMin = Float.parseFloat(args[1]);
                float cXMax = Float.parseFloat(args[2]);
                float cYMin = Float.parseFloat(args[3]);
                float cYMax = Float.parseFloat(args[4]);
                int maxIter = Integer.parseInt(args[5]);
                new Project(cXMin,cXMax,cYMin,cYMax,maxIter).setVisible(true);
            }else{
                System.out.println("Number of arguments are invalid.");
            }
           
        }else if("JuliaSet".equals(args[0])){
            System.out.println("JuliaSet");
        }else{
            System.out.println("Wrong fractal shape.");
        }
    }
}

