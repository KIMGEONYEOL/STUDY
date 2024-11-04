package org.myweb.first.notice.jpa.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import jakarta.validation.constraints.NotBlank;
import lombok.RequiredArgsConstructor;
import org.myweb.first.notice.jpa.entity.NoticeEntity;
import org.myweb.first.notice.jpa.entity.QNoticeEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class NoticeQueryRepository {
    // QueryDSL 사용방법 3:
    // 상속, 재구현 없는(implement) 없는 queryDSL 만으로 구성하는 리포지터리 클래스 작성 방법임

    // QueryDSL 에 대한 config 클래스를 먼저 만들고 나서 필드 선언함
    private final JPAQueryFactory queryFactory;
    // 반드시 final 사용할 것

    private final EntityManager entityManager; // JPQL 사용을 위해 의존성 주입
    private QNoticeEntity notice = QNoticeEntity.noticeEntity;

    // notice 테이블을 의미하는 NoticeEntity를 notice 로 표현한다는 선언

    // 마지막 공지글 번호 조회 (새 글 등록시 공지글번호 + 1 사용)
    public int findLastNoticeNo() {
        NoticeEntity noticeEntity = queryFactory
                .selectFrom(notice)         // select * from notice
                .orderBy(notice.noticeNo.desc())
                .fetch().get(0);        // 내림차순정렬한 공지목록의 첫번째 행 선택 == 가장 최근 등록된 공지글
        return noticeEntity.getNoticeNo();
    }


    // 검색 관련 메소드 ------------------------
    public List<NoticeEntity> findSearchTitle(String keyword, Pageable pageable) {
        return queryFactory
                .selectFrom(notice)
                .where(notice.noticeTitle.like('%' + keyword + '%'))
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetch();
    }

    public long countSearchTitle(String keyword) {
        return queryFactory
                .selectFrom(notice)         // select * from notice
                .where(notice.noticeTitle.like("%" + keyword + "%"))    // where noticetitle %keyword%
                .fetchCount();
    }

    public List<NoticeEntity> findSearchContent(String keyword, Pageable pageable) {
        return queryFactory
                .selectFrom(notice)
                .where(notice.noticeContent.like('%' + keyword + '%'))
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetch();
    }


    public long countSearchContent(String keyword) {
        return queryFactory
                .selectFrom(notice)         // select * from notice
                .where(notice.noticeContent.like("%" + keyword + "%"))    // where noticecontent %keyword%
                .fetchCount();
    }

    public List<NoticeEntity> findSearchDate(Date begin, Date end, Pageable pageable) {
        return queryFactory
                .selectFrom(notice)
                .where(notice.noticeDate.between(begin, end))
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetch();
    }

    public long countSearchDate(Date begin, Date end) {
        return queryFactory
                .selectFrom(notice)         // select * from notice
                .where(notice.noticeDate.between(begin, end))    // where noticedate between begin and end
                .fetchCount();
    }

}
