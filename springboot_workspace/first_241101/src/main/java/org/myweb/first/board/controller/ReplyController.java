package org.myweb.first.board.controller;

import lombok.extern.slf4j.Slf4j;
import org.myweb.first.board.model.dto.Board;
import org.myweb.first.board.model.dto.Reply;
import org.myweb.first.board.model.service.ReplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Slf4j
@Controller
public class ReplyController {
    @Autowired
    private ReplyService replyService;

    //뷰 페이지 이동처리용 ----------------------------------------------------

    //게시글 댓글 등록페이지로 이동 처리용
    @RequestMapping("breplyform.do")
    public ModelAndView moveReplyPage(
            @RequestParam("bnum") int boardNum,
            @RequestParam("page") String page, ModelAndView mv) {

        mv.addObject("bnum", boardNum);
        mv.addObject("page", page);
        mv.setViewName("reply/boardReplyForm");

        return mv;
    }

    //게시글 대댓글 등록페이지로 이동 처리용
    @RequestMapping("rreplyform.do")
    public ModelAndView moveRreplyPage(
            @RequestParam("boardRef") int boardRef,
            @RequestParam("replyReplyRef") int replyReplyRef,
            ModelAndView mv) {
        log.info("moveRreplyPage : " + boardRef + ", " + replyReplyRef);

        mv.addObject("boardRef", boardRef);
        mv.addObject("replyReplyRef", replyReplyRef);
        mv.setViewName("reply/replyReplyForm");

        return mv;
    }


    //요청 처리용 ---------------------------------------------------------------

    //게시 댓글 등록 처리용
    @RequestMapping(value="breply.do", method=RequestMethod.POST)
    public String replyInsertMethod(
            Reply reply,
            @RequestParam("page") String page, Model model) {
        //log.info("breply.do : " + reply);

        //원글에 대한 댓글이므로 레벨을 1로 지정함
        reply.setReplyLev(1);

        if(replyService.insertReply(reply) != null) {
            return "redirect:bdetail.do?bnum=" + reply.getBoardRef() + "&page=" + page;
        }else {
            model.addAttribute("message", reply.getBoardRef() + "번에 대한 댓글 등록 실패!");
            return "common/error";
        }
    }

    //게시 대댓글 등록 처리용
    @RequestMapping(value="rreply.do", method=RequestMethod.POST)
    public String rreplyInsertMethod(Reply reply, Model model) {
        log.info("rreply.do : " + reply);

        if(replyService.insertReply(reply) != null) {
            return "redirect:bdetail.do?bnum=" + reply.getBoardRef() ;
        }else {
            model.addAttribute("message", reply.getBoardRef() + "번에 대한 댓글 등록 실패!");
            return "common/error";
        }
    }

    //댓글과 대댓글 수정 처리용
    @RequestMapping(value="breplyupdate.do", method=RequestMethod.POST)
    public String replyUpdateMethod(Reply reply, Model model) {

        if(replyService.updateReply(reply) != null) {
            //댓글과 대댓글 수정 성공시 다시 상세보기가 보여지게 처리
            return "redirect:bdetail.do?bnum=" + reply.getBoardRef();
        }else {
            model.addAttribute("message", reply.getReplyNum() + "번 글 수정 실패!");
            return "common/error";
        }
    }

    //댓글과 대댓글 삭제 처리용
    @RequestMapping(value="breplydelete.do", method=RequestMethod.GET)
    public String replyDeleteMethod(
            @RequestParam("replyNum") int replyNum,
            @RequestParam("boardNum") int boardNum, Model model) {
        log.info("breplydelete.do : " + replyNum);
        if(replyService.deleteReply(replyNum) > 0) {
            //댓글과 대댓글 삭제 성공시 다시 상세보기가 보여지게 처리
            return "redirect:bdetail.do?bnum=" + boardNum;
        }else {
            model.addAttribute("message", replyNum + "번 글 삭제 실패!");
            return "common/error";
        }
    }
}
