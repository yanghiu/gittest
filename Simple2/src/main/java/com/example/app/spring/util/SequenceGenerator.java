package com.example.app.spring.util;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.concurrent.atomic.AtomicInteger;

@Component// Component> 빈을 사용할려면 무조건 해줘야한다 = Spring Bean
@Scope("singleton") // singleton(디폴트)1개 상태를 알필요가 없을때, prototype(앤티티를 요청할때 여러개생겨남), request, session, application
// prototype>요구사항에 따라 상태가 업데이트되야하는것(getBeans를 할때마다 생겨남) 요청할때마다 인스턴스가 생김
public class SequenceGenerator implements BaseGenerator {
    private  String prefix;
    private  String suffix;
    private  int initial;
    private final AtomicInteger counter; //= new AtomicInteger(); // 동시성 문제

    public SequenceGenerator(){
        this.counter = new AtomicInteger();
    }

    public int getInitial() {
        return initial;
    }

    public void setInitial(int initial) {
        this.initial = initial;
    }

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    //시퀀스 값을 저장했다가 복원을하는 작업
    @Override
    public String getSequence() {
        StringBuilder builder = new StringBuilder(); // 객체를 생성해야하는데 파라미터가 많을때사용
        builder.append(prefix)
                .append(initial+counter.getAndIncrement())
                .append(suffix);

        // 매번 파일을 열고닫으면 렉이걸린다
        // 동기/비동기 (락이걸리고 안걸리고)
        // 팩토리 패턴> 특정한 클래스를 리턴해줌
        return builder.toString();// 빌드가되었을때 스트링이 생김
    }
}
