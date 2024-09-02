package test.objectio;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

public class MemberManager {
	private Scanner sc = new Scanner(System.in);
	private Member[] marray;
	
	// 초기화 블럭
	{
		marray = new Member[] {
				new Member("홍길동", 29, '남', "hong77@test.org", "010-1234-5678", 13500.77),
				new Member("홍박사", 35, '여', "drhong@test.org", "010-5555-5678", 8687.77),
				new Member("홍홍이", 21, '여', "honghong@test.org", "010-7894-4651", 2000.77)		
		};
	}
	
	
	// 생성자에서 객체배열의 주소를 전달받아 초기화 처리
	public MemberManager(Member[] array) {
		marray = array;
	}
	
	public void fileSave() {
		System.out.println("저장할 파일명 (.dat)");
		String fileName = sc.next();
		
//		try (FileOutputStream fout = new FileOutputStream(fileName);
//				ObjectOutputStream objOut = new ObjectOutputStream(fout);){
			
			try (ObjectOutputStream objOut = new ObjectOutputStream(
					new FileOutputStream(fileName));){
			// 준비된 객체 배열을 파일에 저장 처리
			for(Member m : marray) {
				objOut.writeObject(m);
			}
				
			System.out.println(fileName + " 파일에 저장 완료!");
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return;
		}
	}
		
	public void fileRoad() {
		System.out.println("읽을 파일명 : ");
		String fileName = sc.next();
		try (ObjectInputStream objin = new ObjectInputStream(
				new FileInputStream(fileName));){
			// 읽어들일 객체, 저장할 객체 배열 선언 및 할당함
			Member[] members = new Member[marray.length];
			
			for(int i = 0; i < members.length; i++) {
				members[i] = (Member)objin.readObject();
				System.out.println(members[i]);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return;
		}
	}
	
	
	
}
