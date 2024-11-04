package org.myweb.first.member.jpa.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.myweb.first.member.jpa.entity.MemberEntity;
import org.myweb.first.member.jpa.entity.QMemberEntity;
import org.myweb.first.member.model.dto.Member;
import org.myweb.first.notice.jpa.entity.QNoticeEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class MemberQueryRepository {

    // QueryDSL 에 대한 config 클래스를 먼저 만들고 나서 필드 선언함
    private final JPAQueryFactory queryFactory;

    private final EntityManager entityManager; // JPQL 사용을 위해 의존성 주입
    private QMemberEntity member = QMemberEntity.memberEntity;
    // notice 테이블을 의미하는 NoticeEntity를 notice 로 표현한다는 선언


    public long countSearchUserId(String keyword) {
        return queryFactory
                .selectFrom(member)         // select * from notice
                .where(member.userId.like("%" + keyword + "%"))    // where noticecontent %keyword%
                .fetchCount();
    }

    public long countSearchGender(String keyword) {
        return queryFactory
                .selectFrom(member)         // select * from notice
                .where(member.gender.like("%" + keyword + "%"))    // where noticecontent %keyword%
                .fetchCount();
    }

    public long countSearchAge(int age) {
        return queryFactory
                .selectFrom(member)         // select * from notice
                .where(member.age.like("%" + age + "%"))    // where noticecontent %keyword%
                .fetchCount();
    }

    public long countSearchDate(Date begin, Date end) {
        return queryFactory
                .selectFrom(member)         // select * from notice
                .where(member.enrollDate.between(begin, end))    // where noticecontent %keyword%
                .fetchCount();
    }

    public long countSearchLoginOK(String keyword) {
        return queryFactory
                .selectFrom(member)         // select * from notice
                .where(member.loginOk.like("%" + keyword + "%"))    // where noticecontent %keyword%
                .fetchCount();
    }

    public List<MemberEntity> findSearchUserId(String keyword, Pageable pageable) {
        return queryFactory
                .selectFrom(member)
                .where(member.userId.like("%" + keyword + "%"))
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetch();
    }

    public List<MemberEntity> findSearchGender(String keyword, Pageable pageable) {
        return queryFactory
                .selectFrom(member)
                .where(member.gender.like("%" + keyword + "%"))
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetch();
    }

    public List<MemberEntity> findSearchAge(int age, Pageable pageable) {
        return queryFactory
                .selectFrom(member)
                .where(member.age.like("%" + age + "%"))
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetch();
    }

    public List<MemberEntity> findSearchDate(Date begin, Date end, Pageable pageable) {
        return queryFactory
                .selectFrom(member)
                .where(member.enrollDate.between(begin, end))
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetch();
    }

    public List<MemberEntity> findSearchLoginOK(String keyword, Pageable pageable) {
        return queryFactory
                .selectFrom(member)
                .where(member.loginOk.like("%" + keyword + "%"))
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetch();
    }
}
