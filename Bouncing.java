
package bouncing;
import java.applet.Applet;
import java.awt.*;

public class Bouncing extends Applet implements Runnable {
    int x=150,y=50,r=20;
    int dx=11,dy=7;
    int p=100,q=50,r1=15;
    int dp=10,dq=8;
    int u=100,v=100,r2=20;
    int du=13,dv=10;
    Thread t,t1,t2;
    boolean stopFlag;
    public void start()
    {
        t=new Thread(this);
       t1 =new Thread(this);
       t2=new Thread(this);
        stopFlag =false;
        t.start();
        t1.start();
        t2.start();
    }
    public void paint(Graphics g)    
    {
        setBackground(Color.yellow);
        g.setColor(Color.red);
        g.fillOval(x-r, y-r, r*2, r*2);
        Font f=new Font("TimesNewRoman",15,48);
        g.setFont(f);
        g.drawString("  I LOVE YOU SOUMO,U R MINE & I AM YOURS", 100,250);
        g.setColor(Color.blue);
        g.fillOval(p-r1, q-r1, r1*2, r1*2);
        g.setColor(Color.green);
        g.fillOval(u-r2, v-r2, r2*2, r2*2);

    }
    public void run()
    {
        while(true)
        {
            if(stopFlag)
                break;
            if((x-r+dx<0)||(x+r+dx>bounds().width))dx=-dx;
            x=x+dx;
            if((y-r+dy<0)||(y+r+dy>bounds().height))dy=-dy;
            y=y+dy;
            if((p-r1+dp<0)||(p+r1+dp>bounds().width))dp=-dp;
            p=p+dp;
            if((q-r1+dq<0)||(q+r1+dq<bounds().height))dq=-dq;
            q=q+dq;
            if((u-r2+du<0)||(u+r2+du<bounds().width))du=-du;
            u+=du;
            if((v-r2+dv<0)||(v+r2+dv<bounds().height))dv=-dv;
            v+=dv;
            try{
                Thread.sleep(250);
            }catch(Exception e)
            {
                System.out.println(e);
            }
            repaint();
        }
    }
    public void stop()
    {
        stopFlag=true;
        t=null;
        t1=null;
        t2=null;
    }
    
}
