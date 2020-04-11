package com.yghee.book.springboot.domain.posts;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter  // 6  클래스 내 모든 필드의 Getter 메소드 생성
@NoArgsConstructor  // 5 기본 생성자 추가
@Entity  // 1  테이블과 링크될 클래스 camelCase-> underscore_naming
public class Posts {

    @Id  // 2 해당 테이블의 PK 필드
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // 3 PK 생성 규칙 (auto_increment)
    private long id;

    @Column(length = 500, nullable = false)  // 4 테이블의 컬럼, 굳이 선언하지 않아도 되지만 기본 값 외 (길이, 타입) 등 옵션 변경 시 사용
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    private String author;

    @Builder  // 7 해당 클래스의 빌더 패턴 클래스 생성, 생성자 상단에 선언 시 생성자에 포함된 필드만 빌더에 포함
    public Posts(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public void update(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
