package org.myweb.first.board.model.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.myweb.first.board.jpa.entity.ReplyEntity;
import org.myweb.first.board.jpa.repository.ReplyRepository;
import org.myweb.first.board.model.dto.Board;
import org.myweb.first.board.model.dto.Reply;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Slf4j    //Logger 객체 선언임, 별도의 로그객체 선언 필요없음, 제공되는 레퍼런스는 log 임
@Service
@RequiredArgsConstructor
@Transactional
public class ReplyService {
    private final ReplyRepository replyRepository;

    //원글에 대한 댓글, 대댓글 목록 조회
    public ArrayList<Reply> selecReplyList(int boardNum) {
        //추가한 메소드 : 전달받은 원글번호로 board_ref 컬럼의 값이 일치하는 댓글과 대댓글 조회용
        List<ReplyEntity> entities = replyRepository.findAllReply(boardNum);
        ArrayList<Reply> list = new ArrayList<>();
        for(ReplyEntity entity : entities){
            list.add(entity.toDto());
        }
        return list;
    }

    //해당 댓글 조회수 1증가 처리
    @Transactional
    public void updateAddReadCount(int replyNum) {
        replyRepository.addReadCount(replyNum);
    }

    @Transactional
    //댓글과 대댓글 등록
    public Object insertReply(Reply reply) {
        //댓글번호 기록을 위해 마지막 댓글번호 조회 : 추가한 메소드 사용
        int lastNum = replyRepository.findLastReplyNum();

        if(reply.getReplyLev() == 1) {  //댓글 등록이면
            reply.setReplyNum(lastNum + 1); //댓글번호 (replyNum)
            reply.setReplyReplyRef(lastNum + 1);    //댓글이면 참조댓글번호(replyReplyRef)에 자기번호 기록함
            //같은 원글, 같은 레벨의 댓글의 마지막 순번 조회 : 추가한 메소드 사용
            if(replyRepository.countReplySeq(reply.getBoardRef(), reply.getReplyLev()) == 0){
                reply.setReplySeq(1);
            }else {
                reply.setReplySeq(replyRepository.findLastReplySeq(reply.getBoardRef(), reply.getReplyLev()) + 1);
            }
        }
        if(reply.getReplyLev() == 2) {  //대댓글 등록이면
            reply.setReplyNum(lastNum + 1);
            reply.setReplyReplyRef(reply.getReplyReplyRef());
            //같은 원글, 같은 댓글참조, 같은 레벨인 대댓글의 마지막 순번 조회 : 추가한 메소드 사용
            reply.setReplySeq(replyRepository.findLastReplyReplySeq(
                    reply.getBoardRef(), reply.getReplyReplyRef(), reply.getReplyLev()) + 1);
        }        
       
        return replyRepository.save(reply.toEntity());   //jpa 가 제공
    }

    @Transactional
    public Reply updateReply(Reply reply) {
        return replyRepository.save(reply.toEntity()).toDto();
    }

    @Transactional
    public int deleteReply(int replyNum) {
        //댓글, 대댓글 삭제
        //댓글 삭제시 제약조건에 의해 대댓글도 함께 삭제됨(on delete cascade 설정되어 있음)
        //jpa 제공 메소드 사용
        try {
            replyRepository.deleteById(replyNum);
            return 1;
        }catch (Exception e){
            log.info(e.getMessage());
            return 0;
        }

    }

}
