package bsu.rfe.java.group6.lab6.Burvan.varA3;


import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JPanel;
import javax.swing.Timer;


public class Field extends JPanel {

                                    // ���� ������������������ ��������
    private boolean paused;
    private boolean paused1;
    private boolean resumeLol;
    


                                    // ������������ ������ �������� �����
    private ArrayList<BouncingBall> balls = new ArrayList<BouncingBall>(10);




                                        // ����� ������ �������� �� ���������� ��������� ������� ActionEvent
                                        // ��� �������� ��� ���������� ������������ ��������� �����,
                                        // ����������� ��������� ActionListener
    private Timer repaintTimer = new Timer(10, new ActionListener() {
        public void actionPerformed(ActionEvent ev) {
                                                // ������ ����������� ������� ActionEvent - ����������� ����
            repaint();
        }
    });


                                        // ����������� ������
    public Field() {
                                            // ���������� ���� ������� ����
        setBackground(Color.WHITE);
                                            // ��������� ������
        repaintTimer.start();
    }



                                          // �������������� �� JPanel ����� ����������� ����������
    public void paintComponent(Graphics g) {
                                              // ������� ������ ������, �������������� �� ������
        super.paintComponent(g);
        Graphics2D canvas = (Graphics2D) g;
                                               // ��������������� ��������� ���������� �� ���� ����� �� ������
        for (BouncingBall ball : balls) {
            ball.paint(canvas);
        }

    }

                                           // ����� ���������� ������ ���� � ������
    public void addBall() {
                                               //����������� � ���������� � ������ ������ ���������� BouncingBall
                                               // ��� ������������� ���������, ��������, �������, �����
                                               // BouncingBall ��������� ��� � ������������
        balls.add(new BouncingBall(this));

    }

                                           // ����� ���������� ������ ��������� � ������
    
    


    public void pause() {
                                               // �������� ����� �����
    	
        	paused = true;
       
    }
    
    public  void pause1() {
        // �������� ����� �����
        paused1 = true;
        paused = true;
        resumeLol = false;

    }
    
    public synchronized void resumeLol() {
        // �������� ����� �����
        paused = false;
        resumeLol = true;
        notifyAll();
    }
       

                                           // ����� ������������������, �.�. ������ ���� ����� �����
                                           // ������������ ���� ������
    public synchronized void resume() {
                                               // ��������� ����� �����
        paused = false;
        paused1 = false;
        
                                               // ����� ��� ��������� ����������� ������
        notifyAll();
    }
    

                                           // ������������������ ����� ��������, ����� �� ��� ���������
                                           // (�� ������� �� ����� �����?)
    public synchronized void canMove(BouncingBall ball) throws
            InterruptedException {

        if (paused) {
        	if ( ball.gettime() > 8)
                wait();
                                               // ���� ����� ����� �������, �� �����, ��������
                                               // ������ ������� ������, ��������
                                               //wait();
                }
        if(paused1)
            if(resumeLol)
            {
                if (ball.gettime() < 8)
                    wait();
            }
            else
                wait();
        
       
        }
    
    
    }

