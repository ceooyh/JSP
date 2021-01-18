package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import config.DBmanager;
import vo.memberVo;

public class memberDao {
	public static memberDao instance = new memberDao();

	private memberDao() {
	}

	public static memberDao getInstance(){
		if(instance == null) {
			instance = new memberDao();
		}
		return instance;
	}
	public void close(ResultSet rs, PreparedStatement pstmt) {
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}
	public void insertMemberVo(memberVo vo) throws Exception {
		Connection conn = DBmanager.getInstance().getConnection();
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		String sql = "insert into member(id,pass,name,age) values(?,?,?,?)";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getId());
			pstmt.setString(2, vo.getPass());
			pstmt.setString(3, vo.getName());
			pstmt.setInt(4, vo.getAge());
			int count = pstmt.executeUpdate();
				if(count == 0 ) {
					throw new Exception("데이터 등록에 실패했습니다");
				}
				System.out.println(count+"건이 추가되었습니다.");
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			close(rs, pstmt);
		}
		
		
	}
	public memberVo selectMemberVo(String id) {
			memberVo vo = null;
			Connection conn = null;
			ResultSet rs = null;
			PreparedStatement pstmt = null;
			String sql = "Select * from member where id = ?";
			
			try {
				conn = DBmanager.getInstance().getConnection();
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, id);
				rs = pstmt.executeQuery();
				while(rs.next()) {
					vo = new memberVo(rs.getString(1),rs.getString(2),rs.getString(3),rs.getInt(4),rs.getString(5));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				close(rs,pstmt);
			}
			return vo;
			}

	public void updatePass(String id, String pass) throws Exception {
		Connection conn = DBmanager.getInstance().getConnection();
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		String sql = "update member set pass = ? where id =?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, pass);
			pstmt.setString(2, id);
			int count = pstmt.executeUpdate();
				if(count == 0 ) {
					throw new Exception("데이터 등록에 실패했습니다");
				}
				System.out.println(count+"건이 추가되었습니다.");
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			close(rs, pstmt);
		}
	}

	public memberVo loginSearchMemberVo(String id, String pass) {
		memberVo vo = null;
		Connection conn = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		String sql = "select e.id,e.pass,e.name,e.age,g.grade_name from member e, grade_list g where e.grade=g.grade and e.id like ? and e.pass like ?";
		
		try {
			conn = DBmanager.getInstance().getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, pass);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				vo = new memberVo(rs.getString(1),null,rs.getString(3),rs.getInt(4),rs.getString(5));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs,pstmt);
		}
		return vo;
		}

	public void updateMemberVo(String id, String pass, String name, int age) throws Exception {
		Connection conn = DBmanager.getInstance().getConnection();
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		memberVo vo = null;
		String sql = "update member set pass = ? ,name = ? ,age = ? where id =?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, pass);
			pstmt.setString(2, name);
			pstmt.setInt(3, age);
			pstmt.setString(4, id);
			rs = pstmt.executeQuery();
			int count = pstmt.executeUpdate();
				if(count == 0 ) {
					throw new Exception("데이터 등록에 실패했습니다");
				}
				System.out.println(count+"건이 업데이트되었습니다.");
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			close(rs, pstmt);
		}
	}

	public ArrayList<memberVo> selectAllMemberVO() {
		ArrayList<memberVo> list = new ArrayList<memberVo>();
		String sql = "select e.id,e.pass,e.name,e.age,g.gname from member e, grade_list g where e.grade=g.grade";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = DBmanager.getInstance().getConnection().prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				list.add(new memberVo(rs.getString(1),null, rs.getString(3), rs.getInt(4),rs.getString(5)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs, pstmt);
		}
		return list;
	}

	public ArrayList<memberVo> searchNameMemberVO(String name) {
		ArrayList<memberVo> list = new ArrayList<memberVo>();
		String sql = "select e.id,e.pass,e.name,e.age,g.gname from member e, grade_list g where e.grade=g.grade and name like %?%";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = DBmanager.getInstance().getConnection().prepareStatement(sql);
			pstmt.setString(1, name);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				list.add(new memberVo(rs.getString(1),null, rs.getString(3), rs.getInt(4),rs.getString(5)));
				System.out.println(list.toString());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs, pstmt);
		}
		return list;
	}

	public ArrayList<memberVo> searchMemberVo(String kind, String search) {
		ArrayList<memberVo> list = null;
		String sql = "select e.id,e.pass,e.name,e.age,g.gname from member e, grade_list g where e.grade=g.grade" + kind + "like ?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = DBmanager.getInstance().getConnection().prepareStatement(sql);
			pstmt.setString(1,"%"+ search +"%");
			rs = pstmt.executeQuery();
			while(rs.next()) {
				list.add(new memberVo(rs.getString(1),null, rs.getString(3), rs.getInt(4),rs.getString(5)));
				System.out.println(list.toString());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs, pstmt);
		}
		return list;
	}
}
	

