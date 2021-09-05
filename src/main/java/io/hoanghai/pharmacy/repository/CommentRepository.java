package io.hoanghai.pharmacy.repository;

import io.hoanghai.pharmacy.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("commentRepository")
public interface CommentRepository extends JpaRepository<Comment, Integer> {
}
