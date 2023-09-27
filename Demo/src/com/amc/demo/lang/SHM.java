package com.amc.demo.lang;
/**
 * Example of Daemon and worker threads
 * The Oscillator class implements a particle moving under SHM
 * The class SHM monitor a number of Oscillator threads and
 * marks the time when they resonate
 * @Author:Amitava
 */

public class SHM implements Runnable
{

public static final int NO_OSCILLATORS=3;           /* No of oscillators */
public static final int AMPLITUDE=5;                /* Amplitude of SHM  */

//Array of Oscillators
public static Oscillator []oscillators = new Oscillator[NO_OSCILLATORS];

public static void main (String []args)
{
  // Instantiation of the Oscillators
  for (int i=0; i<NO_OSCILLATORS; i++)
    {
    // phase can be between 0 and AMPLITUDE;
    int phase = (int)(AMPLITUDE * Math.random());
    System.out.println(phase);

    oscillators[i] = new Oscillator(i,phase);
    new Thread(oscillators[i]).start();             /* Start the Oscillator */
    }

  SHM SHM = new SHM();                              /* Start the Daemon thread */
  new Thread(SHM).start();
}

public void run()
{
boolean resonance=true;                             /* Variable to indicate resonance */
int previousValue=-1;
    try
    {
    while (true)
      {
      previousValue=-1;
      for (int i=0; i<NO_OSCILLATORS; i++)
        {
        if (resonance && previousValue!=-1)         /* Skip the first pass when the */
          {                                         /* previousValue = -1           */
          if (previousValue==
              oscillators[i].getPlaceValue())       /* if the 'place' of the last   */
            {                                       /* two oscillators are same then*/
            resonance=true;                         /* the next pass need to be     */
            }                                       /* again                        */
          else
            {
            resonance=false;
            }
          }

        System.out.print(
          oscillators[i].getPlaceValue()+"\t");     /* print the 'place' of different*/
                                                    /* oscillators side by side      */
        previousValue=oscillators[i].getPlaceValue();
        } //for Loop
      if (resonance)
        System.out.print("\t***");                  /* if the 'place' value for all the*/
                                                    /* oscillators are same then indicate*/
                                                    /* RESONANCE                       */
      else resonance=true;

      System.out.println("");
      Thread.sleep(100);
      } //while
    }catch (InterruptedException exc)
    {
      exc.printStackTrace();
    }

}

}

/** The Oscillator class */
class Oscillator implements Runnable
{
  public int amplitude=SHM.AMPLITUDE;
  public int phase;
  public int place=0;
  public boolean direction=true;
  public int id;

  public Oscillator(int id,int p)
  {
    id=id;                                          /* Set the thread id               */
    phase=p;                                        /* Set the phase                   */
    place=phase;                                    /* Set the epoch                   */
  }

  public synchronized int getPlaceValue()
  {
  return place;
  }

  public synchronized void setPlaceValue(int v)
  {
  place=v;
  }

  public void run()
  {
    try
    {
    while (true)
      {
      int v=getPlaceValue();
      if (direction) v++;
      else v--;

      setPlaceValue(v);

      if (getPlaceValue()==SHM.AMPLITUDE) direction=false;       /* Once end of the amplitude is    */
                                                    /* reached reverse the direction   */
      if (getPlaceValue()==0) direction=true;
      Thread.sleep(100);
      }
    }catch (InterruptedException exc)
    {
    }
  }
}