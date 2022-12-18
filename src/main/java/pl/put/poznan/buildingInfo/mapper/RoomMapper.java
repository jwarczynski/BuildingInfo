package pl.put.poznan.buildingInfo.mapper;

import lombok.experimental.UtilityClass;
import pl.put.poznan.buildingInfo.dto.RoomRequest;
import pl.put.poznan.buildingInfo.logic.locations.Building;
import pl.put.poznan.buildingInfo.logic.locations.Room;

@UtilityClass
public class RoomMapper {
    Room toModel(RoomRequest requestRoom) {

        return Room.builder().id(requestRoom.getRoomId()).name(requestRoom.getName()).area(requestRoom.getArea())
                .cube(requestRoom.getCube()).lightPower(requestRoom.getLight()).heating(requestRoom.getHeating()).build();
    }


}
