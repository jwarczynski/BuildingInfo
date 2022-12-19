package pl.put.poznan.buildingInfo.logic.visitors;

import pl.put.poznan.buildingInfo.logic.locations.Building;
import pl.put.poznan.buildingInfo.logic.locations.Floor;
import pl.put.poznan.buildingInfo.logic.locations.Room;

public class LightVisitor implements Visitor{
    @Override
    public Float visitRoom(Room room) {
        return room.getLightPower() / room.getArea();
    }

    @Override
    public Float visitFloor(Floor floor) {
        Float lightPower = 0f;
        long roomCounter = floor.getRooms().stream().count();
        for (Room room : floor.getRooms()) {
            lightPower += visitRoom(room);
        }

        float meanLightPower = lightPower / roomCounter;
        return meanLightPower;
    }

    @Override
    public Float visitBuilding(Building building) {
        Float lightPower = 0f;
        long floorCounter = building.getFloors().stream().count();

        for (Floor floor : building.getFloors()) {
            lightPower += visitFloor(floor);
        }

        float meanLightPower = lightPower / floorCounter;
        return meanLightPower;
    }

}
