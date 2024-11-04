package org.myweb.first.member.jpa.repository;

import org.myweb.first.board.jpa.entity.BoardEntity;
import org.myweb.first.member.jpa.entity.MemberEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends JpaRepository<MemberEntity, String> {
    // jpa 가 제공하는 기본 메소드들을 사용할 수 있게 됨

}
