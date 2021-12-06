package school.volnenko.tm.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public final class SuccessDto extends ResultDto {

    public SuccessDto() {
        setSuccess(true);
        setMessage("");
    }

}
