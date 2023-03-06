package jpa.study.domain.persistance.eleven.service;

import jpa.study.domain.persistance.eleven.domain.Member;
import jpa.study.domain.persistance.eleven.repository.MemberRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import javax.transaction.Transactional;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

@ActiveProfiles("test")
@Transactional
@SpringBootTest
class MemberServiceTest {

    MemberService memberService;

    public MemberServiceTest(@Autowired MemberService memberService) {
        this.memberService = memberService;
    }

    @DisplayName("[서비스] 회원가입 로직 테스트")
    @Test
    void 회원가입() throws IllegalStateException{
        //given
        Member member = new Member();
        member.setName("kim");

        //when
        Long saveId = memberService.join(member);

        //then
        assertThat(saveId).isEqualTo(member.getId());

    }

    @Test
    void validateDuplicateMemer() throws IllegalStateException {
        //given
        Member member1 = new Member();
        Member member2 = new Member();
        member1.setName("kim");
        member2.setName("kim");

        //when
        memberService.join(member1);

        //then
        assertThatExceptionOfType(IllegalStateException.class).isThrownBy(() -> {
            memberService.join(member2);
        }).withMessage("이미 존재하는 회원입니다.");

    }

    @Test
    void findMembers() {
    }

    @Test
    void findOne() {
    }
}