package pl.put.poznan.buildingInfo.logic.visitors;

import pl.put.poznan.buildingInfo.logic.locations.Building;
import pl.put.poznan.buildingInfo.logic.locations.Floor;
import pl.put.poznan.buildingInfo.logic.locations.Room;

/**
* Calculates area for specific part or whole building
* @author Jakub Żytliński
* @version 2.0
*/

public class AreaVisitor implements Visitor {
    /**
     * This method calculates the area of the room passed as an argument
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
     /**
     * This method calculates the area of the floor passed as an argument
     *
     * @param floor it is a location for which AreaVisitor is determining area
     * @return the area of the floor object passed as an argument
     *
     */
    @Override
    public Float visitFloor(Floor floor) {
        Float area = 0f;
        for (Room room : floor.getRooms()) {
            area += visitRoom(room);
        }
        return area;
    }
     /**
     * This method calculates the area of the building passed as an argument
     *
     * @param building it is a location for which AreaVisitor is determining area
     * @return the area of the building object passed as an argument
     *
     */
    @Override
    public Float visitBuilding(Building building) {
        Float area = 0f;
        for (Floor floor : building.getFloors()) {
            area += visitFloor(floor);
        }
        return area;
    }
}
