package teacher_management_system.exercise.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import teacher_management_system.exercise.entity.Teacher;

public interface TeacherRepo extends JpaRepository<Teacher, Integer> {
}
