package jpa.study.domain.persistance.eleven.repository;

import jpa.study.domain.persistance.eleven.domain.Member;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@ActiveProfiles("test")
@Transactional
@SpringBootTest
class MemberRepositoryTest {

    private MemberRepository repository;

    @Autowired
    public MemberRepositoryTest(MemberRepository repository) {
        this.repository = repository;
    }

    @DisplayName("회원 가입")
    @Test
    public void test() {
        //given
        Member member1 = new Member();
        member1.setName("kim");

        //when
        repository.save(member1);
        List<Member> findMember = repository.findByName(member1.getName());

        //then
        assertThat(findMember.size()).isEqualTo(1);

    }

}