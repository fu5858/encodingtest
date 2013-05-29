import static org.junit.Assert.fail;

import java.io.UnsupportedEncodingException;

import org.junit.Test;


public class EncodingTest {

	/**
	 * Korean Encoding Test
	 * @throws UnsupportedEncodingException
	 */
	@Test
	public void encodingTest() throws UnsupportedEncodingException {
		
		String koStr = "한글";
		String charsetArr[] = {"euc-kr", "ksc5601", "iso-8859-1", "8859_1", "ascii", "Cp1252", "ms949", "UTF-8"};

		for(int i=0; i< charsetArr.length; i++) {
		    for(int j=0 ; j< charsetArr.length; j++) {
		        if(i == j) {
		            continue;
		        } else {
		            System.out.print(koStr + " >>> "+charsetArr[i] + " : " + charsetArr[j] + " : " + new String(koStr.getBytes(charsetArr[i]), charsetArr[j]) + "\n");
		        }
		    }
		} 
	}
	
}
