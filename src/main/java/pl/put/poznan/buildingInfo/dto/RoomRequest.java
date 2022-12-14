package pl.put.poznan.buildingInfo.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RoomRequest {

    private int roomId;
    private String name;

    private float area;
    private float cube;
    private float heating;
    private float light;

}
