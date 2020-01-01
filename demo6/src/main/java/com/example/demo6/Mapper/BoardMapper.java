package com.example.demo6.Mapper;

import com.example.demo6.Domain.Board;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BoardMapper {
    public void Boardinsert(Board board);
    public void BoardDelete(Board board);
}
