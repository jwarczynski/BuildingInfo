package pl.put.poznan.buildingInfo.logic.visitors;

import pl.put.poznan.buildingInfo.logic.locations.Building;
import pl.put.poznan.buildingInfo.logic.locations.Floor;
import pl.put.poznan.buildingInfo.logic.locations.Room;

public class AreaVisitor implements Visitor {
    /**
     * This method calculate the area of the room passed as an argument
     *
     * @param room it is a location for which AreaVisitor is determining area
     * @return the area of the room object passed as an argument
     *
     * @author Jędrzej Warczyński
     */
    @Override
    public Float visitRoom(Room room) {
        return room.getArea();
    }

    @Override
    public Float visitFloor(Floor floor) {
        Float area = 0f;
        for (Room room : floor.getRooms()) {
            area += visitRoom(room);
        }
        return area;
    }

    @Override
    public Float visitBuilding(Building building) {
        Float area = 0f;
        for (Floor floor : building.getFloors()) {
            area += visitFloor(floor);
        }
        return area;
    }
}
