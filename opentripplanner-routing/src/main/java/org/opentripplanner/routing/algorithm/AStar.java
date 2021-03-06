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

package org.opentripplanner.routing.algorithm;

import org.opentripplanner.routing.core.Graph;
import org.opentripplanner.routing.core.State;
import org.opentripplanner.routing.core.TraverseOptions;
import org.opentripplanner.routing.core.Vertex;
import org.opentripplanner.routing.spt.ShortestPathTree;

/**
 * Find the shortest path between graph vertices using A*.
 */
public class AStar {

    private static final GenericAStar _instance = new GenericAStar();

    public static GenericAStar getDefaultInstance() {
        return _instance;
    }

    /**
     * Plots a path on graph from origin to target, either DEPARTING or ARRIVING at the given time
     * depending on the TraverseOptions (use TraverseOptions.setArriveBy).
     * 
     * @param graph
     * @param origin
     * @param target
     * @param init
     * @param options
     * @return the shortest path, or null if none is found
     */
    public static ShortestPathTree getShortestPathTree(Graph graph, String from_label,
            String to_label, long time, TraverseOptions options) {

        // Get origin vertex to make sure it exists
        Vertex origin = graph.getVertex(from_label);
        Vertex target = graph.getVertex(to_label);

        return getShortestPathTree(graph, origin, target, time, options);
    }

    /**
     * Plots a path on graph from origin to target, either DEPARTING or ARRIVING at the given time
     * depending on the TraverseOptions (use TraverseOptions.setArriveBy).
     * 
     * @param graph
     * @param origin
     * @param target
     * @param init
     * @param options
     * @return the shortest path, or null if none is found
     */
    public static ShortestPathTree getShortestPathTree(Graph graph, Vertex origin, Vertex target,
            long time, TraverseOptions options) {

        State s0;
        if (options.isArriveBy()) {
            s0 = new State(time, target, options);
            target = origin;
        } else {
            s0 = new State(time, origin, options);
        }

        return _instance.getShortestPathTree(graph, s0, target);
    }
}
