package pl.put.poznan.buildingInfo.mapper;

import lombok.experimental.UtilityClass;
import pl.put.poznan.buildingInfo.dto.BuildingRequest;
import pl.put.poznan.buildingInfo.dto.FloorRequest;
import pl.put.poznan.buildingInfo.logic.locations.Building;
import pl.put.poznan.buildingInfo.logic.locations.Floor;
import pl.put.poznan.buildingInfo.logic.locations.Room;

import java.util.Set;
import java.util.stream.Collectors;

@UtilityClass
public class BuildingMapper {

    public Building toModel(BuildingRequest requestBuilding) {
        Set<Floor> floors = requestBuilding.getFloors().stream().map(FloorMapper::toModel).collect(Collectors.toSet());

        return Building.builder().id(requestBuilding.getBuildingId()).name(requestBuilding.getName()).floors(floors).build();
    }
}
