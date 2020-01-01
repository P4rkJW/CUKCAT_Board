package com.example.demo6.Service.Impl;

import com.example.demo6.Domain.Board;
import com.example.demo6.Service.BoardService;
import com.example.demo6.Mapper.BoardMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
