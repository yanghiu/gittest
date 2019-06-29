package com.example.app.spring;

import com.example.app.spring.context.SimpleApplicationContext;
import com.example.app.spring.util.BaseGenerator;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.applet.AppletContext;

/**
 * Hello world!
 *
 */
public class Main
{
    public static void main( String[] args )
    {
        // 자바 구성을 기반으로 애플리케이션 콘텍스트를 만글기위해 AnnotationConfigApplicationContext사용
        ApplicationContext context =
                new AnnotationConfigApplicationContext(SimpleApplicationContext.class);
        // 콘텍스트가 시작되면 비즈니스 서비스 빈을 가져와야한다.

        BaseGenerator generator = context.getBean(BaseGenerator.class);
        //(BaseGenerator.class)타입의인수로 전달하는 getBean 메서드 사용
        System.out.println("sequence : " + generator.getSequence());
        System.out.println( "Hello World!" );
    }

}
