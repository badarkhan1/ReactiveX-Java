package conditionalandbooleanoperators;

import rx.Observable;
import rx.Subscriber;

public class Contains {
    public static void main(String[] args) {
        
        // Observable.contains(Object element)
        System.out.println("Observable.contains(Object element)");
        
        Observable.just(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
                .contains(11)
                .subscribe(new Subscriber<Boolean>(){
            @Override
            public void onCompleted() {
                System.out.println("All items have been emitted.");
            }

            @Override
            public void onError(Throwable thrwbl) {
                System.out.println("Something went wrong...");
            }

            @Override
            public void onNext(Boolean t) {
                System.out.print(t + " ");
            }
        });
    }
}
