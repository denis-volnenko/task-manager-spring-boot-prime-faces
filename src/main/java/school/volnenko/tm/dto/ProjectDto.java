package school.volnenko.tm.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import school.volnenko.tm.enumerated.Status;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "app_project")
@JsonIgnoreProperties(ignoreUnknown = true)
public final class ProjectDto {

    @Id
    private String id = UUID.randomUUID().toString();

    @Column
    private String name = "";

    @Column
    private String description = "";

    private Date dateFinish;

    private Date dateStart;

    @Enumerated(value = EnumType.STRING)
    private Status status = Status.NOT_STARTED;

}
