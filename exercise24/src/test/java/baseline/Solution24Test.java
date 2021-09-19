package baseline;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Solution24Test {

    @Test
    void isAnagram() {
        Solution24 solution = new Solution24();

        String str1 = "Hello";
        String str2 = "oHell";

        boolean result = solution.isAnagram(str1, str2);

        assertTrue(result);
    }

    @Test
    void isAnagram2() {
        Solution24 solution = new Solution24();

        String str1 = "dog";
        String str2 = "god";

        boolean result = solution.isAnagram(str1, str2);

        assertTrue(result);
    }

    @Test
    void isAnagram3() {
        Solution24 solution = new Solution24();

        String str1 = "hello";
        String str2 = "oHell";

        boolean result = solution.isAnagram(str1, str2);

        assertFalse(result);
    }

    @Test
    void isAnagram4() {
        Solution24 solution = new Solution24();

        String str1 = "hello";
        String str2 = "";

        boolean result = solution.isAnagram(str1, str2);

        assertFalse(result);
    }

    @Test
    void isAnagram5() {
        Solution24 solution = new Solution24();

        String str1 = "";
        String str2 = "";

        boolean result = solution.isAnagram(str1, str2);

        assertTrue(result);
    }

    @Test
    void isAnagram6() {
        Solution24 solution = new Solution24();

        String str1 = "";
        String str2 = "dog";

        boolean result = solution.isAnagram(str1, str2);

        assertFalse(result);
    }

    @Test
    void isAnagram7() {
        Solution24 solution = new Solution24();

        String str1 = "doggggg";
        String str2 = "dog";

        boolean result = solution.isAnagram(str1, str2);

        assertFalse(result);
    }
}