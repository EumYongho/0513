package com.ohmycar.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ezen.realfinal.board.model.vo.Board;
import com.ezen.realfinal.board.model.vo.Reply;
import com.ohmycar.common.util.PageInfo;
import com.ezen.realfinal.mypageBoard.model.mapper.MypageBoardMapper;

@Service
public class MypageBoardServiceImpl implements MypageBoardService{
	
	@Autowired
	private MypageBoardMapper mapper;
	
	@Override
	@Transactional(rollbackFor =  Exception.class)
	public int getBoardCount(Map<String, String> param) {
		Map<String, String> searchMap = new HashMap<String, String>();
		String searchValue = param.get("searchValue");
		
		searchMap.put("titleKeyword", searchValue);
		searchMap.put("board_list_no", param.get("type"));
		searchMap.put("user_no", param.get("user_no"));
		
		return mapper.selectMypageBoardCount(searchMap);
	}

	@Override
	@Transactional(rollbackFor =  Exception.class)
	public List<Board> getBoardList(PageInfo pageInfo, Map<String, String> param) {
		int offset = (pageInfo.getCurrentPage() - 1) * pageInfo.getListLimit();
		RowBounds rowBounds = new RowBounds(offset, pageInfo.getListLimit());
		
		Map<String, String> searchMap = new HashMap<String, String>();
		String searchValue = param.get("searchValue");
		searchMap.put("board_list_no", param.get("type"));
		searchMap.put("user_no", param.get("user_no"));
		searchMap.put("titleKeyword", searchValue);
		searchMap.put("sort", param.get("sort"));
		
		return mapper.selectMypageBoardList(rowBounds, searchMap);
	}

	@Override
	public int getReplyCount(Map<String, String> param) {
		Map<String, String> searchMap = new HashMap<String, String>();
		String searchValue = param.get("searchValue");
		
		searchMap.put("board_list_no", param.get("type"));
		searchMap.put("user_no", param.get("user_no"));
		
		if(searchValue != null && searchValue.length() > 0) {
			String type = param.get("sdarchType");
			if(type.equals("board_title")) {
				searchMap.put("titleKeyword", searchValue);
			} else if(type.equals("board_content")) {
				searchMap.put("contentKeyword", searchValue);
			} else if(type.equals("user_NickName")) {
				searchMap.put("NickNameKeyword", searchValue);
			}
		}
		return mapper.selectMypageReplyCount(searchMap);
	}

	@Override
	public List<Reply> getReplyList(PageInfo pageInfo, Map<String, String> param) {
		int offset = (pageInfo.getCurrentPage() - 1) * pageInfo.getListLimit();
		RowBounds rowBounds = new RowBounds(offset, pageInfo.getListLimit());
		
		Map<String, String> searchMap = new HashMap<String, String>();
		String searchValue = param.get("searchValue");
		searchMap.put("board_list_no", param.get("type"));
		searchMap.put("user_no", param.get("user_no"));
		
		if(searchValue != null && searchValue.length() > 0) {
			String type = param.get("searchType");
			if(type.equals("board_title")) {
				searchMap.put("titleKeyword", searchValue);
			} else if(type.equals("board_content")) {
				searchMap.put("contentKeyword", searchValue);
			} else if(type.equals("user_NickName")) {
				searchMap.put("NickNameKeyword", searchValue);
			} 
		}
		return mapper.selectMypageReplyList(rowBounds, searchMap);
	}
}