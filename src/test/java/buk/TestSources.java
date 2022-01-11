package buk;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TestSources {
	
	public static void main (String [] args) {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyyHH:mm");
		
		Date data = new Date();
		System.out.println(data);
		
		data.setYear(121);
		System.out.println(data);
		
		int dat = data.getYear();
		System.out.println(dat);
		

		
		System.out.println(data.getYear());
		
		
		String jac = "Jacek";
		System.out.println(jac);
		String sss= jac.replace("a", "aaaaaaasss");
		System.out.println(sss);
		
	}
 
}
