package pl.put.poznan.buildingInfo.logic.locations;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pl.put.poznan.buildingInfo.logic.visitors.AreaVisitor;
import pl.put.poznan.buildingInfo.logic.visitors.CubatureVisitor;
import pl.put.poznan.buildingInfo.logic.visitors.LightVisitor;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
class BuildingTest {

    private Building buildingUnderTest;
    @Mock
    private AreaVisitor areaVisitor;
    @Mock
    private LightVisitor lightVisitor;
    @Mock
    private CubatureVisitor cubatureVisitor;

    @BeforeEach
    void setUp() {
        buildingUnderTest = new Building();
    }

    @Test
    void acceptAllVisitorTypes() {
        buildingUnderTest.accept(areaVisitor);
        buildingUnderTest.accept(lightVisitor);
        buildingUnderTest.accept(cubatureVisitor);
    }

    @Test
    void shouldReturnCorrectArea() {
        when(areaVisitor.visitBuilding(buildingUnderTest)).thenReturn(5.f);
        assertEquals(5, buildingUnderTest.accept(areaVisitor));
    }

    @Test
    void shouldReturnCorrectLightPower() {
        when(lightVisitor.visitBuilding(buildingUnderTest)).thenReturn(5.f);
        assertEquals(5, buildingUnderTest.accept(lightVisitor));
    }

    @Test
    void shouldReturnCorrectCubature() {
        when(cubatureVisitor.visitBuilding(buildingUnderTest)).thenReturn(5.f);
        assertEquals(5, buildingUnderTest.accept(cubatureVisitor));
    }
}