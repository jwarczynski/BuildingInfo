package pl.put.poznan.buildingInfo.logic.locations;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.put.poznan.buildingInfo.logic.visitors.Visitor;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
public class Floor extends AbstractLocation {

    Set<Room> rooms;
    public Floor(Set<Room> rooms) {
        this.rooms = rooms;
    }
    @Override
    public Float accept(Visitor visitor) {
        return visitor.visitFloor(this);
    }

}
