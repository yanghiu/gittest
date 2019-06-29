package com.example.app.spring.context;

import com.example.app.spring.util.BaseGenerator;
import com.example.app.spring.util.DateSequenceGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

// 생성자 setter new로 넣어줘야한다
// 오토와이어링 > 인스턴스가 하나면됨(singleton패턴을 유지하고싶다하고할때)
// context > 프로그램을 시작하기위한 정보
//@Configuration // 스프링 프레임웍에 어떻게 빈을 찾고 쓸껀지

//@ComponentScan(basePackages = {"com.example.app.spring"}) // 그룹아이디 스프링 빈파일 찾기
public class SimpleApplicationContext {
// 셋업과정이 필요하면 정적
    //@Bean // 명시적 선언
    //@Primary
    public BaseGenerator getBaseGenerator(){
        // 어떤것은 꼭 셋업을 해야함
        DateSequenceGenerator generator = new DateSequenceGenerator();
        generator.setFormat("yyyyMMdd");
        generator.setInitial(10000);
        return  generator;
    }
}
