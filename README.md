# 프로젝트 이름

> 스케줄 관리 API

### 1) 일정 만들기

- **Method**: `POST`
- URL: `/todos`
- 설명:일정 생성
- **request 예시**:
  ```json
  {
    "id": 1,
   "writer": "작성자명"
    "todo": "할일",
    "date": "오늘날짜",
    "createdAt": "YYYY-MM-DD HH-MM-SS"
  }

### 2) 일정 단일 조회

- **Method**: `GET`
- URL: `/todos/{id}`
- 설명:특정 일정 조회
- **reponse 예시**:

    ```json
   {
    "id":1,
    "writer": "작성자명",
    "todo":"할일",
    "date": "오늘날짜", 
    "create": "YYYY-MM-DD HH-MM-SS"
    }

### 3) 일정 전체 조회

- **Method**: `GET`
- URL: `/todos`
  - 설명:전체 일정 조회
      - **reponse 예시**:

          ```json
         {
            [
              {
                  "id": 1,
                  "todo": "할일1",
                  "writer": "작성자명",
                  "date": "오늘날짜",
                  "createdAt": "YYYY-MM-DD HH-MM-SS"
              },
              {
                  "id": 2,
                  "writer": "작성자명2",
                  "todo": "할일2",
                  "data": "오늘날짜",
                  "createdAt": "YYYY-MM-DD HH-MM-SS"
              },
              {
                  "id": 3,
                  "writer": "작성자명3",
                  "todo": "할일3",
                  "data": "오늘날짜",
                  "createdAt": "YYYY-MM-DD HH-MM-SS"
              },
            ....
            ]
          }

### 4) 일정 수정

- **Method**: `PUT`
- URL: `/todos/{id}`
- 설명:일정 수정
- **reponse 예시**:

    ```json
   {
    "id":1,
    "todo":"수정할 내용",
    "date": "YYYY-MM-DD",
    "create": "YYYY-MM-DD HH-MM-SS"
    "update": "YYYY-MM-DD HH-MM-SS"
    "writer": "수정할 이름",
    "message":"일정이 수정되었습니다."
    }

### 5) 일정 삭제

- **Method**: `DELETE`
- URL: `/todos/{id}`
- 설명:일정 삭제
- **reponse 예시**:

    ```json
   {
    "msg":"일정이 삭제되었습니다."
    }

### 1) 유저 생성

- **Method**: `POST`
- URL: `/users`
- 설명:유저 생성
- **request 예시**:
  ```json
  {
    "id": 1,
   "username": "User"
   "createdAt" "YYYY-MM-DD HH-MM-SS"
   "updateAt": "YYYY-MM-DD HH-MM-SS"
  }

### 2) 유저 단일 조회

- **Method**: `GET`
- URL: `/users/{id}`
- 설명:특정 유저 조회
- **reponse 예시**:

    ```json
   {
    "id":1,
   "username": "User"
   "createdAt" "YYYY-MM-DD HH-MM-SS"
   "updateAt": "YYYY-MM-DD HH-MM-SS"
    }

### 3) 유저 전체 조회

- **Method**: `GET`
  - URL: `/users`
    - 설명:전체 유저 조회
      - **reponse 예시**:

          ```json
         {
            [
              {
              "id":1,
              "username": "User1"
              "createdAt" "YYYY-MM-DD HH-MM-SS"
              "updateAt": "YYYY-MM-DD HH-MM-SS"
              },
              {
              "id":2,
              "username": "User2"
              "createdAt" "YYYY-MM-DD HH-MM-SS"
              "updateAt": "YYYY-MM-DD HH-MM-SS"
              },
              {
              "id":3,
              "username": "User3"
              "createdAt" "YYYY-MM-DD HH-MM-SS"
              "updateAt": "YYYY-MM-DD HH-MM-SS"
              },
            ....
            ]
          }

### 4) 유저 수정

- **Method**: `PUT`
- URL: `/todos/{id}`
- 설명:일정 수정
- **reponse 예시**:

    ```json
   {
    "id":1,
    "username":"수정할 유저 이름",
    "createAt": "YYYY-MM-DD HH-MM-SS"
    "updateAt": "YYYY-MM-DD HH-MM-SS"
    "message":"일정이 수정되었습니다."
    }

### 5) 유저 삭제

- **Method**: `DELETE`
- URL: `/todos/{id}`
- 설명:일정 삭제
- **reponse 예시**:

    ```json
   {
    "msg":"유저가 삭제되었습니다."
    }


### ERD

![img.png](img.png)
