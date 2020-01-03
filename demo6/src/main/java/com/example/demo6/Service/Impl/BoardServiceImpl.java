package com.example.demo6.Service.Impl;

import com.example.demo6.Domain.Board;
import com.example.demo6.Service.BoardService;
import com.example.demo6.Mapper.BoardMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardServiceImpl implements BoardService{

    @Autowired
    BoardMapper boardMapper;


    @Override
    public void InsertBoard(Board board){
        boardMapper.Boardinsert(board);
    }

    @Override
    public void DeleteBoard(Board board){
        boardMapper.BoardDelete(board);
    }

    @Override
    public void UpdateBoard(Board board){
        boardMapper.BoardUpdate(board);
    }

    @Override
    public Board SelectBoard(Board board){
        return boardMapper.BoardSelect(board);
    }

    @Override
    public List<Board> RankListBoard() { return boardMapper.RankListBoard(); }

    @Override
    public void RecommandBoard(Board board) { boardMapper.BoardRecommand(board); }

    @Override
    public void OpposeBoard(Board board) { boardMapper.BoardOppose(board); }
}
