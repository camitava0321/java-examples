import java.lang.ref.*;
import java.util.*;

public class ReferenceTest
{
  private static final int NUMBER_OF_REFERENCES = 30;


  public static void main(String[] args)
  {
    // the map contains reference objects as keys, and the id
    // as a value.
    final Map refs = new HashMap();
    final ReferenceQueue queue = new ReferenceQueue();
    // We need a thread that reads processed references from the
    // reference queue so that we can see in what order they are
    // reclaimed.
    new Thread()
    {
      {
        setDaemon(true);
        start();
      }

      public void run()
      {
        try
          {
          while (true)
            {
            Reference ref = queue.remove();
            Integer id = (Integer) refs.remove(ref);
            if (ref instanceof SoftReference)
              {
              System.out.println("SOFT " + id);
              }
            else if (ref instanceof WeakReference)
              {
              System.out.println("WEAK " + id);
              }
            else
              {
              throw new IllegalArgumentException();
              }
            }
          } catch (InterruptedException e)
            {
            return;
            }
      }
    };

    for (int i = 0; i < NUMBER_OF_REFERENCES; i++)
      {
      System.out.println("NEW  " + i);
      Integer num = new Integer(i);
      // must keep a strong reference to the actual reference,
      // otherwise it will not be enqueued.
      refs.put(new SoftReference(new LargeObject(i), queue), num);
      refs.put(new WeakReference(new LargeObject(i), queue), num);
      }
    byte[][] buf = new byte[1024][];
    System.out.println("Allocating until OOME...");
    for (int i = 0; i < buf.length; i++)
      {
      buf[i] = new byte[1024 * 1024];
      }
  }
}
