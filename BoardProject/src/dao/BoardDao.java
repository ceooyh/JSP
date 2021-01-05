package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import config.DBConfig;
import config.DBManager;
import dto.BoardDTO;

public class BoardDao {
	private static BoardDao instance = new BoardDao();
	private DBManager manager;
	public BoardDao() {
		manager = DBManager.getInstance();
	}

	public static BoardDao getInstance() {
		if(instance == null) {
			instance = new BoardDao();
		}
		return instance;
	}


	public int getBoardNO() {
		String sql = "select bno_create.nextval from dual";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int result = 0;
		try {
			pstmt = manager.getConn().prepareStatement(sql);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				result = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			manager.close(pstmt, rs);
		}
		return result;
	}
	
	public void insertBoardDTO(BoardDTO dto) throws Exception {
		Connection conn = DBManager.getInstance().getConn();
		PreparedStatement pstmt = null;
		String sql = "insert into board(bno,title,writer,content) values(?,?,?,?)";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, dto.getBno());
			pstmt.setString(2, dto.getTitle());
			pstmt.setString(3, dto.getWriter());
			pstmt.setString(4, dto.getContent());
			int count = pstmt.executeUpdate();
			if(count == 0) {
				throw new Exception("게시글 등록에 실패하였습니다");
			}else
				System.out.println(count + "건 게시글 등록 완료");
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBManager.getInstance().close(pstmt, null);
		}
	}

	public BoardDTO selectBoardDTO(int bno) {
		return null;
	}
}
