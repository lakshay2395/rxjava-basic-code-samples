package reactive01;

import java.util.concurrent.Flow.Subscriber;
import java.util.concurrent.Flow.Subscription;

public class PrinterSubcriber implements Subscriber<Integer>{
	
	private Subscription subscription;

	@Override
	public void onSubscribe(Subscription subscription) {
		this.subscription = subscription;
		this.subscription.request(1);
	}

	@Override
	public void onNext(Integer item) {
		System.out.println("Received Value = "+item);
		this.subscription.request(1);
	}

	@Override
	public void onError(Throwable throwable) {
		System.out.println("Received Error = "+throwable.getMessage());
	}

	@Override
	public void onComplete() {
		System.out.println("Subscription completed");
	}
	
}
