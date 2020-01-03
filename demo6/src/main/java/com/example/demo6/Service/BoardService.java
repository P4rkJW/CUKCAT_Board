package com.example.demo6.Service;

import com.example.demo6.Domain.Board;

import java.util.List;

public interface BoardService {
    public void InsertBoard(Board board);
    public void DeleteBoard(Board board);
    public void UpdateBoard(Board board);
    public Board SelectBoard(Board board);
    public List<Board> RankListBoard();
}