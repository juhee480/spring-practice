package hello.core.beanFind;

import hello.core.Discount.DiscountPolicy;
import hello.core.Discount.FixDiscountPolicy;
import hello.core.Discount.RateDiscountPolish;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoUniqueBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

public class ApplicationContextExtendsFindTest {
    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);

    @Test
    @DisplayName("부모타입으로 조회시 자식이 둘 이상 있으면 오류남")
    void findBeanByParentTypeDuplicate() {

        Assertions.assertThrows(NoUniqueBeanDefinitionException.class,
                () -> ac.getBean(DiscountPolicy.class));
    }

    @Test
    @DisplayName("부모타입으로 조회시 자식이 둘 이상 있으면 이름으로 조회해야 한다.")
    void findBeanByParentTypeBeanName() {
        DiscountPolicy bean = ac.getBean("fixdiscountPolicy", DiscountPolicy.class);
    }

    @Test
    @DisplayName("부모타입으로 모두 조회하기.")
    void findAllBeanByParentType() {
        Map<String, DiscountPolicy> beansOfType = ac.getBeansOfType(DiscountPolicy.class);
        org.assertj.core.api.Assertions.assertThat(beansOfType.size()).isEqualTo(2);

    }




    @Configuration
    static class TestConfig {

        @Bean
        public DiscountPolicy fixdiscountPolicy() {
            return new FixDiscountPolicy();
        }

        @Bean
        public DiscountPolicy ratediscountPolicy() {
            return new RateDiscountPolish();
        }
    }
}
