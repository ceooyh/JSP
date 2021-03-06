package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import config.DBManager;
import dto.BoardDTO;

public class BoardDAO {
	private static BoardDAO instance = new BoardDAO();
	private DBManager manager;
	private BoardDAO() {
		manager = DBManager.getInstance();
	}

	public static BoardDAO getInstance() {
		if(instance == null)
			instance = new BoardDAO();
		return instance;
	}
	//게시글 번호 뽑는 부분
	public int getBoardNO() {
		String sql = "select bno_seq.nextval from dual";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int result = 0;
		try {
			pstmt = manager.getConn().prepareStatement(sql);
			rs = pstmt.executeQuery();
			if(rs.next())
				result = rs.getInt(1);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			manager.close(pstmt, rs);
		}
		return result;
	}

	public void insertBoardDTO(BoardDTO dto) {
		String sql = "insert into board(bno,title,writer,content) values(?,?,?,?)";
		PreparedStatement pstmt = null;
		try {
			pstmt = manager.getConn().prepareStatement(sql);
			pstmt.setInt(1, dto.getBno());
			pstmt.setString(2, dto.getTitle());
			pstmt.setString(3, dto.getWriter());
			pstmt.setString(4, dto.getContent());
			
			int count = pstmt.executeUpdate();
			System.out.println(count + "건 게시글 등록 완료");
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			manager.close(pstmt, null);
		}
	}

	public BoardDTO selectBoardDTO(int bno) {
		return null;
	}
	
}











