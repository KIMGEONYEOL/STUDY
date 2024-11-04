package org.myweb.first.board.jpa.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.myweb.first.board.model.dto.Reply;
import org.yaml.snakeyaml.events.Event;

import java.sql.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "REPLY") //매핑할 테이블 이름 지정함, NOTICE 테이블을 자동으로 만들어 주기도 하는 어노테이션임
@Entity
public class ReplyEntity {
    @Id
    @Column(name="REPLY_NUM")
    private int replyNum;        //    REPLY_NUM	NUMBER
    @Column(name="REPLY_WRITER")
    private String replyWriter;  //    REPLY_WRITER	VARCHAR2(50 BYTE)
    @Column(name="REPLY_TITLE")
    private String replyTitle;   //    REPLY_TITLE	VARCHAR2(50 BYTE)
    @Column(name="REPLY_CONTENT")
    private String replyContent; //    REPLY_CONTENT	VARCHAR2(2000 BYTE)
    @Column(name="BOARD_REF")
    private int boardRef;        //    BOARD_REF	NUMBER
    @Column(name="REPLY_REPLY_REF")
    private int replyReplyRef;   //    REPLY_REPLY_REF	NUMBER
    @Column(name="REPLY_LEV")
    private int replyLev;        //    REPLY_LEV	NUMBER
    @Column(name="REPLY_SEQ")
    private int replySeq;        //    REPLY_SEQ	NUMBER
    @Column(name="REPLY_READCOUNT")
    private int replyReadCount;  //    REPLY_READCOUNT	NUMBER
    @Column(name="REPLY_DATE")
    private Date replyDate;      //    REPLY_DATE	DATE

    @PrePersist
    public void prePersist(){
        replyDate = new java.sql.Date(System.currentTimeMillis());
    }

    public Reply toDto(){
        return Reply.builder()
                .replyNum(replyNum)
                .replyWriter(replyWriter)
                .replyTitle(replyTitle)
                .replyContent(replyContent)
                .boardRef(boardRef)
                .replyReplyRef(replyReplyRef)
                .replyLev(replyLev)
                .replySeq(replySeq)
                .replyReadCount(replyReadCount)
                .replyDate(replyDate)
                .build();
    }
}
