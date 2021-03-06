package com.myboard.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.myboard.dao.ReplyDAO;
import com.myboard.dto.ReplyDTO;

@Service
public class ReplyServiceImpl implements ReplyService{

	@Resource
	private ReplyDAO rdao;
	
	@Override
	public int insert(ReplyDTO rdto) throws Exception {
		return rdao.insert(rdto);
	}

	@Override
	public int update(ReplyDTO rdto) throws Exception {
		return rdao.update(rdto);
	}

	@Override
	public int delete(int rnum) throws Exception {
		return rdao.delete(rnum);
	}

	@Override
	public List<ReplyDTO> selectList(int bnum) throws Exception {
		return rdao.selectList(bnum);
	}

	@Override
	public ReplyDTO selectOne(int rnum) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int delete_bnum(int bnum) throws Exception {
		return rdao.delete_bnum(bnum);
	}

}
