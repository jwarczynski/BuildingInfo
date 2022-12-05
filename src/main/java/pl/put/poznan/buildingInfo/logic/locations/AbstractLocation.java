package pl.put.poznan.buildingInfo.logic.locations;

import jakarta.annotation.Nullable;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public abstract class AbstractLocation implements Visitable {

    protected int id;
    @Nullable
    protected String name;

    protected Float area;
    protected Float volume;
    protected Float lightPower;

    public AbstractLocation(int id, Float area, Float volume, Float lightPower) {
        this.id = id;
        this.area = area;
        this.volume = volume;
        this.lightPower = lightPower;
    }
}
