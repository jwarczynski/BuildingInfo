package pl.put.poznan.buildingInfo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
public class BuildingRequest {
    private int buildingId;
    private String name;
    @JsonProperty(value = "locations")
    private Set<FloorRequest> floors;
}
