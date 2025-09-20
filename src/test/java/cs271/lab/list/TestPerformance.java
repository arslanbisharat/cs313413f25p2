package cs271.lab.list;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestPerformance{

  // (choose in conjunction with REPS below up to an upper limit where the clock
  // running time is in the tens of seconds)
  // comparing their running times for AddRemove vs. Access? Record those running times in README.txt!
  private int SIZE = 10;
  private int REPS = 1000000;

  private List<Integer> arrayList;

  private List<Integer> linkedList;

  @Before
  public void setUp() throws Exception {
    arrayList = new ArrayList<Integer>(SIZE);
    linkedList = new LinkedList<Integer>();
    for (var i = 0; i < SIZE; i++) {
      arrayList.add(i);
      linkedList.add(i);
    }
  }

  @After
  public void tearDown() throws Exception {
    arrayList = null;
    linkedList = null;
  }

  @Test
  public void testLinkedListAddRemove() {
    for (var r = 0; r < REPS; r++) {
      linkedList.add(0, 77);
      linkedList.remove(0);
    }
  }

  @Test
  public void testArrayListAddRemove() {
    for (var r = 0; r < REPS; r++) {
      arrayList.add(0, 77);
      arrayList.remove(0);
    }
  }

  @Test
  public void testLinkedListAccess() {
    var sum = 0L;
    for (var r = 0; r < REPS; r++) {
      sum += linkedList.get(r % SIZE);
    }
  }

  @Test
  public void testArrayListAccess() {
    var sum = 0L;
    for (var r = 0; r < REPS; r++) {
      sum += arrayList.get(r % SIZE);
    }
  }
    private long timeArrayListAddRemove() {
        long startTime = System.currentTimeMillis();
        for (var r = 0; r < REPS; r++) {
            arrayList.add(0, 77);
            arrayList.remove(0);
        }
        return System.currentTimeMillis() - startTime;
    }

    private long timeLinkedListAddRemove() {
        long startTime = System.currentTimeMillis();
        for (var r = 0; r < REPS; r++) {
            linkedList.add(0, 77);
            linkedList.remove(0);
        }
        return System.currentTimeMillis() - startTime;
    }

    private long timeArrayListAccess() {
        long startTime = System.currentTimeMillis();
        var sum = 0L;
        for (var r = 0; r < REPS; r++) {
            sum += arrayList.get(r % SIZE);
        }
        return System.currentTimeMillis() - startTime;
    }

    private long timeLinkedListAccess() {
        long startTime = System.currentTimeMillis();
        var sum = 0L;
        for (var r = 0; r < REPS; r++) {
            sum += linkedList.get(r % SIZE);
        }
        return System.currentTimeMillis() - startTime;
    }
    public static void main(String[] args) {
        TestPerformance test = new TestPerformance();

        int[] sizes = {10, 100, 1000, 10000};
        int[] reps = {1000000, 100000, 10000, 1000};

        System.out.println("Performance Test Results:");
        System.out.println("SIZE\tREPS\tArrayList AddRemove\tLinkedList AddRemove\tArrayList Access\tLinkedList Access");

        for (int i = 0; i < sizes.length; i++) {
            test.SIZE = sizes[i];
            test.REPS = reps[i];

            try {
                test.setUp();

                long arrayAddRemoveTime = test.timeArrayListAddRemove();
                test.setUp();
                long linkedAddRemoveTime = test.timeLinkedListAddRemove();
                test.setUp();
                long arrayAccessTime = test.timeArrayListAccess();
                test.setUp();
                long linkedAccessTime = test.timeLinkedListAccess();

                System.out.printf("%d\t%d\t%d ms\t\t%d ms\t\t%d ms\t\t%d ms%n",
                        sizes[i], reps[i], arrayAddRemoveTime, linkedAddRemoveTime, arrayAccessTime, linkedAccessTime);

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
