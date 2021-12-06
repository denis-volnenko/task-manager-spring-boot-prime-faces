package school.volnenko.tm.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public final class FailDto extends ResultDto {

    public FailDto() {
        setSuccess(false);
        setMessage("");
    }

}
