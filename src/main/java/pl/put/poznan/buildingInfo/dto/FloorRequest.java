package pl.put.poznan.buildingInfo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
public class FloorRequest {
    private int floorId;

    private String name;

    @JsonProperty(value = "locations")
    private Set<RoomRequest> rooms;

}
