package com.example.demo.mapping;

import com.example.demo.DTOs.requests.CreateCommentRequest;
import com.example.demo.Entities.Comment;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
@Mapper
public interface CommentMapper extends BaseMapper<CreateCommentRequest, Comment> {
    CommentMapper INSTANCE = Mappers.getMapper(CommentMapper.class);  //kullanmadım
}
