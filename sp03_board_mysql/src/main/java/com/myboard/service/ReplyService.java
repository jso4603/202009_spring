package com.myboard.service;

import java.util.List;

import com.myboard.dto.ReplyDTO;

//���
public interface ReplyService {
	public int insert(ReplyDTO rdto) throws Exception;
	public int update(ReplyDTO rdto) throws Exception;
	public int delete(int rnum, int bnum) throws Exception;
	public List<ReplyDTO> selectList(int bnum) throws Exception;
	public ReplyDTO selectOne(int rnum) throws Exception;
	public int delete_bnum(int bnum) throws Exception; //�Խù��� �ش��ϴ� ��� ����
}	