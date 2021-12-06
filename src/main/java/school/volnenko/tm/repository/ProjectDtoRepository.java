package school.volnenko.tm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import school.volnenko.tm.dto.ProjectDto;

public interface ProjectDtoRepository extends JpaRepository<ProjectDto, String> {

}
