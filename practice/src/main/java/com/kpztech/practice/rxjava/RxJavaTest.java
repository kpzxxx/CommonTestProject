package com.kpztech.practice.rxjava;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class RxJavaTest {

  public static void main(String[] args) {
    Observable<String> novel = Observable.create(observableEmitter -> {
      observableEmitter.onNext("1");
      observableEmitter.onNext("2");
      observableEmitter.onNext("3");
      observableEmitter.onComplete();
    });


    Observer<String> reader = new Observer<String>() {
      @Override
      public void onSubscribe(Disposable disposable) {
        log.info("On subscribe.");
      }

      @Override
      public void onNext(String s) {
        if("2".equals(s)){
          log.info("On next: "+ s);
        }
      }

      @Override
      public void onError(Throwable throwable) {
        log.error("On error: ", throwable);
      }

      @Override
      public void onComplete() {
        log.info("On complete.");
      }
    };

    novel.subscribe(reader);

  }

}
