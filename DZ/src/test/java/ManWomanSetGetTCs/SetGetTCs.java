package ManWomanSetGetTCs;

import com.rd.dz.Man;
import com.rd.dz.Woman;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class SetGetTCs {
    @Parameters({
            "FirstName",
            "LastName",
            "Age",
            "Partner_FirstName",
            "Partner_LastName"
    })
    @Test
    public void getManTests(String FirstName, String LastName, int Age, String Partner_FirstName, String Partner_LastName) {
        Man man = new Man(FirstName, LastName, Age, new Woman(Partner_FirstName, Partner_LastName));

        Assert.assertEquals(man.getFirstName(), FirstName, "incorrect first name");
        man.setFirstName("new"+FirstName);
        Assert.assertEquals(man.getFirstName(), "new"+FirstName, "incorrect new first name");
        Assert.assertEquals(man.getLastName(), LastName, "incorrect last name");
        man.setLastName("new"+LastName);
        Assert.assertEquals(man.getLastName(), "new"+LastName, "incorrect new last name");
        Assert.assertEquals(man.getAge(), Age, "incorrect age");
        man.setAge(1+Age);
        Assert.assertEquals(man.getAge(), 1+Age, "incorrect new age");
        Assert.assertEquals(man.getLastName(), Partner_LastName, "incorrect partner last name");
        man.setPartner(new Woman("new"+Partner_FirstName, "new"+Partner_LastName));
        Assert.assertEquals(man.getLastName(), "new"+Partner_LastName, "incorrect new partner last name");
    }
    @Test
    public void getWomanTests(String FirstName, String LastName, int Age, String Partner_FirstName, String Partner_LastName) {
        Woman woman = new Woman(FirstName, LastName, Age, new Man(Partner_FirstName, Partner_LastName));
        Assert.assertEquals(woman.getFirstName(), FirstName, "incorrect first name");
        woman.setFirstName("new"+FirstName);
        Assert.assertEquals(woman.getFirstName(), "new"+FirstName, "incorrect new first name");
        Assert.assertEquals(woman.getLastName(), LastName, "incorrect last name");
        woman.setLastName("new"+LastName);
        Assert.assertEquals(woman.getLastName(), "new"+LastName, "incorrect new last name");
        Assert.assertEquals(woman.getAge(), Age, "incorrect age");
        woman.setAge(1+Age);
        Assert.assertEquals(woman.getAge(), 1+Age, "incorrect new age");
        Assert.assertEquals(woman.getLastName(), Partner_LastName, "incorrect partner last name");
        woman.setPartner(new Man("new"+Partner_FirstName, "new"+Partner_LastName));
        Assert.assertEquals(woman.getLastName(), "new"+Partner_LastName, "incorrect new partner last name");
    }
}
