package employee.view;

import java.util.ArrayList;
import java.util.Scanner;

import employee.controller.EmployeeController;
import employee.exception.EmployeeException;
import employee.model.dto.Employee;

public class EmployeeMenu {
	// 의존성 주입 (DI : Dependency Injection)
	private EmployeeController econtroll;
	
	private Scanner sc = new Scanner(System.in);

	public EmployeeMenu() {
		try {
			econtroll = new EmployeeController();
		} catch (EmployeeException e) {
			printError(e.getMessage());
			e.printStackTrace();
		}
	}
	
	public void display() {
		do {
			System.out.println("\n***** 직원 관리 프로그램 *****\n");

			System.out.println("1. 직원 전체 조회 출력");
			System.out.println("2. 사번으로 직원 조회 출력");
			System.out.println("3. 새 직원 등록");
			System.out.println("4. 직원 정보 수정");
			System.out.println("5. 직원 삭제");
			System.out.println("6. 부서로 조회");
			System.out.println("7. 직급으로 조회");

			System.out.println("9. 프로그램 끝내기");

			System.out.print("번호 입력 : ");
			int no = sc.nextInt();
			try {
				switch (no) {
				case 1:
					printList(econtroll.selectList());
					break;
				case 2:
					Employee emp = econtroll.selectEmp(inputEmpId());
					if(emp != null)
						System.out.println(emp);
					else
						System.out.println("직원이 존재하지 않습니다.");
					break;
				case 3:
					econtroll.insertEmp(inputEmp());
					break;
				case 4:
					econtroll.updateEmp(modifyEmp());
					break;
				case 5:
					if (econtroll.deleteEmp(inputEmpId()) > 0) {
						System.out.println("성공적으로 삭제되었습니다.");
					} else {
						System.out.println("직원 삭제 실패");
					}
					break;
				case 6:
					printList(econtroll.selectDept(inputDeptId()));
					break;
				case 7:
					printList(econtroll.selectJob(inputJobId()));
					break;

				case 9:
					System.out.print("정말 끝내시겠습니까? (y/n)");
					if (sc.next().toUpperCase().charAt(0) == 'Y') {
						System.out.println("프로그램을 종료합니다.");
						return;

					} else {
						break; // switch 문을 빠져 나감
					}
				default:
					System.out.println("잘못된 번호입니다. 확인 후 다시 입력해주세요.");
				}
			} catch (EmployeeException e) {
				printError(e.getMessage());
			}
		} while (true);
	}// display()

	private void printError(String msg) {
		System.out.println("오류 발생 : " + msg);
		
	}

	// 리스트 출력용 메서드
	public void printList(ArrayList<Employee> list) {
		System.out.println("\n직원수 : " + list.size() + "명");
		for (Employee emp : list) {
			System.out.println(emp);
		}
	}

	// 사번 입력용 메서드
	public String inputEmpId() {
		System.out.println("\n조회 또는 삭제할 사번 : ");
		return sc.next();
	}

	// 부서코드 입력용 메서드
	public String inputDeptId() {
		System.out.println("\n조회할 부서번호 : ");
		return sc.next();
	}

	// 부서코드 입력용 메서드
	public String inputJobId() {
		System.out.println("\n조회할 직급번호 : ");
		return sc.next().toUpperCase();
	}

	// 수정할 직원정보 입력용 메서드
	public Employee modifyEmp() {
		Employee emp = new Employee();

		System.out.print("수정할 직원 사번 : ");
		emp.setEmpId(sc.next());
		System.out.print("수정할 급여 : ");
		emp.setSalary(sc.nextInt());
		System.out.print("수정할 보너스포인트 : ");
		emp.setBonusPct(sc.nextDouble());

		return emp;
	}

	// 새 직원 정보 입력용 메서드
	public Employee inputEmp() {
		Employee emp = new Employee();

		System.out.print("이름 : ");
		emp.setEmpName(sc.next());
		System.out.print("주민번호 : ");
		emp.setEmpNo(sc.next());
		System.out.print("email : ");
		emp.setEmail(sc.next());
		System.out.print("전화번호 [- 빼고 입력] : ");
		emp.setPhone(sc.next());
		System.out.print("급여 : ");
		emp.setSalary(sc.nextInt());
		System.out.print("보너스 포인트 : ");
		emp.setBonusPct(sc.nextDouble());
		System.out.print("직급 코드 [J1 ~ J7]: ");
		emp.setJobId(sc.next().toUpperCase());
		System.out.print("부서 코드 : ");
		emp.setDeptId(sc.next());
		System.out.print("결혼 여부[기혼 : Y/미혼 : N] : ");
		emp.setMarriage(sc.next().toUpperCase());
		System.out.print("관리자 사번 : ");
		emp.setMgrId(sc.next());
		System.out.println("입사일 [yyyy-MM-dd] : ");
		emp.setHireDate(java.sql.Date.valueOf(sc.next()));

		return emp;
	}

}
