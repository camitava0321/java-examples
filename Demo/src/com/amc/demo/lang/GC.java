package com.amc.demo.lang;
/** An example of Grabage Collection
 */
public class GC
{

    public static void main (String []args)
    {
        int i=0;
        GrandChild gch = new GrandChild();

        GCChild1 ch1 = new GCChild1();
        GCChild2 ch2 = new GCChild2();

        GCParent par = new GCParent();

        gch=null;
        ch1=null;
        System.gc();
        ch2=null;
        par=null;

        GCChild1 []ch1a = new GCChild1[50];
        ch1 = new GCChild1();
        ch1a[0] = ch1;

        ch1 = null;
        ch1a[0]=null;

        while(true)
        {
            try
            {
                Thread.sleep(500);
                ch1 = new GCChild1();
                if (ch1.total > 30)
                {
                    System.gc();
                }
            }
            catch(InterruptedException e)
            {
            }
        }
    }
}

class GCParent
{
int no;
static int total;

    public GCParent()
    {
        total++;
        no=total;
        System.out.println("Creating GCParent "+no);
    }

    public void finalize()
    {
        System.out.println(".....Cleaning up GCParent "+no);
        total--;
    }
}

class GCChild1 extends GCParent
{
    public GCChild1()
    {
        System.out.println("Creating GCChild1 "+no);
    }

    public void finalize()
    {
        System.out.println(".....Cleaning up GCChild1 "+no);
        total--;
    }
}

class GCChild2 extends GCParent
{
    public GCChild2()
    {
        System.out.println("Creating GCChild2 "+no);
    }

    public void finalize()
    {
        System.out.println(".....Cleaning up GCChild2 "+no);
        total--;
    }
}

class GrandChild extends GCChild1
{

    public GrandChild()
    {
        System.out.println("Creating GrandChild "+no);
    }

    public void finalize()
    {
        System.out.println(".....Cleaning up GrandChild "+no);
        total--;
    }
}


