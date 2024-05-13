package com.ohmycar.service;

import java.util.List;
import java.util.Map;

import com.ezen.realfinal.board.model.vo.Board;
import com.ezen.realfinal.board.model.vo.Reply;
import com.ezen.realfinal.common.util.PageInfo;

public interface MypageBoardService {

	public int getBoardCount(Map<String, String> param);
	List<Board> getBoardList(PageInfo pageInfo, Map<String, String> param);
	public int getReplyCount(Map<String, String> param);
	public List<Reply> getReplyList(PageInfo pageInfo, Map<String, String> param);
}