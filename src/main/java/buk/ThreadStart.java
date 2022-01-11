package buk;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Service
public class ThreadStart {
	
	@Autowired
	Main main;
	
	public void threadStart1 () throws Exception {
		ExecutorService executorService = Executors.newFixedThreadPool(1);
		executorService.submit(()->{
			try {
				main.start1();
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
		executorService.shutdown();

//		ExecutorService executorService2 = Executors.newFixedThreadPool(7);
//		executorService2.submit(()->{
//			try {
//				main.start2();
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//		});
//		executorService2.shutdown();
//
//		ExecutorService executorService3 = Executors.newFixedThreadPool(7);
//		executorService3.submit(()->{
//			try {
//				main.start3();
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//		});
//		executorService3.shutdown();
		
	}

	public void threadStart2 () throws Exception {
		ExecutorService executorService4 = Executors.newFixedThreadPool(1);
		executorService4.submit(()->{
			try {
				main.start4();
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
		executorService4.shutdown();
	}

}
