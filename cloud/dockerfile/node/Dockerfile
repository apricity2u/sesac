# 베이스이미지 지정
FROM node:lts

# 작업 폴더 설정
WORKDIR /app

# 이미지가 생성될 때 명령어를 수행함
COPY ./package.json ./
RUN npm install

# 호스트 파일 또는 폴더를 컨테이너로 복사
# [호스트 파일] [컨테이너 경로]
# COPY ./app.js /app.js

# # 컨테이너가 생성될 때 명령어를 수행함
# CMD ["node", "app.js"]

# 이미지 빌드
# docker build -t my-node . 

# 백그라운드 컨테이너 실행
# docker run -itd --name node-container my-node

# 터미널 진입
# docker exec -it node-container bash
