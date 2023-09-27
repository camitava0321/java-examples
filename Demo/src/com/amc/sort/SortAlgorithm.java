package com.amc.sort;
import java.util.Vector;


public class SortAlgorithm
{


public static Vector sort(Vector vec,int sortField)
  {
  Incident []destInc = new Incident[vec.size()];
  Incident []srcInc = new Incident[vec.size()];

    for(int i=0;i<vec.size();i++)
      {
      srcInc[i] = (Incident)vec.elementAt(i);
      destInc[i] = (Incident)vec.elementAt(i);
      }
    qsort(srcInc,destInc,0,vec.size(),sortField);

    if(destInc!=null)
      {
      for(int i=0;i<vec.size();i++)
        {
        vec.setElementAt(destInc[i],i);
        }
      }
  return vec;
  }


  private static void qsort(Incident src[], Incident dest[],
                            int low, int high,int sortField)
  {
	int length = high - low;
  	// Insertion sort on smallest arrays
  	if (length < 7)
    {
  	    for (int i=low; i<high; i++)
          {
      		for (int j=i; j>low &&
               (Incident.compare(dest[j-1],dest[j],sortField)>0); j--)
            {
      		  swap(dest, j, j-1);
            }
          }
  	    return;
  	}

    // Recursively sort halves of dest into src
    int mid = (low + high)/2;
    qsort(dest, src, low, mid,sortField);
    qsort(dest, src, mid, high,sortField);

    // If list is already sorted, just copy from src to dest.  This is an
    // optimization that results in faster sorts for nearly ordered lists.
    if (Incident.compare(src[mid-1],src[mid],sortField) <= 0)
      {
      System.arraycopy(src, low, dest, low, length);
      return;
      }

    // Merge sorted halves (now in src) into dest
    for(int i = low, p = low, q = mid; i < high; i++)
      {
      if (q>=high || p<mid && Incident.compare(src[p],src[q],sortField)<=0)
          dest[i] = src[p++];
      else
          dest[i] = src[q++];
      }
    }


    /**
     * Swaps two objects viz. inc[i] with inc[j].
     */
    private static void swap(Incident inc[], int i, int j)
    {
	  Incident t = inc[i];
	  inc[i] = inc[j];
	  inc[j] = t;
    }

  public static int compare(Incident inc1, Incident inc2, int sortField)
  {
  int sCompare=0;
  String key1=null, key2 = null;

    switch(sortField)
    {
    case SORT_DATETIME:
      key1 = inc1.getDate()+inc1.getTime();
      key2 = inc2.getDate()+inc1.getTime();
      break;

    case SORT_INCIDENTNO:
      key1 = inc1.getIncidentNo();
      key2 = inc2.getIncidentNo();
      break;

    case SORT_CALLERNAME:
      key1 = inc1.getCallerName();
      key2 = inc2.getCallerName();
      break;

    case SORT_BRANCH:
      key1 = inc1.getBranch();
      key2 = inc2.getBranch();
      break;

    case SORT_STATUS:
      key1 = inc1.getStatus();
      key2 = inc2.getStatus();
      break;
    }
    sCompare = key1.compareTo(key2);
  return sCompare;
  }
}