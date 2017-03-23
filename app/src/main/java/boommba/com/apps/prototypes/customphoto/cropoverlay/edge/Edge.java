package boommba.com.apps.prototypes.customphoto.cropoverlay.edge;

/**
 * Enum representing an edge in the crop window.
 */
public enum Edge {

    LEFT,
    TOP,
    RIGHT,
    BOTTOM;


    private float mCoordinate;


    /**
     * Gets the current width of the crop window.
     */
    public static float getWidth() {
        return Edge.RIGHT.getCoordinate() - Edge.LEFT.getCoordinate();
    }

    /**
     * Gets the current height of the crop window.
     */
    public static float getHeight() {
        return Edge.BOTTOM.getCoordinate() - Edge.TOP.getCoordinate();
    }

    /**
     * Gets the coordinate of the Edge
     *
     * @return the Edge coordinate (x-coordinate for LEFT and RIGHT Edges and
     * the y-coordinate for TOP and BOTTOM edges)
     */
    public float getCoordinate() {
        return mCoordinate;
    }

    /**
     * Sets the coordinate of the Edge. The coordinate will represent the
     * x-coordinate for LEFT and RIGHT Edges and the y-coordinate for TOP and
     * BOTTOM edges.
     *
     * @param coordinate the position of the edge
     */
    public void setCoordinate(float coordinate) {
        mCoordinate = coordinate;
    }

}
