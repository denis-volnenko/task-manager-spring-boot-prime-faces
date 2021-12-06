package school.volnenko.tm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import school.volnenko.tm.model.Task;

public interface TaskRepository extends JpaRepository<Task, String> {

}
