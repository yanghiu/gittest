package com.example.app.spring.util;

import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.atomic.AtomicInteger;

// 키워드 알기!
//@Component// Component> 빈을 사용할려면 무조건 해줘야한다
//@Primary // 이름이 먼저있다고 먼저 찾는것이아니고 Primary로 우선순위를 결정할 수있다.
//@Scope("singleton") // singleton(디폴트)1개 상태를 알필요가 없을때, prototype(앤티티를 요청할때 여러개생겨남)
                    // request(요청할때마다), session(세션이 추가될때마다), application
                    // prototype>요구사항에 따라 상태가 업데이트되야하는것(getBeans를 할때마다 생겨남) 요청할때마다 인스턴스가 생김
// 스테이스리스 stateliess?
// 생성자에서 셋업을 해줘야한다
public class DateSequenceGenerator implements BaseGenerator {
    private SimpleDateFormat simpleDateFormat;
    private  String format;

    public int getInitial() {
        return initial;
    }

    public void setInitial(int initial) {
        this.initial = initial;
    }

    private int initial;


    private final AtomicInteger counter = new AtomicInteger(); // 동시성 문제

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
        this.simpleDateFormat = new SimpleDateFormat();
    }

    @Override
    public String getSequence() {
        //Date now = new Date();// 시간을 가져옴
        StringBuilder builder = new StringBuilder(); // 객체를 생성해야하는데 파라미터가 많을때사용
        builder.append(simpleDateFormat.format(new Date())) // simpleDateFormat자체가 null(그래서 셋업을 해야한다)
                .append("-")
                .append(initial+counter.getAndIncrement());


        // 팩토리 패턴> 특정한 클래스를 리턴해줌
        return builder.toString();// 빌드가되었을때 스트링이 생김
    }
}
