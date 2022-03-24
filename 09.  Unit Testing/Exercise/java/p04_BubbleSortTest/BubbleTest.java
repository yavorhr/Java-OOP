package p04_BubbleSortTest;

import org.junit.Assert;
import org.junit.Test;

public class BubbleTest {
    @Test
    public void testSort() {
        int[] arr = {100, 13, 7, 0, -5, 2};
        Bubble.sort(arr);
        int[] expectedArray = {-5, 0, 2, 7, 13, 100};

        for (int i = 0; i < expectedArray.length; i++) {
            Assert.assertEquals(expectedArray[i], arr[i]);
        }
    }
}
