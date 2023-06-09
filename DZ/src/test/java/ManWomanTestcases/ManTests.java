package ManWomanTestcases;

import com.rd.dz.Man;
import com.rd.dz.Woman;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ManTests {
    Man man;
    @Parameters({
            "firstName",
            "lastName",
            "age",
            "partnerFirstName",
            "partnerLastName"
    })

    @BeforeClass
    public void prepareWoman(String firstName, String lastName, int age, String partnerFirstName, String partnerLastName) {
        //woman = new Woman(firstName, lastName, age, new Man(partnerFirstName, partnerLastName));
        man = new Man(firstName, lastName, age, new Woman(partnerFirstName, partnerLastName));
    }
    @Test
    public void testIsManRetired() {
        int ageRetired = 58;
        man.setAge(ageRetired);
        Assert.assertEquals(man.getAge(), ageRetired, "Woman is not retired");
    }
    @Test
    public void testIsNotManRetired() {
        int ageRetired = 62;
        man.setAge(ageRetired);
        Assert.assertEquals(man.getAge(), ageRetired, "Woman is retired");
    }
}
