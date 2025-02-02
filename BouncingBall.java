import java.awt.*;
import java.awt.event.*;

public class BouncingBall extends Frame implements ActionListener
{
    Button b1, b2 ;
    Panel p, q;

    public BouncingBall()
    {
        super("Bouncing Ball:");
        b1 = new Button("New Object");
        b2 = new Button("Exit");
        b1.addActionListener(this);
        b2.addActionListener(this);
        p = new Panel();
        p.add(b1);
        p.add(b2);
        add(p, BorderLayout.SOUTH);
        q = new Panel();
        add(q, BorderLayout.CENTER);
        setSize(380,220);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e)
    {
        Button b = (Button)e.getSource();
        if( b== b2)
        {
            System.exit(0);
        }
        else
        {
            Ball a = new Ball(q);
        }
    }

    public static void main(String[] args)
    {
        BouncingBall bb = new BouncingBall();
    }
}

class Ball extends Thread
{
    Panel box;
    static final int w = 10;
    static final int h = 10;
    int x, y;
    int dx, dy;
    Color cr;

    public Ball(Panel b)
    {
        super();
        box = b;
        x = 0;
        y = (int)Math.random() * 100;
        cr = new Color((int)Math.random()*255,(int)Math.random()*255,(int)Math.random()*255);
        dx = dy = 2;
        start();
    }

    public void run()
    {
        while(true)
        {
            move();
            try
            {
                Thread.sleep(10);
            }
            catch(Exception e)
            {

            }
        }
    }

    void move()
    {
        Graphics g = box.getGraphics();
        g.setColor(Color.white);
        g.fillOval(x, y, w, h);
        x += dx;
        y += dy;
        g.setColor(cr);
        g.fillOval(x, y, w, h);
        if( x < 0)
        {
            x = 0;
            dx = -dx;
        }
        if((x+w) >= 400)
        {
            x = 400 - w;
            dx = -dx;
        }
        if( y < 0)
        {
            y = 0;
            dy = -dy;
        }
        if((y+h) >= 300)
        {
            y = 300 - h;
            dy = -dy;
        }
    }
}