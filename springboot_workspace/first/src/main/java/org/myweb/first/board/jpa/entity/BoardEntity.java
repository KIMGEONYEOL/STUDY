package org.myweb.first.board.jpa.entity;


import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.myweb.first.board.model.dto.Board;

import java.sql.Date;
import java.util.GregorianCalendar;
import java.util.concurrent.BlockingQueue;

// 테이블 생성에 대한 가이드 클래스임
// @Entity 어노테이션 표시함 => 엔티티로 자동 등록됨 =>
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "BOARD")
@Entity // JPA 가 관리함, 테이블의 컬럼과 DTO 클래스의 프로퍼티를 매핑하는 역할을 함
public class BoardEntity {
    @Id // JPA 가 엔티티를 관리하기 위한 식별자로 지정함
    // @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="BOARD_NUM", nullable = false)
    private int boardNum;			//BOARD_NUM	NUMBER : 게시글 번호 (PK)
    @Column(name="BOARD_WRITER", nullable = false)
    private String boardWriter;		//BOARD_WRITER	VARCHAR2(50 BYTE) : 게시글 작성자 아이디 (FK)
    @Column(name="BOARD_TITLE", nullable = false)
    private String boardTitle;		//BOARD_TITLE	VARCHAR2(50 BYTE) : 게시글 제목
    @Column(name="BOARD_CONTENT", nullable = false)
    private String boardContent;		//BOARD_CONTENT	VARCHAR2(2000 BYTE) : 게시글 내용
    @Column(name="BOARD_ORIGINAL_FILENAME", nullable = false)
    private String boardOriginalFilename;	//BOARD_ORIGINAL_FILENAME	VARCHAR2(100 BYTE) : 첨부파일 원래 이름
    @Column(name="BOARD_RENAME_FILENAME", nullable = false)
    private String boardRenameFilename;	//BOARD_RENAME_FILENAME	VARCHAR2(100 BYTE) : 첨부파일 바뀐 이름
    @Column(name="BOARD_READCOUNT", nullable = false)
    private int boardReadCount;	//BOARD_READCOUNT	NUMBER : 게시글 조회수
    @Column(name="BOARD_DATE", nullable = false)
    private Date boardDate;	//BOARD_DATE	DATE : 게시글 등록 날짜

    @PrePersist     //jpa 로 넘어가기 전(sql 에 적용하기 전)에 작동된다는 어노테이션임
    public void prePersist(){
        // boardDate = new GregorianCalendar().getGregorianChange();  //현재 날짜 시간 적용
        boardDate = new java.sql.Date(System.currentTimeMillis());
    }

    public Board toDto(){
        return Board.builder()
                .boardNum(boardNum)
                .boardWriter(boardWriter)
                .boardTitle(boardTitle)
                .boardContent(boardContent)
                .boardOriginalFilename(boardOriginalFilename)
                .boardRenameFilename(boardRenameFilename)
                .boardReadCount(boardReadCount)
                .boardDate(boardDate)
                .build();
    }

    public Board toDtoTop3(){
        return Board.builder()
                .boardNum(boardNum)
                .boardTitle(boardTitle)
                .boardReadCount(boardReadCount)
                .build();
    }
}
