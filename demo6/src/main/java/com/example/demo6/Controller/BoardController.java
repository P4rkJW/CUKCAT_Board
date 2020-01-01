package com.example.demo6.Controller;

import com.example.demo6.Domain.Board;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import com.example.demo6.Service.BoardService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class BoardController {

    @Autowired
    BoardService boardService;

    @GetMapping("/rank")
    public String rank() {
        return "board/rank";
    }

    @GetMapping("/write")
    public String write(){
        return "board/write";
    }

    @PostMapping("/write_proc")
    public String write_proc(@RequestParam("file") String file, @RequestParam("title") String title, @RequestParam("content") String content){
        Board board = new Board();
        board.setContent(content);
        board.setFile(file);
        board.setTitle(title);
        boardService.InsertBoard(board);
        return "index";
    }

    @GetMapping("/delete")
    public String delete(){
        return "board/delete";
    }

    @PostMapping("/delete_proc")
    public String delete_proc(@RequestParam("seq") int seq){
        Board board = new Board();
        board.setSeq(seq);
        boardService.DeleteBoard(board);
        return "index";
    }

}
