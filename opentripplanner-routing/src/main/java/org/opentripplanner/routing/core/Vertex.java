/* This program is free software: you can redistribute it and/or
 modify it under the terms of the GNU Lesser General Public License
 as published by the Free Software Foundation, either version 3 of
 the License, or (at your option) any later version.

 This program is distributed in the hope that it will be useful,
 but WITHOUT ANY WARRANTY; without even the implied warranty of
 MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 GNU General Public License for more details.

 You should have received a copy of the GNU General Public License
 along with this program.  If not, see <http://www.gnu.org/licenses/>. */

package org.opentripplanner.routing.core;

import org.onebusaway.gtfs.model.AgencyAndId;

import com.vividsolutions.jts.geom.Coordinate;

public interface Vertex extends Cloneable {

    /**
     * Every vertex has a label which is globally unique
     */
    public String getLabel();

    /**
     * For vertices that represent stops, the passenger-facing stop ID (for systems like TriMet that
     * have this feature).
     */
    public AgencyAndId getStopId();

    /**
     * Distance in meters to the coordinate
     */
    public double distance(Coordinate c);
    
    /**
     * Distance in meters to the vertex
     */
    public double distance(Vertex v);

    /**
     * Fast, slightly approximated, under-estimated distance in meters to the vertex
     */
    public double fastDistance(Vertex v);
    
    /**
     * @return The location of the vertex in longitude/latitude
     */
    public Coordinate getCoordinate();

    public String toString();

    public double getX();

    public double getY();

    public String getName();

    public void setDistanceToNearestTransitStop(double distance);

    public double getDistanceToNearestTransitStop();
}