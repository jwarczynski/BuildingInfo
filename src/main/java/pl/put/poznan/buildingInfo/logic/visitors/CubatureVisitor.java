package pl.put.poznan.buildingInfo.logic.visitors;

import pl.put.poznan.buildingInfo.logic.locations.Building;
import pl.put.poznan.buildingInfo.logic.locations.Floor;
import pl.put.poznan.buildingInfo.logic.locations.Room;

public class CubatureVisitor implements Visitor{
    @Override
    public Float visitRoom(Room room) {
        return room.getVolume();
    }

    @Override
    public Float visitFloor(Floor floor) {
        Float volume = 0f;
        for (Room room : floor.getRooms()) {
            volume += visitRoom(room);
        }
        return volume;
    }

    @Override
    public Float visitBuilding(Building building) {
        Float volume = 0f;
        for (Floor floor : building.getFloors()) {
            volume += visitFloor(floor);
        }
        return volume;
    }
}
