package teacher_management_system.exercise.service;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import teacher_management_system.exercise.dao.TeacherRepo;
import teacher_management_system.exercise.entity.Teacher;

import java.util.List;
import java.util.Optional;

@Service
public class TeacherService implements TeacherServiceInterface {

    private TeacherRepo repo;

    @Autowired
    public TeacherService(TeacherRepo repo) {
        this.repo = repo;
    }


    @Override
    public List<Teacher> findAll() {
        return repo.findAll();
    }

    @Override
    public Teacher findById(int id) {

        Optional<Teacher> result = repo.findById(id);

        Teacher teacher = null;

        if (result.isPresent()) {
            teacher = result.get();
        } else {
            throw new RuntimeException("The teacher with ID " + id + " does not exist.");
        }

        return teacher;
    }

    @Transactional
    @Override
    public Teacher update(Teacher teacher) {
        return repo.save(teacher);
    }

    @Transactional
    @Override
    public void deleteById(int id) {
        repo.deleteById(id);
    }
}
