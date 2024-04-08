package teacher_management_system.exercise.service;

import java.util.List;
import teacher_management_system.exercise.entity.Teacher;

public interface TeacherServiceInterface {


    List<Teacher> findAll();

    Teacher findById(int id);

    Teacher update(Teacher teacher);

    void deleteById(int id);
}
