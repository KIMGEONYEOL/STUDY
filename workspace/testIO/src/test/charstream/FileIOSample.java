package test.charstream;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FileIOSample {
	//DI
	private Scanner sc = new Scanner(System.in);
	
	public void fileSave() {
		System.out.print("저장할 파일명 (파일명.txt): ");
		String fileName = sc.next();
		
		File saveFile = new File(fileName);
		System.out.println("파일 용량 확인 : " + saveFile.length()); // 0 byte
		System.out.println("새로 만든 파일이냐? : " + saveFile.isFile()); //true
		System.out.println("디렉토리냐? : " + saveFile.isDirectory()); //false
		
		// 자동 close 처리할 객체 생성 구문을 try () 안에 작성하면 됨
		// try (클래스타입 레퍼런스 = new 생성자(초기값);)
		try (FileWriter fw = new FileWriter(saveFile);){
			// 대상 파일이 없으면 파일을 자동으로 만듦
			// 대상 파일이 있으면, 기존 내용을 지우고 새로쓰기 상태로 열기함.
			
			System.out.println(saveFile.getName() + "에 저장할 내용을 입력하세요.");
			String data;
			while((data = sc.nextLine()).equals("exit") != true) {
				fw.write(data + "\n");				
			}
			System.out.println(saveFile.getName() + "저장 완료!");
			
		} catch (IOException e) {
//			e.printStackTrace();
			System.out.println(e.getMessage());
			return;
		}
		
	}
	
	public void fileRead() {
		System.out.println("읽을 파일명 (파일명.txt): ");
		String fileName = sc.next();
		
		try (FileReader fr = new FileReader(fileName);) {
			// 대상 파일이 없으면 예외(Error) 발생함
			
			int data;
			while((data = fr.read()) != -1) {
				System.out.print((char)data);
			}
			System.out.println();
			
		} catch (Exception e) { // 다형성 적용
			// FileNotFoundException => Exception 이 받아서 처리할 것임
			// IOException => Exception 이 받아서 처리할 것임
			 System.out.println(e.getMessage());
			 return;
		}
	}
	
	
	public void fileAppend() {
		System.out.println("내용을 추가할 파일명(.txt) : ");
		String fileName = sc.next();
		
		try (FileWriter fw = new FileWriter(fileName, true);) {
			// 대상 파일이 없으면, 파일을 새로 만들도 스트림을 연결함.
			// 대상 파일이 있으면, 기존 내용을 그대로 두고 추가쓰기 상태로 연결됨
			
			System.out.println(fileName + "에 추가할 내용을 입력하세요.");
			String data;
//			while((data = sc.nextLine).equals("exit") != true) {
			while(!(data = sc.nextLine()).equals("exit")){
				fw.write(data + "\n");
			}
			System.out.println(fileName + "추가 저장 완료!");
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return;
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
