package test.properties;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Properties;

public class PropertiesSample {
	public void test1() {
		// Properties 사용 : 
		// 어플리케이션의 설정 값들을 파일에 저장하고, 실행시 읽어 들여서 프로그램에 적용하는 용도로 사용할 때
		// 주로 이용하는 클래스
		Properties prop = new Properties(); // 설정값 저장 용도로 사용함
		// key 도 String, value 도 String 으로 정해진 클래스
		// Properties 이름 옆에 <영문자, 영문자> 제네릭 표시가 없음
		
		// 설정값 저장시 : setProperty(String key, String value) 사용함
		prop.setProperty("driver", "oracle.jdbc.driver.OracleDriver");
		prop.setProperty("url", "jdbc:oracle:thin:@127.0.0.1:1521:xe");
		prop.setProperty("user", "c##student");
		prop.setProperty("passwd", "student");
		
		System.out.println(prop);
		
		//파일에 출력 저장
		try {
			prop.store(new FileOutputStream("db_setting.dat"), "jdbc oracle connection setting");
			prop.store(new FileWriter("db_setting.txt"), "jdbc oracle connection setting");
			prop.storeToXML(new FileOutputStream("db_setting.xml"), 
					"jdbc oracle connection setting, null", "utf-8");
		} catch (Exception e) {
			e.printStackTrace();
		}
	} // test1()
	
	
	public void test2() {
		// 설정 파일로 부터 값 읽어오기 테스트
		Properties prop1 = new Properties();
		Properties prop2 = new Properties();
		Properties prop3 = new Properties();
		
		try {
			prop1.load(new FileInputStream("db_setting.dat"));
			prop2.load(new FileReader("db_setting.txt"));
			prop3. loadFromXML(new FileInputStream("db_setting.xml"));
			
			prop1.list(System.out);
			prop2.list(System.out);
			prop3.list(System.out);
		
		} catch (Exception e) {
			e.printStackTrace();
		}
	}// test2()
	
	public void test3() {
		// 파일로부터 읽어온 값들을 하나씩 꺼내기
		Properties prop = new Properties();
		
		try {
			prop.loadFromXML(new FileInputStream("db_setting.xml"));
			
			System.out.println(prop);
			prop.list(System.out);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		// 값 꺼내기 : getProperty(key) : String 값이 반환됨
		String driver = prop.getProperty("driver");
		String url = prop.getProperty("url");
		String user = prop.getProperty("user");
		String pwd = prop.getProperty("passwd");
		
		System.out.println(driver);
		System.out.println(url);
		System.out.println(user);
		System.out.println(pwd);
				
		
		
	}
	
}






























