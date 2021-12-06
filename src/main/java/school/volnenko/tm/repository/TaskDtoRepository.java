package school.volnenko.tm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import school.volnenko.tm.dto.TaskDto;

public interface TaskDtoRepository extends JpaRepository<TaskDto, String> {

}
