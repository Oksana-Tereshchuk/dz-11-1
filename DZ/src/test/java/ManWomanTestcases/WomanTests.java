package ManWomanTestcases;

import com.rd.dz.Man;
import com.rd.dz.Woman;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class WomanTests {
    Woman woman;
        @Parameters({
                "firstName",
                "lastName",
                "age",
                "partnerFirstName",
                "partnerLastName"
        })

        @BeforeClass
        public void prepareWoman(String firstName, String lastName, int age, String partnerFirstName, String partnerLastName) {
            woman = new Woman(firstName, lastName, age, new Man(partnerFirstName, partnerLastName));
            //man = new Man(firstName, lastName, age, new Woman(partnerFirstName, partnerLastName));
        }
    @Test
    public void testIsWomanRetired() {
        int ageRetired = 58;
        woman.setAge(ageRetired);
        Assert.assertEquals(woman.getAge(), ageRetired, "Woman is not retired");
    }
    @Test
    public void testIsNotWomanRetired() {
        int ageRetired = 62;
        woman.setAge(ageRetired);
        Assert.assertEquals(woman.getAge(), ageRetired, "Woman is retired");
    }
    @Test
    public void testIsWomanregisterPartnership() {
        String updatedPartnerLastName = "UpdatedPartner_LastName";
        String updatedPartnerFirstName = "UpdatedPartner_FirstName";
        woman.setPartner(new Man(updatedPartnerFirstName, updatedPartnerLastName));
        Assert.assertEquals(woman.getLastName(), updatedPartnerLastName, "woman has registerPartnership ");
    }
}
