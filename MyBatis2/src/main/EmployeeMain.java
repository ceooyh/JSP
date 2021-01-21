package main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

import dao.EmployeeDAO;
import dto.EmployeeDTO;


public class EmployeeMain {
	
	public static void main(String[] args) {
		
//		List<EmployeeDTO> list= EmployeeDAO.getInstance().selectAllEmployee();
//		for(int i =0; i<list.size();i++) {
//			System.out.println(list.get(i).toString());
//		}
		
		System.out.println("---------------------------------------------------");
		
		int count = EmployeeDAO.getInstance().selectAllCountEmployee();
			System.out.println("총 직원수 : " + count + "명");
			
			
//		System.out.println("---------------------------------------------------");
//		
		Scanner sc = new Scanner(System.in);
//		System.out.print("포지션 값을 입력하세요 : ");
//		int position = sc.nextInt();
//		
//		ArrayList<EmployeeDTO> list2 = EmployeeDAO.getInstance().selectPositionEmployee(position);
//		for(int i =0; i<list2.size();i++) {
//			System.out.println(list2.get(i).toString());
//		}
//		
//		System.out.println("---------------------------------------------------");
//		
//		System.out.print("포지션 영역1을 입력하세요 : ");
//		int num1 = sc.nextInt();
//		System.out.print("포지션 영역2를 입력하세요 : ");
//		int num2 = sc.nextInt();
//		
//		List<EmployeeDTO> list3 = EmployeeDAO.getInstance().selectPositionAreaEmployee(num1,num2);
//		for(int i =0; i<list3.size();i++) {
//			System.out.println(list3.get(i).toString());
//		}
		
//		System.out.println("---------------------------------------------------");
//		
//		
//		System.out.print("사원 추가 시퀸스를 시작합니다.");
//		System.out.print("추가할 사원의 사원번호를 입력하세요 : ");
//		String eno = sc.nextLine();
//		System.out.print("추가할 사원의 이름을 입력하세요 : ");
//		String name = sc.nextLine();
//		System.out.print("추가할 사원의 부서를 입력하세요 : ");
//		String department = sc.nextLine();
//		System.out.print("추가할 사원의 등급을 입력하세요 : ");
//		int position = sc.nextInt();
//		EmployeeDTO dto = new EmployeeDTO(eno, name, department, position);
//		
//		EmployeeDAO.getInstance().insertEmployee(dto);
//		List<EmployeeDTO> list= EmployeeDAO.getInstance().selectAllEmployee();
//		for(int i =0; i<list.size();i++) {
//			System.out.println(list.get(i).toString());
//		}
		
//		System.out.println("---------------------------------------------------");
//		
//		
//		System.out.print("변경할 사원의 사원번호를 입력하세요 : ");
//		String eno = sc.nextLine();
//		System.out.print("변경할 사원의 이름을 입력하세요 : ");
//		String name = sc.nextLine();
//		System.out.print("변경할 사원의 부서를 입력하세요 : ");
//		String department = sc.nextLine();
//		System.out.print("변경할 사원의 등급을 입력하세요 : ");
//		int position = sc.nextInt();
//		HashMap<String, Object> map = new HashMap<String, Object>();
//		
//		map.put("eno", eno);
//		map.put("name", name);
//		map.put("department", department);
//		map.put("position", position);
//		
//		int count1 = EmployeeDAO.getInstance().updateEmployee(map);
//		
//		List<EmployeeDTO> list= EmployeeDAO.getInstance().selectAllEmployee();
//		for(int i =0; i<list.size();i++) {
//			System.out.println(list.get(i).toString());
//		}
		
		
		System.out.println("-----------------------------------------");
		System.out.print("검색할 이름 입력하세요 : " );
		String name = sc.nextLine();
		name = "%" + name + "%";
		
		ArrayList<EmployeeDTO> list = EmployeeDAO.getInstance().selectNameEmployee(name);
		
		for(int i=0; i<list.size();i++) {
			System.out.println(list.get(i).toString());
		}
		
		
	}
}
