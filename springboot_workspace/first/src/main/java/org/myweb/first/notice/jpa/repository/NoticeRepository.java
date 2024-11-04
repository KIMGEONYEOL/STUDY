package org.myweb.first.notice.jpa.repository;

import org.myweb.first.board.jpa.entity.BoardEntity;
import org.myweb.first.notice.jpa.entity.NoticeEntity;
import org.myweb.first.notice.jpa.entity.NoticeNativeVo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

//JPA 는 Entity 와 Repository 를 만들어서 사용하는 기술임
//JPA의 Repository 는 JpaRepository 인터페이스를 상속받아서 후손 인터페이스로 만듦
//제네릭스는 <엔티티클래스명, @id 프로퍼티의 클래스자료형> 표기함
//MyBatis 의 SqlSession 과 같은 역할을 수행함. Mapper 인터페이스와 같음

@Repository
public interface NoticeRepository extends JpaRepository<NoticeEntity, Integer> {
    // 해당 인터페이스가 비어있으면, JpaRepository 가 제공하는 기본 메소드들을 사용한다는 의미임

    // jpa 기본 메소드로 해결이 안되는 쿼리문 작동일 때는 필요한 메소드를 이 인터페이스 안에 추가할 수 있음
    // JPQL 을 이용함 또는 Native Query 이용하면 됨
    // JPQL 은 WHERE, GRUOP BY 절에서만 서브쿼리 사용 가능함
    // FROM 절에서는 서브쿼리 사용 못 함

    // @Query + Native Query 사용 형태 (쿼리문에 테이블과 컬럼명 사용)
    @Query(value = "select noticeno, noticetitle, readCount from board order by readCount desc", nativeQuery = true)
    List<NoticeNativeVo> findTop3();
    // nativeQuery 사용시 컬럼명과 같은 get 메소드로만 구성된 nativeVo 인터페이스 필요함
    // board_num, board_title, board_readcount 컬럼에 대한 get 메소드 작성
    // => board.jpa.entity.BoardNativeVo 인터페이스로 작성함

    // insert 등록시 새 게시글 번호 처리를 위해서 마지막 게시글번호 조회용
    @Query(value = "select max(noticeno) from notice", nativeQuery = true)
    int findLastNoticeNo();

    // @Query + Native Query 사용 형태 (쿼리문에 테이블과 컬럼명 사용)
    @Query(value = "select count(*) from notice n where n.noticetitle like :keyword%", nativeQuery = true)
    Long countSearchTitle(@Param("keyword") String keyword);

    @Query(value = "select count(*) from notice n where n.noticecontent like :keyword%", nativeQuery = true)
    Long countSearchContent(@Param("keyword") String keyword);

    @Query(value = "select count(*) from notice n where n.noticedate between :begin and :end", nativeQuery = true)
    Long countSearchDate(@Param("begin") java.sql.Date begin, @Param("end") java.sql.Date end);

    // @Query + JPQL 사용 (작성하는 쿼리문에 엔티티 클래스명과 프로퍼티 사용) --------------------------------------
    @Query(value = "select n from NoticeEntity n where n.noticeTitle like %:keyword%",
            countQuery = "select count(n) from NoticeEntity n where n.noticeTitle like %:keyword%")
    Page<NoticeEntity> findSearchTitle(@Param("keyword") String keyword, @Param("pageable") Pageable pageable);

    @Query(value = "select n from NoticeEntity n where n.noticeContent like %:keyword%",
            countQuery = "select count(n) from NoticeEntity n where n.noticeContent like %:keyword%")
    Page<NoticeEntity> findSearchContent(@Param("keyword") String keyword, @Param("pageable") Pageable pageable);

    @Query(value = "select n from NoticeEntity n where n.noticeDate between :begin and :end",
            countQuery = "select count(n) from NoticeEntity n where n.noticeTitle like %:keyword%")
    Page<NoticeEntity> findSearchDate(@Param("begin") java.sql.Date begin, @Param("end") java.sql.Date end, @Param("pageable") Pageable pageable);

}
