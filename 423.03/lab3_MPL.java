        //package lab3_MPL;


        import com.jogamp.opengl.GL2;
        import  com.jogamp.opengl.GLAutoDrawable;
        import  com.jogamp.opengl.GLEventListener;
        import  com.jogamp.opengl.glu.GLU;


        public class lab3_MPL implements GLEventListener {

            private GLU glu;


            @Override
            public void init(GLAutoDrawable gld) {
                GL2 gl = gld.getGL().getGL2();    
                glu = new GLU();

                gl.glClearColor(1.0f, 1.0f, 1.0f, 1.0f);
                gl.glViewport(-250, -150, 250, 150);
                gl.glMatrixMode(GL2.GL_PROJECTION);
                gl.glLoadIdentity();
                glu.gluOrtho2D(-250.0, 250.0, -150.0, 150.0);
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

                DrawMPL(gl,10,10,60,50);
                DrawMPL(gl,10,-10,60,-50);
                DrawMPL(gl,-30,-10,-100,-40);




            }

            @Override
            public void reshape(GLAutoDrawable drawable, int x, int y, int width, int height) {
                //do nothing
            }

            public void displayChanged(GLAutoDrawable drawable, boolean modeChanged, boolean deviceChanged) {
                //do nothing
            }

            private void DrawMPL(GL2 gl, float x1, float y1, float x2, float y2) {
                 

                 float x,y;
                 float dx,dy;
                 float d;
                   float zone=FindZone(x1,y1,x2,y2);
                   float x1New=convertX0(x1,y1,zone);
                   float y1New=convertY0(x1,y1,zone);
                   float x2New=convertX0(x2,y2,zone);
                   float y2New=convertY0(x2,y2,zone);
                   dx=x2New-x1New;
                   dy=y2New-y1New;
                   d=dy-(dx/2);
                   float dE=2*dy;
                   float dNE=2*dy-2*dx;


                 x=x1New;
                 y=y1New;
                 while(x<x2New && y<y2New) {
                   if(d<0) {
                           x=x+1;
                           d=d+ dE;
                           gl.glPointSize(1.0f);
                            gl.glColor3d(1, 0, 0);
                           gl.glBegin(GL2.GL_POINTS); 
                           gl.glVertex2f(convertXinit(x,y,zone),convertYinit(x,y,zone));
                           gl.glEnd();
                   }
                   else {
                           x=x+1;
                           y=y+1;
                           d=d+dNE;
                           gl.glPointSize(1.0f);
                            gl.glColor3d(1, 0, 0);
                           gl.glBegin(GL2.GL_POINTS);
                           gl.glVertex2f(convertXinit(x,y,zone),convertYinit(x,y,zone));
                           gl.glEnd();
                   }

                 }

                 
              }
                //y=mx+b
//            private int func(int x, float y){
//                return (int)(dy*x - y*dx + b*dx);
//            }


              float FindZone(float x1,float y1, float x2, float y2) {
                float dx=x2-x1;
                float dy=y2-y1;
                float zone=0;
                if(Math.abs(dx)>=Math.abs(dy)) {
                        if(dx>0 && dy>0) {
                                zone=0;
                        }
                        else if(dx>0 && dy<0) {
                                zone=7;
                        }
                        else if(dx<0 && dy<0) {
                                zone=4;
                        }
                        else if(dx<0 && dy>0) {
                                zone= 3;
                        }
                }
                else {
                        if(dx>0 && dy>0) {
                                zone= 1;
                        }
                        else if(dx>0 && dy<0) {
                                zone= 6;
                        }
                        else if(dx<0 && dy<0) {
                                zone= 5;
                        }
                        else if(dx<0 && dy>0) {
                                zone= 2;
                        }
                }
                return zone;
              }
              float convertX0(float x, float y, float zone) {
                float c_X=0;
                if(zone==0) {
                        c_X=x;
                        }
                else if(zone==1) {
                        c_X=y;
                        }
                else if(zone==2) {
                        c_X=y;
                        }
                else if(zone==3) {c_X=-x;}
                else if(zone==4) {c_X=-x;}
                else if(zone==5) {c_X=-y;}
                else if(zone==6) {c_X=-y;}
                else if(zone==7) {c_X=x;}
                return c_X;
              }
              float convertY0(float x, float y, float zone) {
                float c_Y=0;
                if(zone==0) {c_Y=y;}
                else if(zone==1) {c_Y=x;}
                else if(zone==2) {c_Y=-x;}
                else if(zone==3) {c_Y=y;}
                else if(zone==4) {c_Y=-y;}
                else if(zone==5) {c_Y=-x;}
                else if(zone==6) {c_Y=x;}
                else if(zone==7) {c_Y=-y;}
                return c_Y;

              }
              float convertXinit(float x, float y, float zone) {
                float c_X=0;
                if(zone==0) {c_X=x;}
                else if(zone==1) {c_X=y;}
                else if(zone==2) {c_X=-y;}
                else if(zone==3) {c_X=-x;}
                else if(zone==4) {c_X=-x;}
                else if(zone==5) {c_X=-y;}
                else if(zone==6) {c_X=y;}
                else if(zone==7) {c_X=x;}
                return c_X;
              }
              float convertYinit(float x, float y, float zone) {
                float c_Y=0;
                if(zone==0) {c_Y=y;}
                else if(zone==1) {c_Y=x;}
                else if(zone==2) {c_Y=x;}
                else if(zone==3) {c_Y=y;}
                else if(zone==4) {c_Y=-y;}
                else if(zone==5) {c_Y=-x;}
                else if(zone==6) {c_Y=-x;}
                else if(zone==7) {c_Y=-y;}
                return c_Y;

              }
            @Override
                    public void dispose(GLAutoDrawable arg0) {
                  //do nothing
              }


          }
