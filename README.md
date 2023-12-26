# 학습 관리 시스템(Learning Management System)
## 진행 방법
* 학습 관리 시스템의 수강신청 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.

## 온라인 코드 리뷰 과정
* [텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/next-step/nextstep-docs/tree/master/codereview)

----

## Step 1
### Requirements

- [x] 질문 데이터 삭제가 아닌 데이터의 상태를 삭제 상태(deleted - boolean type)로 변경한다.(soft delete)
- [x] 로그인 사용자와 질문한 사람이 같은 경우 삭제 가능하다.
- [x] 답변이 없는 경우 삭제 가능하다.
- [x] 질문자와 답변 글의 모든 답변자가 같은 경우 삭제가 가능하다.
- [x] 질문을 삭제할 때 답변 또한 삭제해야 하며, 답변의 삭제 또한 삭제 상태(deleted)를 변경한다.
- [x] 질문자와 답변자가 다른 경우 답변을 삭제할 수 없다.
- [x] 질문과 답변 삭제 이력에 대한 정보를 DeleteHistory를 활용해 남긴다.

### Refactoring Requirements

- [x] nextstep.qna.service.QnaService의 deleteQuestion()에 섞여있는 여러 책임들을 다른 도메인 모델 객체에 분할해야한다.
  - [x] TDD로 구현해야한다.
  - [x] deleteQuestion()의 단위 테스트는 로직 이동 후에도 항상 통과해야한다.

----

## Step 2
### Requirements

- [x] 과정(Course)는 기수 단위로 운영된다.
  - [x] 과정에는 복수의 강의(Session)를 가진다.
    - [x] 강의는 시작일과 종료일을 가진다.
    - [x] 강의는 강의 커버 이미지 정보를 가진다.
      - [x] 이미지의 크기는 1mb 이하여야 한다.
      - [x] 이미지의 확장자는 gif, jpg(jpeg 포함), png, svg만 허용한다.
      - [x] 이미지의 너비(width)는 300 px, 높이는(height) 200px 이상이여야 한다.
      - [x] 이미지의 width와 height의 비율은 3:2이여야 한다.
    - [x] 강의는 무료 강의와 유료 강의로 나뉜다.
      - [x] 무료 강의는 최대 수강 인원 제한이 없다.
      - [x] 유료 강의는 최대 수강 인원 제한을 초과할 수 없다.
      - [x] 유료 강의는 수강생이 결재한 금액과 수강료가 일치할 때 수강신청이 가능하다.
    - [x] 강의 상태는 준비중, 모집중, 종료 3가지 상태만 가진다.
    - [x] 강의 수강신청은 강의 상태가 모집중 일때만 가능하다.
    - [x] 유료 강의의 경우 결재는 완료한 것으로 가정한다.
      - [x] 결재를 완료한 결재 정보는 payments 모듈을 통해 관리되며 결재 정보는 Payments 객체에 담겨 반환된다.

----

## Step 3
### Requirements

- [x] Step2에서 구현한 도메인 모델을 DB 테이블과 매핑한다.
  - [x] Course 데이터를 저장한다.
  - [x] Session 테이블을 만든다.
    - [x] Session 데이터를 저장한다.
  - [x] Enrollment 테이블을 만든다.
    - [x] Enrollment 데이터를 저장한다.

