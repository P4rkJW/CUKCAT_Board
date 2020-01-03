package com.example.demo6.Mapper;

import com.example.demo6.Domain.Board;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BoardMapper {
    public void Boardinsert(Board board);
    public void BoardDelete(Board board);
    public void BoardUpdate(Board board);
    public Board BoardSelect(Board board);
    public List<Board> RankListBoard();
    public void BoardRecommand(Board board);
    public void BoardOppose(Board board);
}
