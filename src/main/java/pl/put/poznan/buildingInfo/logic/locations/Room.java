package pl.put.poznan.buildingInfo.logic.locations;

import lombok.*;
import pl.put.poznan.buildingInfo.logic.visitors.Visitor;

@Getter
@Setter
public class Room extends AbstractLocation {

    public Room(int id, Float area, Float volume, Float lightPower) {
        super(id, area, volume, lightPower);
    }
    
    @Override
    public Float accept(Visitor visitor) {
        return visitor.visitRoom(this);
    }


}
