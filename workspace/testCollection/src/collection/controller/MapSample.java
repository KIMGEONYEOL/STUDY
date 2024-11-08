package collection.controller;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.TreeMap;

public class MapSample {
	
	public void testHashMap() {
		// HashMap 사용 테스트
		HashMap hmap = new HashMap(); // 기본 16개 객체 저장, 확장비율 : 0.75
//		Map hmap2 = new HashMap(); // 다형성 사용
		
		// 저장시 키 객체와 값 객체 두 개를 쌍(Entry) 으로 저장함
		hmap.put(new String("one"), Integer.valueOf(1230));
		hmap.put(2, "java"); // auto boxing : data -> Object 로 자동 변환되어서 저장됨
		hmap.put("three", 36.9); // auto boxing
		hmap.put(4, "jdbc");
		
		System.out.println(hmap); // 오버라이딩 된 hmap.toString() 실행됨
		// 키는 Set, 값은 List 구조임 : 저장 순서 유지 안됨
		
		hmap.put(2, "oracle"); // 기존의 저장된 키에 입력된 값 객체를 바꿈
		System.out.println(hmap);
		
		hmap.put("two", 1230); // 값 객체는 중복 저장됨
		System.out.println(hmap);
		
		// 저장된 객체들 중 하나만 조회할 경우 : get(key) : value 리턴
		System.out.println(hmap.get(2));
		
		System.out.println("size : " + hmap.size());
		
		// 저장된 객체 삭제 : remove(key)
		hmap.remove("one");
		System.out.println(hmap);
		System.out.println("size : " + hmap.size());
		
		// 맵에 저장된 객체들을 연속으로 처리하는 방법이 기본 제공되는 메서드에서는 없음
		// 해결방법 1 : key 들을 Set 으로 바꿈 : keySet() 사용 => iterator() 로 key 목록을 만듦
		System.out.println("keySet() => Iterator()로 키 목록 만들어서 연속 처리 ----------------");
		Set keys = hmap.keySet(); // Map 의 key 들만 Set 으로 바꿈
		Iterator keyIter = keys.iterator(); // key 에 대한 Set 으로 목록 만들기함
		while(keyIter.hasNext()) {
			Object key = keyIter.next()	;
			Object value = hmap.get(key);
			System.out.println(key + "=" + value);			
		}
		// 해결방법 2 : 값 객체들을 Collection 으로 바꿈 => for each 문으로 연속 처리
		System.out.println("values() => Collection 으로 값 객체들만 변환");
		Collection values = hmap.values();
		//for each 문 : 객체배열과 컬렉션 연속 처리에 사용하는 루프문임
		for(Object obj : values) {
			System.out.println(obj);
		}
		
		// 해결방법 3 : 값 객체들을 Collection 으로 바꿈 => toArray() : Object[] => for 문으로 연속 처리
		System.out.println("values() => Collection => toArray() 사용 : Object[] => for 문 사용");
		Object[] array = hmap.values().toArray();
		// for 문, for each 문 둘 다 사용 가능함
		for(int i = 0; i < array.length; i++) {
			System.out.println(array[i]);
		}
		
		// 해결방법 4 : 키와 값 한쌍(entry, 엔트리라고 함)을 Set 으로 바꿈 : entrySet()  사용 
		// => 엔트리에 대한 목록 만들기 함 : iterator() => 목록 연속 처리
		// 엔트리 : Mpa.Entry 타입을 사용함 (Entry 는 Map 의 내부(Inner, Nested) 클래스임)
		// 내부 클래스 표현법 : 외부클래스명.내부클래스명		
		System.out.println("entrySet() => 엔트리들을 Set 으로 바꿈 => iterator() => 엔트리 목록 만듦 ---");
		Set entries = hmap.entrySet();
		Iterator entryIter = entries.iterator();
		while(entryIter.hasNext()) {
			Object obj = entryIter.next(); // 다형성 : 부모 타입은 부모 것 밖에 사용 못 함
			// 후손의 멤버를 사용하려면, 후손 타입으로 형변환 필요함 : down casting
			Map.Entry entry = (Map.Entry)obj;
			System.out.println(entry.getKey() + "=" + entry.getValue());
		}
		
	} // testHashMap()
	
	public void testHashMap2() {
		// Map 에 저장된 객체들을 연속으로 처리하는 메서드는 제공이 안 됨
		HashMap hmap = new HashMap();
		
		// 5개의 객체를 맵에 저장 처리함
		// key 는 1 ~ 100 사이의 임의의 정수 객체 : 랜덤 처리
		// 값은 랜덤 값으로 실수 객체 
		for(int count = 1; count < 6; count++) {
			Integer key = new Random().nextInt(100) + 1 ; // auto boxing
			Double value = Math.random(); // auto boxing
			hmap.put(key, value);
		}
		System.out.println(hmap);
		System.out.println("size : " + hmap.size());
		
		// 1. keySet() 사용 : 키 = 값 출력
		System.out.println("\nkeySet() -------------------------------");
		Iterator keyIter = hmap.keySet().iterator();
		while(keyIter.hasNext()	) {
			Object key = keyIter.next();
			System.out.println(key + "=" + hmap.get(key));
		}
		
		// 2. entrySet() 샤용 : 키 = 값 출력
		System.out.println("\nentrySet() ----------------------------");
		Iterator entryIter = hmap.entrySet().iterator();
		while(entryIter.hasNext()) {
			Map.Entry entry = (Map.Entry)entryIter.next();
			System.out.println(entry.getKey() + "=" + entry.getValue());
		}
		
		// 3. values() 사용 : 값 출력
		System.out.println("\nvalues() ------------------------------");
		Collection values = hmap.values();
		for(Object value : values) {
			System.out.println(value);
		}
		
		
		// 4. values() => toArray() : Object[] : 값 출력
		System.out.println("\ntoArray() ----------------------------");
		Object[] array = hmap.values().toArray();
		for(Object value : array) {
			System.out.println(value);
		}
		
	} // testHashMap2()
	
	public void testTreeMap() {
		//TreeMap : key 에 대한 오름차순 정렬 기능이 내장된 클래스임.
		//주의사항 : 키가 한 가지 타입으로 저장되어 있어야 함.
		HashMap hmap = new HashMap();
		
		// 5개의 객체를 맵에 저장 처리함
		// key 는 1 ~ 100 사이의 임의의 정수 객체 : 랜덤 처리
		// 값은 랜덤 값으로 실수 객체 
		for(int count = 1; count < 6; count++) {
			Integer key = new Random().nextInt(100) + 1 ; // auto boxing
			Double value = Math.random(); // auto boxing
			hmap.put(key, value);
		}
		
		System.out.println(hmap);
		
		TreeMap tmap = new TreeMap(hmap); // key 에 대해 자동 오름차순정렬 되면서 저장됨
		System.out.println("Ascending --------------------------------");
		System.out.println(tmap);
		
		// 키에 대한 내림차순정렬이 필요하면
		Map tmap2 = tmap.descendingMap();
		System.out.println("Descending ----------------------------");
		System.out.println(tmap2);
	}
	
}




















