  
package main;


import java.util.List;

import javax.swing.JOptionPane;

import dao.EmployeeDAO;
import dto.EmployeeDTO;

public class MyBatisMain {

	public static void main(String[] args) {
		EmployeeDAO dao = EmployeeDAO.getInstance();
//		int count = dao.selectEmployeeAllCount();
//		System.out.println("현재 사원 인원수 : " + count);
//		
//		System.out.println("---------------------------------------");
//		List<EmployeeDTO> list  = dao.selectAllEmployee();
//		for(int i =0; i<list.size();i++) {
//			System.out.println(list.get(i).toString());
//		}
//		System.out.println("---------------------------------------");
//		
//		List<EmployeeDTO> list2  = dao.selectPositionEmployee(4);
//		for(int i =0; i<list.size();i++) {
//			System.out.println(list.get(i).toString());
//		}
//		
//		System.out.println("---------------------------------------");
//		List<EmployeeDTO> list3  = dao.selectPositionAreaEmployee(2,5);
//		for(int i =0; i<list.size();i++) {
//			System.out.println(list.get(i).toString());
//		}
		System.out.println("---------------------------------------");
		String eno  = JOptionPane.showInputDialog("사원번호를 입력하시오");
		String name  = JOptionPane.showInputDialog("사원이름을 입력하시오");
		String department  = JOptionPane.showInputDialog("부서를 입력하시오");
		int position  = Integer.parseInt((JOptionPane.showInputDialog("사원등급을 입력하시오")));
		EmployeeDTO dto = new EmployeeDTO(eno, name, department, position);
		
		try {
			dao.getInstance().insertEmployee(dto);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("---------------------------------------");
		String eno1  = JOptionPane.showInputDialog("수정할 사원번호를 입력하시오");
		String name1  = JOptionPane.showInputDialog("수정할 사원이름을 입력하시오");
		String department1  = JOptionPane.showInputDialog("수정할 부서를 입력하시오");
		int position1  = Integer.parseInt((JOptionPane.showInputDialog("사원등급을 입력하시오")));
		EmployeeDTO dto1 = new EmployeeDTO(eno1, name1, department1, position1);
		
		System.out.println("---------------------------------------");
		String name2  = JOptionPane.showInputDialog("검색할 사원이름을 입력하시오");
		name2 = "%" + name2 +"%";
	}
	
	
	
	
	
	
	
	
}