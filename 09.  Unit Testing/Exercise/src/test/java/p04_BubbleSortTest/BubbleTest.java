package p04_BubbleSortTest;

import org.junit.Assert;
import org.junit.Test;

public class BubbleTest {

  @Test
  public void testBubbleSortWorksCorrect() {
    int[] array = {31, 5, 21, 105, -10, -5};
    Bubble.sort(array);

    int[] expectedResult = {-10, -5, 5, 21, 31, 105};

    for (int i = 0; i < array.length; i++) {
      int actual = array[i];
      int expected = expectedResult[i];

      Assert.assertEquals(expected,actual);
    }

  }
}