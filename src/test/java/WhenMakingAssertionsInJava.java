import org.assertj.core.api.Assertions;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.Assert.assertTrue;

public class WhenMakingAssertionsInJava {

    @Test
    public void traditionalAssertions(){
        int age = 40;
        List<Integer> ages = Arrays.asList(10,20,21,30);

        assertTrue("The lisf of ages should contain 40",ages.contains(age));
        Assert.assertEquals(age, 21);
    }

    @Test
    public void assertJAssertions(){
        int age = 12;
        List<Integer> ages = Arrays.asList(10,20,21,30);

//        assertThat(age).isGreaterThanOrEqualTo(21);
        assertThat(ages)
                .contains(10)
                .hasSize(4)
                .allMatch( a -> a >= 0 && a <= 100);
    }
}
