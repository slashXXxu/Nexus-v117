
package server.maps;

public enum SavedLocationType {

    FREE_MARKET(0),
    MULUNG_TC(1),
    WORLDTOUR(2),
    FLORINA(3),
    FISHING(4),
    RICHIE(5),
    DONGDONGCHIANG(6),
    EVENT(7),
    AMORIA(8),
    CHRISTMAS(9),
    ARDENTMILL(10),
    PINK_ZAKUM(11);
    private int index;

    SavedLocationType(int index) {
        this.index = index;
    }

    public static SavedLocationType fromString(String Str) {
        return valueOf(Str);
    }

    public int getValue() {
        return index;
    }
}