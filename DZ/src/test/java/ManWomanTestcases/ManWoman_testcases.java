package ManWomanTestcases;

import com.rd.dz.Man;
import com.rd.dz.Woman;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import javax.swing.*;

public class ManWoman_testcases {
    @Parameters({
            "FirstName",
            "LastName",
            "Age",
            "Partner_FirstName",
            "Partner_LastName"
    })


    @Test
    public void testWomanIsRetired(String FirstName, String LastName,int Age,String Partner_FirstName,String Partner_LastName ) {
        Woman woman = new Woman(FirstName, LastName,Age,new Man(Partner_FirstName,Partner_LastName));
        Assert.assertTrue(woman.isRetired(), "Woman is not retired");
        Assert.assertEquals(woman.getLastName(),Partner_LastName, "Woman is registerPartnership");
        woman.deregisterPartnership(false);
        Assert.assertEquals(woman.getLastName(),LastName, "Woman is registerPartnership");
    }
    @Test
    public void testManIsRetired(String FirstName, String LastName,int Age,String Partner_FirstName,String Partner_LastName ) {
        Man man = new Man(FirstName, LastName,Age,new Woman(Partner_FirstName,Partner_LastName));
        Assert.assertFalse(man.isRetired(),"Man is not retired");
    }

}
