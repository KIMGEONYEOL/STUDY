package org.myweb.first.notice.model.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.myweb.first.board.jpa.entity.BoardEntity;
import org.myweb.first.board.model.dto.Board;
import org.myweb.first.common.Search;
import org.myweb.first.notice.jpa.entity.NoticeEntity;
import org.myweb.first.notice.jpa.repository.NoticeRepository;
import org.myweb.first.notice.model.dto.Notice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j	//Logger 객체 선언임, 별도의 로그객체 선언 필요없음, 제공되는 레퍼런스는 log 임
@Service
@RequiredArgsConstructor
@Transactional
public class NoticeService {
	//JPA 가 제공하는 기본 메소드 사용을 하려면
	private final NoticeRepository noticeRepository;

	//ArrayList<Notice> 리턴하는 메소드들이 사용하는 중복 코드는 별도의 메소드로 작성함
	private ArrayList<Notice> toList(Page<NoticeEntity> entityList) {
		//컨트롤러로 리턴할 ArrayList<Notice> 타입으로 변경 처리 필요함
		ArrayList<Notice> list = new ArrayList<>();
		//Page 안의 NoticeEntity 를 Notice 로 변환해서 리스트에 추가 처리함
		for(NoticeEntity entity : entityList){
			list.add(entity.toDto());
		}
		return list;
	}

	public Notice selectLast() {
		return null;
	}




	@Transactional
	public int insertNotice(Notice notice) {
		// 추가한 메소드 사용 : 현재 마지막 게시글번호 조회용
		notice.setNoticeNo(noticeRepository.findLastNoticeNo() + 1);
		log.info("NoticeService notice insert : " + notice.getNoticeNo());
		//save(Entity) : Entity 가 반환되는 메소드 사용, 실패하면 에러 발생임
		//jpa 가 제공, insert 문, update 문 처리
		log.info(notice.toString());
		try {
			noticeRepository.save(notice.toEntity());
			return 1;
		}catch(Exception e){
			log.info(e.getMessage());
			return 0;
		}
	}


	public ArrayList<Notice> selectTop3() {
		//jpa 가 제공하는 메소드 사용한다면
		//최근 공지글 3개 조회이므로, 공지번호 기준 내림차순정렬해서 상위 3개 추출함
		//findAll(Sort.by(Sort.Direction.DESC, "noticeNo")) : List<NoticeEntity>
		List<NoticeEntity> entityList = noticeRepository.findAll(Sort.by(Sort.Direction.DESC, "noticeNo"));
		//select * from notice order by noticeno desc : 쿼리문 실행될 것임
		//3개만 추출함
		ArrayList<Notice> list = new ArrayList<>();
		for(int index = 0; index < 3; index++){
			list.add(entityList.get(index).toDto());
		}
		return list;
	}


	public Notice selectNotice(int noticeNo) {
		//jpa 제공 메소드 사용
		//findById(id) : Optional<T>
		//엔티티에 등록된 id 를 사용해서 entity 조회함
		Optional<NoticeEntity> entityOptional = noticeRepository.findById(noticeNo);
		return entityOptional.get().toDto();
	}


	public int updateAddReadCount(int noticeNo) {
		return 0;
	}


	/*public ArrayList<Notice> selectList(Pageable pageable) {
		//jpa 제공 메소드 사용
		//findAll() : Entity 반환됨 => select * from notice 쿼리 자동 실행됨
		//page 단위로 list 조회를 하고자 한다면, 스프링이 제공하는 Pageable 객체를 사용함
		//findAll(Pageable 변수) : Page<NoticeEntity> 반환됨 => 한 페이지의 리스트 정보가 들어있음
		Page<NoticeEntity> entityList = noticeRepository.findAll(pageable);
		//컨트롤러로 리턴할 ArrayList<Notice> 타입으로 변경 처리 필요함
		ArrayList<Notice> list = new ArrayList<>();
		//Page 안의 NoticeEntity 를 Notice 로 변환해서 리스트에 추가 처리함
		for(NoticeEntity entity : entityList){
			list.add(entity.toDto());
		}
		return list;
	}*/

	//별도로 작성된 toList() 메소드 이용한 코드로 변경하면
	public ArrayList<Notice> selectList(Pageable pageable) {
		//jpa 가 제공 : findAll(Pageable) : Page<Enntity>
		Page<NoticeEntity> page = noticeRepository.findAll(pageable);
		ArrayList<Notice> list = new ArrayList<>();
		for(NoticeEntity entity : page){
			list.add(entity.toDto());
		}
		return list;	}


	public int selectListCount() {
		//jpa 가 제공하는 메소드 사용
		//count() : long
		//테이블의 전체 행 수를 반환함
		return (int)noticeRepository.count();
	}

	@Transactional
	public int deleteNotice(int noticeNo) {
		//jpa 제공하는 메소드 사용
		//deleteById(pk로 지정된 컬럼에 대한 property): void => 실패하면 에러, 성공하면 리턴값없음
		try {
			noticeRepository.deleteById(noticeNo);
			return 1;
		}catch(Exception e){
			log.info(e.getMessage());
			return 0;
		}
	}

	@Transactional
	public int updateNotice(Notice notice) {
		//save(Entity) : Entity 가 반환되는 메소드 사용, 실패하면 에러 발생하고 null 리턴
		//jpa 가 제공, insert 문, update 문 처리
		try {
			noticeRepository.save(notice.toEntity());
			return 1;
		}catch(Exception e){
			log.info(e.getMessage());
			return 0;
		}
	}

	//검색용 메소드 --------------------------------------------------------

	public ArrayList<Notice> selectSearchTitle(String keyword, Pageable pageable) {
		// jpa 가 제공하는 findAll(pageable) 메소드가 있으나, 키워드도 함께 전달되는 메소드는 없음
		// 추가해서 사용함 : BoardRepository 인터페이스에 메소드 추가함
		Page<NoticeEntity> page = noticeRepository.findSearchTitle(keyword, pageable);
		ArrayList<Notice> list = new ArrayList<>();
		for(NoticeEntity entity : page){
			list.add(entity.toDto());
		}
		return list;
	}


	public int selectSearchTitleCount(String keyword) {
		return noticeRepository.countSearchTitle(keyword).intValue();
	}


	public ArrayList<Notice> selectSearchContent(String keyword, Pageable pageable) {
		// jpa 가 제공하는 findAll(pageable) 메소드가 있으나, 키워드도 함께 전달되는 메소드는 없음
		// 추가해서 사용함 : BoardRepository 인터페이스에 메소드 추가함
		Page<NoticeEntity> page = noticeRepository.findSearchContent(keyword, pageable);
		ArrayList<Notice> list = new ArrayList<>();
		for(NoticeEntity entity : page){
			list.add(entity.toDto());
		}
		return list;
	}


	public int selectSearchContentCount(String keyword) {
		return noticeRepository.countSearchContent(keyword).intValue();
	}


	public ArrayList<Notice> selectSearchDate(Search search, Pageable pageable) {
		// jpa 가 제공하는 findAll(pageable) 메소드가 있으나, 키워드도 함께 전달되는 메소드는 없음
		// 추가해서 사용함 : BoardRepository 인터페이스에 메소드 추가함
		Page<NoticeEntity> page = noticeRepository.findSearchDate(search.getBegin(), search.getEnd(), pageable);
		ArrayList<Notice> list = new ArrayList<>();
		for(NoticeEntity entity : page){
			list.add(entity.toDto());
		}
		return list;
	}


	public int selectSearchDateCount(Search search) {
		return noticeRepository.countSearchDate(search.getBegin(), search.getEnd()).intValue();
	}
}





