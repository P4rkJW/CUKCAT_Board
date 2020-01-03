package com.example.demo6.Controller;

import java.io.File;
import java.io.IOException;

import com.example.demo6.Domain.Board;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.example.demo6.Service.BoardService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@Slf4j
@Controller
public class BoardController {

    @Autowired
    BoardService boardService;

    @GetMapping("/rank")
    public String rank(Model model) {
        Board board = new Board();
//        board.setSeq(1);
//        Board board1 = boardService.SelectBoard(board);
        List<Board> board1 = boardService.RankListBoard();
        model.addAttribute("list", board1);
        return "board/rank";
    }

    @GetMapping("/write")
    public String write(){
        return "board/write";
    }

    public static Path path = Paths.get(System.getProperty("user.dir"), ".upload");

    @PostMapping("/write_proc")
    public String write_proc(@RequestParam("title") String title, @RequestParam("file") MultipartFile multipartFile) throws IOException {
        File tmp = new File(System.getProperty("user.dir")+"\\target\\classes\\static\\img\\"+multipartFile.getOriginalFilename());
        multipartFile.transferTo(tmp);
        String filename = multipartFile.getOriginalFilename();
        Board board = new Board();
        board.setFile(filename);
        board.setTitle(title);
        boardService.InsertBoard(board);
        return "redirect:/rank";
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
        return "redirect:/rank";
    }

    @GetMapping("/update")
    public String update(){
        return "board/update";
    }

    @PostMapping("/update_proc")
    public String update_proc(@RequestParam("seq") int seq, @RequestParam("file") String file, @RequestParam("title") String title, @RequestParam("content") String content){
        Board board = new Board();
        board.setSeq(seq);
        board.setNewcontent(content);
        board.setNewtitle(title);
        board.setNewfile(file);
        boardService.UpdateBoard(board);
        return "index";
    }

    @GetMapping("/recommand")
    public String recommand(@RequestParam("seq") int seq){
        Board board = new Board();
        board.setSeq(seq);
        boardService.RecommandBoard(board);
        return "redirect:/rank";
    }

    @GetMapping("/oppose")
    public String oppose(@RequestParam("seq") int seq){
        Board board = new Board();
        board.setSeq(seq);
        boardService.OpposeBoard(board);
        return "redirect:/rank";
    }


}
