package reactive01;

import java.util.concurrent.Flow.Subscriber;
import java.util.concurrent.Flow.Subscription;
import java.util.concurrent.SubmissionPublisher;

public class PlusTenProcessor extends SubmissionPublisher<Integer> implements Subscriber<Integer>{

	private Subscription subscription;

	@Override
	public void onSubscribe(Subscription subscription) {
		this.subscription = subscription;
		this.subscription.request(1);
	}

	@Override
	public void onNext(Integer item) {
		System.out.println("Received Value In Processor = "+item);
		submit(item+10);
		this.subscription.request(1);
	}

	@Override
	public void onError(Throwable throwable) {
		System.out.println("Received Error = "+throwable.getMessage());
	}

	@Override
	public void onComplete() {
		System.out.println("Processor Subscription completed");
	}

}
