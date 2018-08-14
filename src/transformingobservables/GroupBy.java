package transformingobservables;

import rx.Observable;
import rx.Subscriber;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.observables.GroupedObservable;

public class GroupBy {
    public static void main(String[] args){
        
        // Observable.groupBy(Func1<? extends T, ? extends K> func1)
        System.out.println("Observable.groupBy(Func1<? extends T, ? extends K> func1)");
        Observable.just(0, 1, 2, 3, 4, 5, 6, 7, 8, 9)
                .doOnNext(new Action1<Integer>(){
            @Override
            public void call(Integer t) {
                System.out.println("source emitting " + t);
            }
        }).groupBy(new Func1<Integer,Integer>(){
            @Override
            public Integer call(Integer t) {
                System.out.println("GroupBy called for item " + t);
                return t % 3;
            }
        }).subscribe(new Subscriber<GroupedObservable<Integer,Integer>>(){
            @Override
            public void onCompleted() {
                System.out.println("All items have been emitted.");
            }

            @Override
            public void onError(Throwable thrwbl) {
                System.out.println("Something went wrong...");
            }

            @Override
            public void onNext(GroupedObservable<Integer, Integer> t) {
                int key = t.getKey();
                System.out.println("Got observable " + t + " for key " + t.getKey());
                t.subscribe(new Subscriber<Integer>(){
                    @Override
                    public void onCompleted() {
                        System.out.println("All items emitted by grouped observable.");
                    }

                    @Override
                    public void onError(Throwable thrwbl) {
                        System.out.println("Something went wrong in grouped observable...");
                    }

                    @Override
                    public void onNext(Integer t) {
                        System.out.println("Key: " + key + ", Item: " + t +"\n");
                    }
                });
            }
        });
    }
}
