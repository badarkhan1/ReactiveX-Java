package observableutilityoperators;

import rx.Observable;
import rx.Subscriber;

public class TimeInterval {
    public static void main(String[] args) {
        
        // Observable.timeInterval()
        System.out.println("Observable.timeInterval()");

        // There seems to be an issue.
//        Observable.just(1, 2, 3, 4, 5)
//                .timeInterval()
//                .subscribe(new Subscriber<TimeInterval<Integer>>(){
//            @Override
//            public void onCompleted() {
//                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//            }
//
//            @Override
//            public void onError(Throwable thrwbl) {
//                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//            }
//
//            @Override
//            public void onNext(<any> t) {
//                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//            }
//        });
        
    }
}
