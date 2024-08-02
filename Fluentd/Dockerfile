# fluentd의 공식 이미지(debian 기반)를 사용합니다.
FROM fluent/fluentd:edge-debian

# apt 명령어를 사용하기 위해 root 계정을 사용합니다.
USER root

# RUN 명령어를 사용하여 필요한 빌드 도구와 플러그인을 설치합니다.
# buildDeps는 나중에 제거될 패키지 목록을 정의합니다.
RUN buildDeps="sudo make gcc g++ libc-dev" \
 # 패키지 목록을 업데이트하고 buildDeps에 정의된 패키지를 설치합니다.
 && apt-get update \
 && apt-get install -y --no-install-recommends $buildDeps \
 # Elasticsearch 플러그인을 설치합니다.
 && sudo gem install fluent-plugin-elasticsearch \
 # gem 소스를 모두 정리합니다.
 && sudo gem sources --clear-all \
 # 설치된 buildDeps 패키지를 자동으로 제거합니다.
 && SUDO_FORCE_REMOVE=yes \
    apt-get purge -y --auto-remove \
                  -o APT::AutoRemove::RecommendsImportant=false \
                  $buildDeps \
 # apt-get으로 생성된 임시 파일을 제거합니다.
 && rm -rf /var/lib/apt/lists/* \
