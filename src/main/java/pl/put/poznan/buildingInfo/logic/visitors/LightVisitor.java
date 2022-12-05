package pl.put.poznan.buildingInfo.logic.visitors;

import pl.put.poznan.buildingInfo.logic.locations.Building;
import pl.put.poznan.buildingInfo.logic.locations.Floor;
import pl.put.poznan.buildingInfo.logic.locations.Room;

public class LightVisitor implements Visitor{
    @Override
    public Float visitRoom(Room room) {
        return room.getLightPower();
    }

    @Override
    public Float visitFloor(Floor floor) {
        Float lightPower = 0f;
        for (Room room : floor.getRooms()) {
            lightPower += visitRoom(room);
        }
        return lightPower;
    }

    @Override
    public Float visitBuilding(Building building) {
        Float lightPower = 0f;
        for (Floor floor : building.getFloors()) {
            lightPower += visitFloor(floor);
        }
        return lightPower;
    }
}
