# Board-Server
대용량 트래픽 게시판 프로젝트

---
# 목적
- 대용량 트래픽을 고려한 어플리케이션 개발 (초당 1000 tps 이상의 게시글 검색 API)
- 객체지향과 디자인 패턴을 적용 및 가독성을 고려한 코드 작성 방법 공유
- 현업 단계에서 코드리뷰를 어떻게 하는지 경험 공유 공유
- 모니터링 및 트러블 슈팅 전략 공유
- 젠킨스 툴로 배포 자동화를 통해 개발 생산성 높이기

---
# 사용기술
- JAVA 17, Spring Boot 2.3, MyBatis, MySQL, Redis

---
# 성능테스트 툴
- Python 3.9, Locust
- ****[성능테스트 툴](https://github.com/ccommit-dev/Board-Server-Locust)****

- 사전준비
  1. 게시글 카테고리 10개 생성
  2. 게시글 10만개 생성
  3. 게시글 검색 API 각 시나리오 테스트별 진행

- 목표: 서버의 지표 CPU, RAM, DISK 와 목표 TPS 확인

- 시나리오
  1. STRESS 테스트
      - 500명의 동시 사용자가 초당 50번을 호출하여 분당(5분) 사용자를 50씩 늘려 서버의 지표를 확인
  
  2. Endurance 테스트
      - 100명의 동시 사용자가 초당 100번을 호출하였을때 10분동안 서버의 지표를 확인
    
  3. PEAK 테스트
      - 100명의 동시 사용자가 초당 50번씩 호출하다 1분에 1000명으로 사용자를 한번에 늘려 서버의 지표를 확인

---
# 기획
- 커뮤니티 사이트의 게시판을 구현함으로써 자유롭게 소통하는 및 정보 공유 사이트를 목표로 구현
- ****https://ovenapp.io/view/Pv1HR7ajNN47W6qWgKHjIro334XPQvBj/****

---
# 프로그램 주요 기능
- 회원
  - 가입, 탈퇴
  - 아이디 및 닉네임 중복체크
  - 비밀번호 암호화
  - 로그인, 로그아웃
- 게시판
  - 카테고리 관리
    - 추가, 삭제, 수정
  - 게시글 관리
    - 게시글 & 파일 추가, 삭제, 수정, 조회
    - 유저 정보, 게시글 제목, 게시글 내용 등
  - 게시글 검색 기능
    - 작성 유정 아이디
    - 게시글 제목, 게시글 내용 등을 통해 검색
    - 태크 작성 및 조회 기능
  - 댓글 작성 기능
- 어드민
  - 공지글 추가 기능

---
# 이슈별 실습 내용
![이슈별 실습 내용 drawio](https://github.com/Junbeeom/Board_Huge_Traffic_Handling/assets/103010985/4e29024d-539b-4696-b0e1-9b527b77c20d)

---
# ERD(Entity Relationship Diagram)
![image](https://github.com/Junbeeom/Board_Huge_Traffic_Handling/assets/103010985/dc330873-7d44-42db-991f-d4aa72d1e207)

---
# 시퀀스
- 게시글 등록 시퀀스
![패캠  게시글 등록 시퀀스](https://github.com/Junbeeom/Board_Huge_Traffic_Handling/assets/103010985/a274dbe5-3dc2-44b2-ada4-6e100d7d73af)

- 게시글 검색 시퀀스
![게시글 검색 시퀀스](https://github.com/Junbeeom/Board_Huge_Traffic_Handling/assets/103010985/46e9b579-2a86-4729-a549-6e6d510c7fd3)


---
# 아키텍처(요약)
![게시판 서버 아키텍처 drawio](https://github.com/Junbeeom/Board_Huge_Traffic_Handling/assets/103010985/254d653c-dee1-42c0-95e8-84b360e3e892)



