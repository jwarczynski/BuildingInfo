package pl.put.poznan.buildingInfo.logic.visitors;

import pl.put.poznan.buildingInfo.logic.locations.Building;
import pl.put.poznan.buildingInfo.logic.locations.Floor;
import pl.put.poznan.buildingInfo.logic.locations.Room;

public interface Visitor {
    Float visitRoom(Room room);
    Float visitFloor(Floor floor);
    Float visitBuilding(Building building);
}
