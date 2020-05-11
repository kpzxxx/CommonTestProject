package com.kpztech.practice.rxjava;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class RxJavaTest {

  public static void main(String[] args) {

    String param = "ABC";
    Handler1 handler1 = new Handler1();
    List<String> lists = Lists.newArrayList();

    Observable<String> novel = Observable.create(observableEmitter -> {

      for (int i = 0; i < 10; i++) {
        List<String> list = handler1.handle(param);
        lists.addAll(list);
      }
      log.info(JSON.toJSONString(lists));

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
        if ("2".equals(s)) {
          log.info("On next: " + s);
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

  private static class Handler1 {

    List<String> handle(String s) {
      if(s.equals("ABC")){
        s = "ABDC";
      }
      return Lists.newArrayList(s);
    }
  }

}
