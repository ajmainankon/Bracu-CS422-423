/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package 423.01;

/**
 *
 * @author ajmain
 */
import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.GLCapabilities;
import com.jogamp.opengl.GLEventListener;
import com.jogamp.opengl.GLProfile;
import com.jogamp.opengl.awt.GLCanvas;
import com.jogamp.opengl.glu.GLU;
import java.util.Scanner;
import javax.swing.JFrame;

class ThirdGLEventListener implements GLEventListener {
/**
 * Interface to the GLU library.
 */
private GLU glu;

/**
 * Take care of initialization here.
 */
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
 */
@Override
public void display(GLAutoDrawable drawable) {
    
    int x=0;
    int y=0;
    Scanner myObj = new Scanner(System.in);
    System.out.println("Enter length");
 
    String firstInput = myObj.nextLine();
    x=Integer.parseInt(firstInput);
 
    Scanner myObjj = new Scanner(System.in);
    System.out.println("Enter width");
 
    String secondInput = myObjj.nextLine();
    y=Integer.parseInt(secondInput);
    GL2 gl = drawable.getGL().getGL2();

    gl.glClear(GL2.GL_COLOR_BUFFER_BIT);
    /*
     * put your code here
     */
//    gl.glPointSize(30.0f); //point size of the drawing
//    gl.glColor3d(0, 0, 0); // color korbe drawing ke
//    gl.glBegin(GL2.GL_POINTS); // starts the built in func.
//    gl.glVertex2d(-100, 50);// actual command to draw stuff
//    gl.glEnd(); // ending func.
    
    gl.glLineWidth(2.0f);
    gl.glColor3d(0, 0.73, 0.44);
    gl.glBegin(GL2.GL_LINES);
    
    gl.glVertex2d(0, x);
    gl.glVertex2d(0, 0);
    
    gl.glVertex2d(y, x);
    gl.glVertex2d(0, x);
    
    gl.glVertex2d(y, 0);
    gl.glVertex2d(y, x);
    
    gl.glVertex2d(0, 0);
    gl.glVertex2d(y, 0);
    
    gl.glEnd();
}

@Override
public void reshape(GLAutoDrawable drawable, int x, int y, int width,
        int height) {
}

public void displayChanged(GLAutoDrawable drawable,
        boolean modeChanged, boolean deviceChanged) {
}

@Override
public void dispose(GLAutoDrawable arg0)
{
 
}
}
public class J17101054{
public static void main(String args[])
{
 //getting the capabilities object of GL2 profile
 final GLProfile profile=GLProfile.get(GLProfile.GL2);
 GLCapabilities capabilities=new GLCapabilities(profile);
 // The canvas
 final GLCanvas glcanvas=new GLCanvas(capabilities);
 ThirdGLEventListener b=new ThirdGLEventListener();
 glcanvas.addGLEventListener(b);
 glcanvas.setSize(400, 400);
 //creating frame
 final JFrame frame=new JFrame("JOGL First");
 //adding canvas to frame
 frame.add(glcanvas);
 frame.setSize(1000, 600);
 frame.setVisible(true);
 
 
}
}
