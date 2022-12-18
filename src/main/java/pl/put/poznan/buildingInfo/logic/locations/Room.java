package pl.put.poznan.buildingInfo.logic.locations;

import lombok.*;
import lombok.experimental.SuperBuilder;
import pl.put.poznan.buildingInfo.logic.visitors.Visitor;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class Room extends AbstractLocation {
    protected Float area;
    protected Float cube;
    protected Float lightPower;

    protected Float heating;
    public Room(int id, String name,Float area, Float cube, Float lightPower, Float heating) {
        super(id, name);
        this.area = area;
        this.cube = cube;
        this.lightPower = lightPower;
        this.heating = heating;
    }
    
    @Override
    public Float accept(Visitor visitor) {
        return visitor.visitRoom(this);
    }


}
