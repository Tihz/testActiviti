package bool;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class BoolTest {

	@Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {     
                 { true, true, true },
                 { false, true, true },
                 { true, false, true },
                 { true, true, false },
                 { false, false, true },
                 { true, false, false },
                 { false, true, false },
                 { false, false, false }
           });
    }
    
    @Parameter(0)
    private boolean a;
    
    @Parameter(1)
    private boolean b;
    
    @Parameter(2)
    private boolean c;
    
	@Test
	public void test() {
		boolean result1 = a & (b | c);
		boolean result2 = a & b | c;
		Assert.assertTrue(result1 == result2);
	}
}
