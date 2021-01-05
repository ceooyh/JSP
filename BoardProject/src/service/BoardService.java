package service;

import dao.BoardDao;
import dto.BoardDTO;

public class BoardService {
	private static BoardService instance = new BoardService();
	private BoardDao dao;

	public BoardService() {
		dao = BoardDao.getInstance();
	}

	public static BoardService getInstance() {
		if(instance == null) {
			instance = new BoardService();
		}
		return instance;
	}

	public BoardDTO insertBoardDTO(BoardDTO dto) throws Exception {
		int bno = dao.getBoardNO();//게시글 번호 하나 뽑아서
		dto.setBno(bno);//게시글 번호 셋팅
		dao.insertBoardDTO(dto);
		//return dao.selectBoardDTO(bno);
		return null;
	}
	

}
