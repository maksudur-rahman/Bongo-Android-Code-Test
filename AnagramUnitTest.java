import org.junit.Test;
import static org.junit.Assert.*;
import java.lang.*;    
import java.io.*;

public class AnagramUnitTest {

private String mFirstValue="eat";
private String mSecondValue="tar";

    @Test
    public void testIsAnagramOrNot() {
        AnagramTest   = new AnagramTest();
        Boolean result = anagramTest.isAnagram(mFirstValue, mSecondValue);
		if(result){
		   assertEquals(mFirstValue+" and "+mSecondValue+" are Anagram");
		}
		else{
		   assertEquals(mFirstValue+" and "+mSecondValue+" are not Anagram");
		}
    }
	
	@Test
    public void testIsInputValid() {
        AnagramTest   = new AnagramTest();
		if(mFirstValue!=null && mSecondValue!=null){
		system.out.println("inputs are valid");
		}
		else{
		system.out.println("inputs are not valid");
		}
		
    }
}
