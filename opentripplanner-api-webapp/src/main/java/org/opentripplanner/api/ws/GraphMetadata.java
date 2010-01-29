package org.opentripplanner.api.ws;

import javax.xml.bind.annotation.XmlRootElement;

import org.opentripplanner.routing.core.Graph;
import org.opentripplanner.routing.core.Vertex;
import org.springframework.beans.factory.annotation.Autowired;

import com.vividsolutions.jts.geom.Envelope;

@XmlRootElement
public class GraphMetadata {

    /**
     * The bounding box of the graph, in decimal degrees.
     */
    private double minLatitude, minLongitude, maxLatitude, maxLongitude;

    public GraphMetadata() {
    }

    public GraphMetadata(Graph graph) {
        setGraph(graph);
    }

    @Autowired
    public void setGraph(Graph graph) {
        /* generate extents */
        Envelope env = new Envelope();
        for (Vertex v : graph.getVertices()) {
            env.expandToInclude(v.getCoordinate());
        }
        setMinLongitude(env.getMinX());
        setMaxLongitude(env.getMaxX());
        setMinLatitude(env.getMinY());
        setMaxLatitude(env.getMaxY());
    }

    public void setMinLatitude(double minLatitude) {
        this.minLatitude = minLatitude;
    }

    public double getMinLatitude() {
        return minLatitude;
    }

    public void setMaxLongitude(double maxLongitude) {
        this.maxLongitude = maxLongitude;
    }

    public double getMaxLongitude() {
        return maxLongitude;
    }

    public void setMinLongitude(double minLongitude) {
        this.minLongitude = minLongitude;
    }

    public double getMinLongitude() {
        return minLongitude;
    }

    public void setMaxLatitude(double maxLatitude) {
        this.maxLatitude = maxLatitude;
    }

    public double getMaxLatitude() {
        return maxLatitude;
    }
}