package jpa.study.domain.persistance.eleven.config;

import jpa.study.domain.persistance.eleven.controller.MainController;
import jpa.study.domain.persistance.eleven.repository.MemberRepository;
import jpa.study.domain.persistance.eleven.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.sql.SQLException;

@Configuration
public class Config{

    private EntityManager em;

    public Config(EntityManager em) {
        this.em = em;
    }

//    @Bean
//    public MemberService service() throws SQLException {
//        return new MemberService(repository());
//    }
//    @Bean
//    public MemberRepository repository() throws SQLException {
//        return new MemberRepository(this.em);
//    }
}
