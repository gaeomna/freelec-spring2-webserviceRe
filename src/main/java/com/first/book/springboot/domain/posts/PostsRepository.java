package com.first.book.springboot.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PostsRepository extends JpaRepository<Posts, Long> {
    @Query("SELECT p FROM Posts p ORDER BY p.id DESC")
    List<Posts> findAllDesc();
}







/*Repository == 흔히 DAO
* JpaRepository<Entity클래스,PK타입> 상속하면 기본적인 CRUD 메소드가 자동으로 생성됨
* @Repository를 추가할 필요x ,Entity클래스와 기본 Entity Repository는 함께 위치. 둘은 아주 밀접하며, Entity클래스는
  기본 Repository 없이는 제대로 역할 수행x 나중에 프로젝트의 규모가 커져서 이동을 해야 할시 함께 움직여야 하므로 보통
  도메인 패키지에서 함께 관리함.
*
* */
