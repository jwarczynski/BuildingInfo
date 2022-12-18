package pl.put.poznan.buildingInfo.mapper;

import lombok.experimental.UtilityClass;
import pl.put.poznan.buildingInfo.dto.FloorRequest;
import pl.put.poznan.buildingInfo.dto.RoomRequest;
import pl.put.poznan.buildingInfo.logic.locations.Floor;
import pl.put.poznan.buildingInfo.logic.locations.Room;

import java.util.Set;
import java.util.stream.Collectors;

@UtilityClass
public class FloorMapper {

    Floor toModel(FloorRequest requestFloor) {
        Set<Room> rooms = requestFloor.getRooms().stream().map(RoomMapper::toModel).collect(Collectors.toSet());

        return Floor.builder().id(requestFloor.getFloorId()).name(requestFloor.getName()).rooms(rooms).build();
    }
}
