package com.amc.demo.lang;
import java.util.Stack;

public class Threads implements Runnable
{

public static Stack stack = new Stack();


public void run()
{
    try
    {
    while (true)
      {
      stack.push(new Double(Math.random()*100.0));
      Thread.sleep(100);
      }
    }catch (InterruptedException exc)
    {
    }
}

public static void main(String []args)
{
  Threads Threads = new Threads();
  new Thread(Threads).start();

  AccessorThreads []threads = new AccessorThreads[10];
  for (int i=0; i<10; i++)
  {
  threads[i] = new AccessorThreads(i);
  new Thread(threads[i]).start();
  }
}

}

class AccessorThreads implements Runnable
{
  public int threadId;
  public AccessorThreads(int i)
  {
    threadId=i;
  }

  public void run()
  {
    try
    {
    while (true)
      {
      if (!Threads.stack.empty())
      {
        System.out.println("Thread ID : "+threadId+"  ->  "+Threads.stack.pop());
      }
      Thread.sleep(1200);
      }
    }catch (InterruptedException exc)
    {
    }
  }
}