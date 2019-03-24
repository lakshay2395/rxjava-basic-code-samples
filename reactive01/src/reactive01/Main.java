package reactive01;

import java.util.concurrent.SubmissionPublisher;

public class Main {

	public static void main(String[] args)throws Exception {
		SubmissionPublisher<Integer> s = new SubmissionPublisher<>();
		PrinterSubcriber ps = new PrinterSubcriber();
		PlusTenProcessor pt = new PlusTenProcessor();
		
		
		
		s.subscribe(pt);
		pt.subscribe(ps);
		
		for(int i = 0 ;i < 10 ; i++) {
			s.submit(i);
		}
		
		Thread.sleep(2000);
		s.close();
		pt.close();
	}

}
