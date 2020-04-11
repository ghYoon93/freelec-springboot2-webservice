package com.yghee.book.springboot.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;

/* DB 레이어 접근자 */
public interface PostsRepository extends JpaRepository<Posts, Long> {

}
