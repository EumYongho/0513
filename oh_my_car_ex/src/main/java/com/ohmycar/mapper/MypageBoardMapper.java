package com.ohmycar.mapper;

import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.session.RowBounds;

import com.ezen.realfinal.board.model.vo.Board;
import com.ezen.realfinal.board.model.vo.Reply;

@Mapper
public interface MypageBoardMapper {
	List<Board> selectMypageBoardList(RowBounds rowBounds, Map<String, String> map); //���� ������ �� �Խñ� �� ���
	int selectMypageBoardCount(Map<String, String> map); //���� �Խñ��� ������ ���ϴ³�!(����¡ ó���� ���� �ʿ���)
	List<Reply> selectMypageReplyList(RowBounds rowBounds, Map<String, String> searchMap);
	int selectMypageReplyCount(Map<String, String> searchMap);
}