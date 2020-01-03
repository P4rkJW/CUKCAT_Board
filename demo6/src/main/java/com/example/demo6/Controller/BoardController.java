package com.example.demo6.Controller;

import com.example.demo6.Domain.Board;
import org.apache.ibatis.javassist.bytecode.analysis.MultiType;
import org.apache.tomcat.util.http.fileupload.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.example.demo6.Service.BoardService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.InputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

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

    public static Path path = Paths.get(System.getProperty("user.home"), ".upload");

    @PostMapping("/write_proc")
    public String write_proc(@RequestParam("file") String filename, @RequestParam("title") String title, @RequestParam("content") String content, @RequestParam("file") MultipartFile multipartfile){

        File targetFIle = new File(path.resolve(multipartfile.getOriginalFilename()).toString());
        Board board = new Board();
        board.setContent(content);
        board.setFile(filename);
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



}
