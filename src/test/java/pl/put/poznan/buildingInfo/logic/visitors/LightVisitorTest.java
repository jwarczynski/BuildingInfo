package pl.put.poznan.buildingInfo.logic.visitors;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import pl.put.poznan.buildingInfo.logic.locations.Building;
import pl.put.poznan.buildingInfo.logic.locations.Floor;
import pl.put.poznan.buildingInfo.logic.locations.Room;

import java.util.Arrays;
import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
class LightVisitorTest {

    LightVisitor lightVisitorUnderTest;
    @Spy
    LightVisitor spyLightVisitor;
    @Mock
    Room mockedRoom;
    @Mock
    Floor mockedFloor;
    @Mock
    Building mockedBuilding;


    @Test
    void visitRoom() {
        lightVisitorUnderTest = new LightVisitor();
        when(mockedRoom.getLightPower()).thenReturn(5.f);
        when(mockedRoom.getArea()).thenReturn(5.f);
        assertEquals(1, lightVisitorUnderTest.visitRoom(mockedRoom));
        verify(mockedRoom, times(1)).getLightPower();
        verify(mockedRoom, times(1)).getArea();
    }

    @Test
    void visitFloor() {
        when(mockedFloor.getRooms()).thenReturn(new HashSet<>(Arrays.asList(new Room(), new Room())));
        doReturn(1.f).when(spyLightVisitor).visitRoom(any(Room.class));

        assertEquals(1, spyLightVisitor.visitFloor(mockedFloor));
        verify(mockedFloor, times(2)).getRooms();
        verify(spyLightVisitor, times(2)).visitRoom(any(Room.class));
    }

    @Test
    void visitBuilding() {
        when(mockedBuilding.getFloors()).thenReturn(new HashSet<>(Arrays.asList(new Floor(), new Floor())));
        doReturn(1.f).when(spyLightVisitor).visitFloor(any(Floor.class));

        assertEquals(1, spyLightVisitor.visitBuilding(mockedBuilding));
        verify(mockedBuilding, times(2)).getFloors();
        verify(spyLightVisitor, times(2)).visitFloor(any(Floor.class));
    }
}