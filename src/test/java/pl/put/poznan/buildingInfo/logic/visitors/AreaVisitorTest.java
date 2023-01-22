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
class AreaVisitorTest {

    AreaVisitor areaVisitorUnderTest;
    @Spy
    AreaVisitor spyAreaVisitor;
    @Mock
    Room mockedRoom;
    @Mock
    Floor mockedFloor;
    @Mock
    Building mockedBuilding;


    @Test
    void visitRoom() {
        areaVisitorUnderTest = new AreaVisitor();
        when(mockedRoom.getArea()).thenReturn(10.f);

        assertEquals(10, areaVisitorUnderTest.visitRoom(mockedRoom));
        verify(mockedRoom, times(1)).getArea();
    }

    @Test
    void visitFloor() {
        when(mockedFloor.getRooms()).thenReturn(new HashSet<>(Arrays.asList(new Room(), new Room())));
        doReturn(1.f).when(spyAreaVisitor).visitRoom(any(Room.class));

        assertEquals(2, spyAreaVisitor.visitFloor(mockedFloor));
        verify(mockedFloor, times(1)).getRooms();
        verify(spyAreaVisitor, times(2)).visitRoom(any(Room.class));
    }

    @Test
    void visitBuilding() {
        when(mockedBuilding.getFloors()).thenReturn(new HashSet<>(Arrays.asList(new Floor(), new Floor())));
        doReturn(1.f).when(spyAreaVisitor).visitFloor(any(Floor.class));

        assertEquals(2, spyAreaVisitor.visitBuilding(mockedBuilding));
        verify(mockedBuilding, times(1)).getFloors();
        verify(spyAreaVisitor, times(2)).visitFloor(any(Floor.class));

    }
}