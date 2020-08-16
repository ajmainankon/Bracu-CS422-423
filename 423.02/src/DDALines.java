/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.GLEventListener;
import com.jogamp.opengl.glu.GLU;
import java.lang.Math;

/**
 *
 * @author sbiswas.amit
 */
public class DDALines implements GLEventListener {
    public int step = 0;
    /**
     * Interface to the GLU library.
     */
    private GLU glu;

    /**
     * Take care of initialization here.
     * @param gld
     */
    @Override
    public void init(GLAutoDrawable gld) {
        GL2 gl = gld.getGL().getGL2();
        glu = new GLU();

        gl.glClearColor(0.0f, 0.0f, 0.0f, 1.0f);
        gl.glViewport(-500, -500, 500, 500);
        gl.glMatrixMode(GL2.GL_PROJECTION);
        gl.glLoadIdentity();
        glu.gluOrtho2D(-500.0, 500.0, -500.0, 500.0);
    }

    /**
     * Take care of drawing here.
     * @param drawable
     */
    @Override
    public void display(GLAutoDrawable drawable) {
        GL2 gl = drawable.getGL().getGL2();

        gl.glClear(GL2.GL_COLOR_BUFFER_BIT);
        /*
         * put your code here
         */
        // DDA(gl, -100, -50, 60, 70);
        DDA(gl, 40, 40, 100, 140);

    }

    @Override
    public void reshape(GLAutoDrawable drawable, int x, int y, int width, int height) {
        //do nothing
    }

    public void displayChanged(GLAutoDrawable drawable, boolean modeChanged, boolean deviceChanged) {
        //do nothing
    }

    private void DDA(GL2 gl, int x1, int y1, int x2, int y2) {
       //write your own code
       gl.glPointSize(3.0f);
       gl.glColor3d(0, 0.73, 0.44);
       gl.glBegin(GL2.GL_POINTS);

       int delX = x2 - x1;
       int delY = y2 - y1;
       float m = delY/delX;
       
       if(delX>delY){
           step = delX;
       }
       else{
           step = delY;
       }

       int xincr = delX/step;
       int yincr = delY/step;

       gl.glVertex2d(x1, y1);
       gl.glVertex2d(x2, y2);       
       
       if(m<=1){
           for (int i = 0; i <step; i++) {
            gl.glVertex2d(x1, y1);
            gl.glVertex2d(x2, y2); 
            x1 = x1 + xincr;
            y1 = y1 + yincr; 
           }
       }
       else{
        for (int i = 0; i < step; i++) {
            gl.glVertex2d(x1, y1);
            gl.glVertex2d(x2, y2);
            x1 = x1 + Math.round(1/m);
            y1 = y1 + 1; 
           }
       }
   
       gl.glEnd();
    }
    
    public void dispose(GLAutoDrawable arg0) {
        //do nothing
    }
}
