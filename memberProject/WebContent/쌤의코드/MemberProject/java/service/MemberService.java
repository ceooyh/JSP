package service;

import dao.MemberDAO;
import exception.MemberException;
import vo.MemberVO;

public class MemberService {
	private static MemberService instance = new MemberService();
	private MemberDAO dao;
	private MemberService() {
		dao = MemberDAO.getInstance();
	}
	
	public static MemberService getInstance() {
		if(instance==null)
			instance= new MemberService();
		return instance;
	}
	
	public void insertMemberVO(MemberVO vo) throws MemberException {
		//회원정보 조회
		if(dao.selectMemberVO(vo.getId())!=null)
			throw new MemberException("이미 회원정보가 있습니다.");
		//회원정보 등록
		dao.insertMemberVO(vo);
	}

	public void findMemberVO(String id, String name) throws Exception {
		MemberVO vo = dao.selectMemberVO(id);
		System.out.println(vo.toString());
		System.out.println(name);
		if(!vo.getName().equals(name))
			throw new Exception("정보에 해당하는 회원정보가 없습니다.");
	}
	
	public void updatePass(String id, String pass) throws MemberException {
		dao.updatePass(id,pass);
	}
}










